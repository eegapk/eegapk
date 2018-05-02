package net.itss.kahm.eegappv3;

import android.graphics.Bitmap;

/**
 * Created by katerina Hurtado on 3/22/2018.
 */

public class BeanCrearUser {

    protected int id;
    protected String Nombre;
    protected String Apellido;
    protected String Cedula;
    protected String Email;
    protected String fechaNacimiento;
    protected String Especialidad;
    protected String NumTelfOficina;
    protected String NumtelfPaciente;
    protected String NumTelfpersonal;
    protected String claveP;
    protected String claveD;
    protected Bitmap photo;

    public BeanCrearUser(int id, String nombre, String apellido, String cedula, String email, String fechaNacimiento, String especialidad,
                         String numTelfOficina, String numtelfPaciente, String numTelfpersonal, String claveP, String claveD, Bitmap photo) {
        this.id = id;
        this.Nombre = nombre;
        Apellido = apellido;
        Cedula = cedula;
        Email = email;
        this.fechaNacimiento = fechaNacimiento;
        Especialidad = especialidad;
        NumTelfOficina = numTelfOficina;
        NumtelfPaciente = numtelfPaciente;
        NumTelfpersonal = numTelfpersonal;
        this.claveP = claveP;
        this.claveD = claveD;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String cedula) {
        Cedula = cedula;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String especialidad) {
        Especialidad = especialidad;
    }

    public String getNumTelfOficina() {
        return NumTelfOficina;
    }

    public void setNumTelfOficina(String numTelfOficina) {
        NumTelfOficina = numTelfOficina;
    }

    public String getNumtelfPaciente() {
        return NumtelfPaciente;
    }

    public void setNumtelfPaciente(String numtelfPaciente) {
        NumtelfPaciente = numtelfPaciente;
    }

    public String getNumTelfpersonal() {
        return NumTelfpersonal;
    }

    public void setNumTelfpersonal(String numTelfpersonal) {
        NumTelfpersonal = numTelfpersonal;
    }

    public String getClaveP() {
        return claveP;
    }

    public void setClaveP(String claveP) {
        this.claveP = claveP;
    }

    public String getClaveD() {
        return claveD;
    }

    public void setClaveD(String claveD) {
        this.claveD = claveD;
    }

    public Bitmap getPhoto() {
        return photo;
    }

    public void setPhoto(Bitmap photo) {
        this.photo = photo;
    }
}
