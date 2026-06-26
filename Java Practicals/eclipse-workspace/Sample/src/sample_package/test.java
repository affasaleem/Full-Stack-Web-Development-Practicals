package sample_package;

import java.util.Scanner;

public class test {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		//test.array();
		//test.onedarray();
		//test.twodarray();
		//test.threedarray();
		test.jaggedarray();
	}
	
	public static void array() {
		System.out.println("=======Array========");
		int[] a = new int[] {1,2,3,4,5};
		System.out.println(a[3]);
	}

	public static void onedarray() {
		System.out.println("=======1DArray========");
		System.out.print("Enter array numbers: ");
		int[] array = new int[4];
		//for store
		for (int i=0; i < array.length; i++) { 
			array[i] = input.nextInt();
		}
		//for print
		for (int i=0; i < array.length; i++) {
			System.out.print(array[i] + " ");
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
	
	public static void threedarray() {
		
		System.out.println("======3DArray========");
		System.out.print("Enter array numbers of depth: ");
		int depth = input.nextInt();
		
		System.out.print("Enter array numbers of row: ");
		int row = input.nextInt();
		
		System.out.print("Enter array numbers of colum: ");
		int colum = input.nextInt();
		
		int[][][] array = new int[depth][row][colum];
		
		for (int i=0; i < array.length; i++) { 
			for (int j=0; j < array.length; j++) {
				for (int k=0;k < array.length; k++) {
					array[i][j][k] = input.nextInt();
					}
				}
			}
		
		for (int i=0; i < array.length; i++) {
			for (int j=0; j < array.length; j++) {
				for (int k=0;k < array.length; k++) {
					System.out.print(array[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	public static void jaggedarray() {
		System.out.println("2 dimensional array: ");
		int[][] arr = new int[][] {
			{1,2,4},
			{1,2,3},
			{1,3}
		};
		
//		System.out.println(arr[2][1] + " ");
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
		
		
}









