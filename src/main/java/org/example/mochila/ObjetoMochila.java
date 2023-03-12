package org.example.mochila;

public class ObjetoMochila {

    String nombreObjeto;
    double pesoObjeto;

    public ObjetoMochila(String nombreObjeto, double pesoObjeto) {
        this.nombreObjeto = nombreObjeto;
        this.pesoObjeto = pesoObjeto;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public double getPesoObjeto() {
        return pesoObjeto;
    }

    public void setPesoObjeto(int pesoObjeto) {
        this.pesoObjeto = pesoObjeto;
    }
}
