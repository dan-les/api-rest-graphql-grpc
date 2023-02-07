package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
