package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//나의 맵핑 정보를 아래와 같이 선언해준다.
@WebServlet(name = "mypost2", urlPatterns = { "/mypost2.do" })
//Web.xml에 선언해서 사용해야 되는 요소들을 대신해서 WebServlet에서
//사용자에게 필요한 내용들만 WebServlet에 선언하여 객체 안에서 사용한다.
public class PostFormServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		//위와 같이 설정하면 에러가 발생한다. 한글 encoding처리는 응답 받을 때 처리해 주어야 한다.
		//response.setContentType("test/html;charset=euc-kr");
		//위와같이 적으면 다운로드 하려고 한다.
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter pw = response.getWriter();
		//요청정보추출
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String gender = request.getParameter("gender");
		String job = request.getParameter("job");
		String[] item = request.getParameterValues("item");
		
		//응답내용을 생성
		pw.print("<html>");
		pw.print("<body>");
		pw.print("<h1>고객정보</h1>");
		pw.print("<h3>아이디:"+userId+"</h3>");
		pw.print("<h3>성명:"+userName+"</h3>");
		pw.print("<h3>Favorites</h3>");
		for (String data : item) {
			pw.print(data+" ");
		}
		pw.print("</body>");
		pw.print("</html>");
		
		//

		
		
		
	}

}
