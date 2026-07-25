package object_oriented_programming;

public class Polymorphism {

	public static void main(String[] args) {
		Add obj = new Add();
		obj.abc();
		System.out.println(obj.abc("vijay", "trisha"));
		SubClass obj1 = new SubClass();
		obj1.abc();
	}

}

//Compile-Time Polymorphism: (Method Overloading)
//Same method name with different parameter lists.
class Add {  
	public void abc() {
		System.out.println("hii");
	}
	
	public int abc (int a, int b) {
		return a+b;
	}
	public int abc (int a, int b, int c) {
		return a+b+c;
	}
	public String abc (String a, String b) {
		return a+" "+b;
	}
}

//Runtime Polymorphism: (Method Overriding)
// A subclass provides its own implementation of a method from the parent class.
class SubClass extends Add {
	@Override
	public void abc() {
		System.out.println("Override: hello");
	}
	public String abc (String a, String b) {
		return a+" "+b;
	}
}











