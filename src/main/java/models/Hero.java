package models;

public class Hero {

    private String name;
    private int age;
    private String strength;
    public Hero(String name,int age,String strength) {
        this.name = name;
        this.age = age;
        this.strength=strength;
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
}
