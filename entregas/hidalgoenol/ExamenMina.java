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
		
		int i=0;	

		while ( i < 5){

			int PosYMina = (int)(Math.random()*7+1);
			int PosXMina = (int)(Math.random()*5+1);

			if (mapaMinasActivas[PosXMina][PosYMina].equals("1")){

				i=i-1;
			}
			else {

				mapaMinasActivas[PosXMina][PosYMina] = "1";
			}

			i++;
		}
	
		int posX=0, posY=0, juegoEncendido=1, valoresCorrectos, contadorMapa=0, contadorMinas=0;

        while(juegoEncendido==1){

			for( i = 0; i<mapaMinasMostrar.length; i++){            

				for (int j = 0; j<=mapaMinasMostrar.length+1; j++) {                                     

					System.out.print(mapaMinasMostrar[i][j]);
				}

				System.out.println(" ");
			}

			valoresCorrectos=0;

			while(valoresCorrectos==0){

				System.out.println(" ");
				System.out.println("Ingrese X");
				posX = scan.nextInt();

				System.out.println("Ingrese Y");
				posY = scan.nextInt();

				if(posX < 1 || posX > 5 || posY < 1 || posY > 7){
    				System.out.println("Coordenadas incorrectas");
    				valoresCorrectos = 0;
				}
				else{
    				valoresCorrectos = 1;
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

			else{

				System.out.println("No es correcta esa opcion.");
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
		}
	}	
}
