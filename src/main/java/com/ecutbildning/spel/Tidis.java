package com.ecutbildning.spel;

import java.time.LocalTime;

public class Tidis implements Datormotståndare {

    public int valAvDrag() {

        LocalTime time = LocalTime.now();
        int second = time.getSecond();

        if(second < 20){
            return 1;
        }
        else if(second < 40){
            return 2;
        }
        else {
            return 3;
        }

    }

}
