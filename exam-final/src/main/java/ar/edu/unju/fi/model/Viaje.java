package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import lombok.Data;
@Component
@Data
public class Viaje {

    private int id;
    private String tipo; // "corta", "media", "larga"private TipoViaje tipo;
    private boolean estado;

}
