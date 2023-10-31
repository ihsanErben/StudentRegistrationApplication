
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList x = new LinkedList();
        boolean cikis = false;
        while (cikis == false) {
            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.println("0 - exit");
            System.out.println("1 - insert");
            System.out.println("2 - remove");
            System.out.println("3 - print all students");
            System.out.println("4 - print best student");
            System.out.print("choose an action: ");
            int action = input.nextInt();
            System.out.println("");
            switch (action) {
                case 0:
                    cikis = true;
                    break;
                case 1:
                    x.insert();
                    break;
                case 2:
                    x.remove();
                    break;
                case 3:
                    x.printStudentList();
                    break;
                case 4:
                    x.printBestStudent();
                    break;
                default:
                    System.out.println("Invalid Value.");
                    break;
            }
            System.out.println("");
        }

    }
}
