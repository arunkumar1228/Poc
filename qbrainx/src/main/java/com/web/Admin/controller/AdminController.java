package com.web.Admin.controller;

import com.web.Admin.dto.AdminDto;
import com.web.Admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1/admin")
public class AdminController {


    @Autowired
   AdminService adminService;
     public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/getAllAdmin")
    public ResponseEntity<List<AdminDto>> allTextList() {
        List<AdminDto> list = adminService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/AdminLogin")
    public String login(@RequestParam String username, @RequestParam String password) throws AuthenticationException {
        return adminService.login(username, password);
    }

    @PostMapping("/createAdmin" )
    public ResponseEntity<String> uploadImage(@RequestBody AdminDto adminDto) throws IOException {
        return new ResponseEntity<>(adminService.createAdmin(adminDto), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAdminById")
    public String deleteTextById(@RequestParam Long id) throws IOException {
        return adminService.deleteExistingAdmin(id);
    }

    @GetMapping("/getAdminById")
    public AdminDto getText(@RequestParam Long id) throws IOException {
        return adminService.getAdminById(id);
    }

    @PutMapping(value = "/updateAdminDetailsById")
    public ResponseEntity<String> uploadImage(@RequestParam Long id,AdminDto adminDto) throws IOException {
        return new ResponseEntity<>(adminService.updateAdminDetails(id, adminDto ), HttpStatus.OK);
    }






}

