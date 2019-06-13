package com.company;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class GuessMovie {

    private static MovieGame game = new MovieGame();

    public static void main(String[] args) throws FileNotFoundException {

        game.chooseRandomMovie();
        game.firstChangeLetters();
        firstMessage();
        userGuesses();
    }

    public static void firstMessage(){

        System.out.println("Hello! This is a game \"Guess the film title\". " +
                "Computer randomly choose film and your challenge is guess which" +
                "Give the single letters, you can make 10 mistakes. Good luck!");

        System.out.print("Film is: ");
        System.out.println(game.getCharArrayGuess());
        System.out.println("Start guess! :)");
        System.out.println();

    }

    public static void userGuesses(){

        Scanner scanner = new Scanner(System.in);

        game.getWrongLetters();

        for (int i = 0; i < 10; ){
            String guess = scanner.nextLine();

            if (game.checkLetter(guess.charAt(0))){
                if(game.checkWinner()) {
                    break;
                }
                else{
                    System.out.println("You guess letter " + guess + " !");
                    System.out.print("Now your film looks like this: ");
                    System.out.print(game.getCharArrayGuess());
                    System.out.println();
                }
            }

            else{
                i++;
                System.out.println("Sorry, but this title don't have letter " + guess);
                System.out.print("Your wrong letters (" + i + "): ");
                System.out.println(game.getWrongLetters());
                System.out.println("Try again. You can make " + (10-i) + " mistakes yet");
                System.out.print(game.getCharArrayGuess());
                System.out.println();

            }

        }
    }
}
