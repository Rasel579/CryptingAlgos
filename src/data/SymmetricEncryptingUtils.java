package data;

import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

public class SymmetricEncryptingUtils {

    private Map<Character, Integer> semanticMap;
    @Setter
    private String secretKey;

    //симметричный алгоритм шифрования сложной заменой, подаем сообщение
    //  находим через секретный ключ индекс шифра и возвращаем зашифрованное сообщение
    public String encrypt( String unEncryptedMessage ){
        unEncryptedMessage = unEncryptedMessage.toLowerCase();
        secretKey = secretKey.toLowerCase();

        StringBuilder encryptedMessage =  new StringBuilder();
        for ( int i = 0; i < unEncryptedMessage.length(); i++){

             //определяем индекс символа для зашифрованного сообщения
             int idx = ( semanticMap.get( unEncryptedMessage.charAt(i)) + semanticMap.get(secretKey.charAt(i%secretKey.length())) ) % semanticMap.size();

             semanticMap.entrySet().forEach( map -> {
                 if ( map.getValue() == idx ){
                     encryptedMessage.append(map.getKey());
                 }
             });
        }

        return  encryptedMessage.toString();
    }

    //расшифровываем сообщение через секретный ключ
    public String decrypt( String encryptedMessage ){

        encryptedMessage = encryptedMessage.toLowerCase();
        secretKey = secretKey.toLowerCase();

        StringBuilder decryptedMessage =  new StringBuilder();

        for ( int i = 0; i < encryptedMessage.length(); i++){

            //определяем индекс символа исходного сообщения
            int idx = ( semanticMap.get( encryptedMessage.charAt(i)) - semanticMap.get(secretKey.charAt(i%secretKey.length())) ) % semanticMap.size();

            int modifiedIndex;
            if (idx < 0 ){
                modifiedIndex = idx + semanticMap.size();
            } else {
                modifiedIndex = idx;
            }

            semanticMap.entrySet().forEach( map -> {
                if ( map.getValue() == modifiedIndex ){
                    decryptedMessage.append(map.getKey());
                }
            });
        }

        return  decryptedMessage.toString();
    }

    //Инициализация заданных алфавитных порядков и проставления индексов
    public void initSemanticMap( String alphabet ){
        alphabet = alphabet.toLowerCase();
        semanticMap = new HashMap<>();

        for ( int i = 0; i < alphabet.length(); i++){
            semanticMap.put(alphabet.charAt(i), i);
        }
    }

}
