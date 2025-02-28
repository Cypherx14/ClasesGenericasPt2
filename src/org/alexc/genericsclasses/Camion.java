package org.alexc.genericsclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//public class Camion implements Iterable {
public class Camion<T> implements Iterable<T>{
    private List<T> objetos;
    private int maximoObjetos;


    public Camion(int maximoObjetos) {
        this.maximoObjetos = maximoObjetos;
        this.objetos = new ArrayList<>();
    }


    public void addObjeto(T obj){
        if (this.objetos.size() < this.maximoObjetos){
            this.objetos.add(obj);
        }else {
            throw new RuntimeException("No hay mas espacio...");
        }
    }


    @Override
    public Iterator<T> iterator() {
        return this.objetos.iterator();
    }
}
