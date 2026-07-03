package object_oriented_programming;

public class Constructors {

	public static void main(String[] args) {
//		Demo object = new Demo();
		Demo1 object = new Demo1(10,20);
		object.display();

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
	
	public void display() {
		System.out.println(a + " " + b);
	}

}







