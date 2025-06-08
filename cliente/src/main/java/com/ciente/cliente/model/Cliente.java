package com.ciente.cliente.model;

import org.hibernate.mapping.Join;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombreCliente;  

    @Column(nullable = false)
    private String telefonoCliente;

    @Column(nullable = false)
    private String direccionCliente;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String contrasenha;


    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos;

}
