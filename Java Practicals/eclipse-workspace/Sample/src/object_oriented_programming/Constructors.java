package object_oriented_programming;

public class Constructors {

	public static void main(String[] args) {
//		Demo object = new Demo();
		Demo1 object1 = new Demo1(10,20);
		object1.display();
		Demo1 object2 = new Demo1(object1);
		object2.display();

	}
}
// DEFAULT & NO-ARGUMENT CONSTRUCTOR
/*class Demo {		//Default Constructor
	public Demo() {
		System.out.println("hii");  //No-Argument Constructor if i am not write here it's default constructor
	}
}*/

// ARGUMENT CONSTRUTOR
class Demo1 {
	int a;
	int b;
	public Demo1(int a,int b) {
		this.a=a;
		this.b=b;
	}
	
//	COPY CONSTRUTOR
	public Demo1(Demo1 obj) {
		this.a=obj.a;
		this.b=obj.b;
	}
	
	public void display() {
		System.out.println(a + " " + b);
	}

}







