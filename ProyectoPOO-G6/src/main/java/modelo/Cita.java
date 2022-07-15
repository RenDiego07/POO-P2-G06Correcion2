/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Scanner;

public class Cita {
    private String fecha;
    private String hora;
    private Empleado empleado;
    private Cliente cliente;
    private Servicio servicio;

    //Constructor
    public Cita(Cliente cliente, Empleado empleado, Servicio servicio, String fecha, String hora) {
        this.fecha = fecha;
        this.hora = hora;
        this.empleado = empleado;
        this.cliente = cliente;
        this.servicio = servicio;
    }
    
    //Getters
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public String getFecha() {
        return fecha;
    }
    
    
    @Override
    public String toString() {
        String cadena = "Fecha: " + fecha + " Hora: "+ hora + " | Empleado: " + empleado.getCedula() +" "+ empleado.getNombre() + " | Cliente: " + cliente.getCedula() + " " + cliente.getNombre() + " | Servicio: " + servicio.getNombreServicio();
        return cadena;
    }
    
    //Método que muestra las citas que existen en el sistema
    public static void mostrarCitas(ArrayList<Cita> citas){
        for(Cita c: citas){
            System.out.println(c.toString());
        }
    }
    
    //Método para crear una cita que recibe un arreglo de citas, empleados disponibles y servicios, y la fecha y hora de la cita
    public static void crearCita(Cliente clienteCedula, ArrayList<Cita> citas, ArrayList<Empleado> empleadosDisponibles, ArrayList<Servicio> servicios, String fecha, String hora){
        Scanner sc = new Scanner(System.in);
        System.out.println("Se muestran los empleados disponibles para la fecha y hora solicitada. ");
        int i = 0;
        //iterando el arreglo de empleado disponibles para mostrarlos por pantalla
        for(Empleado e: empleadosDisponibles){
            
            System.out.println((1+i)+" "+e.toString());
            i++;
        }
        
        System.out.print("Seleccione el numero del empleado para la cita: ");
        int indiceEmpleado = sc.nextInt();
        sc.nextLine();
        
        //Se guarda al empleado escogido dentro de una variable de tipo Empleado
        Empleado empleadoEscogido = empleadosDisponibles.get(indiceEmpleado-1);
        
        System.out.println("Se muestran los servicios disponibles ");
        //Llamada al metodo mostrar servicios de la clase Servicio
        Servicio.mostrarServicios(servicios);
        System.out.print("Seleccione el numero del servicio para la cita: ");
        int indiceServicio = sc.nextInt();
        sc.nextLine();
        
        //Se guarda al servicio escogido dentro de una variable de tipo Servicio
        Servicio servicioEscogido = servicios.get(indiceServicio-1);
       
        //Se crea la cita a partir del empleado y servicio escogidos, y la fecha y hora de la cita
        Cita citaNueva = new Cita(clienteCedula, empleadoEscogido, servicioEscogido, fecha, hora);
        
        //Se añade la cita al arreglo de citas
        citas.add(citaNueva);
        
    }
    
    /*Método que sirve para verificar una cita por fecha y hora, el cual se utilizará para crear un 
    arreglo de empleados disponibles en la clase Empleado, retornando un arreglo de citas que coinciden
    con la fecha y hora ingresadas.
    */
    public static ArrayList<Cita> verificarCitaFyH(ArrayList<Cita> citas, String fecha, String hora){
        ArrayList<Cita> citaNoDisponible = new ArrayList<>();
        
        for (Cita c: citas){
            if (c.fecha.equals(fecha) && c.hora.equals(hora)){
                citaNoDisponible.add(c);
            }
        }
        return citaNoDisponible;
        
    }
    
    /* Método para eliminar una cita por medio de la cédula del cliente.
    Recibe la cédula del cliente y el arreglo de las citas
    */
    public static void eliminarCita(String cedula, ArrayList<Cita>citas){
        ArrayList<Cita> citaPersona = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //Se muestran las citas filtrando por medio de la cédula del cliente
        int contador = 0;
        for (Cita c: citas){
            if (c.cliente.getCedula().equals(cedula)){
                citaPersona.add(c);
                System.out.println((1+contador)+ ". "+c);
                contador +=1;
            }
        }
        //Si existen citas, se hace que el usuario escoga la cita a eliminar
        if(contador!=0){
            System.out.println("Qué cita de la lista desea eliminar?");
            int indiceEliminar = sc.nextInt();
            sc.nextLine();
            citas.remove(citaPersona.get(indiceEliminar-1));
            citaPersona.remove(indiceEliminar -1);
        }
        //Si no exiten citas, se muestra el mensaje por pantalla
        else{
            System.out.println("No hay citas agendadas al número de cédula.");
        }
        
    }
    
    //Método para consultar las citas por medio de la fecha
    public static void consultarCita(String fecha, ArrayList<Cita> citas){
        int contador= 0;
        for (Cita c: citas){
            //Si existen citas con la fecha ingresa, se mostraran por pantalla
            if (c.fecha.equals(fecha)){
                System.out.println((1+contador)+". "+c);
                contador++;
            }
        }
        // En el caso de no existir cita, se muestra el mensaje por pantalla
        if(contador==0){
            System.out.println("No existen citas en esta fecha: "+fecha);
        }
        
    }
     
}
