package com.ecutbildning;

//import com.ecutbildning.entity.EmployeeEntity;
import com.ecutbildning.spel.PlayerRepository;
import com.ecutbildning.spel.Spelet;
import com.ecutbildning.spel.Statistik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import com.ecutbildning.repository.EmplyeeRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@SpringBootApplication
//@ComponentScan
public class TestbasApplication implements CommandLineRunner {

    @Autowired
    PlayerRepository playerRepository;

    public static void main(String[] args) {
        SpringApplication.run(TestbasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        boolean runProgram = true;

        Scanner scanner = new Scanner(System.in);

        System.out.println("\033[0;1m" + "\u001B[31m" + "Det mest avancerade oanvändbara sten sax påse spelet!" + "\u001B[0m" + "\033[0;0m");
        System.out.println("Välkommen!");
        System.out.println("Vad heter du?");
        String name = scanner.nextLine();
        System.out.println("Välkommen " + name);

        Spelet spelet = new Spelet();

        Statistik statistik = new Statistik(playerRepository, name);
        //while loop
        while(runProgram){
            System.out.println("\nMenyval!\n 1: spela\n 2: statistik\n 3: avsluta");
            int menyVal = scanner.nextInt();

            switch (menyVal){
                case 1:
                    System.out.println("Du valde 1");
                    spelet.spelet(name, playerRepository);
                    break;
                case 2:
                    System.out.println("Du valde 2");
                    statistik.visaStatistik();
                    break;
                default:
                    System.out.println("Du har valt att avsluta!");
                    runProgram = false;
            }
        }

    }
}
