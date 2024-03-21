
package fp.tipos.test;

import fp.tipos.Fecha;

public class TestFecha {
	
	public static void main(String[] args) {
		
		//"of"
        Fecha fecha1 = Fecha.of(2024, 2, 3);
        Fecha fecha2 = Fecha.of(2023, 12, 20);
        
        //"parse"
        Fecha fecha3 = Fecha.parse("2024-02-03");
        Fecha fecha4 = Fecha.parse("2023-07-17");
        
        //Métodos factoría
        System.out.println("Test métodos de factoría \"of\" y \"parse\": ");
        System.out.println("Fecha 1: " + fecha1);
        System.out.println("Fecha 2: " + fecha2);
        System.out.println("Fecha 3: " + fecha3);
        System.out.println("Fecha 4: " + fecha4);
        
        //Criterio igualdad
        System.out.println("\nTest criterio igualdad: ");
        System.out.println("¿Son iguales las fechas 1 y 4? -> " + fecha1.equals(fecha4));
        System.out.println("¿Son iguales las fechas 3 y 1? -> " + fecha3.equals(fecha1));
        System.out.println("¿Son iguales las fechas 2 y 3? -> " + fecha2.equals(fecha3));
        System.out.println("¿Son iguales las fechas 4 y 2? -> " + fecha4.equals(fecha2));
        
        //Sumar días
        System.out.println("\nTest sumar días: ");
        System.out.println("Sumar 23 días a la fecha 1: " + fecha1.sumarDias(23));
        System.out.println("Sumar 15 días a la fecha 2: " + fecha2.sumarDias(15)); // salta al siguiente mes (y al siguiente año también en este caso) correctamente
        System.out.println("Sumar 32 días a la fecha 3: " + fecha3.sumarDias(32)); // salta al siguiente mes correctamente
        System.out.println("Sumar 9 días a la fecha 4: " + fecha4.sumarDias(9));
        
        //Restar días
        System.out.println("\nTest restar días: ");
        System.out.println("Restar 15 días a la fecha 1: " + fecha1.restarDias(15)); //pasa al mes anterior correctamente
        System.out.println("Restar 8 días a la fecha 2: " + fecha2.restarDias(8));
        System.out.println("Restar 103 días a la fecha 3: " + fecha3.restarDias(103)); //pasa al año anterior al quitar tantos días correctamente
        System.out.println("Restar 46 días a la fecha 4: " + fecha4.restarDias(46));
        
        //Diferencia en días
        System.out.println("\nTest diferencia en días: ");
        System.out.println("Número de días entre la fecha 2 y la fecha 4: " + fecha2.diferenciaDias(fecha4));
        System.out.println("Número de días entre la fecha 1 y la fecha 3: " + fecha1.diferenciaDias(fecha3)); //da 0 porque efectivamente se cumple el criterio de igualdad
        
        //Año bisiesto
        System.out.println("\nTest año bisiesto: ");
        System.out.println("¿El año " + fecha1.año() + " es bisiesto?: " + Fecha.esAñoBisiesto(fecha1.año()));
        System.out.println("¿El año " + fecha2.año() + " es bisiesto?: " + Fecha.esAñoBisiesto(fecha2.año()));
        System.out.println("¿El año " + fecha3.año() + " es bisiesto?: " + Fecha.esAñoBisiesto(fecha3.año()));
        System.out.println("¿El año " + fecha4.año() + " es bisiesto?: " + Fecha.esAñoBisiesto(fecha4.año()));

        //Días en mes de una fecha
        System.out.println("\nTest días en el mes de una fecha: ");
        System.out.println("Número de días en el mes de febrero del año " + fecha1.año() + ": " + Fecha.numeroDiasMes(fecha1.año(), fecha1.mes()));
        System.out.println("Número de días en el mes de diciembre del año " + fecha2.año() + ": " + Fecha.numeroDiasMes(fecha2.año(), fecha2.mes()));
        System.out.println("Número de días en el mes de febrero del año " + fecha3.año() + ": " + Fecha.numeroDiasMes(fecha3.año(), fecha3.mes()));
        System.out.println("Número de días en el mes de julio del año " + fecha4.año() + ": " + Fecha.numeroDiasMes(fecha4.año(), fecha4.mes()));

        //Congruencia de Zeller
        System.out.println("\nTest congruencia de Zeller: ");
        System.out.println("Para la congruencia de Zeller, los días de la semana llevan el siguiente orden: 1=Domingo, 2=Lunes,..., 7=Sábado.");
        System.out.println("Congruencia de Zeller para la fecha 1: " + Fecha.congruenciaZ(fecha1.año(), fecha1.mes(), fecha1.dia()));
        System.out.println("Congruencia de Zeller para la fecha 2: " + Fecha.congruenciaZ(fecha2.año(), fecha2.mes(), fecha2.dia()));
        System.out.println("Congruencia de Zeller para la fecha 3: " + Fecha.congruenciaZ(fecha3.año(), fecha3.mes(), fecha3.dia()));
        System.out.println("Congruencia de Zeller para la fecha 4: " + Fecha.congruenciaZ(fecha4.año(), fecha4.mes(), fecha4.dia()));
    }
}
