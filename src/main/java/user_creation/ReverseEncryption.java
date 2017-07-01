package user_creation;

public class ReverseEncryption implements EncryptionAlgorithm {
    public String encrypt(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
