package org.alexc.genericsclasses;

public class Automovil implements TransportableporCamion{
    private String marca;

    public Automovil(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }


    @Override
    public void imprimir() {
        System.out.println(this.getMarca());
    }
}
