package tricon;

import java.util.Objects;

public class Student {
    private String name;

    public Student(String name, String roll_number) {
        this.name = name;
        this.roll_number = roll_number;
    }

    private String roll_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(String roll_number) {
        this.roll_number = roll_number;
    }

    @Override
    public String toString() {
        return this.name+" "+this.roll_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return name.equals(student.name) &&
                roll_number.equals(student.roll_number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roll_number);
    }
}
