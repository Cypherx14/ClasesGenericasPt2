package org.alexc.poointerfaces.repositorio.lista;

import org.alexc.poointerfaces.modelo.Cliente;
import org.alexc.poointerfaces.modelo.Producto;
import org.alexc.poointerfaces.repositorio.AbstractListRepositorio;
import org.alexc.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstractListRepositorio<Producto> {


    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> listaOrdenada = new ArrayList<>(this.datasource);
        //usando clase anonima se puede crear un metodo
        listaOrdenada.sort((a, b) -> {
            int resultado = 0;
            if(dir == Direccion.ASC){
                resultado = ordenar(campo,a,b);
            }else if(dir == Direccion.DESC){
                resultado = ordenar(campo,b,a);
            }
            return resultado;
        });
        return listaOrdenada;
    }

    //metodos de clase
    public static int ordenar(String campo,Producto a, Producto b){
        int resultadoComparador =0;
        switch (campo){
            case "id" ->
                    resultadoComparador = a.getId().compareTo(b.getId());
            case "descripcion" ->
                    resultadoComparador = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" ->
//                    resultadoComparador = a.getPrecio().compareTo(b.getPrecio()); // como es primitivo no se puede con
            //compareTo
                    resultadoComparador = a.getPrecio().compareTo(b.getPrecio());  //cambiamos a Double y no double
        }
        return resultadoComparador;
    }
}
