package Domain;

import java.util.ArrayList;

public class Department {
    private int departmentID;
    private static int nextID = 1;
    private String name;

    public Department(String name) {
        this.name = name;
        this.departmentID = nextID++;
    }
    @Override
    public String toString() {
        return "Department{" +
                "departmentID=" + departmentID +
                ", name='" + name + '\'' +
                '}';
    }
    public int getDepartmentID() {
        return departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
