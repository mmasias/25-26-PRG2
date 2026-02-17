import java.util.Scanner;

public class ExamenMina{
	static final int FILAS = 5;
    static final int COLUMNAS = 7;
    static final int TOTAL_MINAS = 5;
    static final int MAX_EXPLOSIONES = 3;
	static final int CASILLAS_PARA_GANAR = (FILAS * COLUMNAS) - TOTAL_MINAS;
	static String[][] mapaMinasMostrar; 
    static String[][] mapaMinasActivas;

	public static void main(String[] args){	
	Scanner scan = new Scanner(System.in);
	mapaMinasMostrar = inicializarMapa("-");
    mapaMinasActivas = inicializarMapa("0");

	colocarMinas();
	int juegoEncendido = 1, contadorMapa = 0, contadorMinas = 0;
	while(juegoEncendido==1){
		dibujarTablero();
		valoresCorrectos = 0;
		while(valoresCorrectos==0){
			dibujarTablero();
			System.out.println("Ingrese X (1-7)");
			posY = scan.nextInt();
			System.out.println("Ingrese Y (1-5)");
			posX = scan.nextInt();
			if (posX >= 1 && posX <= FILAS && posY >= 1 && posY <= COLUMNAS) {
				valoresCorrectos=1;
			}
			else{
				System.out.println("Coordenadas fuera de rango");
			}
		}
		if(mapaMinasActivas[posX][posY]=="1"){
		mapaMinasMostrar[posX][posY]="*";
		contadorMinas++;
		System.out.println("Mina!");
		}
		else{
		mapaMinasMostrar[posX][posY]=".";
		System.out.println("Libre.");
		}
		
		contadorMapa++;
		if(contadorMinas >= MAX_EXPLOSIONES){
			juegoEncendido=0;
			dibujarTablero();
			System.out.println("Has perdido: " + contadorMinas + " explosiones.");
		}
		else if(contadorMapa >= 31){
			System.out.println("Felicidades Ganador!");
			juegoEncendido=0;
		}
		}
	}	
	static void colocarMinas() {
        int i = 0;
        while (i < TOTAL_MINAS) {
            int filaRandom = (int)(Math.random() * FILAS + 1);
            int colRandom = (int)(Math.random() * COLUMNAS + 1);
            if (mapaMinasActivas[filaRandom][colRandom].equals("0")) {
                mapaMinasActivas[filaRandom][colRandom] = "1";
                i++;
            }
        }
    }

    static void dibujarTablero() {
        System.out.println("\n  1 2 3 4 5 6 7");
        for (int i = 1; i <= FILAS; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= COLUMNAS; j++) {
                System.out.print(mapaMinasMostrar[i][j] + " ");
            }
            System.out.println();
        }
    }
	
	static String[][] inicializarMapa(String simbolo) {
        String[][] matriz = new String[FILAS + 1][COLUMNAS + 1];
        for (int i = 1; i <= FILAS; i++) {
            for (int j = 1; j <= COLUMNAS; j++) {
                matriz[i][j] = simbolo;
            }
        }
        return matriz;
    }	
}