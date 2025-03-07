package org.alexc.poointerfaces;

import org.alexc.poointerfaces.modelo.Cliente;
import org.alexc.poointerfaces.modelo.Producto;
import org.alexc.poointerfaces.repositorio.Direccion;
import org.alexc.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.alexc.poointerfaces.repositorio.lista.ClienteListRepositorioFinal;
import org.alexc.poointerfaces.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploRepositorioProducto {
    public static void main(String[] args) {
//        OrdenablePaginableCrudRepositorio repo = new AbstractListRepositorio();
        OrdenablePaginableCrudRepositorio<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("Leche en carton", 2.87));
        repo.crear(new Producto("Leche deslactosada", 1.7));
        repo.crear(new Producto("Leche de almendra", 12.9));
        repo.crear(new Producto("Leche pura", 50.14));
        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);
        System.out.println("Usando paginable");
        List<Producto> paginable = repo.listar(1,3); //al tener agrupadas todas las interfaces en una sola
        paginable.forEach(System.out::println);

        System.out.println("Ordenar ASC POR DESCRIPCION");
        List<Producto> productosASC = repo.listar("Descripcion", Direccion.ASC);
        productosASC.forEach(System.out::println);

        System.out.println("**********");

        Producto jugoNaranjaAct = new Producto("Jugo de naranja natural", 2.5);
        jugoNaranjaAct.setId(3);
        repo.editar(jugoNaranjaAct);
        Producto lechePura = repo.porId(3);
        System.out.println(lechePura);

        System.out.println("*****ORDENAR DESC POR PRECIO******");
        List<Producto> productosDESC = repo.listar("precio", Direccion.DESC);
        productosDESC.forEach(System.out::println);

        System.out.println("******TOTAL DE REGISTROS********");
        System.out.println(repo.total());

    }
}
