public class SecurityManager {
    public static void createUser() {
        new UserCreator(
            new RealConsole(),
            new ConsoleUserDataRetrieval(
                new RealConsole()
            )
        ).createUser();
    }

}
