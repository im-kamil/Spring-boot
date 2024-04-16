package com.kamil.Springboot.controller;

import com.kamil.Springboot.entity.Department;
import com.kamil.Springboot.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .DepartmentCode("Ahmedabad")
                .DepartmentAddress("IT-06")
                .DepartmentName("IT")
                .DepartmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception{
        Department inputDepartment = Department.builder()
                .DepartmentCode("Ahmedabad")
                .DepartmentName("IT-06")
                .DepartmentName("IT")
                .build();

        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

//        mockMvc.perform(post("/departments")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\n" +
//                                "\t\"departmentName\":\"IT\",\n" +
//                                "\t\"departmentAddress\":\"Ahmedabad\",\n" +
//                                "\t\"departmentCode\":\"IT-06\"\n" +
//                                "}"))
//                .andExpect(status().isOk());

    }

    @Test
    void fetchDepartmentId() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
                .thenReturn(department);

//        mockMvc.perform(get("/departments/1")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.departmentName").
//                        value(department.getDepartmentName()));
    }
}