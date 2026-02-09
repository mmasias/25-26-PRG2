import java.util.Scanner;

public class Edlin {

    public static void main(String[] args) {

        String[] linhas = new String[10];
        int linhaAtiva = 1;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            linhas[i] = "";
        }

        linhas[0] = "Bienvenidos al editor EDLIN";
        linhas[1] = "Utilice el menu inferior para editar el texto";
        linhas[2] = "------";
        linhas[3] = "[L] permite definir la linea activa";
        linhas[4] = "[E] permite editar la linea activa";
        linhas[5] = "[I] permite intercambiar dos lineas";
        linhas[6] = "[B] borra el contenido de la linea activa";
        linhas[7] = "[S] sale del programa";

        boolean sair = false;
        String comando;

        do {
            mostrarTela(linhas, linhaAtiva);

            System.out.print(">> ");
            comando = scanner.nextLine();

            if (comando.equals("L") || comando.equals("l")) {
                linhaAtiva = definirLinhaAtiva(scanner);
            } 
            else if (comando.equals("E") || comando.equals("e")) {
                editarLinha(linhas, linhaAtiva, scanner);
            } 
            else if (comando.equals("B") || comando.equals("b")) {
                borrarLinha(linhas, linhaAtiva);
            } 
            else if (comando.equals("I") || comando.equals("i")) {
                intercambiarLinhas(linhas, scanner);
            } 
            else if (comando.equals("S") || comando.equals("s")) {
                sair = true;
            }

        } while (!sair);
    }

    static void mostrarTela(String[] linhas, int linhaAtiva) {
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < 10; i++) {
            String marcador = (i == linhaAtiva) ? "*" : " ";
            System.out.println(i + ":" + marcador + "| " + linhas[i]);
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Comandos: [L]inea activa | [E]ditar | [I]ntercambiar | [B]orrar | [S]alir");
    }

    static int definirLinhaAtiva(Scanner scanner) {
        System.out.print("Digite o numero da linha (0 a 9): ");
        int n = Integer.parseInt(scanner.nextLine());
        if (n >= 0 && n <= 9) {
            return n;
        }
        return 0;
    }

    static void editarLinha(String[] linhas, int linhaAtiva, Scanner scanner) {
        System.out.print("Novo conteudo da linha: ");
        linhas[linhaAtiva] = scanner.nextLine();
    }

    static void borrarLinha(String[] linhas, int linhaAtiva) {
        linhas[linhaAtiva] = "";
    }

    static void intercambiarLinhas(String[] linhas, Scanner scanner) {
        System.out.print("Primeira linha (0 a 9): ");
        int a = Integer.parseInt(scanner.nextLine());

        System.out.print("Segunda linha (0 a 9): ");
        int b = Integer.parseInt(scanner.nextLine());

        if (a >= 0 && a <= 9 && b >= 0 && b <= 9) {
            String temp = linhas[a];
            linhas[a] = linhas[b];
            linhas[b] = temp;
        }
    }
}
