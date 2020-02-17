import org.junit.After; import org.junit.Before; import org.junit.Test; import static org.junit.Assert.*; public class GradebookTester {      private GradeBook g1;    private GradeBook g2;
   @Before    public void setUp()    {        // create two objects of GradeBook of size 5        g1 = new GradeBook(5);        g2 = new GradeBook(5);
       // Call the addScore method for each of the GradeBook objects        g1.addScore(50.0);        g1.addScore(75.0);
       g2.addScore(30.0);        g2.addScore(10.0);        g2.addScore(40.0);        g2.addScore(20.0);    }
   @After    public void tearDown()    {        // set the two objects of GradeBook to null        g1 = null;        g2 = null;    }

   @Test    public void inaddScoreTest()    {        // Use the toString method to compare the contents of what is in the scores array vs. what is expected to be in the scores array        assertTrue((g1.toString()).equals("50.0 75.0 "));        assertTrue((g2.toString()).equals("30.0 10.0 40.0 20.0 "));
       // Compare the scoreSize to the expected number of scores entered.        assertEquals(2, g1.getScoreSize(), 0.001);        assertEquals(4, g2.getScoreSize(), 0.001);    }

   @Test    public void intestSum()    {        // Compare what is returned by sum() to the expected sum of the scores entered.        assertEquals(125.0, g1.sum(), 0.0001);        assertEquals(100.0, g2.sum(), 0.0001);    }

   @Test    public void intestMinimum()    {        // Compare what is returned by minimum() to the expected minimum of the scores entered.        assertEquals(50.0, g1.minimum(), 0.001);        assertEquals(10.0, g2.minimum(), 0.001);    }

   @Test    public void intestFinalScore()    {        // Compare what is returned by finalScore() to the expected finalScore of the scores entered.        assertEquals(75.0, g1.finalScore(), 0.001);        assertEquals(90.0, g2.finalScore(), 0.001);    } }
