package org.example.session09.services;

import org.example.session09.models.dtos.DepartmentDTO;
import org.example.session09.models.entities.Department;
import org.example.session09.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(DepartmentDTO dto) {
        Department department = Department.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .build();
        return departmentRepository.save(department);
    }
}