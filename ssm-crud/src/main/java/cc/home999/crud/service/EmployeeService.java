package cc.home999.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.crud.bean.Employee;
import cc.home999.crud.dao.EmployeeMapper;
import java.util.*;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	

	public List<Employee> getAll() {
		// TODO 自动生成的方法存根
		return employeeMapper.selectByExampleWithDept(null);
	}
	
}
