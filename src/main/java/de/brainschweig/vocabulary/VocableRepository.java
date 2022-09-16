package de.brainschweig.vocabulary;

import org.springframework.data.repository.CrudRepository;

import de.brainschweig.vocabulary.entities.Vocable;

public interface VocableRepository extends CrudRepository<Vocable, Integer>{
    
}
