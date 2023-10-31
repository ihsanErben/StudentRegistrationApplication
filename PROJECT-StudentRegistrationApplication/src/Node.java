
public class Node {

    String name;
    int id;
    int midtermExam;
    int finalExam;
    double average;
    String status;

    Node next;
    Node prev;

    public Node(String name, int id, int midtermExam, int finalExam) {
        this.name = name;
        this.id = id;
        this.midtermExam = midtermExam;
        this.finalExam = finalExam;

        average = (midtermExam * 0.4 + finalExam * 0.6);

        if (average >= 50) {
            status = "passed";
        } else {
            status = "failed";
        }

        next = null;
    }

}
