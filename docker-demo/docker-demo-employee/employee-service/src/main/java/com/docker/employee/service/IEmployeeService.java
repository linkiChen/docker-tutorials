package com.docker.employee.service;

import com.docker.employee.resp.EmployeesDTO;

public interface IEmployeeService {

    EmployeesDTO selectById(Integer id);

    /**
     * 统计部门的员工数
     * @param deptId
     * @return
     */
    int employeeCountByDept(Integer deptId);
}
