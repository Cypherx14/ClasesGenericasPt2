package org.alexc.poointerfaces.repositorio;

import org.alexc.poointerfaces.modelo.Cliente;
import org.alexc.poointerfaces.modelo.EntidadBase;

import java.util.ArrayList;
import java.util.List;


//reutilizar mas esta clase
public abstract class AbstractListRepositorio<T extends EntidadBase> implements OrdenablePaginableCrudRepositorio<T> {

    protected List<T> datasource;

    public AbstractListRepositorio() {
        this.datasource = new ArrayList<>();
    }

    @Override
    public List<T> listar() {
        return this.datasource;
    }

    //reutilizando porId con generico
    //al inicio no va a reconocer el getId, creamos una clase "Modelo" que tenga el Id
    @Override
    public T porId(Integer id) {
        T c = null;
        for (T cl : this.datasource){
            if(cl.getId().equals(id)){
                c = cl;
                break;
            }
        }
        return c;
    }

    @Override
    public void crear(T t) {
        this.datasource.add(t);
    }

    @Override
    public void eliminar(Integer id) {
        this.datasource.remove(this.porId(id));
    }

    //Paginable
    @Override
    public List<T> listar(int desde, int hasta) {
        return datasource.subList(desde, hasta);
    }

    @Override
    public int total() {
        return this.datasource.size();
    }
}
