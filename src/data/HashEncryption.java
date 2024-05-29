package data;

public class HashEncryption {

    private long P = 37;
    private long G = 6;

    private long a;
    private long b;
    private String message;

    private long secretKeyX = (long) (Math.random() * P);

    //формируем открытый ключ для передачи
    public  long makePublicKey(){
        long y =  (long)Math.pow(G, secretKeyX)%P;

        if ( y < 0 ){
            y+= P;
        }

        return y;
    }

    public String encrypt( String message ){

        setMessage(message);

        StringBuilder m = new StringBuilder();
        byte hashSum = 0;

        //Вычислим хэш сообщения
        byte[] mHash = HashingSha256.hash( message.getBytes());

        //найдем сумм байтов хэша
        for ( byte hash : mHash ){
            m.append(hash);
            hashSum += hash;
        }

        long K = (long) (Math.random() * (P - 1) );

        //найдем K - 1<k<(P-1), причем (k, (P-1))=1.
        while ( EwqlidMethod.estimate( (int)K , (int)P - 1 ) != 1 ){
            K = (long) (Math.random() * (P - 1) );
        }

        //найдем a и b и сохраним как глобальные переменные для передачи и проверки подписи
        long a = ((long)Math.pow(G, K)) % P;
        setA(a);
        long b = LinearEstimate.estimate(K, makePublicKey()*a + Math.abs(hashSum), P - 1 );
        setB(b);

        return  m.toString();
    }

    public String decrypt(){

        byte hashSum = 0;
        byte[] mHash = HashingSha256.hash( message.getBytes());

        for ( byte hash : mHash ){
            hashSum += hash;
        }

        long A = (long)(Math.pow(makePublicKey(), a) * Math.pow(a, b)) % P;
        long Aequal = ((long)Math.pow(G, Math.abs(hashSum))) % P;
        return A == Aequal ? "Подпись верна" : "Подпись не верна";
    }

    private void setA( long a) {
        this.a = a;
    }


    private void setB( long b) {
        this.b = b;
    }


    private void setMessage(String message) {
        this.message = message;
    }
}
