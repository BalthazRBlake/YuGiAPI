package org.dev.fhhf.YuGi.repo;

import org.dev.fhhf.YuGi.model.StandardDeck;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StandardDeckRepo extends JpaRepository<StandardDeck, Long> {
    Optional<StandardDeck> findById(long id);
}
