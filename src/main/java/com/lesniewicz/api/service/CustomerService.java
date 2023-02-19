package com.lesniewicz.api.service;

import com.lesniewicz.api.dto.CustomerResponse;
import com.lesniewicz.api.mapper.ExperimentMapper;
import com.lesniewicz.api.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final ExperimentMapper experimentMapper;

    @Transactional
    public List<CustomerResponse> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(experimentMapper::mapToCustomerDto)
                .toList();
    }
}
