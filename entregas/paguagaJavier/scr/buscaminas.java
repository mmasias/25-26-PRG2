import java.util.Scanner;

public class buscaminas {
	public static void main(String[] args) {

		int minas = 0;
		int celdasVacias = 0;
		int posa = 0;
		int posb = 0;
		int posx = 0;
		int posy = 0;
		boolean juegoTerminado = false;

		String tablero[][] = new String[6][8];

		tablero[0][0] = "**";
		tablero[0][1] = " 1";
		tablero[0][2] = " 2";
		tablero[0][3] = " 3";
		tablero[0][4] = " 4";
		tablero[0][5] = " 5";
		tablero[0][6] = " 6";
		tablero[0][7] = " 7";
		tablero[1][0] = " 1";
		tablero[1][1] = "  ";
		tablero[1][2] = "  ";
		tablero[1][3] = "  ";
		tablero[1][4] = "  ";
		tablero[1][5] = "  ";
		tablero[1][6] = "  ";
		tablero[1][7] = "  ";
		tablero[2][0] = " 2";
		tablero[2][1] = "  ";
		tablero[2][2] = "  ";
		tablero[2][3] = "  ";
		tablero[2][4] = "  ";
		tablero[2][5] = "  ";
		tablero[2][6] = "  ";
		tablero[2][7] = "  ";
		tablero[3][0] = " 3";
		tablero[3][1] = "  ";
		tablero[3][2] = "  ";
		tablero[3][3] = "  ";
		tablero[3][4] = "  ";
		tablero[3][5] = "  ";
		tablero[3][6] = "  ";
		tablero[3][7] = "  ";
		tablero[4][0] = " 4";
		tablero[4][1] = "  ";
		tablero[4][2] = "  ";
		tablero[4][3] = "  ";
		tablero[4][4] = "  ";
		tablero[4][5] = "  ";
		tablero[4][6] = "  ";
		tablero[4][7] = "  ";
		tablero[5][0] = " 5";
		tablero[5][1] = "  ";
		tablero[5][2] = "  ";
		tablero[5][3] = "  ";
		tablero[5][4] = "  ";
		tablero[5][5] = "  ";
		tablero[5][6] = "  ";
		tablero[5][7] = "  ";

		String tableroVisible[][] = new String[6][8];

		tableroVisible[0][0] = "**";
		tableroVisible[0][1] = " 1";
		tableroVisible[0][2] = " 2";
		tableroVisible[0][3] = " 3";
		tableroVisible[0][4] = " 4";
		tableroVisible[0][5] = " 5";
		tableroVisible[0][6] = " 6";
		tableroVisible[0][7] = " 7";
		tableroVisible[1][0] = " 1";
		tableroVisible[1][1] = "  ";
		tableroVisible[1][2] = "  ";
		tableroVisible[1][3] = "  ";
		tableroVisible[1][4] = "  ";
		tableroVisible[1][5] = "  ";
		tableroVisible[1][6] = "  ";
		tableroVisible[1][7] = "  ";
		tableroVisible[2][0] = " 2";
		tableroVisible[2][1] = "  ";
		tableroVisible[2][2] = "  ";
		tableroVisible[2][3] = "  ";
		tableroVisible[2][4] = "  ";
		tableroVisible[2][5] = "  ";
		tableroVisible[2][6] = "  ";
		tableroVisible[2][7] = "  ";
		tableroVisible[3][0] = " 3";
		tableroVisible[3][1] = "  ";
		tableroVisible[3][2] = "  ";
		tableroVisible[3][3] = "  ";
		tableroVisible[3][4] = "  ";
		tableroVisible[3][5] = "  ";
		tableroVisible[3][6] = "  ";
		tableroVisible[3][7] = "  ";
		tableroVisible[4][0] = " 4";
		tableroVisible[4][1] = "  ";
		tableroVisible[4][2] = "  ";
		tableroVisible[4][3] = "  ";
		tableroVisible[4][4] = "  ";
		tableroVisible[4][5] = "  ";
		tableroVisible[4][6] = "  ";
		tableroVisible[4][7] = "  ";
		tableroVisible[5][0] = " 5";
		tableroVisible[5][1] = "  ";
		tableroVisible[5][2] = "  ";
		tableroVisible[5][3] = "  ";
		tableroVisible[5][4] = "  ";
		tableroVisible[5][5] = "  ";
		tableroVisible[5][6] = "  ";
		tableroVisible[5][7] = "  ";

		for (int i = 0; i < 5; i++) {
			posa = (int) ((Math.random() * 5) + 1);
			posb = (int) ((Math.random() * 7) + 1);
			for (int x = 1; x < tablero.length; x++) {
				for (int y = 1; y < 8; y++) {

					tablero[posa][posb] = "MM";
				}
			}
		}

		do {

			imprimirTablero(tableroVisible);

			System.out.println("introduzca posicion X");
			Scanner sc = new Scanner(System.in);
			posx = sc.nextInt();

			System.out.println("Introduzca posicion Y");
			posy = sc.nextInt();

			if ((tablero[posx][posy]) == "  ") {
				tableroVisible[posx][posy] = "--";
				celdasVacias++;
			} else {
				tableroVisible[posx][posy] = "**";
				minas++;
			}

			imprimirTablero(tableroVisible);

			if (minas == 3) {
				System.out.println("Lo siento, ha perdido");
				juegoTerminado = true;
			}

			if (celdasVacias == 30) {
				System.out.println("Enhorabuena, ha ganado");
				juegoTerminado = true;
			}

		} while (!juegoTerminado);

	}

	static void imprimirTablero(String[][] tableroVisible) {
		for (int x = 0; x < tableroVisible.length; x++) {
			System.out.print("|");
			for (int y = 0; y < 8; y++) {

				System.out.print(tableroVisible[x][y]);
			}
			System.out.println("|");
		}
	}

}