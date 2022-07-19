package common.interview;

import java.util.HashMap;
import java.util.Map;

import common.modal.RecordNote;
import common.modal.Student;

public class EqualsHashCode {

    public static void main(String args[]){

        Student s1 = new Student("karthigeyan");
        Student s2 = new Student("karthigeyan");

        Map  record = new HashMap<Student,RecordNote>();
        record.put(s1, new RecordNote());
        record.put(s2, new RecordNote());


        System.out.println(s1.equals(s2));
        System.out.println(record.size());

    }
}
