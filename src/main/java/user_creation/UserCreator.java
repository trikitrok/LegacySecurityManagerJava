package user_creation;

public class UserCreator {
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private final EncryptionAlgorithm encryptionAlgorithm;
    private UserDataRetrieval userDataRetrieval;
    private Reporter reporter;

    public UserCreator(UserDataRetrieval userDataRetrieval, Reporter reporter, EncryptionAlgorithm encryptionAlgorithm) {
        this.userDataRetrieval = userDataRetrieval;
        this.reporter = reporter;
        this.encryptionAlgorithm = encryptionAlgorithm;
    }

    public void createUser() {
        UserData userData = userDataRetrieval.invoke();

        if (!userData.passwordsMatch()) {
            reporter.reportError("The passwords don't match");
            return;
        }

        if (userData.passwordLength() < MINIMUM_PASSWORD_LENGTH) {
            reporter.reportError("Password must be at least 8 characters in length");
            return;
        }

        String encryptedPassword = encryptionAlgorithm.encrypt(userData.password());

        reporter.reportSuccessCreatingUser(userData, encryptedPassword);
    }
}
