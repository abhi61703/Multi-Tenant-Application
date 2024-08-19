package com.example.Multi_Tenant.Repository;

import com.example.Multi_Tenant.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
