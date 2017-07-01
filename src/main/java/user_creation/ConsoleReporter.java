package user_creation;

public class ConsoleReporter implements Reporter {
    private Console console;

    public ConsoleReporter(Console console) {
        this.console = console;
    }

    public void reportSuccessCreatingUser(String text) {
        console.printLine(text);
    }

    @Override
    public void reportError(String description) {
        console.printLine(description);
    }
}
