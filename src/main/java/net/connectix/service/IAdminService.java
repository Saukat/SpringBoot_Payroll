package net.connectix.service;

import java.util.List;
import java.util.Optional;

import net.connectix.document.Admin;


public interface IAdminService {
     public Admin saveAdmin(Admin admin);
     public List<Admin> getAllAdmin();
     public Optional<Admin> getOneAdmin(String id);
     public boolean isPresent(String id);
     public void ResetPassword(Admin admin);
}
