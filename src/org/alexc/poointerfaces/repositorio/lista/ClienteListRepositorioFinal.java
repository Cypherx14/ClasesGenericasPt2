package org.alexc.poointerfaces.repositorio.lista;

import org.alexc.poointerfaces.modelo.Cliente;
import org.alexc.poointerfaces.repositorio.AbstractListRepositorio;
import org.alexc.poointerfaces.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;


//reutilizar mas esta clase
public class ClienteListRepositorioFinal extends AbstractListRepositorio<Cliente> {

    /* ya no es necesario ya esta en la clase padre
    @Override
    public Cliente porId(Integer id) {
        Cliente c = null;
        for (Cliente cl : this.datasource){
            if(cl.getId().equals(id)){
                c = cl;
                break;
            }
        }
        return c;
    }
*/
    @Override
    public void editar(Cliente cliente) {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido());
    }

    //Ordenable usando expresion lambda, que es mejor !

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.datasource);
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


    //metodos de la clase

    public static int ordenar(String campo,Cliente a, Cliente b){
        int resultadoComparador =0;
        switch (campo){
            case "id" ->
                    resultadoComparador = a.getId().compareTo(b.getId());
            case "nombre" ->
                    resultadoComparador = a.getNombre().compareTo(b.getNombre());
            case "apellido" ->
                    resultadoComparador = a.getApellido().compareTo(b.getApellido());
        }
        return resultadoComparador;
    }
}
