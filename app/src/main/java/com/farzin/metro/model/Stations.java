package com.farzin.metro.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Stations implements Parcelable {



    @SerializedName("id")
    private int id;
    @SerializedName("LineId")
    private int lineID;
    @SerializedName("OrderID")
    private int orderID;
    @SerializedName("Station_Duration")
    private int stationDuration;
    @SerializedName("CrossLine_ID")
    private int crossLineID;
    @SerializedName("ticket")
    private int ticket;
    @SerializedName("escalator")
    private int escalator;
    @SerializedName("atm")
    private int atm;
    @SerializedName("taxi")
    private int taxi;
    @SerializedName("bus")
    private int bus;
    @SerializedName("phone")
    private int phone;
    @SerializedName("water")
    private int water;
    @SerializedName("lost")
    private int lost;
    @SerializedName("parking")
    private int parking;
    @SerializedName("elevator")
    private int elevator;
    @SerializedName("Title")
    private String title;
    @SerializedName("Title_English")
    private String titleEnglish;
    @SerializedName("addr")
    private String address;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;

    public Stations(){

    }

    protected Stations(Parcel in) {
        id = in.readInt();
        lineID = in.readInt();
        orderID = in.readInt();
        stationDuration = in.readInt();
        crossLineID = in.readInt();
        ticket = in.readInt();
        escalator = in.readInt();
        atm = in.readInt();
        taxi = in.readInt();
        bus = in.readInt();
        phone = in.readInt();
        water = in.readInt();
        lost = in.readInt();
        parking = in.readInt();
        elevator = in.readInt();
        title = in.readString();
        titleEnglish = in.readString();
        address = in.readString();
        latitude = in.readString();
        longitude = in.readString();
    }

    public static final Creator<Stations> CREATOR = new Creator<Stations>() {
        @Override
        public Stations createFromParcel(Parcel in) {
            return new Stations(in);
        }

        @Override
        public Stations[] newArray(int size) {
            return new Stations[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getLineID() {
        return lineID;
    }

    public void setLineID(int lineID) {
        this.lineID = lineID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getStationDuration() {
        return stationDuration;
    }

    public void setStationDuration(int stationDuration) {
        this.stationDuration = stationDuration;
    }

    public int getCrossLineID() {
        return crossLineID;
    }

    public void setCrossLineID(int crossLineID) {
        this.crossLineID = crossLineID;
    }

    public int getTicket() {
        return ticket;
    }

    public void setTicket(int ticket) {
        this.ticket = ticket;
    }

    public int getEscalator() {
        return escalator;
    }

    public void setEscalator(int escalator) {
        this.escalator = escalator;
    }

    public int getAtm() {
        return atm;
    }

    public void setAtm(int atm) {
        this.atm = atm;
    }

    public int getTaxi() {
        return taxi;
    }

    public void setTaxi(int taxi) {
        this.taxi = taxi;
    }

    public int getBus() {
        return bus;
    }

    public void setBus(int bus) {
        this.bus = bus;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getParking() {
        return parking;
    }

    public void setParking(int parking) {
        this.parking = parking;
    }

    public int getElevator() {
        return elevator;
    }

    public void setElevator(int elevator) {
        this.elevator = elevator;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleEnglish() {
        return titleEnglish;
    }

    public void setTitleEnglish(String titleEnglish) {
        this.titleEnglish = titleEnglish;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeInt(lineID);
        parcel.writeInt(orderID);
        parcel.writeInt(stationDuration);
        parcel.writeInt(crossLineID);
        parcel.writeInt(ticket);
        parcel.writeInt(escalator);
        parcel.writeInt(atm);
        parcel.writeInt(taxi);
        parcel.writeInt(bus);
        parcel.writeInt(phone);
        parcel.writeInt(water);
        parcel.writeInt(lost);
        parcel.writeInt(parking);
        parcel.writeInt(elevator);
        parcel.writeString(title);
        parcel.writeString(titleEnglish);
        parcel.writeString(address);
        parcel.writeString(latitude);
        parcel.writeString(longitude);
    }
}
