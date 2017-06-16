package com.seec.git;

import java.util.Scanner;

class LinkNode{
	protected int data;
	protected LinkNode link;

	public LinkNode(){
		data= 0;
		link = null;
	}
	public LinkNode(int data, LinkNode link) {

		this.data = data;
		this.link = link;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public LinkNode getLink() {
		return link;
	}
	public void setLink(LinkNode link) {
		this.link = link;
	}
}

class LinklistNode{

	protected LinkNode start;
	protected LinkNode end;
	public int size;

	public LinklistNode(){
		start=null;
		end= null;
		size=0;
	}
	public boolean isEmpty(){
		return start==null;
	}

	public int getSize(){
		return size;
	}

	public void insertAtbegin(int value){
		LinkNode linkNode= new LinkNode(value ,null );
		size++;
		if(start==null){
			start=linkNode;
			end= start;
		}
		else{
			linkNode.setLink(start);
			start=linkNode;
		}	
	}

	public void insertAtEnd(int value){
		LinkNode linkNode= new LinkNode(value ,null );
		size++;
		if(start==null){
			start=linkNode;
			end= start;
		}
		else{
			end.setLink(linkNode);
			end= linkNode;
		}
	}
	public void insertAtPos(int value, int pos){
		LinkNode linkNode= new LinkNode(value, null);
		LinkNode linkNode2= start;
		pos= pos-1;
		for(int i = 0; i<size; i++){
			if(i == pos){
				LinkNode node= linkNode2.getLink();
				linkNode2.setLink(linkNode);
				linkNode.setLink(node);
			}
			linkNode2= linkNode2.getLink();
		}
		size++;

	}
	public void deleteAtPos( int pos){
		if(pos==1){
			start= start.getLink();
			size--;
			return;
		}
		if(pos==size){
			LinkNode st = start;
			LinkNode stt= start;
			while(st!=end){
				stt= st;
				st=st.getLink();
			}
			end= stt;
			end.setLink(null);
			size--;
			return;
		}
		LinkNode lnk= start;
		pos=pos-1;
		for(int i = 0 ; i<size; i++){
			if(i==pos){
				LinkNode ptr= lnk.getLink();
				ptr= ptr.getLink();
				lnk.setLink(ptr);
				break;	
			}
			lnk.getData();
		}
		size--;

	}
	public void display(){
		System.out.println("link list");
		if (size==0) {
			System.out.println("empty");
			return;
		}
		if(start.getLink()==null){
			System.out.println(start.getData());
			return;
		}
		LinkNode linknode= start;
		System.out.print(start.getData()+"->");
		linknode= start.getLink();
		while (linknode.getLink()!=null) {
			System.out.print(linknode.getData()+"->");
			linknode=linknode.getLink();
		}
		System.out.println(linknode.getData());

	}
}

public class LinkedListImplementation {

	public static void main(String arg[]){
		Scanner scanner = new Scanner(System.in);
		LinklistNode linklistNode= new LinklistNode(); 
		char ch;
		do {
			System.out.println("1. enter element to insert at begining");
			System.out.println("2. enter element to insert at end");
			System.out.println("3. enter element to insert at pos");
			System.out.println("4. enter element to delete at pos");
			System.out.println("5. status");
			System.out.println("6. size of list");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter element to be insert:");
				linklistNode.insertAtbegin(scanner.nextInt());
				break;
			case 2:
				System.out.println("enter element to insert");
				linklistNode.insertAtEnd(scanner.nextInt());
				break;
			case 3:
				System.out.println("enter element to insert");
				int num= scanner.nextInt();
				System.out.println("enter positin");
				int pos= scanner.nextInt();
				if(pos<=0||pos>linklistNode.getSize()){
					System.out.println("invaild postion");
				}
				else{
					linklistNode.insertAtPos(num, pos);
				}
				break;
			case 4:
				System.out.println("enter the position");
				int position= scanner.nextInt();
				if(position<1||position>linklistNode.getSize()){
					System.out.println("invalid position");
				}
				else{
					linklistNode.deleteAtPos( position);	
				}
				break;
			case 5:
				System.out.println("empty status"+linklistNode.isEmpty());
				break;
			case 6:
				System.out.println("size of list"+linklistNode.size);
				break;
			default:
				System.out.println("you enter wrong choice");
				break;
			}
			linklistNode.display();
			System.out.println("do you want to cont. press 'Y' ");
			ch= scanner.next().charAt(0);

		} while (ch=='Y'|| ch=='y');
		scanner.close();
	}
}
