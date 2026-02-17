import java.util.Scanner;

public class ExamenMina{

	static String[][] mapaMinasMostrar = 	
		{ //[0][0]	[0][1]	[0][2]	[0][3]	[0][4]	[0][5]	[0][6]	[0][7]
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
		  //[1][0]	[1][1]	[1][2]	[1][3]	[1][4]	[1][5]	[1][6]	[1][7]
			{"1", 	"-", 	"-", 	"-", 	"-", 	"-", 	"-",	"-"},
		  //[2][0]	[2][1]	[2][2]	[2][3]	[2][4]	[2][5]	[2][6]	[2][7]
			{"2", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
		  //[3][0]	[3][1]	[3][2]	[3][3]	[3][4]	[3][5]	[3][6]	[3][7]
			{"3", 	"-", 	"-", 	"-",	"-", 	"-", 	"-",	"-"},
		  //[4][0]	[4][1]	[4][2]	[4][3]	[4][4]	[4][5]	[4][6]	[4][7]
			{"4", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
		  //[5][0]	[5][1]	[5][2]	[5][3]	[5][4]	[5][5]	[5][6]	[5][7]
			{"5", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"}
		};
		
	static String[][] mapaMinasActivas = 	
		{ //[0][0]	[0][1]	[0][2]	[0][3]	[0][4]	[0][5]	[0][6]	[0][7]
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
		  //[1][0]	[1][1]	[1][2]	[1][3]	[1][4]	[1][5]	[1][6]	[1][7]
			{"1", 	"0", 	"0", 	"0", 	"0", 	"0", 	"0",	"0"},
		  //[2][0]	[2][1]	[2][2]	[2][3]	[2][4]	[2][5]	[2][6]	[2][7]
			{"2", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
		  //[3][0]	[3][1]	[3][2]	[3][3]	[3][4]	[3][5]	[3][6]	[3][7]
			{"3", 	"0", 	"0", 	"0",	"0", 	"0", 	"0",	"0"},
		  //[4][0]	[4][1]	[4][2]	[4][3]	[4][4]	[4][5]	[4][6]	[4][7]
			{"4", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
		  //[5][0]	[5][1]	[5][2]	[5][3]	[5][4]	[5][5]	[5][6]	[5][7]
			{"5", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"}
		};

	//Posiciones Random de la mina
	public static void main(String[] args){	
	Scanner scan = new Scanner(System.in);

		int minasColocadas = 0;
		while (minasColocadas < 5){
			int fila = (int)(Math.random()*5+1);
			int columna = (int)(Math.random()*7+1);
			if (!mapaMinasActivas[fila][columna].equals("1")){
				mapaMinasActivas[fila][columna]="1";
				minasColocadas++;
			}
		}
	
		int posX=0, posY=0, juegoEncendido=1, valoresCorrectos, contadorMapa=0, contadorMinas=0;
		/////////////Comienza el juego
		while(juegoEncendido==1){
			for( i = 0; i<mapaMinasMostrar.length; i++){            
				for (int j = 0; j<mapaMinasMostrar[i].length; j++) {                                     
					System.out.print(mapaMinasMostrar[i][j]);
				}
				System.out.println(" ");
			}
			valoresCorrectos=0;//reseteo de la variable
			while(valoresCorrectos==0){
				System.out.println(" ");
				System.out.println("Ingrese X");
			posX = scan.nextInt();
			System.out.println("Ingrese Y");
			posY = scan.nextInt();
				if(posX>5){
					valoresCorrectos=0;
				}
				else if(posY>7){
					valoresCorrectos=0;
				}
				else{
					valoresCorrectos=1;
				}
			}

			if(mapaMinasActivas[posX][posY].equals("1")){
				mapaMinasMostrar[posX][posY]="*";
				contadorMinas++;
				System.out.println("Mina!");
			}
			else if(mapaMinasActivas[posX][posY].equals("0")){
				mapaMinasMostrar[posX][posY]=".";
				System.out.println("Libre!");
			}
			
			contadorMapa++;
			if(contadorMinas>2){
				juegoEncendido=0;
				System.out.println("Has perdido");
			}
			else if(contadorMapa>=31){
				System.out.println("Felicidades Ganador!");
				juegoEncendido=0;
			}
			else{
				
			}
		}
	}	
		
		
}