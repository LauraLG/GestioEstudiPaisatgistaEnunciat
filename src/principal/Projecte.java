/*
 * Classe que defineix un projecte. Un projecte es defineix per un codi, NIF del
 * del client que ha encarregat el projecte, si està finalitzat o no, el pressupost 
 * i el dissenyador encarregat en desenvolupar-lo. A més, contindrà un vector de 
 * jardiners encarregats d'implementar el projecte.
 */
package principal;

import components.Dissenyador;
import components.Jardiner;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Projecte {
    private final static Scanner DADES = new Scanner(System.in);
    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nifClient;
    private boolean finalitzat;
    private double pressupost;
    private Dissenyador dissenyador;
    private Jardiner[] jardiners = new Jardiner[40];
    private int posicioJardiners = 0; //Primera posició buida del vector jardiners
    
     /*
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys el vector, el
     codi i finalitzat.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - Quan es crea un projecte aquest mai està finalitzat, per tant, assignarem
     fals a l'atribut finalitzat.
     - Quan es crea un projecte no té cap dissenyador assignat.
     */
    
    public Projecte(String nifClient, double pressupost, Dissenyador dissenyador){
        this.codi = properCodi;
        this.nifClient = nifClient;
        this.finalitzat = false;
        this.pressupost = pressupost;
        this.dissenyador = null;
        //this.posicioJardiners = posicioJardiners;
        
        properCodi++;
    }
    /*
     TODO Mètodes accessors    
     */
    
    public void setCodi(int codi){
        this.codi = codi;
    }
    
    public int getCodi(){
        return this.codi;
    }
    
    public void setNifClient(String nifClient){
        this.nifClient = nifClient;
    }
    
    public String getNifClient(){
        return this.nifClient;
    }
    
    public void seFinalitzat(boolean finalitzat){
        this.finalitzat = finalitzat;
    }
    public boolean getFinalitzat(){
        return this.finalitzat;
    }
    
    public void setPressupost(double pressupost){
        this.pressupost = pressupost;
    }
    
    public double getPressupost(){
        return this.pressupost;
    }
    
    public void setDissenyador(Dissenyador dissenyador){
        this.dissenyador = dissenyador;
    }
    public Dissenyador getDissenyador(){
        return this.dissenyador;
    }
    
    public void setJardiner(Jardiner[] j){
        this.jardiners = j;
    }
    
    public Jardiner[] getJardiner(){
        return this.jardiners;
    }  
    
     /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou projecte. Les dades
     a demanar són les que passem per paràmetre en el constructor.
     Retorn: El nou projecte creat.
     */
    public static Projecte addProjecte() {
        String nifClient, nifDis, nomDis;
        double pressupost;
        
        System.out.println("Introduce los datos del nuevo proyecto.");
        
        System.out.println("NIF del cliente: ");
        nifClient = DADES.nextLine();
        
        System.out.println("Presupuesto del proyecto: ");
        pressupost = DADES.nextDouble();
        
        System.out.println("Añade el diseñador/a al proyecto");
        System.out.println("NIF del diseñador/a: ");
        nifDis = DADES.nextLine();
        
        System.out.println("El nombre del diseñador/a: ");
        nomDis = DADES.nextLine();

        Dissenyador dissenyador = new Dissenyador(nifDis, nomDis);
        
        return new Projecte(nifClient, pressupost, dissenyador);        
    }
    
    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     només es pot modificar el NIF del client, si està finalitzat o no i el pressupost.
     - En el cas de finalitzat o no, li heu de demanar a l'usuari que si el projecte està  
     finalitzat, introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte actual, 
     abans de modificar-los. En el cas de l'atribut finalitzat, li heu de mostrar
     el missatge: "\nEl projecte està finalitzat", si el projecte s'ha finalitzat,
     i en cas contrari, el missatge "\nEl projecte no està finalitzat".
     Retorn: cap
     */
    public void updateProjecte() {
        String nifClient;
        double presuppost;
        int estado;
        boolean finalitzat;
        
        System.out.println("Actualiza los dados del siguiente proyecto.");
        showProjecte();
        
        System.out.println("Introduce el estado del proyecto: '1' - finalizado, '0' - activo: ");
        estado = DADES.nextInt();
        
        if (estado == 1){
            this.finalitzat = true;
            System.out.println("\nEl projecte està finalitzat");
        }else{
            this.finalitzat = false;
            System.out.println("\nEl projecte no està finalitzat");            
        }
        //preguntar a Ismael si tenemos que modificar al diseñador tambien
        //si se puede actualizar los datos solo para proyectos actuales o tambien finalizados?
                
        System.out.println("NIF del cliente");
        nifClient = DADES.nextLine();
        this.setNifClient(nifClient);
        
        System.out.println("Nuevo presupuesto del proyecto: ");
        presuppost = DADES.nextDouble();
        this.setPressupost(pressupost);
    }

    /*
     TODO
     Paràmetres: jardiner o jardinera a afegir
     Accions:
     - afegeix al vector jardiners del projecte actual el jardiner o jardinera
     passat/ada per paràmetre.
     - actualitza la posició del vector jardiners.
     Retorn: cap
     */
    public void addJardiner(Jardiner jardiner) {
        jardiners[posicioJardiners] = jardiner;
        posicioJardiners++;
    }

    public void showProjecte() {
        System.out.println("\nLes dades del projecte amb codi " + codi + " són:");
        System.out.println("\nNIF client: " + nifClient);
        System.out.println("\nPressupost: " + pressupost);
        dissenyador.showDissenyador();
        
        if(finalitzat){
            System.out.println("\nEl projecte està finalitzat");
        }else{
            System.out.println("\nEl projecte no està finalitzat");
        }

        for (int i = 0; i < posicioJardiners; i++) {
            jardiners[i].showJardiner();
        }
    }
    
}
