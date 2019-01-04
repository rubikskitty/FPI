import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.util.HashMap.*;//make sure to research HASHMAP 
//necessary imports

/*<applet code="checkers"width=400 height=400></applet>*/

public class checkers extends Applet implements ActionListener, MouseListener {

  Graphics backg;
  Image backbuffer;
  Timer timeCount;
  Image picture;
  Image piece;
  Image pieceBlack;
  Image pieceRed;
  //have multiple image variables to represent different objects in the checkers match

  int x = 0;
  Color selected = new Color(110, 89, 31);
  //

  piece board[][] = new piece[9][9];
  piece redP[] = new piece[12];
  piece blackP[] = new piece[12];
  //arrays of pieces, one to represent the board, and two to represent each sidde in the checker game

  public void init() {

      backbuffer = createImage( 1000, 1000 );
      backg = backbuffer.getGraphics();
      setSize(1000, 1000);
      backg.setColor( Color.black );
      backg.fillRect( 0, 0, 1000, 1000);
      addMouseListener(this);
      timeCount = new Timer(50, this);
      timeCount.start();
      picture = getImage(getDocumentBase(), "checker.jpg");
      pieceBlack = getImage(getDocumentBase(), "black.png");
      pieceRed = getImage(getDocumentBase(), "red.png");

      piece checkerOne = new piece();
      piece checkerTwo = new piece();
      piece checkerThree = new piece();
      piece checkerFour = new piece();
      piece checkerFive = new piece();
      piece checkerSix = new piece();
      piece checkerSeven = new piece();
      piece checkerEight = new piece();
      piece checkerNine = new piece();
      piece checkerTen = new piece();
      piece checkerEleven = new piece();
      piece checkerTwelve = new piece();
      //red checkers creation

      piece checkerThirteen = new piece();
      piece checkerFourteen = new piece();
      piece checkerFifeteen = new piece();
      piece checkerSixteen = new piece();
      piece checkerSeventeen = new piece();
      piece checkerEighteen = new piece();
      piece checkerNineteen = new piece();
      piece checkerTwenty = new piece();
      piece checkerTwentyOne = new piece();
      piece checkerTwentyTwo = new piece();
      piece checkerTwentyThree = new piece();
      piece checkerTwentyFour = new piece();
      //black checker creation

      redP[0] = checkerOne;
      redP[1] = checkerTwo;
      redP[2] = checkerThree;
      redP[3] = checkerFour;
      redP[4] = checkerFive;
      redP[5] = checkerSix;
      redP[6] = checkerSeven;
      redP[7] = checkerEight;
      redP[8] = checkerNine;
      redP[9] = checkerTen;

      redP[10] = checkerEleven;
      redP[11] = checkerTwelve;
      //add every red piece to the list of red pieces

      for (int i = 0; i < 11; i++) {

        redP[i].side = 1; //set the colour of side to the red pieces, where red is 1, black is 2

      }

      blackP[0] = checkerThirteen;
      blackP[1] = checkerFourteen;
      blackP[2] = checkerFifeteen;
      blackP[3] = checkerSixteen;
      blackP[4] = checkerSeventeen;
      blackP[5] = checkerEighteen;
      blackP[6] = checkerNineteen;
      blackP[7] = checkerTwenty;
      blackP[8] = checkerTwentyOne;
      blackP[9] = checkerTwentyTwo;
      blackP[10] = checkerTwentyThree;
      blackP[11] = checkerTwentyFour;
      //add every black piece to the list of black pieces

      for (int i = 0; i < 11; i++) {

        blackP[i].side = 2; //set the colour of side to the red pieces, where red is 1, black is 2

      }

      int counter = 0;

      for (int i = 1; i < 9; i++) {
          for (int j = 1; j <= 3; j++) {
            if (((j % 2 != 0) && (i % 2 == 0)) || ((j % 2 == 0) && (i % 2 != 0))) {

              board[i][j] = redP[counter];
              redP[counter].xPos = i;
              redP[counter].yPos = j;
              counter++;//confirm that this actually works

            }
          }
        }

    counter = 0;
    for (int i = 1; i < 9; i++) {
      for (int j = 5; j <= 8; j++) {
        if (((j % 2 == 0) && (i % 2 == 0)) || ((j % 2 != 0) && (i % 2 != 0))) {

          board[i][j] = blackP[counter];
          blackP[counter].xPos = i;
          blackP[counter].yPos = j;
          counter++;//confirm that this actually works

        }
      }
    }

    }

  public void paint( Graphics g ) {
      update( g );
  }

  public void mouseClicked(MouseEvent e) {

   //Constantly check the mouse position
       int xpos = e.getX();
       int ypos = e.getY();

       if (piece is clicked) {

         take the list of open positions, = piece.movesOpen

         for (int i = 0; i < length.list of open positions; i++) {

           highlight that spot on the board, by creating a square of a different select colour

           have a state where the person can either chose one of the possible moves, or chose a different piece,

         }

       }
       repaint();
	  }
	  //make something that checks if something is currently selected

  public void start(){
      timeCount.start();
  }

  public void stop(){
      timeCount.stop();
  }

  public void destroy(){
      //System.exit(0);
  }

  public void actionPerformed(ActionEvent e){
    if (e.getSource() == timeCount) {

      backg.setColor(Color.white);
      backg.fillRect( 0, 0, 1000, 1000);
      backg.drawImage(picture, 0, 0, 500,500 ,this);

      for (int i = 1; i < 9; i++) {
	       for (int j = 1; j <= 8; j++) {

	          if ((board[i][j] instanceof piece) && (board[i][j].side == 2)) {

	             backg.drawImage(pieceBlack, ((i-1)*63) + 7, ((j-1)*63) + 10, 45, 45, this);
	             //put the piece at the supposed location as black
	           }

	           else if ((board[i][j] instanceof piece) && (board[i][j].side == 1)) {

	              backg.drawImage(pieceRed, ((i-1)*63) + 2, ((j-1)*63) + 4, 55, 55, this);
	          //put the piece at the supposed location as red
	         }

	       }
      }
    }
}

  public void update( Graphics g ) {
    g.drawImage( backbuffer, 0, 0, this );
    repaint();
  }

  public void mouseEntered(MouseEvent e) {
  }

  public void mouseExited(MouseEvent e) {
  }

  public void mousePressed(MouseEvent e) {
  }

  public void mouseReleased(MouseEvent e) {
  }
}

class piece extends checkers {

  int xPos = 0;
  int yPos = 0;
  int side = 0;
  //tracking variables

  HashMap movesPossible<Integer,Integer> = new HashMap<Integer,Integer>();
   //find a way to store the moves possible for the current piece in some sort of array

  public void movesOpen (piece p, piece[][] board) {

      for (int i = 0 ; i  < 8; i++) {

        for (int j = 0 ; j  < 8; j++) {

          if (board[i][j] instanceof piece) {

              int tempX = board[i][j].Xpos;
              int tempY = board[i][j].Ypos;
              //for each piece in the board cycle through

          }

          if ((board[i][j] instanceof piece) && ((Math.abs(tempX-i) < 9) && (Math.abs(tempY-j) < 9))) {

            movesPossible.put(i, j);//add the location to the moves possible list

          }


        }

      }

  }

}
