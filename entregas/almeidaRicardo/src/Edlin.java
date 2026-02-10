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

        do {
            mostrarTela(linhas, linhaAtiva);

            System.out.print(">> ");
            char comando = scanner.next().charAt(0);

            if (comando == 'L' || comando == 'l') {
                System.out.print("Digite o numero da linha (0 a 9): ");
                linhaAtiva = scanner.nextInt();
                scanner.nextLine();
            }
            else if (comando == 'E' || comando == 'e') {
                System.out.print("Novo conteudo da linha: ");
                scanner.nextLine();
                linhas[linhaAtiva] = scanner.nextLine();
            }
            else if (comando == 'B' || comando == 'b') {
                linhas[linhaAtiva] = "";
                scanner.nextLine();
            }
            else if (comando == 'I' || comando == 'i') {
                System.out.print("Primeira linha (0 a 9): ");
                int a = scanner.nextInt();
                System.out.print("Segunda linha (0 a 9): ");
                int b = scanner.nextInt();
                scanner.nextLine();

                if (a >= 0 && a <= 9 && b >= 0 && b <= 9) {
                    String temp = linhas[a];
                    linhas[a] = linhas[b];
                    linhas[b] = temp;
                }
            }
            else if (comando == 'S' || comando == 's') {
                sair = true;
                scanner.nextLine();
            }
            else {
                scanner.nextLine();
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
}
