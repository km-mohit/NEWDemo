package com.seec.git;

import java.util.Scanner;

public class DynamicArrayStackImplementation {
	protected int capacity;
	public static final int CAPACITY= 1;
	public static final int MINCAPACITY= 1<<15;
	protected int[] stackRep;
	protected int top = -1;


	public DynamicArrayStackImplementation() {
		this(CAPACITY);
	}


	public DynamicArrayStackImplementation(int capacity2) {
		capacity=capacity2;
		stackRep= new int[capacity];
	}
	public int size(){
		return top+1;
	}
	public boolean isEmpty(){
		return (top<0);
	}
	public void push(int data) throws Exception{
		if(size()==capacity){
			expand();
		}
		stackRep[++top]=data;
	}
	private void expand(){
		int length= size();
		int[] newstack=new int[length<<1];
		System.arraycopy(stackRep, 0, newstack, 0, length);
		stackRep=newstack;
		this.capacity= this.capacity<<1;
	}
	private void shrink(){
		int length=top+1;
		if(length<=MINCAPACITY||top<<2>=length){
			return;
		}
		length= length+(top<<1);
		if(top<MINCAPACITY)
			length=MINCAPACITY;
		int[] newstack=new int[length];
		System.arraycopy(stackRep, 0, newstack, 0, top+1);
		stackRep= newstack;
		this.capacity=length;
	}
	public int pop() throws Exception{
		int data;
		if(isEmpty())
			shrink();
		data=stackRep[top];
		stackRep[top--]=Integer.MIN_VALUE;
		return data;

	}
	public String toString(){
		String string ="[";
		if(size()>0){
			string+=stackRep[0];
		}
		if(size()>1){
			for(int i = 1; i<=size()-1;i++){
				string+=","+stackRep[i];
			}
		}
		return string+"]";

	}


	public static void main(String[] args) throws Exception {

		DynamicArrayStackImplementation stackImplementation= new DynamicArrayStackImplementation(); 
		Scanner scanner= new Scanner(System.in);
		char ch;
		do {
			System.out.println("1. for insertion = \n 2. for pop =\n 3. for display= \n 4. status \n 5.size=");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter elemet for push");
				stackImplementation.push(scanner.nextInt());
				break;
			case 2:
				System.out.println(stackImplementation.pop());
				break;
			case 3:
				System.out.println("display \n");
				System.out.println(stackImplementation.toString());
				break;
			case 4:
				System.out.println("status:");
				System.out.println(stackImplementation.isEmpty());
				break;
			case 5:
				System.out.println("size:");
				System.out.println(stackImplementation.size());
			default:
				break;
			}
			System.out.println("want to cont. pres 'y' \n");
			ch= scanner.next().charAt(0);
		} while (ch=='Y'||ch=='y');
		scanner.close();
	}
}
