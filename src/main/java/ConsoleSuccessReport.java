public class ConsoleSuccessReport {
    private Console console;

    public ConsoleSuccessReport(Console console) {
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
}
