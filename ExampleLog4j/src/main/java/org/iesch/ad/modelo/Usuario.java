package org.iesch.ad.modelo;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Usuario {
    private int id;
    private String nombre;
    private String email;
}
