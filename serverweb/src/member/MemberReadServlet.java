package member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "member/read", urlPatterns = { "/member/read.do" })
public class MemberReadServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		response.setContentType("text/html;charset=euc-kr");
		//1.��û��������
		//-Ŭ���̾�Ʈ�� ���� ���±׿� �Է��� ������ �ʿ信 ���ؼ� �ѱ� �Ķ���� ����
		PrintWriter read = response.getWriter();
		System.out.println("����");
		String id = request.getParameter("id");
		//2.�����Ͻ��޼ҵ� ȣ��
		// -DeptDAOŬ������ �޼ҵ� �߰��ϰ� ȣ���ϱ�	
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.read(id);
		
		//3. jsp�� �Ѱ� �� ������ �����ϱ�
		request.setAttribute("member", member);
		System.out.println("ReadServlet����Ϸ�");	
		//4. ��û������ 
		//RequestDispatcherŬ������ request ���� Ŭ�����̴�.
		RequestDispatcher rd = 
			request.getRequestDispatcher("/member/member_read.jsp");
		rd.forward(request, response);	
	}
}
