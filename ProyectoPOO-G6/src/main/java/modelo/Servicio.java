/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author mbravop
 */
public class Servicio {
    private String nombreServicio;
    private int duracion;
    private double precio;
    private boolean estado;
    
    public Servicio(String nS, int d, double p, boolean e){
        nombreServicio=nS;
        duracion=d;
        precio=p;
        estado=e;
    }

    public int getDuracion() {
        return duracion;
    }
    
    public String mostrarServicios(){
        if (estado){
            return "Servicio=" + nombreServicio + ", duracion=" + duracion +"minutos, precio=" + precio + ", estado= Activo";
        } else {
            return "Servicio=" + nombreServicio + ", duracion=" + duracion +"minutos, precio=" + precio + ", estado= Inactivo";
        }
    }
    
    public void agregarServicio(){
        
    }
    
    public void editarServicio(String nS, int d, double p){
        nombreServicio=nS;
        duracion=d;
        precio= p;
    }
    
    public void eliminarServicio(){
        if (estado){
            estado=false;
        }
    }
}