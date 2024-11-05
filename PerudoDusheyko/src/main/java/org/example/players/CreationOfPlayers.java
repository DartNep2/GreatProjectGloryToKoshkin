package org.example.players;
import java.util.ArrayList;
public class CreationOfPlayers {
    public static ArrayList<Player> players = new ArrayList<>();
    public static Player RP1;
    public static Player AI1;
    public static Player AI2;
    public static Player AI3;

    public static int GetSize(){
        return players.size();
    }
    public static void createPlayers() {
        //Один человек-игрок и три бота!
        RP1 = new Player(true);
        AI1 = new Player(false);
        AI2 = new Player(false);
        AI3 = new Player(false);
        players.add(RP1);
        players.add(AI1);
        players.add(AI2);
        players.add(AI3);
    }
}
