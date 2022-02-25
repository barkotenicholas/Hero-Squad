package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hero {

    private String name;
    private int age;
    private String strength;
    private String weakness;
    private static final ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name,int age,String strength,String weakness) {
        this.name = name;
        this.age = age;
        this.strength = strength;
        this.weakness = weakness;
        instances.add(this);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStrength() {
        return strength;
    }

    public String getWeakness() {
        return weakness;
    }

    public static ArrayList<Hero> getAll () {
        return (ArrayList<Hero>) instances;
    }


    public static void clearAll(){
        instances.clear();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return age == hero.age && Objects.equals(name, hero.name) && Objects.equals(strength, hero.strength) && Objects.equals(weakness, hero.weakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, strength, weakness);
    }


}
