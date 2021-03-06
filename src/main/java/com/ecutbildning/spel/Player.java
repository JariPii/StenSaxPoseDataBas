package com.ecutbildning.spel;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public
class Player {

    @Id
    String name;
    int vinster;
    int lika;
    int förluster;
    int drag;

    public Player(String name) {
        this.name = name;
    }

    public Player() {

    }

    public int getLika() {
        return lika;
    }

    public int setDrag(int drag) {
        return this.drag = drag;
    }

    public int getDrag() {
        return drag;
    }

    public int getVinster() {
        return vinster;
    }

    public int getFörluster() {
        return förluster;
    }


    @Override
    public String toString() {
        return "Player{ " +
                "name='" + name + '\'' +
                ", vinster=" + vinster +
                ", lika=" + lika +
                ", förluster=" + förluster +
                " }";
    }

}
