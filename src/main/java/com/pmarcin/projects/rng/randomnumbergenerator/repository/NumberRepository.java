package com.pmarcin.projects.rng.randomnumbergenerator.repository;

import com.pmarcin.projects.rng.randomnumbergenerator.repository.entities.Number;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Integer> {

}
