package user_creation;

public interface Reporter {
    void reportSuccessCreatingUser(UserData userData, String encryptedPassword);

    void reportError(String description);
}
