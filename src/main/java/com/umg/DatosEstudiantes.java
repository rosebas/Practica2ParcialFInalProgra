package com.umg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class DatosEstudiantes {

    private String CarreraE;
    String rutaArchivo = System.getProperty("user.dir") + "/estudiantes/estudiantes.txt";
    public List<Estudiante> llenarLista(){
        List<Estudiante> listaEstudiantes = new ArrayList<>();
        
        FileReader lector = null;
        BufferedReader br = null;
        int contador1 = 0;
        int contador2 = 0;
        int contador3 = 0;
        int contador4 = 0;
        int contador5 = 0;
        int contadorTotal = 0;
        try {
            lector = new FileReader(this.rutaArchivo);

            br = new BufferedReader(lector);

            String linea;
            while ((linea = br.readLine()) != null){
                String[] parteLinea = linea.split(",");
                
                String carreraBL = parteLinea[3];
                
                if(carreraBL.equals("Ingenieria")){
                    contador1++;
                }
                if(carreraBL.equals("Derecho")){
                    contador2++;
                }
                if(carreraBL.equals("Criminologia")){
                    contador3++;
                }
                if(carreraBL.equals("Auditoria")){
                    contador4++;
                }
                if(carreraBL.equals("Quimica Farmaceutica")){
                    contador5++;
                }
                
                contadorTotal++;
            }
            
            Estudiante carrera1 = new Estudiante("Ingenieria", contador1);
            listaEstudiantes.add(carrera1);
            Estudiante carrera2 = new Estudiante("Derecho", contador2);
            listaEstudiantes.add(carrera2);                
            Estudiante carrera3 = new Estudiante("Criminologia", contador3);
            listaEstudiantes.add(carrera3);
            Estudiante carrera4 = new Estudiante("Auditoria", contador4);
            listaEstudiantes.add(carrera4);
            Estudiante carrera5 = new Estudiante("Quimica Farmaceutica", contador5);
            listaEstudiantes.add(carrera5);
            Estudiante total = new Estudiante("Total", contadorTotal);
            listaEstudiantes.add(total);
            
        } catch (Exception e) {
        } finally {
        }
        
        return listaEstudiantes;
    }    
}
