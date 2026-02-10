import java.util.Scanner;
import java.util.Stack;

public class PyEdlin {

    static class EstadoEditor {
        String[] contenidoLineas;
        int lineaActiva;

        EstadoEditor(String[] lineasActuales, int lineaActivaActual){
            contenidoLineas = new String[10];
            for(int indice = 0; indice < 10; indice++)
                contenidoLineas[indice] = lineasActuales[indice];
            lineaActiva = lineaActivaActual;
        }
    }

    static String[] lineas = new String[10];
    static int lineaActiva = 0;
    static Stack<EstadoEditor> historialEstados = new Stack<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        for(int indice = 0; indice < 10; indice++){
            lineas[indice] = "";
        }

        while(true){
            mostrarEditor();
            System.out.print("Comando: ");
            String comandoUsuario = scanner.nextLine().toUpperCase();

            if(comandoUsuario.equals("L")){
                System.out.print("Numero de linea (0-9): ");
                int nuevaLineaActiva = Integer.parseInt(scanner.nextLine());
                if(nuevaLineaActiva >= 0 && nuevaLineaActiva <= 9){
                    lineaActiva = nuevaLineaActiva;
                }
            }
            else if(comandoUsuario.equals("E")){
                guardarEstado();
                System.out.print("Nuevo texto: ");
                String nuevoTexto = scanner.nextLine();
                lineas[lineaActiva] = nuevoTexto;
            }
            else if(comandoUsuario.equals("B")){
                guardarEstado();
                lineas[lineaActiva] = "";
            }
            else if(comandoUsuario.equals("I")){
                guardarEstado();
                System.out.print("Primera linea: ");
                int primeraLinea = Integer.parseInt(scanner.nextLine());
                System.out.print("Segunda linea: ");
                int segundaLinea = Integer.parseInt(scanner.nextLine());

                if(primeraLinea >= 0 && primeraLinea <= 9 && segundaLinea >= 0 && segundaLinea <= 9){
                    String textoTemporal = lineas[primeraLinea];
                    lineas[primeraLinea] = lineas[segundaLinea];
                    lineas[segundaLinea] = textoTemporal;
                }
            }
            else if(comandoUsuario.equals("D")){
                if(!historialEstados.isEmpty()){
                    EstadoEditor estadoAnterior = historialEstados.pop();
                    lineas = estadoAnterior.contenidoLineas;
                    lineaActiva = estadoAnterior.lineaActiva;
                }
            }
            else if(comandoUsuario.equals("S")){
                break;
            }
        }

        scanner.close();
    }

    public static void mostrarEditor(){
        System.out.println("----------------------------------");
        for(int indice = 0; indice < 10; indice++){
            if(indice == lineaActiva)
                System.out.println(indice + ":*| " + lineas[indice]);
            else
                System.out.println(indice + ": | " + lineas[indice]);
        }
        System.out.println("----------------------------------");
    }

    public static void guardarEstado(){
        historialEstados.push(new EstadoEditor(lineas, lineaActiva));
    }
}
