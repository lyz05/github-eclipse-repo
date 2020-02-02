package cc.home999.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cc.home999.crud.bean.Employee;
import cc.home999.crud.bean.Msg;
import cc.home999.crud.service.EmployeeService;

/**
 * 处理员工CRUD请求
 * @author congcong
 *
 */
@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeservice;
	
	/**
	 * 导入jackson包
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getEmpsWithJson(@RequestParam(value="pn",defaultValue="1") Integer pn) {
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeservice.getAll();
		//使用pageInfo包装查询后的结果，只需要pageInfo交给页面就行了
		//封装了详细 的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		return Msg.success().add("pageInfo",page);
	}
	/**
	 * 查询员工数据（分页查询）
	 * @return
	 */
	//@RequestMapping("/emps")
	public String getEmps(@RequestParam(value="pn",defaultValue="1") Integer pn,Model model) {
		//引入PageHelper分页插件
		//在查询之前只需要调用,传入页码，以及每页的大小
		PageHelper.startPage(pn, 5);
		List<Employee> emps = employeeservice.getAll();
		//使用pageInfo包装查询后的结果，只需要pageInfo交给页面就行了
		//封装了详细 的分页信息，包括有我们查询出来的数据,传入连续显示的页数
		PageInfo page = new PageInfo(emps,5);
		model.addAttribute("pageInfo",page);
		
		return "list";
	}
}
