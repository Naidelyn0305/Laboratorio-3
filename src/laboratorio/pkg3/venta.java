/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio.pkg3;

import java.util.Date;
import java.util.List;


/**
 *
 * @author EmesisMairenaSevilla
 */
public  abstract class Venta {
    private String cedula;
    private String nombre;
    private String genero;
    private List<int[]> asientos; // Lista de asientos comprados
    private double montoTotal;
    private Date fechaHora;

    public Venta(String cedula, String nombre, String genero, List<int[]> asientos, double montoTotal, Date fechaHora) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.genero = genero;
        this.asientos = asientos;
        this.montoTotal = montoTotal;
        this.fechaHora = fechaHora;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public List<int[]> getAsientos() {
        return asientos;
    }

    public void setAsientos(List<int[]> asientos) {
        this.asientos = asientos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }
    
}


