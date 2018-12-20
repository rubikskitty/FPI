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

public class Chess extends Applet implements ActionListener, MouseListener {

  Graphics backg;
  Image backbuffer;
  Timer timeCount;
  //required things

  Image picture;
  Image piece;
  //images for each piece

  int x = 0;
  //

  Color selected = new Color(110, 89, 31);
  // variable to store the selected color

  static player playerOne = new player();
  static player playerTwo = new player();
  //creates both player characters


  static boolean oneSelected = false;
  //variable to check if a piece is selected

  ArrayList<piece> blackPieces = new ArrayList<piece>();
  ArrayList<piece> whitePieces = new ArrayList<piece>();
  //arraylists to track each players pieces, and all information involved

  static String playerStatement;
  static String checkStatement = "Check";
  //statements to display information to the player

  static rook blackRookOne = new rook();
  static rook blackRookTwo = new rook();
  static bishop blackBishopOne = new bishop();
  static bishop blackBishopTwo = new bishop();
  static knight blackKnightOne = new knight();
  static knight blackKnightTwo = new knight();
  static queen blackQueen = new queen();
  static king blackKing = new king();
  //create black more expensive pieces

  static pawn blackPawnOne = new pawn();
  static pawn blackPawnTwo= new pawn();
  static pawn blackPawnThree = new pawn();
  static pawn blackPawnFour = new pawn();
  static pawn blackPawnFive = new pawn();
  static pawn blackPawnSix = new pawn();
  static pawn blackPawnSeven = new pawn();
  static pawn blackPawnEight = new pawn();
  //create black pawns

  static rook whiteRookOne = new rook();
  static rook whiteRookTwo = new rook();
  static bishop whiteBishopOne = new bishop();
  static bishop whiteBishopTwo = new bishop();
  static knight whiteKnightOne = new knight();
  static knight whiteKnightTwo = new knight();
  static queen whiteQueen = new queen();
  static king whiteKing = new king();
  //create white more expensive pieces

  static pawn whitePawnOne = new pawn();
  static pawn whitePawnTwo= new pawn();
  static pawn whitePawnThree = new pawn();
  static pawn whitePawnFour = new pawn();
  static pawn whitePawnFive = new pawn();
  static pawn whitePawnSix = new pawn();
  static pawn whitePawnSeven = new pawn();
  static pawn whitePawnEight = new pawn();
  //create white pawns

  static AudioClip chessSound;
  //chess movement sound

  public void init() {

      backbuffer = createImage( 1000, 1000 );
      backg = backbuffer.getGraphics();
      setSize(1000, 1000);
      //all required to create the screen

      backg.setColor( Color.black );
      backg.fillRect( 0, 0, 1000, 1000);
      addMouseListener(this);
      timeCount = new Timer(50, this);
      timeCount.start();
      //start the timer and use buffering

      blackPieces.add(blackRookOne);
      blackPieces.add(blackRookTwo);
      blackPieces.add(blackBishopOne);
      blackPieces.add(blackBishopTwo);
      blackPieces.add(blackKnightOne);
      blackPieces.add(blackKnightTwo);
      blackPieces.add(blackQueen);
      blackPieces.add(blackKing);
      //add black expensive pieces to the black piece list

      blackPieces.add(blackPawnOne);
      blackPieces.add(blackPawnTwo);
      blackPieces.add(blackPawnThree);
      blackPieces.add(blackPawnFour);
      blackPieces.add(blackPawnFive);
      blackPieces.add(blackPawnSix);
      blackPieces.add(blackPawnSeven);
      blackPieces.add(blackPawnEight);
      //add black pawns to the black piece list

      whitePieces.add(whiteRookOne);
      whitePieces.add(whiteRookTwo);
      whitePieces.add(whiteBishopOne);
      whitePieces.add(whiteBishopTwo);
      whitePieces.add(whiteKnightOne);
      whitePieces.add(whiteKnightTwo);
      whitePieces.add(whiteQueen);
      whitePieces.add(whiteKing);
      //add white expensive pieces to the list

      whitePieces.add(whitePawnOne);
      whitePieces.add(whitePawnTwo);
      whitePieces.add(whitePawnThree);
      whitePieces.add(whitePawnFour);
      whitePieces.add(whitePawnFive);
      whitePieces.add(whitePawnSix);
      whitePieces.add(whitePawnSeven);
      whitePieces.add(whitePawnEight);
      //add white pawn pieces to the list


      picture = getImage(getDocumentBase(), "chessBoard.png");
      //image for the chessboard

      blackRookOne.h = getImage(getDocumentBase(), "blackRook.png");
      blackRookTwo.h = getImage(getDocumentBase(), "blackRook.png");
      blackBishopOne.h = getImage(getDocumentBase(), "blackBishop.png");
      blackBishopTwo.h = getImage(getDocumentBase(), "blackBishop.png");
      blackKnightOne.h = getImage(getDocumentBase(), "blackKnight.png");
      blackKnightTwo.h = getImage(getDocumentBase(), "blackKnight.png");
      blackQueen.h = getImage(getDocumentBase(), "blackQueen.png");
      blackKing.h = getImage(getDocumentBase(), "blackKing.png");


      blackPawnOne.h = getImage(getDocumentBase(), "blackPawn.png");
      blackPawnTwo.h = getImage(getDocumentBase(), "blackPawn.png");
      blackPawnThree.h = getImage(getDocumentBase(), "blackPawn.png");
      blackPawnFour.h = getImage(getDocumentBase(), "blackPawn.png");
      blackPawnFive.h = getImage(getDocumentBase(), "blackPawn.png");
      blackPawnSix.h = getImage(getDocumentBase(), "blackPawn.png");
      blackPawnSeven.h = getImage(getDocumentBase(), "blackPawn.png");
      blackPawnEight.h = getImage(getDocumentBase(), "blackPawn.png");

      whiteRookOne.h = getImage(getDocumentBase(), "whiteRook.png");
      whiteRookTwo.h = getImage(getDocumentBase(), "whiteRook.png");
      whiteBishopOne.h = getImage(getDocumentBase(), "whiteBishop.png");
      whiteBishopTwo.h = getImage(getDocumentBase(), "whiteBishop.png");
      whiteKnightOne.h = getImage(getDocumentBase(), "whiteKnight.png");
      whiteKnightTwo.h = getImage(getDocumentBase(), "whiteKnight.png");
      whiteQueen.h = getImage(getDocumentBase(), "whiteQueen.png");
      whiteKing.h = getImage(getDocumentBase(), "whiteKing.png");

      whitePawnOne.h = getImage(getDocumentBase(), "whitePawn.png");
      whitePawnTwo.h = getImage(getDocumentBase(), "whitePawn.png");
      whitePawnThree.h = getImage(getDocumentBase(), "whitePawn.png");
      whitePawnFour.h = getImage(getDocumentBase(), "whitePawn.png");
      whitePawnFive.h = getImage(getDocumentBase(), "whitePawn.png");
      whitePawnSix.h = getImage(getDocumentBase(), "whitePawn.png");
      whitePawnSeven.h = getImage(getDocumentBase(), "whitePawn.png");
      whitePawnEight.h = getImage(getDocumentBase(), "whitePawn.png");

      //set each piece to its specific image

      blackRookOne.Xposition = 0;
      blackRookOne.Yposition = 0;
      blackRookTwo.Xposition = 7;
      blackRookTwo.Yposition = 0;
      blackBishopOne.Xposition = 2;
      blackBishopOne.Yposition = 0;
      blackBishopTwo.Xposition = 5;
      blackBishopTwo.Yposition = 0;
      blackKnightOne.Xposition = 1;
      blackKnightOne.Yposition = 0;
      blackKnightTwo.Xposition = 6;
      blackKnightTwo.Yposition = 0;
      blackQueen.Xposition = 3;
      blackQueen.Yposition = 0;
      blackKing.Xposition = 4;
      blackKing.Yposition = 0;


      blackPawnOne.Xposition = 0;
      blackPawnOne.Yposition = 1;
      blackPawnTwo.Xposition = 1;
      blackPawnTwo.Yposition = 1;
      blackPawnThree.Xposition = 2;
      blackPawnThree.Yposition = 1;
      blackPawnFour.Xposition = 3;
      blackPawnFour.Yposition = 1;
      blackPawnFive.Xposition = 4;
      blackPawnFive.Yposition = 1;
      blackPawnSix.Xposition = 5;
      blackPawnSix.Yposition = 1;
      blackPawnSeven.Xposition = 6;
      blackPawnSeven.Yposition = 1;
      blackPawnEight.Xposition = 7;
      blackPawnEight.Yposition = 1;

      whiteRookOne.Xposition = 0;
      whiteRookOne.Yposition = 7;
      whiteRookTwo.Xposition = 7;
      whiteRookTwo.Yposition = 7;
      whiteBishopOne.Xposition = 2;
      whiteBishopOne.Yposition = 7;
      whiteBishopTwo.Xposition = 5;
      whiteBishopTwo.Yposition = 7;
      whiteKnightOne.Xposition = 1;
      whiteKnightOne.Yposition = 7;
      whiteKnightTwo.Xposition = 6;
      whiteKnightTwo.Yposition = 7;
      whiteQueen.Xposition = 3;
      whiteQueen.Yposition = 7;
      whiteKing.Xposition = 4;
      whiteKing.Yposition = 7;

      whitePawnOne.Xposition = 0;
      whitePawnOne.Yposition = 6;
      whitePawnTwo.Xposition = 1;
      whitePawnTwo.Yposition = 6;
      whitePawnThree.Xposition = 2;
      whitePawnThree.Yposition = 6;
      whitePawnFour.Xposition = 3;
      whitePawnFour.Yposition = 6;
      whitePawnFive.Xposition = 4;
      whitePawnFive.Yposition = 6;
      whitePawnSix.Xposition = 5;
      whitePawnSix.Yposition = 6;
      whitePawnSeven.Xposition = 6;
      whitePawnSeven.Yposition = 6;
      whitePawnEight.Xposition = 7;
      whitePawnEight.Yposition = 6;

      //set the x and y initial positions of each piece

      playerOne.playing = true;
      //player one will start, who is white

      chessSound = getAudioClip(getDocumentBase(), "chess.wav");
      //set the pawn moving sound to the sound

    }

  public void paint( Graphics g ) {
      update( g );
  }

  public void mouseClicked(MouseEvent e) {

      int xpos = e.getX();
      int ypos = e.getY();

      //update x and y coordinates


      int x = 0;
      int y = 0;
      //x and y will track the 0-7, and 0-7 x and y coordinates as opposed to the 100, 200, screen locations

      boolean isActive = true;
      //if is

      if (e.getClickCount() == 1) {

          for (int i = 0; i < 8; i++) {

              for (int j = 0; j < 800; j+=100) {
                  if (xpos < (j + 100)) {
                      x = j /100;//x is the current x position
                      break;
                  }
              }

              if ((ypos  < (i*100 + 100)) && isActive) {
                  y = i;//y is the y position
                  isActive = false;
              }
          }
          //set the x position to t

          //Create way to select a different piece


              if (playerOne.playing) {
                  for (int i = 0; i < whitePieces.size(); i++) {

                	  if (whitePieces.get(i) instanceof king) {
                		  boolean futMove = true;
                		  //decides whether the king is in check in the future or not
                		  king wKing = (king) whitePieces.get(i);
                		  //the white king must be set to a new king


                		  //check each whitepiece moves and compare to the black moves to check if the king can be taken out of check
                		  //due to this large and repetitive nature, this segment is commented in the black players turn

                		  for (int j = 0; j < whitePieces.size(); j++) {

                			  if (whitePieces.get(j) instanceof bishop) {
                                  bishop currentPiece;
                                  try {
									currentPiece = (bishop)whitePieces.get(j).clone();
									} catch (CloneNotSupportedException ez){
										continue;
									}
                                  currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: whitePieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(whitePieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < blackPieces.size(); m++) {

                                		  if (blackPieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo,playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof king) {
                                              king currentPiecea = (king)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }

                			  if (whitePieces.get(j) instanceof queen) {
                                  queen currentPiece;
                                  try {
									currentPiece = (queen)whitePieces.get(j).clone();
									} catch (CloneNotSupportedException ez){
										continue;
									}
                                  currentPiece.checkMoves(currentPiece, playerOne, playerTwo, whitePieces, blackPieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: whitePieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(whitePieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < blackPieces.size(); m++) {

                                		  if (blackPieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo,playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof king) {
                                              king currentPiecea = (king)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }

                			  if (whitePieces.get(j) instanceof rook) {
                                  rook currentPiece;
                                  try {
									currentPiece = (rook)whitePieces.get(j).clone();
									} catch (CloneNotSupportedException ez){
										continue;
									}
                                  currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: whitePieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(whitePieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < blackPieces.size(); m++) {

                                		  if (blackPieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo,playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof king) {
                                              king currentPiecea = (king)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }

                			  if (whitePieces.get(j) instanceof knight) {
                                  knight currentPiece;
                                  try {
									currentPiece = (knight)whitePieces.get(j).clone();
									} catch (CloneNotSupportedException ez){
										continue;
									}
                                  currentPiece.checkMoves(currentPiece, playerOne, whitePieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: whitePieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(whitePieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < blackPieces.size(); m++) {

                                		  if (blackPieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo,playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof king) {
                                              king currentPiecea = (king)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }
                			  if (whitePieces.get(j) instanceof pawn) {
                                  pawn currentPiece;
                                  try {
									currentPiece = (pawn)whitePieces.get(j).clone();
									} catch (CloneNotSupportedException ez){
										continue;
									}
                                  currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: whitePieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(whitePieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < blackPieces.size(); m++) {

                                		  if (blackPieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo,playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof king) {
                                              king currentPiecea = (king)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerTwo, playerOne, blackPieces, aPieces);

                                              for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == wKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  wKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }



                                  }



                		  if (wKing.pPx.size() == 0 && wKing.pPy.size() == 0 && wKing.inCheck && !futMove) {

                			  checkStatement = "Checkmate!, Black wins!";
                			  backg.drawString(checkStatement, 850, 400);
                			  repaint();
                			  timeCount.stop();
                		  }

                		  //tell the players that black won the game and white is in checkmate after it is decided white cannot move to prevent the checkmate, and the kinghas no moves
                	  }

                      /*
                      if ((whitePieces.get(i).isSelected)) {
                          oneSelected = true;
                          break;
                      }
                      */
                      if ((whitePieces.get(i).Xposition == x) && (whitePieces.get(i).Yposition ==y)) {
                          for (int j = 0; j < whitePieces.size(); j++) {
                              if (whitePieces.get(j).isSelected == true) {
                                  whitePieces.get(j).isSelected = false;
                                  //
                              }

                          }
                          whitePieces.get(i).isSelected = true;
                      }
                      //this code will select the white piece that you click on, or change it if one is alreafy selected
                  }
              }
              //in player ones turn this stuff will happen

              if (playerTwo.playing) {
                  for (int i = 0; i < blackPieces.size(); i++) {

                	  if (blackPieces.get(i) instanceof king) {
                		  king bKing = (king) blackPieces.get(i);
                		  boolean futMove = true;
                		  //variable to check if the king is in check in the future

                		  //the following mass of code looks at every black piece and its possible move, and if it was to move there whether the king would still be in check
                		  //due to the massive size of this code, I will only comment one block as the rest is repetition

                		  for (int j =0; j < blackPieces.size(); j++) {
                			  //cycle through each black piece

                			  if (blackPieces.get(j) instanceof bishop) {
                				  //if the black piece is a bishop
                                  bishop currentPiece;
                                  //create new bishop
                                  try {
									     currentPiece = (bishop)blackPieces.get(j).clone();
									     //clone the black bishop, so the actions of current Piece do not affect the black bishop

								   } catch (CloneNotSupportedException ez){
										                  continue;
										                  //this is a required catch statement
									                }

                                  currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);
                                  //for the current bishop check all capable moves, which will save to its move list fields

                                  ArrayList<piece> aPieces = new ArrayList<piece>();
                                  //create a new arraylist of pieces

                                  for (piece z: blackPieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());
                                		  //completely copy the black piece list so aPieces has not affect on back piece list

                                	  }catch(CloneNotSupportedException ex){
                                		  //required catch
                                	  }


                                  }


                                  aPieces.remove(blackPieces.get(j));
                                  //remove the black bishop that was initially chosen from the copied list

                                  aPieces.add(currentPiece);
                                  //add the current chosen piece which is a copy of the black bishop that was removed

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  //cycle through the possible moves for the copied black bishop

                                	  currentPiece.Xposition = currentPiece.pPx.get(k);

                                	  currentPiece.Yposition = currentPiece.pPy.get(k);
                                	  //change the x and y pos of the current piece to the the current moves that are cycled on

                                	  for (int m = 0; m < whitePieces.size(); m++) {
                                		  //cycle through each whitePiece in the white piece list
                                		  //due to the repetition of the code i will only go over the bishop code in this sub group

                                		  if (whitePieces.get(m) instanceof bishop) {
                                			  //if that piece is a bishop
                                              bishop currentPiecea = (bishop)whitePieces.get(m);
                                              //make another piece that will be a bishop that is the same as the white bishop
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);
                                              //check the moves for this piece

                                              for (int l =0; l < whitePieces.get(m).pPx.size(); l++) {



                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;
                                                      //if the black king is in check set the future check variable to false, meaning that the black king has no black pieces to protect it
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  //otherwise there is a piece that will protect it
                                                  continue;
                                                }
                                              }

                                          }

                                		  if (whitePieces.get(m) instanceof knight) {
                                              knight currentPiecea = (knight)whitePieces.get(m);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces);

                                              for (int l =0; l < whitePieces.get(m).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(m) instanceof pawn) {
                                              pawn currentPiecea = (pawn)whitePieces.get(m);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(m).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(m) instanceof queen) {
                                              queen currentPiecea = (queen)whitePieces.get(m);
                                              currentPiecea.checkMoves(currentPiecea, playerOne,playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(m).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(m) instanceof rook) {
                                              rook currentPiecea = (rook)whitePieces.get(m);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(m).pPx.size(); l++) {

                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(m) instanceof king) {
                                              king currentPiecea = (king)whitePieces.get(m);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(m).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }

                			  if (blackPieces.get(j) instanceof rook) {
                                  rook currentPiece;
                                  try {
									     currentPiece = (rook)blackPieces.get(j).clone();
								   } catch (CloneNotSupportedException ez){
										                  continue;
									                }
                                  currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: blackPieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(blackPieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < whitePieces.size(); m++) {

                                		  if (whitePieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                                }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne,playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {

                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof king) {
                                              king currentPiecea = (king)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }

                			  if (blackPieces.get(j) instanceof queen) {
                                  queen currentPiece;
                                  try {
									     currentPiece = (queen)blackPieces.get(j).clone();
								   } catch (CloneNotSupportedException ez){
										                  continue;
									                }
                                  currentPiece.checkMoves(currentPiece, playerTwo, playerOne, blackPieces, whitePieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: blackPieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(blackPieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < whitePieces.size(); m++) {

                                		  if (whitePieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                                }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne,playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {

                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof king) {
                                              king currentPiecea = (king)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }

                			  if (blackPieces.get(j) instanceof knight) {
                                  knight currentPiece;
                                  try {
									     currentPiece = (knight)blackPieces.get(j).clone();
								   } catch (CloneNotSupportedException ez){
										                  continue;
									                }
                                  currentPiece.checkMoves(currentPiece, playerTwo, blackPieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: blackPieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(blackPieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < whitePieces.size(); m++) {

                                		  if (whitePieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                                }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne,playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {

                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof king) {
                                              king currentPiecea = (king)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }

                			  if (blackPieces.get(j) instanceof pawn) {
                                  pawn currentPiece;
                                  try {
									     currentPiece = (pawn)blackPieces.get(j).clone();
								   } catch (CloneNotSupportedException ez){
										                  continue;
									                }
                                  currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);

                                  ArrayList<piece> aPieces = new ArrayList<piece>();

                                  for (piece z: blackPieces) {

                                	  try {
                                		  aPieces.add((piece)z.clone());

                                	  }catch(CloneNotSupportedException ex){

                                	  }


                                  }


                                  aPieces.remove(blackPieces.get(j));
                                  aPieces.add(currentPiece);

                                  for (int k = 0; k < currentPiece.pPx.size(); k++) {
                                	  currentPiece.Xposition = currentPiece.pPx.get(k);
                                	  currentPiece.Yposition = currentPiece.pPy.get(k);

                                	  for (int m = 0; m < whitePieces.size(); m++) {

                                		  if (whitePieces.get(i) instanceof bishop) {
                                              bishop currentPiecea = (bishop)blackPieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                                }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof knight) {
                                              knight currentPiecea = (knight)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (blackPieces.get(i) instanceof pawn) {
                                              pawn currentPiecea = (pawn)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof queen) {
                                              queen currentPiecea = (queen)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne,playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof rook) {
                                              rook currentPiecea = (rook)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {

                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }

                                		  if (whitePieces.get(i) instanceof king) {
                                              king currentPiecea = (king)whitePieces.get(i);
                                              currentPiecea.checkMoves(currentPiecea, playerOne, playerTwo, whitePieces, aPieces);

                                              for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                  if ((currentPiecea.pPx.get(l) == bKing.Xposition) &&  (currentPiecea.pPy.get(l) ==  bKing.Yposition)) {

                                                      futMove = false;;
                                                      break;
                                              }
                                              else {
                                                  futMove = true;
                                                  continue;
                                              }
                                              }

                                          }


                                          }
                                	  }

                                  }


                		  }


                		  // if the king is in check, has no pieces to protect it, and has no way to move it will be in checkmate
                		  if (bKing.pPx.size() == 0 && bKing.pPy.size() == 0 && bKing.inCheck && !futMove) {
                			  checkStatement = "Checkmate!, White wins!";
                			  backg.drawString(checkStatement, 850, 400);
                			  repaint();
                			  timeCount.stop();
                		  }
                	  }

                	  	// changes to black piece that is selected when another is chosen
                      if ((blackPieces.get(i).Xposition == x) && (blackPieces.get(i).Yposition ==y)) {
                          for (int j = 0; j < blackPieces.size(); j++) {
                              if (blackPieces.get(j).isSelected == true) {
                                  blackPieces.get(j).isSelected = false;

                              }

                          }
                          blackPieces.get(i).isSelected = true;
                      }
                  }
              }




              if (playerOne.playing) {
                  for (int i = 0; i < whitePieces.size(); i++) {
                      if ((whitePieces.get(i).isSelected) && !(whitePieces.get(i).isDead)) {

                        if (whitePieces.get(i) instanceof pawn) {
                            pawn currentPiece = (pawn)whitePieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);
                            }
                        if (whitePieces.get(i) instanceof knight) {
                            knight currentPiece = (knight)whitePieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces);
                        }
                        if (whitePieces.get(i) instanceof pawn) {
                            pawn currentPiece = (pawn)whitePieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);
                        }
                        if (whitePieces.get(i) instanceof bishop) {
                            bishop currentPiece = (bishop)whitePieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces,blackPieces);
                        }

                        if (whitePieces.get(i) instanceof rook) {
                            rook currentPiece = (rook)whitePieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);
                        }
                        if (whitePieces.get(i) instanceof queen) {
                            queen currentPiece = (queen)whitePieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerOne, playerTwo, whitePieces, blackPieces);
                        }
                        if (whitePieces.get(i) instanceof king) {
                            king currentPiece = (king)whitePieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerOne, playerTwo, whitePieces, blackPieces);

                        }

                        //if the selected piece is the specified one the pieces possible move will be updated

                          for (int j = 0; j < whitePieces.get(i).pPx.size(); j++) {

                              if (x == whitePieces.get(i).pPx.get(j) && y == whitePieces.get(i).pPy.get(j)) {
                            	  // if the current selected square is one of the possible moves

                                  whitePieces.get(i).Xposition  = x;
                                  whitePieces.get(i).Yposition  = y;
                                  //change the piece x and y to the clicked location

                                  whitePieces.get(i).isSelected = false;
                                  //the piece is no longer selected

                                  oneSelected = false;
                                  //no piece is longer selected

                                  playerOne.playing = false;
                                  playerTwo.playing = true;
                                  //it is player twos turns

                                  //bishop will only be commented due to repetition
                                  //additonally this is the same code for the black player
                                  //some of these areas have wrong variables and may not work due to it being done so soon, but the game will continue

                                  for (int k =0, po = 0; k < whitePieces.size() && po < blackPieces.size(); k++, po++) {

                                      if (whitePieces.get(k) instanceof king) {
                                    	  //if the whitePiece is a king

                                          king currentKing = (king)whitePieces.get(k);
                                          //a new variable will be the current selected king

                                          if (blackPieces.get(po) instanceof bishop) {
                                        	  //if the current black piece is a bishop

                                              bishop currentPiece = (bishop)blackPieces.get(po);
                                              //create a new bishop variable that is a copy of the black current bishop

                                              currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);
                                              //check the moves for that current bishop

                                              for (int l =0; l < blackPieces.get(po).pPx.size(); l++) {
                                            	  //for each of the black piece current moves


                                                  if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {
                                                	  	//the current white king will be put into check if the current possible position aligns with the kings spot
                                                      currentKing.inCheck = true;
                                                      break;
                                              }
                                              else {
                                                  currentKing.inCheck = false;
                                                  continue;
                                              }
                                              }

                                          }
                                          if (blackPieces.get(po) instanceof king) {
                                              king currentPiece = (king)blackPieces.get(po);
                                              currentPiece.checkMoves(currentPiece, playerTwo, playerOne, blackPieces, whitePieces);

                                              for (int l =0; l < blackPieces.get(po).pPx.size(); l++) {


                                                  if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                      currentKing.inCheck = true;
                                                      break;
                                              }
                                              else {
                                                  currentKing.inCheck = false;
                                                  continue;
                                              }
                                              }

                                          }
                                          if (blackPieces.get(po) instanceof pawn) {
                                              pawn currentPiece = (pawn)blackPieces.get(po);
                                              currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);

                                              for (int l =0; l < blackPieces.get(po).pPx.size(); l++) {


                                                  if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                      currentKing.inCheck = true;
                                                      break;
                                              }
                                              else {
                                                  currentKing.inCheck = false;
                                                  continue;
                                              }
                                              }

                                          }

                                          if (blackPieces.get(po) instanceof queen) {
                                              queen currentPiece = (queen)blackPieces.get(po);
                                              currentPiece.checkMoves(currentPiece, playerTwo, playerOne, blackPieces, whitePieces);

                                              for (int l =0; l < blackPieces.get(po).pPx.size(); l++) {


                                                  if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                      currentKing.inCheck = true;
                                                      break;
                                              }
                                              else {
                                                  currentKing.inCheck = false;
                                                  continue;
                                              }
                                              }

                                          }

                                          if (blackPieces.get(po) instanceof rook) {
                                              rook currentPiece = (rook)blackPieces.get(po);
                                              currentPiece.checkMoves(currentPiece, playerTwo, blackPieces,whitePieces);

                                              for (int l =0; l < blackPieces.get(po).pPx.size(); l++) {


                                                  if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                      currentKing.inCheck = true;
                                                      break;
                                              }
                                              else {
                                                  currentKing.inCheck = false;
                                                  continue;
                                              }
                                              }

                                          }

                                          if (blackPieces.get(po) instanceof knight) {
                                              knight currentPiece = (knight)blackPieces.get(po);
                                              currentPiece.checkMoves(currentPiece, playerTwo, blackPieces);

                                              for (int l =0; l < blackPieces.get(po).pPx.size(); l++) {


                                                  if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                      currentKing.inCheck = true;
                                                      break;
                                              }
                                              else {
                                                  currentKing.inCheck = false;
                                                  continue;
                                              }
                                              }

                                          }



                                      }

                                  }

                                for (int k =0; k < blackPieces.size(); k++) {
                                    if (blackPieces.get(k) instanceof king) {
                                        king currentKing = (king)blackPieces.get(k);
                                        if (whitePieces.get(i) instanceof bishop) {
                                            bishop currentPiece = (bishop)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces,blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }
                                        if (whitePieces.get(i) instanceof king) {
                                            king currentPiece = (king)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne,playerTwo, whitePieces, blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }
                                        if (whitePieces.get(i) instanceof pawn) {
                                            pawn currentPiece = (pawn)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (whitePieces.get(i) instanceof queen) {
                                            queen currentPiece = (queen)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, playerTwo, whitePieces, blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) == currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (whitePieces.get(i) instanceof rook) {
                                            rook currentPiece = (rook)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces,blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (whitePieces.get(i) instanceof knight) {
                                            knight currentPiece = (knight)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }



                                    }

                                }

                                  if (whitePieces.get(i) instanceof pawn) {
                                    pawn currentPiece = (pawn)whitePieces.get(i);
                                    currentPiece.hasMovedTwice = true;
                                    //if the pawn has moved twice change its status
                                  }
                                  chessSound.play();
                                  //play the chess sound when the movement occurs
                                  break;
                          }

                      }

                  }

              }
          }

            if (playerTwo.playing) {
                  for (int i = 0; i < blackPieces.size(); i++) {
                  if ((blackPieces.get(i).isSelected) && !(blackPieces.get(i).isDead)) {

                      if (blackPieces.get(i) instanceof knight) {
                            knight currentPiece = (knight)blackPieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces);
                            }
                        if (blackPieces.get(i) instanceof pawn) {
                            pawn currentPiece = (pawn)blackPieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);
                        }
                        if (blackPieces.get(i) instanceof bishop) {
                            bishop currentPiece = (bishop)blackPieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);
                        }
                        if (blackPieces.get(i) instanceof rook) {
                            rook currentPiece = (rook)blackPieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);
                        }
                        if (blackPieces.get(i) instanceof queen) {
                            queen currentPiece = (queen)blackPieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerTwo, playerOne, blackPieces, whitePieces);
                        }
                        if (blackPieces.get(i) instanceof king) {
                            king currentPiece = (king)blackPieces.get(i);
                            currentPiece.checkMoves(currentPiece, playerTwo, playerOne, blackPieces, whitePieces);
                        }

                      for (int j = 0; j < blackPieces.get(i).pPx.size(); j ++) {

                          if (x == blackPieces.get(i).pPx.get(j) && y == blackPieces.get(i).pPy.get(j)) {



                                blackPieces.get(i).Xposition  = x;
                                blackPieces.get(i).Yposition  = y;
                                blackPieces.get(i).isSelected = false;
                                oneSelected = false;
                                playerTwo.playing = false;
                                playerOne.playing = true;

                                for (int k =0; k < blackPieces.size(); k++) {
                                    if (blackPieces.get(k) instanceof king) {
                                        king currentKing = (king)blackPieces.get(k);
                                        if (whitePieces.get(i) instanceof bishop) {
                                            bishop currentPiece = (bishop)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces,blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }
                                        if (whitePieces.get(i) instanceof king) {
                                            king currentPiece = (king)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne,playerTwo, whitePieces, blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }
                                        if (whitePieces.get(i) instanceof pawn) {
                                            pawn currentPiece = (pawn)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces, blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (whitePieces.get(i) instanceof queen) {
                                            queen currentPiece = (queen)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, playerTwo, whitePieces, blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) == currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (whitePieces.get(i) instanceof rook) {
                                            rook currentPiece = (rook)whitePieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerOne, whitePieces,blackPieces);

                                            for (int l =0; l < whitePieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }
                                    }
                                }

                                for (int k =0; k < whitePieces.size(); k++) {
                                    if (whitePieces.get(k) instanceof king) {
                                        king currentKing = (king)whitePieces.get(k);
                                        if (blackPieces.get(i) instanceof bishop) {
                                            bishop currentPiece = (bishop)blackPieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);

                                            for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }
                                        if (blackPieces.get(i) instanceof king) {
                                            king currentPiece = (king)blackPieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerTwo, playerOne, blackPieces, whitePieces);

                                            for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }
                                        if (blackPieces.get(i) instanceof pawn) {
                                            pawn currentPiece = (pawn)blackPieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces, whitePieces);

                                            for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (blackPieces.get(i) instanceof queen) {
                                            queen currentPiece = (queen)blackPieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerTwo, playerOne, blackPieces, whitePieces);

                                            for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (blackPieces.get(i) instanceof rook) {
                                            rook currentPiece = (rook)blackPieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces,whitePieces);

                                            for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }

                                        if (blackPieces.get(i) instanceof knight) {
                                            knight currentPiece = (knight)blackPieces.get(i);
                                            currentPiece.checkMoves(currentPiece, playerTwo, blackPieces);

                                            for (int l =0; l < blackPieces.get(i).pPx.size(); l++) {


                                                if ((currentPiece.pPx.get(l) ==  currentKing.Xposition) &&  (currentPiece.pPy.get(l) ==  currentKing.Yposition)) {

                                                    currentKing.inCheck = true;
                                                    break;
                                            }
                                            else {
                                                currentKing.inCheck = false;
                                                continue;
                                            }
                                            }

                                        }



                                    }

                                }

                                if (blackPieces.get(i) instanceof pawn) {
                                    pawn currentPiece = (pawn)blackPieces.get(i);
                                    currentPiece.hasMovedTwice = true;
                                }

                                chessSound.play();
                                break;
                          }

                      }

                  }

              }
          }
      }

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
      //make a white background screen each time

      backg.drawImage(picture, 0, 0, 800, 800, this);
      //draw the chess board

      if (playerOne.playing) {
    	  		//if it is the white player turn change the text to white player turn
    	  		//this section will be commented for black, while for white it will not

            playerStatement = "White player turn";

            for (int i =0; i < whitePieces.size(); i++) {

            	if (whitePieces.get(i).isSelected) {


            		backg.setColor(selected);
            		backg.fillRect(100*whitePieces.get(i).Xposition, 100*whitePieces.get(i).Yposition, 100, 100);

                }


            	for (int j = 0; j < whitePieces.get(i).pPx.size(); j++) {
                    if (whitePieces.get(i).isSelected) {
                    	backg.fillRect(100*whitePieces.get(i).pPx.get(j), 100*whitePieces.get(i).pPy.get(j), 100, 100);
                    }

                }

                for (int j = 0; j < blackPieces.size(); j++) {
                	if ( i == whitePieces.size()) {
                		i--;
                	}
                    if ((whitePieces.get(i).Xposition == blackPieces.get(j).Xposition) && (whitePieces.get(i).Yposition == blackPieces.get(j).Yposition)) {

                        whitePieces.get(i).isDead = true;

                        if (whitePieces.get(i).isDead) {
                            whitePieces.remove(i);
                            i = i--;

                        }

                    }
                }



            }
        }

      if (playerTwo.playing) {
            playerStatement = "Black player turn";
            //change the statement to the black player

          for (int i =0; i < blackPieces.size(); i++) {

            if (blackPieces.get(i).isSelected) {

                backg.setColor(selected);
                backg.fillRect(100*blackPieces.get(i).Xposition, 100*blackPieces.get(i).Yposition, 100, 100);

                //if the current piece is selected, draw the selected brown square at their current x and ys

            }

            for (int j = 0; j < blackPieces.get(i).pPx.size(); j++) {
                if (blackPieces.get(i).isSelected) {
                    backg.fillRect(100*blackPieces.get(i).pPx.get(j), 100*blackPieces.get(i).pPy.get(j), 100, 100);
                }

                //additionally draw a brown square in each possible move square

            }

            for (int j = 0; j < whitePieces.size(); j++) {
            	if ( i == blackPieces.size()) {
            		//this is for debugging I was having index issue
            		i--;
            	}
                if ((whitePieces.get(j).Xposition == blackPieces.get(i).Xposition) && (whitePieces.get(j).Yposition == blackPieces.get(i).Yposition)) {

                    blackPieces.get(i).isDead = true;

                    if (blackPieces.get(i).isDead) {
                        blackPieces.remove(i);
                        i = i--;
                        //Index issue fix again, but also the removal of a dead piece form the list of black pieces

                    }

                }
            }


            }
      }



      for (int i = 0; i < whitePieces.size(); i++) {

                whitePieces.get(i).drawPiece(backg, whitePieces.get(i));
                //draw the current white piece in its position
      }

      for (int i = 0; i < blackPieces.size(); i++) {

            blackPieces.get(i).drawPiece(backg, blackPieces.get(i));
            //draw the black piece in position

      }

      backg.setColor(Color.black);
      //change the color for the string drawing than draw the palyer statement
      backg.drawString(playerStatement, 850, 300);



      for (int i = 0; i < whitePieces.size(); i++) {
            if (whitePieces.get(i) instanceof king) {


                king currentKing = (king)whitePieces.get(i);
                if (currentKing.inCheck) {
                    backg.drawString(checkStatement, 850, 400);
                    //draw the king check statement if it is in check the white piece
            }
                else {
                    currentKing.inCheck = false;
                }
      }


    }

      for (int i = 0; i < blackPieces.size(); i++) {
        if (blackPieces.get(i) instanceof king) {

            king currentKing = (king)blackPieces.get(i);
            if (currentKing.inCheck) {
                backg.drawString(checkStatement, 850, 400);
              //draw the king check statement if it is in check the black piece
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

class player extends Chess {

    boolean playing = false;
}
//although small as a class, the player class is very important as it tracks the current order of the game

class piece extends Chess{

  Image h;
  //this is the track variable for the image of the piece
  int Xposition;
  //this is the xposition on the board for the piece
  int Yposition;
  //this is the y position on the board for the piece
  boolean isSelected;
  //this variable tracks wheher the piece is selected

  boolean isDead = false;
  //this variable tracks whether the piece is dead

  ArrayList<Integer> pPx = new ArrayList<Integer>();
  //  this arraylist tracks the possible x locations in movement for the piece

  ArrayList<Integer> pPy = new ArrayList<Integer>();
  //this arraylist tracks the possible y locations in movement for the piece


  public void drawPiece(Graphics g, piece p) {
    g.drawImage(p.h, (p.Xposition * 100) + 15, (p.Yposition * 100) + 15, 75,75, this);
  }

  //this method draws the piece in the desired location
}

class pawn extends piece implements Cloneable{
    // White: Movement: (x - 0, y - 1), Attacking: (x-1,y-1)
    // Black: Movement: (x + 0, y + 1), Attacking: (x+1,y+1),  (x-1,y+1)

    boolean hasMovedTwice;

    public void checkMoves(pawn g, player p, ArrayList<piece> e, ArrayList<piece> a) {
        ArrayList<Integer> emptyX= new ArrayList<Integer>();
        ArrayList<Integer> emptyY = new ArrayList<Integer>();

        boolean var = false;

        g.pPx = emptyX;
        g.pPy = emptyY;

        for (int i = 0; i < 8; i++) {

              for (int j = 0; j < 800; j+=100) {

                  if (p == playerOne) {

                      if ((i == g.Xposition + 0) && ((j/100) ==g.Yposition - 2) && g.hasMovedTwice == false) {
                          for (int k = 0, l = 0; k < e.size() && l < a.size(); k++, l++) {

                        	  boolean y = true;

                        	  if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition)))) {
                        		  y = false;
                        	  }
                              if (y)  {
                                  g.pPx.add(i);
                                  g.pPy.add((j/100));
                                  break;
                              }

                              else {
                                  continue;
                                  }
                          }

                      }


                      if ((i == g.Xposition + 0) && ((j/100) == g.Yposition - 1)) {

                    	  boolean f = false;
                          for (int k = 0, l = 0; (k < e.size()) && (l < a.size()); k++, l++) {

                        	  if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))) || (((i == a.get(l).Xposition) && ((j/100) == a.get(l).Yposition)))) {

                        		  f = true;
                        	  }
                              else {
                                  continue;
                                  }

                          }

                          if (!f) {
                              g.pPx.add(i);
                              g.pPy.add((j/100));
                              break;
                          }
                      }

                      //diagonal
                      for (int l = 0; l < a.size(); l++) {
                          if (((g.Xposition + 1) == a.get(l).Xposition) && ((g.Yposition - 1) == a.get(l).Yposition)) {
                              g.pPx.add(a.get(l).Xposition);
                              g.pPy.add(a.get(l).Yposition);
                              break;
                          }
                          else if (((g.Xposition - 1) == a.get(l).Xposition) && ((g.Yposition - 1)== a.get(l).Yposition)) {
                              g.pPx.add(a.get(l).Xposition);
                              g.pPy.add(a.get(l).Yposition);
                              break;
                          }

                          else {
                              continue;

                          }
                      }

                  }

                 if (p == playerTwo) {

                	 if ((i == g.Xposition + 0) && ((j/100) ==g.Yposition + 2) && g.hasMovedTwice == false) {

                		  for (int k = 0; k < e.size(); k++) {
                              if (!(((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))))  {
                                  g.pPx.add(i);
                                  g.pPy.add((j/100));
                                  break;
                              }
                              else {
                                  continue;
                                  }
                          }

                     }


                     if ((i == g.Xposition + 0) && ((j/100) == g.Yposition + 1)) {

                    	 boolean f = false;
                         for (int k = 0, l = 0; (k < e.size()) && (l < a.size()); k++, l++) {

                       	  if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))) || (((i == a.get(l).Xposition) && ((j/100) == a.get(l).Yposition)))) {

                       		  f = true;
                       	  }
                             else {
                                 continue;
                                 }

                         }

                         if (!f) {
                             g.pPx.add(i);
                             g.pPy.add((j/100));
                             break;
                         }

                     }

                      for (int l = 0; l < a.size(); l++) {
                          if (((g.Xposition - 1) == a.get(l).Xposition) && ((g.Yposition + 1) == a.get(l).Yposition)) {
                              g.pPx.add(a.get(l).Xposition);
                              g.pPy.add(a.get(l).Yposition);
                              break;
                          }
                          else if (((g.Xposition + 1) == a.get(l).Xposition) && ((g.Yposition + 1)== a.get(l).Yposition)) {
                              g.pPx.add(a.get(l).Xposition);
                              g.pPy.add(a.get(l).Yposition);
                              break;
                          }
                      }

                  }



                  }
              }

          }
}
//pawns check moves based on color, and have a field to track whether the initial movement occured,

class knight extends piece {

    public void checkMoves(knight g, player p, ArrayList<piece> e) {

        ArrayList<Integer> emptyX = new ArrayList<Integer>();
        ArrayList<Integer> emptyY = new ArrayList<Integer>();

        boolean var = false;
        g.pPx = emptyX;
        g.pPy = emptyY;

        for (int i = 0; i < 8; i++) {

              for (int j = 0; j < 800; j+=100) {
                  //fix 3,6

                  if (((((i == g.Xposition - 1)) && (((j/100) == g.Yposition -2))) || ((i == g.Xposition + 1) && ((j/100) == g.Yposition -2)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition - 1)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition -1)) || ((i == g.Xposition + 1) && ((j/100) == g.Yposition + 2)) || ((i == g.Xposition - 1) && ((j/100) == g.Yposition + 2)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition + 1)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition + 1)))) {
                      var = false;
                      for (int k = 0; k < e.size(); k++) {
                          if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))) && !e.get(k).isDead)  {
                             var = true;
                             break;
                          }


                      }

                      if (var == true) {
                          continue;
                      }
                      else {
                          g.pPx.add(i);
                          g.pPy.add((j/100));
                      }
                  }



                  }
              }

          }
    }
//knight class will check moves for knight based on legal knight moves


class bishop extends piece {


    public void checkMoves(bishop g, player p, ArrayList<piece> e, ArrayList<piece> a) {

        ArrayList<Integer> emptyX = new ArrayList<Integer>();
        ArrayList<Integer> emptyY = new ArrayList<Integer>();

        boolean var = false;
        g.pPx = emptyX;
        g.pPy = emptyY;

        for (int i = 0; i < 8; i++) {

              for (int j = 0; j < 800; j+=100) {
                  //fix 3,6
                  if (((i == g.Xposition + 1) && ((j/100) == g.Yposition +1)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition +2)) || ((i == g.Xposition + 3) && ((j/100) == g.Yposition +3)) || ((i == g.Xposition + 4) && ((j/100) == g.Yposition +4)) || ((i == g.Xposition + 5) && ((j/100) == g.Yposition +5)) || ((i == g.Xposition + 6) && ((j/100) == g.Yposition +6)) || ((i == g.Xposition + 7) && ((j/100) == g.Yposition +7)) || ((i == g.Xposition + 8) && ((j/100) == g.Yposition +8)) || ((i == g.Xposition - 1) && ((j/100) == g.Yposition - 1)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition - 2)) || ((i == g.Xposition - 3) && ((j/100) == g.Yposition - 3)) || ((i == g.Xposition -4) && ((j/100) == g.Yposition - 4)) || ((i == g.Xposition - 5) && ((j/100) == g.Yposition - 5)) || ((i == g.Xposition - 6) && ((j/100) == g.Yposition - 6)) || ((i == g.Xposition - 7) && ((j/100) == g.Yposition - 7)) || ((i == g.Xposition - 8) && ((j/100) == g.Yposition - 8)) || ((i == g.Xposition + 1) && ((j/100) == g.Yposition -1)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition - 2)) || ((i == g.Xposition + 3) && ((j/100) == g.Yposition - 3)) || ((i == g.Xposition + 4) && ((j/100) == g.Yposition - 4)) || ((i == g.Xposition + 5) && ((j/100) == g.Yposition - 5)) || ((i == g.Xposition + 6) && ((j/100) == g.Yposition -6)) || ((i == g.Xposition +7) && ((j/100) == g.Yposition -7)) || ((i == g.Xposition + 8) && ((j/100) == g.Yposition - 8)) || ((i == g.Xposition - 1) && ((j/100) == g.Yposition +1)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition + 2)) || ((i == g.Xposition - 3) && ((j/100) == g.Yposition + 3)) || ((i == g.Xposition - 4) && ((j/100) == g.Yposition + 4)) || ((i == g.Xposition - 5) && ((j/100) == g.Yposition + 5)) || ((i == g.Xposition - 6) && ((j/100) == g.Yposition + 6)) || ((i == g.Xposition - 7) && ((j/100) == g.Yposition +7)) || ((i == g.Xposition - 8) && ((j/100) == g.Yposition +8))) {

                      var = false;
                      for (int k = 0, v = 0; k < e.size() && v < a.size(); k++, v++) {
                          if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))) && !e.get(k).isDead)  {
                             var = true;
                             break;
                          }


                          for (int l = (j/100), m = i; l < g.Yposition && m < g.Xposition; l++, m++) {

                                for (int n = l, r = m; n < g.Yposition && r < g.Xposition; n++, r++) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }



                          for (int l = (j/100), m = i; l > g.Yposition && m > g.Xposition; l--, m--) {

                                for (int n = l, r = m; n > g.Yposition && r > g.Xposition; n--, r--) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l < g.Yposition && m > g.Xposition; l++, m--) {

                                for (int n = l, r = m; n < g.Yposition && r > g.Xposition; n++, r--) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l > g.Yposition && m < g.Xposition; l--, m++) {

                                for (int n = l, r = m; n > g.Yposition && r < g.Xposition; n--, r++) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l < g.Yposition && m < g.Xposition; l++, m++) {

                                for (int n = l, r = m; n < g.Yposition && r < g.Xposition; n++, r++) {

                                        if ((((r == a.get(v).Xposition -1) && (n == a.get(v).Yposition -1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l > g.Yposition && m > g.Xposition; l--, m--) {

                                for (int n = l, r = m; n > g.Yposition && r > g.Xposition; n--, r--) {

                                        if ((((r == a.get(v).Xposition+1) && (n == a.get(v).Yposition+1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l < g.Yposition && m > g.Xposition; l++, m--) {

                                for (int n = l, r = m; n < g.Yposition && r > g.Xposition; n++, r--) {

                                        if ((((r == a.get(v).Xposition+1) && (n == a.get(v).Yposition-1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l > g.Yposition && m < g.Xposition; l--, m++) {

                                for (int n = l, r = m; n > g.Yposition && r < g.Xposition; n--, r++) {

                                        if ((((r == a.get(v).Xposition-1) && (n == a.get(v).Yposition+1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }



                      }

                      if (var == true) {
                          continue;
                      }
                      else {
                          g.pPx.add(i);
                          g.pPy.add((j/100));
                      }
                  }



                  }
              }

    }

//create a bishop class, that checks avaliable moves based on legal moves for a bishop

}

//I will comment this king class movement as opposed to the other pieces, since they are similiar but slightly different

class king extends piece {

    boolean inCheck;
    //keeps track of whether the king is in check


    public void checkMoves(king g, player p, player pa, ArrayList<piece> e, ArrayList<piece> a) {
    	//accepts the king, the present player, the enemy player, the arraylist of the player, the arraylist of the enemy
        ArrayList<Integer> emptyX = new ArrayList<Integer>();
        ArrayList<Integer> emptyY = new ArrayList<Integer>();
        //2 lists to reset the possible move lists


        boolean var = false;
        boolean ya = false;
        //variable for tracking

        g.pPx = emptyX;
        g.pPy = emptyY;
        //reset the possible moves

        for (int i = 0; i < 8; i++) {

              for (int j = 0; j < 800; j+=100) {
            	  	//for each move on the board
                  //fix 3,6

                  if ((i == g.Xposition + 1) && (((j/100) == g.Yposition +1 )) || (i == g.Xposition + 1) && (((j/100) == g.Yposition - 1 )) || (i == g.Xposition - 1) && (((j/100) == g.Yposition +1 )) || (i == g.Xposition - 1) && (((j/100) == g.Yposition - 1 )) || (i == g.Xposition + 1) && (((j/100) == g.Yposition )) || (i == g.Xposition - 1) && (((j/100) == g.Yposition )) || (i == g.Xposition) && (((j/100) == g.Yposition + 1)) || (i == g.Xposition) && (((j/100) == g.Yposition -1))) {
                      var = false;
                      //massive if statement that contains all possible moves for the king, and if it is a move continue on

                      for (int k = 0; k < e.size(); k++) {

                          if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))) && !e.get(k).isDead)  {
                             var = true;
                             //the move will be avaliable unless it is occupied by an enemy
                             break;
                          }

                      }


                      //add a checkmate condition to check if the king is in check ore checkmate here, or where in instances

                      //this is repetition so I will only do knight
                      for (int n = 0; n < a.size(); n++) {
                    	  if (a.get(n)instanceof knight) {
                    		  //if the piece in the enemy cycle is a knight set the current piece to that knight

                    		  knight currentPiece = (knight)a.get(n);
                              currentPiece.checkMoves(currentPiece, pa, a);
                              //check the currentMoves for this knight

                              for (int q = 0; q < currentPiece.pPx.size(); q++) {
                            	  //check the possible moves for this black knight

                            	  if ((i ==  currentPiece.pPx.get(q)) && ((j/100) ==  currentPiece.pPy.get(q))) {
                            		  //if the current square aligns with the possible move, this move will not be avaliable to the king
                            		  var = true;
                            		  break;
                            	  }
                              }
                    	  }
                    	  if (a.get(n)instanceof pawn) {
                    		  pawn currentPiece = (pawn)a.get(n);
                              currentPiece.checkMoves(currentPiece, pa, a, e);

                              for (int q = 0; q < currentPiece.pPx.size(); q++) {
                            	  if ((i ==  currentPiece.pPx.get(q)) && ((j/100) ==  currentPiece.pPy.get(q))) {
                            		  var = true;
                            		  break;
                            	  }
                              }
                    	  }
                    	  if (a.get(n)instanceof bishop) {
                    		  bishop currentPiece = (bishop)a.get(n);
                              currentPiece.checkMoves(currentPiece, pa, a, e);

                              for (int q = 0; q < currentPiece.pPx.size(); q++) {
                            	  if ((i ==  currentPiece.pPx.get(q)) && ((j/100) ==  currentPiece.pPy.get(q))) {
                            		  var = true;
                            		  break;
                            	  }
                              }
                    	  }
                    	  if (a.get(n)instanceof rook) {
                    		  rook currentPiece = (rook)a.get(n);
                              currentPiece.checkMoves(currentPiece, pa, a, e);

                              for (int q = 0; q < currentPiece.pPx.size(); q++) {
                            	  if ((i ==  currentPiece.pPx.get(q)) && ((j/100) ==  currentPiece.pPy.get(q))) {
                            		  var = true;
                            		  break;
                            	  }
                              }
                    	  }
                    	  if (a.get(n)instanceof queen) {
                    		  queen currentPiece = (queen)a.get(n);
                              currentPiece.checkMoves(currentPiece, pa, p, a, e);

                              for (int q = 0; q < currentPiece.pPx.size(); q++) {
                            	  if ((i ==  currentPiece.pPx.get(q)) && ((j/100) ==  currentPiece.pPy.get(q))) {
                            		  var = true;
                            		  break;
                            	  }
                              }
                    	  }

                      }

                      if (var == true) {
                          continue;
                          //if this is true the move is not avaliable
                      }
                      else {
                          g.pPx.add(i);
                          g.pPy.add((j/100));
                          //adds the move to the list of possible moves
                      }
                  }



                  }
              }

          }
}
//create a class of king, that has a method to discover moves, based on legal chess moves for a king, and create a field that tracks whether that king is in check

//create a class of queen, that will check for possible queen moves and set the possible moves to that
class queen extends piece {


    public void checkMoves(queen g, player p, player pa, ArrayList<piece> e, ArrayList<piece> a) {

        ArrayList<Integer> emptyX = new ArrayList<Integer>();
        ArrayList<Integer> emptyY = new ArrayList<Integer>();

        boolean var = false;

        g.pPx = emptyX;
        g.pPy = emptyY;


        for (int i = 0; i < 8; i++) {

              for (int j = 0; j < 800; j+=100) {
                  //fix 3,6
                  if (((i == g.Xposition + 1) && ((j/100) == g.Yposition +1)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition +2)) || ((i == g.Xposition + 3) && ((j/100) == g.Yposition +3)) || ((i == g.Xposition + 4) && ((j/100) == g.Yposition +4)) || ((i == g.Xposition + 5) && ((j/100) == g.Yposition +5)) || ((i == g.Xposition + 6) && ((j/100) == g.Yposition +6)) || ((i == g.Xposition + 7) && ((j/100) == g.Yposition +7)) || ((i == g.Xposition + 8) && ((j/100) == g.Yposition +8)) || ((i == g.Xposition - 1) && ((j/100) == g.Yposition - 1)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition - 2)) || ((i == g.Xposition - 3) && ((j/100) == g.Yposition - 3)) || ((i == g.Xposition -4) && ((j/100) == g.Yposition - 4)) || ((i == g.Xposition - 5) && ((j/100) == g.Yposition - 5)) || ((i == g.Xposition - 6) && ((j/100) == g.Yposition - 6)) || ((i == g.Xposition - 7) && ((j/100) == g.Yposition - 7)) || ((i == g.Xposition - 8) && ((j/100) == g.Yposition - 8)) || ((i == g.Xposition + 1) && ((j/100) == g.Yposition -1)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition - 2)) || ((i == g.Xposition + 3) && ((j/100) == g.Yposition - 3)) || ((i == g.Xposition + 4) && ((j/100) == g.Yposition - 4)) || ((i == g.Xposition + 5) && ((j/100) == g.Yposition - 5)) || ((i == g.Xposition + 6) && ((j/100) == g.Yposition -6)) || ((i == g.Xposition +7) && ((j/100) == g.Yposition -7)) || ((i == g.Xposition + 8) && ((j/100) == g.Yposition - 8)) || ((i == g.Xposition - 1) && ((j/100) == g.Yposition +1)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition + 2)) || ((i == g.Xposition - 3) && ((j/100) == g.Yposition + 3)) || ((i == g.Xposition - 4) && ((j/100) == g.Yposition + 4)) || ((i == g.Xposition - 5) && ((j/100) == g.Yposition + 5)) || ((i == g.Xposition - 6) && ((j/100) == g.Yposition + 6)) || ((i == g.Xposition - 7) && ((j/100) == g.Yposition +7)) || ((i == g.Xposition - 8) && ((j/100) == g.Yposition +8))|| ((i == g.Xposition + 1) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 3) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 4) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 5) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 6) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 7) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 8) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 1) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 3) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 4) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 5) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 6) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 7) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 8) && ((j/100) == g.Yposition)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 1)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 2)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 3)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 4)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 5)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 6)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 7)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 8)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 1)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 2)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 3)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 4)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 5)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 6)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 7)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 8))) {

                      var = false;
                      for (int k = 0, v = 0; k < e.size() && v < a.size(); k++, v++) {
                          if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))) && !e.get(k).isDead)  {
                             var = true;
                             break;
                          }

                          for (int l = (j/100); l < g.Yposition; l++) {



                                for (int n = l; n < g.Yposition; n++) {
                                    if ((((i == e.get(k).Xposition) && (n == e.get(k).Yposition)))  && !e.get(k).isDead)  {

                                         var = true;
                                         break;

                                      }


                                }


                          }

                          //down code
                          for (int l = (j/100); l > g.Yposition; l--) {



                                for (int n = l; n > g.Yposition; n--) {
                                    if ((((i == e.get(k).Xposition) && (n == e.get(k).Yposition)))  && !e.get(k).isDead)  {

                                         var = true;
                                         break;

                                      }
                                }


                          }

                          //left code
                          for (int l = i; l < g.Xposition; l++) {



                                for (int n = l; n < g.Xposition; n++) {
                                    if ((((n == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition)))  && !e.get(k).isDead)  {

                                         var = true;
                                         break;

                                      }
                                }


                          }

                          //right code
                          for (int l = i; l > g.Xposition; l--) {



                                for (int n = l; n > g.Xposition; n--) {
                                    if ((((n == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition)))  && !e.get(k).isDead)  {

                                         var = true;
                                         break;

                                      }
                                }


                          }

                          for (int l = (j/100), m = i; l < g.Yposition && m < g.Xposition; l++, m++) {

                                for (int n = l, r = m; n < g.Yposition && r < g.Xposition; n++, r++) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l > g.Yposition && m > g.Xposition; l--, m--) {

                                for (int n = l, r = m; n > g.Yposition && r > g.Xposition; n--, r--) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l < g.Yposition && m > g.Xposition; l++, m--) {

                                for (int n = l, r = m; n < g.Yposition && r > g.Xposition; n++, r--) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }


                          for (int l = (j/100), m = i; l > g.Yposition && m < g.Xposition; l--, m++) {

                                for (int n = l, r = m; n > g.Yposition && r < g.Xposition; n--, r++) {

                                        if ((((r == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                            var = true;
                                            break;

                                        }


                                }


                          }

                          for (int l = (j/100), m = i; l < g.Yposition && m < g.Xposition; l++, m++) {

                                for (int n = l, r = m; n < g.Yposition && r < g.Xposition; n++, r++) {

                                        if ((((r == a.get(v).Xposition -1) && (n == a.get(v).Yposition -1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l > g.Yposition && m > g.Xposition; l--, m--) {

                                for (int n = l, r = m; n > g.Yposition && r > g.Xposition; n--, r--) {

                                        if ((((r == a.get(v).Xposition+1) && (n == a.get(v).Yposition+1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l < g.Yposition && m > g.Xposition; l++, m--) {

                                for (int n = l, r = m; n < g.Yposition && r > g.Xposition; n++, r--) {

                                        if ((((r == a.get(v).Xposition+1) && (n == a.get(v).Yposition-1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }

                          for (int l = (j/100), m = i; l > g.Yposition && m < g.Xposition; l--, m++) {

                                for (int n = l, r = m; n > g.Yposition && r < g.Xposition; n--, r++) {

                                        if ((((r == a.get(v).Xposition-1) && (n == a.get(v).Yposition+1))))  {

                                            var = true;
                                            break;

                                        }

                                }


                          }




                      }



                      if (var == true) {
                          continue;
                      }
                      else {
                          g.pPx.add(i);
                          g.pPy.add((j/100));
                      }
                  }



                  }
              }

    }
}
//class for the rook and its decision of movements
class rook extends piece {

    public void checkMoves(rook g, player p, ArrayList<piece> e, ArrayList<piece> q) {

        ArrayList<Integer> emptyX = new ArrayList<Integer>();
        ArrayList<Integer> emptyY = new ArrayList<Integer>();

        boolean var = false;
        g.pPx = emptyX;
        g.pPy = emptyY;


        for (int i = 0; i < 8; i++) {

              for (int j = 0; j < 800; j+=100) {

                  if (((i == g.Xposition + 1) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 2) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 3) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 4) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 5) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 6) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 7) && ((j/100) == g.Yposition)) || ((i == g.Xposition + 8) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 1) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 2) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 3) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 4) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 5) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 6) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 7) && ((j/100) == g.Yposition)) || ((i == g.Xposition - 8) && ((j/100) == g.Yposition)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 1)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 2)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 3)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 4)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 5)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 6)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 7)) || ((i == g.Xposition) && ((j/100) == g.Yposition + 8)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 1)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 2)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 3)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 4)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 5)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 6)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 7)) || ((i == g.Xposition) && ((j/100) == g.Yposition - 8))) {

                      var = false;

                      for (int k = 0, v =0; k < e.size() && v < q.size(); k++, v++) {
                          for (int b = 0; b < q.size(); b++) {

                          if ((((i == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))) && !e.get(k).isDead)  {
                             var = true;
                             break;
                          }

                          //up code


                          for (int l = (j/100); l < g.Yposition; l++) {



                                for (int n = l; n < g.Yposition; n++) {
                                    if ((((i == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                         var = true;
                                         break;

                                      }


                                }


                          }

                          //down code
                          for (int l = (j/100); l > g.Yposition; l--) {



                                for (int n = l; n > g.Yposition; n--) {
                                    if ((((i == e.get(k).Xposition) && (n == e.get(k).Yposition))))  {

                                         var = true;
                                         break;

                                      }
                                }


                          }

                          //left code
                          for (int l = i; l < g.Xposition; l++) {



                                for (int n = l; n < g.Xposition; n++) {
                                    if ((((n == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))))  {

                                         var = true;
                                         break;

                                      }
                                }


                          }

                          //right code
                          for (int l = i; l > g.Xposition; l--) {



                                for (int n = l; n > g.Xposition; n--) {
                                    if ((((n == e.get(k).Xposition) && ((j/100) == e.get(k).Yposition))))  {

                                         var = true;
                                         break;

                                      }
                                }


                          }

                          for (int l = (j/100); l < g.Yposition; l++) {

                                for (int n = l; n < g.Yposition; n++) {
                                    if ((((i == q.get(v).Xposition) && (n == q.get(v).Yposition-1))))  {

                                         var = true;
                                         break;

                                      }


                                }


                          }

                          for (int l = (j/100); l > g.Yposition; l--) {



                                for (int n = l; n > g.Yposition; n--) {
                                    if ((((i == q.get(v).Xposition) && (n == q.get(v).Yposition+1))))  {

                                         var = true;
                                         break;

                                      }
                                }


                          }

                          for (int l = i; l < g.Xposition; l++) {



                                for (int n = l; n < g.Xposition; n++) {
                                    if ((((n == q.get(v).Xposition-1) && ((j/100) == q.get(v).Yposition))))  {

                                         var = true;
                                         break;

                                      }
                                }


                          }


                          for (int l = i; l > g.Xposition; l--) {



                                for (int n = l; n > g.Xposition; n--) {
                                    if ((((n == q.get(v).Xposition+1) && ((j/100) == q.get(v).Yposition))))  {

                                         var = true;
                                         break;

                                      }
                                }


                          }





                          }


                      }

                      if (var == true) {
                          continue;
                      }
                      else {
                          g.pPx.add(i);
                          g.pPy.add((j/100));
                      }
                  }



                  }
              }

    }

}

class AiPlayer extends player {

    public int movePiece() {
      int position = findBestMove
      return position;
    }

    public int findBestMove(ArrayList<piece> whitePiecesList, ArrayList<piece> blackPiecesList, board) {

      int bestVal;
      Boolean isMaximizeplayer;

      for (int i = 0; i < blackPiecesList.size(); i++) {

          for (int j = 0; j < blackPiecesList.get(i).pPx.size(); j++) {

              bestVal = miniMax(blackPiecesList.get(i), 0, !isMaximizeplayer);
          }

      }

    }

public int miniMax(current piece, all the white pieces, all the black pieces, isMaximizePlayer) {

  int bestVal;
  int reward = 0;

  if (!isMaximizingPlayer) {

      make the supposed move

      create a rewards system, so if pawn 5 points, if knight or bishop 10 poits, if rook 15 points, queen 500 points, king 2000 points
      check the rewards see if the move gives any of the values

      for each piece white can possibly move with the new board {

              cycle through every position {

                  bestVal = miniMax(position, depth, isMaximizeplayer);
                }

      }


}

else {

    make the supposed move

    create a rewards system, so if pawn -5 points, if knight or bishop -10 poits, if rook -15 points, queen -500 points, king -2000 points
    check the rewards see if the move gives any of the values

    for each piece black can possibly move {

        cycle through every position {

            bestVal = miniMax(position, depth, !isMaximizeplayer);
          }

        }


}

}

}
