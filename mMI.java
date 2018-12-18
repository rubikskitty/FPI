//observe the chess.java and implement it with minimax for the Ai choice decisions
//put the code for minimax in this file
//this assumes that ai is black

public int findBestMove(int ai.currentPositionX, int ai.currentPositionY, all the white pieces, all the black pieces) {

    int bestVal;
    Boolean isMaximizeplayer;

    for each piece black can possibly move {
    
	cycle through every position {
	
	    bestVal = miniMax(position, depth, !isMaximizeplayer);
	}
	
    }


}

public int miniMax(int ai.currentPositionX, int ai.currentPositionY, all the white pieces, all the black pieces, isMaximizePlayer) {

    int bestVal;
    int tempBoard
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
