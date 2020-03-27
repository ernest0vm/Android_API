package com.examen.ernestovaldez.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AvailableData {

    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("descripcion")
    @Expose
    private String descripcion;
    @SerializedName("peso")
    @Expose
    private Integer peso;
    @SerializedName("usadas")
    @Expose
    private Integer usadas;
    @SerializedName("disponibles")
    @Expose
    private Integer disponibles;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("activo")
    @Expose
    private Boolean activo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getUsadas() {
        return usadas;
    }

    public void setUsadas(Integer usadas) {
        this.usadas = usadas;
    }

    public Integer getDisponibles() {
        return disponibles;
    }

    public void setDisponibles(Integer disponibles) {
        this.disponibles = disponibles;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

}