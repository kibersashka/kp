package org.example;

import javax.crypto.spec.PSource;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static org.example.Questions.creatAsk;
import static org.example.Questions.createQuest;


public class Raiting implements Serializable {
    class Game implements Serializable{
        public String gamer;
        public Integer raiting ;
        public Date gameDate;
        public int serialVersionUID = 100;
        public Game(String name){
            this.gamer = name;
            raiting = 0;
        }

    }
    public int serialVersionUID = 1090;
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
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("res.txt", true))){
            oos.writeObject(games);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void showRaiting(){
        //
        File file = new File("res.txt");
        if(!file.exists() || file.length() == 0){
            games = new ArrayList<>();
            return;
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            games = (List<Game>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //games.stream().forEach(System.out::println);

    }

    public void consol(){
        Scanner sc = new Scanner(System.in);
        createQuest(creatAsk());
        questions = Questions.readQuestions();
        System.out.println("name");
        thisGame = new Game(sc.nextLine());
        showRaiting();

        System.out.println(questions.getQuestion1());
        getScore1(sc.nextLine());
        System.out.println(questions.getQuestion2());
        getScore2(sc.nextLine());
        System.out.println(questions.getQuestion3());
        getScore3(sc.nextLine());
        games.add(thisGame);
        games.stream().sorted(((o1, o2) -> o1.raiting - o2.raiting))
                .forEach(x -> System.out.println(x.raiting) );
        saveRaiting();
        createQuest(questions);
    }
}

