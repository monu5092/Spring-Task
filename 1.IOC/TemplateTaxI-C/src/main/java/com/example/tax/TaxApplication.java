package com.example.tax;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TaxApplication {

	private static System Sytem;

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Tax Payment Application");
		while (true) {
			System.out.println("Please select which tax you want to pay: \n1. Income \n2. Property\n3. Exit");
			int userChoice = scanner.nextInt();
			String taxChoice = "";
			switch (userChoice) {
				case 1 -> taxChoice = "incomeTax";
				case 2 -> taxChoice = "propertyTax";
				case 3 -> {
					System.out.println("Exiting...");
					return;
				}
				default -> {
					System.out.println("Invalid choice");
					return;
				}
			}
			Tax tax = (Tax) context.getBean(taxChoice);

			if(tax.isTaxPayed()){
				System.out.println("you have already paid Income/Property"+tax.getTaxType()+"tax");
			}
			else{
				System.out.print("Enter the taxable Amount:");
				double taxableAmount=scanner.nextDouble();
				tax.setTaxableAmount((int) taxableAmount);

				double taxamount = tax.calculateTaxAmount();
				System.out.print(taxamount);

				Sytem.out.print("Do you want to pay the tax?(yes/no)");
				String paychoic=scanner.next();

				if(paychoic.equalsIgnoreCase("yes")){
					tax.payTax();
					System.out.println("You have successfully paid the "+tax.getTaxType()+" tax.");
				}
				else{
					System.out.println("Exit");
				}
			}

		}
	}

}
