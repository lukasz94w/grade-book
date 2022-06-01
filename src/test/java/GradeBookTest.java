import exception.SubjectException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GradeBookTest {

    private GradeBook gradeBook;

    @BeforeEach
    void prepareCleanGradeBook() {
        this.gradeBook = new GradeBook(new HashMap<>());
    }

    @Test
    void shouldCreateGradeBook() {
        GradeBook gradeBook = new GradeBook(new HashMap<>());
        assertNotNull(gradeBook);
    }

    @Test
    void shouldAddSubjectToGradeBook() {
        Subject chemistry = new Subject("Chemistry", new ArrayList<>());

        assertEquals(0, gradeBook.getNumberOfSubjects());

        gradeBook.addNewSubject(chemistry);
        assertEquals(1, gradeBook.getNumberOfSubjects());
        assertEquals(chemistry, gradeBook.findSubjectByName(chemistry.getName()));

        gradeBook.addNewSubject(chemistry);
        assertEquals(1, gradeBook.getNumberOfSubjects());
    }

    @Test
    void shouldGetSubjectFromGradeBook() {
        // given
        Subject biology = new Subject("Biology", new ArrayList<>());

        // when
        gradeBook.addNewSubject(biology);

        // then
        assertEquals(biology, gradeBook.findSubjectByName("Biology"));
    }

    @Test
    void shouldAddGradeToSubject() {
        Subject philosophy = new Subject("Philosophy", new ArrayList<>());
        philosophy.addNewGrade(5);
        assertEquals(philosophy.getGrades().get(0), 5);
        philosophy.addNewGrade(4);
        assertEquals(2, philosophy.getGrades().size());
    }

    @Test
    void shouldRemoveGradeFromSubject() {
        Subject philosophy = new Subject("Philosophy", new ArrayList<>());
        philosophy.addNewGrade(5);
        philosophy.addNewGrade(4);
        philosophy.removeGrade(5);
        philosophy.removeGrade(4);
        assertEquals(0, philosophy.getGrades().size());
    }

    @Test
    void shouldThrownExceptionsWithBadGradesValues() {
        // given
        Subject history = new Subject("History", new ArrayList<>());

        // when, then
        assertThatThrownBy(() -> history.addNewGrade(-2))
                .isInstanceOf(SubjectException.class)
                .hasMessageContaining("Incorrect grade value");

        assertThatThrownBy(() -> history.addNewGrade(7))
                .isInstanceOf(SubjectException.class)
                .hasMessageContaining("Incorrect grade value");
    }

    @Test
    void shouldCalculateAverageForAllSubjects() {
        // given
        Subject physics = new Subject("Physics", Arrays.asList(1, 3, 5));
        Subject greek = new Subject("Greek", Arrays.asList(3, 4, 5));
        Subject chemistry = new Subject("Chemistry", Arrays.asList(4, 5, 6));

        // when
        gradeBook.addNewSubject(physics);
        gradeBook.addNewSubject(greek);
        gradeBook.addNewSubject(chemistry);

        // then
        assertEquals(4, gradeBook.getAverageForAllSubjects());
    }

    @Test
    void shouldAddGradeBySubject() {
        gradeBook.addNewSubject(new Subject("History", new ArrayList<>()));
        gradeBook.addGradeBySubjectName("History", 5);
        // not the best checking...
        assertEquals(5, gradeBook.getAverageForAllSubjects());
    }
}