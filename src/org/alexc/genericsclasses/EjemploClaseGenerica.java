package org.alexc.genericsclasses;

public class EjemploClaseGenerica {

    public static void main(String[] args) {
        Camion<Animal> transpCaballo = new Camion<>(5);
        transpCaballo.addObjeto(new Animal("Spirit", "Caballo"));
        transpCaballo.addObjeto(new Animal("Lucho", "Caballo"));
        transpCaballo.addObjeto(new Animal("Paco", "Caballo"));
        transpCaballo.addObjeto(new Animal("Luz", "Caballo"));
        transpCaballo.addObjeto(new Animal("Paz", "Caballo"));

//        for (Animal obj: transpCaballo){
////            Animal anm = (Animal) obj; ya no es necesario el cast
//            System.out.println(obj.getNombre() + " tipo "+ obj.getTipo());
//        }
        imprimirCamion2(transpCaballo);

        Camion<Maquinaria> transMaquina = new Camion<>(3);
        transMaquina.addObjeto(new Maquinaria("Bulldozer"));
        transMaquina.addObjeto(new Maquinaria("Grua"));
        transMaquina.addObjeto(new Maquinaria("Perforadora"));
//        for (Maquinaria mq : transMaquina){
////            Maquinaria maq = (Maquinaria)mq;
//            System.out.println(mq.getTipo());
//        }
        imprimirCamion2(transMaquina);

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.addObjeto(new Automovil("Toyota"));
        transAuto.addObjeto(new Automovil("Mazda"));
        transAuto.addObjeto(new Automovil("Chevrolet"));
//        for (Automovil aut : transAuto){
////            Maquinaria maq = (Maquinaria)obj;
//            System.out.println(aut.getMarca());
//        }
        imprimirCamion2(transAuto);

    }

    public static <T> void imprimirCamion(Camion<T> camion){
        for (T objGen: camion){
            if(objGen instanceof Animal){
                Animal anm = (Animal) objGen;
                System.out.println(anm.getNombre() + " tipo "+ anm.getTipo());
            }else if(objGen instanceof Automovil){
                System.out.println(((Automovil)objGen).getMarca());
            }else if(objGen instanceof Maquinaria){
                System.out.println(((Maquinaria)objGen).getTipo());
            }
        }
    }

    //mejorando usando una interfaz para no estar con ifs de instance of
    public static <T extends TransportableporCamion > void imprimirCamion2(Camion<T> camion){
        for (T obj: camion){
            obj.imprimir();
        }
    }
}
