package entregas.moraDaniel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Console {
    private static final String INTEGER_regExp = "-?\\d+";
    private BufferedReader input;

    public Console() {
        this.input = new BufferedReader(new InputStreamReader(System.in));
    }

    public int readInt() {
        return this.readInt("");
    }

    public int readInt(String title) {
        assert title != null;

        Pattern intPattern = Pattern.compile(INTEGER_regExp);
        int intInput = 0;
        boolean ok;
        do {
            String string = this.readString(title);
            ok = intPattern.matcher(string.trim()).matches();
            if (ok) {
                intInput = Integer.parseInt(string.trim());
            } else {
                this.writeError(intPattern.toString());
            }
        } while (!ok);
        return intInput;
    }

    public String readString() {
        return this.readString("");
    }

    public String readString(String title) {
        assert title != null;

        this.write(title);
        String string = "";
        try {
            string = this.input.readLine();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return string;
    }

    public void write(String string) {
        assert string != null;
        System.out.print(string);
    }

    public void writeln(String string) {
        this.write(string + "\n");
    }

    public void writeln() {
        this.writeln("");
    }

    private void writeError(String regExp) {
        System.out.println("Error de formato: se esperaba " + regExp);
    }
}
