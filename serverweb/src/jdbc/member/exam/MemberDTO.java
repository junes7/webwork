package jdbc.member.exam;

import java.sql.Date;

public class MemberDTO {	
	private String id;
	private String pass;
	private String name;
	private String addr;
	private String deptno;
	private Date hiredate;
	private int point;
	
	public MemberDTO() {
		
	}
	//insert용
	public MemberDTO(String id, String pass, String name, String addr, String deptno) {
		super();
		this.id=id;
		this.pass=pass;
		this.name=name;
		this.addr=addr;
		this.deptno=deptno;
	}
	//select용
	public MemberDTO(String id, String pass, String name, String addr, String deptno, Date hiredate, int point) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.deptno = deptno;
		this.hiredate = hiredate;
		this.point = point;
	}
	//값 확인 및 출력
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", deptno=" + deptno
				+ ", hiredate=" + hiredate + ", point=" + point + "]";
	}
	//getter/setter 생성
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
