import user_creation.*;

public class SecurityManager {
    public static void createUser() {
        Console console = new RealConsole();
        new CreatingUser(
            new ConsoleUserDataRetrieval(console),
            new ConsoleReporter(console),
            new ReverseEncryption()
        ).execute();
    }

}
