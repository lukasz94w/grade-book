import exception.SubjectException;

import java.util.Map;

class GradeBook {
    private final Map<String, Subject> subjects;

    public GradeBook(Map<String, Subject> subjects) {
        this.subjects = subjects;
    }

    public void addNewSubject(Subject newSubject) {
        subjects.put(newSubject.getName(), newSubject);
    }

    public Integer getNumberOfSubjects() {
        return subjects.size();
    }

    public Subject findSubjectByName(String name) {
        return subjects.get(name);
    }

    public void addGradeBySubjectName(String subjectName, Integer grade) {
        verifySubjectExist(subjectName);
        Subject subject = subjects.get(subjectName);
        subject.addNewGrade(grade);
    }

    private void verifySubjectExist(String name) {
        if (!subjects.containsKey(name)) {
            // TODO write test
            throw new SubjectException("Such subject doesn't exist!");
        }
    }

    public double getAverageForAllSubjects() {
        int totalSum = 0;
        int totalNumberOfGrades = 0;
        for (Subject subject : subjects.values()) {
            totalSum += subject.getSumOfGrades();
            totalNumberOfGrades += subject.getGrades().size();
        }
        return (double) totalSum / totalNumberOfGrades;
    }
}
