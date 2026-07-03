package string_package;

public class string_methods {

	public static void main(String[] args) {
		/*
		 * String s = "hello" ; System.out.println( "toUpperCase: " + s.toUpperCase());
		 * System.out.println("charAt(0): " + s.charAt(0));
		 * 
		 * System.out.print("String to Array: "); for (int i=0; i<s.length(); i++) {
		 * char[] c = s.toCharArray(); System.out.print( c[i] + " ")
		 */

		String str = "  Hello Java World  ";
		String str2 = "hello java world";
		String str3 = "Hello Java World";

		System.out.println("Original String : \"" + str + "\"");

		// 1. length()
		System.out.println("\n1. length()");
		System.out.println(str.length());

		// 2. charAt()
		System.out.println("\n2. charAt()");
		System.out.println(str.charAt(2));

		// 3. substring()
		System.out.println("\n3. substring()");
		System.out.println(str.substring(2));
		System.out.println(str.substring(2, 7));

		// 4. concat()
		System.out.println("\n4. concat()");
		System.out.println(str.concat("-Programming"));

		// 5. equals()
		System.out.println("\n5. equals()");
		System.out.println(str3.equals("Hello Java World"));

		// 6. equalsIgnoreCase()
		System.out.println("\n6. equalsIgnoreCase()");
		System.out.println(str3.equalsIgnoreCase(str2));

		// 7. compareTo()
		System.out.println("\n7. compareTo()");
		System.out.println(str3.compareTo("Hello"));

		// 8. compareToIgnoreCase()
		System.out.println("\n8. compareToIgnoreCase()");
		System.out.println(str3.compareToIgnoreCase(str2));

		// 9. contains()
		System.out.println("\n9. contains()");
		System.out.println(str.contains("Java"));

		// 10. startsWith()
		System.out.println("\n10. startsWith()");
		System.out.println(str.trim().startsWith("Hello"));

		// 11. endsWith()
		System.out.println("\n11. endsWith()");
		System.out.println(str.trim().endsWith("World"));

		// 12. indexOf()
		System.out.println("\n12. indexOf()");
		System.out.println(str.indexOf("Java"));

		// 13. lastIndexOf()
		System.out.println("\n13. lastIndexOf()");
		System.out.println(str.lastIndexOf("o"));

		// 14. toUpperCase()
		System.out.println("\n14. toUpperCase()");
		System.out.println(str.toUpperCase());

		// 15. toLowerCase()
		System.out.println("\n15. toLowerCase()");
		System.out.println(str.toLowerCase());

		// 16. trim()
		System.out.println("\n16. trim()");
		System.out.println(str.trim());

		// 17. strip()
		System.out.println("\n17. strip()");
		System.out.println(str.strip());

		// 18. replace()
		System.out.println("\n18. replace()");
		System.out.println(str.replace("Java", "Python"));

		// 19. replaceAll()
		System.out.println("\n19. replaceAll()");
		System.out.println(str.replaceAll("a", "@"));

		// 20. replaceFirst()
		System.out.println("\n20. replaceFirst()");
		System.out.println(str.replaceFirst("o", "O"));

		// 21. split()
		System.out.println("\n21. split()");

		String[] words = str.trim().split(" ");

		for (String word : words) {
			System.out.println(word);
		}

		// 22. isEmpty()
 		System.out.println("\n22. isEmpty()");
		System.out.println("".isEmpty());

		// 23. isBlank()
		System.out.println("\n23. isBlank()");
		System.out.println("     ".isBlank());

		// 24. matches()
		System.out.println("\n24. matches()");
		System.out.println("Java123".matches("[A-Za-z0-9]+"));

		// 25. toCharArray()
		System.out.println("\n25. toCharArray()");

		char[] chars = str.trim().toCharArray();

		for (char c : chars) {
			System.out.print(c + " ");
		}

		System.out.println();

		// 26. getBytes()
		System.out.println("\n26. getBytes()");

		byte[] bytes = str.getBytes();

		for (byte b : bytes) {
			System.out.print(b + " ");
		}

		System.out.println();

		// 27. intern()
		System.out.println("\n27. intern()");

		String s1 = new String("Java");
		String s2 = s1.intern();

		System.out.println(s1 == s2); // false
		System.out.println(s2 == "Java"); // true

		// 28. repeat()
		System.out.println("\n28. repeat()");
		System.out.println("Hi ".repeat(3));

		// 29. join()
		System.out.println("\n29. join()");
		String joined = String.join("-", "Java", "Python", "C++");
		System.out.println(joined);

		// 30. valueOf()
		System.out.println("\n30. valueOf()");
		int number = 100;
		String numberString = String.valueOf(number);
		System.out.println(numberString);

		// 31. format()
		System.out.println("\n31. format()");
		String formatted = String.format("Name: %s, Age: %d", "John", 25);
		System.out.println(formatted);

		// 32. subSequence()
		System.out.println("\n32. subSequence()");
		CharSequence seq = str.trim().subSequence(0, 5);
		System.out.println(seq);

		// 33. contentEquals()
		System.out.println("\n33. contentEquals()");
		System.out.println(str3.contentEquals("Hello Java World"));

		// 34. hashCode()
		System.out.println("\n34. hashCode()");
		System.out.println(str3.hashCode());

		// 35. codePointAt()
		System.out.println("\n35. codePointAt()");
		System.out.println(str3.codePointAt(0));

		// 36. codePointBefore()
		System.out.println("\n36. codePointBefore()");
		System.out.println(str3.codePointBefore(1));

		// 37. codePointCount()
		System.out.println("\n37. codePointCount()");
		System.out.println(str3.codePointCount(0, str3.length()));

		// 38. offsetByCodePoints()
		System.out.println("\n38. offsetByCodePoints()");
		System.out.println(str3.offsetByCodePoints(0, 5));

		// ===============================
		// Extra Examples
		// ===============================
		System.out.println("\nExtra Examples");

		System.out.println("Upper Case : " + str3.toUpperCase());
		System.out.println("Lower Case : " + str3.toLowerCase());
		System.out.println("Length     : " + str3.length());
		System.out.println("Contains   : " + str3.contains("Java"));
		System.out.println("Replace    : " + str3.replace("Java", "Python"));
		System.out.println("Substring  : " + str3.substring(6));

	}

}

/*
 * String Methods length() charAt() substring() concat() equals()
 * equalsIgnoreCase() compareTo() compareToIgnoreCase() contains() startsWith()
 * endsWith() indexOf() lastIndexOf() toUpperCase() toLowerCase() trim() strip()
 * replace() replaceAll() replaceFirst() split() isEmpty() isBlank() matches()
 * toCharArray() getBytes() intern() repeat() join() valueOf() format()
 * subSequence() contentEquals() hashCode() codePointAt() codePointBefore()
 * codePointCount() offsetByCodePoints()
 */
