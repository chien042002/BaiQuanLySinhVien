package BangDanhSach;

import Dao.DanhSachSinhVienDAO;
import Model.DanhSachSinhVien;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private DanhSachSinhVienDAO Dao;
    private Scanner scanner;

    public Menu() {
        Dao = DanhSachSinhVienDAO.GetInstance();
        scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        int choice = 0;

        do {
            System.out.println("------- MENU -------");
            System.out.println("1. Insert student");
            System.out.println("2. Update student");
            System.out.println("3. Delete student");
            System.out.println("4.deleteStudentnhohon5");
            System.out.println("5. View all students");
            System.out.println("6. Search student by name");
            System.out.println("7. Exit");

            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    insertStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    deleteStudentnhohon5();
                    break;
                case 5:
                    viewAllStudents();
                    break;
                case 6:
                    searchStudentByName();
                    break;
                case 7:
                    System.out.println("thoát khỏi chương trình...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ Vui lòng thử lại.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    private void insertStudent() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        if (name.matches(".*\\d+.*")) {
            System.out.println("Tên không hợp lệ! Tên không được chứa số.");
            return;
        }

        System.out.print("Nhập tuổi sinh viên: ");
        String ageInput = scanner.next();


        if (!ageInput.matches("\\d+")) {
            System.out.println("Tuổi không hợp lệ! Tuổi phải là một số nguyên dương.");
            return;
        }
        int age = Integer.parseInt(ageInput);

        System.out.print("Nhập địa chỉ sinh viên: ");
        String address = scanner.next();

        System.out.print("Nhập hạnh kiểm sinh viên: ");
        String conduct = scanner.next();

        System.out.println("Nhập Điểm sinh viên: ");
        float point=scanner.nextFloat();


        DanhSachSinhVien student = new DanhSachSinhVien(name, age, address, conduct,(int) point );


        if (Dao.SelectById(student) != null) {
            System.out.println("Sinh viên đã tồn tại! Không thể chèn sinh viên trùng lặp.");
            return;
        }


        int result = Dao.Insert(student);
        if (result > 0) {
            System.out.println("Sinh viên được chèn thành công!");
        } else {
            System.out.println("Không thể chèn sinh viên.");
        }
    }

    private void updateStudent() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        DanhSachSinhVien student = new DanhSachSinhVien(name, 0, "", "",0);

        student = Dao.SelectById(student);

        if (student != null) {

            System.out.print("Nhập tuổi sinh viên: ");
            int age = scanner.nextInt();
            System.out.print("Nhập địa chỉ sinh viên: ");
            String address = scanner.next();
            System.out.print("Nhập hạnh kiểm sinh viên: ");
            String conduct = scanner.next();


            student.setTuoi(age);
            student.setDiachi(address);
            student.setHanhkiem(conduct);

            int result = Dao.Update(student);
            if (result > 0) {
                System.out.println("Sinh viên được cập nhật thành công!");
            } else {
                System.out.println("Không cập nhật được sinh viên.");
            }
        } else {
            System.out.println("không tìm thấy sinh viên!");
        }
    }

    private void deleteStudent() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        DanhSachSinhVien student = new DanhSachSinhVien(name, 0, "", "",0);

        student = Dao.SelectById(student);

        if (student != null) {

            int result = Dao.Delete(student);
            if (result > 0) {
                System.out.println("Sinh viên đã xóa thành công!");
            } else {
                System.out.println("Không xóa được sinh viên.");
            }
        } else {
            System.out.println("không tìm thấy sinh viên!");
        }
    }
    private void deleteStudentnhohon5() {
        ArrayList<DanhSachSinhVien> students = Dao.SelectAll();

        int count = 0;
        for (DanhSachSinhVien student : students) {
            if (student.getTuoi() < 5) {
                int result = Dao.Delete(student);
                if (result > 0) {
                    count++;
                }
            }
        }

        if (count > 0) {
            System.out.println("Đã xóa " + count + " sinh viên có điểm nhỏ hơn 5.");
        } else {
            System.out.println("Không tìm thấy sinh viên nào có điểm nhỏ hơn 5.");
        }
    }

    private void viewAllStudents() {

        ArrayList<DanhSachSinhVien> students = Dao.SelectAll();


        if (!students.isEmpty()) {
            System.out.println("------- STUDENTS -------");
            for (DanhSachSinhVien student : students) {
                displayStudentDetails(student);
            }
            System.out.println("------------------------");
        } else {
            System.out.println("Không tìm thấy sinh viên nào!");
        }
    }

    private void displayStudentDetails(DanhSachSinhVien student) {
    }

    private void searchStudentByName() {

        System.out.print("Nhập tên sinh viên: ");
        String name = scanner.next();


        DanhSachSinhVien student = new DanhSachSinhVien(name, 0, "", "",0);
        DanhSachSinhVien result = Dao.SelectById(student);

        if (result != null) {
            System.out.println("sinh viên được tìm thấy: " + result);
        } else {
            System.out.println("không tìm thấy sinh viên.");
        }
    }
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
