import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Juego de Adivinanza - Adivina el Numero Secreto");
        
        int minN = 1;
        int maxN = 100;
        int maxI = 10; // Max intentos

        System.out.println(); // espacio
        System.out.println("Selecciona Dificultad:");
        System.out.println("1. Facil (1-50, 10 intentos)");
        System.out.println("2. Normal (1-100, 7 intentos)");
        System.out.println("3. Dificil (1-200, 8 intentos)");
        System.out.print("Opcion: ");
        int d = sc.nextInt();

        if (d == 1) {
            maxN = 50;
            maxI = 10;
        } else if (d == 2) {
            maxN = 100;
            maxI = 7;
        } else if (d == 3) {
            maxN = 200;
            maxI = 8;
        } else {
            System.out.println("Opcion no valida, usando dificultad Normal.");
        }

        System.out.println(); // espacio
        System.out.println("Adivina el numero entre " + minN + " y " + maxN);

        int ns = (int)(Math.random() * (maxN - minN + 1)) + minN;
        int intentosRealizados = 0;
        boolean adivinado = false;

        // Historial
        int[] histN = new int[maxI];
        String[] histP = new String[maxI];
        int idx = 0; // Indice

        while (intentosRealizados < maxI && !adivinado) {
            System.out.println(); // espacio
            System.out.println("Intento " + (intentosRealizados + 1) + "/" + maxI + ": ");
            System.out.println("[1] Adivinar [2] Pedir Pista");
            System.out.print("Opcion: ");
            int opt_juego = sc.nextInt();

            String pistaActual = "";

            if (opt_juego == 2) { // Pista
                if (intentosRealizados >= maxI - 1) { // Ultimo intento no hay pista
                    System.out.println("No puedes pedir mas pistas, es tu ultimo intento.");
                    pistaActual = "Pista denegada";
                } else {
                    intentosRealizados++; // La pista cuesta
                    System.out.print("PISTA: ");
                    if (ns % 2 == 0) { // Duplicado
                        System.out.println("El numero es par.");
                    } else {
                        System.out.println("El numero es impar.");
                    }
                    if (ns % 3 == 0) { // Otra
                        System.out.println("El numero es multiplo de 3.");
                    }
                    pistaActual = "Pista solicitada";
                    // Guardar en historial
                    if (idx < maxI) {
                        histN[idx] = 0; // 0 para pista
                        histP[idx] = pistaActual;
                        idx++;
                    }
                }
                continue; // Volver a empezar
            } else if (opt_juego == 1) { // Adivinar
                System.out.print("Tu numero: ");
                int n = sc.nextInt();
                
                // Valida rango
                if (n < minN || n > maxN) {
                    System.out.println("El numero debe estar entre " + minN + " y " + maxN);
                    pistaActual = "Fuera de rango";
                    // Guardar en historial
                    if (idx < maxI) {
                        histN[idx] = n;
                        histP[idx] = pistaActual;
                        idx++;
                    }
                    continue; // Saltar intento
                }
                
                intentosRealizados++;

                if (n == ns) {
                    adivinado = true;
                    System.out.println("¡Felicidades! ¡Has adivinado el numero!");
                    System.out.println("Lo lograste en " + intentosRealizados + " intentos");
                    pistaActual = "¡Adivinado!";
                } else if (n < ns) {
                    System.out.println("El numero es MAYOR");
                    if (n > ns - 5 && n < ns + 5) { // Cerca
                        System.out.println("¡Muy cerca!");
                        pistaActual = "MAYOR, ¡Muy cerca!";
                    } else {
                        pistaActual = "MAYOR";
                    }
                } else { // n > ns
                    System.out.println("El numero es MENOR");
                    if (n > ns - 5 && n < ns + 5) { // Cerca
                        System.out.println("¡Muy cerca!");
                        pistaActual = "MENOR, ¡Muy cerca!";
                    } else {
                        pistaActual = "MENOR";
                    }
                }
                
                // Guardar en historial
                if (idx < maxI) {
                    histN[idx] = n;
                    histP[idx] = pistaActual;
                    idx++;
                }
            } else {
                System.out.println("Opcion invalida.");
                pistaActual = "Opcion invalida";
                // No hay intento consumido
            }
        }

        if (!adivinado) {
            System.out.println(); // espacio
            System.out.println("¡Se acabaron los intentos!");
            System.out.println("El numero era: " + ns);
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