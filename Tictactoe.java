package Mylla;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Tictactoe implements ActionListener {
    private int player;
    private int board[];
    private int counter;
    private boolean win;
    private Font f = new Font("Dialog", Font.PLAIN, 50);

    private JFrame window = new JFrame("Tic-Tac-Toe");
    private JButton[] buttons;

    public Tictactoe(){
        player = 1;
        board = new int[9];
        buttons = new JButton[9];
        win = false;
        counter= 0;
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
        }

        for (int i = 0; i < board.length; i++){
            board[i] = 0;
        }

        windowSetup();

    }

    public void windowSetup(){
        window.setSize(400,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new GridLayout(3,3));

        for(int i =0; i < buttons.length; i++){
            window.add(buttons[i]).setFont(f);
            buttons[i].addActionListener(this);
        }

        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.

        for(int i = 0; i < buttons.length; i++){
            if(e.getSource() == buttons[i]){
                board[i] = player;
                buttonPressed(i);
            }
        }

        if(player == 1){
            player = 2;
        }
        else{
            player = 1;
        }
    }

    public void buttonPressed(int bNr) {
        if(player == 1){
            buttons[bNr].setText("X");
        }
        else{
            buttons[bNr].setText("O");
        }
        buttons[bNr].setEnabled(false);
        checkforwin();
        
        counter+=1;
        if(counter == 9)
        {
        	gameOver();
        }
        
        
        
        	
    }

    public void checkforwin(){
        for(int i = 0; i < 9; i+=3){
            if(board[i] == board[i+1] && board[i] == board[i+2] && board[i] != 0){
                win = true;
                gameOver();
                
            }
        }
        for(int i = 0; i < 3; i++){
            if(board[i] == board[i+3] && board[i] == board[i+6] && board[i] != 0){
            	win = true;
                gameOver();
            }
        }

        if(board[0] == board[4] && board[0] == board[8] && board[0] != 0){
        	win = true;
            gameOver();
        }

        if(board[2] == board[4] && board[2] == board[6] && board[2] != 0){
        	win = true;
            gameOver();
        }

    }

    public void gameOver(){
        for(int i =0; i < buttons.length; i++){
            buttons[i].setEnabled(false);
            buttons[i].setVisible(false);
        }
        for(int i = 3; i<9;i++)
        {
        	window.remove(buttons[i]);
        }
        if(win == true){
	        buttons[1].setText("Player "+player+" wins");
	        buttons[1].setBackground(Color.white);
	        buttons[1].setVisible(true);
        }
        else{
        	 buttons[1].setText("Draw");
             buttons[1].setBackground(Color.white);
             buttons[1].setVisible(true);
        }
    }

    public static void main(String[] args){
        new Tictactoe();
    }
}
