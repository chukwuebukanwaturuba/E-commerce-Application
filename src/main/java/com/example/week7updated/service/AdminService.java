package com.example.week7updated.service;

import com.example.week7updated.dto.AdminDTO;
import com.example.week7updated.model.Admin;

public interface AdminService {
    Admin authenticate(AdminDTO adminDTO);
}
