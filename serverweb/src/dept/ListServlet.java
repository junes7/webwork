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


@WebServlet(name = "list", urlPatterns = { "/list.do" })
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("euc-kr");
	response.setContentType("text/html;charset=euc-kr");
	//1.��û��������
	PrintWriter list = response.getWriter();
	System.out.println("����");
	//2.�����Ͻ��޼ҵ� ȣ��
	DeptDAO dao = new DeptDAOImpl();
	ArrayList<DeptDTO> deptlist = dao.getDeptList();
	//������ ����
	request.setAttribute("deptlist", deptlist);
	System.out.println("ListServlet����Ϸ�");	
	//2. ��û������ 
	RequestDispatcher rd = request.getRequestDispatcher("/dept/list.jsp");
	rd.forward(request, response);
	
	//3.����޽��� ����
/*	list.print("<html>");
	list.print("<body>");
	//�� �ΰ��� �����ص� �����ϴ�.
	list.print("<h1 align='center'>�μ� ��� ���</h1>");
	list.print("<hr/>");
	list.print("<table border='1' align='center'>");
		list.print("<tr>");
		list.print("<th>�μ��ڵ�</th><th>�μ���</th><th>��ġ</th>");
		list.print("<th>��ȭ��ȣ</th><th>������</th><th>��������</th>");
		list.print("</tr>");
		
	for (int i = 0; i < size; i++) {
		DeptDTO dept = deptlist.get(i);
		list.print("<tr align='center'>");
		list.print("<td>"+dept.getDeptNo()+"</td>");
		list.print("<td>"+dept.getDeptName()+"</td>");
		list.print("<td>"+dept.getLoc()+"</td>");
		list.print("<td>"+dept.getTel()+"</td>");
		list.print("<td>"+dept.getMgr()+"</td>");
		list.print("<td><a href='/serverweb/delete.do?deptno="+dept.getDeptNo()+"&info=test' target='_blank'>����</a></td>");
		list.print("</tr>");		
	}
	list.print("</table>");
	list.print("</body>");
	list.print("</html>");	*/
	
	}
}
