package entregas.moraDaniel;

import java.util.Scanner;

public class BuscaMinasCorregido {

	static String[][] tableroVisible = {
			{ " ", "1", "2", "3", "4", "5", "6", "7" },

			{ "1", "-", "-", "-", "-", "-", "-", "-" },

			{ "2", "-", "-", "-", "-", "-", "-", "-" },

			{ "3", "-", "-", "-", "-", "-", "-", "-" },

			{ "4", "-", "-", "-", "-", "-", "-", "-" },

			{ "5", "-", "-", "-", "-", "-", "-", "-" }
	};

	static String[][] tableroMinasActivas = {
			{ " ", "1", "2", "3", "4", "5", "6", "7" },

			{ "1", "0", "0", "0", "0", "0", "0", "0" },

			{ "2", "0", "0", "0", "0", "0", "0", "0" },

			{ "3", "0", "0", "0", "0", "0", "0", "0" },

			{ "4", "0", "0", "0", "0", "0", "0", "0" },

			{ "5", "0", "0", "0", "0", "0", "0", "0" }
	};
	static final int FILAS = 5;
	static final int COLUMNAS = 7;
	static final int TOTAL_MINAS = 5;
	static final int MAX_EXPLOSIONES = 3;
	static final int CASILLAS_LIBRES = FILAS * COLUMNAS - TOTAL_MINAS;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		colocarMinas();
		iniciarJuego(scanner);

		scanner.close();

	}

	static void colocarMinas() {
		int minasColocadas = 0;
		while (minasColocadas < TOTAL_MINAS) {
			int filaAleatorinaDeMina = (int) (Math.random() * FILAS + 1);
			int columnaAleatoriaDeMina = (int) (Math.random() * COLUMNAS + 1);
			if (!tableroMinasActivas[filaAleatorinaDeMina][columnaAleatoriaDeMina].equals("1")) {

				tableroMinasActivas[filaAleatorinaDeMina][columnaAleatoriaDeMina] = "1";
				minasColocadas++;
			}
		}

	}

	static void mostrarTablero() {

		for (int i = 0; i < tableroVisible.length; i++) {
			for (int j = 0; j < tableroVisible[i].length; j++) {
				System.out.print(tableroVisible[i][j]);
			}
			System.out.println(" ");
		}
	}

	static int[] pedirCoordenadas(Scanner scanner) {

		int filaMina = 0;
		int columnaMina = 0;
		int valoresCorrectos = 0;

		while (valoresCorrectos == 0) {

			System.out.println(" ");
			System.out.println("Ingrese X");
			filaMina = scanner.nextInt();

			System.out.println("Ingrese Y");
			columnaMina = scanner.nextInt();

			if (filaMina < 1 || filaMina > FILAS || columnaMina < 1 || columnaMina > COLUMNAS) {
				valoresCorrectos = 0;
			} else {
				valoresCorrectos = 1;
			}
		}

		return new int[] { filaMina, columnaMina };
	}

	static void iniciarJuego(Scanner scanner) {

		boolean juegoEncendido = true;
		int contadorMapa = 0;
		int contadorMinas = 0;

		while (juegoEncendido) {

			mostrarTablero();

			int[] coordenadas = pedirCoordenadas(scanner);
			int filaMina = coordenadas[0];
			int columnaMina = coordenadas[1];

			if (tableroMinasActivas[filaMina][columnaMina].equals("1")) {
				tableroVisible[filaMina][columnaMina] = "x";
				contadorMinas++;
			} else {
				tableroVisible[filaMina][columnaMina] = ".";
			}

			contadorMapa++;

			if (contadorMinas >= MAX_EXPLOSIONES) {
				System.out.println("Has perdido");
				juegoEncendido = false;
			} else if (contadorMapa >= CASILLAS_LIBRES) {
				System.out.println("Felicidades Ganador!");
				juegoEncendido = false;
			}
		}
	}
}
