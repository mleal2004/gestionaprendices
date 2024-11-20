package com.gestionaprendices.modelo;

public class Aprendiz {
    private int idAprendiz;
    private String nombre;
    private String apellido;
    private String documentoIdentidad;
    private String correo;
    private String telefono;

    // Constructor
    public Aprendiz(int idAprendiz, String nombre, String apellido, String documentoIdentidad, String correo, String telefono) {
        this.idAprendiz = idAprendiz;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
        this.correo = correo;
        this.telefono = telefono;
    }

    // Getters y Setters
    public int getIdAprendiz() { return idAprendiz; }
    public void setIdAprendiz(int idAprendiz) { this.idAprendiz = idAprendiz; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getDocumentoIdentidad() { return documentoIdentidad; }
    public void setDocumentoIdentidad(String documentoIdentidad) { this.documentoIdentidad = documentoIdentidad; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
