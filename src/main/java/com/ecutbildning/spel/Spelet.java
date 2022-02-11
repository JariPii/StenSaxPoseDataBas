package com.ecutbildning.spel;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class Spelet{


    public void spelet(String name, PlayerRepository playerRepository) {

        Result result = new Result(playerRepository);

        Scanner scanner = new Scanner(System.in);

        Player spelare = new Player(name);

        Optional<Player> plFromDatabase = playerRepository.findById(spelare.name);
        if(plFromDatabase.isPresent()){
            spelare = plFromDatabase.orElseThrow();
        } else {
            playerRepository.save(spelare);
        }


        List<Player> motståndare = List.of(
                new Player("Slumpis"),
                new Player("Vokalis"),
                new Player("Tidis")
        );
        playerRepository.saveAll(motståndare);


        for (int i = 0; i < motståndare.size(); i++) {
            System.out.println("Du möter : " + motståndare.get(i).name);
            System.out.println("Välj ditt drag \n1: sten \n2: sax \n3: påse");
            int användarensDrag = scanner.nextInt();
            motDrag(spelare.name);
            switch (användarensDrag) {
                case 1:
                    spelare.setDrag(1);
                    break;
                case 2:
                    spelare.setDrag(2);
                    break;
                case 3:
                    spelare.setDrag(3);
                    break;
                default:
                    System.out.println("Vänligen ange en siffra för ditt val");

            }
            for(Player valAvDrag : motståndare){
                valAvDrag.setDrag(motDrag(valAvDrag.name));
            }

            switch (motståndare.get(i).getDrag()) {
                case 1:
                    motståndare.get(i).setDrag(1);
                    System.out.println(motståndare.get(i).name + " Har valt Sten");
                    break;
                case 2:
                    motståndare.get(i).setDrag(2);
                    System.out.println(motståndare.get(i).name + " Har valt sax");
                    break;
                case 3:
                    motståndare.get(i).setDrag(3);
                    System.out.println(motståndare.get(i).name + " Har valt påse");
                    break;
            }

            result.beslutaVinnare(spelare, motståndare.get(i));
            if(i == 0){
                result.beslutaVinnare(motståndare.get(i + 1), motståndare.get(i + 2));
            } else if ( i == 1) {
                result.beslutaVinnare(motståndare.get(0), motståndare.get(i + 1));
            }else {
                result.beslutaVinnare(motståndare.get(0), motståndare.get(1));
            }
            result.antalMatcher++;

        }

        Statistik statistik = new Statistik(playerRepository);
        List<Player> allaSpelare = new ArrayList<>();

        for(Player bot : motståndare){
                  allaSpelare.add(bot);
        };

        allaSpelare.add(spelare);
        statistik.setSpelare(allaSpelare);


        System.out.println("Matcher spelade: " + result.antalMatcher);
        System.out.println("Du vann: " + spelare.vinster + " Matcher");
        for(Player bot : motståndare){
            System.out.println(bot.name + "Har " + bot.vinster + " Vinster \n");
        }
    }

    public static int motDrag(String name){

        Tidis tidis = new Tidis();
        Slumpis slumpis = new Slumpis();
        Vokalis vokalis = new Vokalis();

        vokalis.setSpelarNamn(name);

        int tidisDrag = tidis.valAvDrag();
        int slumpisDrag = slumpis.valAvDrag();
        int vokalisDrag = vokalis.valAvDrag();


        switch(name){
            case "Slumpis" :
                return slumpisDrag;
            case "Vokalis" :
                return vokalisDrag;
            default:
                return tidisDrag;

        }

    }


}



