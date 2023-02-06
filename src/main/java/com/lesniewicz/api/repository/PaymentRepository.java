package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Payment;
import com.lesniewicz.api.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
    interface StoreRepository extends JpaRepository<Store, Integer> {
    }
}
