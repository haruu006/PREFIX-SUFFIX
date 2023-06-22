//Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

//The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

//You must write an algorithm that runs in O(n) time and without using the division operation.

//Example 1:

//Input: nums = [1,2,3,4]
//Output: [24,12,8,6]

//ANSWER:
//Three approaches can be followed
//Brute force method, divide prod by that value, and prefix-suffix(without using '/' )

class Solution {
    public int[] productExceptSelf(int[] nums) {
        //O(n) time and without using the division operation.
        // Using prefix and suffix approach
        int n=nums.length;
        int[] prefixprod=new int[n];
        int[] suffixprod=new int[n];
        
        prefixprod[0]=1;
        for(int i=1;i<n;i++){
            prefixprod[i]=prefixprod[i-1]*nums[i-1];
            System.out.println(prefixprod[i]);
        }

        suffixprod[n-1]=1;
        for(int i=n-2;i>=0;i--){
            suffixprod[i]=suffixprod[i+1]*nums[i+1];
            System.out.println(suffixprod[i]);
        }

        for(int i=0;i<n;i++){
            nums[i]=prefixprod[i]*suffixprod[i];
        }
        return nums;
    }
}
