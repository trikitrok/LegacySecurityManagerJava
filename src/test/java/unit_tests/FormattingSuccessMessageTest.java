package unit_tests;

import org.junit.Test;
import user_creation.UserCreationSuccessMessage;
import user_creation.UserData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FormattingSuccessMessageTest {
    @Test
    public void creating_user_with_valid_password() {
        String notUsed = "";
        String encryptedPassword = "87654321";
        UserData userData = new UserData("pepe", "pepe lopes", notUsed, notUsed);
        UserCreationSuccessMessage messag = new UserCreationSuccessMessage(userData,encryptedPassword);

        assertThat(
            messag.compose(),
            is("Saving Details for User (pepe, pepe lopes, 87654321)\n")
        );
    }
}
