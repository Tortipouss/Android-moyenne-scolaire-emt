package com.gallale.notes.models;

public class Note {
    private  String note;
    private String category;
    private double value;

     public Note(){
     }

     public Note(String note, double value, String category){
         this.note = note;
         this.value = value;

         // EPT ou ATE ou MOD
         this.category = category;
     }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
