package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostFormServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
		
		req.setCharacterEncoding("euc-kr");
		//한글 변환하는 방법 중 하나이다.
		String id = req.getParameter("userId");
		String name = req.getParameter("userName");
		String pass = req.getParameter("passwd");
		String gender = req.getParameter("gender");
		String job = req.getParameter("job");
		String favorites = req.getParameter("item");
		
		System.out.println("아이디:"+id);
		System.out.println("성명:"+name);
		System.out.println("패스워드:"+pass);
		System.out.println("성별"+gender);
		System.out.println("JOB:"+job);
		System.out.println("Favorites:"+favorites);
		
	}
}
