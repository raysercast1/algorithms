package Leetcode.SlidingWindows;

public class SubArraysSearch {
    public static void main(String[] args) {
        Integer[] nums = {3,1,2,7,4,2,1,1,5};
        int k = 8;
        Integer ans = slideWindows(nums, k);
        System.out.println("Longest subarray sum");
        System.out.println(ans);

        System.out.println("what is the longest substring that contains at most one '0'?");
        Integer binaryStringAns = binaryString("1101100111");
        System.out.println(binaryStringAns);

        System.out.println("Finding longest average");
        Integer[] avgInput = {1,12,-5,-6,50,3};
        Integer avgConstraint = 4;
        double findMaxAverage = findMaxAverage(avgInput, avgConstraint);
        System.out.println(findMaxAverage);

        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int constraint = 2;
        int ans1 = longestOnes(nums1, constraint);
        System.out.println("LongestOnes answer: ");
        System.out.println(ans1);
    }
    
    /*
     * You may be thinking: there is a while loop inside of the for loop, isn't the time complexity
     O(n^2)? The reason it is still O(n) is that the while loop can only iterate n times in total for
    the entire algorithm (left starts at 0, only increases, and never exceeds n). If the while loop 
    were to run n times on one iteration of the for loop, that would mean it wouldn't run at all for
    all the other iterations of the for loop. This is what we refer to as amortized analysis - 
    even though the worst case for an iteration inside the for loop is O(n), it averages out to O(1)
    when you consider the entire runtime of the algorithm.
    
    * O(n) Time Complexity.
    * O(1) Space Complexity = The space complexity is constant because we are only using 3 integer variables.
    */
    private static Integer slideWindows(Integer[] A, int target) {
        Integer answer = 0;
        Integer current = 0;
        int p = 0;

        for (int sp = 0; sp < A.length; sp++) {
            current += A[sp];
            while (current > target) {
                current -= A[p];
                p++;
            }
            answer = Math.max(answer, sp - p + 1);
        }
        return answer;
    }

    //Binary string is a string containing only "0" and "1"
    //O(n). As the work done in each loop iteration is amortized constant.
    //O(1) Space Complexity. Only a few integer variables are used.
    /*
     * the condition to determine if a window is valid is countingZero <= 1.
     * Whenever the window becomes invalid (countingZero > 1), we remove elements from the left.
     */
    private static Integer binaryString(String str) {
        int rightP = 0;
        int leftP = 0;
        int countingZero = 0;
        int currentAnswer = 0;
        
        while (rightP < str.length()) {
            if (str.charAt(rightP) == '0') {
                countingZero++;
            }

            while (countingZero > 1) {
                if (str.charAt(leftP) == '0') {
                    countingZero--;
                }
                leftP++;
            }

            currentAnswer = Math.max(currentAnswer, rightP - leftP + 1); //Valid window formula.
            rightP++;
        }
        return currentAnswer;
    }

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }

        int ans = 0;
        int left = 0;
        int curr = 1;
        
        for (int right = 0; right < nums.length; right++) {
            curr *= nums[right];
            while (curr >= k) {
                curr /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }
        
        return ans;
    }

    //O(n) Time Complexity. The work done in each iteration is constant
    //O(1) Space Complexity.
    private static Integer subArrayWithLargestSum(Integer[] nums, int subArrayLength) {
       int curr = 0;
       int ans = 0;

       for (int i = 0; i < subArrayLength; i++) {
            curr += nums[i];
       }
       ans = curr;

       for (int i = subArrayLength; i < nums.length; i++) {
        //If we are adding the value at i, then we need to remove the value at i - subArrayLength.
        //To keep the window size at subArrayLength.
            curr += nums[i] - nums[i - subArrayLength];
            ans = Math.max(ans, curr);
       }
       return ans;
    }

    //O(n) Time Completixy. Only iterating n times and executing constants op.
    //O(1) Space Complexity.
    private static double findMaxAverage(Integer[] nums, Integer constraint) {
        if (constraint == 1) return (double) nums[constraint];
        
        int curr = 0;
        double ans = 0.0;
        int leftP = 0;
        int rightP = 0;
        
        while (leftP < constraint) {
            curr += nums[leftP]; 
            leftP++;
        }

        ans = curr / 4;
        rightP = leftP;  

        while (rightP < nums.length) {
            curr = (curr + nums[rightP] - nums[rightP - constraint]) / 4; 
            ans = Math.max(ans, curr);
            rightP++; 
        }
        return ans;
    } 

    private static int longestOnes(int[] nums, int k) {
        int leftP = 0;
        int rightP = 0;
        int count = 0;
        int ans = 0;
        
        while (rightP < nums.length) {
            if (nums[rightP] == 0) {
                count++;
            }
            
            while (count > k) {
                if (nums[leftP] == 0) {
                    count--; //Remove a 0
                }
                leftP++; //Step forward
            }
            ans = Math.max(ans, rightP - leftP + 1);
            rightP++;
        }
        return ans;
    }
}
