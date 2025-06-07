package org.example;

import java.io.*;

public class Questions implements Serializable {


    private Raiting score;
    private String question1;
    private String[] respones1;
    private int goodResponseIndex1;

    private String question2;
    private String[] respones2;
    private int goodResponseIndex2;

    private String question3;
    private String[] respones3;
    private int goodResponseIndex3;

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String[] getRespones1() {
        return respones1;
    }

    public void setRespones1(String[] respones1) {
        this.respones1 = respones1;
    }

    public int getGoodResponseIndex1() {
        return goodResponseIndex1;
    }

    public void setGoodResponseIndex1(int goodResponseIndex1) {
        this.goodResponseIndex1 = goodResponseIndex1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String[] getRespones2() {
        return respones2;
    }

    public void setRespones2(String[] respones2) {
        this.respones2 = respones2;
    }

    public int getGoodResponseIndex2() {
        return goodResponseIndex2;
    }

    public void setGoodResponseIndex2(int goodResponseIndex2) {
        this.goodResponseIndex2 = goodResponseIndex2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public String[] getRespones3() {
        return respones3;
    }

    public void setRespones3(String[] respones3) {
        this.respones3 = respones3;
    }

    public int getGoodResponseIndex3() {
        return goodResponseIndex3;
    }

    public void setGoodResponseIndex3(int goodResponseIndex3) {
        this.goodResponseIndex3 = goodResponseIndex3;
    }


    public void createQuest(){
        //создали вопросы и записали их в файл

        try(ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("questions.txt"))){
            ois.writeObject(creatAsk());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public Questions creatAsk(){
        Questions questions = new Questions();
        questions.setQuestion1("ask 1");
        questions.setQuestion2("ask 2");
        questions.setQuestion3("ask 3");
        questions.setGoodResponseIndex1(0);
        questions.setGoodResponseIndex2(0);
        questions.setGoodResponseIndex3(0);
        questions.setRespones1(new String[]{"1", "2", "3"});
        questions.setRespones2(new String[]{"1", "2", "3"});
        questions.setRespones3(new String[]{"1", "2", "3"});
        return questions;
    }
    public void readQuestions() {//считываем

        try(DataInputStream dis = new DataInputStream(new FileInputStream("questions.txt"))){
            question1 = dis.readLine();
            respones1 = new String[]{dis.readLine()};
            goodResponseIndex1 = dis.readInt();
            question2 = dis.readLine();
            respones2 = new String[]{dis.readLine()};
            goodResponseIndex2 = dis.readInt();
            question3 = dis.readLine();
            respones3 = new String[]{dis.readLine()};
            goodResponseIndex3 = dis.readInt();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
