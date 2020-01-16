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
		//1.��û��������
		int num1 = Integer.parseInt(request.getParameter("num1")); 
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String method = request.getParameter("method");
		//sysout���� ����ϱ�
		System.out.println("num1=>"+num1);
		System.out.println("num2=>"+num2);
		System.out.println("method=>"+method);
		//2. �����Ͻ� �޼ҵ� ȣ��
		//������ �����Ͻ� ������ ���� �и��Ǿ� �־�� �Ѵ�.
		int result = 0;//������� ������ ����
		CalcLogic logic = new CalcLogic();
		result = logic.calc(num1, method, num2);
		//3. ����ȭ�� ����		
		//���䳻���� ����
		cal.print("<html>");
		cal.print("<body>");
		//�� �ΰ��� �����ص� �����ϴ�.
		cal.print("<h1>�������</h1>");
		cal.print("<h3>num1�� "+num1+"�� num2�� "+num2+"�� ������ �����"
				+result+"�Դϴ�.</h3>");
		cal.print("</body>");
		cal.print("</html>");
	}
}
