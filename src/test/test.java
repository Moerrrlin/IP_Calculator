package test;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scanner1 = new Scanner(System.in);
		
		int integer = scanner1.nextInt();
		System.out.println("Ihre Zahl: " + integer);
		
		int no1 = scanner1.nextInt();
		int no2 = scanner1.nextInt();
		System.out.println("Ergebnis: " + (no1 * no2));
		
		Scanner scanner2 = new Scanner(System.in);
		String word1 = scanner2.nextLine();
		Scanner scanner3 = new Scanner(System.in);
		String word2 = scanner3.nextLine();
		System.out.println(word1.concat(word2));
	}

}
