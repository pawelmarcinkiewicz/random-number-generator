package com.pmarcin.projects.rng.randomnumbergenerator.generator.impl;

import com.pmarcin.projects.rng.randomnumbergenerator.generator.interfaces.RandomNumberGenerator;
import com.pmarcin.projects.rng.randomnumbergenerator.repository.entities.Number;
import com.pmarcin.projects.rng.randomnumbergenerator.repository.NumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.Optional;

@Component
public class DatabaseRandomNumberGenerator implements RandomNumberGenerator {

    @Autowired
    NumberRepository numberRepository;

    @Override
    public BigInteger generate() {
        return getRandomNumberFromDatabase();
    }

    private BigInteger getRandomNumberFromDatabase() {
        long count = numberRepository.count();
        int randomRecordId = (int) (Math.random() * (count - 1)) + 1;

        Optional<Number> numberOptional = numberRepository.findById(randomRecordId);

        if (numberOptional.isPresent()) {
            Number number = numberOptional.get();

            Integer value = number.getValue();
            if (value == null) {
                System.err.println("Record with id '" + randomRecordId
                        + "' has null value for field 'value' in database 'numbers'");
                return null;
            } else {
                return BigInteger.valueOf(value);
            }
        } else {
            System.err.println("Cannot find record with id '" + randomRecordId + "' in database 'numbers'");
            return null;
        }
    }
}
