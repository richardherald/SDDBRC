package br.com.commons.model;

public class Sincronization {

    private Integer sincronization_Id;
    private String sincronization_Name;

    public Sincronization() {
    }

    public Sincronization(Integer sincronization_Id, String sincronization_Name) {
        this.sincronization_Id = sincronization_Id;
        this.sincronization_Name = sincronization_Name;
    }

    public Integer getSincronization_Id() {
        return sincronization_Id;
    }

    public void setSincronization_Id(Integer sincronization_Id) {
        this.sincronization_Id = sincronization_Id;
    }

    public String getSincronization_Name() {
        return sincronization_Name;
    }

    public void setSincronization_Name(String sincronization_Name) {
        this.sincronization_Name = sincronization_Name;
    }
    


}
