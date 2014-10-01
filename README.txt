Hill Climbing ReadMe

This program is used to solve the N-Queens problem. There are lots of resources on the internet to find out what the N-Queens problem is, but here's a quick overview.

On a chess board of arbitrary (N x N) size, how can we arrange N queens on the board such that no queen on the board can attack any other queen on the board?

This program solves that problem using a Hill Climbing algorithm. What that means is that the algorithm starts with a random solution (but NOT a correct solution) and makes improvements to the solution iteratively.
The running time of this algorithm is fairly low in most cases, but with a huge board size the time can increase.

This program takes a board size as input. It will start with a randomly generated board of queens and go from there to find a correct solution. 
Please see below for compiling and running instructions.


Compiling instructions:

To compile these files, place them in a directory. Navigate to the level above the folder hillClimbing containing the .java files
and type "javac hillClimbing/*.java".

Running Instructions:

To run the Hill Climbing Agent, type:

java hillClimbing/testHarness boardsize, replacing boardsize with an actual integer board size of your choosing.

Sample: "java hillClimbing/testHarness 5"
