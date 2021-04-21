package classroomPack;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    public int capacity;
    public List<Student> students;

    public Classroom(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>(capacity);
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public String registerStudent(Student student) {
        String text = "";
        if (students.contains(student)) {
            text = "Student is already in the classroom";
        } else {
            if (students.size() + 1 > capacity) {
                text = "No seats in the classroom";
            } else {
                students.add(student);
                text = String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            }
        }
        return text;
    }

    public String dismissStudent(Student student) {
        String text = "";
        if (students.contains(student)) {
            text = String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
            students.remove(student);

        } else {
            text = "Student not found";
        }
        return text;
    }

    public String getSubjectInfo(String subject) {
        boolean hasStudent = false;
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            if (student.getBestSubject().equals(subject)) {

                hasStudent = true;

                break;
            }

        }
        if (hasStudent) {
            sb.append(String.format("Subject: %s%n", subject)).append("Students:");
            for (Student student : students) {
                if (student.getBestSubject().equals(subject)) {
                    sb.append(String.format("%n%s %s", student.getFirstName(), student.getLastName()));

                }

            }
            return sb.toString();
        }
        return "No students enrolled for the subject";
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }

        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Classroom size: %d%n", students.size()));
        for (Student student : students) {
            sb.append(String.format("==Student: First Name= %s, Last Name= %s, Best Subject= %s%n", student.getFirstName(), student.getLastName(), student.getBestSubject()));

        }

        return sb.toString();
    }

}




