package com.seec.git;

import java.util.Scanner;

public class StackImplementation {
	protected int capacity;
	public static final int CAPACITY= 10;
	protected int[] stackRep;
	protected int top = -1;


	public StackImplementation() {
		this(CAPACITY);
	}


	public StackImplementation(int capacity2) {
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
			throw new Exception("stack is full");
		}
		stackRep[++top]=data;
	}
	public int pop() throws Exception{
		int data;
		if(isEmpty())
			throw new Exception("stack is empty");
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

		StackImplementation stackImplementation= new StackImplementation(); 
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
