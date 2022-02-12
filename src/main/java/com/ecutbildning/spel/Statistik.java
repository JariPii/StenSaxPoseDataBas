package com.ecutbildning.spel;

import java.text.DecimalFormat;
import java.util.*;

public class Statistik {


    PlayerRepository playerRepository;
    String name;

    public Statistik(PlayerRepository playerRepository, String name){
        this.playerRepository = playerRepository;
        this.name = name;

    }

    List<Player> spelare = new ArrayList<>();

    public void visaStatistik(){

        DecimalFormat numberFormat = new DecimalFormat("#.00");
        System.out.println("Visar statistik");
        spelare = new ArrayList<>();

        playerRepository.findAll().stream().forEach(x ->spelare.add(x));

        List<Player> spelaren = spelare.stream().filter(x -> x.name.equals(name)).toList();
        if(spelaren.size() <= 0){
            System.out.println("Ingen spelare vid det namnet har spelat ännu");
        }else{
            int spelarVinster = spelaren.get(0).getVinster();
            int matcher = spelaren.get(0).getVinster() + spelaren.get(0).getFörluster() + spelaren.get(0).getLika();
            double spelarVinstProcent = (double)spelarVinster / matcher * 100;
            double spelarFörlustProcent = (double)spelaren.get(0).getFörluster() / matcher * 100;
            double spelarLikaProcent = (double)spelaren.get(0).getLika() / matcher * 100;
            System.out.println("\n     STATISTIK");
            System.out.println("Procent vinster");
            System.out.println(numberFormat.format(spelarVinstProcent) + "%");
            System.out.println("---------------------------");
            System.out.println("Procent förlust");
            System.out.println(numberFormat.format(spelarFörlustProcent) + "%");
            System.out.println("---------------------------");
            System.out.println("Procent lika");
            System.out.println(numberFormat.format(spelarLikaProcent) + "%");
        }
    }

    public void setSpelare(List<Player> spelare) {
        this.spelare = spelare;
    }

}
