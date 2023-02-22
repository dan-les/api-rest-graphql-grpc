package com.lesniewicz.api.service;

import com.lesniewicz.api.entity.Actor;
import com.lesniewicz.api.exception.ApiExperimentException;
import com.lesniewicz.api.exception.Error;
import com.lesniewicz.api.repository.ActorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ActorService {
    private final ActorRepository actorRepository;

    private static Actor validateActor(Optional<Actor> actor) {
        return actor.orElseThrow(() -> new ApiExperimentException(Error.ACTOR_NOT_FOUND));
    }

    @Transactional
    public Set<Actor> retrieveActorsByIds(List<Long> actorsIds) {
        return actorsIds.stream()
                .map(actorRepository::findById)
                .map(ActorService::validateActor)
                .collect(Collectors.toSet());
    }
}
