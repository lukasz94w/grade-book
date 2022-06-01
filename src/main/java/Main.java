import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        GradeBook gradeBook = new GradeBook(new HashMap<>());
        gradeBook.addNewSubject(new Subject("History", new ArrayList<>()));
        gradeBook.addGradeBySubjectName("History", 5);
        gradeBook.addGradeBySubjectName("History", 3);
        System.out.println(gradeBook.findSubjectByName("History"));
        System.out.println("Average for history: " + gradeBook.getAverageForAllSubjects());
    }
}
