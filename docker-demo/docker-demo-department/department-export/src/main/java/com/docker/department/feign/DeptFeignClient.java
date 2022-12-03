package com.docker.department.feign;


import com.docker.department.resp.DeptDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "DEPARTMENT-SERVICE")
public interface DeptFeignClient {

    @GetMapping(value = "/dept/{id}")
    DeptDTO getDeptById(@PathVariable(value = "id") Integer id);
}
