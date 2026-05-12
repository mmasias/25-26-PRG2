package entregas.bolivarMarcos.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    private static final String INTEGER_regExp = "-?\\d+";
    private static final String DOUBLE_regExp = "-?(\\d+(\\.\\d+)?([eE][+-]?\\d+)?|\\.\\d+([eE][+-]?\\d+)?)";
    private static final String CHAR_regExp = ".";

    private BufferedReader input;

    public Console() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
    }
}
