package data;

import java.util.ArrayList;
import java.util.List;

public class AratosfenMethod {

    // Вычислим последовательность простых чисел, не превосходящих
    //данного N, на основе алгоритма Эратосфена;
    public  static  String estimate ( int number ){
        StringBuilder result = new StringBuilder();
        List<Integer> answer = new ArrayList<>();
        for ( int i = 2; i <= number; i++ ){


            for ( int j = i; j <= number ; j++ ){

               if ( j == i && ! answer.contains(j) ){
                   int temp = 0;
                   for ( Integer a : answer ){
                       if ( j%a == 0){
                           temp++;
                       }
                   }

                   if (temp == 0){
                       answer.add(j);
                   }
               }

               if ( j% i != 0 ){
                   int temp = 0;
                   for ( Integer a : answer ){
                       if ( j%a == 0){
                           temp++;
                       }
                   }

                   if (temp == 0){
                       answer.add(j);
                   }

               } else if ( answer.contains(j) && j != i ) {

                   answer.remove( Integer.valueOf(j) );
               }
            }
        }
        answer.forEach( ans -> result.append(ans.toString()).append(" ,") );

        return result.toString();
    }

    //Вывод в Текстовое поле
    public  static  String estimateCanonical ( int number ){
        StringBuilder result = new StringBuilder();
        List<Integer> answer = canonicalEstimate( number );
        answer.forEach( ans -> result.append(ans.toString()).append(" ,") );

        return result.toString();
    }

    // Разложим число N на каноническое произведение простых чисел;
    public  static List<Integer> canonicalEstimate( int number ){
        List<Integer> result = new ArrayList<>();
        int chastnoe = number;
        boolean isStop = false;
        while (!isStop){
            isStop = true;
            for ( int i = 2; i < number; i ++){
                if(chastnoe % i == 0){
                    result.add(i);
                    chastnoe = chastnoe / i;
                    isStop = false;
                    break;
                }
            }

        }

        return  result;
    }
}
