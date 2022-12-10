package ex2p1_josebendana;

import java.util.ArrayList;

public class Granja {
    public String nombre;
    public ArrayList<Vacas> vacas;
    public ArrayList<Vegetales> vegetales;
    public ArrayList<Conejos> Conejos;

    public Granja(String nombre) {
        this.nombre = nombre;
        this.vacas = new ArrayList<Vacas>();
        this.vegetales = new ArrayList<Vegetales>();
        this.Conejos = new ArrayList<Conejos>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Vacas> getVacas() {
        return vacas;
    }

    public void setVacas(ArrayList<Vacas> vacas) {
        this.vacas = vacas;
    }

    public ArrayList<Vegetales> getVegetales() {
        return vegetales;
    }

    public void setVegetales(ArrayList<Vegetales> vegetales) {
        this.vegetales = vegetales;
    }

    public ArrayList<Conejos> getConejos() {
        return Conejos;
    }

    public void setConejos(ArrayList<Conejos> Conejos) {
        this.Conejos = Conejos;
    }
    
    public void addvegetal(){
        vegetales.add(new Vegetales(100));
    }
    
    public void addconejo(String conejoname){
        Conejos.add(new Conejos(conejoname, 170));
    }
    
    public void addvaca(String vacaname){
        vacas.add(new Vacas(vacaname, 400));
    }
    
    public String nombrecon(int i){
        String name = Conejos.get(i).getNombre();
        
        return name;
    }
    
    public String nombrevac(int i){
        String name = Conejos.get(i).getNombre();
        return name;
    }
    public int conejosize(){
        return Conejos.size();
    }
    
    public int vacasize(){
        return vacas.size();
    }    
    public int vagesize(){
        return vegetales.size();
    }
    
    public void printgranja(){
        System.out.println("Tienes "+vegetales.size()+" vegetales");
        System.out.println("Tienes "+Conejos.size()+" conejos");
        System.out.println("Tienes "+vacas.size()+" vacas");
    }
   
    
}
