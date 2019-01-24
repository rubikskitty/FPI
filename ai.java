class ai extends player {

  String aiString = "ai";
  String huString = "hu";

  public static int checkPieces(piece[] pieceArray) {

    int count = 0;

    for (int i =0; i < pieceArray.length; i++) {

      if (pieceArray[i].alive == true) {

        count++;

      }

    }

    return count;

  }

  public Boolean winning(String currentPlayer, piece[] redArray, piece[] blackArray){

    int redCount = 0;
    int blackCount = 0;
    for (int i = 0; i < redArray.length-1; i++ ) {

      if (redArray[i].alive == true) {
        redCount++;
      }
      if (blackArray[i].alive == true) {
        blackCount++;
      }

    }

    if (blackCount == 0 && currentPlayer.equals("ai")) {
          return true;
    }
    else if (redCount == 0 && currentPlayer.equals("hu")){
          return true;
    }
    else {
      return false;
    }
  }
  //Checks if one player is winning the game, returns true if yes, else false

  public int miniMax(piece[][] board, piece[] redArray, piece[] blackArray,  player[] pArray, Boolean isMaximizingPlayer, int depth, ai rob) {

    int bestVal = 0;
    int currentVal = 0;

    if (rob.checkPieces(redArray) > rob.checkPieces(blackArray)) {
      return 10;
    }
    if (rob.checkPieces(blackArray) > rob.checkPieces(redArray)) {
      return -10;
    }
    else {
      return 0;
    }

    if (isMaximizingPlayer) {//aiplayer

      bestVal = -1000;

      for (int i = 0; i < temprArray.length-1; i++) {

        temprArray[i].movesOpen(temprArray[i], tempBoard);

        if (temprArray[i].alive) {

            if (temprArray[i].movesPossible.get(0).size() > 0) {

              for (int j = 0; j < temprArray[i].movesPossible.get(0).size()-1; i++) {

                  temprArray[i].makeMove(tempBoard, temprArray[i], true, temprArray[i].movesPossible.get(0).get(j) * 63, temprArray[i].movesPossible.get(1).get(j) * 63, pArray);

                   bestVal = Math.max(bestVal, rob.miniMax(tempBoard, temprArray, tempbArray[i], pArray, isMaximizingPlayer, depth++, rob));


              }

              return bestVal;

            }

        }

      }


    }
    else {

      bestVal = 1000;

      for (int i = 0; i < tempbArray.length-1; i++) {

        tempbArray[i].movesOpen(tempbArray[i], tempBoard);

        if (tempbArray[i].alive) {

            if (tempbArray[i].movesPossible.get(0).size() > 0) {

              for (int j = 0; j < tempbArray[i].movesPossible.get(0).size()-1; i++) {


                  tempbArray[i].makeMove(tempBoard, tempbArray[i], true, tempbArray[i].movesPossible.get(0).get(j) * 63, tempbArray[i].movesPossible.get(1).get(j) * 63, pArray);

                   bestVal = Math.max(bestVal,rob.miniMax(tempBoard, tempbArray, tempbArray[i], pArray, isMaximizingPlayer, depth++, rob));



              }

              return bestVal;

            }

        }

      }


    }


  }
  public int[] AImove(piece[][] board, piece[] redArray, piece[] blackArray, player[] pArray, ai rob) {

    piece tempBoard[][] = board;
    piece temprArray = redArray;
    piece tempbArray = blackArray;
    int bestThings[][] = new int[2];
    int bestVal = 0;
    int currentVal = 0;
    int depth = 0;

    bestThings[0] = 0;// tracks piece
    bestThings[1] = 0;//tracks the index of the best move



    for (int i = 0; i < temprArray.length-1; i++) {

      temprArray[i].movesOpen(temprArray[i], tempBoard);

      if (temprArray[i].alive) {

          if (temprArray[i].movesPossible.get(0).size() > 0) {

            for (int j = 0; j < temprArray[i].movesPossible.get(0).size()-1; i++) {

                temprArray[i].makeMove(tempBoard, temprArray[i], true, temprArray[i].movesPossible.get(0).get(j) * 63, temprArray[i].movesPossible.get(1).get(j) * 63, pArray);

                 currentVal = rob.miniMax(tempBoard, temprArray, tempbArray[i], pArray, !isMaximizingPlayer, depth++, rob);

                //return move

                if (currentVal > bestVal) {

                  bestVal = currentVal;

                  bestThings[0] = i;
                  bestThings[1] = j;

                }

            }

          }

      }

    }

    return bestThings ;

  }



}



/*


public int[] findbestMove(piece[][] board, piece[] redArray, piece[] blackArray) {

    int[] bestMove = new int[2]; //The score of the best move
    int bestVal = 0; //The location of the bestMove

    for (int i = 0; i < redArray.length-1; i++) {

      if (redArray[i].alive) {

        for (int j = 0; j < redArray[i].movesPossible.get(0).size()-1; j++)
        {

            board[redArray[i].movesPossible.get(0).get(j)][redArray[i].movesPossible.get(1).get(j)] = redArray[i]; //Make the move for the ai player
            board[redArray[i].xPos][redArray[i].yPos] = null;

            int moveVal = miniMax(board, 0, false, redArray, blackArray);
            //Call the minimax function to determine the best move

            board[redArray[i].movesPossible.get(0).get(j)][redArray[i].movesPossible.get(1).get(j)] = null; //Make the move for the ai player
            board[redArray[i].xPos][redArray[i].yPos] = redP[i];//Take back the ai player's move

            if (moveVal > bestVal) {
                bestMove[0] = j;
                bestMove[1] = j;
                bestVal = moveVal;
            }
            //if the move being examined is a better value than the best move set it equal to the best move
        }
        //if the board space is empty determine the best move for that space




      }




    }

    return bestMove;

    }

    public int miniMax(piece[][] board, int depth, boolean isMaximizingPlayer, piece[] redArray, piece[] blackArray) {

        int bestVal;


        if (winning(pAI, redArray, blackArray)) {
            return 10;
        }
        //If the ai is winning return 10
        else if(winning(pOne,redArray, blackArray)) {
            return -10 ;
        }
        //If the human is winning return -10

        if (isMaximizingPlayer) {
            bestVal = -1000;

            for (int i = 0; i < redArray.length-1; i++) {

              if (redArray[i].alive) {

                for (int j = 0; j < redArray[i].movesPossible.get(0).size()-1; j++)
                {

                    makeMove(board, redArray[i], piece[][] board, piece currentPiece, boolean selectedPiece, int xpos, int ypos, player[] pArray)

                    bestVal = Math.max(bestVal,  miniMax(board, depth + 1, !isMaximizingPlayer, redArray, blackArray));
                    //Call the minimax function to determine the best move

                    board[redArray[i].movesPossible.get(0).get(j)][redArray[i].movesPossible.get(1).get(j)] = null; //Make the move for the ai player
                    board[redArray[i].xPos][redArray[i].yPos] = redArray[i];//Take back the ai player's move


                    //if the move being examined is a better value than the best move set it equal to the best move
                }

            return bestVal;

            }

          }
        }
        else {
            bestVal = 1000;

            for (int i = 0; i < blackArray.length-1; i++) {

              if (blackArray[i].alive) {

                for (int j = 0; j < blackArray[i].movesPossible.get(0).size()-1; j++)
                {

                    board[blackArray[i].movesPossible.get(0).get(j)][blackArray[i].movesPossible.get(1).get(j)] = blackArray[i]; //Make the move for the ai player
                    board[blackArray[i].xPos][blackArray[i].yPos] = null;

                    blackArray[i].movesOpen(blackArray[i], board)

                    bestVal = Math.max(bestVal,  miniMax(board, depth + 1, !isMaximizingPlayer, redArray, blackArray));
                    //Call the minimax function to determine the best move

                    board[blackArray[i].movesPossible.get(0).get(j)][blackArray[i].movesPossible.get(1).get(j)] = null; //Make the move for the ai player
                    board[blackArray[i].xPos][blackArray[i].yPos] = blackArray[i];//Take back the ai player's move


                    //if the move being examined is a better value than the best move set it equal to the best move
                }

            }

          }


        }

        return bestVal;
    }
*/
