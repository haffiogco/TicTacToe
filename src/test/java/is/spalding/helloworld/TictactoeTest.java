package is.spalding.helloworld;


import static org.junit.Assert.assertEquals;


import junit.framework.Assert;
import org.junit.Test;

import is.spalding.tictactoe.Tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Stefan
 * Date: 22.11.2013
 * Time: 19:36
 * To change this template use File | Settings | File Templates.
 */
import Tictactoe.Tictactoe;

/**
 * Created with IntelliJ IDEA.
 * User: Stefán
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
            //Test á player turn
            Assert.assertEquals(1, T.getPlayer());
            T.pushButton(0);
            Assert.assertEquals(1, T.getBoard(0));
            Assert.assertEquals(2, T.getPlayer());
            T.pushButton(3);
            Assert.assertEquals(2, T.getBoard(3));
            Assert.assertEquals(1, T.getPlayer());

            //Test á win
            T.pushButton(1);
            Assert.assertEquals(1, T.getBoard(1));
            Assert.assertEquals(2, T.getPlayer());
            T.pushButton(4);
            Assert.assertEquals(2, T.getBoard(4));
            Assert.assertEquals(1, T.getPlayer());
            T.pushButton(2);
            Assert.assertEquals(1, T.getBoard(2));

            Assert.assertEquals(true, T.getWin());
            Assert.assertEquals(true, T.getGameOver());
        }
        catch (AssertionError em) {
            System.out.println("Error");
        }
    }

    public void testDraw(){
        Tictactoe T = new Tictactoe();
        int player = 1;

        try{
            for(int i = 0; i < 5; i++){
                T.pushButton(i);
                Assert.assertEquals(player, T.getBoard(i));
                if(player == 1){ player = 2;}
                else{ player = 1;}
                Assert.assertEquals(player, T.getPlayer());
            }

            T.pushButton(6);
            Assert.assertEquals(2, T.getBoard(6));
            Assert.assertEquals(1, T.getPlayer());
            T.pushButton(7);
            Assert.assertEquals(1, T.getBoard(7));
            Assert.assertEquals(2, T.getPlayer());
            T.pushButton(8);
            Assert.assertEquals(2, T.getBoard(8));
            Assert.assertEquals(1, T.getPlayer());
            T.pushButton(5);
            Assert.assertEquals(1, T.getBoard(5));
            Assert.assertEquals(true, T.getGameOver());
        }
        catch (AssertionError em){
            System.out.println("Error");
        }
    }

    public static void main(String[] args){
        TictactoeTest T = new TictactoeTest();
        T.testWin();
        //T.testDraw();
    }

}