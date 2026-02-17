import java.util.Scanner;

public class ExamenMina {

    static String[][] mapaMinasMostrar =
            {
                    {" ", "1", "2", "3", "4", "5", "6", "7"},
                    {"1", "-", "-", "-", "-", "-", "-", "-"},
                    {"2", "-", "-", "-", "-", "-", "-", "-"},
                    {"3", "-", "-", "-", "-", "-", "-", "-"},
                    {"4", "-", "-", "-", "-", "-", "-", "-"},
                    {"5", "-", "-", "-", "-", "-", "-", "-"}
            };

    static String[][] mapaMinasActivas =
            {
                    {" ", "1", "2", "3", "4", "5", "6", "7"},
                    {"1", "0", "0", "0", "0", "0", "0", "0"},
                    {"2", "0", "0", "0", "0", "0", "0", "0"},
                    {"3", "0", "0", "0", "0", "0", "0", "0"},
                    {"4", "0", "0", "0", "0", "0", "0", "0"},
                    {"5", "0", "0", "0", "0", "0", "0", "0"}
            };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int minasColocadas = 0;
        while (minasColocadas < 5) {

            int filaMina = (int) (Math.random() * 5 + 1);
            int columnaMina = (int) (Math.random() * 7 + 1);

            if (mapaMinasActivas[filaMina][columnaMina].equals("1")) {
                continue;
            }

            mapaMinasActivas[filaMina][columnaMina] = "1";
            minasColocadas++;
        }

        int fila = 0;
        int columna = 0;
        int minasPisadas = 0;
        int casillasSegurasDescubiertas = 0;
        boolean juegoActivo = true;

        while (juegoActivo) {

            for (int i = 0; i < mapaMinasMostrar.length; i++) {
                for (int j = 0; j < mapaMinasMostrar[i].length; j++) {
                    System.out.print(mapaMinasMostrar[i][j] + " ");
                }
                System.out.println();
            }

            boolean coordenadasValidas = false;
            while (!coordenadasValidas) {

                try {
                    System.out.println();
                    System.out.print("Ingrese FILA (1-5): ");
                    fila = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese COLUMNA (1-7): ");
                    columna = Integer.parseInt(scanner.nextLine());

                    if (fila >= 1 && fila <= 5 && columna >= 1 && columna <= 7) {
                        coordenadasValidas = true;
                    } else {
                        System.out.println("Coordenadas fuera del tablero.");
                    }

                } catch (Exception e) {
                    System.out.println("Debe introducir numeros enteros.");
                }
            }

            if (mapaMinasActivas[fila][columna].equals("1")) {

                if (!mapaMinasMostrar[fila][columna].equals("x")) {
                    mapaMinasMostrar[fila][columna] = "x";
                    minasPisadas++;
                }

            } else {

                if (mapaMinasMostrar[fila][columna].equals("-")) {
                    mapaMinasMostrar[fila][columna] = ".";
                    casillasSegurasDescubiertas++;
                }
            }

            if (minasPisadas >= 3) {
                juegoActivo = false;
                System.out.println("Has perdido");
            }

            else if (casillasSegurasDescubiertas == 30) {
                juegoActivo = false;
                System.out.println("Felicidades Ganador!");
            }
        }

        scanner.close();
    }
}
