package org.example;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Raiting implements Serializable {
    public class Game{
        public String gamer;
        public Integer raiting = 0;
        public Date gameDate;
        public Game(String name){
            this.gamer = name;
        }
    }
    private Questions questions;
    List<Game> games;
    public Game thisGame;
    public void getScore1(String answer){
        int i = 0;
        for(String var: questions.getRespones1()){
            i++;
            if(var.equals(answer) && i == questions.getGoodResponseIndex1()){
                thisGame.raiting++;
                return;
            }
        }
    }
    public void getScore2(String answer){
        int i = 0;
        for(String var: questions.getRespones2()){
            if(var.equals(answer) && i == questions.getGoodResponseIndex2()){
                thisGame.raiting++;
                return;
            }
        }

    }
    public void getScore3(String answer){
        int i = 0;
        for(String var: questions.getRespones3()){
            if(var.equals(answer) && i == questions.getGoodResponseIndex3()){
                thisGame.raiting++;
                return;
            }
        }

    }

    public void saveRaiting(){
        ////записали в файл данные этой попытки
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("questions.txt", true))){
            oos.writeObject(thisGame);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showRaiting(){
        //
        Game game;
        File file = new File("questions.txt");
        if(!file.exists()){
            games = new ArrayList<>();
            return;
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            game = (Game) ois.readObject();
            games.add(game);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        games.stream().forEach(System.out::println);
    }

    public void consol(){
        Scanner sc = new Scanner(System.in);
        Questions questions1 = new Questions();
        System.out.println("name");
        thisGame = new Game(sc.nextLine());
        questions1.creatAsk();
        //questions1.createQuest();
        //questions1.readQuestions();

        System.out.println(questions1.getQuestion1());
        getScore1(sc.nextLine());
        System.out.println(questions1.getQuestion2());
        getScore2(sc.nextLine());
        System.out.println(questions1.getQuestion3());
        getScore3(sc.nextLine());
        saveRaiting();
        showRaiting();
        questions.createQuest();
    }
}

