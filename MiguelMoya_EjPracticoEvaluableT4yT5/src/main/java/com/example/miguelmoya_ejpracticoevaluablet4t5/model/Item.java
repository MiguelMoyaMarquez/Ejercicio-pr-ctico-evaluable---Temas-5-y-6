package com.example.miguelmoya_ejpracticoevaluablet4t5.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

/**
 * Representa un item en la base de datos.
 */
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private float precio;
    private String categoria;
    private String descripcion;
    private float valoracion;
    private int ventas;
    private String urlaImage;


    /**
     * Constructor vacío de la clase Item.
     */
    public Item() {}

    /**
     * Obtiene el ID del item.
     *
     * @return ID del item.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del item.
     *
     * @param id ID del item.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del item.
     *
     * @return Nombre del item.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del item.
     *
     * @param nombre Nombre del item.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValoracion() {
        return valoracion;
    }

    public void setValoracion(float valoracion) {
        this.valoracion = valoracion;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public String getUrlaImage() {
        return urlaImage;
    }

    public void setUrlaImage(String urlaImage) {
        this.urlaImage = urlaImage;
    }
}
