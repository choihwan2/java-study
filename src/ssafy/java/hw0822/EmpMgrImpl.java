package ssafy.java.hw0822;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmpMgrImpl extends EmpDB implements EmpMgr {

	private static EmpMgrImpl instance = null;

	private EmpMgrImpl() {

	}

	public static EmpMgrImpl getInstance() {
		if (instance == null) {
			instance = new EmpMgrImpl();
		}
		return instance;
	}

	@Override
	public void add(Employee b) {
		String sql = "";
		try {
			Connection conn = connectSever();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
	}

	@Override
	public Employee search(int empNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(int empNo, String dept) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int empNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
