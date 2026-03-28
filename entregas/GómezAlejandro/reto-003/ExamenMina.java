import java.util.Scanner;

public class ExamenMina{

	static final int FILAS = 5;
	static final int COLUMNAS = 7;
	static final int MINAS = 5;
	static final int MAX_EXPLOSIONES = 3;

	static String[][] mapaMinasMostrar = new String[FILAS+1][COLUMNAS+1];
	static String[][] mapaMinasActivas = new String[FILAS+1][COLUMNAS+1];

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);

		for (int i = 1; i <= FILAS; i++){
			for (int j = 1; j <= COLUMNAS; j++){
				mapaMinasMostrar[i][j] = "-";
				mapaMinasActivas[i][j] = "0";
			}
		}

		int minasColocadas = 0;
		while (minasColocadas < MINAS){
			int x = (int)(Math.random()*FILAS + 1);
			int y = (int)(Math.random()*COLUMNAS + 1);

			if (mapaMinasActivas[x][y].equals("0")){
				mapaMinasActivas[x][y] = "1";
				minasColocadas++;
			}
		}

		int posX = 0, posY = 0;
		int contadorMinas = 0;
		int casillasSeguras = 0;
		boolean juegoEncendido = true;

		while (juegoEncendido){
			for (int i = 1; i <= FILAS; i++){
				for (int j = 1; j <= COLUMNAS; j++){
					System.out.print(mapaMinasMostrar[i][j] + " ");
				}
				System.out.println();
			}

			boolean valoresCorrectos = false;
			while (!valoresCorrectos){
				posY = scan.nextInt();
				posX = scan.nextInt();

				if (posX >= 1 && posX <= FILAS && posY >= 1 && posY <= COLUMNAS &&
					mapaMinasMostrar[posX][posY].equals("-")){
					valoresCorrectos = true;
				}
			}

			if (mapaMinasActivas[posX][posY].equals("1")){
				mapaMinasMostrar[posX][posY] = "x";
				contadorMinas++;
			} else {
				mapaMinasMostrar[posX][posY] = ".";
				casillasSeguras++;
			}

			if (contadorMinas >= MAX_EXPLOSIONES){
				juegoEncendido = false;
			} else if (casillasSeguras >= FILAS*COLUMNAS - MINAS){
				juegoEncendido = false;
			}
		}
	}
}
