import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Juego de Adivinanza - Adivina el Numero Secreto");
        
        final int NUMERO_MINIMO = 1;
        int numeroMaximo;
        int intentosMaximo;

        System.out.println("");
        System.out.println("Selecciona Dificultad:");
        System.out.println("1. Facil (1-50, 10 intentos)");
        System.out.println("2. Normal (1-100, 7 intentos)");
        System.out.println("3. Dificil (1-200, 8 intentos)");
        System.out.print("Opcion: ");
        int dificultadElegida = sc.nextInt();

        switch (dificultadElegida) {
            case 1 -> {
            numeroMaximo = 50;
            intentosMaximo = 10;
            }
            case 2 -> {
            numeroMaximo = 100;
            intentosMaximo = 7;
            }
            case 3 -> {
            numeroMaximo = 200;
            intentosMaximo = 8;
            }
            default -> {
            numeroMaximo = 100;
            intentosMaximo = 7;
            System.out.println("Opcion no valida, usando dificultad Normal.");
            }
        }

        System.out.println("");
        System.out.println("Adivina el numero entre " + NUMERO_MINIMO + " y " + numeroMaximo);

        int NumeroCualAdivinar = (int)(Math.random() * (numeroMaximo - NUMERO_MINIMO + 1)) + NUMERO_MINIMO;
        int intentosRealizados = 0;
        boolean adivinado = false;

        // Historial
        int[] histN = new int[intentosMaximo];
        String[] histP = new String[intentosMaximo];
        int idx = 0; // Indice

        while (intentosRealizados < intentosMaximo && !adivinado) {
            System.out.println("");
            System.out.println("Intento " + (intentosRealizados + 1) + "/" + intentosMaximo + ": ");
            System.out.println("[1] Adivinar [2] Pedir Pista");
            System.out.print("Opcion: ");
            int opcionElegida = sc.nextInt();

            String pistaActual;

            switch (opcionElegida) {
                case 2:
                    // Pista
                    if (intentosRealizados >= intentosMaximo - 1) { // Ultimo intento no hay pista
                        System.out.println("No puedes pedir mas pistas, es tu ultimo intento.");
                        pistaActual = "Pista denegada";
                    } else {
                        intentosRealizados++; // La pista cuesta
                        System.out.print("PISTA: ");
                        if (NumeroCualAdivinar % 2 == 0) { // Duplicado
                            System.out.println("El numero es par.");
                        } else {
                            System.out.println("El numero es impar.");
                        }
                        if (NumeroCualAdivinar % 3 == 0) { // Otra
                            System.out.println("El numero es multiplo de 3.");
                        }
                        pistaActual = "Pista solicitada";
                        // Guardar en historial
                        if (idx < intentosMaximo) {
                            histN[idx] = 0; // 0 para pista
                            histP[idx] = pistaActual;
                            idx++;
                        }
                    }
                    continue; // Volver a empezar
                case 1:
                    // Adivinar
                    System.out.print("Tu numero: ");
                    int n = sc.nextInt();
                    // Valida rango
                    if (n < NUMERO_MINIMO || n > numeroMaximo) {
                        System.out.println("El numero debe estar entre " + NUMERO_MINIMO + " y " + numeroMaximo);
                        pistaActual = "Fuera de rango";
                        // Guardar en historial
                        if (idx < intentosMaximo) {
                            histN[idx] = n;
                            histP[idx] = pistaActual;
                            idx++;
                        }
                        continue; // Saltar intento
                    }   intentosRealizados++;
                    if (n == NumeroCualAdivinar) {
                        adivinado = true;
                        System.out.println("¡Felicidades! ¡Has adivinado el numero!");
                        System.out.println("Lo lograste en " + intentosRealizados + " intentos");
                        pistaActual = "¡Adivinado!";
                    } else if (n < NumeroCualAdivinar) {
                        System.out.println("El numero es MAYOR");
                        if (n > NumeroCualAdivinar - 5 && n < NumeroCualAdivinar + 5) { // Cerca
                            System.out.println("¡Muy cerca!");
                            pistaActual = "MAYOR, ¡Muy cerca!";
                        } else {
                            pistaActual = "MAYOR";
                        }
                    } else { // n > ns
                        System.out.println("El numero es MENOR");
                        if (n > NumeroCualAdivinar - 5 && n < NumeroCualAdivinar + 5) { // Cerca
                            System.out.println("¡Muy cerca!");
                            pistaActual = "MENOR, ¡Muy cerca!";
                        } else {
                            pistaActual = "MENOR";
                        }
                    }   // Guardar en historial
                    if (idx < intentosMaximo) {
                        histN[idx] = n;
                        histP[idx] = pistaActual;
                        idx++;
                    }   break;
                default:
                    System.out.println("Opcion invalida.");
                    pistaActual = "Opcion invalida";
                    // No hay intento consumido
                    break;
            }
        }

        if (!adivinado) {
            System.out.println(); // espacio
            System.out.println("¡Se acabaron los intentos!");
            System.out.println("El numero era: " + NumeroCualAdivinar);
        }

        System.out.println(); // espacio
        System.out.println("Historial de Intentos");
        for (int k = 0; k < idx; k++) {
            System.out.println((k + 1) + ". " + histN[k] + " -> " + histP[k]);
        }
        if (idx == 0) {
            System.out.println("(No hubo intentos)");
        }

        System.out.println(); // espacio
        System.out.println("Fin del juego");
        sc.close();
    }
}