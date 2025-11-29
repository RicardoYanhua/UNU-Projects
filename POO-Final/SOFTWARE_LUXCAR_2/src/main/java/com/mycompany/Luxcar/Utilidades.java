/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.Luxcar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author ricar
 */
public class Utilidades {

    public static String getMesEnEspanol(Month month) {
        Map<Month, String> mesesEnEspanol = new HashMap<>();
        mesesEnEspanol.put(Month.JANUARY, "Enero");
        mesesEnEspanol.put(Month.FEBRUARY, "Febrero");
        mesesEnEspanol.put(Month.MARCH, "Marzo");
        mesesEnEspanol.put(Month.APRIL, "Abril");
        mesesEnEspanol.put(Month.MAY, "Mayo");
        mesesEnEspanol.put(Month.JUNE, "Junio");
        mesesEnEspanol.put(Month.JULY, "Julio");
        mesesEnEspanol.put(Month.AUGUST, "Agosto");
        mesesEnEspanol.put(Month.SEPTEMBER, "Septiembre");
        mesesEnEspanol.put(Month.OCTOBER, "Octubre");
        mesesEnEspanol.put(Month.NOVEMBER, "Noviembre");
        mesesEnEspanol.put(Month.DECEMBER, "Diciembre");
        return mesesEnEspanol.get(month);
    }

    public static LocalDateTime getDateTime(LocalDate date, String hourStr, String minuteStr) {
        try {
            if (date == null) {
                return null;
            }

            int hour = Integer.parseInt(hourStr);
            int minute = Integer.parseInt(minuteStr);

            hour = Math.max(0, Math.min(23, hour));
            minute = Math.max(0, Math.min(59, minute));

            return LocalDateTime.of(date.getYear(), date.getMonthValue(), date.getDayOfMonth(), hour, minute, 0);
        } catch (NumberFormatException | DateTimeException e) {
            return null;
        }
    }

    public static Integer getMesNumero(String NombredelMes) {
        try {
            Map<String, Integer> meses = new HashMap<>();
            meses.put("Enero", 1);
            meses.put("Febrero", 2);
            meses.put("Marzo", 3);
            meses.put("Abril", 4);
            meses.put("Mayo", 5);
            meses.put("Junio", 6);
            meses.put("Julio", 7);
            meses.put("Agosto", 8);
            meses.put("Septiembre", 9);
            meses.put("Octubre", 10);
            meses.put("Noviembre", 11);
            meses.put("Diciembre", 12);

            if (meses.containsKey(NombredelMes)) {
                return meses.get(NombredelMes);
            } else {
                return 0; // El mes no se encuentra en el mapa
            }
        } catch (Exception e) {
            return 0; // En caso de cualquier otra excepción
        }
    }

    public static ImageIcon getImagenIconToProject(String ruta) {
        BufferedImage imagen;
        ImageIcon icono = null;
        try {
            URL imgURL = Main.class.getResource(ruta);
            if (imgURL != null) {
                imagen = ImageIO.read(imgURL);
                icono = new ImageIcon(imagen);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return icono;
    }

    public static ImageIcon getImagenIconToURL(String Ruta) {

        try {
            // Cargar la imagen desde el archivo
            File archivoImagen = new File(Ruta);
            BufferedImage imagen = ImageIO.read(archivoImagen);
            ImageIcon icono = new ImageIcon(imagen);
            return icono;
        } catch (IOException e) {
            System.out.println("Error Util.getImagenIcon : \n " + e.getMessage().toString());
            return null;
        }
    }

    public static String getNumeroTelefonox9_from51(String telefono) {
        telefono = telefono.replace("+51 ", "").replace(" ", "");
        return telefono;
    }

    public static String setNumerox9_51(String telefono) {

        StringBuilder telf = new StringBuilder(telefono);
        telf.insert(3, " ");
        telf.insert(7, " ");
        telf.insert(0, "+51 ");
        return telf.toString();
    }

    public static LocalDate getFechaTextField(String fecha_dd_mm_yyyy) {

        try {
            fecha_dd_mm_yyyy = fecha_dd_mm_yyyy.replaceAll("\\s+", "");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fecha_dd_mm_yyyy, formatter);
            if (fecha.getDayOfMonth() != Integer.parseInt(fecha_dd_mm_yyyy.substring(0, 2))
                    || fecha.getMonthValue() != Integer.parseInt(fecha_dd_mm_yyyy.substring(3, 5))
                    || fecha.getYear() != Integer.parseInt(fecha_dd_mm_yyyy.substring(6, 10))) {
                return null; // Fecha no válida
            }

            return fecha;
        } catch (DateTimeParseException e) {
            return null; // Fecha no válida
        }
    }

    public static LocalDate getFechaSpinnerx3_dd_StringMes_yyyy(int dia, String mes, int anio) {
        Integer numeroMes = getMesNumero(mes);
        if (numeroMes == null) {
            return null; // Mes no válido
        }

        try {
            // Intentar crear el LocalDate
            LocalDate fecha = LocalDate.of(anio, numeroMes, dia);
            return fecha;
        } catch (DateTimeException e) {
            return null; 
        }

    }

    public static LocalDate getFechaSpinnerx3_dd_StringMes_yyyy(String dia, String mes, String anio) {
        Integer numeroMes = getMesNumero(mes);
        Integer dia_i = Integer.parseInt(dia);
        Integer anio_i = Integer.parseInt(anio);
        if (numeroMes == null) {
            return null; // Mes no válido
        }

        try {
            // Intentar crear el LocalDate
            LocalDate fecha = LocalDate.of(anio_i, numeroMes, dia_i);
            return fecha;
        } catch (DateTimeException e) {
            return null;
        }

    }

    public static String getFechaActual_dd_mm_yyy() {
        Date fecha = new Date(); // Captura la fecha actual
        SimpleDateFormat format = new SimpleDateFormat("dd' / 'MM' / 'yyyy"); // Define el formato con espacios
        return format.format(fecha); // Devuelve la fecha formateada
    }

}
