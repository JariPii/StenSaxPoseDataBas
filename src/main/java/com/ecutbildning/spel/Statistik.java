package com.ecutbildning.spel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Statistik {

    private int antalMatcher;
    PlayerRepository playerRepository;

    public Statistik(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }


    List<Player> spelare = new ArrayList<>();


    public void visaStatistik(){
        System.out.println("Visar statistik");
        spelare = new ArrayList<>(
                playerRepository.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Player::getVinster).reversed())
                        .toList()
        );
        spelare.forEach(System.out::println);
    }

    public List<Player> getSpelare() {
        return spelare;
    }

    public void setSpelare(List<Player> spelare) {
        this.spelare = spelare;
    }

    public int getAntalMatcher() {
        return antalMatcher;
    }

    public void setAntalMatcher(int antalMatcher) {
        this.antalMatcher = antalMatcher;
    }
}
