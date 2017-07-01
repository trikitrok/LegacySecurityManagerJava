import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserCreationThroughConsoleTest {

    @Test
    public void creating_user_with_valid_password() {
        FakeConsole console = new FakeConsole(
            "pepe", "pepe lopes", "12345678", "12345678"
        );
        UserDataRetrieval userDataRetrieval = mock(UserDataRetrieval.class);
        UserCreator userCreator = new UserCreator(userDataRetrieval, new ConsoleReporter(console));
        when(userDataRetrieval.invoke()).thenReturn(
            new UserData("pepe", "pepe lopes", "12345678", "12345678")
        );

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
        UserDataRetrieval userDataRetrieval = mock(UserDataRetrieval.class);
        UserCreator userCreator = new UserCreator(userDataRetrieval, new ConsoleReporter(console));
        when(userDataRetrieval.invoke()).thenReturn(
            new UserData("pepe", "pepe lopes", "1234567", "1234567")
        );

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
        UserDataRetrieval userDataRetrieval = mock(UserDataRetrieval.class);
        UserCreator userCreator = new UserCreator(userDataRetrieval, new ConsoleReporter(console));
        when(userDataRetrieval.invoke()).thenReturn(
            new UserData("pepe", "pepe lopes", "1234567", "xkofjsofis")
        );

        userCreator.createUser();

        assertThat(
            console.lastPrintedLine(),
            is("The passwords don't match"));
    }

}
