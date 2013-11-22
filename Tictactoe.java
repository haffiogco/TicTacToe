import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Stefán
 * Date: 22.11.2013
 * Time: 18:02
 * To change this template use File | Settings | File Templates.
 */
public class Tictactoe implements ActionListener {
    private int player;
    private int board[];
    private Font f = new Font("Dialog", Font.PLAIN, 50);

    private JFrame window = new JFrame("Tic-Tac-Toe");
    private JButton[] buttons;

    public Tictactoe(){
        player = 1;
        board = new int[9];
        buttons = new JButton[9];
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

        if(checkforwin()){
            win();
        }
    }

    public boolean checkforwin(){
        for(int i = 0; i < 9; i+=3){
            if(board[i] == board[i+1] && board[i] == board[i+2] && board[i] != 0){
                return true;
            }
        }
        for(int i = 0; i < 3; i++){
            if(board[i] == board[i+3] && board[i] == board[i+6] && board[i] != 0){
                return true;
            }
        }

        if(board[0] == board[4] && board[0] == board[8] && board[0] != 0){
            return true;
        }

        if(board[2] == board[4] && board[2] == board[6] && board[2] != 0){
            return true;
        }

        return false;
    }

    public void win(){
        for(int i =0; i < buttons.length; i++){
            buttons[i].setEnabled(false);
            buttons[i].setVisible(false);
        }
    }

    public static void main(String[] args){
        new Tictactoe();
    }
}
