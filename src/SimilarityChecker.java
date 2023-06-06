/**
 * Compares to strings to see if they're similar.
 * The comparison is as percentage.
 * It compares each char in the strings
 * and if they are the same the score rises.
 * @version 0.1
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
    private static float similarityScore = 0;
    
    /**
     * Default of 85%
     */
    private static float minScore = 85;
    
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
     * Holds the value that each character is worth as a percentage.
     */
    private static float charPercentage = 0;
    
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
    static boolean compareStrings(String input,
            String first,
            float... minScoreVarArgs)
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
    
    private static void compareStringArrays()
    {
        char[] inputChars = inputString.toCharArray();
        char[] storedChars = storedString.toCharArray();
        
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
                if (inputChars[i] == storedChars[i])
                {
                    similarityScore = similarityScore + charPercentage;
                }
            }
            catch (Exception e)
            {
                System.out.println(e);
                return;
            }
        }
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
    }
    
    /**
     * Sets the value that each character is worth as a percentage.
     * Example: a 4 letter string would have a char percentage of 25,
     * since 100 / 4 = 25.
     * @param input 
     */
    private static void setCharPercentage()
    {
        charPercentage = 100/inputString.length();
    }
}
