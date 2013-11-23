package is.ru.helloworld;


import static org.junit.Assert.assertEquals;


import org.junit.Test;

import is.ru.helloworld.Tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Stefan
 * Date: 22.11.2013
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */
public class TictactoeTest {


    public void TictactoeTest(){

    }
    @Test
    public void testWin(){
        Tictactoe T = new Tictactoe();

        try{
            //Test a player turn
            assertEquals(1, T.getPlayer());
            T.pushButton(0);
            assertEquals(1, T.getBoard(0));
            assertEquals(2, T.getPlayer());
            T.pushButton(3);
            assertEquals(2, T.getBoard(3));
            assertEquals(1, T.getPlayer());

            //Test a win
            T.pushButton(1);
            assertEquals(1, T.getBoard(1));
            assertEquals(2, T.getPlayer());
            T.pushButton(4);
            assertEquals(2, T.getBoard(4));
            assertEquals(1, T.getPlayer());
            T.pushButton(2);
            assertEquals(1, T.getBoard(2));
            assertEquals(2, T.getPlayer());

            assertEquals(true, T.getWin());
        }
        catch (AssertionError em) {
            System.out.println("Error");
        }
    }
    @Test
    public void testDraw(){
        Tictactoe T = new Tictactoe();
        int player = 1;

        try{
            for(int i = 0; i < 5; i++){
                T.pushButton(i);
                assertEquals(player, T.getBoard(i));
                if(player == 1){ player = 2;}
                else{ player = 1;}
                assertEquals(player, T.getPlayer());
            }

            T.pushButton(6);
            assertEquals(2, T.getBoard(6));
            assertEquals(1, T.getPlayer());
            T.pushButton(7);
            assertEquals(1, T.getBoard(7));
            assertEquals(2, T.getPlayer());
            T.pushButton(8);
            assertEquals(2, T.getBoard(8));
            assertEquals(1, T.getPlayer());
            T.pushButton(5);
            assertEquals(1, T.getBoard(5));
            assertEquals(2, T.getPlayer());
        }
        catch (AssertionError em){
            System.out.println("Error");
        }
    }

    public static void main(String[] args){
        TictactoeTest T = new TictactoeTest();
        T.testWin();
        T.testDraw();
    }

}
