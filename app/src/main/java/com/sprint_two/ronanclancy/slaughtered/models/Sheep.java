package com.sprint_two.ronanclancy.slaughtered.models;

import android.os.Parcel;
import android.os.Parcelable;

import auto.parcel.AutoParcel;

/**
 * Sheep model
 * <p/>
 * Created by ronanclancy on 1/13/16.
 */
@AutoParcel
public abstract class Sheep implements Parcelable {

    public abstract int id();
    public abstract String name();
    public abstract String age();
    public abstract String weight();
    public abstract int photoId();
    public abstract int alive(); // 0 alive, 1 dead

    public static Sheep create(int id, String name, String age, String weight, int photoId, int alive){
        return new AutoParcel_Sheep(id, name, age, weight, photoId, alive);
    }
}
