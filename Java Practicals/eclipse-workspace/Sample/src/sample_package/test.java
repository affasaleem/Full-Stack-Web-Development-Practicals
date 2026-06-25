package sample_package;

import java.util.Scanner;

public class test {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		//test.array();
		test.twodarray();
	}
	
	public static void array() {
//		int[] a = new int[] {1,2,3,4,5};
//		System.out.println(a[0]);
		System.out.println("=====-=Array========");
		System.out.print("Enter array numbers: ");
		int[] array = new int[3];
		//for store
		for (int i=0; i < array.length; i++) { 
			array[i] = input.nextInt();
		}
		//for print
		for (int i=0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	public static void twodarray() {
		
		System.out.println("======2DArray========");
		System.out.print("Enter array numbers of row: ");
		int row = input.nextInt();
		
		System.out.print("Enter array numbers of colum: ");
		int colum = input.nextInt();
		
		int[][] array = new int[row][colum];
		
		for (int i=0; i < array.length; i++) { 
			for (int j=0; j < array.length; j++) {
			array[i][j] = input.nextInt();
			}
		}
		
		for (int i=0; i < array.length; i++) {
			for (int j=0; j < array.length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}









