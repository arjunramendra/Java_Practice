package com.example.dynamicprogramming;

public class Runner {

	public static void main(String[] args) {
		maxSubArray();
	}
	
	public static int minCostStairs() {
		int[] cost	= {1,100,1,1,1,100,1,1,100,1};
		
		int rob2 = 0;
		int rob1 = 0;
		for(int n = 2; n < cost.length ; n++) {
            int temp = rob1;
            rob1 = Math.min(rob1 + cost[n - 1], rob2 + cost[n - 2]);
            rob2 = temp;
		}
		return rob1;
	}
	
	public static int houseRobber() {
		int[] nums = {1,2,3,1};
        int N = nums.length;
        
        if (N == 0) {
            return 0;
        }

        int rob1 = 0;
        int rob2 = 0;
        for (int i : nums) {
            
            int current = Math.max(rob2, rob1 + i);
            
            rob1 = rob2;
            rob2 = current;
        }
        
        return rob2;	    
	}

    public static int climbStairs(int n){
        if(n == 1) return 1;
        if(n == 2) return 2;

        int n2 = 1, n1 = 2, all = 0;

        for(int i = 2; i < n; i++){
            all = n2 + n1;
            n2 = n1;
            n1 = all;
        }
        return all;
    }

    public static void maxSubArray(){
        int[] nums = {5,4,-1,7,8};
        int max = 0, current = nums[0];
        max = current;
        for(int i = 1; i < nums.length; i++){
            current = Math.max(nums[i] + current, nums[i]);
            max = Math.max(max, current);
        }
        System.out.println(max);
    }
}
