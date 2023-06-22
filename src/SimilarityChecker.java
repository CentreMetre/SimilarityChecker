
import java.util.ArrayList;

/**
 * Compares to strings to see if they're similar.
 * The comparison is as percentage.
 * It compares each char in the strings
 * and if they are the same the score rises.
 * @version 2.0
 * @since 0.1
 * @author CentreMetre
 */
public class SimilarityChecker {
    
    /**
     * The default minimum score.
     */
    private final static int MIN_SCORE_DEFAULT = 85;
    
    /**
     * How similar the two strings are as a percentage.
     */
    private static double similarityScore = 0;
    
    /**
     * Default of 85%
     */
    private static double minScore = 85;
    
    /**
     * Stores if the user wants to check for strict capitalisation
     */
    private static boolean doCheckStrictCapitalisation = false;
    
    /**
     * Stores if the user wants to check adjacent characters
     */
    private static boolean doCheckAdjacentCharacters = false;
    
    /**
     * The string that is inputted.
     * and to be compared against the already stored string
     */
    private static String inputString = null;
    
    /**
     * The string that already existed and is being compared against
     */
    private static String storedString = null;
    
    /**
     * The string array list of inputString
     */
    static ArrayList<Character> inputStringArray = new ArrayList<Character>();
    
    /**
     * The string array list of storedString
     */
    static ArrayList<Character> storedStringArray = new ArrayList<Character>();
    
    /**
     * Holds the value that each character is worth as a percentage.
     */
    private static double charPercentage = 0;
    
    /**
     * The main method to check two strings. What will be called by a dev.
     * @param input The string inputted by the user
     * @param first The string you want to check the input against
     * @param minScoreVarArgs The minimum similarity to return true.
     * Optional: the default minimum score is 85%.
     * Uses varargs for optional input functionality,
     * will use index 0 of the array.
     * @return True if the score is higher than or equal to the minimum score.
     */
    static boolean compareStirngs(String input,
            String first,
            boolean checkForStrictCapitalisation,
            boolean checkForAdjacentCharacters,
            double... minScoreVarArgs)
    {
        resetVariables();
        
        /*
        Shouldn't be needed since there should be a check to see if
        two strings are equal, but here just in case.
        */
        if (input.equals(first))
        {
            return true;
        }
        
        doCheckStrictCapitalisation = checkForStrictCapitalisation;
        doCheckAdjacentCharacters = checkForAdjacentCharacters;
        
        /*
        Checks if there is a custom min score needed to trigger a similarity.
        */
        if (minScoreVarArgs.length > 0)
        {
            minScore = minScoreVarArgs[0];
        }
        
        storedString = first;
        inputString = input;
        
        setCharPercentage();
        
        if (doCheckStrictCapitalisation)
        {
            
        }
        
        compareStringArrays();
        
        //debug
        System.out.println(similarityScore);
        
        if (similarityScore < minScore)
        {
            return false;
        }
        if (similarityScore >= minScore)
        {
            return true;
        }
        
        /*
        If there is some error checking similarity
        (I can't see there being any errors, but i havnt tested this yet...)
        it will print this and return false.
        */
        StackTraceElement frame = new Exception().getStackTrace()[0];
        String fileName = frame.getFileName();
        
        System.err.println("Error occured in " + frame.getFileName() +
                "at method " + frame.getMethodName() +
                ". Error checking similarity. Returning false.");
        
        return false;
        
    }
    
    /**
     * Rests similarityScore and minScore so the class can be used again.
     */
    private static void resetVariables()
    {
        similarityScore = 0;
        minScore = MIN_SCORE_DEFAULT;
                
        inputString = null;
        storedString = null;
        
        inputStringArray.clear();
        storedStringArray.clear();
        
        doCheckStrictCapitalisation = false;
        doCheckAdjacentCharacters = false;
    }
    
    private static void decapitaliseWords()
    {
            
    }
    
    /**
     * Compares the strings, adding charPercentage to similartyScore
     */
    private static void compareStringArrays()
    {   
        /*
        If the inputted string is shorter than the length of the already
        stored one there doesnt need to be a check for that becuase score
        is added for each same character.
        
        If the inputted string is longer than the length of the already
        stored one there doesnt need to be a check for that becuase score
        is added for the same of each character, but there does need to be
        a try catch becouse of out of bounds exception.
        
        And each character that isnt there means less score for similarity.
        */
        for (int i = 0; i < inputString.length(); i++)
        {
            try
            {
                //add check for individiual words aswell
                if (inputChars[i] == storedChars[i])
                {
                    similarityScore = similarityScore + charPercentage;
                }
                else if (doCheckAdjacentCharacters)
                {
                    //if ()
                }
                
            }
            catch (Exception e)
            {
                System.out.println(e);
                return;
            }
        }
    }
    
    private static boolean checkAdjacentCharacters()
    {
        
    }
    
    /**
     * Sets the value that each character is worth as a percentage.
     * Example: a 4 letter string would have a char percentage of 25,
     * since 100 / 4 = 25.
     * @param input 
     */
    private static void setCharPercentage()
    {
        //double cast is needed so there is no loss in decimals
        charPercentage = (double) 100.0/inputString.length();
    }
}
