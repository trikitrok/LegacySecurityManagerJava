package unit_tests;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import user_creation.Console;
import user_creation.ConsoleUserDataRetrieval;
import user_creation.UserData;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RetrievingUserDataThoroughConsoleTest {
    @Test
    public void retrieving_user_data_through_the_console() {
        Console console = mock(Console.class);
        ConsoleUserDataRetrieval userDataRetrieval = new ConsoleUserDataRetrieval(console);
        when(console.readLine()).thenReturn(
            "pepe", "pepe lopes", "12345678", "12345678"
        );

        UserData userData = userDataRetrieval.invoke();

        assertThat(userData, CoreMatchers.is(new UserData("pepe", "pepe lopes", "12345678", "12345678")));
        verify(console).printLine("Enter a username");
        verify(console).printLine("Enter your full name");
        verify(console).printLine("Enter your password");
        verify(console).printLine("Re-enter your password");
    }

}
