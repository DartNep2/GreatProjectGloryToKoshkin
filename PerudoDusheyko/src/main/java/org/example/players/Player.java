package org.example.players;
import org.example.DBOperator;
import org.example.Dice;
import java.util.ArrayList;
import java.util.Scanner;

public class Player{
    public static DBOperator db = new DBOperator();
    static int numberOfAIPlayers=0;
    private final ArrayList<Dice> cupOfDice;
    {numberOfAIPlayers+=1;}
    public Player(boolean human){
        if(human){
        this.name=Authorization();}
        else
            this.name=db.GetDatName();
        this.cupOfDice=new ArrayList<>(5);
        for(int i= 0; i< 5; i ++){
            cupOfDice.add(new Dice());
        }
        this.number=numberOfAIPlayers;
    }
    public String getName() {
        return name;
    }
    public int getDiceSize() {
        return cupOfDice.size();
    }
    public ArrayList<Dice> getDice() {
        return cupOfDice;
    }
    public int getIntOneDice(){
        return cupOfDice.get(0).getNumber();
    }
    public final String name;
    public int number;
    public String Authorization() {
        Scanner sc = new Scanner(System.in);
        System.out.println("""
            Пожалуйста, впишите ваше имя!
            \
            Или напишите 0, если хотите получить сгенерированное имя.""");
        String in = sc.nextLine();
        if (in.equals("0")) {
            in = db.GetDatName();
        }
        return in;
    }
    public void ShuffleDice(){
        for(Dice die: cupOfDice){
            die.shuffle();
        }
    }
}
