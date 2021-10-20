package studentManager.managerService;

import studentManager.model.Student;

import java.util.ArrayList;
import java.util.Comparator;

public class ManagerServiceStudent implements ManagerService<Student> {
    private ArrayList<Student> studentArray;
    private static int idOfList = 0;

    public ManagerServiceStudent(ArrayList<Student> studentList) {
        this.studentArray = studentList;
    }

    public ManagerServiceStudent() {
        studentArray = new ArrayList<>();
    }

    public ArrayList<Student> getStudentArray() {
        return studentArray;
    }

    public void setStudentArray(ArrayList<Student> studentArray) {
        this.studentArray = studentArray;
    }

    @Override
    public void print() {
        for (Student student : studentArray) {
            System.out.println(student);
        }
    }

    @Override
    public void add(Student student) {
        student.setId(idOfList);
        studentArray.add(student);
        idOfList++;
        System.out.println("Đã thêm thành công");
    }

    @Override
    public int findByID(int id) {
        for (int i = 0; i < studentArray.size(); i++) {
            if (studentArray.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void deleteByID(int id) {
        int index = findByID(id);
        if (index != -1) {
            studentArray.remove(index);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy id này");
        }
    }

    @Override
    public void updateByID(int id, Student student) {
        int index = findByID(id);
        if (index != -1) {
            studentArray.set(index, student);
            System.out.println("Đã cập nhật thành công");
        } else {
            System.out.println("Không tìm thấy id này ");
        }
    }

    @Override
    public void sortMinToMax() {
        studentArray.sort((Comparator.comparingDouble(Student::getAverageScore)));
        System.out.println("Đã sắp xếp thành công");
    }

    @Override
    public void sortMaxToMin() {
        studentArray.sort((o1, o2) -> Double.compare(o2.getAverageScore(), o1.getAverageScore()));
        System.out.println("Đã sắp xếp thành công !");
    }

    @Override
    public double totalScore() {
        double totalscore = 0;
        for (Student student : studentArray) {
            totalscore += student.getAverageScore();
        }
        return totalscore;
    }
}
