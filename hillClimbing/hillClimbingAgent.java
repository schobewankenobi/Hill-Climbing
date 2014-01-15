package hillClimbing;
import java.util.*;

public class hillClimbingAgent {

	
	/**
	 * By Jeff Schobelock
	 * Agent that takes a board size and returns a representation of a possible solution
	 */
	public static int[] agent(int boardsize) {
		int[] state = new int[boardsize];
		int stateIterator = 0;
		int icounter = 0;
		
		//Populate the board randomly
		while (stateIterator < boardsize)
		{
			Random randInt = new Random();
			int rand = randInt.nextInt(boardsize);
			state[stateIterator] = rand;
			stateIterator++;
		}
		
		//Loop until solution found (or stuck)
		while (true)
		{
			//Increase iteration counter
			icounter++;
			
			//Find successors
			ArrayList<int[]> successors = successors(state);
			
			//Find best successor
			int[]successor = findMin(successors);
			
			//Print iteration and best child score
			System.out.println("Iteration " + icounter + ": Current State: " + Arrays.toString(state) + " Best Child Score: " + boardScore(successor));
			
			
			if (boardScore(state) <= boardScore(successor))
			{
				return state;
			}
			
			
			//Replace current state with successor state
			int x = 0;
			while(x < boardsize)
			{
				state[x] = successor[x];
				x++;
			}
			
			
		}	
	
	}

	
	
	//Function to find successors
	public static ArrayList<int[]> successors (int[] state){
		
		ArrayList<int[]> successors = new ArrayList<int[]>();
		
		//Size of board
		int boardSize = state.length;
		
		//Iterator for board
		int i = 0;
		
		//Iterator for positions for each piece
		int p = 0;
		
		//Go through board, move one piece at a time and save as successor
		while(i < boardSize)
		{
			while (p < boardSize)
			{
				
				//Create new state for successor
				int[] successorState = new int[boardSize];
				
				//Populate successor state with current state's values
				int x = 0;
				while (x < state.length)
				{
					successorState[x] = state[x];
					x++;
				}
				
				
				//Want to make sure we only make moves that aren't already there
				if (state[i] != p)
				{
					successorState[i] = p;
					successors.add(successorState);
				}
				
				p++;
				
			}
			
			p = 0;
			i++;
		}
		
		return successors;
	}
	
	//Function to score the board
	public static int boardScore (int[] state){
		int score = 0;
		int stateIterator = 0;
		int stateIterator2 = 0;
		
		//Iterate through state vector to check positions and score
		while (stateIterator < (state.length - 1))
		{
			
			stateIterator2 = stateIterator;
			while (stateIterator2 < state.length) //Second loop
			{
				if (stateIterator != stateIterator2) //Not the same pieces
				{
					//Queens are diagonal to each other
					if (Math.abs(state[stateIterator] - state[stateIterator2]) == Math.abs(stateIterator - stateIterator2))
					{
						score = score + 1;
					}
				
					//Queens are in same row
					else if ((state[stateIterator] == state[stateIterator2]))
					{
						score = score + 1;
					}
					
				}
				
				stateIterator2++;
			}
				
			stateIterator++;
		}
		
		return score;
	}
	
	//Function to find min of successors
	public static int[] findMin (ArrayList<int[]> successors)
	{
		
		int i = 0;
		
		//Set max score to score of first successor
		int min = boardScore(successors.get(0));
		
		//Best successor
		int bestSuccessorScore = 0;
		
		//Iterate through successors, find lowest score
		while (i < successors.size())
		{
			int successorScore = boardScore(successors.get(i));
			
			if (successorScore < min)
			{
				min = successorScore;
				bestSuccessorScore = i;
			}
			
			i++;
		}
		
		//Copy best scoring successor into new state to return
		int minLength = successors.get(bestSuccessorScore).length;
		int[] bestSuccessor = new int[minLength];
		
		int x = 0;
		while (x < minLength)
		{
			bestSuccessor[x] = successors.get(bestSuccessorScore)[x];
			x++;
		}
		
		return bestSuccessor;
	}
}
