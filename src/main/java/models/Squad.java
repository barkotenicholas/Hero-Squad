package models;

import java.util.ArrayList;
import java.util.Objects;

public class Squad {

    private String name;
    private int size;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>();
    public Squad(String name,int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
        instances.add(this);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public String getCause() {
        return cause;
    }

    public static ArrayList<Squad> getAll() {
        return instances;
    }

    public  static void clearAll(){
        instances.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Squad squad = (Squad) o;
        return size == squad.size && Objects.equals(name, squad.name) && Objects.equals(cause, squad.cause);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size, cause);
    }
}
