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
//ensure to fix the coordinates locations, the ypos appear to be mistaken for xpos

public class checkers extends Applet implements ActionListener, MouseListener {

  Graphics backg;
  Image backbuffer;
  Timer timeCount;
  Image picture;
  Image piece;
  Image pieceBlack;
  Image pieceRed;
  Image kingRed;
  Image kingBlack;

  //have multiple image variables to represent different objects in the checkers match

  int x = 0;
  Color selected = new Color(110, 89, 31);
  //
  boolean selectedPiece = false;

  piece board[][] = new piece[9][9];
  piece redP[] = new piece[12];
  piece blackP[] = new piece[12];

  public static player pOne = new player();
  public static player pAI = new player();
  public static player pTwo = new player();
  player pArray[] = new player[3];

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
      kingRed = getImage(getDocumentBase(), "redKing.png");
      kingBlack = getImage(getDocumentBase(), "blackKing.png");

      pArray[0] = pOne;
      pArray[1] = pTwo;
      pArray[2] = pAI;

      pOne.playing = true;
      pTwo.playing = false;
      pAI.playing = false;

      pOne.side = 2;
      pTwo.side = 1;
      pAI.side = 1;

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

      for (int i = 0; i < 12; i++) {

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

      for (int i = 0; i < 12; i++) {

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
       //sets the mouse postitions to variables

       for (int i = 1; i < 9; i++) {
         for (int j = 1; j < 9; j++) {

           if (board[i][j] instanceof piece) {

             if (board[i][j].selected == true) {

               board[i][j].selected = false;// check each piece on the board, if it is selected after being clicked again make it unselected

               //
             }

           }


         if (((xpos > (i-1)*63) && (xpos < (63*i))) && ((ypos > (j-1)*63) && (ypos < (63*j)))) {

           if (board[i][j] instanceof piece) {
             //ensure the value if a piece

             /*
             currentPiece = board[i][j];
             currentPiece.selected = true;//set the selected piece to a temporary variable
             selectedPiece = true;
             *///debug code

             if (pOne.playing && pOne.side == board[i][j].side) {

               currentPiece = board[i][j];
               currentPiece.selected = true;//set the selected piece to a temporary variable
               selectedPiece = true;

             }
             else if (pTwo.playing && pTwo.side == board[i][j].side) {

                 currentPiece = board[i][j];
                 currentPiece.selected = true;//set the selected piece to a temporary variable
                 selectedPiece = true;

              }
               //if the location is a piece of the same colour, set that piece to selection

           }
           //it will only allow the selection of pieces during a certain players turn

         }

       }

     }

     if (selectedPiece) {

       currentPiece.makeMove(board,currentPiece,selectedPiece,xpos,ypos, pArray);
       //this will check to see if the piece that is chosen has had one of its possible positions selected, then make moves accordingly

       //the program will cycle through a list of all of the players in the game, if their side matches with the piece just played, their turn will end

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
      backg.drawImage(picture, 0, 0, 504,504 ,this);

      int redPieceAlive = 0;
      int blackPieceAlive = 0;

      redPieceAlive = checkers.checkPieces(redP);
      blackPieceAlive = checkers.checkPieces(blackP);

      backg.setColor(Color.black);
      backg.drawString("Red Pieces Killed: " + (12 - redPieceAlive), 600, 400);
      backg.drawString("Blue Pieces Killed: " + (12 - blackPieceAlive), 600, 200);

      if (redPieceAlive == 0) {
        backg.drawString("Blue Wins!",600, 300 );
        timeCount.stop();
      }

      if (blackPieceAlive == 0) {
        backg.drawString("Red Wins!", 600, 300);
        timeCount.stop();
      }

      for (int i = 0; i < pArray.length -1; i++) {

        if (pArray[i].playing) {

          if (pArray[i].side == 1) {

            backg.drawString("Player Two Turn", 600, 250);

          }
          else if (pArray[i].side == 2) {

            backg.drawString("Player One Turn", 600, 250);

          }

        }

      }


      for (int i = 1; i < 9; i++) {

	       for (int j = 1; j < 9; j++) {

           if (board[i][j] instanceof piece) {

             if (board[i][j].selected == true) {

               board[i][j].movesOpen(board[i][j], board);// check for the possible moves
               backg.setColor(Color.red);

               for (int k = 0; k < board[i][j].movesPossible.get(0).size()-1; k++) {

                 int xDec = (board[i][j].movesPossible.get(0).get(k)-1);
                 int yDec = (board[i][j].movesPossible.get(1).get(k)-1);

                 backg.fillRect( ((xDec*63)), ((yDec*63)), 63, 63);
                 //for the possible positions draw squares there

               }

             }
           }

	          if ((board[i][j] instanceof piece) && (board[i][j].side == 2) && (board[i][j].alive == true)) {


	             //put the piece at the supposed location as black
               if (board[i][j].king) {

                 backg.drawImage(kingBlack, ((i-1)*63) + 7, ((j-1)*63) + 10, 45, 45, this);

               }
               else {
                 backg.drawImage(pieceBlack, ((i-1)*63) + 7, ((j-1)*63) + 10, 45, 45, this);

               }
	           }

	           if ((board[i][j] instanceof piece) && (board[i][j].side == 1) && (board[i][j].alive == true)) {

                if (board[i][j].king) {

                  backg.drawImage(kingRed, ((i-1)*63) + 7, ((j-1)*63) + 10, 45, 45, this);

                }
                else {

                  backg.drawImage(pieceRed, ((i-1)*63) + 2, ((j-1)*63) + 4, 55, 55, this);

                }
	          //put the piece at the supposed location as red
	           }

	       }
    }
    //draw everything on the board, possible positions and pieces
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

  public static int checkPieces(piece[] pieceArray) {

    int count = 0;

    for (int i =0; i < pieceArray.length; i++) {

      if (pieceArray[i].alive == true) {

        count++;

      }

    }

    return count;

  }
  //checks the amount of pieces alive on for the given array of pieces, returns a value

}

class piece extends checkers {

  int xPos = 0;
  int yPos = 0;
  int side = 0;
  int tempX = 0;
  int tempY = 0;
  boolean king = false;
  boolean selected = false;
  boolean alive = true;
  //tracking variables

  ArrayList<ArrayList<Integer>> movesPossible = new ArrayList<ArrayList<Integer>>();
  //the arraylsit used to store every possible move

  ArrayList<Integer> xArray = new ArrayList<Integer>();
  ArrayList<Integer> yArray = new ArrayList<Integer>();
  //two seperate arraylists for x and y coordinates

  protected piece(){
      movesPossible.add(xArray);
      movesPossible.add(yArray);
    }
    //add each sub arraylist to the moves possible arraylist

    public void makeMove (piece[][] board, piece currentPiece, boolean selectedPiece, int xpos, int ypos, player[] pArray) {

      if (currentPiece.movesPossible.get(0).size() != 0) {//ensure the size is larger than 0
        for (int i = 0; i < (currentPiece.movesPossible.get(0).size() -1); i++) {// loop through the size of the moves avaliable

          int tempx = currentPiece.movesPossible.get(0).get(i);
          int tempy = currentPiece.movesPossible.get(1).get(i);
          //for each value cycled through of the move possible, set them to their respective variables

          if (((xpos > (tempx-1)*63) && (xpos < (63*tempx))) && ((ypos > (tempy-1)*63) && (ypos < (63*tempy)))) {// if the click is within the bounds of a possible move

            if ((tempx != currentPiece.xPos) || (tempy != currentPiece.yPos)) {// ensure that this is not their spot,

              board[currentPiece.xPos][currentPiece.yPos] = null; // set their current location on the board to null
              board[tempx][tempy] = currentPiece; // set the clicked location to the piece moved

              for (int j = 0; j < pArray.length -1;j++) {

                if (currentPiece.side == pArray[j].side) {

                  pArray[j].playing = false;

                }
                else {
                  pArray[j].playing = true;
                }
              }
              //changes the status of the turns, based on who is playing currently


             if (board[tempx-1][tempy-1] instanceof piece && ((tempx - 2 == currentPiece.xPos) && (tempy - 2 == currentPiece.yPos))) {//will run

               if (board[tempx-1][tempy-1].side != currentPiece.side) {

                 board[tempx-1][tempy-1].alive = false;
                 board[tempx-1][tempy-1] = null;

               }

             }
             if ((tempx +1 != 9)) {//runs

               if (board[tempx+1][tempy-1] instanceof piece && ((tempx + 2 == currentPiece.xPos) && (tempy - 2 == currentPiece.yPos))) {

                 if (board[tempx+1][tempy-1].side != currentPiece.side) {

                   board[tempx+1][tempy-1].alive = false;
                   board[tempx+1][tempy-1] = null;

                 }

               }

             }
             if ((tempy +1 != 9)) {//will not run


               if (board[tempx-1][tempy+1] instanceof piece && ((tempx - 2 == currentPiece.xPos) && (tempy + 2 == currentPiece.yPos))) {

                 if (board[tempx-1][tempy+1].side != currentPiece.side) {

                   board[tempx-1][tempy+1].alive = false;
                   board[tempx-1][tempy+1] = null;

                 }

               }

             }
             if ((tempx +1 != 9) && (tempy +1 != 9)) {//will not run

              if (board[tempx+1][tempy+1] instanceof piece && ((tempx + 2 == currentPiece.xPos) && (tempy + 2 == currentPiece.yPos))) {

               if (board[tempx+1][tempy+1].side != currentPiece.side) {

                 board[tempx+1][tempy+1].alive = false;
                 board[tempx+1][tempy+1] = null;

                }

              }
            }
            //these if statements regulate the killing of moves


             currentPiece.xPos = currentPiece.movesPossible.get(0).get(i);
             currentPiece.yPos = currentPiece.movesPossible.get(1).get(i);//change it so that the piece that is chosen can be moved to one of the possible locations
             //change the move coordiantes stored in the piece to the current move selected

             if (currentPiece.yPos == 8 && currentPiece.side == 1) {
               currentPiece.king = true;

             }
             if (currentPiece.yPos == 1 && currentPiece.side == 2) {
               currentPiece.king = true;
             }
             //king the piece if it is in the other zone

             selectedPiece = false;//variable used to track if a piece is currently selected
             currentPiece.selected = false;//the piece is no longer selected

             currentPiece.movesPossible = new ArrayList<ArrayList<Integer>>();
             ArrayList<Integer> xArray = new ArrayList<Integer>();
             ArrayList<Integer> yArray = new ArrayList<Integer>();

             currentPiece.movesPossible.add(xArray);
             currentPiece.movesPossible.add(yArray);
             //reset the movesPossible array so that it doesn't contain the previous position possible moves



               }

           }
         }

     }

    }

    /*
    public void moveTake (piece[][] board, int fXpos, int fYpos, piece p) {

    if (fXpos <= 6 && fYpos <= 6) {

      if (p.side != 1 || p.king == true) {
        if (board[fXpos+1][fYpos-1] instanceof piece && p.checkMoves(p, (fXpos+1), (fYpos-1))) {

          if (board[fXpos+1][fYpos-1].side != p.side && board[fXpos+2][fYpos-2] == null) {

            p.movesPossible.get(0).add(fXpos+2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos-2);//add the location to the moves possible list

        }

      }

    }

    if (p.side != 2 || p.king == true) {
      if (board[fXpos+1][fYpos+1] instanceof piece && p.checkMoves(p, (fXpos+1), (fYpos+1))) {

        if (board[fXpos+1][fYpos+1].side != p.side && board[fXpos+2][fYpos+2] == null) {

            p.movesPossible.get(0).add(fXpos+2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos+2);//add the location to the moves possible list

        }

      }
    }

    if (p.side !=2 || p.king == true) {
      if (board[fXpos-1][fYpos-1] instanceof piece && p.checkMoves(p, (fXpos-1), (fYpos-1))) {

        if (board[fXpos-1][fYpos-1].side != p.side && board[fXpos-2][fYpos-2] == null) {

            p.movesPossible.get(0).add(fXpos-2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos-2);//add the location to the moves possible list

        }

      }

    }

    if (p.side != 1 || p.king == true) {

      if (board[fXpos-1][fYpos+1] instanceof piece && p.checkMoves(p, (fXpos-1), (fYpos+1))) {

        if (board[fXpos-1][fYpos+1].side != p.side && board[fXpos-2][fYpos+2] == null) {

            p.movesPossible.get(0).add(fXpos-2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos+2);//add the location to the moves possible list

        }

      }
    }

  }
    }

    *///debug code

    public boolean checkMoves (piece p, int fXpos, int fYpos){

      if (p.movesPossible.get(0).size() > 0) {

        for (int i = 0; i < p.movesPossible.get(0).size(); i++) {

          if (p.movesPossible.get(0).get(i) == fXpos && p.movesPossible.get(1).get(i) == fYpos) {

            return false;
          }
        }


      }

      return true;
    }
   //check to see for the current piece, if there are any moves from the two provided points

  public void movesOpen (piece p, piece[][] board) {

      for (int i = 1 ; i  < 9; i++) {

        for (int j = 1 ; j  < 9; j++) {

          int difX = Math.abs(p.xPos-i);
          int difY = Math.abs(p.yPos-j);
          //determine the difference between the observed position and the current piece positions

          boolean checkLane = false;
          //a variable used to stop the addition of a move to the movespossible list

           if ((difX == 1) && (difY ==1)) {

             if (((i+1) == p.xPos) && ((j-1) == p.yPos)) {

               if (p.side == 2 && (!p.king)) {

                 checkLane = true;//fix this up but other than that it seems to recognize open moves

               }

               if (board[i][j] instanceof piece && !checkLane) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {

                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     if (board[i-1][j+1] == null) {

                       p.movesPossible.get(0).add(i-1);//add the location to the moves possible list
                       p.movesPossible.get(1).add(j+1);//add the location to the moves possible list

                       //p.moveTake(board,i-1, j+1, p);

                      checkLane = true;
                     }
                     else {
                     checkLane = true;//fix this up but other than that it seems to recognize open moves
                   }

                  }
                }

              }

            }

            if (((i-1) == p.xPos) && ((j+1) == p.yPos)) {

               if (p.side == 1 && (!p.king)) {
                 checkLane = true;//fix this up but other than that it seems to recognize open moves

               }

               if (board[i][j] instanceof piece && !checkLane) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }

                 else {

                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     if (board[i+1][j-1] == null) {

                        p.movesPossible.get(0).add(i+1);//add the location to the moves possible list
                        p.movesPossible.get(1).add(j-1);//add the location to the moves possible list

                        //p.moveTake(board,i+1, j-1, p);

                        checkLane = true;
                     }
                     else {
                     checkLane = true;//fix this up but other than that it seems to recognize open moves
                    }

                  }
               }
             }
           }

             if (((i-1) == p.xPos) && ((j-1) == p.yPos)) {

               if (p.side == 2 && (!p.king)) {
                 checkLane = true;//fix this up but other than that it seems to recognize open moves
                 break;

               }

               if (board[i][j] instanceof piece && !checkLane) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {
                   checkLane = true;

                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     if ((i+1 < 8) && (j+1 <8)) {

                       if (board[i+1][j+1] == null) {

                         p.movesPossible.get(0).add(i+1);//add the location to the moves possible list
                         p.movesPossible.get(1).add(j+1);//add the location to the moves possible list

                       //p.moveTake(board,i+1, j+1, p);

                     }
                   }

                 }

                 }

               }

             }

             if (((i+1) == p.xPos) && ((j+1) == p.yPos)) {

               if (p.side == 1 && (!p.king)) {
                 checkLane = true;//fix this up but other than that it seems to recognize open moves
               }

               if (board[i][j] instanceof piece && !checkLane) {

                 if (board[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {
                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     checkLane = true;//fix this up but other than that it seems to recognize open moves
                     if (board[i-1][j-1] == null) {

                         p.movesPossible.get(0).add(i-1);//add the location to the moves possible list
                         p.movesPossible.get(1).add(j-1);//add the location to the moves possible list

                         //p.moveTake(board,i-1, j-1, p);

                     }
                   }

                 }
               }

             }

           }


          if (((difX == 1) && (difY == 1)) && (board[i][j] == null) && ((i != p.xPos) && (j != p.yPos)) && (checkLane == false)) {

            p.movesPossible.get(0).add(i);
            p.movesPossible.get(1).add(j);
            //add the location to the moves possible list if it is adjacent, empty, and the right direction

          }


        }

      }

  }

}

class player extends checkers{

int side = 0;
boolean playing = false;
//a player class for each player
//it will store the side of the palyer and the status

}
