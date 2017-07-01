public class UserData {
    private final String username;
    private final String fullName;
    private final String password;
    private final String confirmPassword;

    public UserData(String username, String fullName, String password, String confirmPassword) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public boolean passwordsMatch() {
        return password.equals(confirmPassword);
    }

    public int passwordLength() {
        return password.length();
    }

    public String password() {
        return password;
    }

    public String fullName() {
        return fullName;
    }

    public String username() {
        return username;
    }
}
