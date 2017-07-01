class UserCreator {
    private Console console;

    public UserCreator(Console console) {
        this.console = console;
    }

    public void createUser() {
        String username = null;
        String fullName = null;
        String password = null;
        String confirmPassword = null;

        print("Enter a username");
        username = readLine();
        print("Enter your full name");
        fullName = readLine();
        print("Enter your password");
        password = readLine();
        print("Re-enter your password");
        confirmPassword = readLine();

        UserData userData = new UserData(username, fullName, password, confirmPassword);

        if (!userData.passwordsMatch()) {
            print("The passwords don't match");
            return;
        }

        if (password.length() < 8) {
            print("Password must be at least 8 characters in length");
            return;
        }

        // Encrypt the password (just reverse it, should be secure)
        String encryptedPassword = new StringBuilder(password).reverse().toString();

        print(String.format(
            "Saving Details for User (%s, %s, %s)\n",
            username,
            fullName,
            encryptedPassword));
    }

    protected String readLine() {
        return console.readLine();
    }

    protected void print(String line) {
        console.printLine(line);
    }

}
