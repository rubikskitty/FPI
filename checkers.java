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
  boolean selectedPiece = false;

  piece board[][] = new piece[9][9];
  piece redP[] = new piece[12];
  piece blackP[] = new piece[12];

  public static piece currentPiece = new piece();

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

      int pieceNum = 0;
      for (int i = 1; i < 9; i++) {
          for (int j = 1; j <= 3; j++) {
            if (((j % 2 != 0) && (i % 2 == 0)) || ((j % 2 == 0) && (i % 2 != 0))) {

              board[i][j] = redP[pieceNum];
              redP[pieceNum].xPos = i;
              redP[pieceNum].yPos = j;//so this will assign the red piece to their initial location
              pieceNum++;//confirm that this actually works
            }
          }
        }
  //

  pieceNum = 0;
  for (int i = 1; i < 9; i++) {
      for (int j = 6; j <= 8; j++) {
        if ((((j) % 2 == 0) && ((i) % 2 != 0)) || (((j) % 2 != 0) && ((i) % 2 == 0))) {

          board[i][j] = blackP[pieceNum];
          blackP[pieceNum].xPos = i;
          blackP[pieceNum].yPos = j;
          pieceNum++;//confirm that this actually works


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

       for (int i = 1; i < 9; i++) {
         for (int j = 1; j < 9; j++) {

           if (board[i][j] instanceof piece) {

             if (board[i][j].selected == true) {

               board[i][j].selected = false;
             }

           }


         if (((xpos > (i-1)*63) && (xpos < (63*i))) && ((ypos > (j-1)*63) && (ypos < (63*j)))) {

           if (board[i][j] instanceof piece) {

             currentPiece = board[i][j];
             currentPiece.selected = true;
             selectedPiece = true;

           }

         }

       }

     }

     if (selectedPiece) {

       if (currentPiece.movesPossible.get(0).size() != 0) {
         for (int i = 0; i < (currentPiece.movesPossible.get(0).size()-1); i++) {

           int tempx = currentPiece.movesPossible.get(0).get(i);
           int tempy = currentPiece.movesPossible.get(1).get(i);

           if (((xpos > (tempx-1)*63) && (xpos < (63*tempx))) && ((ypos > (tempy-1)*63) && (ypos < (63*tempy)))) {

             if ((tempx != currentPiece.xPos) || (tempy != currentPiece.yPos)) {

               board[currentPiece.xPos][currentPiece.yPos] = null;
               board[tempx][tempy] = currentPiece;

               currentPiece.xPos = currentPiece.movesPossible.get(0).get(i);
               currentPiece.yPos = currentPiece.movesPossible.get(1).get(i);//change it so that the piece that is chosen can be moved to one of the possible locations

               selectedPiece = false;
               currentPiece.selected = false;

               currentPiece.movesPossible = new ArrayList<ArrayList<Integer>>();
               ArrayList<Integer> xArray = new ArrayList<Integer>();
               ArrayList<Integer> yArray = new ArrayList<Integer>();

               currentPiece.movesPossible.add(xArray);
               currentPiece.movesPossible.add(yArray);
               break;

             }

           }

         }

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
	       for (int j = 1; j < 9; j++) {

           if (board[i][j] instanceof piece) {

             if (board[i][j].selected == true) {


               board[i][j].movesOpen(board[i][j], board);
               backg.setColor(Color.red);

               for (int k = 0; k < board[i][j].movesPossible.get(0).size(); k++) {

                 backg.fillRect( ((board[i][j].movesPossible.get(0).get(k)-1)*63), ((board[i][j].movesPossible.get(1).get(k)-1)*63), 63, 63);

               }

             }
           }
	          if ((board[i][j] instanceof piece) && (board[i][j].side == 2)) {

	             backg.drawImage(pieceBlack, ((i-1)*63) + 7, ((j-1)*63) + 10, 45, 45, this);
	             //put the piece at the supposed location as black
	           }

	           if ((board[i][j] instanceof piece) && (board[i][j].side == 1)) {

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
  int tempX = 0;
  int tempY = 0;
  boolean king = false;
  boolean selected = false;
  //tracking variables

  ArrayList<ArrayList<Integer>> movesPossible = new ArrayList<ArrayList<Integer>>();

  ArrayList<Integer> xArray = new ArrayList<Integer>();
  ArrayList<Integer> yArray = new ArrayList<Integer>();

  protected piece(){
      movesPossible.add(xArray);
      movesPossible.add(yArray);
    }


   //find a way to store the moves possible for the current piece in some sort of array
  public void movesOpen (piece p, piece[][] board) {

      for (int i = 1 ; i  < 9; i++) {

        for (int j = 1 ; j  < 9; j++) {

          int difX = Math.abs(p.xPos-i);
          int difY = Math.abs(p.yPos-j);
          boolean checkLane = false;
          boolean piececnTaken = false;

           if ((difX == 1) && (difY ==1)) {

             if (((i+1) == p.xPos) && ((j-1) == p.yPos)) {

               if (p.side == 2 && (!king)) {
                 checkLane = true;//fix this up but other than that it seems to recognize open moves

               }

               if (board[i][j] instanceof piece) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {
                   if (board[i-1][j+1] == null) {

                       p.movesPossible.get(0).add(i-1);//add the location to the moves possible list
                       p.movesPossible.get(1).add(j+1);//add the location to the moves possible list
                       checkLane = true;
                   }
                   else {
                     checkLane = true;//fix this up but other than that it seems to recognize open moves
                   }

                 }



               }

             }


            if (((i-1) == p.xPos) && ((j+1) == p.yPos)) {

               if (p.side == 1 && (!king)) {
                 checkLane = true;//fix this up but other than that it seems to recognize open moves

               }

               if (board[i][j] instanceof piece) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }

               else {
                 if (board[i+1][j-1] == null) {

                     p.movesPossible.get(0).add(i+1);//add the location to the moves possible list
                     p.movesPossible.get(1).add(j-1);//add the location to the moves possible list
                     checkLane = true;
                 }
                 else {
                   checkLane = true;//fix this up but other than that it seems to recognize open moves
                 }

               }
             }

             }

             if (((i-1) == p.xPos) && ((j-1) == p.yPos)) {

               if (p.side == 2 && (!king)) {
                 checkLane = true;//fix this up but other than that it seems to recognize open moves

               }

               if (board[i][j] instanceof piece) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {
                   checkLane = true;
                   if ((i+1 <= 9) && (j+1 <=9)) {

                     if (board[i+1][j+1] == null) {

                         p.movesPossible.get(0).add(i+1);//add the location to the moves possible list
                         p.movesPossible.get(1).add(j+1);//add the location to the moves possible list

                     }
                   }

                 }

               }

             }

             if (((i+1) == p.xPos) && ((j+1) == p.yPos)) {

               if (p.side == 1 && (!king)) {
                 checkLane = true;//fix this up but other than that it seems to recognize open moves
               }

               if (board[i][j] instanceof piece) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {

                   if ((i-1 >= 1) && (j-1 >=1)) {
                     checkLane = true;//fix this up but other than that it seems to recognize open moves
                     if (board[i-1][j-1] == null) {

                         p.movesPossible.get(0).add(i-1);//add the location to the moves possible list
                         p.movesPossible.get(1).add(j-1);//add the location to the moves possible list

                     }
                   }

                 }
               }

             }

           }


          if (((difX == 1) && (difY == 1)) && (board[i][j] == null) && ((i != p.xPos) && (j != p.yPos)) && (checkLane == false)) {

            p.movesPossible.get(0).add(i);//add the location to the moves possible list
            p.movesPossible.get(1).add(j);//add the location to the moves possible list

          }


        }

      }

  }

}
