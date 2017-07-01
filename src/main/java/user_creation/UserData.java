package user_creation;

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

    @Override
    public String toString() {
        return "UserData{" +
            "username='" + username + '\'' +
            ", fullName='" + fullName + '\'' +
            ", password='" + password + '\'' +
            ", confirmPassword='" + confirmPassword + '\'' +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserData)) return false;

        UserData userData = (UserData) o;

        if (username != null ? !username.equals(userData.username) : userData.username != null) return false;
        if (fullName != null ? !fullName.equals(userData.fullName) : userData.fullName != null) return false;
        if (password != null ? !password.equals(userData.password) : userData.password != null) return false;
        return confirmPassword != null ? confirmPassword.equals(userData.confirmPassword) : userData.confirmPassword == null;

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (confirmPassword != null ? confirmPassword.hashCode() : 0);
        return result;
    }
}
