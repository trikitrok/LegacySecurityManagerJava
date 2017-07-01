class UserCreator {
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private UserDataRetrieval userDataRetrieval;
    private Reporter reporter;

    public UserCreator(UserDataRetrieval userDataRetrieval, Reporter reporter) {
        this.userDataRetrieval = userDataRetrieval;
        this.reporter = reporter;
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

        // Encrypt the password (just reverse it, should be secure)
        String encryptedPassword = new StringBuilder(userData.password()).reverse().toString();

        reporter.reportSuccessCreatingUser(userData, encryptedPassword);
    }
}
