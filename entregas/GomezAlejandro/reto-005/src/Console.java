import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Console {

    private static final String INTEGER = "-?\\d+";
    private static final String DOUBLE = "-?(\\d+(\\.\\d+)?([eE][+-]?\\d+)?|\\.\\d+([eE][+-]?\\d+)?)";
    private static final String CHAR = ".";

    private BufferedReader input;

    public Console() {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readString() {
        return readString("");
    }

    public String readString(String title) {
        System.out.print(title);
        String s = "";
        try {
            s = input.readLine();
        } catch (Exception e) {
        }
        return s;
    }

    public char readChar() {
        return readChar("");
    }

    public char readChar(String title) {
        Pattern p = Pattern.compile(CHAR);
        char c = ' ';
        boolean ok;
        do {
            String s = readString(title);
            ok = p.matcher(s).find();
            if (ok) {
                c = s.charAt(0);
            }
        } while (!ok);
        return c;
    }

    public int readInt() {
        return readInt("");
    }

    public int readInt(String title) {
        Pattern p = Pattern.compile(INTEGER);
        int n = 0;
        boolean ok;
        do {
            String s = readString(title);
            ok = p.matcher(s.trim()).matches();
            if (ok) {
                n = Integer.parseInt(s.trim());
            }
        } while (!ok);
        return n;
    }

    public double readDouble() {
        return readDouble("");
    }

    public double readDouble(String title) {
        Pattern p = Pattern.compile(DOUBLE);
        double d = 0;
        boolean ok;
        do {
            String s = readString(title);
            ok = p.matcher(s.trim()).matches();
            if (ok) {
                d = Double.parseDouble(s.trim());
            }
        } while (!ok);
        return d;
    }

    public void write(String s) {
        System.out.print(s);
    }

    public void writeln(String s) {
        System.out.println(s);
    }

    public void writeln() {
        System.out.println();
    }

    public void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
        }
    }

    public void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
