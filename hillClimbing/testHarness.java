package hillClimbing;
import hillClimbing.hillClimbingAgent;


public class testHarness {

	/**
	 * By Jeff Schobelock
	 * 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//Establish board size from command line argument
		int boardSize = 0;
		try 
		{
			boardSize = Integer.parseInt(args[0]);
		}
		catch (NumberFormatException e)
		{
			System.out.println("The given board size is not a number.");
		}

		//Check that board size is greater than 4
		if (boardSize < 4)
		{
			System.out.println("The board size can't be less than 4 by 4.");
			System.exit(0);
		}
		
		//Start counting time
		long startTime = System.currentTimeMillis();
		
		
		int[] state = new int[boardSize];
		
		//Call hillClimbingAgent, run while it hasn't found a solution with no attacking queens
		while (true)
		{
			state = hillClimbingAgent.agent(boardSize);
			
			//Found a solution with no attacking queens
			if(hillClimbingAgent.boardScore(state) == 0)
			{
				break;
			}
			
			System.out.println();
			System.out.println("The test harness needs to do a random restart.");
		}
		
		//Find out how long the agent took
		long endTime = System.currentTimeMillis();
		long totalTime = (endTime - startTime);
		double totalSeconds = totalTime / 1000.0;
		
		
		//Display final state
		int i = 0;
		while (i < state.length)
		{
			System.out.println();
			System.out.println ("Queen " + (i + 1) + ": Row " + (state[i] + 1) + " Column " + (i + 1));
			i++;
		}
		//Display time agent took
		System.out.println();
		System.out.println("The hill-climbing agent took " + totalSeconds + " seconds to find a solution for this size.");
	}

}
