import java.util.Scanner;

public class ExamenMina{

	static String[][] mapaMinasMostrar = {	
			{" ",	"1", 	"2", 	"3", 	"4",	"5",	"6", 	"7"},
			{"1", 	"-", 	"-", 	"-", 	"-", 	"-", 	"-",	"-"},
			{"2", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"3", 	"-", 	"-", 	"-",	"-", 	"-", 	"-",	"-"},
			{"4", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"},
			{"5", 	"-", 	"-",	"-", 	"-", 	"-", 	"-",	"-"}
		};
		
	static String[][] mapaMinasActivas = {	
			{" ",	" ", 	" ", 	" ", 	" ",	" ",	" ", 	" "},
			{" ", 	"0", 	"0", 	"0", 	"0", 	"0", 	"0",	"0"},
			{" ", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{" ", 	"0", 	"0", 	"0",	"0", 	"0", 	"0",	"0"},
			{" ", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"},
			{" ", 	"0", 	"0",	"0", 	"0", 	"0", 	"0",	"0"}
		};

	public static void main(String[] args){	
	Scanner scan = new Scanner(System.in);
		int cantidadMinas=0;	
		while ( cantidadMinas < 5){
			int PosYMina = (int)(Math.random()*2+1);
			int PosXMina = (int)(Math.random()*4+1);
			if (mapaMinasActivas[PosXMina][PosYMina]!="1"){
				mapaMinasActivas[PosXMina][PosYMina]="1";
				cantidadMinas++;
			}
		}
	
		int posX=0, posY=0, juegoEncendido=1, contadorMapa=0, contadorMinas=0;
		while(juegoEncendido==1){
			for( int i = 0; i<mapaMinasMostrar.length; i++){            
				for (int j = 0; j<=mapaMinasMostrar.length+1; j++) {                                     
					System.out.print(mapaMinasMostrar[i][j]);
				}
				System.out.println(" ");
			}
			
			ElegirPosición(scan, posX, posY);

			if(mapaMinasActivas[posX][posY]=="1"){
			mapaMinasMostrar[posX][posY]="x";
			contadorMinas++;
			}
			else if(mapaMinasActivas[posX][posY]=="0"){
			mapaMinasMostrar[posX][posY]=".";
			}
			else{
			System.out.println("No es correcta esa opcion.");
			}
			
			contadorMapa++;
			if(contadorMinas>3){
				juegoEncendido=0;
				System.out.println("Has perdido");
			}
			else if(contadorMapa>=30){
				System.out.println("Felicidades Ganador!");
				juegoEncendido=0;
			}
		}
		scan.close();
	}	
		
	static void ElegirPosición(Scanner scan, int posX, int posY){
		boolean valoresCorrectos=true;
			while(valoresCorrectos==true){
				System.out.println(" ");
				System.out.println("Ingrese X");
				posY = scan.nextInt();
				System.out.println("Ingrese Y");
				posX = scan.nextInt();
				if(posX>5){
					valoresCorrectos=false;
				}
				else if(posY>7){
					valoresCorrectos=false;
				}
				else{
					valoresCorrectos=true;
				}
			}
	}
	
}