package com.example.springboot.app.model;


import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "employee")
public class Product {
    @Id
    private  long id;

    @Column(name = "surnombre")
    private  String apellido;

    @Column(name="firstname")
    private  String nombre;

    @Column(name="nacionalidad")
    private String nacio;

    @Column(name="idioma")
    private String lenguaje;

    @Column(name="aeropuerto")
    private String aero;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacio() {
        return nacio;
    }

    public void setNacio(String nacio) {
        this.nacio = nacio;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getAero() {
        return aero;
    }

    public void setAero(String aero) {
        this.aero = aero;
    }
}