

package ec.edu.ec.welintonsacon_2025;

import java.util.Scanner;


public class WelintonSacon_2025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] temperaturas = new double[7];
        
        // 1. Ingresar temperaturas validadas
        for (int i = 0; i < 7; i++) {
            double temp;
            do {
                System.out.print("Ingrese la temperatura del día " + (i + 1) + " (-30 a 50 °C): ");
                temp = sc.nextDouble();
                if (temp < -30 || temp > 50) {
                    System.out.println("Temperatura fuera de rango. Intente de nuevo.");
                }
            } while (temp < -30 || temp > 50);
            temperaturas[i] = temp;
        }

        int opcion;
        do {
            // 3. Menú de opciones
            System.out.println("MENÚ ");
            System.out.println(" Calcular promedio semanal de temperatura");
            System.out.println(" Mostrar días por encima del promedio");
            System.out.println("Indicar el día más caluroso y el más frío");
            System.out.println("Sumar temperaturas de los primeros 3 y últimos 3 días");
            System.out.println("Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    // Promedio semanal
                    double suma = 0;
                    for (double t : temperaturas) {
                        suma += t;
                    }
                    double promedio = suma / temperaturas.length;
                    System.out.println("Promedio semanal: " + promedio + " °C");
                    break;

                case 2:
                    // Días por encima del promedio
                    double total = 0;
                    for (double t : temperaturas) {
                        total += t;
                    }
                    double prom = total / temperaturas.length;
                    int contador = 0;
                    for (double t : temperaturas) {
                        if (t > prom) {
                            contador++;
                        }
                    }
                    System.out.println("Días con temperatura por encima del promedio (" + prom + " °C): " + contador);
                    break;

                case 3:
                    // Día más caluroso y más frío
                    int diaMax = 0, diaMin = 0;
                    for (int i = 1; i < temperaturas.length; i++) {
                        if (temperaturas[i] > temperaturas[diaMax]) diaMax = i;
                        if (temperaturas[i] < temperaturas[diaMin]) diaMin = i;
                    }
                    System.out.println("Día más caluroso: Día " + (diaMax + 1) + " (" + temperaturas[diaMax] + " °C)");
                    System.out.println("Día más frío: Día " + (diaMin + 1) + " (" + temperaturas[diaMin] + " °C)");
                    break;

                case 4:
                    // Suma de primeros tres y últimos tres días
                    double sumaInicio = temperaturas[0] + temperaturas[1] + temperaturas[2];
                    double sumaFin = temperaturas[4] + temperaturas[5] + temperaturas[6];
                    System.out.println("Suma primeros 3 días: " + sumaInicio + " °C");
                    System.out.println("Suma últimos 3 días: " + sumaFin + " °C");
                    break;

                case 5:
                    // Salir
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }

        } while (opcion != 5);

        sc.close();
    }
}
