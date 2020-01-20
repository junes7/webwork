package member;
public class MemberDTO {
	//클래스 멤버변수 선언
	private String id; 
	private String pass;
	private String name;	
	private String addr;
	private String deptno; 
	private String grade;
	private int point; 
		
	//기본 생성자 생성
	public MemberDTO() {
		
	}
	
	//클래스 매개변수를 받는 생성자 생성
	public MemberDTO(String id, String pass, String name, String addr, String deptno, String grade, int point) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.addr = addr;
		this.deptno = deptno;
		this.grade = grade;
		this.point = point;
	}
	
	//클래스 멤버변수 값 toString으로 출력
	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", addr=" + addr + ", deptno=" + deptno
				+ ", grade=" + grade + ", point=" + point + "]";
	}
	
	//getter/setter생성
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}	
	
}
