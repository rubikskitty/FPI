
class player extends gameBox {

    String name; //Tracks player's name
    boolean playing = false; // Tracks if the player is playing
    String symbol; // Tracks the current player's symbol x or o

    public static String printStatus(player currentPlayer) {
        return currentPlayer.name + " is currently playing!";
    }
    //Prints out if the player is playing currently

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
