package user_creation;

import user_creation.EncryptionAlgorithm;

public class ReverseEncryption implements EncryptionAlgorithm {
    public String encrypt(String password) {
        return new StringBuilder(password).reverse().toString();
    }
}
