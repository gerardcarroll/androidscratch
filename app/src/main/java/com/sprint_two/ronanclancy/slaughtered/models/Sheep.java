package com.sprint_two.ronanclancy.slaughtered.models;

/**
 * Sheep model
 * <p/>
 * Created by ronanclancy on 1/13/16.
 */
public class Sheep {

    public int id;
    public String name;
    public String age;
    public String weight;
    public int photoId;
    public int alive; // 0 alive, 1 dead

    public Sheep() {
    }

    public Sheep(int id, String name, String age, String weight, int photoId, int alive) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.photoId = photoId;
        this.alive = alive;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getAlive() {
        return alive;
    }

    public void setAlive(int alive) {
        this.alive = alive;
    }
}
