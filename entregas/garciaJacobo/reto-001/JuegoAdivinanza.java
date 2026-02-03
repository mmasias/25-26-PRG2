import java.util.Scanner;

public class JuegoAdivinanza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Juego de Adivinanza - Adivina el Numero Secreto");
        
        int minNumero = 1;
        int maxNumero = 100;
        int maxIntentos = 10; 

        System.out.println(); 
        System.out.println("Selecciona Dificultad:");
        System.out.println("1. Facil (1-50, 10 intentos)");
        System.out.println("2. Normal (1-100, 7 intentos)");
        System.out.println("3. Dificil (1-200, 8 intentos)");
        System.out.print("Opcion: ");
        int dificultad = scanner.nextInt();

        if (dificultad == 1) {
            maxNumero = 50;
            maxIntentos = 10;
        } else if (dificultad == 2) {
            maxNumero = 100;
            maxIntentos = 7;
        } else if (dificultad == 3) {
            maxNumero = 200;
            maxIntentos = 8;
        } else {
            System.out.println("Opcion no valida, usando dificultad Normal.");
        }

        System.out.println(); 
        System.out.println("Adivina el numero entre " + minNumero + " y " + maxNumero);

        int numeroSecreto = (int)(Math.random() * (maxNumero - minNumero + 1)) + minNumero;
        int intentosRealizados = 0;
        boolean adivinado = false;

        
        int[] historialNumeros = new int[maxIntentos];
        String[] historialPistas = new String[maxIntentos];
        int indiceHistorial = 0; 

        while (intentosRealizados < maxIntentos && !adivinado) {
            System.out.println(); 
            System.out.println("Intento " + (intentosRealizados + 1) + "/" + maxIntentos + ": ");
            System.out.println("[1] Adivinar [2] Pedir Pista");
            System.out.print("Opcion: ");
            int opt_juego = scanner.nextInt();

            String pistaActual = "";

            if (opt_juego == 2) { 
                if (intentosRealizados >= maxIntentos - 1) { 
                    System.out.println("No puedes pedir mas pistas, es tu ultimo intento.");
                    pistaActual = "Pista denegada";
                } else {
                    intentosRealizados++; 
                    System.out.print("PISTA: ");
                    if (numeroSecreto % 2 == 0) { 
                        System.out.println("El numero es par.");
                    } else {
                        System.out.println("El numero es impar.");
                    }
                    if (numeroSecreto % 3 == 0) { 
                        System.out.println("El numero es multiplo de 3.");
                    }
                    pistaActual = "Pista solicitada";
                
                    if (indiceHistorial < maxIntentos) {
                        historialNumeros[indiceHistorial] = 0; 
                        historialPistas[indiceHistorial] = pistaActual;
                        indiceHistorial++;
                    }
                }
                continue; 
            } else if (opt_juego == 1) { 
                System.out.print("Tu numero: ");
                int numeroUsuario = scanner.nextInt();
                
                
                if (numeroUsuario < minNumero || numeroUsuario > maxNumero) {
                    System.out.println("El numero debe estar entre " + minNumero + " y " + maxNumero);
                    pistaActual = "Fuera de rango";
                    
                    if (indiceHistorial < maxIntentos) {
                        historialNumeros[indiceHistorial] = numeroUsuario;
                        historialPistas[indiceHistorial] = pistaActual;
                        indiceHistorial++;
                    }
                    continue; 
                }
                
                intentosRealizados++;

                if (numeroUsuario == numeroSecreto) {
                    adivinado = true;
                    System.out.println("¡Felicidades! ¡Has adivinado el numero!");
                    System.out.println("Lo lograste en " + intentosRealizados + " intentos");
                    pistaActual = "¡Adivinado!";
                } else if (numeroUsuario < numeroSecreto) {
                    System.out.println("El numero es MAYOR");
                    if (numeroUsuario > numeroSecreto - 5 && numeroUsuario < numeroSecreto + 5) { 
                        System.out.println("¡Muy cerca!");
                        pistaActual = "MAYOR, ¡Muy cerca!";
                    } else {
                        pistaActual = "MAYOR";
                    }
                } else { // n > ns
                    System.out.println("El numero es MENOR");
                    if (numeroUsuario > numeroSecreto - 5 && numeroUsuario < numeroSecreto + 5) {
                        System.out.println("¡Muy cerca!");
                        pistaActual = "MENOR, ¡Muy cerca!";
                    } else {
                        pistaActual = "MENOR";
                    }
                }
                
                
                if (indiceHistorial < maxIntentos) {
                    historialNumeros[indiceHistorial] = numeroUsuario;
                    historialPistas[indiceHistorial] = pistaActual;
                    indiceHistorial++;
                }
            } else {
                System.out.println("Opcion invalida.");
                pistaActual = "Opcion invalida";
              
            }
        }

        if (!adivinado) {
            System.out.println(); 
            System.out.println("¡Se acabaron los intentos!");
            System.out.println("El numero era: " + numeroSecreto);
        }

        System.out.println(); 
        System.out.println("Historial de Intentos");
        for (int k = 0; k < indiceHistorial; k++) {
            System.out.println((k + 1) + ". " + historialNumeros[k] + " -> " + historialPistas[k]);
        }
        if (indiceHistorial == 0) {
            System.out.println("(No hubo intentos)");
        }

        System.out.println(); 
        System.out.println("Fin del juego");
        scanner.close();
    }
}