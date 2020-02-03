package cc.home999.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cc.home999.crud.bean.Employee;
import cc.home999.crud.bean.EmployeeExample;
import cc.home999.crud.bean.EmployeeExample.Criteria;
import cc.home999.crud.dao.EmployeeMapper;
import java.util.*;

@Service
public class EmployeeService {

	@Autowired
	EmployeeMapper employeeMapper;
	

	public List<Employee> getAll() {
		return employeeMapper.selectByExampleWithDept(null);
	}


	/** 员工添加
	 * 
	 * @param employee
	 */
	public void saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
	}


	/**
	 * 检验用户名是否可用
	 * @param empName
	 * @return
	 */
	public boolean checkUser(String empName) {
		// TODO 自动生成的方法存根
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		return count==0;
	}


	/** 按照员工ID查询员工
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmp(Integer id) {
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
		// TODO 自动生成的方法存根
	}


	public void updateEmp(Employee employee) {
		// TODO 自动生成的方法存根
		employeeMapper.updateByPrimaryKeySelective(employee);
	}


	public void deleteEmp(Integer id) {
		// TODO 自动生成的方法存根
		employeeMapper.deleteByPrimaryKey(id);
	}


	public void deleteBatch(List<Integer> ids) {
		// TODO 自动生成的方法存根
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}
	
}
