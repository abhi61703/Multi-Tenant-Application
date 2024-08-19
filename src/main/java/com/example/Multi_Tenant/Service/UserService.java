package com.example.Multi_Tenant.Service;

import com.example.Multi_Tenant.Entity.User;
import com.example.Multi_Tenant.Repository.UserRepository;
import com.example.Multi_Tenant.Tenant.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        String tenantId = TenantContext.getCurrentTenant(); // Get the tenant ID
        user.setTenantId(tenantId); // Ensure tenantId is set
        return userRepository.save(user);
    }
}
