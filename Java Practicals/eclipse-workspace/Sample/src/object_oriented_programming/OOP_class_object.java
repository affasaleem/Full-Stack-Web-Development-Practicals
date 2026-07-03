package object_oriented_programming;


public class OOP_class_object {

	public static void main(String[] args) {
		OOP_class_object object =  new OOP_class_object();
		System.out.println(object.add("vijay "));
	}
	
	public String add(String name) {
		return name + "welcome!";
	}

}
