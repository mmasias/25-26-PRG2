import java.util.Scanner;
public class buscaminas{
	public static void main(String[] args){
	
	int minas=0;
	int celdasVacias=0;
	int posa=0;
	int posb=0;
	int posc=0;
	int posd=0;
	int posx=0;
	int posy=0;
	boolean salida=false;
	
	String tablero [][] = new String [6][8];
	
	tablero[0][0]= "**";	tablero[0][1]= " 1";	tablero[0][2]= " 2";	tablero[0][3]= " 3";	tablero[0][4]= " 4";	tablero[0][5]= " 5";	tablero[0][6]= " 6";	tablero[0][7]= " 7";
	tablero[1][0]= " 1";	tablero[1][1]= "  ";	tablero[1][2]= "  ";	tablero[1][3]= "  ";	tablero[1][4]= "  ";	tablero[1][5]= "  ";	tablero[1][6]= "  ";	tablero[1][7]= "  ";
	tablero[2][0]= " 2";	tablero[2][1]= "  ";	tablero[2][2]= "  ";	tablero[2][3]= "  ";	tablero[2][4]= "  ";	tablero[2][5]= "  ";	tablero[2][6]= "  ";	tablero[2][7]= "  ";
	tablero[3][0]= " 3";	tablero[3][1]= "  ";	tablero[3][2]= "  ";	tablero[3][3]= "  ";	tablero[3][4]= "  ";	tablero[3][5]= "  ";	tablero[3][6]= "  ";	tablero[3][7]= "  ";
	tablero[4][0]= " 4";	tablero[4][1]= "  ";	tablero[4][2]= "  ";	tablero[4][3]= "  ";	tablero[4][4]= "  ";	tablero[4][5]= "  ";	tablero[4][6]= "  ";	tablero[4][7]= "  ";
	tablero[5][0]= " 5";	tablero[5][1]= "  ";	tablero[5][2]= "  ";	tablero[5][3]= "  ";	tablero[5][4]= "  ";	tablero[5][5]= "  ";	tablero[5][6]= "  ";	tablero[5][7]= "  ";
	
	
	
	String tablero2 [][] = new String[6][8];
	
	tablero2[0][0]= "**";	tablero2[0][1]= " 1";	tablero2[0][2]= " 2";	tablero2[0][3]= " 3";	tablero2[0][4]= " 4";	tablero2[0][5]= " 5";	tablero2[0][6]= " 6";	tablero2[0][7]= " 7";
	tablero2[1][0]= " 1";	tablero2[1][1]= "  ";	tablero2[1][2]= "  ";	tablero2[1][3]= "  ";	tablero2[1][4]= "  ";	tablero2[1][5]= "  ";	tablero2[1][6]= "  ";	tablero2[1][7]= "  ";
	tablero2[2][0]= " 2";	tablero2[2][1]= "  ";	tablero2[2][2]= "  ";	tablero2[2][3]= "  ";	tablero2[2][4]= "  ";	tablero2[2][5]= "  ";	tablero2[2][6]= "  ";	tablero2[2][7]= "  ";
	tablero2[3][0]= " 3";	tablero2[3][1]= "  ";	tablero2[3][2]= "  ";	tablero2[3][3]= "  ";	tablero2[3][4]= "  ";	tablero2[3][5]= "  ";	tablero2[3][6]= "  ";	tablero2[3][7]= "  ";
	tablero2[4][0]= " 4";	tablero2[4][1]= "  ";	tablero2[4][2]= "  ";	tablero2[4][3]= "  ";	tablero2[4][4]= "  ";	tablero2[4][5]= "  ";	tablero2[4][6]= "  ";	tablero2[4][7]= "  ";	
	tablero2[5][0]= " 5";	tablero2[5][1]= "  ";	tablero2[5][2]= "  ";	tablero2[5][3]= "  ";	tablero2[5][4]= "  ";	tablero2[5][5]= "  ";	tablero2[5][6]= "  ";	tablero2[5][7]= "  ";			
		
	
	
	//He tenido problemas al hacerlo con un bucle y al no encontrar la solucion he preferido hacerlo asi aun sabiendo que es mas costoso
		posa=(int)((Math.random()*5)+1);
		posb=(int)((Math.random()*7)+1);
		for (int x=1; x < tablero.length; x++) {
			for (int y=1; y < 8; y++){
							
				tablero[posa][posb]="MM";
			}
		}
		
		posa=(int)((Math.random()*5)+1);
		posb=(int)((Math.random()*7)+1);
		for (int x=1; x < tablero.length; x++) {
			for (int y=1; y < 8; y++){
							
				tablero[posa][posb]="MM";
			}
		}
		
		posa=(int)((Math.random()*5)+1);
		posb=(int)((Math.random()*7)+1);
		for (int x=1; x < tablero.length; x++) {
			for (int y=1; y < 8; y++){
							
				tablero[posa][posb]="MM";
			}
		}
		
		posa=(int)((Math.random()*5)+1);
		posb=(int)((Math.random()*7)+1);
		for (int x=1; x < tablero.length; x++) {
			for (int y=1; y < 8; y++){
							
				tablero[posa][posb]="MM";
			}
		}
		posa=(int)((Math.random()*5)+1);
		posb=(int)((Math.random()*7)+1);
		for (int x=1; x < tablero.length; x++) {
			for (int y=1; y < 8; y++){
							
				tablero[posa][posb]="MM";
			}
		}
		
		
		
	while(!salida){
		
	for (int x=0; x < tablero2.length; x++) {
		System.out.print("|");
		for (int y=0; y < 8; y++){
	
			System.out.print (tablero2[x][y]);
		}
		System.out.println("|");
	}
	

		
	
	
	
	System.out.println("introduzca posicion X");
	Scanner sc=new Scanner(System.in);
	posx=sc.nextInt();
	
	System.out.println("Introduzca posicion Y");
	Scanner sc2=new Scanner(System.in);
	posy=sc.nextInt();
	
	
	if ((tablero[posx][posy])=="  "){
		tablero2[posx][posy]= "--";
		celdasVacias++;
	}
	else{
		tablero2[posx][posy]= "**";
		minas++;
	}
	
	
	for (int x=0; x < tablero2.length; x++) {
		System.out.print("|");
		for (int y=0; y < 8; y++){
	
			System.out.print (tablero2[x][y]);
		}
		System.out.println("|");
	}

		
		if (minas==3){
		System.out.println("Lo siento, ha perdido");
		salida=true;
		}
		
		if (celdasVacias==30){
			System.out.println("Enhorabuena, ha ganado");
			salida=true;
		}
	
	}
		
	}
}