package common.modal;

public class Student {

    int id;
    String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean equals(Object o) {
        System.out.println("Inside Equals ====>");
        if(o != null && o instanceof Student) {
            String studentName = ((Student) o).name;
            if(studentName != null && studentName.equals(this.name)){
                return true;
            }
        }
        return false;
    }

    public int hashCode () {
        System.out.println("Inside HashCode ###");
        return this.name.hashCode();
    }


}

