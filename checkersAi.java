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
import java.util.Arrays;
//necessary imports

/*<applet code="checkers"width=400 height=400></applet>*/

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
  int fix = 1;
  Color selected = new Color(110, 89, 31);
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


    for (int i =0; i < 12; i++) {

      System.out.println("Piece at " + blackP[i].xPos + " , " + blackP[i].yPos);

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
        System.out.println(pAI.playing);

    int[] array = new int[2];
    boolean alive = false;

    //temp array to hold the ai chosen positions

    piece[] safeRed = ai.deepCop(redP);
    piece[] safeBlack = ai.deepCop(blackP);
    //safety piece array to ensure that the pieces at the end are not changed, this is done by creating deep copies of these respective array

    piece[][] safeboard = new piece[9][9];
    safeboard = ai.deepCopy(board);
    //safety board so that the board doesn't change from a shallow copy. I did this since I was experiencing errors beforehand with the board positions actually changing

    array = otherPlay.AImove(board, redP, blackP, pArray, otherPlay, fix);
    fix++;

    //the array will equal the returned array of the AImvoe method, 0 value is the piece index in the redP array, 1 is the index of the best move for that piece in its movespossible arraylist

    //board = safeboard;// set the regular board back, this was due to the board errors was experiencing earlier

    redP[array[0]].alive = true;

    redP[array[0]].movesOpen(redP[array[0]], board);
    //the real piece the AI will check its possible moves, and its movesPossible array will be altered

    /*
      while (redP[array[0]].movesPossible.get(0).size() == 0 ) {
        array[0] = (int)(Math.random() * 11);
      }
      */


      int tX = (redP[array[0]].movesPossible.get(0).get(array[1]))*63;
      int tY = (redP[array[0]].movesPossible.get(1).get(array[1]))*63;

      System.out.println("Tx: " + tX/63 + " , Ty: " + tY/63 + " , piece at " + redP[array[0]].xPos + " , " + redP[array[0]].yPos);
      System.out.println(board[tX/63][tY/63]);

    //I multiplied the chosen x and y coordiantes by 63, to simulate a click on the board. This I had to do due to the nature of how I built the makeMove method


    //debug statement to tell me the move that the AI took, I wanted to ensure that the move was connecting with the visual board move
    redP[0].makeMove(board,redP[array[0]], true, tX, tY, pArray);

    //the AI will make the move it chose, and I plugged in the x adn y two values, simulating them as a click, and plugged in the piece index with the redP array

    pAI.playing = false;
    pOne.playing = true;
    //changes the turns of the player

    otherPlay.branch = 0;
    //sets the branch of AI to false, so each time the minimax algothrithim made a branch I coutned it, I did this as a way to try to stop stackoverflow error

    /*

    for (int i = 1; i < 9; i++) {

      for (int j = 1; j < 9; j++) {

        if(board[i][j] instanceof piece) {

          System.out.println("Piece at " + board[i][j].xPos + " , " + board[i][j].yPos + "status: " + board[i][j].alive);

        }

      }

    }


    for (int i =0; i < 12; i++) {

      System.out.println("Piece at " + blackP[i].xPos + " , " + blackP[i].yPos);

    }

    */  //debug print statements

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
        for (int i = 0; i < (currentPiece.movesPossible.get(0).size() ); i++) {// loop through the size of the moves avaliable

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

                    if ((tempx >= 2) && (tempy >= 2)){
                       if (tempBoard[tempx-1][tempy-1] instanceof piece && ((tempx - 2 == currentPiece.xPos) && (tempy - 2 == currentPiece.yPos))) {//will run

                         if (tempBoard[tempx-1][tempy-1].side != currentPiece.side) {

                           tempBoard[tempx-1][tempy-1].alive = false;
                           tempBoard[tempx-1][tempy-1] = null;

                         }

                       }
                     }
                       if ((tempx +1 != 9) && (tempy >=2)) {//runs

                         if (tempBoard[tempx+1][tempy-1] instanceof piece && ((tempx + 2 == currentPiece.xPos) && (tempy - 2 == currentPiece.yPos))) {

                           if (tempBoard[tempx+1][tempy-1].side != currentPiece.side) {

                             tempBoard[tempx+1][tempy-1].alive = false;
                             tempBoard[tempx+1][tempy-1] = null;

                           }

                         }

                       }
                       if ((tempy +1 != 9) && (tempx >= 2)) {//will not run


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

class ai extends player {

  int branch = 0;
  piece temprArray[] = new piece[12];
  piece tempbArray[] = new piece[12];

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
    //variables are explained upon use

     // checkers has 500,000,000,000,000,000,000 combinations, so it must be trimmed using a depth variable which stops the minimax from going too deep
      if (rob.checkPieces(redArray) > rob.checkPieces(blackArray)) {
        return 100;//if the robot is in an advantagous position a value of 100 will be returned
      }
      if (rob.checkPieces(blackArray) > rob.checkPieces(redArray)) {
        return -100;//if the robot is in a bad position, a value of -100 is returned
      }


    if (depth < 200) {
      if (isMaximizingPlayer) {//aiplayer
        //the ai is going to take the move that maximizes the value

        bestVal = -10000;
        //the best value is set low in order to ensure that a new value is chosen

        for (int i = 0; i < 11; i++) {
          //cycle through all of the pieces it can move

          redArray[i].movesOpen(redArray[i], tumpboard);
          //check the moves that are open for the specific piece on the temporary board

          if (redArray[i].alive) {
            //make sure the piece is alive

              if (redArray[i].movesPossible.get(0).size() > 0) {
                //ensure that the piece has avaliable moves

                for (int j = 0; j < redArray[i].movesPossible.get(0).size()-1; j++) {
                    //cycle through all of the moves that the selected piece can take

                    tempX = redArray[i].xPos;
                    tempY = redArray[i].yPos;
                    //save its current x and y postitions

                    if (redArray[i].king) {
                      kingStatus = true;
                    }
                    //check to see if it is a king

                    redArray[i].makeMove(board, redArray[i], true, redArray[i].movesPossible.get(0).get(j) * 63, redArray[i].movesPossible.get(1).get(j) * 63, pArray);
                    //make the move that is currently selected

                    depth++;//fix this

                     bestVal = Math.max(bestVal, rob.miniMax(tumpboard, redArray, blackArray, pArray, false, depth, rob));
                     //evaluate that move with minimax, assign it to the value

                     //System.out.println("Best val is: " + bestVal);
                     //print out the value for debugging

                     tumpboard[tempX][tempY] = redArray[i];
                     tumpboard[redArray[i].xPos][redArray[i].yPos] = null;
                     //return the move

                     if ((redArray[i].xPos >=2) && (redArray[i].yPos >= 2)) {
                     if (tumpboard[redArray[i].xPos-1][redArray[i].yPos-1] instanceof piece && ((redArray[i].xPos - 2 == tempX) && (redArray[i].yPos - 2 == tempY))) {//will run

                       for (int k =0; k < 11; k++) {

                         if (blackArray[k].xPos ==redArray[i].xPos-1 && blackArray[k].yPos ==redArray[i].yPos-1) {

                            blackArray[k].alive = true;
                            tumpboard[redArray[i].xPos-1][redArray[i].yPos-1] = blackArray[k];


                         }

                       }

                     }
                   }
                     if ((redArray[i].xPos +1 != 9) && (redArray[i].yPos >= 2)) {//runs

                       if (tumpboard[redArray[i].xPos+1][redArray[i].yPos-1] == null && ((redArray[i].xPos + 2 == tempX) && (redArray[i].yPos - 2 == tempY))) {

                         for (int k =0; k < 11; k++) {

                           if (blackArray[k].xPos ==redArray[i].xPos+1 && blackArray[k].yPos ==redArray[i].yPos-1) {

                              blackArray[k].alive = true;
                              tumpboard[redArray[i].xPos+1][redArray[i].yPos-1] = blackArray[k];


                           }

                         }

                       }

                     }
                     if ((redArray[i].yPos +1 != 9) && (redArray[i].xPos >= 2)) {//will not run


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
                     //return any taking of pieces on the part of the red side

                     if (redArray[i].king && !kingStatus) {

                       redArray[i].king = false;
                     }
                     //if the piece is a king but gained it just now, remove the kingship

                     redArray[i].xPos = tempX;
                     redArray[i].yPos = tempY;
                     //set the recorded x,y coordiantes to the former ones

                }

              }

          }

        }


      }
      else {

        bestVal = 10000;
        //set to a very high value so that it will immediately be replaced

        for (int i = 0; i < 11; i++) {
          //cycle through the array of black pieces

          blackArray[i].movesOpen(blackArray[i], tumpboard);
          //check for moves possible on the temporary board

          if (blackArray[i].alive) {
            //check to see if the piece is alive

              if (blackArray[i].movesPossible.get(0).size() > 0) {
                //ensure the piece can move

                for (int j = 0; j < blackArray[i].movesPossible.get(0).size(); j++) {
                  //cycle through the possible moves

                  tempX = blackArray[i].xPos;
                  tempY = blackArray[i].yPos;
                  //set the pieces current coordinates to temporary variables

                  if (blackArray[i].king) {
                    kingStatus = true;
                  }
                  //if the piece is a king set the status

                    blackArray[i].makeMove(tumpboard, blackArray[i], true, blackArray[i].movesPossible.get(0).get(j) * 63, blackArray[i].movesPossible.get(1).get(j) * 63, pArray);
                    //make the move based on the chosen cycled index

                    depth++;//fix this

                     bestVal = Math.min(bestVal,rob.miniMax(tumpboard, redArray,blackArray, pArray, true, depth, rob));
                     //chose the humans likely move, the human will liekly chose the minimizing move, which is the lowest value

                     tumpboard[tempX][tempY] = blackArray[i];
                     tumpboard[blackArray[i].xPos][blackArray[i].yPos] = null;
                     //reset the move back to previous position


                    if ((blackArray[i].xPos >= 2) && (blackArray[i].yPos >= 2)) {
                     if (tumpboard[blackArray[i].xPos-1][blackArray[i].yPos-1] == null && ((blackArray[i].xPos - 2 == tempX) && (blackArray[i].yPos - 2 == tempY))) {//will run

                       for (int k =0; k < 11; k++) {

                         if (redArray[k].xPos ==blackArray[i].xPos-1 && redArray[k].yPos ==blackArray[i].yPos-1) {

                            redArray[k].alive = true;
                            tumpboard[blackArray[i].xPos-1][blackArray[i].yPos-1] = redArray[k];


                         }

                       }


                     }
                   }
                     if ((blackArray[i].xPos +1 != 9) && (blackArray[i].yPos >= 2)) {//runs

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
                     if ((blackArray[i].yPos +1 != 9) && (blackArray[i].xPos >= 2)) {//will not run


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
                     //reset any pieces that were killed from the move

                     if (blackArray[i].king && !kingStatus) {

                       blackArray[i].king = false;
                     }
                     //if the piece wasn't a king beforehand and is a king now, reset the status


                      blackArray[i].xPos = tempX;
                      blackArray[i].yPos = tempY;
                      //set the recorded x and y positions back to the original

                }

              }

          }

        }

      }


      return bestVal;
    }


    //C
  public static piece[][] deepCopy(piece[][] original) {
      if (original == null) {
          return null;
      }

      final piece[][] result = new piece[original.length][];
      for (int i = 1; i < original.length; i++) {
          result[i] = Arrays.copyOf(original[i], original[i].length);
          // For Java versions prior to Java 6 use the next:
          // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
      }
      return result;
  }//a method to deep copy piece[][] board

  public static piece[] deepCop(piece[] original) {
      if (original == null) {
          return null;
      }

      piece[] result = new piece[original.length];

          result = Arrays.copyOf(original, original.length);
          // For Java versions prior to Java 6 use the next:
          // System.arraycopy(original[i], 0, result[i], 0, original[i].length);

      return result;
  }//a method used to deep copy piece[] arrays

  public int[] AImove(piece[][] tumpboard, piece[] redArray, piece[] blackArray, player[] pArray, ai rob, int time) {

    piece tempBoard[][] = new piece[9][9];
    tempBoard = rob.deepCopy(tumpboard);
    //first a deep copy of the board is created, and it is tempBoard


    //rob.temprArray = rob.deepCop(redArray);
    //rob.tempbArray = rob.deepCop(blackArray);
   if (time == 1) {
    for (int i = 1; i < 9; i++) {

      for (int j = 1; j < 9;j++) {

        if (tempBoard[i][j] instanceof piece) {

           System.out.println("Piece at " + tempBoard[i][j].xPos + " , " + tempBoard[i][j].yPos + "status: " + tempBoard[i][j].alive);

            if (tempBoard[i][j].side == 1) {

              for (int k = 0; k < 11; k++) {

                if (rob.temprArray[k] == null) {
                  rob.temprArray[k] = tempBoard[i][j];
                  System.out.println(k);
                  break;

                }
              }

            }
            if (tempBoard[i][j].side == 2) {

              for (int k = 0; k < 11; k++) {

                if (rob.tempbArray[k] == null) {
                  rob.tempbArray[k] = tempBoard[i][j];
                  break;

                }
              }

            }
        }

      }
    }
  }



    //two deep copied arrays of the black and red piece arrays

    //the issue must be that the two deep copied arrays are not tied to the tempboard

    int bestThings[] = new int[2];
    int bestVal = -1000;
    int currentVal = 0;
    int depth = 0;
    int tempX = 0;
    int tempY = 0;
    int deep = 0;
    boolean kingStatus = false;
    //variables, that wil be explained with use

    for (int i = 0; i < 11; i++) {
      //cycle through the red pieces

      rob.temprArray[i].movesOpen(rob.temprArray[i], tempBoard);
      //check the moves for the current cycled piece on the temporary board

      if (rob.temprArray[i].alive) {
        //make sure the piece is not dead

          if (temprArray[i].movesPossible.get(0).size() > 0) {
            //ensure that it has moves avaliable

            for (int j = 0; j < rob.temprArray[i].movesPossible.get(0).size()-1; j++) {
              //cycle through all of the avaliable moves to the piece in question

              System.out.println("The avaliable moves are: " + rob.temprArray[i].movesPossible.get(0).get(j) + " , " + rob.temprArray[i].movesPossible.get(1).get(j) );
              //print out coordinates, for debug reasons

                tempX = rob.temprArray[i].xPos;
                tempY = rob.temprArray[i].yPos;
                // save the current xpos and ypos of the specific piece

                if (redArray[i].king) {
                  kingStatus = true;
                }
                //check if the piece is a king, this was implemneted due to my issues caused by random kinging occuring

                rob.temprArray[i].makeMove(tempBoard, rob.temprArray[i], true, rob.temprArray[i].movesPossible.get(0).get(j) * 63, rob.temprArray[i].movesPossible.get(1).get(j) * 63, pArray);
                //make the move on the current position that is chosen

                 currentVal = rob.miniMax(tempBoard, rob.temprArray, rob.tempbArray, pArray, false, deep++, rob);
                 //the move will be sent to minimax, it will try to predict the following moves, and use that to select the best moved
                 //minimax is going to return a value
                 deep = 0;

                tempBoard[tempX][tempY] = rob.temprArray[i];
                tempBoard[rob.temprArray[i].xPos][rob.temprArray[i].yPos] = null;
                //return the positions on the temporary board

                if ((rob.temprArray[i].xPos >= 2) && (rob.temprArray[i].yPos >= 2)) {
                  if (tempBoard[rob.temprArray[i].xPos-1][rob.temprArray[i].yPos-1] instanceof piece && ((rob.temprArray[i].xPos - 2 == tempX) && (rob.temprArray[i].yPos - 2 == tempY))) {//will run

                  for (int k =0; k < 11; k++) {

                    if (rob.tempbArray[k].xPos ==rob.temprArray[i].xPos-1 && rob.tempbArray[k].yPos ==rob.temprArray[i].yPos-1) {

                       rob.tempbArray[k].alive = true;
                       tempBoard[rob.temprArray[i].xPos-1][rob.temprArray[i].yPos-1] = rob.tempbArray[k];


                    }

                  }

                 }
                }
                if ((rob.temprArray[i].xPos +1 != 9) && (rob.temprArray[i].yPos >= 2)) {//runs

                  if (tempBoard[rob.temprArray[i].xPos+1][rob.temprArray[i].yPos-1] == null && ((rob.temprArray[i].xPos + 2 == tempX) && (rob.temprArray[i].yPos - 2 == tempY))) {

                    for (int k =0; k < 11; k++) {

                      if (rob.tempbArray[k].xPos ==rob.temprArray[i].xPos+1 && rob.tempbArray[k].yPos ==rob.temprArray[i].yPos-1) {

                         rob.tempbArray[k].alive = true;
                         tempBoard[rob.temprArray[i].xPos+1][rob.temprArray[i].yPos-1] = rob.tempbArray[k];


                      }

                    }

                  }

                }
                if ((rob.temprArray[i].yPos +1 != 9) && (rob.temprArray[i].xPos >= 2)) {//will not run


                  if (tempBoard[rob.temprArray[i].xPos-1][rob.temprArray[i].yPos+1] == null && ((rob.temprArray[i].xPos - 2 == tempX) && (rob.temprArray[i].yPos + 2 == tempY))) {

                    for (int k =0; k < 11; k++) {

                      if (rob.tempbArray[k].xPos ==rob.temprArray[i].xPos-1 && rob.tempbArray[k].yPos ==rob.temprArray[i].yPos+1) {

                         rob.tempbArray[k].alive = true;
                         tempBoard[rob.temprArray[i].xPos-1][rob.temprArray[i].yPos+1] = rob.tempbArray[k];


                      }

                    }

                  }

                }
                if ((rob.temprArray[i].xPos +1 != 9) && (rob.temprArray[i].yPos +1 != 9)) {//will not run

                 if (tempBoard[rob.temprArray[i].xPos+1][rob.temprArray[i].yPos+1] == null && ((rob.temprArray[i].xPos + 2 == tempX) && (rob.temprArray[i].yPos + 2 == tempY))) {

                   for (int k =0; k < 11; k++) {

                     if (rob.tempbArray[k].xPos ==rob.temprArray[i].xPos+1 && rob.tempbArray[k].yPos ==rob.temprArray[i].yPos+1) {

                        rob.tempbArray[k].alive = true;
                        tempBoard[rob.temprArray[i].xPos+1][rob.temprArray[i].yPos+1] = rob.tempbArray[k];


                     }

                   }


                 }
                }
                //if statements to fix the board and pieces that may have died


                if (rob.temprArray[i].king && !kingStatus) {

                  rob.temprArray[i].king = false;
                }//reset the piece if it has became a king

                rob.temprArray[i].xPos = tempX;
                rob.temprArray[i].yPos = tempY;
                //reset the recorded coordinates of the piece chosen, back to its former position

                if (currentVal > bestVal && rob.temprArray[i].movesPossible.size() > 0) {

                  bestVal = currentVal;

                  bestThings[0] = i;
                  bestThings[1] = j;

                }
                //if the move is of more worth than the best move value, save the piece index, and the move index, also set the value to the highest value



            }

          }

      }

    }

    /*
    while ( rob.temprArray[bestThings[0]].movesPossible.size() == 0 && rob.temprArray[bestThings[0]].alive) {

      bestThings[0] = (int)(bestThings[0]*Math.random()*12+1);
    }//code added in the prevent the movement of something due a non changed value of bestThings

    */
    return bestThings ;

  }

}
