package dept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "dept/read", urlPatterns = { "/dept/read.do" })
public class ReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
	
		//1.��û��������
		//-Ŭ���̾�Ʈ�� ���� ���±׿� �Է��� ������ �ʿ信 ���ؼ� �ѱ� �Ķ���� ����
		//-�⺻������ ��� POST��Ŀ����� ����, GET����� ��� �����Ϸ��� 
		//server.xml�� ������ �����Ѵ�.
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=euc-kr");
		
		PrintWriter read = response.getWriter();
		System.out.println("����");
		String deptNo = request.getParameter("deptNo");
		String info = request.getParameter("info");
		System.out.println("�ѱ���������:"+info);
		//2.�����Ͻ��޼ҵ� ȣ��
		// -DeptDAOŬ������ �޼ҵ� �߰��ϰ� ȣ���ϱ�
		
		DeptDAO dao = new DeptDAOImpl();
		DeptDTO result = dao.read(deptNo);
		
		//3. jsp�� �Ѱ� �� ������ �����ϱ�
		request.setAttribute("dept", result);
		System.out.println("ReadServlet����Ϸ�");	
		//4. ��û������ 
		//RequestDispatcherŬ������ request ���� Ŭ�����̴�.
		RequestDispatcher rd = 
			request.getRequestDispatcher("/dept/dept_read.jsp");
		rd.forward(request, response);
	}
}
