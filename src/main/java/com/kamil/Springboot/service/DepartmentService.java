package com.kamil.Springboot.service;

import com.kamil.Springboot.entity.Department;
import com.kamil.Springboot.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
   public static Department updateDepartment(Long departmentId, Department department) {
       return department;
   }

   public  static Department fetchDepartmentByName(String departmentName) {

       return null;
   }

//    static Department fetchDepartmentByName(String departmentName) {
//    }

    public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

   public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);
}
