/*
 * Classe que defineix un dissenyador o dissenyadora. Un dissenyador o dissenyadora
 * es defineix pel seu nif, nom i estat, és a dir, actiu si està treballant o no 
 * actiu si està de baixa o vacances.
 */
package components;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Dissenyador {
    private final static Scanner DADES = new Scanner(System.in);
    private String nif;
    private String nom;
    private boolean actiu;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou dissenyador o dissenyadora, el seu estat sempre es
     actiu, per tant li assignem verdader.
     */

    public Dissenyador(String nif, String nom){
        this.nif = nif;
        this.nom = nom;
        this.actiu = true;
    }   
    /*
     TODO Mètodes accessors    
     */   
    public void setNif(String nif){
        this.nif = nif;
    }
    public String getNif(){
        return this.nif;
    }    
    public void setNom(String nom){
        this.nom = nom;
    }
    public String getNom(){
        return this.nom;
    }

    public void setActiu(boolean actiu){
        this.actiu = actiu;
    }
    
    public boolean getActiu(){
        return this.actiu;
    }
    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou dissenyador o nova
     dissenyadora. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou dissenyador o nova dissenyadora creat/da.
     */    
    public static Dissenyador addDissenyador() {
        String nif,nom;
        
        System.out.println("Introduce los datos del nuevo diseñador");
        
        System.out.println("El nombre del diseñador/a: ");
        nom = DADES.nextLine();
     
        System.out.println("Introduce el NIF del diseñador/a");
        nif = DADES.nextLine();   
        
        return new Dissenyador(nif, nom);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - En el cas de l'atribut actiu, li heu de demanar que si el dissenyador o dissenyadora està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl dissenyador
     o dissenyadora està en actiu", si el dissenyador o dissenyadora està en actiu,
     i en cas contrari, el misaatge "\nEl dissenyador o dissenyadora no està en actiu".
     Retorn: cap
     */
    
    public void updateDissenyador() {
        String nif, nom;
        int estado;
        
        System.out.println("Instroduce datos actuales del diseñador/a");
        
        System.out.println("Instroduce el NIF del diseñador/a");
        nif = DADES.nextLine();
        this.setNif(nif);

        System.out.println("Introduce el nombre del diseñador/a");
        nom = DADES.nextLine();
        this.setNom(nom);
        
        System.out.println("Actualiza el estado del diseñador/a. 'Activo'corresponde al número 1,'No activo'corresponde al número 0");
        estado = DADES.nextInt();
        this.setActiu(actiu);   
        
        //Associamos el valor numerico a la definicion de dato "boolean" true or false.
        if (estado == 1){
            actiu = true;
        }else{
            actiu = false;
        }
    }
 
    public void showDissenyador() {
        System.out.println("\nLes dades del dissenyador o dissenyadora amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
}