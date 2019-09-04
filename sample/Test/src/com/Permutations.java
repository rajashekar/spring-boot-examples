package com;

public class Permutations {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int iterations = 1;
		for(int i=0;i< a.length;i++) {
			iterations = iterations * (i + 1);
		}
		System.out.println("Total permutations will be "+iterations);
		int total = iterations;
		int index = 0, sub  = 1;
		while(iterations > 0) {
			
			if(iterations == total/2) {
				sub = sub + 1;
			}
			
			for(int i=0;i<a.length;i++) {
				System.out.print(a[i]);
			}
			System.out.println();
			
			index = index % a.length;
			int i1 = index;
			int i2 = (index + sub) % a.length;

			int temp = a[i1];
			a[i1] = a[i2];
			a[i2] = temp;
			
			index++;
			iterations--;
		}
	}
}
