/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author centremetre
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String stored = "Payday 2";
        String input = "padyay 2";
        
        boolean isSimilar = SimilarityChecker.compareStrings(input,
                stored, 62);
        
        System.out.println(isSimilar);
        
        if (isSimilar)
        {
            System.out.println("You inputted " + input +
                    " did you mean " + stored);
        }
        
    }
    
}
