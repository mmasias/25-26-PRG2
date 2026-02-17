import java.util.Scanner;

public class ExamenMina{

	static String[][] mapaMinasMostrar = {
		{" ", "1", "2", "3", "4", "5", "6", "7"},
		{"1", "-", "-", "-", "-", "-", "-", "-"},
		{"2", "-", "-", "-", "-", "-", "-", "-"},
		{"3", "-", "-", "-", "-", "-", "-", "-"},
		{"4", "-", "-", "-", "-", "-", "-", "-"},
		{"5", "-", "-", "-", "-", "-", "-", "-"}
	};
		
	static String[][] mapaMinasActivas = {
		{" ", "1", "2", "3", "4", "5", "6", "7"},
		{"1", "0", "0", "0", "0", "0", "0", "0"},
		{"2", "0", "0", "0", "0", "0", "0", "0"},
		{"3", "0", "0", "0", "0", "0", "0", "0"},
		{"4", "0", "0", "0", "0", "0", "0", "0"},
		{"5", "0", "0", "0", "0", "0", "0", "0"}
	};

	
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
	
		int posX=0, posY=0, valoresCorrectos, casillasLibres=0, contadorMinas=0;
		boolean juegoActivo = true;
		
		while(juegoActivo){
			for(int i = 0; i<mapaMinasMostrar.length; i++){            
				for (int j = 0; j<mapaMinasMostrar[i].length; j++) {                                     
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
				if(posX<1 || posX>5 || posY<1 || posY>7){
					System.out.println("Coordenadas fuera de rango.");
					valoresCorrectos=0;
				}
				else if(mapaMinasMostrar[posX][posY].equals(".") || mapaMinasMostrar[posX][posY].equals("*")){
					System.out.println("Casilla ya descubierta.");
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
				casillasLibres++;
				System.out.println("Libre!");
			}
			
			if(contadorMinas>=3){
				juegoActivo=false;
				System.out.println("Has perdido");
			}
			else if(casillasLibres>=30){
				System.out.println("Felicidades Ganador!");
				juegoActivo=false;
			}
		}
	}	
		
		
}