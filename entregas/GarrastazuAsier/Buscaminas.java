import java.util.Scanner;

public class Buscaminas {

	static final int FILAS = 5;
	static final int COLUMNAS = 7;
	static final int MINAS = 5;
	static final int MAX_MINAS_TOCADAS = 2;
	static final int MAX_MOVIMIENTOS = 31;

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

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		colocarMinas();

		int contadorMinas = 0;
		int contadorMapa = 0;
		boolean juegoEncendido = true;

		while (juegoEncendido) {
			imprimirTablero();
			int[] coordenadas = leerCoordenadas();

			if (!mapaMinasMostrar[coordenadas[0]][coordenadas[1]].equals("-")) {
				continue;
			}

			procesarJugada(coordenadas);

			if (mapaMinasActivas[coordenadas[0]][coordenadas[1]].equals("1")) {
				contadorMinas++;
			}

			contadorMapa++;
			juegoEncendido = !(contadorMinas > MAX_MINAS_TOCADAS || contadorMapa >= MAX_MOVIMIENTOS);
		}
	}

	static void colocarMinas() {
		int i = 0;
		while (i < MINAS) {
			int posX = (int) (Math.random() * FILAS + 1);
			int posY = (int) (Math.random() * COLUMNAS + 1);
			if (!mapaMinasActivas[posX][posY].equals("1")) {
				mapaMinasActivas[posX][posY] = "1";
				i++;
			}
		}
	}

	static void imprimirTablero() {
		for (int i = 0; i < mapaMinasMostrar.length; i++) {
			for (int j = 0; j < mapaMinasMostrar[i].length; j++) {
				System.out.print(mapaMinasMostrar[i][j]);
			}
			System.out.println();
		}
	}

	static int[] leerCoordenadas() {
		int posX = 0, posY = 0;
		boolean valido = false;
		while (!valido) {
			posY = scan.nextInt();
			posX = scan.nextInt();
			if (posX >= 1 && posX <= FILAS && posY >= 1 && posY <= COLUMNAS) {
				valido = true;
			}
		}
		return new int[]{posX, posY};
	}

	static void procesarJugada(int[] coordenadas) {
		int posX = coordenadas[0];
		int posY = coordenadas[1];

		if (mapaMinasActivas[posX][posY].equals("1")) {
			mapaMinasMostrar[posX][posY] = "x";
		} else if (mapaMinasActivas[posX][posY].equals("0")) {
			mapaMinasMostrar[posX][posY] = ".";
		}
	}
}