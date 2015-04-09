package com.iteso.marco.sesion10.beans;

/**
 * Created by marco on 4/8/15.
 */
public class Tree
{
    String NID;
    String taxonomia;
    String plantado;
    String diametro;
    String altura;
    String valoracion;
    String latitud;
    String longitud;
    String jardin;
    String imagen;

    public Tree()
    {
        setNID("");
        setTaxonomia("");
        setPlantado("");
        setDiametro("");
        setAltura("");
        setValoracion("");
        setLatitud("");
        setLongitud("");
        setJardin("");
        setImagen("");
    }

    public String getNID() {
        return NID;
    }

    public void setNID(String NID) {
        this.NID = NID;
    }

    public String getTaxonomia() {
        return taxonomia;
    }

    public void setTaxonomia(String taxonomia) {
        this.taxonomia = taxonomia;
    }

    public String getPlantado() {
        return plantado;
    }

    public void setPlantado(String plantado) {
        this.plantado = plantado;
    }

    public String getDiametro() {
        return diametro;
    }

    public void setDiametro(String diametro) {
        this.diametro = diametro;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getJardin() {
        return jardin;
    }

    public void setJardin(String jardin) {
        this.jardin = jardin;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
