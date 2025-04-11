package com.Integracion.Biblioteca.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AngController {

    @GetMapping
    public String test() {
        return "Biblioteca";
    }
}
