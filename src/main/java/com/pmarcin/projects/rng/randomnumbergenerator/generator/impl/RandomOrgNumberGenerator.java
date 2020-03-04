package com.pmarcin.projects.rng.randomnumbergenerator.generator.impl;

import com.pmarcin.projects.rng.randomnumbergenerator.generator.interfaces.RandomNumberGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;

@Component
public class RandomOrgNumberGenerator implements RandomNumberGenerator {

    private static final String GET_RANDOM_NUMBER_RANDOM_ORG_REST_API =
            "https://www.random.org/integers/?num=1&min=-1000000000&max=1000000000&col=1&base=10&format=plain&rnd=new";

    @Override
    public BigInteger generate() {
        return getNumberFromRandomOrg();
    }

    private BigInteger getNumberFromRandomOrg() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(
                GET_RANDOM_NUMBER_RANDOM_ORG_REST_API, String.class);

        if (!HttpStatus.OK.equals(responseEntity.getStatusCode())) {
            System.err.println("Something went wrong with connection... "
                    + "(Status code: " + responseEntity.getStatusCode() + ")");
            return null;
        }

        String responseBody = responseEntity.getBody();

        if (StringUtils.isEmpty(responseBody)) {
            System.err.println("Something went wrong with obtaining random number... (Empty response)");
            return null;
        }

        return new BigInteger(responseBody.trim());
    }

}
