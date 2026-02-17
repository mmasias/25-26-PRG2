import java.util.Scanner;

public class ExamenMina{

	static String[][] mapaMinasMostrar = 	
		{
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"-", 	"-", 	"-", 	"-", 	"-", 	"-",	"-"},
			{"2", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"3", 	"-", 	"-", 	"-",	"-", 	"-", 	"-",	"-"},
			{"4", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"5", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"}
		};
		
	static String[][] mapaMinasActivas = 	
		{
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"0", 	"0", 	"0", 	"0", 	"0", 	"0",	"0"},
			{"2", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"3", 	"0", 	"0", 	"0",	"0", 	"0", 	"0",	"0"},
			{"4", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{"5", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"}
		};

	public static void main(String[] args){	
	Scanner scan = new Scanner(System.in);

		// generar minas
		int i=0;	
		while (i < 5){
			int PosXMina = (int)(Math.random()*5 + 1);
			int PosYMina = (int)(Math.random()*7 + 1);

			if (mapaMinasActivas[PosXMina][PosYMina].equals("1")){
				continue;
			}

			mapaMinasActivas[PosXMina][PosYMina] = "1";
			i++;
		}
	
		int posX=0, posY=0, juegoEncendido=1, valoresCorrectos;
		int contadorMinas=0;
		int casillasDescubiertas=0;

		while(juegoEncendido==1){

			for( i = 0; i<mapaMinasMostrar.length; i++){            
				for (int j = 0; j<mapaMinasMostrar[i].length; j++) {                                     
					System.out.print(mapaMinasMostrar[i][j] + " ");
				}
				System.out.println();
			}

			valoresCorrectos=0;
			while(valoresCorrectos==0){
				System.out.println(" ");

				System.out.println("Ingrese FILA (1-5)");
				posX = scan.nextInt();

				System.out.println("Ingrese COLUMNA (1-7)");
				posY = scan.nextInt();

				if(posX>5 || posX<1){
					valoresCorrectos=0;
				}
				else if(posY>7 || posY<1){
					valoresCorrectos=0;
				}
				else{
					valoresCorrectos=1;
				}
			}

			// SI HAY MINA
			if(mapaMinasActivas[posX][posY].equals("1")){
				if(!mapaMinasMostrar[posX][posY].equals("x")){
					mapaMinasMostrar[posX][posY]="x";
					contadorMinas++;
				}
			}

			// SI ES CASILLA SEGURA
			else{
				if(mapaMinasMostrar[posX][posY].equals("-")){
					mapaMinasMostrar[posX][posY]=".";
					casillasDescubiertas++;
				}
			}

			// DERROTA
			if(contadorMinas>=3){
				juegoEncendido=0;
				System.out.println("Has perdido");
			}

			// VICTORIA REAL
			else if(casillasDescubiertas==30){
				System.out.println("Felicidades Ganador!");
				juegoEncendido=0;
			}
		}
	}	
}
