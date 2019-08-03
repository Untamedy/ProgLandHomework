package javaOOP.homework_8.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YBolshakova
 */
public class GroupOfStudent implements Serializable {

    private List<Student> list;
    private int number;
    private int groupSize;

    public GroupOfStudent() {
    }

    public GroupOfStudent(int number, int groupSize) {
        this.number = number;
        this.groupSize = groupSize;
        this.list = new ArrayList<>();
    }

    public List<Student> getList() {
        return list;
    }

    public void setList(List<Student> list) {
        this.list = list;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGroupSize() {
        return groupSize;
    }

    public void addStudent(Student student) {
        student.setGroupNumber(this.number);
        list.add(student);
    }

    public boolean isFull() {
        return list.size() == this.groupSize;
    }
    
    @Override
    public String toString(){
        String info = "Group №_" + number + "\n";
        for(Student s: this.list){
           info = info + s.toString() + "\n";
        }
        return  info;
    }

}
