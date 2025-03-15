package com.example.dynamicprogramming;

import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {
        palindromicSubstrings();
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

    public static void maxSubarray(){
       int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
       int max = 0, current = nums[0];
       max = current;
       for(int i = 1; i < nums.length; i++){
           current = Math.max(nums[i] + current, nums[i]);
           max = Math.max(current, max);
       }
        System.out.println(max);
    }

    public static void coinChange(){
        int[] coins = {1,2,5};
        int amount = 11;
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }else{
                    break;
                }
            }
        }
        int val = dp[amount] > amount ? -1 : dp[amount];
        System.out.println(val);
    }

    public static void decodeWays(){
        String s = "06";
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); i++){
            int oneDigit = Integer.valueOf(s.substring(i - 1, i));
            int twoDigit = Integer.valueOf(s.substring(i - 2, i));

            if(oneDigit >= 1){
                dp[i] += dp[i - 1];
            }
            if(twoDigit >= 10 && twoDigit <= 26){
                dp[i] += dp[i - 2];
            }
        }
        System.out.println(dp[s.length()]);
    }

    public static void palindromicSubstrings(){
        String s = "aaa";
        int n = s.length();
        int totalPalindrome = 0;
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                totalPalindrome++;
            }
            right = i + 1;
            left = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                totalPalindrome++;
            }
        }
        System.out.println(totalPalindrome);
    }
}
