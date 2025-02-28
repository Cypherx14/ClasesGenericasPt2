package org.alexc.genericsclasses;

public class Maquinaria implements TransportableporCamion{
    private String tipo;

    public Maquinaria(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public void imprimir() {
        System.out.println(this.getTipo());
    }
}
