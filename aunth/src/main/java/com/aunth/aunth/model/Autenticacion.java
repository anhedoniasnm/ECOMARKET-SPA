package com.aunth.aunth.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "auntenticacion")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autenticacion {

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String contrasenha;

}
