package Mylla;

	import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


	public class Mylla  implements ActionListener {
		int count = 0;
		char[][]score = new char[3][3];
	private JFrame window = new JFrame("Tic-Tac-Toe");
	private JButton button1 = new JButton("");
	private JButton button2 = new JButton("");
	private JButton button3 = new JButton("");
	private JButton button4 = new JButton("");
	private JButton button5 = new JButton("");
	private JButton button6 = new JButton("");
	private JButton button7 = new JButton("");
	private JButton button8 = new JButton("");
	private JButton button9 = new JButton("");



	public Mylla(){
		for(int i = 0; i <3; i++)
		{
			for(int s = 0; s<3;s++)
			{
				score[i][s] = 'E';
			}
		}
		
	
	/*Create Window*/
	window.setSize(400,400);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	window.setLayout(new GridLayout(3,3));

	window.add(button1);
	window.add(button2);
	window.add(button3);
	window.add(button4);
	window.add(button5);
	window.add(button6);
	window.add(button7);
	window.add(button8);
	window.add(button9);

	button1.addActionListener(this);
	button2.addActionListener(this);
	button3.addActionListener(this);
	button4.addActionListener(this);
	button5.addActionListener(this);
	button6.addActionListener(this);
	button7.addActionListener(this);
	button8.addActionListener(this);
	button9.addActionListener(this);

	window.setVisible(true);
	}
	
	public void pressed(JButton button){
		if(count %2 ==0)
		{
			button.setText("X");  
		}
		else{
			button.setText("O");
		}
		count+=1;
		button.setEnabled(false);
		
		checkforwin();
	}
	public void checkforwin(){
		if(score[0][0] == score[0][1] &&score[0][1] == score[0][2] && score[0][0] != 'E' )
		{
			
			winner(score[0][0]);
		}
		else if(score[1][0] == score[1][1] &&score[1][1] == score[1][2] && score[1][0] != 'E' )
		{
			winner(score[1][0]);
		}
		else if(score[2][0] == score[2][1] &&score[2][1] == score[2][2] && score[2][0] != 'E' )
		{
			winner(score[2][0]);
		}
		else if(score[0][0] == score[1][0] &&score[1][0] == score[2][0] && score[0][0] != 'E' )
		{
			winner(score[0][0]);
		}
		else if(score[0][1] == score[1][1] &&score[1][1] == score[2][1] && score[0][1] != 'E' )
		{
			winner(score[0][1]);
		}
		else if(score[0][2] == score[1][2] &&score[1][2] == score[2][2] && score[0][2] != 'E' )
		{
			winner(score[0][2]);
		}
		else if(score[0][0] == score[1][1] &&score[1][1] == score[2][2] && score[0][0] != 'E' )
		{
			winner(score[0][0]);	
		}
		else if(score[0][2] == score[1][1] &&score[1][1] == score[2][0] && score[0][2] != 'E')
		{
			winner(score[0][2]);
		}
		else if(count == 9){
			
			System.out.println("we have a Draw!");
		}
	}
	public void winner(char x){
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);
		if(x =='X')
		{	
		System.out.println("Player 1 Wins!");
		}
		else{
			System.out.println("Player 2 Wins!");
		}
	}
	public void actionPerformed(ActionEvent e) {
		{
			
	    	if(e.getSource() == button1){
	    		if(count%2 == 0){
	    			score[0][0] = 'X';
	    		}
	    		else{
	    			score[0][0] = 'O';
	    		}
	    		pressed(button1);
	    		
	    	}
	    	else if(e.getSource() == button2){
	    		if(count%2 == 0){
	    			score[0][1] = 'X';
	    		}
	    		else{
	    			score[0][1] = 'O';
	    		}
	    		pressed(button2);
	    	}
	    	else if(e.getSource() == button3){
	    		if(count%2 == 0){
	    			score[0][2] = 'X';
	    		}
	    		else{
	    			score[0][2] = 'O';
	    		}
	    		pressed(button3);
	    	}
	    	else if(e.getSource() == button4){
	    		if(count%2 == 0){
	    			score[1][0] = 'X';
	    		}
	    		else{
	    			score[1][0] = 'O';
	    		}
	    		pressed(button4);
	    	}
	    	else if(e.getSource() == button5){
	    		if(count%2 == 0){
	    			score[1][1] = 'X';
	    		}
	    		else{
	    			score[1][1] = 'O';
	    		}
	    		pressed(button5);
	    	}
	    	else if(e.getSource() == button6){
	    		if(count%2 == 0){
	    			score[1][2] = 'X';
	    		}
	    		else{
	    			score[1][2] = 'O';
	    		}
	    		pressed(button6);
	    	}
	    	else if(e.getSource() == button7){
	    		if(count%2 == 0){
	    			score[2][0] = 'X';
	    		}
	    		else{
	    			score[2][0] = 'O';
	    		}
	    		pressed(button7);
	    		
	    	}
	    	else if(e.getSource() == button8){
	    		if(count%2 == 0){
	    			score[2][1] = 'X';
	    		}
	    		else{
	    			score[2][1] = 'O';
	    		}
	    		pressed(button8);
	    	}
	    	else if(e.getSource() == button9){
	    		if(count%2 == 0){
	    			score[2][2] = 'X';
	    		}
	    		else{
	    			score[2][2] = 'O';
	    		}
	    		pressed(button9);
	    	}
	    }

	}

	public static void main(String[] args){
		
			new Mylla();
	  }
	}

	
