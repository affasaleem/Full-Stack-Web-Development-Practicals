package string_package;

public class immutal_and_mutal {

	public static void main(String[] args) {
		immutal_and_mutal.mutal();
		immutal_and_mutal.immutal();

	}
	
	public static void mutal() {
		StringBuffer s = new StringBuffer("Hello");
		s.append(" World");

		System.out.println(s); // Hello World
	}
	
	public static void immutal() {
		String str = "Hello";
		str = str + " World";

		System.out.println(str); // Hello World
	}
}
