/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhoMillionaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bhara
 */
public class GameFunctions 
{

    public static final GameMethods game = new GameMethods();
    public static Random rand = new Random();
    public static List<LifeLines> lifeLines = new ArrayList<>();
    public static Scanner scan = new Scanner(System.in);

    public static boolean checkInputIsValid(Questions ques, AnswerEnum token, LifeLines life) {
        if (ques.getAnsTokens().contains(token)) {
            return true;
        }

        return life != null;
    }

    public static void useLifeLine(Questions ques, LifeLines used) 
    {
        lifeLines.remove(used);

        switch (used) {
            case FIFTY_FIFTY:

                for (int i = 0; i < 2; i++) {
                    removeRandomWrongAnswer(ques);
                }
            case CALL_FRIEND:
                System.out.println("Your friend believes that the correct answer is option B!");

            case ASK_AUDIENCE:
                System.out.println("50% of the audience voted for option B!");
                System.out.println("25% of the audiece voted for option D!");
                System.out.println("25% of the audience did not vote!");
        }
    }

    public static void removeRandomWrongAnswer(Questions ques) {
        List<Answers> incorrectAns = ques.getWrongAnswers();
        int randomIndex = rand.nextInt(incorrectAns.size());
        Answers randomAns = incorrectAns.get(randomIndex);
        ques.removeAnswer(randomAns);
    }

    static List<Questions> loadQuestions() {
        List<Questions> questions = new ArrayList<>();
        //1
        questions.add(new Questions("What does 1+1 equal?", AnswerEnum.A,
                new Answers(AnswerEnum.A, "2"),
                new Answers(AnswerEnum.B, "4"),
                new Answers(AnswerEnum.C, "6"),
                new Answers(AnswerEnum.D, "8")));
        //2
        questions.add(new Questions("Who is the Prime Minister of New Zealand (2021)?", AnswerEnum.C,
                new Answers(AnswerEnum.A, "Barack Obama"),
                new Answers(AnswerEnum.B, "Joe Bidin"),
                new Answers(AnswerEnum.C, "Jacinda Adern"),
                new Answers(AnswerEnum.D, "Judith Collins")));
        //3
        questions.add(new Questions("Which of the following is a breed of dog?", AnswerEnum.D,
                new Answers(AnswerEnum.A, "Zebra"),
                new Answers(AnswerEnum.B, "Lion"),
                new Answers(AnswerEnum.C, "Hyena"),
                new Answers(AnswerEnum.D, "Pug")));
        //4
        questions.add(new Questions("Which planet in our solar system is known for its rings?", AnswerEnum.B,
                new Answers(AnswerEnum.A, "Earth"),
                new Answers(AnswerEnum.B, "Saturn"),
                new Answers(AnswerEnum.C, "Jupiter"),
                new Answers(AnswerEnum.D, "Uranus")));
        //5
        questions.add(new Questions("Which if the following is NOT a continent?", AnswerEnum.D,
                new Answers(AnswerEnum.A, "Africa"),
                new Answers(AnswerEnum.B, "South America"),
                new Answers(AnswerEnum.C, "Asia"),
                new Answers(AnswerEnum.D, "Russia")));
        //6
        questions.add(new Questions("Which of the following actors is not a martial artist?", AnswerEnum.A,
                new Answers(AnswerEnum.A, "Leonardo Dicaprio"),
                new Answers(AnswerEnum.B, "Jackie Chan"),
                new Answers(AnswerEnum.C, "Jet Lee"),
                new Answers(AnswerEnum.D, "Bruce Lee")));
        //7
        questions.add(new Questions("Which of the following animals is classified as the fastest land animal?", AnswerEnum.C,
                new Answers(AnswerEnum.A, "Antilope"),
                new Answers(AnswerEnum.B, "Tiger"),
                new Answers(AnswerEnum.C, "Cheetah"),
                new Answers(AnswerEnum.D, "Ostrich")));
        //8
        questions.add(new Questions("Which of the following is the largest animal on Earth?", AnswerEnum.A,
                new Answers(AnswerEnum.A, "Blue Whale"),
                new Answers(AnswerEnum.B, "African Elephant"),
                new Answers(AnswerEnum.C, "Giraffe"),
                new Answers(AnswerEnum.D, "Anaconda")));
        //9
        questions.add(new Questions("In which year did World War II end?", AnswerEnum.B,
                new Answers(AnswerEnum.A, "1944"),
                new Answers(AnswerEnum.B, "1945"),
                new Answers(AnswerEnum.C, "1946"),
                new Answers(AnswerEnum.D, "1947")));
        //10
        questions.add(new Questions("What was the official name of the virus that caused a global pandemic in the year 2020?", AnswerEnum.D,
                new Answers(AnswerEnum.A, "Coronavirus"),
                new Answers(AnswerEnum.B, "Swine Flu"),
                new Answers(AnswerEnum.C, "Bubonic Plague"),
                new Answers(AnswerEnum.D, "Covid-19")));
        //11
        questions.add(new Questions("What does 2+2 equal?", AnswerEnum.B,
                new Answers(AnswerEnum.A, "2"),
                new Answers(AnswerEnum.B, "4"),
                new Answers(AnswerEnum.C, "6"),
                new Answers(AnswerEnum.D, "8")));

        return questions;
    }
}
