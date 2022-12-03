package com.docker.department.service;

import com.docker.department.resp.DeptDTO;

public interface IDepartmentService {

    DeptDTO selectById(Integer id);
}
