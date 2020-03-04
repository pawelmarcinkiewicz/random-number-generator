package com.pmarcin.projects.rng.randomnumbergenerator.services;

import com.pmarcin.projects.rng.randomnumbergenerator.generator.interfaces.RandomNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class GeneratorService {

    @Autowired
    @Qualifier("randomOrgAndDatabaseNumberGenerator")
    private RandomNumberGenerator randomNumberGenerator;

    public BigInteger generateNumber() {
        return randomNumberGenerator.generate();
    }

}
