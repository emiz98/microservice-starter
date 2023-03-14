package org.emiz;

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
    public String endpoint2(){
        return "endpoint";
    }
}
