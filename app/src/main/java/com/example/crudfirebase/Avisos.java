package com.example.crudfirebase;

public class Avisos {

    private String id_Aviso;
    private String nombreProfesor;
    private String AvisoProfesor;


    public Avisos(){}

    public Avisos(String id_Aviso, String nombreProfesor, String avisoProfesor) {
        this.id_Aviso = id_Aviso;
        this.nombreProfesor = nombreProfesor;
        AvisoProfesor = avisoProfesor;
    }

    public String getId_Aviso() {
        return id_Aviso;
    }

    public void setId_Aviso(String id_Aviso) {
        this.id_Aviso = id_Aviso;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getAvisoProfesor() {
        return AvisoProfesor;
    }

    public void setAvisoProfesor(String avisoProfesor) {
        AvisoProfesor = avisoProfesor;
    }
}
