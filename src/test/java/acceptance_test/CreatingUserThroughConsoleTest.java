package acceptance_test;

import org.junit.Before;
import org.junit.Test;
import user_creation.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CreatingUserThroughConsoleTest {
    private UserDataRetrieval userDataRetrieval;
    private Reporter reporter;
    private CreatingUser userCreator;
    private Console console;

    @Before
    public void setUp() throws Exception {
        console = mock(Console.class);
        userDataRetrieval = new ConsoleUserDataRetrieval(console);
        reporter = new ConsoleReporter(console);
        userCreator = new CreatingUser(userDataRetrieval, reporter, new ReverseEncryption());
    }

    @Test
    public void creating_user_with_valid_password() {
        String password = "12345678";
        when(console.readLine()).thenReturn(
            "pepe", "pepe lopes", password, password
        );

        userCreator.execute();

        verify(console).printLine("Enter a username");
        verify(console).printLine("Enter your full name");
        verify(console).printLine("Enter your password");
        verify(console).printLine("Re-enter your password");
        verify(console).printLine("Saving Details for User (pepe, pepe lopes, 87654321)\n");
    }

    @Test
    public void creating_user_using_a_password_that_is_to_short() {
        when(console.readLine()).thenReturn(
            "pepe", "pepe lopes", "1234567", "1234567"
        );

        userCreator.execute();

        verify(console).printLine("Enter a username");
        verify(console).printLine("Enter your full name");
        verify(console).printLine("Enter your password");
        verify(console).printLine("Re-enter your password");
        verify(console).printLine("Password must be at least 8 characters in length");
    }

    @Test
    public void creating_user_using_passwords_that_do_not_match() {
        when(console.readLine()).thenReturn(
            "pepe", "pepe lopes", "1234567", "xkofjsofis"
        );

        userCreator.execute();

        verify(console).printLine("Enter a username");
        verify(console).printLine("Enter your full name");
        verify(console).printLine("Enter your password");
        verify(console).printLine("Re-enter your password");
        verify(console).printLine("The passwords don't match");
    }

}
