package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

interface StoreRepository extends JpaRepository<Store, Long> {
}