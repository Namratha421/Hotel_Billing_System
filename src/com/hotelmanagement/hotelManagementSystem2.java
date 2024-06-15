package com.hotelmanagement;

import java.util.ArrayList;
import java.util.Scanner;

class Bill{
	int itemId;
	String itemName;
	int itemPrice;
	int quantity;
	int subTotal;

	public Bill(int itemId, String itemName, int itemPrice, int quantity, int subTotal) {

		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.quantity = quantity;
		this.subTotal = subTotal;

	}

	public String toString() {

		return  "  "+itemId+"          "+itemName+"          "+itemPrice+"              "+quantity+"               "
				+ " "+subTotal;

	}
}

public class hotelManagementSystem2 {
	public static void main(String[] args) {
		String name = null;
		int itemId = 0;
		int quantity = 0;
		String itemName = null;
		int itemPrice = 0;
		int subTotal = 0;
		String choice = null;

		int grandTotal = 0;

		ArrayList<Bill> al = new ArrayList<Bill>();
		System.out.println("\n *******************************Welcome to Hotel Vishnu Park*******************************  ");
		Scanner scan = new Scanner(System.in);
		System.out.println("\nPlease enter your name");
		name = scan.nextLine();

		do{
			System.out.println("\nDear " + name + ", Below is the menu");
			System.out.println("__________________________________________");
			System.out.println("Item id      Item Name     Item Price");
			System.out.println("__________________________________________");
			System.out.println("1            Water         10");
			System.out.println("2            Peppsi        30");
			System.out.println("3            Burger        100");
			System.out.println("4            Fries         50");
			System.out.println("5            Pizza         150");
			System.out.println("___________________________________________");

			System.out.println("\nPlease Enter the Item id");
			itemId = scan.nextInt();
			System.out.println(" ");
			System.out.println("Please Enter the Quantity");
			quantity = scan.nextInt();
			System.out.println(" ");

			switch(itemId) {
			case 1:itemName = "Water";
			itemPrice = 10;
			subTotal = itemPrice*quantity;
			break;
			case 2:itemName = "Peppsi";
			itemPrice = 30;
			subTotal = itemPrice*quantity;
			break;
			case 3:itemName = "Burger";
			itemPrice = 100;
			subTotal = itemPrice*quantity;
			break;
			case 4:itemName = "Fries";
			itemPrice = 50;
			subTotal = itemPrice*quantity;
			break;
			case 5:itemName = "Pizza";
			itemPrice = 150;
			subTotal = itemPrice*quantity;
			break;
			default:System.out.println("Invalid Choice");
			break;
			}

			grandTotal +=  subTotal;
			System.out.println( " Item Name: " + itemName + 
					"\n Item price: " + itemPrice + "\n Quantity: " + quantity + "\n SubTotal: " + 
					subTotal);


			al.add( new Bill(itemId,itemName,quantity,itemPrice,subTotal));
			System.out.println(" ");
			System.out.println("Do you like to order more(Y/N)");
			choice = scan.next();
			System.out.println(" ");


		}while(choice.equalsIgnoreCase("Y") || (choice.equalsIgnoreCase("Yes")));

		//total billing
		System.out.println("_________________________________________________________________________");
		System.out.println(" ItemId      ItemName     ItemPrice      ItemQuantity       SubTotal");
		System.out.println("_________________________________________________________________________");

		for(Bill x:al) {
			System.out.println(x);
		}
		System.out.println("_________________________________________________________________________");
		System.out.println("\nThe Total Bill Before Tax is : " + grandTotal);

		//total billing with tax
		float total = grandTotal + (0.05f*grandTotal);
		System.out.println("The Total Bill After Tax is  : " + total);


		//adding tips to customers
		System.out.println("\nWould you like to leave a tip? (Y/N)");
		String tipChoice = scan.next();

		if (tipChoice.equalsIgnoreCase("Y") || tipChoice.equalsIgnoreCase("Yes")) {
			System.out.println("Please enter the tip amount: ");
			float tipAmount = scan.nextFloat();

			// Add the tip amount to the total bill
			total += tipAmount;

			// Display the updated total bill with the tip
			System.out.println("Total Bill with Tip: " + total);
			System.out.println("\n*******************************Thank you for dining with us!*******************************");
		} else {
			System.out.println("*******************************Thank you for dining with us!*******************************");
		}
		scan.close();
	}
}

