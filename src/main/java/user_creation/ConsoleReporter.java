package user_creation;

public class ConsoleReporter implements Reporter {
    private Console console;

    public ConsoleReporter(Console console) {
        this.console = console;
    }

    public void reportSuccessCreatingUser(UserData userData, String encryptedPassword) {
        console.printLine(
            String.format(
                "Saving Details for User (%s, %s, %s)\n",
                userData.username(),
                userData.fullName(),
                encryptedPassword));
    }

    @Override
    public void reportError(String description) {
        console.printLine(description);
    }
}
