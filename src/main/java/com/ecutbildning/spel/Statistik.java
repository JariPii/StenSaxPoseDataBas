package com.ecutbildning.spel;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;


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
