package 满汉楼.MHL.service;

import 满汉楼.MHL.dao.EmployeeDAO;
import 满汉楼.MHL.domain.Employee;

public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public Employee getEmployeeByIdAndPwd(String empId, String pwd) {
        Employee employee =
                employeeDAO.querySingle("select * from employee where empId = ? and pwd = md5(?)",
                        Employee.class, empId, pwd);
        return employee;
    }

}
