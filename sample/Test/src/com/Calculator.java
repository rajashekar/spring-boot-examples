package com;

import java.util.Stack;

public class Calculator {
	public static void main(String[] args) {
		String input = "1+42-2*5";
		System.out.println(calculate(input));
		
	}
	public static int calculate(String s) {
		int num = 0;
		char sign = '+';
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<s.length();i++) {
			if(Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
			} 
			
			if(!Character.isDigit(s.charAt(i)) || i == s.length() - 1) {
				if(sign == '-') {
					stack.push(-num);
				}
				if(sign == '+') {
					stack.push(num);
				}
				if(sign == '*') {
					stack.push(stack.pop()*num);
				}
				sign = s.charAt(i);
				num = 0;
			}
			
		}
		
		int ans = 0;
		for(int i : stack) {
			ans += i;
		}
		return ans;
	}
}
