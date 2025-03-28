package com.ebc.juegos.controller;

import com.ebc.juegos.dto.AdivinadorRespuesta;
import com.ebc.juegos.service.AdivinadorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adivina")
public class AdivinadorController {
    private final AdivinadorService adivinadorService;

    public AdivinadorController(AdivinadorService adivinadorService) {
        this.adivinadorService = adivinadorService;
    }

    @GetMapping("/hola")
    public String diHola() {
        return "¡Hola mundo Spring!";
    }

    @GetMapping
    public String otroHola() {
        return "¡Hola de nuevo! soy el default";
    }

    @GetMapping("/intento")
    public AdivinadorRespuesta adivinarNumero(@RequestParam int intento) {
        AdivinadorRespuesta respuesta = this.adivinadorService.adivinar(intento);
        return respuesta;
    }

}
