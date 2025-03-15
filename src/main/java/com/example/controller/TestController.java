package com.example.controller;

import com.example.linkedlist.Node;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        System.out.println("Hello");
        //throw new Exception();
        return "Hello";
    }

    public static void frequencySort() {
    	Integer[] n = {4,6,5,5,4,3};
    	List<Integer> items = Arrays.asList(n);
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < items.size(); i++){
            if(map.containsKey(items.get(i))){
                int value = map.get(items.get(i)) + 1;
                map.put(items.get(i), value);
            }else{
                map.put(items.get(i), 1);
            }
        }
        
        List<Integer> finalList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
        	if(entry.getValue() == 1) {
        		finalList.add(entry.getKey());
        		entry.setValue(-1);
        	}else {
        		valueList.add(entry.getValue());
        	}
        }
        Collections.sort(finalList);
        Collections.sort(valueList);
        for(int j = 0; j< valueList.size(); j++) {
	        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
	        	if(entry.getValue() == valueList.get(j)){
	        		int i = entry.getValue();
	        		while(i >= 1) {
	        			finalList.add(entry.getKey());
	        			i--;
	        		}
	        		entry.setValue(-1);
        		}
        	}
        }
        System.out.println(finalList);   
    }

	public static void frequencySor1t(){
		int[] nums = {1,1,2,2,2,3};
		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> valMap = new HashMap<>();
		for(int i = 0;  i < nums.length; i++){
			if(valMap.containsKey(nums[i])){
				valMap.put(nums[i], valMap.get(nums[i]) + 1);
			}else{
				valMap.put(nums[i], 1);
			}
		}

	}
    
    public static void printFibo() {
    	int n = 2;
    	int arr[] = new int[10];
    	arr[0] = 0;
    	arr[1] = 1;
    	printfibo(0, 1, n, arr);
    	System.out.println(arr);
    }
    
    public static void anagram() {
		String[] str = {"cat", "dog", "tac", "god", "act"};
		Map<String, List<String>> map = new HashMap<>();
		for(int i = 0; i < str.length; i++) {
			char[] curr = str[i].toCharArray();
			Arrays.sort(curr);
			String word = str[i];
			if(!map.containsKey(String.valueOf(curr))) {
				List<String> words = new ArrayList<>();
				words.add(word);
				map.put(String.valueOf(curr), words);
			}else {
				List<String> add = map.get(String.valueOf(curr));
				add.add(word);
				map.put(String.valueOf(curr), add);
			}
		}
		for(Map.Entry<String, List<String>> set : map.entrySet()) {
			if(set.getValue().size() > 1) {
				System.out.print(set.getValue().toString());
			}		
		}
    }
    
    public static void printfibo(int i, int j, int n, int arr[]) {
    	if(n == 10) {
    		return;
    	}
    	arr[n++] = arr[i] + arr[j];
		printfibo(n-1, n-2, n, arr);

    }
    
    
    public static void fiboLoop() {
    	int[] arr = new int[10];
    	arr[0] = 0;
    	arr[1] = 1;
    	for(int i = 2; i < arr.length; i++) {
    		arr[i] = arr[i - 1] + arr[i - 2];
    	}
    	System.out.println(arr);
    }
    
    public static int calcProfit(int[] prices, int start, int end, int k, int profit) {
    	if(k == 0) {
    		return profit;
    	}
    	int currProf = profit;
    	int min = prices[start];
		int max = prices[start];
		int startIndex = start;
		boolean buy = false, sell = false;
//    	else {
    		for(startIndex = start; startIndex < end; startIndex++) {
    			if(prices[startIndex] < min && !buy && !sell) {
    				min = prices[startIndex];
    				max = prices[++startIndex];
    				buy = true;
    			}if(prices[startIndex] > max && !sell && buy) {
    				max = prices[startIndex];
    				sell = true;
    			}if(buy && sell) {
    				break;
    			}
    		}
//    	}
    	currProf += max - min;
    	k--;
		return calcProfit(prices, startIndex + 1, end + 1, k, currProf);
    }
    
    public static void runLengthEncoding() {
    	String s = "wwwwaaadexxxxxxywww";
    	Map<Character, Integer> count = new LinkedHashMap<>();
    	for(int i = 0 ; i < s.length(); i++) {
    		if(!count.containsKey(s.charAt(i))) {
    			count.put(s.charAt(i), 1);
    		}else if(count.containsKey(s.charAt(i))) {
//    			int update = count.get(s.charAt(i)) + 1;
    			count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
    		}
    	}
    	for(Map.Entry<Character, Integer> set : count.entrySet()) {
    		System.out.print(set.getKey().toString() + set.getValue());
    	}
	}
    
    public static double medianTwoSortedArrays() {
    	int[] nums1 = {1, 3}, nums2 = {2};
    	int n1 = nums1.length, n2 = nums2.length, total = n1 + n2;
		if(n1 == 0 || n2 == 0){
			double sum = 0;
			if(n1 == 0){
				return median(n2, nums2);
			}else{
				return median(n1, nums1);
			}
		}
		int[] temp = new int[total];
		int i = 0, j = 0, k = 0;
		while(i < n1 || j < n2){
			if(nums1[i] > nums2[j]){
				temp[k++] = nums2[j++];
			}else{
				temp[k++] = nums1[i++];
			}
			if(j == n2){
				while(i < n1) {
					temp[k++] = nums1[i++];
				}
			}if(i == n1){
				while(j < n2){
					temp[k++] = nums2[j++];
				}
			}
		}
		return median(total, temp);
    }

	private static double median(int total, int[] temp){
		double median = 0, sum = 0;
		if(total % 2 == 0){
			int middle = total/2 - 1;
			sum = temp[middle] + temp[middle + 1];
			median = sum /2;
		}else{
			int middle = total/2;
			sum = temp[middle];
			median = sum;
		}
		return median;
	}

	public static void findMissingNumber(){
		int a=0,b=0;
		int[] arr = {3,0,1};
		int n = arr.length;
		int xor = 0;
		for(int i=0;i<n;i++) {
			xor = xor ^ arr[i];
		}
		for(int i=0;i<=n;i++){
			xor^=i;
		}
		System.out.println(xor);
	}
    
    public static void validParanth() {
		String str = "{[()]}";
		boolean valid = true;
		Map<Character, Character> map = new HashMap<>();
		map.put('}','{');
		map.put(']','[');
		map.put(')','(');
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < str.length(); i++){
			if(map.containsKey(str.charAt(i))){
				if(!stack.pop().equals(map.get(str.charAt(i)))){
					valid = false;
					break;
				}
			}else{
				stack.push(str.charAt(i));
			}
		}
		System.out.println(valid);
    }
    
    public static int longestWoRepeating() {
    	String s = "dvdf";
		if(s.length() == 0 || s.length() == 1) {
			return s.length();
		}
		List<Character> list = new LinkedList<>();
		list.add(s.charAt(0));
		int length = 0;
		for(int i = 1; i < s.length(); i++) {
			if(list.contains(s.charAt(i))) {
				length = Math.max(list.size(), length);
				list.clear();
				list.add(s.charAt(i));
			}else {
				list.add(s.charAt(i));
			}
		}
		return Math.max(length, list.size());
    }
    
    public static String palindrome() {
		String s = "cbbd";
		int n = s.length();
		int maxLength = 0;
		String palindrome = "";
		for(int i = 0; i < n; i++) {
			int left = i;
			int right = i;
			while(left >= 0 && right < n && s.charAt(left)  == s.charAt(right)) {
				left--;
				right++;
			}
			String substring = s.substring(left + 1, right);
			if(substring.length() > maxLength) {
				palindrome = substring;
				maxLength = substring.length();
			}
			right = i +1;
			left = i;
			while(left >= 0 && right < n && s.charAt(left)  == s.charAt(right)) {
				left--;
				right++;
			}
			substring = s.substring(left + 1, right);
			if(substring.length() > maxLength) {
				palindrome = substring;
				maxLength = substring.length();
			}

		}
		System.out.println(maxLength);
		return palindrome;
	}

	public static void setMatrixZeros() {
		int[][] matrix = {{0,1},{0,1}};
		boolean isRowFirstZero = false;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix.length; c++) {
				if (matrix[r][c] == 0) {
					matrix[0][c] = 0;
					if(r > 0) {
						matrix[r][0] = 0;
					}else{
						isRowFirstZero = true;
					}
				}
			}
		}
		System.out.println(matrix);
		for(int r = 1; r < matrix.length; r++){
			for(int c = 1; c < matrix[0].length; c++){
				if(matrix[r][0] == 0 || matrix[0][c] == 0){
					matrix[r][c] = 0;
				}
			}
		}
		System.out.println(matrix);
		if(isRowFirstZero){
			for(int r = 0; r < matrix.length; r++){
				matrix[r][0] = 0;
			}
			for(int c = 0; c < matrix.length; c++){
				matrix[0][c] = 0;
			}
		}
		System.out.println(matrix);
//			0, 1, 2, 0    0 ,0, 0, 0
//			3, 4, 5, 2    0, 4, 5, 0
//			1, 3, 1, 5    0, 3, 1, 0
	}

	public static int[] twoSum(){
		int[] nums = {3,2,4};
		int target = 6;
		Map<Integer, Integer> numsList = new HashMap<>();
		int result = 0, result1 = 0;
		for(int i = 0; i < nums.length; i++){

			int compute = target - nums[i];
			if(numsList.containsValue(compute)){
				for(Map.Entry<Integer, Integer> entry : numsList.entrySet()) {
					if (entry.getValue() == compute && entry.getKey() != i) {
						result = entry.getKey();
						break;
					}
				}
				result1 = i;
				break;
			}
			numsList.put(i, nums[i]);
		}
		return new int[] {result1, result};
	}

	public static int[] twoSumOptimized(){
		int[] nums = {3,2,4};
		int target = 6;
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			map.put(nums[i], i);
		}
		for(int i = 0; i < nums.length; i++){
			int diff = target - nums[i];
			if(map.containsKey(diff) && map.get(diff) != i){
				return new int[]{i, map.get(diff)};
			}
		}
		return null;
	}

	public static boolean containsDuplicates(){
		int[] nums = {1,1,1,3,3,4,3,2,4,2};
		HashSet<Integer> list = new HashSet<>();
		for(int i = 0; i < nums.length; i++){
			if(list.contains(nums[i])){
				return true;
			}else{
				list.add(nums[i]);
			}
		}
		return false;
	}

	public boolean hasCycle(){

		ListNode head = null;
		Node node = head;
		HashSet<Node> set = new HashSet<>();
		while(node.next != null){
			if(set.contains(node)){
				return true;
			}
			set.add(node);
			node = node.next;
		}
		return false;
	}

	public int llIntersection(){
		ListNode headA = null;
		ListNode headB = null;
		Node a = headA, b = headB;
		while(a != null && b != null){
			if(a == b){
				return a.getData();
			}
		}
		return -1;
	}

	public class ListNode extends Node {}

//	public ListNode intersectionLl(){
//		ListNode headA = null, headB = null;
//		ListNode A = headA, B = headB;
//		while(A != B){
//			A = A == null ? headB : A.next;
//			B = B == null ? headA : B.next;
//		}
//		return A;
//	}

	public static void main(String[] args) {
		System.out.println(containsDuplicates());
	}

}