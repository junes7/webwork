package dept;

import java.util.ArrayList;

public interface DeptDAO {
	public int insert(DeptDTO dept);
	public ArrayList<DeptDTO> getDeptList();
	public int delete(String deptno);
}
