package user_creation;

public class CreatingUser {
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private final EncryptionAlgorithm encryptionAlgorithm;
    private UserDataRetrieval userDataRetrieval;
    private Reporter reporter;

    public CreatingUser(
        UserDataRetrieval userDataRetrieval,
        Reporter reporter,
        EncryptionAlgorithm encryptionAlgorithm
    ) {
        this.userDataRetrieval = userDataRetrieval;
        this.reporter = reporter;
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public void execute() {
        UserData userData = userDataRetrieval.invoke();

        if (!userData.passwordsMatch()) {
            reporter.reportError("The passwords don't match");
            return;
        }

        if (isPasswordTooShort(userData)) {
            reporter.reportError("Password must be at least 8 characters in length");
            return;
        }

        String encryptedPassword = encryptionAlgorithm.encrypt(userData.password());

        reporter.reportSuccessCreatingUser(
            composeMessage(userData, encryptedPassword)
        );
    }

    private boolean isPasswordTooShort(UserData userData) {
        return userData.passwordLength() < MINIMUM_PASSWORD_LENGTH;
    }

    private String composeMessage(UserData userData, String encryptedPassword) {
        return new UserCreationSuccessMessage(userData, encryptedPassword).compose();
    }
}
