package com.bootcamp2021.app;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private final int random;
    private int round = 5;
    private int guess;
    private final Scanner sc;

    // constructor
    public GuessGame(){
        this.random = new Random().nextInt(101 - 1) + 1;
        this.sc = new Scanner(System.in);
        System.out.println(random);
    }

    private void validateGuess(){
        while(this.guess > 100 || this.guess < 1){
            System.out.println("Your guess is not between 1 and 100, please try again!");
            // override current guess when current is out of range
            this.guess = this.sc.nextInt();
        }
        this.round--;
    }

    private void setGuess(){
        System.out.println("Pick a number between 1 and 100: ");
        // current guess
        this.guess = this.sc.nextInt();
        validateGuess();
    }

    public void play(){
        // request the 1st guess
        setGuess();
        while (this.round != 0){
            if (this.guess > this.random){
                System.out.println("Please pick a lower number");
                setGuess();
            }else if (this.guess  < this.random){
                System.out.println("Please pick a higher number!");
                setGuess();
            }else{
                System.out.println("You won!");
            return ;
            }
        };
        // for the last guess we do not give the option to choose lower or higher number
        // hence the last guess does not goes through the validation process, as the result here we just check
        // whether it is matches or not
        if (this.guess == this.random){
            System.out.println("You won!");
        }else{
            System.out.println("You lose, the number to guess was " + this.random);
        }

    }

}
