package com.docker.department.resp;

import java.io.Serializable;


public class DeptDTO implements Serializable {

    private Integer id;

    private String deptName;

    private String deptCode;

    private Integer employeesNumbers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public Integer getEmployeesNumbers() {
        return employeesNumbers;
    }

    public void setEmployeesNumbers(Integer employeesNumbers) {
        this.employeesNumbers = employeesNumbers;
    }
}
