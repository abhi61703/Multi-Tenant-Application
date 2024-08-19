package com.example.Multi_Tenant.Controller;

import com.example.Multi_Tenant.Entity.User;
import com.example.Multi_Tenant.Service.UserService;
import com.example.Multi_Tenant.Tenant.TenantContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tenants")
public class TenantController {

    @Autowired
    UserService userService;

    @PostMapping("/{tenantId}/users")
    public User addUserToTenant(@PathVariable String tenantId, @RequestBody User user) {
        TenantContext.setCurrentTenant(tenantId);
        User createdUser = userService.createUser(user.getUsername());
        TenantContext.clear();
        return createdUser;
    }

    @GetMapping("/{tenantId}/users")
    public List<User> getUsersForTenant(@PathVariable String tenantId) {
        TenantContext.setCurrentTenant(tenantId);
        List<User> users = userService.getUsersByTenant();
        TenantContext.clear();
        return users;
    }
}
