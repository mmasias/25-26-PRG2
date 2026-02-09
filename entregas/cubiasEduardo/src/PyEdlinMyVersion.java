import java.util.Scanner;

public class PyEdlinMyVersion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] textoIngresadoPorElUsuario = new String[10];
        int lineaSeleccionadaDelTextoIngresado = 0;
        
        menuDeBienvenidaYOpciones();
        crearTextoIngresadoPorElUsuario(sc, textoIngresadoPorElUsuario);
        mostrarTextoIngresadoPorElUsuario(textoIngresadoPorElUsuario);
        preguntarComandoAlUsuario(sc, textoIngresadoPorElUsuario, lineaSeleccionadaDelTextoIngresado);
    }

    static void menuDeBienvenidaYOpciones() {
        String menu = """
                --------------------------------------------------
                0: | Bienvenidos al editor EDLIN
                1:*| Utilice el menu inferior para editar el texto
                2: | ------
                3: | [L] permite definir la linea activa
                4: | [E] permite editar la linea activa
                5: | [I] permite intercambiar dos lineas
                6: | [B] borra el contenido de la linea activa
                7: | [S] sale del programa
                8: | [H] muestra este menu de opciones
                9: |
                --------------------------------------------------
                Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir
                """;

        System.out.println(menu);
    }

    static void crearTextoIngresadoPorElUsuario(Scanner sc, String[] textoIngresadoPorElUsuario) {
        System.out.println("Ingrese el texto que desea editar. Para finalizar, ingrese [S]");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < textoIngresadoPorElUsuario.length; i++) {
            System.out.print("Ingrese la linea " + (i + 1) + ": ");
            String lineaIngresada = sc.nextLine();
            if(lineaIngresada.equals("[S]")) {
                break;
            }
            textoIngresadoPorElUsuario[i] = lineaIngresada;
        }
        System.out.println("--------------------------------------------------");
    }

    static void mostrarTextoIngresadoPorElUsuario(String[] textoIngresadoPorElUsuario) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < textoIngresadoPorElUsuario.length; i++) {
            System.out.println((i + 1) + ": " + ((textoIngresadoPorElUsuario[i] != null) ? textoIngresadoPorElUsuario[i] : ""));
        }
        System.out.println("--------------------------------------------------");
    }

    static void preguntarComandoAlUsuario(Scanner sc, String[] textoIngresadoPorElUsuario, int lineaSeleccionadaDelTextoIngresado)
    {
        int numeroDeLineaSeleccionada = 0; 
        boolean salirDelPrograma = false;
        do {
            System.out.print("Ingrese un comando de la lista de opciones: ");
            String comandoIngresado = sc.nextLine();
            switch (comandoIngresado) {
                case "[L]" -> {
                    System.out.print("Ingrese el numero de la linea que desea seleccionar: ");
                    int numeroDeLineaSeleccionada = sc.nextInt();
                    sc.nextLine();
                    validarLineaSeleccionada(numeroDeLineaSeleccionada, textoIngresadoPorElUsuario);
                }
                case "[E]" -> {
                    boolean lineaValida =validarLineaSeleccionada(lineaSeleccionadaDelTextoIngresado, textoIngresadoPorElUsuario);
                    if (lineaValida)
                    {
                    System.out.print("Ingrese el nuevo contenido de la linea seleccionada: ");
                    String nuevoContenidoDeLaLineaSeleccionada = sc.nextLine();
                    boolean segundaLineaValida = validarLineaSeleccionada(lineaSeleccionadaDelTextoIngresado, textoIngresadoPorElUsuario);
                    if (segundaLineaValida)
                    {
                    editarLineaSeleccionadaConElNuevoContenido(lineaSeleccionadaDelTextoIngresado, textoIngresadoPorElUsuario, nuevoContenidoDeLaLineaSeleccionada);
                    mostrarTextoIngresadoPorElUsuario(textoIngresadoPorElUsuario);
                    }
                }
                }
                case "[I]" -> {
                    validarLineaSeleccionada(lineaSeleccionadaDelTextoIngresado, textoIngresadoPorElUsuario);
                    System.out.print("Ingrese el numero de la linea con la que desea intercambiar la linea seleccionada: " + lineaSeleccionadaDelTextoIngresado);
                    int numeroDeLineaConLaQueDeseaIntercambiar = sc.nextInt();
                    sc.nextLine();
                    intercambiarLineas(lineaSeleccionadaDelTextoIngresado, numeroDeLineaConLaQueDeseaIntercambiar, textoIngresadoPorElUsuario);
                    mostrarTextoIngresadoPorElUsuario(textoIngresadoPorElUsuario);
                }
                case "[B]" -> {
                    validarLineaSeleccionada(lineaSeleccionadaDelTextoIngresado, textoIngresadoPorElUsuario);
                    borrarContenidoDeLaLineaSeleccionada(lineaSeleccionadaDelTextoIngresado, textoIngresadoPorElUsuario);
                    mostrarTextoIngresadoPorElUsuario(textoIngresadoPorElUsuario);
                }
                case "[S]" -> {
                    salirDelPrograma = true;
                    System.out.println("Saliendo del programa...");
                }
                case "[H]" -> menuDeBienvenidaYOpciones();
                default -> System.out.println("Comando no reconocido. Por favor, ingrese un comando valido.");        
        } while (!salirDelPrograma);
    }
}

static boolean validarLineaSeleccionada(int numeroDeLineaSeleccionada, String[] textoIngresadoPorElUsuario) {
    if (numeroDeLineaSeleccionada < 1 || numeroDeLineaSeleccionada > textoIngresadoPorElUsuario.length) {
        System.out.println("Numero de linea no valido. Por favor, ingrese un numero de linea entre 1 y " + textoIngresadoPorElUsuario.length);
    return false;
    }
    System.out.println("Linea " + numeroDeLineaSeleccionada + " seleccionada.");
    return true;
}

static void editarLineaSeleccionadaConElNuevoContenido(int lineaSeleccionadaDelTextoIngresado, String[] textoIngresadoPorElUsuario, String nuevoContenidoDeLaLineaSeleccionada) {
    textoIngresadoPorElUsuario[lineaSeleccionadaDelTextoIngresado - 1] = nuevoContenidoDeLaLineaSeleccionada;
    System.out.println("Linea " + lineaSeleccionadaDelTextoIngresado + " editada.");
}

static void intercambiarLineas(int numeroDeLaLineaSeleccionadaDelTextoIngresado, int numeroDeLineaConLaQueDeseaIntercambiar, String[] textoIngresadoPorElUsuario)
{
    String contenidoDeLaLineSeleccionada = textoIngresadoPorElUsuario[numeroDeLaLineaSeleccionadaDelTextoIngresado - 1];
    String contenidoDeLaLineaConLaQueDeseaIntercambiar = textoIngresadoPorElUsuario[numeroDeLineaConLaQueDeseaIntercambiar-1]
    textoIngresadoPorElUsuario[numeroDeLaLineaSeleccionadaDelTextoIngresado - 1] = contenidoDeLaLineaConLaQueDeseaIntercambiar;
    textoIngresadoPorElUsuario[numeroDeLineaConLaQueDeseaIntercambiar] = contenidoDeLaLineSeleccionada;
    System.out.println("Linea " + numeroDeLaLineaSeleccionadaDelTextoIngresado + " intercambiada con la linea " + numeroDeLineaConLaQueDeseaIntercambiar);
}

static void borrarContenidoDeLaLineaSeleccionada(int numeroDeLaLineaSeleccionadaDelTextoIngresado, String[] textoIngresadoPorElUsuario)
{
    textoIngresadoPorElUsuario[numeroDeLaLineaSeleccionadaDelTextoIngresado - 1] = "";
    System.out.println("Contenido de la linea " + numeroDeLaLineaSeleccionadaDelTextoIngresado + " borrado.");
}
