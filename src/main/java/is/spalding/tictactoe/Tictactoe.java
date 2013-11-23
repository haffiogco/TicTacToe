package is.spalding.tictactoe;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;

public class Tictactoe{
    private int player;
    private int board[];
    private int counter;
    private boolean win;
    private boolean gameOver;

    public Tictactoe(){
        player = 1;
        board = new int[9];
        win = false;
        gameOver = false;
        counter= 0;

        for (int i = 0; i < board.length; i++){
            board[i] = 0;
        }

    }

    public void buttonPressed(int bNr) {
        board[bNr] = player;
        checkforwin();
        counter+=1;
        if(counter == 9)
        {
            gameOver = true;
        }

        if(gameOver != true){
            if(player == 1){
                player = 2;
            }
            else{
                player = 1;
            }
        }


    }

    public void checkforwin(){
        for(int i = 0; i < 9; i+=3){
            if(board[i] == board[i+1] && board[i] == board[i+2] && board[i] != 0){
                win = true;
                gameOver = true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(board[i] == board[i+3] && board[i] == board[i+6] && board[i] != 0){
                win = true;
                gameOver = true;
            }
        }

        if(board[0] == board[4] && board[0] == board[8] && board[0] != 0){
            win = true;
            gameOver = true;
        }

        if(board[2] == board[4] && board[2] == board[6] && board[2] != 0){
            win = true;
            gameOver = true;
        }

    }

    public int getPlayer(){
        return player;
    }

    public int getTurn(){
        return counter;
    }

    public int getBoard(int n){
        return board[n];
    }

    public boolean getWin(){
        return win;
    }

    public static void main(String[] args){
        new Tictactoe();
    }
    public boolean getGameOver(){
        return gameOver;
    }

    public void pushButton(int bNr){
        buttonPressed(bNr);
    }
}