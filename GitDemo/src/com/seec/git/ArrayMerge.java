package com.seec.git;

public class ArrayMerge {
public  int[] merge(int[] a, int[] b) {

    int[] answer = new int[a.length + b.length];
    int i = 0, j = 0, k = 0;

    while (i < a.length && j < b.length)  
       answer[k++] = a[i] < b[j] ? a[i++] :  b[j++];

    while (i < a.length)  
        answer[k++] = a[i++];


    while (j < b.length)    
        answer[k++] = b[j++];

    return answer;
}
public static void main(String arg[]){
	ArrayMerge arrayMerge= new ArrayMerge();
	int[] arr1={1,2,3,4,5,10};
	int[] arr2={6,7,8,9};
	int[] arrr3=arrayMerge.merge(arr1,arr2);
	for (int i = 0; i < arrr3.length; i++) {
		System.out.print(arrr3[i]+" ");
		
	}
}

}
