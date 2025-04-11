package com.Integracion.Biblioteca.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sergio")
public class TestControllerSergio {
    

public class TestController {

    @GetMapping
    public String test() {
        return "Rama de sergio";
    }

}

}
