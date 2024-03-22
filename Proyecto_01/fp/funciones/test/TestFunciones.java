
package fp.funciones.test;

import fp.funciones.Funciones;

public class TestFunciones {
	
	public static void main(String[] args) {
        // 1. Test esPrimo
		System.out.println("Test número primo: ");
        System.out.println("¿Es 5 un número primo? " + Funciones.esPrimo(5)); 
        System.out.println("¿Es 22 un número primo? " + Funciones.esPrimo(22)); 
        System.out.println("¿Es 17 un número primo? " + Funciones.esPrimo(17));
        System.out.println("¿Es 45 un número primo? " + Funciones.esPrimo(45));

        // 2. Test número combinatorio
        System.out.println("\nTest número combinatorio: ");
        System.out.println("El número combinatorio de 10 sobre 7 es: " + Funciones.numCom(10, 7)); 
        System.out.println("El número combinatorio de 9 sobre 3 es: " + Funciones.numCom(9, 3));
        System.out.println("El número combinatorio de 12 sobre 6 es: " + Funciones.numCom(12, 6));
        System.out.println("El número combinatorio de 13 sobre 9 es: " + Funciones.numCom(13, 9));

        // 3. Test calcular S(n,k)
        System.out.println("\nTest calcular S(n,k): ");
        System.out.println("El resultado de S(10, 7) es: " + Funciones.calcularS(10, 7)); 
        System.out.println("El resultado de S(9, 3) es: " + Funciones.calcularS(9, 3));
        System.out.println("El resultado de S(12, 6) es: " + Funciones.calcularS(12, 6));
        System.out.println("El resultado de S(13, 9) es: " + Funciones.calcularS(13, 9));

        // 4. Test diferencias valores consecutivos
        System.out.println("\nTest diferencias valores consecutivos: ");
        int[] lista1 = {3, 9, 12, 20, 10, -3};
        System.out.println("Diferencias entre valores consecutivos en {3, 9, 12, 20, 10, -3}: "
                + java.util.Arrays.toString(Funciones.DiffValorAnterior(lista1))); 
        int[] lista2 = {4, -7, 10, -11, 2, 23};
        System.out.println("Diferencias entre valores consecutivos en {4, -7, 10, -11, 2, 23}: "
                + java.util.Arrays.toString(Funciones.DiffValorAnterior(lista2))); 
        int[] lista3 = {7, 3, 4, 1, 14, -23};
        System.out.println("Diferencias entre valores consecutivos en {7, 3, 4, 1, 14, -23}: "
                + java.util.Arrays.toString(Funciones.DiffValorAnterior(lista3))); 

        // 5. Test cadena más larga
        System.out.println("\nTest cadena de caracteres más larga: ");
        String[] lista4 = {"Fútbol", "Baloncesto", "Tenis"};
        System.out.println("La cadena más larga es: " + Funciones.cadenamasLarga(lista4)); 
        String[] lista5 = {"Desayuno", "Comida", "Merienda", "Cena"};
        System.out.println("La cadena más larga es: " + Funciones.cadenamasLarga(lista5)); 
        String[] lista6 = {"Albus", "Snape", "Homer", "Bart", "Maggie"};
        System.out.println("La cadena más larga es: " + Funciones.cadenamasLarga(lista6)); 
        
        //Defensa Entrega 01 Java
        //Test Función P2
        System.out.println("\nPrueba de la función P2:");
        try {
        	//Prueba 1
            int resultado = Funciones.P2(10, 5, 2);
            System.out.println("P2(10, 5, 2) = " + resultado); 
            //Prueba 2
        	int resultado2 = Funciones.P2(8, 4, 1);
        	System.out.println("P2(8, 4, 1) = " + resultado2); 
		} catch (IllegalArgumentException e) {
			System.out.println("Error: " + e.getMessage());
		}
        
        //Test Función C2
        System.out.println("\nPrueba de la función C2:");
        try {
        	//Prueba 1
            int resultado = Funciones.C2(6, 2);
            System.out.println("C2(6, 2) = " + resultado);
            //Prueba 2
            int resultado2 = Funciones.C2(8, 3);
            System.out.println("C2(8, 3) = " + resultado2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        //Test Función S2
        System.out.println("\nPrueba de la función S2:");
        try {
        	//Prueba 1
            double resultado = Funciones.S2(5, 3);
            System.out.println("S2(5, 3) = " + resultado);
            //Prueba 2
            double resultado2 = Funciones.S2(4, 2);
            System.out.println("S2(4, 2) = " + resultado2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
