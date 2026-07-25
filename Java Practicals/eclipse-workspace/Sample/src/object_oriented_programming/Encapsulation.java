package object_oriented_programming;

public class Encapsulation {

	public static void main(String[] args) {
		Test object = new Test();
		object.setValue(5, "affa");
		System.out.println(object.geta() + " " + object.getb());
	}
}

class Test {
	private int a;
	private String b;

	public void setValue(int a, String b) {
		this.a = a;
		this.b = b;
	}

	public int geta() {
		return a;
	}
	public String getb() {
		return b;
	}
}
