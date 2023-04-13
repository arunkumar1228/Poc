package com.web.admin.service;


import com.web.admin.dto.AdminDto;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.List;

@Service
public interface AdminService {



    List<AdminDto> getAllList();

    String createAdmin(AdminDto adminDto) throws IOException;

    String deleteExistingAdmin(Long id) throws IOException;

    String updateAdminDetails(Long id,AdminDto adminDto) throws IOException;
    AdminDto  getAdminById(Long id) throws IOException;


    String login(String username, String password) throws AuthenticationException;

}
