package com.docker.employee.controller;

import com.docker.employee.resp.EmployeesDTO;
import com.docker.employee.service.IEmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeCtrl {

    private final IEmployeeService baseService;

    public EmployeeCtrl(IEmployeeService baseService) {
        this.baseService = baseService;
    }

    @GetMapping(value = "helloWorld")
    public String helloWorld() {
        return "hello from employee";
    }

    /**
     * 获取员工信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public EmployeesDTO getById(@PathVariable(value = "id") Integer id) {
        return this.baseService.selectById(id);
    }

    /**
     * 获取指定部门的员工数
     *
     * @param deptId
     * @return
     */
    @GetMapping(value = "empCount/{deptId}")
    public Integer employeeCountByDept(@PathVariable("deptId") Integer deptId) {
        return this.baseService.employeeCountByDept(deptId);
    }
}
