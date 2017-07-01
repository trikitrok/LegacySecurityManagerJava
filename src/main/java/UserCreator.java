class UserCreator {
    private static final int MINIMUM_PASSWORD_LENGTH = 8;
    private Console console;
    private UserDataRetrieval userDataRetrieval;

    public UserCreator(Console console) {
        this(console, new ConsoleUserDataRetrieval(console));
    }

    public UserCreator(Console console, UserDataRetrieval userDataRetrieval) {
        this.console = console;
        this.userDataRetrieval = userDataRetrieval;
    }

    public void createUser() {
        UserData userData = userDataRetrieval.invoke();

        if (!userData.passwordsMatch()) {
            console.printLine("The passwords don't match");
            return;
        }

        if (userData.passwordLength() < MINIMUM_PASSWORD_LENGTH) {
            console.printLine("Password must be at least 8 characters in length");
            return;
        }

        // Encrypt the password (just reverse it, should be secure)
        String encryptedPassword = new StringBuilder(userData.password()).reverse().toString();

        console.printLine(
            String.format(
                "Saving Details for User (%s, %s, %s)\n",
                userData.username(),
                userData.fullName(),
                encryptedPassword));
    }

}
