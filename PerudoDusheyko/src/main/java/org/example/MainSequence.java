package org.example;
import org.example.players.CreationOfPlayers;
import org.example.players.Player;
import java.util.*;
import static org.example.players.CreationOfPlayers.players;

public class MainSequence {
    DBOperator db = new DBOperator();
    Dice dice = new Dice();
    Player activeplayer;
    public void StartINI(){
        System.out.println("""
                1.Начать игру
                \
                2.Правила игры
                \
                3.Выйти
                \
                DusheykoInc@ ALL RIGHTS RESERVED 2024-2024""");
        try{
            Scanner sc = new Scanner(System.in);
            int in = sc.nextInt();
            switch(in) {
                case 1:
                    Game();
                    break;
                case 2:
                    db.readRules();
                    StartINI();
                    break;
                case 3:
                    break;
                default:
                    StartINI();
                    break;
            }
        }
        catch(InputMismatchException e){
            System.out.println("Пожалуйста, введите число от одного для трёх для продолжения.");
            StartINI();
            }
    }
    public void ShuffleDice() {
        for (Player player : players) {
            player.ShuffleDice();
        }
    }
    private void Game() {
        CreationOfPlayers.createPlayers();
        ShowInfo();
        FirstRoll();
    }
    public void FirstRoll(){
        System.out.println("\nНачало игры!\n Кидаем кубики, чтобы определить первого ходуна!");
        int max=0;
        for(int i=0;i<CreationOfPlayers.GetSize();i++){
            System.out.println("Игрок "+players.get(i).getName() + " кидает "+players.get(i).getIntOneDice());
            if(players.get(i).getIntOneDice()>max){
                activeplayer=players.get(i);
                max=players.get(i).getIntOneDice();
            }
            else if(players.get(i).getIntOneDice()==max){
                boolean deadlock=true;
                while(deadlock){
                    System.out.println("Одинаковые значения! Реролл!\n-------------");
                    activeplayer.ShuffleDice();
                    System.out.println("Игрок "+activeplayer.getName() + " кидает "+activeplayer.getIntOneDice());
                    players.get(i).ShuffleDice();
                    System.out.println("Игрок "+players.get(i).getName() + " кидает "+players.get(i).getIntOneDice());
                    if(activeplayer.getIntOneDice()>players.get(i).getIntOneDice()){
                        System.out.println("В рероллинге побеждает "+activeplayer.getName()+"\n-------------");
                        deadlock=false;
                    }
                    else if(activeplayer.getIntOneDice()<players.get(i).getIntOneDice()){
                        System.out.println("В рероллинге побеждает "+players.get(i).getName()+"\n-------------");
                        activeplayer=players.get(i);
                        deadlock=false;
                }
            }
        }
    }
        System.out.println("\nПервым ходит "+activeplayer.getName());
        MakeBet();
    }

    private void MakeBet() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Сделайте ставку! Сначала введите количество костей, а затем номинал.");
        ArrayList<Integer> bet = new ArrayList<>();
        try{
            int input = sc.nextInt();
            if(input>6||input<1){
                System.out.println("Ставка вне кубического формата, или меньше или равна нынешней ставки.");
                MakeBet();
            }
            else
                bet.add(input);
            input = sc.nextInt();
            if(input>6||input<1){
                System.out.println("Ставка вне кубического формата, или меньше или равна нынешней ставки.");
                MakeBet();
            }
            else bet.add(input);
        }catch( InputMismatchException e){
            System.out.println("Введите цифру, а не что-то там ещё...");
            bet.clear();
            MakeBet();
        }
        bet.clear();
    }

    public void ShowInfo() {
            System.out.println("Ваше имя - " + players.get(0).getName() +
                    "\nУ вас костей - " + players.get(0).getDiceSize()+
                    "\n" +
                    "\nВаши противники:");
            for(int i=1;i<CreationOfPlayers.GetSize();i++){
                System.out.println("Противник "+i+" - "+players.get(i).getName() + ", костей - " + players.get(i).getDiceSize());
            }
  }
}
