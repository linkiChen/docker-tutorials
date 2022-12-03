package com.docker.employee.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "EMPLOYEE-SERVICE")
public interface EmployeeFeignClient {

    @GetMapping(value = "employee/empCount/{deptId}")
    Integer employeeCountByDept(@PathVariable("deptId") Integer deptId);
}
