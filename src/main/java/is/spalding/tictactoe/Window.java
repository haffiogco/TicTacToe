package is.spalding.tictactoe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Stefán
 * Date: 23.11.2013
 * Time: 22:19
 * To change this template use File | Settings | File Templates.
 */
public class Window implements ActionListener{
    private Font f = new Font("Dialog", Font.PLAIN, 50);

    private JFrame window = new JFrame("Tic-Tac-Toe");
    private JButton[] buttons;

    Tictactoe T;

    public Window(){
        buttons = new JButton[9];

        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
        }

        windowSetup();
        T = new Tictactoe();

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
                if(T.getPlayer() == 1){
                    buttons[i].setText("X");
                }
                else{
                    buttons[i].setText("O");
                }
                buttons[i].setEnabled(false);
                T.buttonPressed(i);
            }
        }

        if(T.getGameOver() == true){
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
        if(T.getWin() == true){
            buttons[1].setText("Player "+T.getPlayer()+" wins");
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
        Window W = new Window();
    }
}
