package com.pmarcin.projects.rng.randomnumbergenerator.generator.interfaces;

import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public interface RandomNumberGenerator {

    BigInteger generate();

}
