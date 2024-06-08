package com.umg;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ResumenExcel {

    DatosEstudiantes datosEstudiantes = new DatosEstudiantes();
    public void generarReporteExcel() {

        List<Estudiante> listaEstudiantes = new ArrayList<>();

        listaEstudiantes = datosEstudiantes.llenarLista();

        String nombreReporte = System.getProperty("user.dir") + "/reporte_estudiantes.xlsx";

        Workbook workbook = new XSSFWorkbook();

        Sheet hoja = workbook.createSheet("Reporte");

        String[] titulos = {"CARRERA", "NO ALUMNOS"};

        Row filaEncabezados = hoja.createRow(0);

        for(int i = 0; i < titulos.length; i++) {
            Cell celda = filaEncabezados.createCell(i);
            celda.setCellValue(titulos[i]);
            hoja.autoSizeColumn(i);
        }

        for(int i = 0; i<listaEstudiantes.size(); i++) {
            
            Row filaDatos = hoja.createRow(i+1);
            
            for(int dato = 0; dato < titulos.length; dato++) { 
            
                Cell celdaDato = filaDatos.createCell(dato);
                
                String carrera = listaEstudiantes.get(i).getCarreraElegida()!= null ? listaEstudiantes.get(i).getCarreraElegida() : "";
                Integer contador = listaEstudiantes.get(i).getContadorEstudiantesB()!= null ? listaEstudiantes.get(i).getContadorEstudiantesB(): 0;

                switch (dato) {
                    case 0: { celdaDato.setCellValue(carrera); break; }
                    case 1: { celdaDato.setCellValue(contador); break; }
                }
                
                hoja.autoSizeColumn(dato);
                
            }
            
        }

        try (FileOutputStream fileOut = new FileOutputStream(nombreReporte)) {
            workbook.write(fileOut);
            System.out.println("");
            System.out.println("Resumen generado con exito");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }    
}
