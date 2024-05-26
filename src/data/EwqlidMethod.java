package data;

public class EwqlidMethod {

    //Найдем наибольшего общего делителя двух чисел на основе
    //алгоритма Евклида;
    public static int estimate( int a, int b ){
        if ( a < b ){
            int temp = a;
            a = b;
            b = temp;
        }
        while ( a > 0 && b > 0 ){
            a = a - b * ( a/ b );
            if ( a == 0 ){
                return  b;
            }
            b = b - a * ( b / a);
        }
        return b;

    }
}
