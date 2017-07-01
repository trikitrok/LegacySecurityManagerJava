public class SecurityManager {
    public static void createUser() {
        Console console = new RealConsole();
        new UserCreator(
            new RealConsole(),
            new ConsoleUserDataRetrieval(console),
            new ConsoleReporter(console)).createUser();
    }

}
