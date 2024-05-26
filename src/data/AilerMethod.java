package data;

import java.util.List;

public class AilerMethod {


    //Реализация функции Эйлера
    public static String estimate( int number ){

        List<Integer> answer = AratosfenMethod.canonicalEstimate( number );

        return  String.valueOf(answer.size());
    }
}
