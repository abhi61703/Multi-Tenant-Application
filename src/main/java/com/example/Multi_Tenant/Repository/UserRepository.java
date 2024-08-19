package com.example.Multi_Tenant.Repository;

import com.example.Multi_Tenant.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByTenantId(String tenantId);
}
