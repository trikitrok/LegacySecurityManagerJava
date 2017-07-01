package user_creation;

public interface Reporter {
    void reportSuccessCreatingUser(String text);

    void reportError(String description);
}
