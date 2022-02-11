package com.ecutbildning.spel;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Statistik {


    PlayerRepository playerRepository;
    String name;
    int matcher;

    public Statistik(PlayerRepository playerRepository, String name){
        this.playerRepository = playerRepository;
        this.name = name;


    }


    List<Player> spelare = new ArrayList<>();


    public void visaStatistik(){
        System.out.println("Visar statistik");
        spelare = new ArrayList<>();

        playerRepository.findAll().stream().forEach(x ->spelare.add(x));



        spelare.stream().sorted(Comparator.comparing(Player::getVinster).reversed()).toList().forEach(System.out::println);

        System.out.println("---------------------------");

        //Snyggt fixat!

        System.out.println("Snitt " +
                spelare.stream().collect(Collectors.averagingDouble(Player::getVinster))
        );
//        spelare.stream().filter(x -> x.name.equals(name)).forEach(System.out::println)
        /*spelare = new ArrayList<>(
                playerRepository.findAll()
                        .stream()
                        .sorted(Comparator.comparing(Player::getVinster).reversed())
                        .toList()
        );
        spelare.forEach(System.out::println);*/
        //en ström för att visa ens egen vinst %

    }

    public List<Player> getSpelare() {
        return spelare;
    }

    public void setSpelare(List<Player> spelare) {
        this.spelare = spelare;
    }

    public void antalMatcher(){
        matcher++;
    }

    //public int getAntalMatcher() {
     //   return antalMatcher;
    //}

   /* public void setAntalMatcher(int antalMatcher) {
        this.antalMatcher = antalMatcher;
    }
*/}
