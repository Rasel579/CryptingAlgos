package data;

import org.threadly.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElGamalEncryption {
    private long P = 37;
    private long G = 6;
    private long secretKeyX = (long) (Math.random() * P);
    private Map<Character, Integer> semanticMap;


    List<Pair<Long, Long>> cryptedMessage = new ArrayList<>();

    //С помощью открытых ключей PublicKey, P, G  шифруют сообщение и отсылают пару <a, b>
    public String encrypt( String message ){

        initSemanticMap("йцукенгшщзхъфывапролджэячсмитьбю");
        message = message.toLowerCase();
        StringBuilder resultCryptedMessage = new StringBuilder();
        cryptedMessage.clear();
        long K = 4;
        long a = ((long)Math.pow(G, K)) % P;
        for ( int i = 0; i < message.length(); i++){
            long charCode = semanticMap.get(message.charAt(i));
            long b = ((long)(Math.pow( makePublicKey(), K))*charCode) % P;
            if ( b < 0 ){
                b += P;
            }
            cryptedMessage.add( new Pair<>(a, b));

        }

        cryptedMessage.forEach( msg  -> resultCryptedMessage.append( "a = " + msg.getLeft() + " b = " + msg.getRight()));



        return  resultCryptedMessage.toString();
    }

    public  long makePublicKey(){
        long y =  (long)Math.pow(G, secretKeyX)%P;

        if ( y < 0 ){
            y+= P;
        }

        return y;
    }

    //Расшифровка сообщения с помощью секретного ключа пары <a, b> и простого открытого числа P
    public String decryptMessage(){
        StringBuilder deryptedMessage = new StringBuilder();

        cryptedMessage.forEach( symbol -> {
            //расшифровываем сообщение с помощью решения линейного сравненмя и закрытого ключа
            long b = LinearEstimate.estimate( (long)Math.pow( symbol.getLeft(), secretKeyX), 1, P);
            long m = symbol.getRight() * b % P;
            long modifiedIndex;
            if ( m < 0 ){
                modifiedIndex = P + m;
            } else {
                modifiedIndex = m;
            }

            semanticMap.entrySet().forEach( map -> {
                if ( map.getValue().longValue() == modifiedIndex ){
                    deryptedMessage.append(map.getKey());
                }
            });

        });

        return  deryptedMessage.toString();
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
