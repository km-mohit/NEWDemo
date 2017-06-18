package com.seec.git;

import java.util.Scanner;

class DLLNode{
	protected int data;
	protected DLLNode next;
	protected DLLNode prev;

	public DLLNode(int data){
		this.data= data;
		next= null;
		prev= null;
	}

	public DLLNode(int data, DLLNode next, DLLNode prev) {
		
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DLLNode getNext() {
		return next;
	}
	public void setNext(DLLNode next) {
		this.next = next;
	}
	public DLLNode getPrev() {
		return prev;
	}
	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}


}
class LinklistImplementation {
	protected DLLNode head;
	protected DLLNode tail;
	protected int length;
	public LinklistImplementation(){
		head= new DLLNode(Integer.MIN_VALUE, null, null);
		tail= new DLLNode(Integer.MIN_VALUE, head, null);
		
		length= 0;
	}
	public int getValue(int data){
		return Integer.MIN_VALUE;
	}
	public int length(){
		return length;
	}
	public void insertAtFront(int value){
		DLLNode newNode= new DLLNode(value, null, head.getNext());
		newNode.setPrev(newNode);
		head=newNode;
		length+=1;
	}
	public void insertAtTail(int value){
		DLLNode newNode= new DLLNode(value, tail.getPrev(), null);
		newNode.setNext(newNode);
		tail.setPrev(newNode);
		length+=1;
	}
	public void display(){
		String string =" ";
		if(length==0){
			System.out.println(string);
			return;
		}
		string=" "+head.getData();
		DLLNode dllNode=head;
		System.out.println(string+"<->");
		dllNode=head.getNext();
		while (dllNode!=null) {
			
			System.out.println(head.getData()+"<->");
			dllNode=dllNode.getNext();
		}
		System.out.println(head.getData());
		return ;
	}
	public static void main(String arg[]){
		LinklistImplementation linklistImplementation=new LinklistImplementation();
		Scanner scanner= new Scanner(System.in);
		System.out.println("Double Link list Implementation");
		char ch;
		do {
			System.out.println("1. for insert at head:");
			System.out.println("2. insert at tail:");
			System.out.println("3. display:");
			System.out.println("4. total length");
			int choice= scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter element:");
				linklistImplementation.insertAtFront(scanner.nextInt());
				break;
			case 2:
				System.out.println("enter element :");
				linklistImplementation.insertAtTail(scanner.nextInt());
				break;
			case 5:
				System.out.println(linklistImplementation.getValue(23));
				break;
			case 4:
				System.out.println(linklistImplementation.length());
				break;
			default:
				System.out.println("invalid choice:");
				break;
			}
			linklistImplementation.display();
			System.out.println("want to contd. pres 'y':");
			ch= scanner.next().charAt(0);

		} while (ch=='y'||ch=='Y');
		scanner.close();
	}

}
