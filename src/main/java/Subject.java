import exception.SubjectException;

import java.util.List;

public class Subject {
    private final String name;
    private final List<Integer> grades;

    public Subject(String name, List<Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public int getSumOfGrades() {
        int totalSum = 0;
        for (Integer grade : grades) {
            totalSum += grade;
        }
        return totalSum;
    }

    public void addNewGrade(Integer grade) {
        verifyGrade(grade);
        grades.add(grade);
    }

    public void removeGrade(Integer grade) {
        verifyGrade(grade);
        grades.remove(grade);
    }

    public void addGrades(List<Integer> grades) {
        for (Integer grade : grades) {
            verifyGrade(grade);
            this.grades.add(grade);
        }
    }

    public double calculateAverage() {
        double totalSumOfGrades = 0;
        for (Integer grade : grades) {
            totalSumOfGrades += grade;
        }

        return totalSumOfGrades /  grades.size();
    }

    private void verifyGrade(Integer grade) {
        if (grade < 1 || grade > 6) {
            throw new SubjectException("Incorrect grade value");
        }
    }

    @Override
    public String toString() {
        StringBuilder gradesBuilder = new StringBuilder();
        for (Integer grade : grades) {
            gradesBuilder.append(grade).append(" ");
        }

        return "Name: " + name + ", grades: " + gradesBuilder;
    }
}
