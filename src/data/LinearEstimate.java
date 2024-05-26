package data;

import java.util.ArrayList;
import java.util.List;

public class LinearEstimate {

    public   static int estimate( int a, int b, int m){
        int mPrev = m;
        if ( a < m ){
            int temp = a;
            a = m;
            m = temp;
        }

        List<Integer> arrayOfQ =  new ArrayList<>();

        while ( a > 0 && m > 0 ){

            arrayOfQ.add(a/m);
            a = a - m * ( a / m );

            if ( a == 0 ){
                break;
            }
            arrayOfQ.add(m/a);
            m = m - a * ( m / a);

        }

        List<Integer> arrayOfP =  new ArrayList<>();

        for (int i = 0; i < arrayOfQ.size(); i++ ){
            if ( arrayOfP.isEmpty()){
                arrayOfP.add(1);
                continue;
            }

            if ( arrayOfP.size() == 1){
                arrayOfP.add( arrayOfQ.get(i));
                continue;
            }

            arrayOfP.add( arrayOfQ.get(i) * arrayOfP.get(i - 1) + arrayOfP.get(i - 2));

        }

        return  (int)Math.pow( -1, arrayOfP.size() - 1) * arrayOfP.get(arrayOfP.size() - 1) * b/mPrev  + mPrev - 1;
    }
}
