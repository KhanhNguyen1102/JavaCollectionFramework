package studentManager.managerService;

import studentManager.model.Teacher;

import java.util.ArrayList;

public class ManagerServiceTeacher extends ManagerServicePerson{
    public ArrayList<Teacher> findBySubjectName(String subject){
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (int i = 0; i < super.getPersonArray().size(); i++) {
            Teacher teacher = (Teacher) super.getPersonArray().get(i);
            if(teacher.getSubject().equals(subject)){
                teachers.add(teacher);
            }
        }
        return teachers;
    }
}
