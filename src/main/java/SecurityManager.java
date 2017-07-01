import user_creation.*;

public class SecurityManager {
    public static void createUser() {
        Console console = new RealConsole();
        new UserCreator(
            new ConsoleUserDataRetrieval(console),
            new ConsoleReporter(console),
            new ReverseEncryption()
        ).createUser();
    }

}
