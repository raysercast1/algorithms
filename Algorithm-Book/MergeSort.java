import java.util.Arrays;
/**
 * RUNTIME:
 * Each basic step takes constant time. If the two sorted piles that I start with each have
 * n/2 cards, then the number of basic steps is at least n/2 (since in whichever pile was emptied, every
 * card was found to be smaller than some card from the other pile) and at most n (actually, at most n-1,
 * since after n-1 basic steps, one of the piles must be empty). With each basic steps taking constant
 * time and the total number of basic steps being between n/2 and n, we can say that merging takes time
 * roughlt proportional to n. That is, merging takes O(n) time.
 * 
 * EXPLANATION:
 * In detail, the Merge procedure works as follows. It copies the two subarrays A[p:q] and A[q + 1 : r]
 * into temporary arrays L and R, and then it merges the values in L and R back into A[p:r]. Lines 18
 * and 19 compute the lenghts of nL and nR of the subarrays A[p:q] and A[q + 1 : r], respectively. 
 * Then line 22 and 23 creates subarrays leftA[0: nL -1] and rightA[0:nR -1] w/ respective lengths
 * nL and nR. The for loop of lines 26-28 copies subArray A[p:q] into L, and the for loop of lines
 * 30-32 copies subArray of A[q+1:r] into R.
 * 
 * Lines 47-60 perform the basic steps. The while loop of lines 51-60 repeatedly identifies the smallest
 * value in L and R that has yet to be copied back into A[p:r] and copies it back in. As the comments
 * indicate, the index k gives the position of A that is being filled in, and the indices i and j give
 * the positions in L and R, respectively, of the smallest remaining value. Eventually, either all of L
 * or all of R is copied back into A[p:r], and this loop terminates. If the loop terminates because all 
 * of R has been copied back, that is, because j equals nR, then i is still less than nL, so that some of
 * L has yet to be copied back, and these values are the greates in both L and R. In this case, the while
 * loop of lines 69-73 copies these remaining values of L into the last few position of A[p:r]. Because
 * j equals nR, the while loop of lines 75-79 iterates 0 times. If instead the while loop of lines 59-68
 * terminates because i equals nL, then all of L has already been copied back into A[p:r], and the while
 * loop of lines 77-81 copies the remaining values of R back into the end of A[p:r].
 */
public class MergeSort {
    public static void main(String args[]) {
        Integer[] aIntegers = {10,11,22,23,34,45,46,37,18,2,4,6,7,1,2,3,5};
        System.out.println("Array of Integer BEFORE calling Merge");
        System.out.println(Arrays.toString(aIntegers));

        merge(aIntegers, 9, 12, 16);
        System.out.println("Array of Integer AFTER calling Merge");
        System.out.println(Arrays.toString(aIntegers));
    }

    public static void merge(Integer[] A, Integer p, Integer q, Integer r) {
        //Constant Time.
        int nL = q - p + 1; //length of A[p:q].
        //Constant Time.
        int nR = r - q; //length of A[q + 1 : r].

        //Constant Time.
        Integer[] leftA = new Integer[nL];
        //Constant Time.
        Integer[] rightA =  new Integer[nR];
        
        //O(n)
        for (int i = 0; i < nL; i++) { //copy A[p:q] into L[0:nL-1].
            leftA[i] = A[p + i];
        }

        //O(n)
        for (int j = 0; j < nR; j++) { //copy A[q + 1 : r] into R[0: nR-1].
            rightA[j] = A[q + j + 1];   
        }

        //Constant Time.
        int leftIndex = 0; //indexes the smallest remaining element in L.
        //Constant Time.
        int rightIndex = 0; //indexes the smallest remaining element in R.
        //Constant Time.
        int locationToFillIndex = p; //indexes the location in A to fill.

        //As long as each of the arrays L and R contains an unmerged element, copy the smallest unmerged
        //element back into A[p:r].
        //O(n)
        while (leftIndex < nL && rightIndex < nR) {
            //Constant Time.
            if (leftA[leftIndex] <= rightA[rightIndex]) {
                //Constant Time.
                A[locationToFillIndex] = leftA[leftIndex];
                //Constant Time.
                leftIndex++;
            } else {
                //Constant Time.
                A[locationToFillIndex] = rightA[rightIndex];
                //Constant Time.
                rightIndex++;
            }
            //Constant Time.
            locationToFillIndex++;
        }

        //Having gone through one of L or R entirely, 
        //copy the remainder of the other to the end of A[p:r].
        //O(n)
        while (leftIndex < nL) {
            //Constant Time.
            A[locationToFillIndex] = leftA[leftIndex];
            //Constant Time.
            leftIndex++;
            //Constant Time.
            locationToFillIndex++;
        }
        //O(n)
        while (rightIndex < nR) {
            //Constant Time.
            A[locationToFillIndex] = rightA[rightIndex];
            //Constant Time.
            rightIndex++;
            //Constant Time.
            locationToFillIndex++;
        }
    }
}