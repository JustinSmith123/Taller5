/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;
import java.util.*;

/**
 *
 * @author usuario
 */
public class Pais {
    String nombre = null;
    String area = null;
    String poblacion = null;
    String idioma = null;
    ArrayList<String> provincias = new ArrayList();
    ArrayList<String> limites = new ArrayList();
    public Pais(String pNombre,String pArea,String pPoblacion,String pIdioma){
        nombre = pNombre;
        area = pArea;
        poblacion = pPoblacion;
        idioma = pIdioma;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public ArrayList<String> getProvincias() {
        return provincias;
    }

    public void setProvincias(ArrayList<String> provincias) {
        this.provincias = provincias;
    }

    public ArrayList<String> getLimites() {
        return limites;
    }

    public void setLimites(ArrayList<String> limites) {
        this.limites = limites;
    }
    public void agregarProvincia(String pName){
        provincias.add(pName);
    }
    public void agregarLimite(String pName){
        limites.add(pName);
    }
}
