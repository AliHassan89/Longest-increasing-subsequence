/*

Task: Longest increasing subsequence
Given a list of N integers find the longest increasing subsequence in this list.

Example

If the list is [16, 3, 5, 19, 10, 14, 12, 0, 15] one possible answer is the 
subsequence [3, 5, 10, 12, 15], another is [3, 5, 10, 14, 15].

If the list has only one integer, for example: [14], the correct answer is [14].

One more example: [10, 8, 6, 4, 2, 0], a possible correct answer is [8].

Test cases

Your solution will be graded against a number of test cases. All test cases 
contain at least one integer. Half of them will have no more than 1,000 integers 
in the input sequence. The other half will contain sequences with up to 10,000 
integers.

You can design a solution, which works fast enough for N <= 1,000 but is slow 
for bigger inputs. Try and see how good of a solution you can create. Of course, 
aim to get the maximum possible points!

 */
package longestincreasingsubsequence;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Ali
 */
public class LongestIncreasingSubsequence 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        List<Integer> list = new ArrayList<>();
        
        //Test case 1
        //16, 3, 5, 19, 10, 14, 12, 0, 15
//        list.add(16);
//        list.add(3);
//        list.add(5);
//        list.add(19);
//        list.add(10);
//        list.add(14);
//        list.add(12);
//        list.add(0);
//        list.add(15);
        
        //Test case 2
        // 3, 4, -1, 0, 6, 2, 3
        list.add(3);
        list.add(4);
        list.add(-1);
        list.add(0);
        list.add(6);
        list.add(2);
        list.add(3);
        
        list = longest_increasing_subsequence(list);
        
        for (int i : list)
        {
            System.out.print(i+", ");
        }
    }
    
    public static List<Integer> longest_increasing_subsequence(List<Integer> sequence) 
    {
        if (sequence.size() <= 1)
            return sequence;
        
        int lastVal;
        ArrayList<Integer> maxSequence = new ArrayList<>();
        ArrayList<Integer> newSequence;
        
        for (int i=1; i<sequence.size(); i++)
        {
            if (maxSequence.size() > i)
                break;
            lastVal = Integer.MIN_VALUE;
            newSequence = new ArrayList<>();
            for (int j=0; j<i; j++)
            {
                if (sequence.get(j) < sequence.get(i) && sequence.get(j) > lastVal)
                {
                    lastVal = sequence.get(j);
                    newSequence.add(lastVal);
                }
            }
            newSequence.add(sequence.get(i));
            maxSequence = newSequence.size() > maxSequence.size() ? newSequence : maxSequence;
        }
        
        return maxSequence;
    }
    
    /*
        computes length of longest increasing subsequence using dynamic programming.
    */
    public int lengthOfLongestIncreasingSubsequence(List<Integer> sequence) {
        
        int n = sequence.size();
        int memo[] = new int[n]; 
        int i,j,max = 0; 
    
        /* Initialize memo values for all indexes */
        Arrays.fill(memo, 1);
        
        /* Compute optimized memo values in bottom up manner */
        for ( i = 1; i < n; i++ ) 
          for ( j = 0; j < i; j++ )  
            if ( sequence.get(i) > sequence.get(j) && memo[i] < memo[j] + 1) 
                memo[i] = memo[j] + 1; 
    
           /* Pick maximum of all LIS values */
           for ( i = 0; i < n; i++ ) 
              if ( max < memo[i] ) 
                 max = memo[i]; 
    
            return max; 
    }
}
