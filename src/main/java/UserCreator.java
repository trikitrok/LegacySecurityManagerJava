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

    private class ConsoleUserDataRetrieval {
        private final Console console;

        public ConsoleUserDataRetrieval(Console console) {
            this.console = console;
        }

        public UserData invoke() {
            console.printLine("Enter a username");
            String username = console.readLine();
            console.printLine("Enter your full name");
            String fullName = console.readLine();
            console.printLine("Enter your password");
            String password = console.readLine();
            console.printLine("Re-enter your password");
            String confirmPassword = console.readLine();

            return new UserData(username, fullName, password, confirmPassword);
        }
    }
}
