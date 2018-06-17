# Longest-increasing-subsequence
Computes and print longest increasing sub sequence using dynamic programming

#Question description:

Task: Longest increasing subsequence
Given a list of N integers find the longest increasing subsequence in this list.

Example

If the list is [16, 3, 5, 19, 10, 14, 12, 0, 15] one possible answer is the 
subsequence [3, 5, 10, 12, 15], another is [3, 5, 10, 14, 15].

If the list has only one integer, for example: [14], the correct answer is [14].

One more example: [10, 8, 6, 4, 2, 0], a possible correct answer is [8].

# Solution:

1. A list is received as parameter in the function.

2. Create two lists name them maxSequence and newSequence. maxSequence will hold the longest increasing subsequence.

3. Loop through the list initializing the loop from 1 to end of list.

4. Check if maxSequence.size() is greater than i value of loop then break that means longest increasing subsequence has been calculated.

5. Otherwise initialize a new integer call it lastVal and initialize newSequence list.

6. Start the nested loop from 0 to i.

7. In nested loop check if the value at j is less than value at i and value at j is greater than lastVal then that means we can include this value in maxSequence
if (sequence.get(j) < sequence.get(i) && sequence.get(j) > lastVal)

8. Update lastVal by initializing it with j value in sequence. And add j value in sequence to newSequence.

9. Once we come out of the nested loop it is checked if the length of newSequence is greater than length of maxSequence then maxSequence is updated.

10. At the end return maxSequence.
