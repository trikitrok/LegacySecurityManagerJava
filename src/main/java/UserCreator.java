class UserCreator {
    private static final int MINIMUM_PASSWORD_LEGTH = 8;
    private Console console;

    public UserCreator(Console console) {
        this.console = console;
    }

    public void createUser() {
        UserData userData = new ConsoleUserDataRetrieval(console).invoke();

        if (!userData.passwordsMatch()) {
            console.printLine("The passwords don't match");
            return;
        }

        if (userData.passwordLength() < MINIMUM_PASSWORD_LEGTH) {
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
