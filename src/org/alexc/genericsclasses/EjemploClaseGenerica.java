package org.alexc.genericsclasses;

public class EjemploClaseGenerica {

    public static void main(String[] args) {
        Camion transpCaballo = new Camion(5);
        transpCaballo.addObjeto(new Animal("Spirit", "Caballo"));
        transpCaballo.addObjeto(new Animal("Lucho", "Caballo"));
        transpCaballo.addObjeto(new Animal("Paco", "Caballo"));
        transpCaballo.addObjeto(new Animal("Luz", "Caballo"));
        transpCaballo.addObjeto(new Animal("Paz", "Caballo"));

        for (Object obj: transpCaballo){
            Animal anm = (Animal) obj;
            System.out.println(anm.getNombre() + " tipo "+ anm.getTipo());
        }

        Camion transMaquina = new Camion(3);
        transMaquina.addObjeto(new Maquinaria("Bulldozer"));
        transMaquina.addObjeto(new Maquinaria("Grua"));
        transMaquina.addObjeto(new Maquinaria("Perforadora"));
        for (Object obj : transMaquina){
            Maquinaria maq = (Maquinaria)obj;
            System.out.println(maq.getTipo());
        }

        Camion transAuto = new Camion(3);
        transAuto.addObjeto(new Automovil("Toyota"));
        transAuto.addObjeto(new Automovil("Mazda"));
        transAuto.addObjeto(new Automovil("Chevrolet"));
        for (Object obj : transMaquina){
            Maquinaria maq = (Maquinaria)obj;
            System.out.println(maq.getTipo());
        }


    }
}
