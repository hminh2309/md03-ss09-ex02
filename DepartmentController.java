package org.example.session09.controllers;

import jakarta.validation.Valid;
import org.example.session09.models.dtos.DepartmentDTO;
import org.example.session09.models.entities.Department;
import org.example.session09.api.ApiResponse;
import org.example.session09.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Department>> createDepartment(@Valid @RequestBody DepartmentDTO departmentDTO) {
        Department savedDepartment = departmentService.createDepartment(departmentDTO);

        ApiResponse<Department> response = ApiResponse.<Department>builder()
                .status("SUCCESS")
                .message("Tạo phòng ban thành công")
                .data(savedDepartment)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}