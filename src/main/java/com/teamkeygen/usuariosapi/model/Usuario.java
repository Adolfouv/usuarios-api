package com.teamkeygen.usuariosapi.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


import java.util.HashSet;
import java.util.Set;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @NotBlank(message = "El correo no puede estar vacío")
    @Email(message = "El formato del correo electrónico es inválido")
    private String correo;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String contraseña;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Telefono> telefonos = new HashSet<>();


    //Constructores, getters y setters
    public Usuario() {
    }

    public Usuario(Long id, String nombre, String correo, String contraseña, Set<Telefono> telefonos) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.contraseña = contraseña;
        this.telefonos = telefonos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }
}
