/* Sarah Whelan slw96 
 * EECS 132 Programming Project 3 
 * 
 * March 31, 2014
 * 
 * Gomoku Game
 * 
 * The game is played on a grid and the goal is to get five (exactly) five of the same color pieces in a row. 
 * Play alternates between colors beginning with white.
 * 
 * No move may create more than one open group of four of the color that was played nor may it create more than one
 * open group of three. 
 * 
 * @author Sarah Whelan
 */

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gomoku extends JFrame implements ActionListener {
  
  /*
   * creates the three colors of the pieces green is the default background while the players place the black and white
   * tiles. The first move is a white piece then play alternates.
   */
  
  //background color for black pieces
  private Color black = new Color(0, 0, 0);
  
  //background color for white pieces
  private Color white = new Color(255, 255, 255);
  
  //default background color
  private Color green = new Color(0, 100, 0);
  
  //determines which color is placed white is placed first.
  private int player = 0;
  
  //this is the array to hold the JButton that makes up the game board each tile is a button and changes when clicked
  private JButton[][] array;
  
  //boolean value stops game play - once game ends button clicks do nothing
  private boolean gameOver = false;
  
  //counts the number of open groups of four created by any one move
  private int fourByFour = 0;
  
  //counts the number of open groups of four created by any one move
  private int threeByThree = 0;
  
  //coutns the numebr of moves and checks against remaining tiles to end the game if there are no more moves
  private int numMoves = 0;
  
  /*
   * main method two command line arguments specify the size of the grid
   * 
   * @param String[] args comand line arguments to specify size of board firs argument - row second - column
   */
  public static void main(String[] args){
    if(args.length == 1 || args.length > 2){
      System.out.println("Please check your arguments only two int values are accepted.");
    } else if(args.length == 2){
      try {
        Gomoku game = new Gomoku(Integer.parseInt(args[0]),  Integer.parseInt(args[1]));
      }
      catch (NumberFormatException e) {
        System.out.println("Please check your arguments only two int values are accepted.");
      }
    } else {
      Gomoku game = new Gomoku();
    }
  }
  
  
  //default constructor for a gomoku instance creates a 19 by 19 grid of buttons
  public Gomoku(){
    this(19, 19);
  }

  /*  
   * constructor that creates an arbitrarily sized grid there is no minimum size
   * 
   * @param int row specifies number of rows for gomoku board
   * @param int column specifies number of columns for gomoku board
   */
  public Gomoku(int row, int column){
    //creates a grid layout to organize the buttons in a grid
    GridLayout grid = new GridLayout(row, column);
    //creates the array of JButtons that creates the grid
    array = new JButton[row][column];
    //creates a JPanel with the grid layout
    JPanel board = new JPanel(grid);
    
    /*
     * iterates through the rows and columns of the array of JButtons after each iteration of the outside for loop 
     * an entire row will have been traversed and each iteration of the interior for loop a single place in the array
     * will be a JButton
     *
     */
    
    for(int j = 0; j<array.length; j++){
      for(int k =0; k<array[j].length; k++){
        
        /*creates a JButton in a place in the array sets the default background, sets the actionListener
         * to react when the button is clicked and adds the button to the board
         */
        
        array[j][k] = new JButton();
        array[j][k].setBackground(green);
        array[j][k].addActionListener(this);
        board.add(array[j][k]);
      }
    }
    //places the board on the JFrame
    this.getContentPane().add(board, "Center");
    //sets the JFrame default size
    this.setSize(600, 600);
    //sets title of the Frame
    this.setTitle("Gomoku");
    //displays the JFrame
    this.setVisible(true);
  }
  
  /*
   * The action performed method is activated when any button is pressed
   * 
   * @param ActionEvent e the information about the event including which button was pressed
   */
  public void actionPerformed(ActionEvent e) {
    //sets the button that was pressed to b
    JButton b = (JButton)e.getSource();
    
    //changes the background of the button based on whose turn it is white plays first
    if (b.getBackground().equals(green) && !gameOver){
      numMoves++;
      if(player % 2 == 0){
        b.setBackground(white);
      } else{
        b.setBackground(black);
      }
      //determines where the button that was pressed is in the array sets the row and column values for later use   
      //row of button pressed
      int row = 0;
      //column of button pressed
      int column = 0;
      for(int i = 0; i < this.array.length; i++){
        for(int j = 0; j < this.array[i].length; j++){
          if(this.array[i][j] == b){
            row = i;
            column = j;
          }
        }
      }
      /*
       * 
       * The numberInLine method returns the number of pieces in a row including the one that was given 
       * if two opposing directions add up to 6 there are 5 pieces in a group and if both directions add up to 
       * 5 then there are 4 pieces in a group and likewise if the two directions add up to 4 there are 3 pieces in
       * a group.
       * 
       * This checks for a winner by checking for a group of five and no more than five in a row
       * and informs the players of the win.
       * 
       */
      if((array[row][column].getBackground() != green) &&
         (this.numberInLine(this.array, row, column, "right") + 
          this.numberInLine(this.array, row, column, "left") == 6) ||
         (this.numberInLine(this.array, row, column, "up") +
          this.numberInLine(this.array, row, column, "down") == 6) ||
         (this.numberInLine(this.array, row, column, "up-right") +
          this.numberInLine(this.array, row, column, "down-left") == 6) ||
         (this.numberInLine(this.array, row, column, "up-left") +
          this.numberInLine(this.array, row, column, "down-right") == 6)){
        System.out.println("Game is over: " + ((player % 2 == 0)?"White " : "Black ") + "Player wins");
        this.gameOver = true;
      }
      /*
       * 
       * checks for more than one four by four created by a move 
       * 
       * 
       * The following four if statements checks the four opposite directions to see if a group of four has been 
       * created and adds to a count if there is a group of four. 
       * 
       * This does not check if the group is open becuase in class it was indicated that it did not matter if they 
       * were closed.
       * 
       */
      
      if(this.numberInLine(this.array, row, column, "right") + 
        this.numberInLine(this.array, row, column, "left") == 5){
        fourByFour++;
      }
      if(this.numberInLine(this.array, row, column, "up") +
        this.numberInLine(this.array, row, column, "down") == 5){
        fourByFour++;
      }
      if(this.numberInLine(this.array, row, column, "up-right") +
        this.numberInLine(this.array, row, column, "down-left") == 5){
        fourByFour++;
      }
      if(this.numberInLine(this.array, row, column, "up-left") +
        this.numberInLine(this.array, row, column, "down-right") == 5){
        fourByFour++;
      }
      
      /*
       * 
       * Checks the number of groups of four created and if it is more than two/is an illegal move puts the piece's
       * background color back to the default green and informs the user of their error
       * 
       */
      
      if(fourByFour >= 2){
        array[row][column].setBackground(green);
        System.out.println("This move creates two 4 length open streaks and is not allowed. Try again.");
        numMoves--;
        player = player - 1;
      }
      
      fourByFour = 0;
      
      
      /*
       * This group of if statements like the last one checks for open groups of three and counts how many groups
       * are created by one move.
       * 
       * Both sides of each three must be open for the move to be illegal.
       */
      if((this.numberInLine(this.array, row, column, "right") + 
        this.numberInLine(this.array, row, column, "left") == 4) &&
         (this.isOpen(this.array, row, column, "right") && this.isOpen(this.array, row, column, "left"))){
        threeByThree++;
      }
      
      if((this.numberInLine(this.array, row, column, "up") +
        this.numberInLine(this.array, row, column, "down") == 4) && 
         (this.isOpen(this.array, row, column, "up") && this.isOpen(this.array, row, column, "down"))){
        threeByThree++;
      }
      
      if((this.numberInLine(this.array, row, column, "up-right") +
        this.numberInLine(this.array, row, column, "down-left") == 4) &&
         (this.isOpen(this.array, row, column, "up-right") || this.isOpen(this.array, row, column, "down-left"))){
        threeByThree++;
      }
      
      if((this.numberInLine(this.array, row, column, "up-left") +
        this.numberInLine(this.array, row, column, "down-right") == 4) &&
         (this.isOpen(this.array, row, column, "up-left") && this.isOpen(this.array, row, column, "down-right"))){
        threeByThree++;
      }
      
      /*
       * 
       * Checks if the move created more than one open group of three and if it did changes the piece's background
       * color back to the default green and informs the user of the illegal move.
       * 
       * 
       */
      
      if(threeByThree >= 2){
        array[row][column].setBackground(green);
        System.out.println("This move creates two 3 length open streaks and is not allowed. Try again.");
        numMoves--;
        player = player - 1;
      }
      
      threeByThree = 0;
      
      /*
       * checks the number of moves played (and not removed against the area of the grid) to determine if there are
       * any remaining moves
       */
      
      if(numMoves == this.array.length*this.array[row].length){
        System.out.println("Game is over there are no more moves.");
        this.gameOver = true;
      }
      
      //changes game play to the next player.
      player = player + 1;
    }
  }

  /*
   * This method returns the number of pieces of the same color in a row including the button given to the method
   * 
   * takes an array and a place to start in each direction the direction is specified by a string
   * 
   * @param JButton[][] array the game board pieces to iterate through
   * @param int row the row of the button that was pressed/is being checked/counted
   * @param int columbn the column of the button that was pressed/is being checked/counted
   * @param String direction the direction to go through the array 
   * @return int the number of pieces of the same color in a row/column/diagonal including the butto that was passed to
   * this method
   * 
   * The options for the direction string are:
   * 
   * up
   * up-right
   * right
   * down-right
   * down
   * down-left
   * left
   * up-left
   * 
   * 
   */
  public int numberInLine(JButton[][] array, int row, int column, String direction){
    int i = 0;
    int count = 0;
    if(direction.equals("right")) {
    //right
      while(column + i <= array[row].length - 1 &&
            array[row][column + i].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i++;
      }
    } else if(direction.equals("left")){    
    //left
      i = column;
      while(i >=0 && array[row][i].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i--;         
      }
    } else if(direction.equals("up")){
      //up
      i = row;
      while(i >= 0 && array[i][column].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i--;
      }
    } else if(direction.equals("down")){
      //down
      i = row;
      while(i <= array.length -1 && array[i][column].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i++;
      }
    } else if(direction.equals("up-right")){
      //up-right
      i = 0;
      while(row - i >=0 && column + i <= array[row - i].length - 1 &&
            array[row - i][column + i].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i++;
      }
    } else if(direction.equals("up-left")){
      //up-left
      i = 0;
      while(row - i >= 0 && column - i >= 0 &&
            array[row - i][column - i].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i++;
      }
    } else if(direction.equals("down-left")){
      //down-left
      i = 0;
      while(row + i >= 0 && row + i <= array.length - 1 && column - i >= 0 && column - i <= array[row].length - 1 &&
            array[row + i][column - i].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i++;
      }
    } else if(direction.equals("down-right")){
      //down-right
      i = 0;
      while(row + i <= array.length - 1 && column + i <= array[row + i].length -1 &&
            array[row + i][column + i].getBackground() == array[row][column].getBackground()){
        count = count + 1;
        i++;
      }
    }
    return count;
  }
  /*
   * The isOpen method goes through each direction from a specified space and if at the end of the row there is an
   * open space (not a different color or the end of the board) the method returns true
   * 
   * @param JButton[][] array the game board pieces to iterate through
   * @param int row the row of the button that was pressed/is being checked/counted
   * @param int columbn the column of the button that was pressed/is being checked/counted
   * @param String direction the direction to go through the array 
   * @return boolean true if at the end of a group there is a green button/space false if at the end of a gorup
   * there is a different color piece or it is the edge of the board
   * 
   * The options for the direction string are:
   * 
   * up
   * up-right
   * right
   * down-right
   * down
   * down-left
   * left
   * up-left
   * 
   */
  public boolean isOpen(JButton[][] array, int row, int column, String direction){
    int check = this.numberInLine(array, row, column, direction);
    boolean isOpen = false;
    try {
      if(direction.equals("right")) {
        //right
        isOpen = (array[row][column + check].getBackground()).equals(green);
      } else if(direction.equals("left")){    
        //left
        isOpen = (array[row][column - check].getBackground()).equals(green);
      } else if(direction.equals("up")){
        //up
        isOpen = (array[row - check][column].getBackground()).equals(green);
      } else if(direction.equals("down")){
        //down
        isOpen = (array[row + check][column].getBackground()).equals(green);
      } else if(direction.equals("up-right")){
        //up-right
        isOpen = (array[row - check][column + check].getBackground()).equals(green);
      } else if(direction.equals("up-left")){
        isOpen = (array[row - check][column - check].getBackground()).equals(green);
      } else if(direction.equals("down-left")){
        //down-left
        isOpen = (array[row + check][column - check].getBackground()).equals(green);
      } else if(direction.equals("down-right")){
        //down-right
        isOpen = (array[row + check][column + check].getBackground()).equals(green);
      }
    }
    catch (ArrayIndexOutOfBoundsException e){
    }
    finally {
      return isOpen;
    }
  }
}