class ai extends checkers {

    public int move(piece[][] board) {
	int number = findbestMove(board);
	return number;
    }
    //Method to move the ai returns the move

    public boolean winning(piece[][] board, player p, piece[] redArray, piece[] blackArray){

        int redCount = 0;

        if (player == Ai) {

          for (int i = 0; i < redArray.size(); i++) {
            if (redArray.alive == true) {
              redCount++;
            }

          }

          if (redCount == 0) {
            return true;
          }
          else {
            return false;
          }

        }

        if (player == huPlayer) {

          for (int i = 0; i < blackArray.size(); i++) {
            if (blackArray.alive == true) {
              blackCount++;
            }

          }

          if (blackCount == 0) {
            return true;
          }
          else {
            return false;
          }

        }




    }
    //Checks if one player is winning the game, returns true if yes, else false

    public int findbestMove(piece[][] board) {

	int bestVal = 0; //The score of the best move
	int bestMove = 0; //The location of the bestMove

	for (int i = 0; i < blackP.size(); i++)
	{
    for (int j = 0; j < blackP[i].movesPossible.get(0).size(); j++) {

		//Make the move for the ai player
    board[blackP[i].movesPossible.get(0).get(j)][blackP[i].movesPossible.get(1).get(j)] = blackP[i];
    board[blackP[i].xPos][blackP[i].yPos] = null;

		int moveVal = miniMax(board, 0, false);
		//Call the minimax function to determine the best move

		board[blackP[i].xPos][blackP[i].yPos] = blackP[i];
    board[blackP[i].movesPossible.get(0).get(j)][blackP[i].movesPossible.get(1).get(j)] = null;


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

    public int miniMax(piece[][] board, int depth, boolean isMaximizingPlayer) {

	int bestVal;


	if (winning(board, ai, redP, blackP)) {
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
