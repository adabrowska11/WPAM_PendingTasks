package com.example.pendingtasks.dane;

import java.util.Calendar;

public class Task {
    private long taskId;
    private String nazwa;
    private String opis;
    boolean metoda = true;      //true - data i czas, false - lokalizacja
    private String data;
    private String czas;
    private boolean wykonane = false;
    private boolean zlecone = false;
    private boolean doZrobienia = false;
    private long idTworcy;

    public Task() {}

    public Task(long taskId, String nazwa, String opis, boolean metoda, String data, String czas, boolean wykonane, boolean zlecone, boolean doZrobienia, long idTworcy) {
        this.taskId = taskId;
        this.nazwa = nazwa;
        this.opis = opis;
        this.metoda = metoda;
        this.czas = czas;
        this.data = data;
        this.wykonane = wykonane;
        this.zlecone = zlecone;
        this.doZrobienia = doZrobienia;
        this.idTworcy = idTworcy;
    }

    public long getTaskId() { return taskId; };
    public String getNazwa() { return nazwa; };
    public String getOpis() { return opis; };
    public boolean isMetoda() {return metoda;};
    public String getData() { return data; };
    public String getCzas() { return czas; };
    public boolean isWykonane() { return wykonane; };
    public boolean isZlecone() { return zlecone; };
    public boolean isDoZrobienia() { return doZrobienia; };
    public long getIdTworcy() { return idTworcy; };


}
