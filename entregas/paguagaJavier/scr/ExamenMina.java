import java.util.Scanner;

public class ExamenMina {

	static String[][] mapaMinasMostrar = {
			{ " ", "1", "2", "3", "4", "5", "6", "7" },
			{ "1", "-", "-", "-", "-", "-", "-", "-" },
			{ "2", "-", "-", "-", "-", "-", "-", "-" },
			{ "3", "-", "-", "-", "-", "-", "-", "-" },
			{ "4", "-", "-", "-", "-", "-", "-", "-" },
			{ "5", "-", "-", "-", "-", "-", "-", "-" }
	};

	static String[][] mapaMinasActivas = {
			{ " ", "1", "2", "3", "4", "5", "6", "7" },
			{ "1", "0", "0", "0", "0", "0", "0", "0" },
			{ "2", "0", "0", "0", "0", "0", "0", "0" },
			{ "3", "0", "0", "0", "0", "0", "0", "0" },
			{ "4", "0", "0", "0", "0", "0", "0", "0" },
			{ "5", "0", "0", "0", "0", "0", "0", "0" }
	};

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			int PosYMina = (int) (Math.random() * 2 + 1);
			int PosXMina = (int) (Math.random() * 4 + 1);
			if (mapaMinasActivas[PosXMina][PosYMina] == "1") {
				i = i - 1;
			} else {
				mapaMinasActivas[PosXMina + 1][PosYMina + 1] = "1";
			}
		}

		int posX = 0, posY = 0, valoresCorrectos, contadorMapa = 0, contadorMinas = 0;
		boolean juegoEncendido = true;
		do {
			for (int l = 0; l < mapaMinasMostrar.length; l++) {
				for (int j = 0; j < mapaMinasMostrar[l].length; j++) {
					System.out.print(mapaMinasMostrar[l][j]);
				}
				System.out.println(" ");
			}
			valoresCorrectos = 0;
			do {
				System.out.println(" ");
				System.out.println("Ingrese X");
				posY = scan.nextInt();
				System.out.println("Ingrese Y");
				posX = scan.nextInt();
				if (posX > 5) {
					valoresCorrectos = 0;
				} else if (posY > 7) {
					valoresCorrectos = 0;
				} else {
					valoresCorrectos = 1;
				}
			} while (valoresCorrectos == 0);

			if (mapaMinasActivas[posX][posY] == "1") {
				mapaMinasMostrar[posX][posY] = "x";
				contadorMinas++;
			} else if (mapaMinasActivas[posX][posY] == "0") {
				mapaMinasMostrar[posX][posY] = ".";
			} else {
				System.out.println("No es correcta esa opcion.");
			}

			contadorMapa++;
			if (contadorMinas > 2) {
				juegoEncendido = false;
				System.out.println("Has perdido");
			} else if (contadorMapa >= 31) {
				System.out.println("Felicidades Ganador!");
				juegoEncendido = false;
			}
		} while (juegoEncendido);
	}

}