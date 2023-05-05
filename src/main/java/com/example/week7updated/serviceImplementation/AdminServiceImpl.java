package com.example.week7updated.serviceImplementation;

import com.example.week7updated.dto.AdminDTO;
import com.example.week7updated.model.Admin;
import com.example.week7updated.repository.AdminRepository;
import com.example.week7updated.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @Service
    public class AdminServiceImpl implements AdminService {
        private AdminRepository adminRepository;

        @Autowired
        public AdminServiceImpl(AdminRepository adminRepository) {
            this.adminRepository = adminRepository;
        }
        @Override
        public Admin authenticate(AdminDTO adminDTO) {
            Admin admin = adminRepository.findByEmail(adminDTO.getEmail()).get();
            if(admin.getEmail().equals("ebus@gmail.com") && admin.getPassword().equals("1234")) {
                return admin;
            }
            return null;
        }
    }

