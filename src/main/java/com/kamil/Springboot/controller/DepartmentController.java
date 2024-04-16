package com.kamil.Springboot.controller;

import com.kamil.Springboot.entity.Department;
import com.kamil.Springboot.error.DepartmentNotFoundException;
import com.kamil.Springboot.service.DepartmentService;
import com.kamil.Springboot.service.DepartmentServiceImpl;
import jakarta.validation.Valid;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentservice;
//    This is simple logger implementation
private final Logger LOGGER =
        (Logger) LoggerFactory.getLogger(DepartmentController.class);
@PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
    DepartmentService service = new DepartmentServiceImpl();
    LOGGER.info("Inside saveDepartment of Department Controller");
       return departmentservice.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of Department Controller");
       return departmentservice.fetchDepartmentList();
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentId(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
       return departmentservice.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
     departmentservice.deleteDepartmentById(departmentId);
     return "Department Deleted Succesfully !! ";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,
                                       @RequestBody Department department){
      return DepartmentService.updateDepartment(departmentId,department);
    }

//    fetch data by name
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
      return DepartmentService.fetchDepartmentByName(departmentName);
    }

}

