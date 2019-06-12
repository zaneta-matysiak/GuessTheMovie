package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieGame {


    private String choosenMovie;

    private char[] charArrayGuess;

    public char[] getCharArrayGuess() {
        return this.charArrayGuess;
    }

    private ArrayList<Character> wrongLetters = new ArrayList<>();

    public ArrayList<Character> getWrongLetters() {
        return wrongLetters;
    }


    public void chooseRandomMovie() throws FileNotFoundException {

        File file = new File("/home/zaneta/Documents/Sources/GuessTheMovie/src/movieList.txt");
        Scanner scanner = new Scanner(file);

        int countLine;
        ArrayList<String> Movies = new ArrayList<String>();

        for( countLine = 0; scanner.hasNextLine(); countLine++){
            String line = scanner.nextLine();
            Movies.add(line);
        }

        int randomLine = (int)(Math.random() * countLine);
        String randomMovie = Movies.get(randomLine);
        System.out.println(randomMovie);

        this.choosenMovie = randomMovie;
    }

    public void firstChangeLetters() {

        char[] charArrayGuess = this.choosenMovie.toCharArray();

        for (int i = 0; i < charArrayGuess.length; i++){
            if (charArrayGuess[i] != ' '){
                charArrayGuess[i] = '*';
            }
        }
        System.out.println(charArrayGuess);

        this.charArrayGuess = charArrayGuess;

    }

    public boolean checkLetter(char letter){

        boolean result = true;

        int index = this.choosenMovie.indexOf(letter);

        if (index < 0){
            this.wrongLetters.add(letter);
            result = false;
            if (this.wrongLetters.size() == 10){
                System.out.println("GAME OVER! You make 10 mistakes!. This film was: ");
                System.out.println(choosenMovie);
                System.out.println();
                System.exit(0);
            }
        }

        while ( index >= 0){
            this.charArrayGuess[index] = letter;
            index = this.choosenMovie.indexOf(letter, index +1);

        }

        return result;
    }

    public boolean checkWinner(){

        if (new String(this.charArrayGuess).contains("*") == false){
            System.out.println("GRATULATIONS! You guess the title!");
            return true;
        }
        else{
            return false;
        }
    }

}
