package com.lesniewicz.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
public class Staff {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;

    @Column(nullable = false, length = 45)
    private String firstName;

    @Column(nullable = false, length = 45)
    private String lastName;

    @Column(columnDefinition = "longtext")
    private String picture;

    @Column(length = 50)
    private String email;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false, length = 16)
    private String username;

    @Column(length = 40)
    private String password;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "staff")
    private Set<Payment> staffPayments;

    @OneToMany(mappedBy = "staff")
    private Set<Rental> staffRentals;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "managerStaff")
    private Set<Store> managerStaffStores;

}
