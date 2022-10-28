package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Roles;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long>{

}
