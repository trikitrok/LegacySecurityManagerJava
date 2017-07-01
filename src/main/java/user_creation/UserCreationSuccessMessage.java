package user_creation;

public class UserCreationSuccessMessage {
    private final UserData userData;
    private final String encryptedPassword;

    public UserCreationSuccessMessage(UserData userData, String encryptedPassword) {
        this.userData = userData;
        this.encryptedPassword = encryptedPassword;
    }

    public String compose() {
        return String.format(
            "Saving Details for User (%s, %s, %s)\n",
            userData.username(),
            userData.fullName(),
            encryptedPassword
        );
    }
}
