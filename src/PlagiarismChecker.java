/**
 * Plagiarism Checker
 * A tool for finding the longest shared substring between two documents.
 *
 * @author Zach Blick
 * @author Jacob Lowe
 */
public class PlagiarismChecker {

    /**
     * This method finds the longest sequence of characters that appear in both texts in the same order,
     * although not necessarily contiguously.
     * @param doc1 the first document
     * @param doc2 the second
     * @return The length of the longest shared substring.
     */

    /**
     * Recursion With Memoization
     */
//    public static int longestSharedSubstring(String doc1, String doc2) {
//
//        // Memoization table
//        int[][] LCS = new int[doc1.length()][doc2.length()];
//
//        // Initialize each index as not computed yet
//        for (int i = 0; i < doc1.length(); i++) {
//            for (int j = 0; j < doc2.length(); j++) {
//                LCS[i][j] = -1;
//            }
//        }
//
//        // Begin recursion
//        return RecursionHelper(doc1, doc2, 0, 0, LCS);
//    }
//
//    public static int RecursionHelper(String doc1, String doc2, int i, int j, int[][] LCS) {
//
//        // Base case if at the end of string
//        if (i == doc1.length() || j == doc2.length()) {
//            return 0;
//        }
//
//        // Find previously found values using memoization
//        if (LCS[i][j] != -1) {
//            return LCS[i][j];
//        }
//
//        // Continue forward if both characters match
//        // Otherwise, take the max value from above or to the left
//        if (doc1.charAt(i) == doc2.charAt(j)) {
//            LCS[i][j] = RecursionHelper(doc1, doc2, i + 1, j + 1, LCS) + 1;
//        } else {
//            LCS[i][j] = Math.max(RecursionHelper(doc1, doc2, i + 1, j, LCS), RecursionHelper(doc1, doc2, i, j + 1, LCS));
//        }
//        return LCS[i][j];
//    }

    /**
     * Tabulation
     */
    public static int longestSharedSubstring(String doc1, String doc2) {

        // Memoization table
        int[][] LCS = new int[doc1.length() + 1][doc2.length() + 1];

        // Tabulation
        for (int i = 1; i <= doc1.length(); i++) {
            for (int j = 1; j <= doc2.length(); j++) {

                // Add from diagonal if characters match
                // If not, take the highest result from above or to the left
                if (doc1.charAt(i - 1) == doc2.charAt(j - 1)) {
                    LCS[i][j] = LCS[i - 1][j - 1] + 1;
                } else {
                    LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
                }
            }
        }

        return LCS[doc1.length()][doc2.length()];
    }
}
