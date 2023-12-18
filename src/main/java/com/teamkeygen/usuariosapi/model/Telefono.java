package com.teamkeygen.usuariosapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message = "El número no puede estar vacío")
    private String numero;

    @NotBlank(message = "El código de ciudad no puede estar vacío")
    private String codigoCiudad;

    @NotBlank(message = "El código de país no puede estar vacío")
    private String codigoPais;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    @JsonBackReference
    private Usuario usuario;


    //Constructores, getters y setters
    public Telefono() {
    }

    public Telefono(Long id, String numero, String codigoCiudad, String codigoPais, Usuario usuario) {
        this.id = id;
        this.numero = numero;
        this.codigoCiudad = codigoCiudad;
        this.codigoPais = codigoPais;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoCiudad() {
        return codigoCiudad;
    }

    public void setCodigoCiudad(String codigoCiudad) {
        this.codigoCiudad = codigoCiudad;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
