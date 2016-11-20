package com.ss_baez.formulario;

/**
 * Created by SS_Baez on 19/11/2016.
 */

public class Formulario {

    private String nombreC;
    private String fechaC;
    private String telefonoC;
    private String emailC;
    private String descripcionC;


    public Formulario(String nombreC, String fechaC, String telefonoC, String emailC, String descripcionC) {
        this.nombreC = nombreC;
        this.fechaC = fechaC;
        this.telefonoC = telefonoC;
        this.emailC = emailC;
        this.descripcionC = descripcionC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getFechaC() {
        return fechaC;
    }

    public void setFechaC(String fechaC) {
        this.fechaC = fechaC;
    }

    public String getTelefonoC() {
        return telefonoC;
    }

    public void setTelefonoC(String telefonoC) {
        this.telefonoC = telefonoC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    public String getDescripcionC() {
        return descripcionC;
    }

    public void setDescripcionC(String descripcionC) {
        this.descripcionC = descripcionC;
    }
}
