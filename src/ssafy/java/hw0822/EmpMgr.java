package ssafy.java.hw0822;

import java.util.List;

public interface EmpMgr {
	void add(Employee b);

	Employee search(int empNo);

	List<Employee> search(String name);

	boolean update(int empNo, String dept);

	boolean delete(int empNo);
}
