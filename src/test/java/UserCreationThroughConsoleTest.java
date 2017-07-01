import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class UserCreationThroughConsoleTest {

    @Test
    public void creating_user_with_valid_password() {
        FakeConsole console = new FakeConsole(
            "pepe", "pepe lopes", "12345678", "12345678"
        );
        UserCreator userCreator = new UserCreator(console);

        userCreator.createUser();

        assertThat(
            console.lastPrintedLine(),
            is("Saving Details for User (pepe, pepe lopes, 87654321)\n"));
    }

    @Test
    public void creating_user_using_a_password_that_is_to_short() {
        FakeConsole console = new FakeConsole(
            "pepe", "pepe lopes", "1234567", "1234567"
        );
        UserCreator userCreator = new UserCreator(console);

        userCreator.createUser();

        assertThat(
            console.lastPrintedLine(),
            is("Password must be at least 8 characters in length"));
    }

    @Test
    public void creating_user_using_passwords_that_do_not_match() {
        FakeConsole console = new FakeConsole(
            "pepe", "pepe lopes", "1234567", "xkofjsofis"
        );
        UserCreator userCreator = new UserCreator(console);

        userCreator.createUser();

        assertThat(
            console.lastPrintedLine(),
            is("The passwords don't match"));
    }

    private class FakeConsole implements Console {
        private final List<String> userInputs;
        private int linesReadNumber;
        private List<String> printedLines;

        public FakeConsole(String ... userInputs) {
            printedLines = new ArrayList<>();
            this.userInputs = Arrays.asList(userInputs);
            linesReadNumber = 0;
        }

        public String readLine()  {
            String line = userInputs.get(linesReadNumber);
            linesReadNumber++;
            return line;
        }

        public void printLine(String line) {
            printedLines.add(line);
        }

        public String lastPrintedLine() {
            return printedLines.get(printedLines.size() - 1);
        }
    }
}
