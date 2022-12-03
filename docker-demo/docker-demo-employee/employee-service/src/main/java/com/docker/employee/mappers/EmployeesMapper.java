package com.docker.employee.mappers;

import com.docker.employee.entities.Employees;

public interface EmployeesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employees record);

    int insertSelective(Employees record);

    Employees selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employees record);

    int updateByPrimaryKey(Employees record);

    int countByDeptId(Integer deptId);
}