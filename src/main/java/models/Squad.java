package models;

import java.util.ArrayList;
import java.util.Objects;

public class Squad {

    private String name;
    private int size;
    private String cause;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private  ArrayList<Hero> heroes  = new ArrayList<>();
    private int members;
    private int id;

    public Squad(String name, int size, String cause) {
        this.name = name;
        this.size = size;
        this.cause = cause;
        this.members = 0;
        instances.add(this);
        id = instances.size();
    }

    public int getId() {
        return id;
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

    public void addHeroes(Hero hero) {

        if (heroes.size() < this.size)
            heroes.add(hero);
        else System.out.println("Squad is full");

    }

    public int getMembers() {
        return heroes.size();
    }

    public  ArrayList<Hero> allHeroes() {

        return this.heroes;
    }

    public static Squad find(String name) {

        for (int i = 0; i < instances.size(); i++) {
            if (instances.get(i).getName().contains(name)) {
                return instances.get(i);
            }
        }
        return null;
    }

    public static Squad findById(int id){
        return instances.get(id -1 );
    }


    public static void clearAll() {
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
