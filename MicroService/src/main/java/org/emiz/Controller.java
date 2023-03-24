package org.emiz;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/ms")
public class Controller {

    @GetMapping("")
    public String getRoot(){
        return "root";
    }

    @GetMapping("/endpoint")
    @CircuitBreaker(name = "resilientService", fallbackMethod = "fallbackEndpoint")
    public String endpoint(){
//        If this call failed the fallback method will be called for now it will not fail
        return "endpoint";
    }

    public String fallbackEndpoint(Exception e){
        return "endpoint-fallback";
    }
}
