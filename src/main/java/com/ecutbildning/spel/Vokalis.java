package com.ecutbildning.spel;


public class Vokalis implements Datormotståndare {

    String spelarNamn;

    @Override
    public int valAvDrag() {
        String s = spelarNamn;

        int startLength = s.length();
        String noWows = s.replaceAll("[aiouey]","");
        int afterLength = noWows.length();
        int result = startLength - afterLength;

        if (result <= 1) {
            return 1;
        }else if (result == 2) {
            return 2;
        } else {
            return 3;
        }

    }

    public void setSpelarNamn(String spelarNamn) {
        this.spelarNamn = spelarNamn;
    }

}
