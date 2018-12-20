//observe the chess.java and implement it with minimax for the Ai choice decisions
//put the code for minimax in this file
//this assumes that ai is black
// so far not written in code


public int movePiece() {
  int position = findBestMove
  return position;
}

public int findBestMove(ArrayList<piece> whitePiecesList, ArrayList<piece> blackPiecesList, board) {

    int bestVal;
    Boolean isMaximizeplayer;

    for (int i =0; i < blackPiecesList.size(); i++)

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


              class ai extends player {

    String huPlayer = "X";
    String aiPlayer = "O";
    //Two strings to represent the human palyer and one to represent the ai player

    public int move(ArrayList board) {
        int number = findbestMove(board);
        return number;
    }
    //Method to move the ai returns the move

    public Boolean winning(ArrayList board, String currentPlayer){
        if ((board.get(3).toString().equals(currentPlayer) && board.get(4).toString().equals(currentPlayer) && board.get(5).toString().equals(currentPlayer)) ||
                (board.get(0).toString().equals(currentPlayer) && board.get(1).toString().equals(currentPlayer) && board.get(2).toString().equals(currentPlayer)) ||
                (board.get(6).toString().equals(currentPlayer) && board.get(7).toString().equals(currentPlayer) && board.get(8).toString().equals(currentPlayer)) ||
                (board.get(0).toString().equals(currentPlayer) && board.get(3).toString().equals(currentPlayer) && board.get(6).toString().equals(currentPlayer)) ||
                (board.get(1).toString().equals(currentPlayer) && board.get(4).toString().equals(currentPlayer) && board.get(7).toString().equals(currentPlayer)) ||
                (board.get(2).toString().equals(currentPlayer) && board.get(5).toString().equals(currentPlayer) && board.get(8).toString().equals(currentPlayer)) ||
                (board.get(0).toString().equals(currentPlayer) && board.get(4).toString().equals(currentPlayer) && board.get(8).toString().equals(currentPlayer)) ||
                (board.get(2).toString().equals(currentPlayer) && board.get(4).toString().equals(currentPlayer) && board.get(6).toString().equals(currentPlayer))) {
            return true;
        }
        else {
            return false;
        }
    }
    //Checks if one player is winning the game, returns true if yes, else false

    public int findbestMove(ArrayList board) {

        int bestVal = 0; //The score of the best move
        int bestMove = 0; //The location of the bestMove

        for (int i = 0; i<=8; i++)
        {
            if (board.get(i).equals("empty"))
            {

                board.set(i, aiPlayer); //Make the move for the ai player

                int moveVal = miniMax(board, 0, false);
                //Call the minimax function to determine the best move

                board.set(i, "empty"); //Take back the ai player's move

                if (moveVal > bestVal) {
                    bestMove = i;
                    bestVal = moveVal;
                }
                //if the move being examined is a better value than the best move set it equal to the best move
            }
            //if the board space is empty determine the best move for that space
        }

        return bestMove;

    }


    public static boolean isMovesLeft(ArrayList board)
    {
        for (int i = 0; i<board.size(); i++) {
            if (board.get(i).toString().equals("empty")) {
                return true;
            }
            //Checks the board to see if there are any more moves that can be made on the board

        }
        return false;

    }

    public int miniMax(ArrayList board, int depth, boolean isMaximizingPlayer) {

        int bestVal;


        if (winning(board, aiPlayer)) {
            return 10;
        }
        //If the ai is winning return 10
        else if(winning(board, huPlayer)) {
            return -10 ;
        }
        //If the human is winning return -10
        if (!isMovesLeft(board)) {
            return 5;
        }
        //If the game is a tie return 5

        if (isMaximizingPlayer) {
            bestVal = -1000;

            for (int i = 0; i < board.size(); i++) {

                if  (board.get(i).toString().equals("empty")) {
                    board.set(i, aiPlayer);
                    //Makes an ai move for each empty space on the board
                    bestVal = Math.max(bestVal,  miniMax(board, depth + 1, !isMaximizingPlayer));
                    // Best value for the better move by calling minimax again
                    board.set(i, "empty");
                    //Reset the board
                }

            }
            return bestVal;
        }
        else {
            bestVal = 1000;

            for (int i = 0; i < board.size(); i++) {

                if  (board.get(i).toString().equals("empty")) {
                    board.set(i, huPlayer);
                    //Makes the human move ffro each empty space on the board

                    bestVal = Math.min(bestVal,  miniMax(board, depth + 1, !isMaximizingPlayer));
                    //Finds the most likely move depending on the human players moves by calling minimax

                    board.set(i, "empty");
                    //Reset board
                }

            }

            return bestVal;
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
