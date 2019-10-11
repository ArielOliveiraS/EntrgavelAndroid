package com.example.entregavelandroid.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Cervejaria implements Parcelable {

    private String nome;
    private String endereco;
    private String horarioFuncionamento;
    private int imagem;

    public Cervejaria(String nome, String endereco, String horarioFuncionamento, int imagem) {
        this.nome = nome;
        this.endereco = endereco;
        this.horarioFuncionamento = horarioFuncionamento;
        this.imagem = imagem;
    }

    protected Cervejaria(Parcel in) {
        nome = in.readString();
        endereco = in.readString();
        horarioFuncionamento = in.readString();
        imagem = in.readInt();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getHorarioFuncionamento() {
        return horarioFuncionamento;
    }

    public void setHorarioFuncionamento(String horarioFuncionamento) {
        this.horarioFuncionamento = horarioFuncionamento;
    }

    public int getImagem() {
        return imagem;
    }

    public void setImagem(int imagem) {
        this.imagem = imagem;
    }

    public static final Creator<Cervejaria> CREATOR = new Creator<Cervejaria>() {
        @Override
        public Cervejaria createFromParcel(Parcel in) {
            return new Cervejaria(in);
        }

        @Override
        public Cervejaria[] newArray(int size) {
            return new Cervejaria[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(endereco);
        dest.writeString(horarioFuncionamento);
        dest.writeInt(imagem);

    }
}
