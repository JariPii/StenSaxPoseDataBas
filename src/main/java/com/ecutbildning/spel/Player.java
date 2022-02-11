package com.ecutbildning.spel;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public
class Player {

    @Id
    String name;
    int vinster;
    int lika;
    int förluster;
    int drag;
    Date time;

    public void setTime(Date time) {
        this.time = time;
    }

    public Player(String name) {
        this.name = name;
    }

    public Player() {

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
                ", förluster=" + förluster + " }";
    }
}
