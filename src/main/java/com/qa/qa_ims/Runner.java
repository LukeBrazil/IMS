package com.qa.qa_ims;

import java.util.Scanner;

import com.qa.qa_ims.SqlCon;

public class Runner {
	
	static void add() {
		SqlCon myCon = new SqlCon();
		//myCon.addItem();
		//myCon.updateItem();
		//myCon.deleteItem();
		myCon.deleteCustomer();
	}
	
	static void menuMessage() {
		System.out.println("Welcome to the Inventory Managment System!");
		System.out.println();
		System.out.println("Please Choose an option below to continue: ");
		System.out.println();
		System.out.println("A: Add New Customer.");
		System.out.println();
		System.out.println("B: Show All Customers.");
		System.out.println();
		System.out.println("C: Show All Items.");
		System.out.println();
		System.out.println("D: Create New Order.");
		System.out.println();
		System.out.println("E: Add Item to Order.");
		System.out.println();
		System.out.println("F: Show All Orders.");
		System.out.println();
		System.out.println("G: Create New Item.");
		System.out.println();
		System.out.println("H: Update Item.");
		System.out.println();
		System.out.println("I: Delete Item.");
		System.out.println();
		System.out.println("M: Exit.");
	}
	
	static void initiatePortal() {
		char option = '\0';
		menuMessage();
		
		do {
			SqlCon myCon = new SqlCon();
			Scanner myInput = new Scanner(System.in);
			char chosenInput = myInput.next().charAt(0);
			option = Character.toUpperCase(chosenInput);
			switch(option) {
			case 'A':
				Scanner myObj = new Scanner(System.in);
				System.out.println("Enter First Name: ");
				String first_name = myObj.next();
				System.out.println(first_name);
				System.out.println("Enter Last Name: ");
				String last_name = myObj.next();
				System.out.println(last_name);
				System.out.println("Enter Age: ");
				int age = myObj.nextInt();
				System.out.println(age);
				myCon.addCustomer(first_name, last_name, age);
				menuMessage();
				break;
			case 'B':
				myCon.showAllCustomers();
				menuMessage();
				break;
			case 'C':
				System.out.println(myCon.showItems());
				menuMessage();
				break;
			case 'D':
				myCon.createOrder();
				menuMessage();
				break;
			case 'E':
				myCon.addItemsToOrder();
				menuMessage();
				break;
			case 'F':
				myCon.showOrders();
				menuMessage();
				break;
			case 'G':
				myCon.addItem();
				menuMessage();
				break;
			case 'H':
				myCon.updateItem();
				menuMessage();
				break;
			case 'I':
				myCon.deleteItem();
				menuMessage();
				break;
			default:
				System.out.println("Please Choose a valid option: A, B, C, D, E, or F.");
				menuMessage();
				break;
			}
		} while(option != 'M');
		System.out.println("Thank you for using the inventory managment system!");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//add();
		initiatePortal();
	}

}
