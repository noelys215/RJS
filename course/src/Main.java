public class Main {
    public static void main(String[] args) {

        isEven(11);




    }
    private static void isEven(int num) {
        if (num % 2 == 0){
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }
}