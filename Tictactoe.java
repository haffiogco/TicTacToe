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
    private int Player;
    private int board[];
    private Font f = new Font("Dialog", Font.PLAIN, 50);

    private JFrame window = new JFrame("Tic-Tac-Toe");
    private JButton[] buttons;

    public Tictactoe(){
        board = new int[9];
        buttons = new JButton[9];
        for(JButton i : buttons){
            i = new JButton("");
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

        for(JButton i : buttons){
            window.add(i).setFont(f);
            i.addActionListener(this);
        }

        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public static void main(String[] args){
        new Tictactoe();
    }
}
