
package fp.funciones;

public class Funciones {

	// 1. Determinar si es un número primo o no.
	public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 2. Calcular número combinatorio de n, k 
    public static int numCom(int n, int k) {
        if (n < k) {
            throw new IllegalArgumentException("n debe ser mayor o igual que k");
        }
        if (k == 0 | k == n) {
            return 1;
        }
        return numCom(n - 1, k - 1) + numCom(n - 1, k);
    }
    
    // 3. Calcular el factorial de un número
    private static int fact(int n) {
   		if (n == 0) {
   			return 1;
   		}
   		return n * fact(n - 1);
    }

    // 3. Calcular S(n,k)
    public static double calcularS(int n, int k) {
        double sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += Math.pow(-1, i) * numCom(k, i) * Math.pow(k - i, n);
        }
        return sum / fact(k);
    }

    // 4. Lista diferencia entre valores enteros
    public static int[] DiffValorAnterior(int[] lista) {
        int[] diff = new int[lista.length - 1];
        for (int i = 1; i < lista.length; i++) {
            diff[i - 1] = lista[i] - lista[i - 1];
        }
        return diff;
    }

    // 5. Obtener la cadena más larga dada una lista de cadenas de caracteres
    public static String cadenamasLarga(String[] lista) {
        String masLarga = "";
        for (String cadena : lista) {
            if (cadena.length() > masLarga.length()) {
                masLarga = cadena;
            }
        }
        return masLarga;
    }
}

