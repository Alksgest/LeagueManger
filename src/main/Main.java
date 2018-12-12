package main;

import starCraft.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<SC2Player> customLeague = new HashSet<>();
        customLeague.add(new SC2Player("Player1", League.GOLD, 57, Race.PROTOSS));
        customLeague.add(new SC2Player("Player2", League.SILVER, 21, Race.ZERG));
        customLeague.add(new SC2Player("Player3", League.PRACTICE, 0, Race.PROTOSS));

        ILeagueManager manager = new LeagueManager(customLeague);

        for (SC2Player p :
                manager.getAllPlayers() ) {
            System.out.println(p.toString());
        }
        System.out.println("\n=-=-=-=-=-=-=-==--=-=-=-=\n");

        manager.addPlayer(new SC2Player("Player4", League.DIAMOND, 193, Race.TERRAN));

        for (SC2Player p :
                manager.getAllPlayers() ) {
            System.out.println(p.toString());
        }
        System.out.println("\n=-=-=-=-=-=-=-==--=-=-=-=\n");

        for (SC2Player p :
                manager.getPlayers(League.DIAMOND) ) {
            System.out.println(p.toString());
        }
        System.out.println("\n=-=-=-=-=-=-=-==--=-=-=-=\n");

        for (SC2Player p :
                manager.getPlayers(Race.PROTOSS) ) {
            System.out.println(p.toString());
        }
        System.out.println("\n=-=-=-=-=-=-=-==--=-=-=-=\n");

        manager.removePlayer(new SC2Player("Player3", League.PRACTICE, 0, Race.PROTOSS));

        for (SC2Player p :
                manager.getAllPlayers() ) {
            System.out.println(p.toString());
        }
        System.out.println("\n=-=-=-=-=-=-=-==--=-=-=-=\n");


        manager.addPoints("Player1", 21973);

        for (SC2Player p :
                manager.getAllPlayers() ) {
            System.out.println(p.toString());
        }
        System.out.println("\n=-=-=-=-=-=-=-==--=-=-=-=\n");

        System.out.println(manager.getPlayer("Player1"));

    }
}


