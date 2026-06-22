public class if_else {
    public static void main(String[] args) {
        int mark = 55;
        if (mark <= 35){
            System.out.println("D");
        }
        else if (mark <= 50){
            System.out.println("C");
        }
        else if (mark <= 85){
            System.out.println("B");
        }
        else if (mark <= 100){
            System.out.println("A");
        }
        else{
            System.out.println("invalid marks");
        }
    }
}
