package com.example.controller;

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
    
    public static void main(String[] args) {
		frequencySort();
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
		Map<String, List<String>> list = new HashMap<>();
		for(int i = 0; i < str.length; i++) {
			char[] curr = str[i].toCharArray();
			Arrays.sort(curr);
			String word = str[i];
			if(!list.containsKey(String.valueOf(curr))) {
				List<String> words = new ArrayList<>();
				words.add(word);
				list.put(String.valueOf(curr), words); 
			}else {
				List<String> add = list.get(String.valueOf(curr));
				add.add(word);
				list.put(String.valueOf(curr), add);
			}
		}
		for(Map.Entry<String, List<String>> set : list.entrySet()) {
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
    
    public static void medianTwoSortedArrays() {
    	int [] nums1 = {1,3}, nums2 = {2};
    	int n = nums1.length;
    	int m = nums2.length;
    	int tot = m + n;
    	int[] temp = new int[m + n];
    	int i = 0, j = 0;
    	while(i < n) {
    		temp[j++] = nums1[i++];
    	}
    	i = 0;
    	while(i < m) {
    		temp[j++] = nums2[i++];
    	}
    	System.out.println(temp);
    	Arrays.sort(temp);
    	int lower = temp[0];
    	int higher = temp[tot - 1];
    	double sum = lower + higher;
    	double median = sum / 2;
    	System.out.println(median);
    	//    	int[] temp = new int[nums1.length + nums2.length];
//    	while() {
//    		
//    	}
    }
    
    public static void validParanth() {
	   String str = "{[()]}";
       Map<Character, Character> map = new HashMap<>();
	   map.put('}', '{');
	   map.put(']', '[');
	   map.put(')', '(');
	   boolean flag = true;
	   Stack<Character> stack = new Stack<>();
	   for(int i = 0; i < str.length(); i++) {
		   if(!map.containsKey(str.charAt(i))) {
			   stack.add(str.charAt(i));
		   }else {
			   if(stack.pop() != map.get(str.charAt(i))) {
				  flag = false;
				   break;
			   }
		   }
	   }
	   System.out.println(flag);
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
    	return palindrome;
    }
}