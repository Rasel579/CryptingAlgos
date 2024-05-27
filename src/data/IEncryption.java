package data;

public interface IEncryption {
    String decrypt( String encryptedMessage );
    String encrypt( String unEncryptedMessage );

}
