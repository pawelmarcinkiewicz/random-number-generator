package com.pmarcin.projects.rng.randomnumbergenerator.controllers;

import com.pmarcin.projects.rng.randomnumbergenerator.services.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

@Controller
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/generateNumber")
    public ModelAndView generateNumber() {
        BigInteger generatedNumber = generatorService.generateNumber();

        ModelAndView modelAndView = new ModelAndView("generateNumber");
        modelAndView.addObject("generatedNumber", generatedNumber);

        return modelAndView;
    }

}
