package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
