import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SubjectTest {

    @Test
    void shouldCreateNewSubject() {
        Subject physics = new Subject("Physics", new ArrayList<>());
        assertNotNull(physics);
        assertEquals(physics.getName(), "Physics");
        assertEquals(physics.getGrades(), new ArrayList<>());
    }

    @Test
    void shouldReturnValidGradesList() {
        // given
        Subject math = new Subject("Math", new ArrayList<>());
        List<Integer> gradesToAdd = Arrays.asList(1, 2, 3);

        // when
        math.addGrades(gradesToAdd);

        // then
        assertEquals(Arrays.asList(1, 2, 3), math.getGrades());
    }

    @Test
    void shouldCalculateAverage() {
        Subject english = new Subject("English", Arrays.asList(1, 3, 5, 6));
        assertEquals(3.75, english.calculateAverage());
    }
}