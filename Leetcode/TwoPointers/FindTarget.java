package Leetcode.TwoPointers;

/**
 * This is a TWO POINTERS example.
 * Start the pointers at the edges of the input. Move them towards each other until they meet.
 * Or move one of them to accomplish the goal.
 */
public class FindTarget {
    public static void main(String[] args) {
        Integer[] sortedArr = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        Integer target = 22;
        printTarget(sortedArr, target);
        printTargetOptimized(sortedArr, target);
    }

    //O(n^2)
    public static void printTarget(Integer[] sortedArray, Integer target) {
        for (int i = 0; i < sortedArray.length; i++) {
            for (int j = 1; j < sortedArray.length; j++) {
                int currentOp = sortedArray[i] + sortedArray[j];
                if (currentOp == target) {
                    System.out.println("Numbers found at index");
                    System.out.println(i);
                    System.out.println("and at index");
                    System.out.println(j);
                    return;
                }
            }
        }
        System.out.println("Target not found");
        return;
    }

    //O(n) time complexity and O(1) for space complexity.
    private static void printTargetOptimized(Integer[] sortedArray, Integer target) {
        int firstPointer = 0;
        int lastPointer = sortedArray.length - 1;
        // The reason this algorithm works: because the numbers are sorted.
        while (firstPointer < lastPointer) {
          int currentOp = sortedArray[firstPointer] + sortedArray[lastPointer];
          if (currentOp > target) {
            lastPointer--;
          } else if (currentOp < target) {
            firstPointer++;
          } else if (currentOp == target) {
            return;
          }
        }
        return;
    }
}
