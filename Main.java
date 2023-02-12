package project_work;

import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //player 1 gameplay
        Scanner scanner =new Scanner(System.in);
        Game game1=new Game();
        System.out.println("PLAYER 1: Enter your name ");
        game1.setPlayername(scanner.nextLine());
        game1.play();
        System.out.println("your score :"+game1.getNo_of_try());
        //player 2 gameplay
        Game game2=new Game();
        System.out.println("PLAYER 2: Enter your name ");
        game2.setPlayername(scanner.nextLine());
        game2.play();
        System.out.println("your score :"+game2.getNo_of_try());
        //winning statement
        if(game1.getNo_of_try()>game2.getNo_of_try()){
            System.out.println(game1.getPlayername()+" lost and "+game2.getPlayername()+" won.");
        }else  if(game1.getNo_of_try()<game2.getNo_of_try()) {
            System.out.println(game2.getPlayername() + " lost and " + game1.getPlayername() + " won.");
        }else System.out.println("match draw");
    }
}
class Game {
    public Game (){
        Random random =new Random();
        this.target = random.nextInt(100);
    }
    String playername;

    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public String getPlayername() {
        return playername;
    }

    int target;
    Scanner scanner=new Scanner(System.in);
    int input;
    public void takeinput(){
        System.out.println("guess a number between 0 and 100.");
        this.input =scanner.nextInt();
    }
    public void takelowerinput(){
        System.out.println("try something lower");
        this.input=scanner.nextInt();
    }
    public void takehigherinput(){
        System.out.println("try something higher");
        this.input=scanner.nextInt();
    }
    public void gamebody(){

        if (input==target)
        {
            System.out.println("PERFECT");
        } else if (input<target) {
            this.takehigherinput();
            gamebody();
            no_of_try++;
        } else if (input>target) {
            this.takelowerinput();
            gamebody();
            no_of_try++;
        }
    }
    public void play(){
        this.takeinput();
        this.gamebody();
    }
    int no_of_try;

    public int getNo_of_try() {
        return no_of_try+1;
    }
}