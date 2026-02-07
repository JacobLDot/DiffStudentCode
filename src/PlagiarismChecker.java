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
    public static int longestSharedSubstring(String doc1, String doc2) {

        // Memoization table
        int[][] seqLen = new int[doc1.length()][doc2.length()];

        // Recursive calls to find the longest shared substring
        return longestSharedSubstringHelper(doc1, doc2, seqLen, 0, 0);
    }

    public static int longestSharedSubstringHelper(String doc1, String doc2, int[][] seqLen, int doc1_index, int doc2_index) {

        // Base case
        // End of string / Memoization
        if (doc1_index == doc1.length()) { return 0; }
        if (doc2_index == doc2.length()) { return 0; }
        if (seqLen[doc1_index][doc2_index] == 0) { return seqLen[doc1_index][doc2_index]; }

        int maxLen;
        if (doc1.charAt(doc1_index) == doc2.charAt(doc2_index)) {
            maxLen = 1 + longestSharedSubstringHelper(doc1, doc2, seqLen, doc1_index + 1, doc2_index + 1);
        } else {
            // ?
        }

        seqLen[doc1_index][doc2_index] = maxLen;
        return maxLen;
    }
}
