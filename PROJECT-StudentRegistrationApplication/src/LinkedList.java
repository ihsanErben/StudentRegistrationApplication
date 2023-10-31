
import java.util.Scanner;

public class LinkedList {

    Node first = null;
    Node last = null;
    Scanner input = new Scanner(System.in);

    public void insert() {
        System.out.print("Choose an option:   1 - first     2 - last     :");
        int option = input.nextInt();
        System.out.println("");
        System.out.println("enter the new student informations: ");
        System.out.print("name: ");
        String name = input.next();
        System.out.print("id: ");
        int id = input.nextInt();
        System.out.print("midterm: ");
        int midtermExam = input.nextInt();
        System.out.print("final: ");
        int finalExam = input.nextInt();

        Node newNode = new Node(name, id, midtermExam, finalExam);

        switch (option) {
            case 1:
                if (first == null) {
                    first = newNode;
                    last = newNode;
                    System.out.println("First Student was added to the system.");
                } else {
                    newNode.next = first;
                    first = newNode;
                    System.out.println("Student was added to the system.");
                }
                break;
            case 2:
                if (first == null) {
                    first = newNode;
                    last = newNode;
                    System.out.println("First Student was added to the system.");
                } else {
                    last.next = newNode;
                    last = newNode;
                    System.out.println("Student was added to the system.");
                }
                break;
            default:
                System.out.println("invalid value.");
                break;
        }
    }

    public void remove() {

        if (first == null) {
            System.out.println("It is empty.");
        } else if (first == last) {
            first = null;
            last = null;
            System.out.println("The last of student in list was deleted.");
            return;
        } else {
            System.out.print("Choose an option:   1 - first     2 - last     3 - with id    :");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    first = first.next;
                    first.prev = null;
                    System.out.println("Student was deleted.");
                    break;
                case 2:
                    last = last.prev;
                    last.next = null;
                    System.out.println("Student was deleted.");
                    break;
                case 3:
                    System.out.print("Enter the id of the student you want to delete from the system: ");
                    int id = input.nextInt();
                    if (first == last && first.id == id) {
                        first = null;
                        last = null;
                        System.out.println("Student was deleted.");
                        return;
                    } else if (first.next == last && first.id == id) {
                        first = first.next;
                        first.prev = null;
                        System.out.println("Student was deleted.");
                        return;
                    } else if (first.next == last && last.id == id) {
                        last = last.prev;
                        System.out.println("Student was deleted.");
                        return;
                    } else {
                        Node tmp = first;
                        while (tmp != null) {
                            if (tmp.id == id) {

                                if (tmp == first) {
                                    first = first.next;
                                    first.prev = null;
                                    System.out.println("Student was deleted.");
                                    return;
                                } else if (tmp == last) {
                                    last.prev = last;
                                    last.next = null;
                                    System.out.println("Student was deleted.");
                                    return;
                                } else {
                                    Node c = tmp.prev;
                                    c.next = tmp.next;
                                    tmp.next.prev = c;
                                    tmp.prev = null;
                                    tmp.next = null;
                                    System.out.println("Student was deleted.");
                                    return;
                                }
                            }
                            tmp = tmp.next;
                        }
                        System.out.println("There is no such id: " + id);
                        return;
                    }

                default:
                    System.out.println("invalid value.");
                    return;
            }
        }
    }

    public void printStudentList() {
        System.out.println("----------------------------------------------");
        if (first == null) {
            System.out.println("There is no student");
        } else {
            Node tmp = first;
            while (tmp != null) {
                System.out.println("name: " + tmp.name);
                System.out.println("id: " + tmp.id);
                System.out.println("midterm: " + tmp.midtermExam);
                System.out.println("final: " + tmp.finalExam);
                System.out.println("average: " + tmp.average);
                System.out.println("status: " + tmp.status);
                System.out.println("----------------------------------------------");
                tmp = tmp.next;
            }
        }
    }

    public void printBestStudent() {
        if (first == null) {
            System.out.println("There is no student");
        } else {
            Node tmp = first;
            Node bestS = first;
            double bestA = 0;
            while (tmp != null) {
                if (tmp.average >= bestA) {
                    bestA = tmp.average;
                    bestS = tmp;
                }
                tmp = tmp.next;
            }
            System.out.println("The best student informations:");
            System.out.println("name: " + bestS.name);
            System.out.println("id: " + bestS.id);
            System.out.println("midterm: " + bestS.midtermExam);
            System.out.println("final: " + bestS.finalExam);
            System.out.println("average: " + bestS.average);
            System.out.println("status: " + bestS.status);
            System.out.println("----------------------------------------------");

        }

    }

    public int sizeOfList() {
        Node tmp = first;
        int size = 0;
        while (tmp != null) {
            size++;
            tmp = tmp.next;
        }
        return size;
    }
}
