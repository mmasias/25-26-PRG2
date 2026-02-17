import java.util.Scanner;

public class ExamenMina {

	static final int FILAS = 5;
	static final int COLUMNAS = 7;
	static final int TOTAL_MINAS = 5;
	static final int MAX_EXPLOSIONES = 3;
	static final int CASILLAS_PARA_GANAR = FILAS * COLUMNAS - TOTAL_MINAS;

	static String[][] tableroVisible = {
		{" ", "1", "2", "3", "4", "5", "6", "7"},
		{"1", "-", "-", "-", "-", "-", "-", "-"},
		{"2", "-", "-", "-", "-", "-", "-", "-"},
		{"3", "-", "-", "-", "-", "-", "-", "-"},
		{"4", "-", "-", "-", "-", "-", "-", "-"},
		{"5", "-", "-", "-", "-", "-", "-", "-"}
	};

	static String[][] tableroDeMinas = {
		{" ", "1", "2", "3", "4", "5", "6", "7"},
		{"1", "0", "0", "0", "0", "0", "0", "0"},
		{"2", "0", "0", "0", "0", "0", "0", "0"},
		{"3", "0", "0", "0", "0", "0", "0", "0"},
		{"4", "0", "0", "0", "0", "0", "0", "0"},
		{"5", "0", "0", "0", "0", "0", "0", "0"}
	};

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		colocarMinas();

		int casillasLibres = 0;
		int explosiones = 0;
		boolean juegoActivo = true;

		while (juegoActivo) {
			mostrarTablero();
			int[] coordenadas = pedirCoordenadas();
			int fila = coordenadas[0];
			int columna = coordenadas[1];

			if (hayMina(fila, columna)) {
				tableroVisible[fila][columna] = "*";
				explosiones++;
				System.out.println("Mina!");
			} else {
				tableroVisible[fila][columna] = ".";
				casillasLibres++;
				System.out.println("Libre!");
			}

			if (explosiones >= MAX_EXPLOSIONES) {
				mostrarTablero();
				System.out.println("Has perdido");
				juegoActivo = false;
			} else if (casillasLibres >= CASILLAS_PARA_GANAR) {
				mostrarTablero();
				System.out.println("Felicidades Ganador!");
				juegoActivo = false;
			}
		}
	}

	static void colocarMinas() {
		int minasColocadas = 0;
		while (minasColocadas < TOTAL_MINAS) {
			int fila = (int) (Math.random() * FILAS + 1);
			int columna = (int) (Math.random() * COLUMNAS + 1);
			if (!hayMina(fila, columna)) {
				tableroDeMinas[fila][columna] = "1";
				minasColocadas++;
			}
		}
	}

	static void mostrarTablero() {
		System.out.println("================");
		for (int i = 0; i < tableroVisible.length; i++) {
			for (int j = 0; j < tableroVisible[i].length; j++) {
				System.out.print(tableroVisible[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("================");
	}

	static int[] pedirCoordenadas() {
		while (true) {
			System.out.println("Ingrese X");
			int fila = scan.nextInt();
			System.out.println("Ingrese Y");
			int columna = scan.nextInt();

			if (fila < 1 || fila > FILAS || columna < 1 || columna > COLUMNAS) {
				System.out.println("Coordenadas fuera de rango.");
			} else if (casillaYaDescubierta(fila, columna)) {
				System.out.println("Casilla ya descubierta.");
			} else {
				return new int[]{fila, columna};
			}
		}
	}

	static boolean hayMina(int fila, int columna) {
		return tableroDeMinas[fila][columna].equals("1");
	}

	static boolean casillaYaDescubierta(int fila, int columna) {
		return tableroVisible[fila][columna].equals(".")
			|| tableroVisible[fila][columna].equals("*");
	}
}