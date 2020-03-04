package com.pmarcin.projects.rng.randomnumbergenerator.generator.impl;

import com.pmarcin.projects.rng.randomnumbergenerator.generator.interfaces.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class RandomOrgAndDatabaseNumberGenerator implements RandomNumberGenerator {

    @Autowired
    RandomOrgNumberGenerator randomOrgNumberGenerator;

    @Autowired
    DatabaseRandomNumberGenerator databaseRandomNumberGenerator;

    @Override
    public BigInteger generate() {
        BigInteger numberFromRandomOrg = randomOrgNumberGenerator.generate();
        if (numberFromRandomOrg == null) {
            return null;
        }

        BigInteger randomNumberFromDatabase = databaseRandomNumberGenerator.generate();
        if (randomNumberFromDatabase == null) {
            return null;
        }

        return numberFromRandomOrg.add(randomNumberFromDatabase);
    }

}
