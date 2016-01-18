package com.sprint_two.ronanclancy.slaughtered.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Sheep model
 * <p/>
 * Created by ronanclancy on 1/13/16.
 */
public class Sheep implements Parcelable {

    public int id;
    public String name;
    public String age;
    public String weight;
    public int photoId;
    public int alive; // 0 alive, 1 dead

    public Sheep() {}

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

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Retrieving Sheep data from Parcel object
     * This constructor is invoked by the method createFromParcel(Parcel source) of
     * the object CREATOR
     **/
    private Sheep(Parcel in) {
        id = in.readInt();
        name = in.readString();
        age = in.readString();
        weight = in.readString();
        photoId = in.readInt();
        alive = in.readInt();
    }

    /**
     * Storing the Sheep data to Parcel object
     **/
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(age);
        dest.writeString(weight);
        dest.writeInt(photoId);
        dest.writeInt(alive);
    }

    /**
     * Object creator
     */
    public static final Parcelable.Creator<Sheep> CREATOR
            = new Parcelable.Creator<Sheep>() {
        public Sheep createFromParcel(Parcel in) {
            return new Sheep(in);
        }

        public Sheep[] newArray(int size) {
            return new Sheep[size];
        }
    };
}
