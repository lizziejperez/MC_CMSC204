# JUnit Lab
You will be creating a JUnit Test Class for Gradebook.java, that has been provided for you.

Add the following two methods to the Gradebook class. Do not modify the other methods of Gradebook.
1. Add a getScoreSize() method to the Gradebook class which returns scoresSize;
2. Add a toString() method to the Gradebook class that returns a string with each score in scores separated by a space.

Create the Test Class GradebookTester.
1. Select the setUp and tearDown method.
2. Select all of the methods of Gradebook, except for the constructor to create tests for.
3. In the setUp method of GradebookTester, create at least two objects of Gradebook of size 5.  Call the addScore method for each of the Gradebook classes at least twice (but no more than 5 times).
4. In the teardown method of GradebookTester, set the two objects of Gradebook to null;
5. Create test for the methods of Gradebook:
   * addScore - Use the toString method to compare the contents of what is in the scores array vs. what is expected to be in the scores array. Compare the scoreSize to the expected number of scores entered.
   * sum -	Compare what is returned by sum() to the expected sum of the scores entered.
   * minimum - Compare what is returned by minimum() to the expected minimum of the scores entered.
   * finalScore - Compare what is returned by finalScore() to the expected finalscore of the scores entered. The finalScore is the sum of the scores, with the lowest score dropped if there are at least two scores, or 0 if there are no scores.
