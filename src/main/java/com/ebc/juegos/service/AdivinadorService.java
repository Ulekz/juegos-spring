package com.ebc.juegos.service;

import com.ebc.juegos.dto.AdivinadorRespuesta;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AdivinadorService {
    private int numeroSecreto;
    private final Random random = new Random();

    public AdivinadorService() {
        generarNuevoNumero();
    }

    /**
     * Esta Función va a crear un nuevo numero aleateario (entero entre 1 y 9)
     */
    private void generarNuevoNumero() {
        this.numeroSecreto = random.nextInt(10) +1;
    }

    public AdivinadorRespuesta adivinar(int intento) {
        String resultado = null;

        if (intento < this.numeroSecreto) {
            resultado = "Te quedaste muy por debajo";
        } else if (intento > this.numeroSecreto) {
            resultado = "Te pasaste!!!";
        } else{
            resultado = "Bien hecho muggle.. eres libre ahora.. quieres volver a jugar";
            generarNuevoNumero();
        }

        AdivinadorRespuesta adivinadorRespuesta = new AdivinadorRespuesta();
        adivinadorRespuesta.setNumero(intento);
        adivinadorRespuesta.setMensaje(resultado);

        return adivinadorRespuesta;
    }

}
