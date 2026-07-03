package string_package;

public class stringBuffer_methods {

	public static void main(String[] args) {

		        // Create a StringBuffer object
		        StringBuffer sb = new StringBuffer("Hello");

		        System.out.println("Original StringBuffer : " + sb);

		        // 1. append()
		        // Adds text at the end
		        // ===================================================
		        sb.append(" Java");
		        System.out.println("\n1. append()");
		        System.out.println(sb);

		        // 2. insert()
		        // Inserts text at a specific index
		        // ===================================================
		        sb.insert(6, "Awesome ");
		        System.out.println("\n2. insert()");
		        System.out.println(sb);

		        // 3. replace()
		        // Replaces characters between indexes
		        // ===================================================
		        sb.replace(6, 13, "Beautiful ");
		        System.out.println("\n3. replace()");
		        System.out.println(sb);

		        // 4. delete()
		        // Deletes characters between indexes
		        // ===================================================
		        sb.delete(6, 16);
		        System.out.println("\n4. delete()");
		        System.out.println(sb);

		        // 5. deleteCharAt()
		        // Deletes a character at the given index
		        // ===================================================
		        sb.deleteCharAt(5); //give 4 to check the real result
		        System.out.println("\n5. deleteCharAt()");
		        System.out.println(sb);

		        // 6. reverse()
		        // Reverses the string
		        // ===================================================
		        sb.reverse();
		        System.out.println("\n6. reverse()");
		        System.out.println(sb);

		        // Reverse again to restore original
		        sb.reverse();
		        System.out.println("restore original: " + sb);

		        // 7. capacity()
		        // Returns current buffer capacity
		        // ===================================================
		        System.out.println("\n7. capacity()");
		        System.out.println(sb.capacity());

		        // 8. ensureCapacity()
		        // Increases capacity if needed
		        // ===================================================
		        sb.ensureCapacity(50);
		        System.out.println("\n8. ensureCapacity()");
		        System.out.println(sb.capacity());

		        // 9. length()
		        // Returns number of characters
		        // ===================================================
		        System.out.println("\n9. length()");
		        System.out.println(sb.length());

		        // 10. charAt()
		        // Returns character at index
		        // ===================================================
		        System.out.println("\n10. charAt()");
		        System.out.println(sb.charAt(1));

		        // 11. setCharAt()
		        // Changes character at index
		        // ===================================================
		        sb.setCharAt(0, 'h');
		        System.out.println("\n11. setCharAt()");
		        System.out.println(sb);

		        // 12. substring()
		        // Returns part of the StringBuffer as String
		        // ===================================================
		        System.out.println("\n12. substring()");
		        System.out.println(sb.substring(0, 5));

		        // 13. indexOf()
		        // Returns first occurrence
		        // ===================================================
		        System.out.println("\n13. indexOf()");
		        System.out.println(sb.indexOf("Java"));

		        // 14. lastIndexOf()
		        // Returns last occurrence
		        // ===================================================
		        sb.append(" Java");
		        System.out.println("\n14. lastIndexOf()");
		        System.out.println(sb.lastIndexOf("Java"));

		        // 15. toString()
		        // Converts StringBuffer to String
		        // ===================================================
		        System.out.println("\n15. toString()");
		        String text = sb.toString();
		        System.out.println(text);

		        // ===================================================
		        // Final Output
		        // ===================================================
		        System.out.println("\nFinal StringBuffer : " + sb);
		    }
		

}

/*
 * append() insert() replace() delete() deleteCharAt() reverse() capacity()
 * ensureCapacity() length() charAt() setCharAt() substring() indexOf()
 * lastIndexOf() toString()
 */