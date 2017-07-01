package user_creation;

public class ConsoleUserDataRetrieval implements UserDataRetrieval {
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
