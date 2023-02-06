package com.lesniewicz.api.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
public class Store {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storeId;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "store")
    private Set<Customer> storeCustomers;

    @OneToMany(mappedBy = "store")
    private Set<Inventory> storeInventorys;

    @OneToMany(mappedBy = "store")
    private Set<Staff> storeStaffs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private Staff managerStaff;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

}
