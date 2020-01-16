package basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "calc", urlPatterns = { "/calc.do" })
public class CalcServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter cal = response.getWriter();
		//1.요청정보추출
		int num1 = Integer.parseInt(request.getParameter("num1")); 
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String method = request.getParameter("method");
		//sysout으로 출력하기
		System.out.println("num1=>"+num1);
		System.out.println("num2=>"+num2);
		System.out.println("method=>"+method);
		//2. 비지니스 메소드 호출
		//무조건 비지니스 로직은 따로 분리되어 있어야 한다.
		int result = 0;//계산결과를 저장할 변수
		CalcLogic logic = new CalcLogic();
		result = logic.calc(num1, method, num2);
		//3. 응답화면 생성		
		//응답내용을 생성
		cal.print("<html>");
		cal.print("<body>");
		//위 두개는 생략해도 무관하다.
		cal.print("<h1>계산정보</h1>");
		cal.print("<h3>num1의 "+num1+"과 num2의 "+num2+"을 연산한 결과는"
				+result+"입니다.</h3>");
		cal.print("</body>");
		cal.print("</html>");
	}
}
