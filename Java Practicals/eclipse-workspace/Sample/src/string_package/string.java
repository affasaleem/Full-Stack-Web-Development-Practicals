package string_package;

public class string {

	public static void main(String[] args) {
		// Declaring Strings using String literals
        String s1 = "TAT";
        String s2 = "TAT";

        // Declaring Strings using new keyword
        String s3 = new String("TAT");
        String s4 = new String("TAT");

        // Printing all the Strings
//        System.out.println(s1.equals(s2));
//        System.out.println(s2);
//        System.out.println(s3.equals(s4));
//        System.out.println(s4);
        System.out.println(s3 == s4);

	}

}
