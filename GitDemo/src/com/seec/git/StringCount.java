package com.seec.git;

import java.util.Scanner;

public class StringCount {
	public static void main(String arg[]){
		int[] arr= new int[26];
		Scanner scanner= new Scanner(System.in);
		String string= scanner.nextLine();
		for(int i = 0 ; i<string.length();i++){
			if(string.charAt(i)>=65&&string.charAt(i)<=90){
				arr[string.charAt(i)-65]++;
			}
			if(string.charAt(i)>=97&&string.charAt(i)<=122){
				arr[string.charAt(i)-97]++;
			}
			
		}
		for(int i = 0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		scanner.close();
	}

}


