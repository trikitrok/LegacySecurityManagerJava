import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ReportingThroughConsoleTest {
    private Console console;
    private Reporter reporter;

    @Before
    public void setUp() throws Exception {
        console = mock(Console.class);
        reporter = new ConsoleReporter(console);
    }

    @Test
    public void creating_user_with_valid_password() {
        String password = "12345678";
        String encryptedPassword = "87654321";
        UserData userData = new UserData("pepe", "pepe lopes", password, password);

        reporter.reportSuccessCreatingUser(userData, encryptedPassword);

        verify(console).printLine("Saving Details for User (pepe, pepe lopes, 87654321)\n");
    }

    @Test
    public void creating_user_using_a_password_that_is_to_short() {
        String someDescription = "whatever";
        reporter.reportError(someDescription);

        verify(console).printLine(someDescription);
    }
}
