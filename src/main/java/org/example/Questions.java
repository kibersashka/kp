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


    public static void createQuest(Questions questions){
        //создали вопросы и записали их в файл

        try(ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("questions.txt"))){
            ois.writeObject(questions);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static Questions creatAsk(){
        Questions questions = new Questions();
        questions.setQuestion1("Угадайте число от 0 до 2");
        questions.setRespones1(new String[] {"0", "1", "2"});
        questions.setGoodResponseIndex1(0);
        questions.setQuestion2("Угадайте, как зовут создателя");
        questions.setRespones2(new String[] {"Камиль", "Артем", "Саша"});
        questions.setGoodResponseIndex2(0);
        questions.setQuestion3("Угадайте букву от A до С");
        questions.setRespones3(new String[] {"A", "B", "C"});
        questions.setGoodResponseIndex3(0);
        return questions;
    }
    public static Questions readQuestions() {//считываем

        Questions questions;
        try (ObjectInputStream oos = new ObjectInputStream((new FileInputStream("questions.txt")))) {
            questions = (Questions) oos.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }
}
