import java.util.Scanner;

public class ExamenMina{

	static final int FILAS = 5;
	static final int COLUMNAS = 7;
	static final int NUM_MINAS = 5;

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

		colocarMinas();
	
		int posX=0, posY=0;
		int juegoActivo=1;
		int inputValido;
		int casillasDescubiertas=0;
		int minasEncontradas=0;

		while(juegoActivo==1){

			mostrarMapa();

			inputValido=0;
			while(inputValido==0){
				System.out.println(" ");
				System.out.println("Ingrese fila (1-5)");
				posX = scan.nextInt();
				System.out.println("Ingrese columna (1-7)");
				posY = scan.nextInt();

				if(posX>=1 && posX<=FILAS && posY>=1 && posY<=COLUMNAS){
					inputValido=1;
				}else{
					System.out.println("Coordenadas fuera de rango");
				}
			}

			if(mapaMinasActivas[posX][posY].equals("1")){
				mapaMinasMostrar[posX][posY]="x";
				minasEncontradas++;
			}
			else if(mapaMinasActivas[posX][posY].equals("0")){
				mapaMinasMostrar[posX][posY]=".";
			}
			else{
				System.out.println("No es correcta esa opcion.");
			}
			
			casillasDescubiertas++;

			if(minasEncontradas>2){
				juegoActivo=0;
				System.out.println("Has perdido");
			}
			else if(casillasDescubiertas>=31){
				System.out.println("Felicidades Ganador!");
				juegoActivo=0;
			}
		}
	}

	public static void colocarMinas(){
		int i=0;	
		while ( i < NUM_MINAS){

			int PosXMina = (int)(Math.random()*FILAS+1);
			int PosYMina = (int)(Math.random()*COLUMNAS+1);

			if (mapaMinasActivas[PosXMina][PosYMina].equals("1")){
				i=i-1;
			}
			else {
				mapaMinasActivas[PosXMina][PosYMina]="1";
			}
			i++;
		}
	}

	public static void mostrarMapa(){
		for(int i = 0; i<mapaMinasMostrar.length; i++){            
			for (int j = 0; j < mapaMinasMostrar[i].length; j++) {                                     
				System.out.print(mapaMinasMostrar[i][j]);
			}
			System.out.println(" ");
		}
	}
}




