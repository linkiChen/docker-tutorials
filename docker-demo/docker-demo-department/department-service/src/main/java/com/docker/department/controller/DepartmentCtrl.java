package com.docker.department.controller;

import com.docker.department.resp.DeptDTO;
import com.docker.department.service.IDepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "dept")
public class DepartmentCtrl {


    private final IDepartmentService baseService;

    public DepartmentCtrl(IDepartmentService baseService) {
        this.baseService = baseService;
    }

    @GetMapping(value = "helloWorld")
    public String helloWorld() {
        return "hello from department";
    }

    /**
     * 根据主键获取部门信息
     *
     * @param id
     * @return
     */
    @GetMapping(value = "{id}")
    public DeptDTO getDeptById(@PathVariable(value = "id") Integer id) {
        return this.baseService.selectById(id);
    }
}
