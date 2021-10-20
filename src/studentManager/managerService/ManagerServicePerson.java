package studentManager.managerService;

import studentManager.model.Person;
import studentManager.model.Student;

import java.util.ArrayList;

public class ManagerServicePerson implements ManagerService<Person>{
    private ArrayList<Person> personArray;
    private static int idOfList = 0;

    public ManagerServicePerson(ArrayList<Person> personArray) {
        this.personArray = personArray;
    }

    public ManagerServicePerson() {
        personArray = new ArrayList<>();
    }

    @Override
    public void print() {
        for (Person person : personArray) {
            System.out.println(person);
        }
    }

    @Override
    public void add(Person person) {
        person.setId(idOfList);
        personArray.add(person);
        idOfList++;
        System.out.println("Đã thêm thành công");
    }

    @Override
    public int findByID(int id) {
        for (int i = 0; i < personArray.size(); i++) {
            if (personArray.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void deleteByID(int id) {
        int index = findByID(id);
        if (index != -1) {
            personArray.remove(index);
            System.out.println("Đã xóa thành công");
        } else {
            System.out.println("Không tìm thấy id này");
        }
    }

    @Override
    public void updateByID(int id, Person person) {
        int index = findByID(id);
        if (index != -1) {
            personArray.set(index, person);
            System.out.println("Đã cập nhật thành công");
        } else {
            System.out.println("Không tìm thấy id này ");
        }
    }

}
