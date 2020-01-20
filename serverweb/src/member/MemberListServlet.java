package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dept.DeptDAO;
import dept.DeptDAOImpl;
import dept.DeptDTO;

@WebServlet(name = "member/list", urlPatterns = { "/member/list.do" })
public class MemberListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, 
		HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("euc-kr");//POST��Ŀ����� ������ �ȴ�.
		response.setContentType("text/html;charset=euc-kr");
		//1.��û��������
		System.out.println("����");
		//2.�����Ͻ��޼ҵ� ȣ��
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> memberlist = dao.getMemberList();
		//������ ����
		request.setAttribute("memberlist", memberlist);
		System.out.println("ListServlet����Ϸ�");	
		System.out.println("dao=>"+memberlist.size());
		//2. ��û������ 
		RequestDispatcher rd = 
			request.getRequestDispatcher("/member/list.jsp");
		rd.forward(request, response);
		
	}
}
