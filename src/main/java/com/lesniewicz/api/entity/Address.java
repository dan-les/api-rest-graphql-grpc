package com.lesniewicz.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
public class Address {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @Column(nullable = false, length = 50)
    private String address;

    @Column(length = 50)
    private String address2;

    @Column(nullable = false, length = 20)
    private String district;

    @Column(length = 10)
    private String postalCode;

    @Column(nullable = false, length = 20)
    private String phone;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy = "address")
    private Set<Customer> addressCustomers;

    @OneToMany(mappedBy = "address")
    private Set<Staff> addressStaffs;

    @OneToMany(mappedBy = "address")
    private Set<Store> addressStores;

}
