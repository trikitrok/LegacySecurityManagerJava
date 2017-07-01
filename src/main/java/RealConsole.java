import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class RealConsole {
    public String readLine() throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        return buffer.readLine();
    }

    public void printLine(String line) {
        System.out.println(line);
    }
}
