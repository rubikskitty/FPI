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
//ensure to fix the coordiantes locations, the ypos appear to be mistaken for xpos

public class checkersAi extends Applet implements ActionListener, MouseListener {

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
  public static ai otherPlay = new ai();
  player pArray[] = new player[2];


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
      pArray[1] = pAI;

      pOne.playing = true;
      pAI.playing = false;

      pOne.side = 2;
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

             /*
             currentPiece = board[i][j];
             currentPiece.selected = true;//set the selected piece to a temporary variable
             selectedPiece = true;
             */


             if (pOne.playing && pOne.side == board[i][j].side) {

               currentPiece = board[i][j];
               currentPiece.selected = true;//set the selected piece to a temporary variable
               selectedPiece = true;

             }

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

      redPieceAlive = checkersAi.checkPieces(redP);
      blackPieceAlive = checkersAi.checkPieces(blackP);

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
  }

  if (pAI.playing) {

    int[] array = new int[2];
    array = otherPlay.AImove(board, redP, blackP, pArray, otherPlay);

    redP[array[0]].movesOpen(redP[array[0]], board);
    int tX = (redP[array[0]].movesPossible.get(0).get(array[1]))*63;
    int tY = (redP[array[0]].movesPossible.get(1).get(array[1]))*63;


    redP[0].makeMove(board,redP[array[0]], true, tX, tY, pArray);

    pAI.playing = false;
    pOne.playing = true;
    otherPlay.branch = 0;

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

      if (pieceArray[i] != null) {
        if (pieceArray[i].alive == true) {

          count++;

        }

      }


    }

    return count;

  }

}

class piece extends checkersAi {

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

    public void makeMove (piece[][] tempBoard, piece currentPiece, boolean selectedPiece, int xpos, int ypos, player[] pArray) {

      if (currentPiece.movesPossible.get(0).size() != 0) {//ensure the size is larger than 0
        for (int i = 0; i < (currentPiece.movesPossible.get(0).size() -1); i++) {// loop through the size of the moves avaliable

          int tempx = currentPiece.movesPossible.get(0).get(i);
          int tempy = currentPiece.movesPossible.get(1).get(i);
          //for each value cycled through of the move possible, set them to their respective variables



          if (((xpos >= (tempx-1)*63) && (xpos <= (63*tempx))) && ((ypos >= (tempy-1)*63) && (ypos <= (63*tempy)))) {// if the click is within the bounds of a possible move

            if ((tempx != currentPiece.xPos) || (tempy != currentPiece.yPos)) {// ensure that this is not their spot,

              tempBoard[currentPiece.xPos][currentPiece.yPos] = null; // set their current location on the tempBoard to null
              tempBoard[tempx][tempy] = currentPiece; // set the clicked location to the piece moved

              for (int j = 0; j < pArray.length -1;j++) {

                if (pOne.playing) {

                  pOne.playing = false;
                  pAI.playing = true;

                }
                else {
                  pAI.playing = true;
                }
              }

                // if the piece is within thebounds of the tempBoard if it could jump

                       if (tempBoard[tempx-1][tempy-1] instanceof piece && ((tempx - 2 == currentPiece.xPos) && (tempy - 2 == currentPiece.yPos))) {//will run

                         if (tempBoard[tempx-1][tempy-1].side != currentPiece.side) {

                           tempBoard[tempx-1][tempy-1].alive = false;
                           tempBoard[tempx-1][tempy-1] = null;

                         }

                       }
                       if ((tempx +1 != 9)) {//runs

                         if (tempBoard[tempx+1][tempy-1] instanceof piece && ((tempx + 2 == currentPiece.xPos) && (tempy - 2 == currentPiece.yPos))) {

                           if (tempBoard[tempx+1][tempy-1].side != currentPiece.side) {

                             tempBoard[tempx+1][tempy-1].alive = false;
                             tempBoard[tempx+1][tempy-1] = null;

                           }

                         }

                       }
                       if ((tempy +1 != 9)) {//will not run


                         if (tempBoard[tempx-1][tempy+1] instanceof piece && ((tempx - 2 == currentPiece.xPos) && (tempy + 2 == currentPiece.yPos))) {

                           if (tempBoard[tempx-1][tempy+1].side != currentPiece.side) {

                             tempBoard[tempx-1][tempy+1].alive = false;
                             tempBoard[tempx-1][tempy+1] = null;

                           }

                         }

                       }
                       if ((tempx +1 != 9) && (tempy +1 != 9)) {//will not run

                        if (tempBoard[tempx+1][tempy+1] instanceof piece && ((tempx + 2 == currentPiece.xPos) && (tempy + 2 == currentPiece.yPos))) {

                         if (tempBoard[tempx+1][tempy+1].side != currentPiece.side) {

                           tempBoard[tempx+1][tempy+1].alive = false;
                           tempBoard[tempx+1][tempy+1] = null;

                          }

                        }
                      }


                       currentPiece.xPos = currentPiece.movesPossible.get(0).get(i);
                       currentPiece.yPos = currentPiece.movesPossible.get(1).get(i);//change it so that the piece that is chosen can be moved to one of the possible locations

                       if (currentPiece.yPos == 8 && currentPiece.side == 1) {
                         currentPiece.king = true;

                       }

                       if (currentPiece.yPos == 1 && currentPiece.side == 2) {
                         currentPiece.king = true;
                       }

                       selectedPiece = false;
                       currentPiece.selected = false;

                       currentPiece.movesPossible = new ArrayList<ArrayList<Integer>>();
                       ArrayList<Integer> xArray = new ArrayList<Integer>();
                       ArrayList<Integer> yArray = new ArrayList<Integer>();


                       currentPiece.movesPossible.add(xArray);
                       currentPiece.movesPossible.add(yArray);



               }

           }
         }

     }

    }

    /*
    public void moveTake (piece[][] tempBoard, int fXpos, int fYpos, piece p) {

    if (fXpos <= 6 && fYpos <= 6) {

      if (p.side != 1 || p.king == true) {
        if (tempBoard[fXpos+1][fYpos-1] instanceof piece && p.checkMoves(p, (fXpos+1), (fYpos-1))) {

          if (tempBoard[fXpos+1][fYpos-1].side != p.side && tempBoard[fXpos+2][fYpos-2] == null) {

            p.movesPossible.get(0).add(fXpos+2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos-2);//add the location to the moves possible list

        }

      }

    }

    if (p.side != 2 || p.king == true) {
      if (tempBoard[fXpos+1][fYpos+1] instanceof piece && p.checkMoves(p, (fXpos+1), (fYpos+1))) {

        if (tempBoard[fXpos+1][fYpos+1].side != p.side && tempBoard[fXpos+2][fYpos+2] == null) {

            p.movesPossible.get(0).add(fXpos+2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos+2);//add the location to the moves possible list

        }

      }
    }

    if (p.side !=2 || p.king == true) {
      if (tempBoard[fXpos-1][fYpos-1] instanceof piece && p.checkMoves(p, (fXpos-1), (fYpos-1))) {

        if (tempBoard[fXpos-1][fYpos-1].side != p.side && tempBoard[fXpos-2][fYpos-2] == null) {

            p.movesPossible.get(0).add(fXpos-2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos-2);//add the location to the moves possible list

        }

      }

    }

    if (p.side != 1 || p.king == true) {

      if (tempBoard[fXpos-1][fYpos+1] instanceof piece && p.checkMoves(p, (fXpos-1), (fYpos+1))) {

        if (tempBoard[fXpos-1][fYpos+1].side != p.side && tempBoard[fXpos-2][fYpos+2] == null) {

            p.movesPossible.get(0).add(fXpos-2);//add the location to the moves possible list
            p.movesPossible.get(1).add(fYpos+2);//add the location to the moves possible list

        }

      }
    }

  }
    }

    */

   //check to see for the current piece, if there are any moves from the two provided points

  public void movesOpen (piece p, piece[][] tempBoard) {

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

               if (tempBoard[i][j] instanceof piece && !checkLane) {

                 if (tempBoard[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {

                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     if (tempBoard[i-1][j+1] == null) {

                       p.movesPossible.get(0).add(i-1);//add the location to the moves possible list
                       p.movesPossible.get(1).add(j+1);//add the location to the moves possible list

                       //p.moveTake(tempBoard,i-1, j+1, p);

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

               if (tempBoard[i][j] instanceof piece && !checkLane) {

                 if (tempBoard[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }

                 else {

                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     if (tempBoard[i+1][j-1] == null) {

                        p.movesPossible.get(0).add(i+1);//add the location to the moves possible list
                        p.movesPossible.get(1).add(j-1);//add the location to the moves possible list

                        //p.moveTake(tempBoard,i+1, j-1, p);

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

               if (tempBoard[i][j] instanceof piece && !checkLane) {

                 if (tempBoard[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {
                   checkLane = true;

                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     if ((i+1 < 8) && (j+1 <8)) {

                       if (tempBoard[i+1][j+1] == null) {

                         p.movesPossible.get(0).add(i+1);//add the location to the moves possible list
                         p.movesPossible.get(1).add(j+1);//add the location to the moves possible list

                       //p.moveTake(tempBoard,i+1, j+1, p);

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

               if (tempBoard[i][j] instanceof piece && !checkLane) {

                 if (tempBoard[i][j].side == p.side) {

                   checkLane = true;//fix this up but other than that it seems to recognize open moves

                 }
                 else {
                   if (((i-1 >= 1) && (i+1 <= 8)) && ((j-1 >= 1) && (j+1 <= 8))) {

                     checkLane = true;//fix this up but other than that it seems to recognize open moves
                     if (tempBoard[i-1][j-1] == null) {

                         p.movesPossible.get(0).add(i-1);//add the location to the moves possible list
                         p.movesPossible.get(1).add(j-1);//add the location to the moves possible list

                         //p.moveTake(tempBoard,i-1, j-1, p);

                     }
                   }

                 }
               }

             }

           }


          if (((difX == 1) && (difY == 1)) && (tempBoard[i][j] == null) && ((i != p.xPos) && (j != p.yPos)) && (checkLane == false)) {

            p.movesPossible.get(0).add(i);
            p.movesPossible.get(1).add(j);
            //add the location to the moves possible list if it is adjacent, empty, and the right direction

          }


        }

      }

  }

}

class player extends checkersAi{

int side = 0;
boolean playing = false;

}

class ai extends player implements Cloneable {

  int branch = 0;

  public static int checkPieces(piece[] pieceArray) {

    int count = 0;

    for (int i =0; i < pieceArray.length; i++) {

      if (pieceArray[i] != null) {

        if (pieceArray[i].alive == true) {

          count++;

        }

      }


    }

    return count;

  }

  public int miniMax(piece[][] tumpboard, piece[] redArray, piece[] blackArray,  player[] pArray, Boolean isMaximizingPlayer, int depth, ai rob) {

    rob.branch++;
    int bestVal = 0;
    int currentVal = 0;
    int tempX = 0;
    int tempY = 0;
    boolean kingStatus = false;

    if (rob.checkPieces(redArray) > rob.checkPieces(blackArray)) {
      return 10;
    }
    if (rob.checkPieces(blackArray) > rob.checkPieces(redArray)) {
      return -10;
    }

    if (isMaximizingPlayer) {//aiplayer

      bestVal = -1000;

      for (int i = 0; i < redArray.length-1; i++) {

        redArray[i].movesOpen(redArray[i], tumpboard);

        if (redArray[i].alive) {

            if (redArray[i].movesPossible.get(0).size() > 0) {

              for (int j = 0; j < redArray[i].movesPossible.get(0).size()-1; j++) {

                  tempX = redArray[i].xPos;
                  tempY = redArray[i].yPos;
                  if (redArray[i].king) {
                    kingStatus = true;
                  }

                  redArray[i].makeMove(board, redArray[i], true, redArray[i].movesPossible.get(0).get(j) * 63, redArray[i].movesPossible.get(1).get(j) * 63, pArray);

                   bestVal = Math.max(bestVal, rob.miniMax(tumpboard, redArray, blackArray, pArray, false, 1, rob));
                   System.out.println("Best val is: " + bestVal);

                   tumpboard[tempX][tempY] = redArray[i];
                   tumpboard[redArray[i].xPos][redArray[i].yPos] = null;

                   if ((redArray[i].xPos -1 != -1) && (redArray[i].yPos -1 != -1)) {
                   if (tumpboard[redArray[i].xPos-1][redArray[i].yPos-1] instanceof piece && ((redArray[i].xPos - 2 == tempX) && (redArray[i].yPos - 2 == tempY))) {//will run

                     for (int k =0; k < 11; k++) {

                       if (blackArray[k].xPos ==redArray[i].xPos-1 && blackArray[k].yPos ==redArray[i].yPos-1) {

                          blackArray[k].alive = true;
                          tumpboard[redArray[i].xPos-1][redArray[i].yPos-1] = blackArray[k];


                       }

                     }

                   }
                 }
                   if ((redArray[i].xPos +1 != 9) && (redArray[i].yPos -1 != -1)) {//runs

                     if (tumpboard[redArray[i].xPos+1][redArray[i].yPos-1] == null && ((redArray[i].xPos + 2 == tempX) && (redArray[i].yPos - 2 == tempY))) {

                       for (int k =0; k < 11; k++) {

                         if (blackArray[k].xPos ==redArray[i].xPos+1 && blackArray[k].yPos ==redArray[i].yPos-1) {

                            blackArray[k].alive = true;
                            tumpboard[redArray[i].xPos+1][redArray[i].yPos-1] = blackArray[k];


                         }

                       }

                     }

                   }
                   if ((redArray[i].yPos +1 != 9) && (redArray[i].xPos -1 != -1)) {//will not run


                     if (tumpboard[redArray[i].xPos-1][redArray[i].yPos+1] == null && ((redArray[i].xPos - 2 == tempX) && (redArray[i].yPos + 2 == tempY))) {

                       for (int k =0; k < 11; k++) {

                         if (blackArray[k].xPos ==redArray[i].xPos-1 && blackArray[k].yPos ==redArray[i].yPos+1) {

                            blackArray[k].alive = true;
                            tumpboard[redArray[i].xPos-1][redArray[i].yPos+1] = blackArray[k];


                         }

                       }

                     }

                   }
                   if ((redArray[i].xPos +1 != 9) && (redArray[i].yPos +1 != 9)) {//will not run

                    if (tumpboard[redArray[i].xPos+1][redArray[i].yPos+1] == null && ((redArray[i].xPos + 2 == tempX) && (redArray[i].yPos + 2 == tempY))) {

                      for (int k =0; k < 11; k++) {

                        if (blackArray[k].xPos ==redArray[i].xPos+1 && blackArray[k].yPos ==redArray[i].yPos+1) {

                           blackArray[k].alive = true;
                           tumpboard[redArray[i].xPos+1][redArray[i].yPos+1] = blackArray[k];


                        }

                      }


                    }
                   }

                   if (redArray[i].king && !kingStatus) {

                     redArray[i].king = false;
                   }

                   redArray[i].xPos = tempX;
                   redArray[i].yPos = tempY;
              }

            }

        }

      }


    }
    else {

      bestVal = 1000;

      for (int i = 0; i < blackArray.length-1; i++) {

        blackArray[i].movesOpen(blackArray[i], tumpboard);

        if (blackArray[i].alive) {

            if (blackArray[i].movesPossible.get(0).size() > 0) {

              for (int j = 0; j < blackArray[i].movesPossible.get(0).size()-1; j++) {

                tempX = blackArray[i].xPos;
                tempY = blackArray[i].yPos;
                if (blackArray[i].king) {
                  kingStatus = true;
                }

                  blackArray[i].makeMove(tumpboard, blackArray[i], true, blackArray[i].movesPossible.get(0).get(j) * 63, blackArray[i].movesPossible.get(1).get(j) * 63, pArray);

                   bestVal = Math.max(bestVal,rob.miniMax(tumpboard, redArray,blackArray, pArray, true, 1, rob));

                   tumpboard[tempX][tempY] = blackArray[i];
                   tumpboard[blackArray[i].xPos][blackArray[i].yPos] = null;

                  if ((blackArray[i].xPos -1 != -1) && (blackArray[i].yPos -1 != -1)) {
                   if (tumpboard[blackArray[i].xPos-1][blackArray[i].yPos-1] == null && ((blackArray[i].xPos - 2 == tempX) && (blackArray[i].yPos - 2 == tempY))) {//will run

                     for (int k =0; k < 11; k++) {

                       if (redArray[k].xPos ==blackArray[i].xPos-1 && redArray[k].yPos ==blackArray[i].yPos-1) {

                          redArray[k].alive = true;
                          tumpboard[blackArray[i].xPos-1][blackArray[i].yPos-1] = redArray[k];


                       }

                     }


                   }
                 }
                   if ((blackArray[i].xPos +1 != 9) && (blackArray[i].yPos -1 != -1)) {//runs

                     if (tumpboard[blackArray[i].xPos+1][blackArray[i].yPos-1] == null && ((blackArray[i].xPos + 2 == tempX) && (blackArray[i].yPos - 2 == tempY))) {


                         for (int k =0; k < 11; k++) {

                           if (redArray[k].xPos ==blackArray[i].xPos+1 && redArray[k].yPos ==blackArray[i].yPos-1) {

                              redArray[k].alive = true;
                              tumpboard[blackArray[i].xPos+1][blackArray[i].yPos-1] = redArray[k];


                           }

                         }


                       }

                     }

                   }
                   if ((blackArray[i].yPos +1 != 9) && (blackArray[i].xPos -1 != -1)) {//will not run


                     if (tumpboard[blackArray[i].xPos-1][blackArray[i].yPos+1] == null && ((blackArray[i].xPos - 2 == tempX) && (blackArray[i].yPos + 2 == tempY))) {

                       for (int k =0; k < 11; k++) {

                         if (redArray[k].xPos ==blackArray[i].xPos+1 && redArray[k].yPos ==blackArray[i].yPos+1) {

                            redArray[k].alive = true;
                            tumpboard[blackArray[i].xPos-1][blackArray[i].yPos+1] = redArray[k];


                         }

                       }

                     }

                   }
                   if ((blackArray[i].xPos +1 != 9) && (blackArray[i].yPos +1 != 9)) {//will not run

                    if (tumpboard[blackArray[i].xPos+1][blackArray[i].yPos+1] == null && ((blackArray[i].xPos + 2 == tempX) && (blackArray[i].yPos + 2 == tempY))) {

                      for (int k =0; k < 11; k++) {

                        if (redArray[k].xPos ==blackArray[i].xPos+1 && redArray[k].yPos ==blackArray[i].yPos+1) {

                           redArray[k].alive = true;
                           tumpboard[blackArray[i].xPos+1][blackArray[i].yPos+1] = redArray[k];


                        }

                      }


                    }
                   }

                   if (blackArray[i].king && !kingStatus) {

                     blackArray[i].king = false;
                   }

                   blackArray[i].xPos = tempX;
                   blackArray[i].yPos = tempY;

              }

            }

        }

      }

      return bestVal;
    }


  public int[] AImove(piece[][] tumpboard, piece[] redArray, piece[] blackArray, player[] pArray, ai rob) {

    piece tempBoard[][] = new piece[9][9];

    System.arraycopy( tumpboard, 0, tempBoard, 0, tumpboard.length );

    piece temprArray[] = new piece[12];

    System.arraycopy( redArray, 0, temprArray, 0, redArray.length );
    piece tempbArray[] = new piece[12];

    System.arraycopy( blackArray, 0, tempbArray, 0, redArray.length );

    int bestThings[] = new int[2];
    int bestVal = -1000;
    int currentVal = 0;
    int depth = 0;
    int tempX = 0;
    int tempY = 0;
    boolean kingStatus = false;

    for (int i = 0; i < temprArray.length-1; i++) {

      temprArray[i].movesOpen(temprArray[i], tempBoard);

      if (temprArray[i].alive) {

          if (temprArray[i].movesPossible.get(0).size() > 0) {

            for (int j = 0; j < temprArray[i].movesPossible.get(0).size()-1; j++) {

              System.out.println("The avaliable moves are: " + temprArray[i].movesPossible.get(0).get(j) + " , " + temprArray[i].movesPossible.get(1).get(j) );

                tempX = temprArray[i].xPos;
                tempY = temprArray[i].yPos;
                if (redArray[i].king) {
                  kingStatus = true;
                }

                temprArray[i].makeMove(tempBoard, temprArray[i], true, temprArray[i].movesPossible.get(0).get(j) * 63, temprArray[i].movesPossible.get(1).get(j) * 63, pArray);

                 currentVal = rob.miniMax(tempBoard, temprArray, tempbArray, pArray, false, depth+1, rob);

                //return move
                tempBoard[tempX][tempY] = temprArray[i];
                tempBoard[temprArray[i].xPos][temprArray[i].yPos] = null;

                if ((temprArray[i].xPos -1 != -1) && (temprArray[i].yPos -1 != -1)) {
                if (tempBoard[temprArray[i].xPos-1][temprArray[i].yPos-1] instanceof piece && ((temprArray[i].xPos - 2 == tempX) && (temprArray[i].yPos - 2 == tempY))) {//will run

                  for (int k =0; k < 11; k++) {

                    if (tempbArray[k].xPos ==temprArray[i].xPos-1 && tempbArray[k].yPos ==temprArray[i].yPos-1) {

                       tempbArray[k].alive = true;
                       tempBoard[temprArray[i].xPos-1][temprArray[i].yPos-1] = tempbArray[k];


                    }

                  }

                }
                }
                if ((temprArray[i].xPos +1 != 9) && (temprArray[i].yPos -1 != -1)) {//runs

                  if (tempBoard[temprArray[i].xPos+1][temprArray[i].yPos-1] == null && ((temprArray[i].xPos + 2 == tempX) && (temprArray[i].yPos - 2 == tempY))) {

                    for (int k =0; k < 11; k++) {

                      if (tempbArray[k].xPos ==temprArray[i].xPos+1 && tempbArray[k].yPos ==temprArray[i].yPos-1) {

                         tempbArray[k].alive = true;
                         tempBoard[temprArray[i].xPos+1][temprArray[i].yPos-1] = tempbArray[k];


                      }

                    }

                  }

                }
                if ((temprArray[i].yPos +1 != 9) && (temprArray[i].xPos -1 != -1)) {//will not run


                  if (tempBoard[temprArray[i].xPos-1][temprArray[i].yPos+1] == null && ((temprArray[i].xPos - 2 == tempX) && (temprArray[i].yPos + 2 == tempY))) {

                    for (int k =0; k < 11; k++) {

                      if (tempbArray[k].xPos ==temprArray[i].xPos-1 && tempbArray[k].yPos ==temprArray[i].yPos+1) {

                         tempbArray[k].alive = true;
                         tempBoard[temprArray[i].xPos-1][temprArray[i].yPos+1] = tempbArray[k];


                      }

                    }

                  }

                }
                if ((temprArray[i].xPos +1 != 9) && (temprArray[i].yPos +1 != 9)) {//will not run

                 if (tempBoard[temprArray[i].xPos+1][temprArray[i].yPos+1] == null && ((temprArray[i].xPos + 2 == tempX) && (temprArray[i].yPos + 2 == tempY))) {

                   for (int k =0; k < 11; k++) {

                     if (tempbArray[k].xPos ==temprArray[i].xPos+1 && tempbArray[k].yPos ==temprArray[i].yPos+1) {

                        tempbArray[k].alive = true;
                        tempBoard[temprArray[i].xPos+1][temprArray[i].yPos+1] = tempbArray[k];


                     }

                   }


                 }
                }


                if (temprArray[i].king && !kingStatus) {

                  temprArray[i].king = false;
                }
                temprArray[i].xPos = tempX;
                temprArray[i].yPos = tempY;



                if (currentVal > bestVal && temprArray[i].movesPossible.size() > 0) {

                  bestVal = currentVal;

                  bestThings[0] = i;
                  bestThings[1] = j;

                }



            }

          }

      }

    }

    while ( temprArray[bestThings[0]].movesPossible.size() == 0 && temprArray[bestThings[0]].alive) {

      bestThings[0] = (int)(bestThings[0]*Math.random()*12+1);
    }

    return bestThings ;

  }

}
