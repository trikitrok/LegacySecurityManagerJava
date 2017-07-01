package user_creation;

import user_creation.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RealConsole implements Console {
    public String readLine() {
        try {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            return buffer.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printLine(String line) {
        System.out.println(line);
    }
}
