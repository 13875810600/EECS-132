/* Sarah Whelan
 * EECS 132 Programming Project 3
 * 
 * March 31, 2014
 * 
 * JUnit test for Gomoku class
 * 
 * test two methods:
 * numberInLine
 * isOpen
 * 
 */

import org.junit.*;
import static org.junit.Assert.*;
import junit.framework.TestCase;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

public class GomokuTester extends TestCase {
  
  //creates objects on which to call our methods to test
  private Gomoku tester = new Gomoku();
  //Colors to use in creating the test array
  //black pieces
  private Color black = new Color(0, 0, 0);
  //white pieces
  private Color white = new Color(255, 255, 255);
  //default green background
  private Color green = new Color(0, 100, 0);
  
  /*test for the method numberInLine method returns the number of pieces of the same color in a group including the 
   * piece given to the method. Method takes a direction in string form with eight possible directions.
  */
  public void testNumberInLine() {
    
    //creates the array specified in the testing documentation is a 19 by 19 grid 
    JButton[][] array = new JButton[19][19];
    
    //adds buttons to the array and sets the background to green
    for(int j = 0; j<array.length; j++){
      for(int k =0; k<array[j].length; k++){
        array[j][k] = new JButton();
        array[j][k].setBackground(green);
      }
    }
    //set black tiles as specified in accompanying document
    array[0][0].setBackground(black);
    array[0][1].setBackground(black); 
    array[0][2].setBackground(black);
    array[0][3].setBackground(black); 
    array[1][17].setBackground(black);
    array[1][18].setBackground(black); 
    array[2][17].setBackground(black);
    array[2][18].setBackground(black); 
    array[3][0].setBackground(black);
    array[3][1].setBackground(black); 
    array[3][3].setBackground(black);
    array[3][4].setBackground(black);
    array[5][1].setBackground(black);
    array[5][3].setBackground(black);
    array[5][5].setBackground(black);
    array[5][18].setBackground(black);
    array[6][3].setBackground(black);
    array[7][3].setBackground(black);
    array[7][16].setBackground(black);
    array[8][3].setBackground(black);
    array[9][3].setBackground(black);
    array[10][17].setBackground(black);
    array[11][7].setBackground(black);
    array[12][5].setBackground(black);
    array[13][0].setBackground(black);
    array[13][2].setBackground(black);
    array[13][3].setBackground(black);
    array[13][4].setBackground(black);
    array[13][9].setBackground(black);
    array[13][10].setBackground(black);
    array[13][11].setBackground(black);
    array[14][1].setBackground(black);
    array[14][3].setBackground(black);
    array[14][9].setBackground(black);
    array[14][11].setBackground(black);
    array[15][4].setBackground(black);
    array[15][9].setBackground(black);
    array[15][10].setBackground(black);
    array[15][11].setBackground(black);
    array[15][15].setBackground(black);
    array[16][4].setBackground(black);
    array[16][16].setBackground(black);
    array[17][17].setBackground(black);
    array[18][0].setBackground(black);
    array[18][8].setBackground(black);
    array[18][18].setBackground(black);
    
    //set white tiles as specified in accompanying document
    array[0][4].setBackground(white);
    array[0][13].setBackground(white);
    array[0][17].setBackground(white);
    array[0][18].setBackground(white);
    array[1][0].setBackground(white);
    array[1][2].setBackground(white);
    array[2][1].setBackground(white);
    array[2][2].setBackground(white);
    array[3][2].setBackground(white);
    array[4][2].setBackground(white);
    array[4][3].setBackground(white);
    array[5][2].setBackground(white);
    array[5][4].setBackground(white);
    array[5][12].setBackground(white);
    array[5][15].setBackground(white);
    array[6][8].setBackground(white);
    array[6][11].setBackground(white);
    array[7][6].setBackground(white);
    array[7][8].setBackground(white);
    array[7][10].setBackground(white);
    array[8][0].setBackground(white);
    array[8][7].setBackground(white);
    array[8][8].setBackground(white);
    array[8][9].setBackground(white);
    array[9][6].setBackground(white);
    array[9][7].setBackground(white);
    array[9][8].setBackground(white);
    array[9][9].setBackground(white);
    array[9][10].setBackground(white);
    array[10][7].setBackground(white);
    array[10][8].setBackground(white);
    array[10][9].setBackground(white);
    array[10][16].setBackground(white);
    array[10][18].setBackground(white);
    array[11][8].setBackground(white);
    array[11][10].setBackground(white);
    array[12][1].setBackground(white);
    array[12][3].setBackground(white);
    array[12][6].setBackground(white);
    array[13][1].setBackground(white);
    array[13][5].setBackground(white);
    array[14][2].setBackground(white);
    array[14][4].setBackground(white);
    array[14][10].setBackground(white);
    array[15][3].setBackground(white);
    array[16][3].setBackground(white);
    array[16][5].setBackground(white);
    array[17][18].setBackground(white);
    array[18][17].setBackground(white);
    
    //assert tests 
    
    //Basic tests an area where the pieces are all connected and we are not in danger of an index out of bounds error
    assertEquals(4, tester.numberInLine(array, 9, 8, "up"));
    assertEquals(5, tester.numberInLine(array, 9, 8, "up-right"));
    assertEquals(3, tester.numberInLine(array, 9, 8, "right"));
    assertEquals(3, tester.numberInLine(array, 9, 8, "down-right"));
    assertEquals(3, tester.numberInLine(array, 9, 8, "down"));
    assertEquals(2, tester.numberInLine(array, 9, 8, "down-left"));
    assertEquals(3, tester.numberInLine(array, 9, 8, "left"));
    assertEquals(3, tester.numberInLine(array, 9, 8, "up-left"));
    
    //Alone tests a single piece by itself not near edges
    assertEquals(1, tester.numberInLine(array, 5, 15, "up"));
    assertEquals(1, tester.numberInLine(array, 5, 15, "up-right"));
    assertEquals(1, tester.numberInLine(array, 5, 15, "right"));
    assertEquals(1, tester.numberInLine(array, 5, 15, "down-right"));
    assertEquals(1, tester.numberInLine(array, 5, 15, "down"));
    assertEquals(1, tester.numberInLine(array, 5, 15, "down-left"));
    assertEquals(1, tester.numberInLine(array, 5, 15, "left"));
    assertEquals(1, tester.numberInLine(array, 5, 15, "up-left"));
    
    //Alone test many of the single piece case
    assertEquals(1, tester.numberInLine(array, 7, 16, "up"));
    assertEquals(1, tester.numberInLine(array, 7, 16, "up-right"));
    assertEquals(1, tester.numberInLine(array, 7, 16, "right"));
    assertEquals(1, tester.numberInLine(array, 7, 16, "down-right"));
    assertEquals(1, tester.numberInLine(array, 7, 16, "down"));
    assertEquals(1, tester.numberInLine(array, 7, 16, "down-left"));
    assertEquals(1, tester.numberInLine(array, 7, 16, "left"));
    assertEquals(1, tester.numberInLine(array, 7, 16, "up-left"));
    
    //Alone Top Row test a single piece in danger of an index out of bounds error on the top row
    assertEquals(1, tester.numberInLine(array, 0, 13, "up"));
    assertEquals(1, tester.numberInLine(array, 0, 13, "up-right"));
    assertEquals(1, tester.numberInLine(array, 0, 13, "right"));
    assertEquals(1, tester.numberInLine(array, 0, 13, "down-right"));
    assertEquals(1, tester.numberInLine(array, 0, 13, "down"));
    assertEquals(1, tester.numberInLine(array, 0, 13, "down-left"));
    assertEquals(1, tester.numberInLine(array, 0, 13, "left"));
    assertEquals(1, tester.numberInLine(array, 0, 13, "up-left"));
    
    //Alone Right Column test a single piece in danger of an index out of bounds error on the right most column
    assertEquals(1, tester.numberInLine(array, 5, 18, "up"));
    assertEquals(1, tester.numberInLine(array, 5, 18, "up-right"));
    assertEquals(1, tester.numberInLine(array, 5, 18, "right"));
    assertEquals(1, tester.numberInLine(array, 5, 18, "down-right"));
    assertEquals(1, tester.numberInLine(array, 5, 18, "down"));
    assertEquals(1, tester.numberInLine(array, 5, 18, "down-left"));
    assertEquals(1, tester.numberInLine(array, 5, 18, "left"));
    assertEquals(1, tester.numberInLine(array, 5, 18, "up-left"));
    
    //Alone Bottom Row test a single piece in danger of an index out of bounds error on the bottom row
    assertEquals(1, tester.numberInLine(array, 18, 8, "up"));
    assertEquals(1, tester.numberInLine(array, 18, 8, "up-right"));
    assertEquals(1, tester.numberInLine(array, 18, 8, "right"));
    assertEquals(1, tester.numberInLine(array, 18, 8, "down-right"));
    assertEquals(1, tester.numberInLine(array, 18, 8, "down"));
    assertEquals(1, tester.numberInLine(array, 18, 8, "down-left"));
    assertEquals(1, tester.numberInLine(array, 18, 8, "left"));
    assertEquals(1, tester.numberInLine(array, 18, 8, "up-left"));
    
    //Alone Left Column test a single piece in danger of an index out of bounds error on the left most column
    assertEquals(1, tester.numberInLine(array, 8, 0, "up"));
    assertEquals(1, tester.numberInLine(array, 8, 0, "up-right"));
    assertEquals(1, tester.numberInLine(array, 8, 0, "right"));
    assertEquals(1, tester.numberInLine(array, 8, 0, "down-right"));
    assertEquals(1, tester.numberInLine(array, 8, 0, "down"));
    assertEquals(1, tester.numberInLine(array, 8, 0, "down-left"));
    assertEquals(1, tester.numberInLine(array, 8, 0, "left"));
    assertEquals(1, tester.numberInLine(array, 8, 0, "up-left"));
    
    //Top Left Corner
    assertEquals(1, tester.numberInLine(array, 0, 0, "up"));
    assertEquals(1, tester.numberInLine(array, 0, 0, "up-right"));
    assertEquals(4, tester.numberInLine(array, 0, 0, "right"));
    assertEquals(1, tester.numberInLine(array, 0, 0, "down-right"));
    assertEquals(1, tester.numberInLine(array, 0, 0, "down"));
    assertEquals(1, tester.numberInLine(array, 0, 0, "down-left"));
    assertEquals(1, tester.numberInLine(array, 0, 0, "left"));
    assertEquals(1, tester.numberInLine(array, 0, 0, "up-left"));
    
    //Top Right Corner
    assertEquals(1, tester.numberInLine(array, 0, 18, "up"));
    assertEquals(1, tester.numberInLine(array, 0, 18, "up-right"));
    assertEquals(1, tester.numberInLine(array, 0, 18, "right"));
    assertEquals(1, tester.numberInLine(array, 0, 18, "down-right"));
    assertEquals(1, tester.numberInLine(array, 0, 18, "down"));
    assertEquals(1, tester.numberInLine(array, 0, 18, "down-left"));
    assertEquals(2, tester.numberInLine(array, 0, 18, "left"));
    assertEquals(1, tester.numberInLine(array, 0, 18, "up-left"));
    
    //Bottom Left Corner
    assertEquals(1, tester.numberInLine(array, 18, 0, "up"));
    assertEquals(1, tester.numberInLine(array, 18, 0, "up-right"));
    assertEquals(1, tester.numberInLine(array, 18, 0, "right"));
    assertEquals(1, tester.numberInLine(array, 18, 0, "down-right"));
    assertEquals(1, tester.numberInLine(array, 18, 0, "down"));
    assertEquals(1, tester.numberInLine(array, 18, 0, "down-left"));
    assertEquals(1, tester.numberInLine(array, 18, 0, "left"));
    assertEquals(1, tester.numberInLine(array, 18, 0, "up-left"));
    
    //Bottom Right Corner
    assertEquals(1, tester.numberInLine(array, 18, 18, "up"));
    assertEquals(1, tester.numberInLine(array, 18, 18, "up-right"));
    assertEquals(1, tester.numberInLine(array, 18, 18, "right"));
    assertEquals(1, tester.numberInLine(array, 18, 18, "down-right"));
    assertEquals(1, tester.numberInLine(array, 18, 18, "down"));
    assertEquals(1, tester.numberInLine(array, 18, 18, "down-left"));
    assertEquals(1, tester.numberInLine(array, 18, 18, "left"));
    assertEquals(4, tester.numberInLine(array, 18, 18, "up-left"));
    
    //Test Many
    assertEquals(1, tester.numberInLine(array, 10, 17, "up"));
    assertEquals(1, tester.numberInLine(array, 10, 17, "up-right"));
    assertEquals(1, tester.numberInLine(array, 10, 17, "right"));
    assertEquals(1, tester.numberInLine(array, 10, 17, "down-right"));
    assertEquals(1, tester.numberInLine(array, 10, 17, "down"));
    assertEquals(1, tester.numberInLine(array, 10, 17, "down-left"));
    assertEquals(1, tester.numberInLine(array, 10, 17, "left"));
    assertEquals(1, tester.numberInLine(array, 10, 17, "up-left"));
    
    //Test Many
    assertEquals(1, tester.numberInLine(array, 14, 10, "up"));
    assertEquals(1, tester.numberInLine(array, 14, 10, "up-right"));
    assertEquals(1, tester.numberInLine(array, 14, 10, "right"));
    assertEquals(1, tester.numberInLine(array, 14, 10, "down-right"));
    assertEquals(1, tester.numberInLine(array, 14, 10, "down"));
    assertEquals(1, tester.numberInLine(array, 14, 10, "down-left"));
    assertEquals(1, tester.numberInLine(array, 14, 10, "left"));
    assertEquals(1, tester.numberInLine(array, 14, 10, "up-left"));
    
    //Test Many
    assertEquals(1, tester.numberInLine(array, 13, 3, "up"));
    assertEquals(1, tester.numberInLine(array, 13, 3, "up-right"));
    assertEquals(2, tester.numberInLine(array, 13, 3, "right"));
    assertEquals(1, tester.numberInLine(array, 13, 3, "down-right"));
    assertEquals(2, tester.numberInLine(array, 13, 3, "down"));
    assertEquals(1, tester.numberInLine(array, 13, 3, "down-left"));
    assertEquals(2, tester.numberInLine(array, 13, 3, "left"));
    assertEquals(1, tester.numberInLine(array, 13, 3, "up-left"));
  }

  /* 
   * test for isOpen method - the method returns true if the group the piece is in is open in the direction specified
   * meaning that the end of the group is a green space not outside of the array or a different color
   */
  public void testIsOpen() {
    //creates array as specified in accompanying document 19 by 19 and creates buttons and sets background to green
    JButton[][] array = new JButton[19][19];
    for(int j = 0; j<array.length; j++){
      for(int k =0; k<array[j].length; k++){
        array[j][k] = new JButton();
        array[j][k].setBackground(green);
      }
    }
    //set black tiles as specified in accompanying document
    array[0][0].setBackground(black);
    array[0][1].setBackground(black); 
    array[0][2].setBackground(black);
    array[0][3].setBackground(black); 
    array[1][17].setBackground(black);
    array[1][18].setBackground(black); 
    array[2][17].setBackground(black);
    array[2][18].setBackground(black); 
    array[3][0].setBackground(black);
    array[3][1].setBackground(black); 
    array[3][3].setBackground(black);
    array[3][4].setBackground(black);
    array[5][1].setBackground(black);
    array[5][3].setBackground(black);
    array[5][5].setBackground(black);
    array[5][18].setBackground(black);
    array[6][3].setBackground(black);
    array[7][3].setBackground(black);
    array[7][16].setBackground(black);
    array[8][3].setBackground(black);
    array[9][3].setBackground(black);
    array[10][17].setBackground(black);
    array[11][7].setBackground(black);
    array[12][5].setBackground(black);
    array[13][0].setBackground(black);
    array[13][2].setBackground(black);
    array[13][3].setBackground(black);
    array[13][4].setBackground(black);
    array[13][9].setBackground(black);
    array[13][10].setBackground(black);
    array[13][11].setBackground(black);
    array[14][1].setBackground(black);
    array[14][3].setBackground(black);
    array[14][9].setBackground(black);
    array[14][11].setBackground(black);
    array[15][4].setBackground(black);
    array[15][9].setBackground(black);
    array[15][10].setBackground(black);
    array[15][11].setBackground(black);
    array[15][15].setBackground(black);
    array[16][4].setBackground(black);
    array[16][16].setBackground(black);
    array[17][17].setBackground(black);
    array[18][0].setBackground(black);
    array[18][8].setBackground(black);
    array[18][18].setBackground(black);
    
    //set white tiles as specified in accompanying document
    array[0][4].setBackground(white);
    array[0][13].setBackground(white);
    array[0][17].setBackground(white);
    array[0][18].setBackground(white);
    array[1][0].setBackground(white);
    array[1][2].setBackground(white);
    array[2][1].setBackground(white);
    array[2][2].setBackground(white);
    array[3][2].setBackground(white);
    array[4][2].setBackground(white);
    array[4][3].setBackground(white);
    array[5][2].setBackground(white);
    array[5][4].setBackground(white);
    array[5][12].setBackground(white);
    array[5][15].setBackground(white);
    array[6][8].setBackground(white);
    array[6][11].setBackground(white);
    array[7][6].setBackground(white);
    array[7][8].setBackground(white);
    array[7][10].setBackground(white);
    array[8][0].setBackground(white);
    array[8][7].setBackground(white);
    array[8][8].setBackground(white);
    array[8][9].setBackground(white);
    array[9][6].setBackground(white);
    array[9][7].setBackground(white);
    array[9][8].setBackground(white);
    array[9][9].setBackground(white);
    array[9][10].setBackground(white);
    array[10][7].setBackground(white);
    array[10][8].setBackground(white);
    array[10][9].setBackground(white);
    array[10][16].setBackground(white);
    array[10][18].setBackground(white);
    array[11][8].setBackground(white);
    array[11][10].setBackground(white);
    array[12][1].setBackground(white);
    array[12][3].setBackground(white);
    array[12][6].setBackground(white);
    array[13][1].setBackground(white);
    array[13][5].setBackground(white);
    array[14][2].setBackground(white);
    array[14][4].setBackground(white);
    array[14][10].setBackground(white);
    array[15][3].setBackground(white);
    array[16][3].setBackground(white);
    array[16][5].setBackground(white);
    array[17][18].setBackground(white);
    array[18][17].setBackground(white);
    
    //assert
    
    //Basic just tests standard playing area no index out of bounds exception to worry about
    assertEquals(true, tester.isOpen(array, 9, 8, "up"));
    assertEquals(true, tester.isOpen(array, 9, 8, "up-right"));
    assertEquals(true, tester.isOpen(array, 9, 8, "right"));
    assertEquals(true, tester.isOpen(array, 9, 8, "down-right"));
    assertEquals(true, tester.isOpen(array, 9, 8, "down"));
    assertEquals(true, tester.isOpen(array, 9, 8, "down-left"));
    assertEquals(true, tester.isOpen(array, 9, 8, "left"));
    assertEquals(true, tester.isOpen(array, 9, 8, "up-left"));
    
    //Alone test a single piece
    assertEquals(true, tester.isOpen(array, 5, 15, "up"));
    assertEquals(true, tester.isOpen(array, 5, 15, "up-right"));
    assertEquals(true, tester.isOpen(array, 5, 15, "right"));
    assertEquals(true, tester.isOpen(array, 5, 15, "down-right"));
    assertEquals(true, tester.isOpen(array, 5, 15, "down"));
    assertEquals(true, tester.isOpen(array, 5, 15, "down-left"));
    assertEquals(true, tester.isOpen(array, 5, 15, "left"));
    assertEquals(true, tester.isOpen(array, 5, 15, "up-left"));
    
    //Alone test a different single piece
    assertEquals(true, tester.isOpen(array, 7, 16, "up"));
    assertEquals(true, tester.isOpen(array, 7, 16, "up-right"));
    assertEquals(true, tester.isOpen(array, 7, 16, "right"));
    assertEquals(true, tester.isOpen(array, 7, 16, "down-right"));
    assertEquals(true, tester.isOpen(array, 7, 16, "down"));
    assertEquals(true, tester.isOpen(array, 7, 16, "down-left"));
    assertEquals(true, tester.isOpen(array, 7, 16, "left"));
    assertEquals(true, tester.isOpen(array, 7, 16, "up-left"));
    
    //Alone Top Row test a single piece in danger of an index out of bounds error on the top row
    assertEquals(false, tester.isOpen(array, 0, 13, "up"));
    assertEquals(false, tester.isOpen(array, 0, 13, "up-right"));
    assertEquals(true, tester.isOpen(array, 0, 13, "right"));
    assertEquals(true, tester.isOpen(array, 0, 13, "down-right"));
    assertEquals(true, tester.isOpen(array, 0, 13, "down"));
    assertEquals(true, tester.isOpen(array, 0, 13, "down-left"));
    assertEquals(true, tester.isOpen(array, 0, 13, "left"));
    assertEquals(false, tester.isOpen(array, 0, 13, "up-left"));
    
    //Alone Right Column test a single piece in danger of an index out of bounds error on the right most column
    assertEquals(true, tester.isOpen(array, 5, 18, "up"));
    assertEquals(false, tester.isOpen(array, 5, 18, "up-right"));
    assertEquals(false, tester.isOpen(array, 5, 18, "right"));
    assertEquals(false, tester.isOpen(array, 5, 18, "down-right"));
    assertEquals(true, tester.isOpen(array, 5, 18, "down"));
    assertEquals(true, tester.isOpen(array, 5, 18, "down-left"));
    assertEquals(true, tester.isOpen(array, 5, 18, "left"));
    assertEquals(true, tester.isOpen(array, 5, 18, "up-left"));
    
    //Alone Bottom Row test a single piece in danger of an index out of bounds error on the bottom row
    assertEquals(true, tester.isOpen(array, 18, 8, "up"));
    assertEquals(true, tester.isOpen(array, 18, 8, "up-right"));
    assertEquals(true, tester.isOpen(array, 18, 8, "right"));
    assertEquals(false, tester.isOpen(array, 18, 8, "down-right"));
    assertEquals(false, tester.isOpen(array, 18, 8, "down"));
    assertEquals(false, tester.isOpen(array, 18, 8, "down-left"));
    assertEquals(true, tester.isOpen(array, 18, 8, "left"));
    assertEquals(true, tester.isOpen(array, 18, 8, "up-left"));
    
    //Alone Left Column test a single piece in danger of an index out of bounds error on the left most column
    assertEquals(true, tester.isOpen(array, 8, 0, "up"));
    assertEquals(true, tester.isOpen(array, 8, 0, "up-right"));
    assertEquals(true, tester.isOpen(array, 8, 0, "right"));
    assertEquals(true, tester.isOpen(array, 8, 0, "down-right"));
    assertEquals(true, tester.isOpen(array, 8, 0, "down"));
    assertEquals(false, tester.isOpen(array, 8, 0, "down-left"));
    assertEquals(false, tester.isOpen(array, 8, 0, "left"));
    assertEquals(false, tester.isOpen(array, 8, 0, "up-left"));
    
    //Top Left Corner
    assertEquals(false, tester.isOpen(array, 0, 0, "up"));
    assertEquals(false, tester.isOpen(array, 0, 0, "up-right"));
    assertEquals(false, tester.isOpen(array, 0, 0, "right"));
    assertEquals(true, tester.isOpen(array, 0, 0, "down-right"));
    assertEquals(false, tester.isOpen(array, 0, 0, "down"));
    assertEquals(false, tester.isOpen(array, 0, 0, "down-left"));
    assertEquals(false, tester.isOpen(array, 0, 0, "left"));
    assertEquals(false, tester.isOpen(array, 0, 0, "up-left"));
    
    //Top Right Corner
    assertEquals(false, tester.isOpen(array, 0, 18, "up"));
    assertEquals(false, tester.isOpen(array, 0, 18, "up-right"));
    assertEquals(false, tester.isOpen(array, 0, 18, "right"));
    assertEquals(false, tester.isOpen(array, 0, 18, "down-right"));
    assertEquals(false, tester.isOpen(array, 0, 18, "down"));
    assertEquals(false, tester.isOpen(array, 0, 18, "down-left"));
    assertEquals(true, tester.isOpen(array, 0, 18, "left"));
    assertEquals(false, tester.isOpen(array, 0, 18, "up-left"));
    
    //Bottom Left Corner
    assertEquals(true, tester.isOpen(array, 18, 0, "up"));
    assertEquals(true, tester.isOpen(array, 18, 0, "up-right"));
    assertEquals(true, tester.isOpen(array, 18, 0, "right"));
    assertEquals(false, tester.isOpen(array, 18, 0, "down-right"));
    assertEquals(false, tester.isOpen(array, 18, 0, "down"));
    assertEquals(false, tester.isOpen(array, 18, 0, "down-left"));
    assertEquals(false, tester.isOpen(array, 18, 0, "left"));
    assertEquals(false, tester.isOpen(array, 18, 0, "up-left"));
    
    //Bottom Right Corner
    assertEquals(false, tester.isOpen(array, 18, 18, "up"));
    assertEquals(false, tester.isOpen(array, 18, 18, "up-right"));
    assertEquals(false, tester.isOpen(array, 18, 18, "right"));
    assertEquals(false, tester.isOpen(array, 18, 18, "down-right"));
    assertEquals(false, tester.isOpen(array, 18, 18, "down"));
    assertEquals(false, tester.isOpen(array, 18, 18, "down-left"));
    assertEquals(false, tester.isOpen(array, 18, 18, "left"));
    assertEquals(true, tester.isOpen(array, 18, 18, "up-left"));
    
    //Test Many
    assertEquals(true, tester.isOpen(array, 10, 17, "up"));
    assertEquals(true, tester.isOpen(array, 10, 17, "up-right"));
    assertEquals(false, tester.isOpen(array, 10, 17, "right"));
    assertEquals(true, tester.isOpen(array, 10, 17, "down-right"));
    assertEquals(true, tester.isOpen(array, 10, 17, "down"));
    assertEquals(true, tester.isOpen(array, 10, 17, "down-left"));
    assertEquals(false, tester.isOpen(array, 10, 17, "left"));
    assertEquals(true, tester.isOpen(array, 10, 17, "up-left"));
    
    //Test Many
    assertEquals(false, tester.isOpen(array, 14, 10, "up"));
    assertEquals(false, tester.isOpen(array, 14, 10, "up-right"));
    assertEquals(false, tester.isOpen(array, 14, 10, "right"));
    assertEquals(false, tester.isOpen(array, 14, 10, "down-right"));
    assertEquals(false, tester.isOpen(array, 14, 10, "down"));
    assertEquals(false, tester.isOpen(array, 14, 10, "down-left"));
    assertEquals(false, tester.isOpen(array, 14, 10, "left"));
    assertEquals(false, tester.isOpen(array, 14, 10, "up-left"));
    
    //Test Many
    assertEquals(false, tester.isOpen(array, 13, 3, "up"));
    assertEquals(true, tester.isOpen(array, 13, 3, "up-right"));
    assertEquals(false, tester.isOpen(array, 13, 3, "right"));
    assertEquals(false, tester.isOpen(array, 13, 3, "down-right"));
    assertEquals(false, tester.isOpen(array, 13, 3, "down"));
    assertEquals(false, tester.isOpen(array, 13, 3, "down-left"));
    assertEquals(false, tester.isOpen(array, 13, 3, "left"));
    assertEquals(true, tester.isOpen(array, 13, 3, "up-left"));
  }
}