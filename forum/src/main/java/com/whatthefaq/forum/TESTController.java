package com.whatthefaq.forum;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class TESTController {

    public TESTService testService;
    public TESTController(TESTService testService) {
        this.testService = testService;
    }

   
}
