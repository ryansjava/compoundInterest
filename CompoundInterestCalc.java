package com.mydomain;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CompoundInterestCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double initialInvestment = collectInput(sc, "Type in your starting investment:");
		double interestRate = collectInput(sc, "Type in your interest rate:");
		
		calcAndOutput(initialInvestment, interestRate);
		sc.close();
	}

	private static double collectInput(Scanner input, String prompt) {
		boolean error = false;
		double userInput = 0.0;
		
		do {
			try {
				System.out.println(prompt);
				userInput = Double.parseDouble(input.nextLine());
				if(isValid(userInput)) {
					error = false;
				}
			} catch(NumberFormatException ex) {
				System.out.println("Invalid Input.. Pls enter a numeric value");
				error = true;
			}
		} while(error);
		
		return userInput;
	}
	
	private static boolean isValid(double num) {
		if((num > 0 && num <= 100) || num > 0) {
			return true;
		}
		
		System.out.println("Enter a positive dollar amount or interest rate percentage");
		return false;
	}
	
	private static void calcAndOutput(double initialInvestment, double interestRate) {
		DecimalFormat currency = new DecimalFormat("$###,###,###.00");
		double newBalance = initialInvestment;
		
		for(int i = 0; i < 30; i++) {
			newBalance = newBalance * ((interestRate / 100) + 1.0);
			if(i % 5 == 4) {
				 System.out.println("After " + (i + 1) + " years, you would have: " + currency.format(newBalance));
			}
		}
	}
}
