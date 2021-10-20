package studentManager.managerService;


import studentManager.model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ManagerServiceStudent studentList = new ManagerServiceStudent();

        int choice = -1;
        showMenu();
        do {
            Scanner input = new Scanner(System.in);
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Nhập lại số đi");
                input.nextLine();
                choice = -1;
            } finally {
                switch (choice) {
                    case 1:
                        studentList.add(createStudent());
                        studentList.print();

                        break;
                    case 2:
                        studentList.print();

                        break;
                    case 3:
                        System.out.println("Điền vị trí muốn sửa");
                        int index1 = input.nextInt();
                        studentList.updateByID(index1, createStudent());
                        studentList.print();

                        break;
                    case 4:
                        System.out.println("Nhập id học sinh muốn xóa ");
                        int index2 = input.nextInt();
                        studentList.deleteByID(index2);
                        studentList.print();

                        break;
                    case 5:
                        System.out.println("Nhập id học sinh muốn tìm ");
                        input.nextLine();
                        int idToFind = input.nextInt();
                        int indexToFind = studentList.findByID(idToFind);
                        if (indexToFind != -1) {
                            System.out.println(studentList.getStudentArray().get(indexToFind));
                        } else System.out.println("Ko tìm thấy");
                        System.out.println("=========================");
                        studentList.print();

                        break;
                    case 6:
                        studentList.sortMinToMax();
                        studentList.print();

                        break;
                    case 7:
                        studentList.sortMaxToMin();
                        studentList.print();

                        break;
                    case 8:
                        System.out.println("Tổng điểm bằng " + studentList.totalScore());

                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
                }
              showMenu();
            }
        }while (true);
    }
    public static void showMenu(){
        System.out.println("Menu");
        System.out.println("1. Thêm học sinh ");
        System.out.println("2. Hiển thị mọi người trong danh sách");
        System.out.println("3. Sửa thông tin học sinh");
        System.out.println("4. Xóa học sinh ");
        System.out.println("5. Tìm học sinh theo mã ");
        System.out.println("6. Sắp xếp các học sinh từ bé đến lớn theo điểm trung bình ");
        System.out.println("7. Sắp xếp các học sinh từ lớn đến bé theo điểm trung bình ");
        System.out.println("8. Tính tổng điểm trung bình ");
        System.out.println("0. Thoát ");
        System.out.println("Điền lựa chọn: ");
        System.out.println("=========================");
    }


    public static Student createStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Điền tên của học sinh ");
        String name = scanner.nextLine();
        System.out.println("Điền tuổi của học sinh ");
        int age = scanner.nextInt();
        System.out.println("Điền điểm trung bình của sản phẩm ");
        double score = scanner.nextDouble();
        return new Student(name,age,score);
    }
}
