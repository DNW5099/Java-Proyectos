
package fp.tipos;

public record Fecha(int año, int mes, int dia) { //año, mes, día de tipo Integer
	
	//Nombres de los meses definidos
	private static final String[] nombres_meses = {
		"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", 
		"Noviembre", "Diciembre"
    };
	
	//Nombres de días de la semana definidos
	private static final String[] nombres_dias = {
		"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"
    };
	
	//Indica nombre del mes asociado
    public String nombreMes() {
        return nombres_meses[mes - 1];
    }

    //Indica nombre del día de la semana
    public String diaSemana() {
        int diaZeller = congruenciaZ(año, mes, dia);
        return nombres_dias[diaZeller - 1]; 
    }

    //Indica fecha resultante de sumar número de días a la fecha
    public Fecha sumarDias(int dias) {
        int añoResultante = año;
        int mesResultante = mes;
        int diaResultante = dia + dias;

        while (diaResultante > numeroDiasMes(añoResultante, mesResultante)) {
            diaResultante -= numeroDiasMes(añoResultante, mesResultante);
            mesResultante++;
            if (mesResultante > 12) {
                mesResultante = 1;
                añoResultante++;
            }
        }
        return of(añoResultante, mesResultante, diaResultante);
    }

    //Indica fecha resultante de restar número de días a la fecha
    public Fecha restarDias(int dias) {
        int añoResultante = año;
        int mesResultante = mes;
        int diaResultante = dia - dias;

        while (diaResultante <= 0) {
            if (mesResultante == 1) {
                mesResultante = 12;
                añoResultante--;
            } else {
                mesResultante--;
            }
            diaResultante += numeroDiasMes(añoResultante, mesResultante);
        }
        return of(añoResultante, mesResultante, diaResultante);
    }

    //Indica número de días entre una fecha y otra
    public int diferenciaDias(Fecha otraFecha) {
        int diasPrimeraFecha = diasdesdeInicio();
        int diasSegundaFecha = otraFecha.diasdesdeInicio();
        return Math.abs(diasPrimeraFecha - diasSegundaFecha);   
    }

    //Calcula número de días que han pasado desde el inicio del año hasta la fecha
    private int diasdesdeInicio() {
        int totalDias = 0;
        for (int i = 1; i < mes; i++) {
            totalDias += numeroDiasMes(año, i);
        }
        return totalDias + dia;
    }

    //Formato de la fecha como cadena
    public String toString() {
        return String.format("%s, %d de %s de %d", diaSemana(), dia, nombreMes(), año);
    }

    //Método de factoría of
    public static Fecha of(int año, int mes, int dia) {
        return new Fecha(año, mes, dia);
    }

    //Método de factoría parse
    public static Fecha parse(String cadenaFecha) {
        String[] partes = cadenaFecha.split("-");
        int año = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);
        return of(año, mes, dia);
    }

    //Indica si el año es bisiesto o no
    public static boolean esAñoBisiesto(int año) {
        return (año % 4 == 0 && año % 100 != 0) || año % 400 == 0;
    }

    //Indica el número del mes de dicho año
    public static int numeroDiasMes(int año, int mes) {
        switch (mes) {
            case 2:
                return esAñoBisiesto(año) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    //Indica el día de la semana asociado a dicha fecha
    public static int congruenciaZ(int año, int mes, int dia) {
        if (mes < 3) {
            año--;
            mes += 12;
        }
        int K = año % 100;
        int J = año / 100;
        int h = (dia + ((13 * (mes + 1)) / 5) + K + (K / 4) + (J / 4) + (5 * J)) % 7;
        return (h == 0) ? 7 : h;
    }
    
    //Defensa Entrega 01 Java
    public Fecha restarDiasFechaDada(int numDias) {
        if (numDias <= 0 || numDias > 999) {
            throw new IllegalArgumentException("El número de días debe ser positivo y tener 3 dígitos como máximo");
        }
        int diasRestantes = numDias;
        int añoActual = this.año;
        int mesActual = this.mes;
        int diaActual = this.dia;

        while (diasRestantes > 0) {
            int diasEnMesActual = Fecha.numeroDiasMes(añoActual, mesActual);
            if (diasRestantes >= diaActual) {
                diasRestantes -= diaActual;
                if (mesActual == 1) {
                    mesActual = 12;
                    añoActual--;
                } else {
                    mesActual--;
                }
                diaActual = Fecha.numeroDiasMes(añoActual, mesActual);
            } else {
                diaActual -= diasRestantes;
                diasRestantes = 0;
            }
        }

        return new Fecha(añoActual, mesActual, diaActual);
    }
}
