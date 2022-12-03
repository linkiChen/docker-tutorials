package com.docker.department.service.impl;

import com.docker.department.entities.Department;
import com.docker.department.mappers.DepartmentMapper;
import com.docker.department.resp.DeptDTO;
import com.docker.department.service.IDepartmentService;
import com.docker.employee.feign.EmployeeFeignClient;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class DepartmentServiceImpl implements IDepartmentService {

    private final DepartmentMapper baseMapper;
    private final EmployeeFeignClient employeeFeignClient;

    public DepartmentServiceImpl(DepartmentMapper baseMapper, EmployeeFeignClient feignClient) {
        this.baseMapper = baseMapper;
        this.employeeFeignClient = feignClient;
    }

    @Override
    public DeptDTO selectById(Integer id) {
        Department department = this.baseMapper.selectByPrimaryKey(id);
        if (department == null) {
            return null;
        }
        DeptDTO dto = new DeptDTO();
        BeanUtils.copyProperties(department, dto);
        Integer empNumbers = employeeFeignClient.employeeCountByDept(department.getId());
        dto.setEmployeesNumbers(empNumbers);
        return dto;
    }
}
