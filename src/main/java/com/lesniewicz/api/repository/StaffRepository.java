package com.lesniewicz.api.repository;


import com.lesniewicz.api.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
