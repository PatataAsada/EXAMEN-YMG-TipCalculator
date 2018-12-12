package es.iessaladillo.yeraymoreno.examen_ymg_tipcalculator.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Record implements Parcelable {
    private static  long idCounter = 0;
    private long id;
    private String date;
    private String name;
    private double bill;
    private int tipPercent;
    private int diners;

    public Record(String date, String name, double bill, int tipPercent, int diners) {
        idCounter++;
        id = idCounter;
        this.date = date;
        this.name = name;
        this.bill = bill;
        this.tipPercent = tipPercent;
        this.diners = diners;
    }

    private Record(Parcel in) {
        id = in.readLong();
        date = in.readString();
        name = in.readString();
        bill = in.readDouble();
        tipPercent = in.readInt();
        diners = in.readInt();
    }

    public static final Creator<Record> CREATOR = new Creator<Record>() {
        @Override
        public Record createFromParcel(Parcel in) {
            return new Record(in);
        }

        @Override
        public Record[] newArray(int size) {
            return new Record[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }

    public int getTipPercent() {
        return tipPercent;
    }

    public void setTipPercent(int tipPercent) {
        this.tipPercent = tipPercent;
    }

    public int getDiners() {
        return diners;
    }

    public void setDiners(int diners) {
        this.diners = diners;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeLong(id);
        dest.writeString(date);
        dest.writeDouble(bill);
        dest.writeInt(tipPercent);
        dest.writeInt(diners);
    }
}
