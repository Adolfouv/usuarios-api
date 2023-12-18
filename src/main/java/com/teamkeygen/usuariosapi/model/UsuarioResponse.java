package com.teamkeygen.usuariosapi.model;

public class UsuarioResponse {

    private Long id;
    private String creado;
    private String modificado;
    private String ultimoLogin;
    private boolean activo;
    private String token;

    public UsuarioResponse() {
    }

    public UsuarioResponse(Long id, String creado, String modificado, String ultimoLogin, boolean activo, String token) {
        this.id = id;
        this.creado = creado;
        this.modificado = modificado;
        this.ultimoLogin = ultimoLogin;
        this.activo = activo;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreado() {
        return creado;
    }

    public void setCreado(String creado) {
        this.creado = creado;
    }

    public String getModificado() {
        return modificado;
    }

    public void setModificado(String modificado) {
        this.modificado = modificado;
    }

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
