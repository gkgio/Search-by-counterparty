package com.gig.gio.search_by_counterparty.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by georgy on 29.10.2017.
 * Gig
 */

public class Data extends RealmObject implements Serializable {

    /** id */
    @PrimaryKey
    private long id;

    private String kpp;

    @SerializedName("management")
    private Management management;

    private String inn;

    private String ogrn;

    @SerializedName("opf")
    private Opf opf;

    @SerializedName("state")
    private State state;

    @SerializedName("address")
    private Address address;


    public long getId() {
        return id;
    }

    public String getKpp() {
        return kpp;
    }

    public Management getManagement() {
        return management;
    }

    public String getInn() {
        return inn;
    }

    public String getOgrn() {
        return ogrn;
    }

    public Opf getOpf() {
        return opf;
    }

    public State getState() {
        return state;
    }

    public Address getAddress() {
        return address;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public void setManagement(Management management) {
        this.management = management;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setOgrn(String ogrn) {
        this.ogrn = ogrn;
    }

    public void setOpf(Opf opf) {
        this.opf = opf;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
