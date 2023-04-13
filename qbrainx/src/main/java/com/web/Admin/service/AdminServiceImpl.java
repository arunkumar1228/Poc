package com.web.admin.service;

import com.web.admin.dto.AdminDto;

import com.web.admin.entity.AdminEntity;
import com.web.admin.repository.AdminRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;

    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Override
    public List<AdminDto> getAllList() {
        List<AdminEntity> adminEntities = adminRepository.findAll();
        return adminEntities.stream().map(allList -> dozerBeanMapper.map(allList, AdminDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public String createAdmin(AdminDto adminDto) throws IOException {
        AdminEntity admin = dozerBeanMapper.map(adminDto, AdminEntity.class);

        adminRepository.save(admin);
        return "Ok";
    }

    @Override
    public String deleteExistingAdmin(Long id) throws IOException {
        try {
            adminRepository.deleteById(id);
            return "Deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateAdminDetails(Long id, AdminDto adminDto) throws IOException {
        Optional<AdminEntity> adminEntity = adminRepository.findById(id);
        if (adminEntity.isPresent()) {
            AdminEntity admin = dozerBeanMapper.map(adminDto, AdminEntity.class);
            adminRepository.save(admin);
            return "Updated Successfully";
        }
        return "Not Updated Admin details";
    }

    @Override
    public AdminDto getAdminById(Long id) throws IOException {
        AdminEntity admin = adminRepository.findById(id).orElseThrow(RuntimeException::new);
        return dozerBeanMapper.map(admin, AdminDto.class);

    }

    public String login(String username, String password) throws AuthenticationException {
        Optional<AdminEntity> optionalUser = adminRepository.findByUsername(username);
        AdminEntity adminDto = optionalUser.orElseThrow(() -> new AuthenticationException("Admin not found"));
        if (!adminDto.getPassword().equals(password)) {
            throw new AuthenticationException("Invalid username or password");
        }
        return "login successfully";
    }


}
