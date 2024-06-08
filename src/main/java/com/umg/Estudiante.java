package com.umg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Estudiante {
    private String carnet;
    private String nombre;
    private String apellido;
    private int carrera;
    private String carreraElegida;
    private Integer contadorEstudiantesB;

    public Estudiante() {
    }

    public Estudiante(String carnet, String nombre, String apellido, int carrera) {
        this.carnet = carnet;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public Estudiante(String carreraElegida, Integer contadorEstudiantesB) {
        this.carreraElegida = carreraElegida;
        this.contadorEstudiantesB = contadorEstudiantesB;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public String getCarreraElegida() {
        return carreraElegida;
    }

    public void setCarreraElegida(String carreraElegida) {
        this.carreraElegida = carreraElegida;
    }

    public Integer getContadorEstudiantesB() {
        return contadorEstudiantesB;
    }

    public void setContadorEstudiantesB(Integer contadorEstudiantesB) {
        this.contadorEstudiantesB = contadorEstudiantesB;
    }
    
    
    
    Scanner scanner = new Scanner(System.in);
    String rutaArchivo = System.getProperty("user.dir") + "/estudiantes/estudiantes.txt";
    public void menuSistema(){
        System.out.println("*****BIENVENIDO AL SISTEMA UNIVERSIARIO*****");
        System.out.println("QUE DESEAS HACER?");
        System.out.println("");
        System.out.println("1. Inscribirse.");
        System.out.println("2. Estudiantes inscritos a una carrera.");
        System.out.println("3. Generar resumen Excel de los estudiantes inscritos.");
        System.out.println("0. Salir.");
        
        int opcion;
        do{
            try {
                opcion = scanner.nextInt();
                switch(opcion){
                case 1:{agregarEstudiante(); break;}
                case 2:{buscarCantidadEstudiantesEnUnaCarrera(); break;}
                case 3:{ResumenExcel resumen = new ResumenExcel();
                        resumen.generarReporteExcel();
                        System.out.println("");
                        System.out.println("QUE DESEAS HACER AHORA?");
                        System.out.println("");
                        System.out.println("1. Inscribirse.");
                        System.out.println("2. Estudiantes inscritos a una carrera.");
                        System.out.println("3. Generar resumen Excel de los estudiantes inscritos.");
                        System.out.println("0. Salir."); 
                break;}
                }
            } catch (Exception e) {
                opcion = 0;
            }
        }while(opcion != 0);
    }
    
    public void agregarEstudiante(){
        System.out.println("***INSCRIPCION***");
        System.out.println("");
        System.out.println("INGRESE SU CARNET:");
        carnet = scanner.next();
        System.out.println("INGRESE SU NOMBRE:");
        nombre = scanner.next();
        System.out.println("INGRESE SU APELLIDO:");
        apellido = scanner.next();

        boolean validacion = false;
        do{
        System.out.println("INGRESE EL NUMERO DE LA CARRERA A LA QUE DESEA INSCRIBIRSE:");
        System.out.println("1. Ingenieria");
        System.out.println("2. Derecho");
        System.out.println("3. Criminologia");
        System.out.println("4. Auditoria");
        System.out.println("5. Quimica Farmaceutica");
        carrera = scanner.nextInt();
            switch(carrera){
                case 1:{carreraElegida = "Ingenieria";
                validacion = true;
                break;}
                case 2:{carreraElegida = "Derecho";
                validacion = true;
                break;}
                case 3:{carreraElegida = "Criminologia";
                validacion = true;
                break;}
                case 4:{carreraElegida = "Auditoria";
                validacion = true;
                break;}
                case 5:{carreraElegida = "Quimica Farmaceutica";
                validacion = true;
                break;}
                default:{System.out.println("Ingrese una opcion correcta:");
                validacion = false;
                break;}
            }
        }while(!validacion);
        
        FileWriter escritor = null;
        BufferedWriter bw = null;        
        try {
            escritor = new FileWriter(rutaArchivo,true);
            bw = new BufferedWriter(escritor);
            
            String estudiante = carnet + "," + nombre + "," + apellido + "," + carreraElegida;
            
            bw.write(estudiante);
            bw.newLine();
            
            System.out.println("Inscrito con exito");
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println("Error al inscribirse.");
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println("Error al guardar el archivo. " + e.getMessage());
            }            
        }
        
        System.out.println("QUE DESEAS HACER AHORA?");
        System.out.println("");
        System.out.println("1. Inscribirse.");
        System.out.println("2. Estudiantes inscritos a una carrera.");
        System.out.println("3. Generar resumen Excel de los estudiantes inscritos.");
        System.out.println("0. Salir.");        
        
    }
    
    public void buscarCantidadEstudiantesEnUnaCarrera(){
        boolean validacion = false;
        do{
        System.out.println("INGRESE EL NUMERO DE LA CARRERA EN LA QUE DESEA BUSCAR:");
        System.out.println("1. Ingenieria");
        System.out.println("2. Derecho");
        System.out.println("3. Criminologia");
        System.out.println("4. Auditoria");
        System.out.println("5. Quimica Farmaceutica");
        carrera = scanner.nextInt();
            switch(carrera){
                case 1:{carreraElegida = "Ingenieria";
                validacion = true;
                break;}
                case 2:{carreraElegida = "Derecho";
                validacion = true;
                break;}
                case 3:{carreraElegida = "Criminologia";
                validacion = true;
                break;}
                case 4:{carreraElegida = "Auditoria";
                validacion = true;
                break;}
                case 5:{carreraElegida = "Quimica Farmaceutica";
                validacion = true;
                break;}
                default:{System.out.println("Ingrese una opcion correcta:");
                validacion = false;
                break;}
            }
        }while(!validacion);
        
        FileReader lector = null;
        BufferedReader br = null;
        int contadorEstudiantes = 0;
        try {
            lector = new FileReader(this.rutaArchivo);
            br = new BufferedReader(lector);
            
            String linea;
            while((linea = br.readLine()) != null){
            
                String[] parteLinea = linea.split(",");

                String carreraB = parteLinea[3];
                
                if(carreraElegida.equals(carreraB)){
                    contadorEstudiantes++;
                }       
            }
            String pluralSingularEs;
            if(contadorEstudiantes == 1){
            pluralSingularEs = "estudiante.";
            }else{
            pluralSingularEs = "estudiantes.";
            }
            System.out.println("La cantidad de estudiantes inscritos en la carrera de " + carreraElegida + " es de " + contadorEstudiantes + " " +pluralSingularEs);
            System.out.println("");
            
        } catch (Exception e) {
            System.out.println("Error al leer el archivo. " + e.getMessage());
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar el archivo. " + e.getMessage());
            }
        }
        
        System.out.println("QUE DESEAS HACER AHORA?");
        System.out.println("");
        System.out.println("1. Inscribirse.");
        System.out.println("2. Estudiantes inscritos a una carrera.");
        System.out.println("3. Generar resumen Excel de los estudiantes inscritos.");
        System.out.println("0. Salir."); 
    }

}
