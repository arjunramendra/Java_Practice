package com.example.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        System.out.println(wordSearch());
    }

    public static boolean wordSearch(){
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "SEE";
        int rows = board.length;
        int columns = board[0].length;
        boolean[][] visited = new boolean[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(word.charAt(0) == board[i][j] && searchWord(i, j, 0, word, board, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean searchWord(int i, int j, int index, String word, char[][] board, boolean[][] visited){
        if(index == word.length()){
            return true;
        }
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length ||
                word.charAt(index) != board[i][j] || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        if(searchWord(i + 1, j, index + 1, word, board, visited) ||
                searchWord(i - 1, j, index + 1, word, board, visited) ||
                searchWord(i, j + 1, index + 1, word, board, visited) ||
                searchWord(i, j - 1, index + 1, word, board, visited)
        ){
            return true;
        }
        visited[i][j] = false;
        return false;
    }

    public static void letterCasePermutation(){
        String s = "a1b2";
        List<String> array = new ArrayList<>();
        permutation(s.toCharArray(), 0, array);
        System.out.println(array.toString());
    }

    private static void permutation(char[] s, int index, List<String> array)
    {
        if (s.length == index) {
            array.add(String.valueOf(s));
            return;
        }
        permutation(s, index + 1, array);
        if (Character.isAlphabetic(s[index])) {
            s[index] = Character.isUpperCase(s[index]) ? Character.toLowerCase(s[index]) :
                    Character.toUpperCase(s[index]);
            permutation(s, index + 1, array);
        }
    }

    public static void subsets(){
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = new ArrayList<>();
        generateSubsets(0, nums, new ArrayList<Integer>(), subsets);
        System.out.println(subsets.toString());
    }

    private static void generateSubsets(int index, int[] nums, List<Integer> current, List<List<Integer>> subsets){
        subsets.add(new ArrayList<>(current));
        for(int i = index; i < nums.length; i++){
            current.add(nums[i]);
            generateSubsets(i + 1, nums, current, subsets);
            current.remove(current.size() - 1);
        }
    }

    public static void combinationSum(){
        int[] candidates = {2,3,6,7};
        int target = 7;

        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        System.out.println(ans.toString());
    }

    private static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if(arr[ind] <= target){
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
}
