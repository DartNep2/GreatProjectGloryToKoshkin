package org.example;
import java.util.*;
import static org.example.players.CreationOfPlayers.players;

public class Dice {
    private int number;
    public void ThrowDicePublic(){
    }
    public int getNumber(){
        return number;
    }
    public Dice() {
        Random random = new Random();
        this.number = random.nextInt(6)+1;
    }
    public void removeAPlayer(int playerPos){
        System.out.println(players.get(playerPos).getName()+" выбывает из игры!");
        players.remove(playerPos);
    }
    public void shuffle() {
        Random random = new Random();
        this.number = random.nextInt(6)+1;
    }
    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
