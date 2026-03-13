import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Juego de Adivinanza - Adivina el Numero Secreto");
        
         int minimo = 1;
        int maximo = 100;
        int maximoIntentos = 10

        System.out.println();
        System.out.println("Selecciona Dificultad:");
        System.out.println("1. Facil (1-50, 10 intentos)");
        System.out.println("2. Normal (1-100, 7 intentos)");
        System.out.println("3. Dificil (1-200, 8 intentos)");
        System.out.print("Opcion: ");
        int dificultad = sc.nextInt();

        if (dificultad == 1) {
            maximo = 50;
            maximoIntentos = 10;
        } else if (dificultad == 2) {
            maximo = 100;
            maximoIntentos = 7;
        } else if (dificultad == 3) {
            maximo = 200;
            maximoIntentos = 8;
        } else {
            System.out.println("Opcion no valida, usando dificultad Normal.");
        }

        System.out.println(); // espacio
        System.out.println("Adivina el numero entre " + minN + " y " + maxN);

         int ns = generarNumeroSecreto(minN, maxN);
        int intentosRealizados = 0;
        boolean adivinado = false;

        
        int[] histN = new int[maxI];
        String[] histP = new String[maxI];
        int idx = 0; 

        while (intentosRealizados < maxI && !adivinado) {
            System.out.println(); /
            System.out.println("Intento " + (intentosRealizados + 1) + "/" + maxI + ": ");
            System.out.println("[1] Adivinar [2] Pedir Pista");
            System.out.print("Opcion: ");
            int opt_juego = sc.nextInt();

            String pistaActual = "";

            if (opt_juego == 2) { 
                if (intentosRealizados >= maxI - 1) { 
                    System.out.println("No puedes pedir mas pistas, es tu ultimo intento.");
                    pistaActual = "Pista denegada";
                } else {
                    intentosRealizados++; 
                    System.out.print("PISTA: ");
                    if (ns % 2 == 0) { 
                        System.out.println("El numero es par.");
                    } else {
                        System.out.println("El numero es impar.");
                    }
                    if (ns % 3 == 0) { 
                        System.out.println("El numero es multiplo de 3.");
                    }
                    pistaActual = "Pista solicitada";
                   
                    if (idx < maxI) {
                        histN[idx] = 0; 
                        histP[idx] = pistaActual;
                        idx++;
                    }
                }
                continue; 
            } else if (opt_juego == 1) { 
                System.out.print("Tu numero: ");
                int n = sc.nextInt();
                
           
                if (n < minN || n > maxN) {
                    System.out.println("El numero debe estar entre " + minN + " y " + maxN);
                    pistaActual = "Fuera de rango";
                   
                    if (idx < maxI) {
                        histN[idx] = n;
                        histP[idx] = pistaActual;
                        idx++;
                    }
                    continue; 
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
                } else { 
                    System.out.println("El numero es MENOR");
                    if (n > ns - 5 && n < ns + 5) { // Cerca
                        System.out.println("¡Muy cerca!");
                        pistaActual = "MENOR, ¡Muy cerca!";
                    } else {
                        pistaActual = "MENOR";
                    }
                }
                
            
                if (idx < maxI) {
                    histN[idx] = n;
                    histP[idx] = pistaActual;
                    idx++;
                }
            } else {
                System.out.println("Opcion invalida.");
                pistaActual = "Opcion invalida";
                
            }
        }

        if (!adivinado) {
            System.out.println(); 
            System.out.println("¡Se acabaron los intentos!");
            System.out.println("El numero era: " + ns);
        }

        System.out.println(); 
        System.out.println("Historial de Intentos");
        for (int k = 0; k < idx; k++) {
            System.out.println((k + 1) + ". " + histN[k] + " -> " + histP[k]);
        }
        if (idx == 0) {
            System.out.println("(No hubo intentos)");
        }

        System.out.println(); 
        System.out.println("Fin del juego");
        sc.close();
    }
}