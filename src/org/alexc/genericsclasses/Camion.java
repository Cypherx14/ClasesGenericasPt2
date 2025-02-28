package org.alexc.genericsclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//public class Camion implements Iterable {
public class Camion implements Iterable {
    private List objetos;
    private int maximoObjetos;


    public Camion(int maximoObjetos) {
        this.maximoObjetos = maximoObjetos;
        this.objetos = new ArrayList();
    }


    public void addObjeto(Object obj){
        if (this.objetos.size() < this.maximoObjetos){
            this.objetos.add(obj);
        }else {
            throw new RuntimeException("No hay mas espacio...");
        }
    }


    @Override
    public Iterator iterator() {
        return this.objetos.iterator();
    }
}
