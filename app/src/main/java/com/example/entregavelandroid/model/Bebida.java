package com.example.entregavelandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Bebida implements Parcelable {

    private String nomeBebida;
    private int imgBebida;
    private String descrBebida;

    public Bebida(String nomeBebida, int imgBebida, String descrBebida) {
        this.nomeBebida = nomeBebida;
        this.imgBebida = imgBebida;
        this.descrBebida = descrBebida;
    }

    protected Bebida(Parcel in) {
        nomeBebida = in.readString();
        imgBebida = in.readInt();
        descrBebida = in.readString();

    }

    public static final Creator<Bebida> CREATOR = new Creator<Bebida>() {
        @Override
        public Bebida createFromParcel(Parcel in) {
            return new Bebida(in);
        }

        @Override
        public Bebida[] newArray(int size) {
            return new Bebida[size];
        }
    };

    public String getNomeBebida() {
        return nomeBebida;
    }

    public void setNomeBebida(String nomeBebida) {
        this.nomeBebida = nomeBebida;
    }

    public int getImgBebida() {
        return imgBebida;
    }

    public void setImgBebida(int imgBebida) {
        this.imgBebida = imgBebida;
    }

    public String getDescrBebida() {
        return descrBebida;
    }

    public void setDescrBebida(String descrBebida) {
        this.descrBebida = descrBebida;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nomeBebida);
        parcel.writeInt(imgBebida);
        parcel.writeString(descrBebida);
    }
}
