package com.docker.employee.service.impl;

import com.docker.department.feign.DeptFeignClient;
import com.docker.department.resp.DeptDTO;
import com.docker.employee.entities.Employees;
import com.docker.employee.mappers.EmployeesMapper;
import com.docker.employee.resp.EmployeesDTO;
import com.docker.employee.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    private final EmployeesMapper baseMapper;
    private final DeptFeignClient deptFeignClient;

    public EmployeeServiceImpl(EmployeesMapper baseMapper, DeptFeignClient deptFeignClient) {
        this.baseMapper = baseMapper;
        this.deptFeignClient = deptFeignClient;
    }

    @Override
    public EmployeesDTO selectById(Integer id) {
        Employees emp = this.baseMapper.selectByPrimaryKey(id);
        if (emp == null) {
            return null;
        }
        EmployeesDTO dto = new EmployeesDTO();
        BeanUtils.copyProperties(emp, dto);
        // 部门信息
        DeptDTO dept = deptFeignClient.getDeptById(emp.getDeptId());
        if (dept != null) {
            dto.setDeptName(dept.getDeptName());
        }
        return dto;
    }

    @Override
    public int employeeCountByDept(Integer deptId) {
        return this.baseMapper.countByDeptId(deptId);
    }


}
