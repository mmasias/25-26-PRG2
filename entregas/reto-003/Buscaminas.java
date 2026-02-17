import java.util.Scanner;
import java.util.Random;

public class Buscaminas {

    static final int FILAS       = 5;
    static final int COLUMNAS    = 7;
    static final int TOTAL_MINAS = 5;
    static final int MAX_EXPLOSIONES = 3;

    static char[][]    tablero    = new char[FILAS][COLUMNAS];
    static boolean[][] minas      = new boolean[FILAS][COLUMNAS];
    static int         explosiones   = 0;
    static int         casillasLibres = 0;
