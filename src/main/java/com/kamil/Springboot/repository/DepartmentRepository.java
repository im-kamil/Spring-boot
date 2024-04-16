package com.kamil.Springboot.repository;

import com.kamil.Springboot.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Object findByDepartmentNameIgnoreCase(String it);
}
