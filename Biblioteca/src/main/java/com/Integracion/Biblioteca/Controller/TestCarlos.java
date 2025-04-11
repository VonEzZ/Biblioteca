package Proyecto.Biblioteca.Biblioteca.src.main.java.com.Integracion.Biblioteca.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class TestCarlos {

    @GetMapping
    public String test() {
        return "Esta funcionando";
    }

}

