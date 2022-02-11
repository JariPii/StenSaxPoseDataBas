package com.ecutbildning.spel;

import org.springframework.stereotype.Service;

@Service
class Result {
    int matcher;
    PlayerRepository playerRepository;

    public Result(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public void beslutaVinnare(Player a, Player b) {

        int playerADrag = a.getDrag();
        int playerBDrag = b.getDrag();

        System.out.println(a.name + " HAR VALT DRAGET " + a.getDrag() + "\n" + b.name + " HAR VALT DRAGET " + b.getDrag());

        if (playerADrag == playerBDrag) {
            System.out.println("Det BLEV LIKA");
            a.lika++;
            b.lika++;
        } else if ((playerADrag + 1) % 3 == playerBDrag % 3) {
            System.out.println(a.name + " <-VANN" + " " + b.name + " <-FÖRLORADE");
            a.vinster++;
            b.förluster++;
        } else {
            System.out.println(a.name + " <-FÖRLORADE " + b.name + " <-VANN");
            a.förluster++;
            b.vinster++;
        }
        playerRepository.save(a);
        playerRepository.save(b);
    }
}
