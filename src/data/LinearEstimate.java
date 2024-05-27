package data;

import java.util.ArrayList;
import java.util.List;

public class LinearEstimate {

    public   static long estimate( long a, long b, long m){
        long mPrev = m;
        if ( a < m ){
            long temp = a;
            a = m;
            m = temp;
        }

        List<Long> arrayOfQ =  new ArrayList<>();
        //вычисляем q1..qn
        while ( a > 0 && m > 0 ){

            arrayOfQ.add(a/m);
            a = a - m * ( a / m );

            if ( a == 0 ){
                break;
            }
            arrayOfQ.add(m/a);
            m = m - a * ( m / a);

        }

        List<Long> arrayOfP =  new ArrayList<>();

        //Вычисляем p0..pn
        for (int i = 0; i < arrayOfQ.size(); i++ ){
            if ( arrayOfP.isEmpty()){
                arrayOfP.add(1l);
                continue;
            }

            if ( arrayOfP.size() == 1){
                arrayOfP.add( arrayOfQ.get(0));
                continue;
            }
            long q = arrayOfQ.get(i -1);
            long pPrev = arrayOfP.get(i - 1);
            long pPrevPrev = arrayOfP.get(i - 2);
            long result = q * pPrev + pPrevPrev;
            arrayOfP.add( result);

        }

        //находим решения линейного сравнения
        long result = ((long)Math.pow( -1, arrayOfP.size() - 1) * arrayOfP.get(arrayOfP.size() - 1) * b) % mPrev;

        //если результат отрицат находим правильный mod
        if ( result < 0){
            result += mPrev;
        }

        return  result;
    }
}
