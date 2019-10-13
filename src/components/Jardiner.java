/*
 * Classe que defineix un jardiner o jardinera. Un jardiner o jardinera es defineix 
 * pel seu NIF, nom, torn de feina i estat, és a dir, actiu si està treballant o no actiu si està 
 * de baixa o vacances.
 */
package components;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Jardiner {
    private final static Scanner DADES = new Scanner(System.in);
    private String nif;
    private String nom;
    private Torn torn;
    private boolean actiu;
    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou jardiner o jardinera, el seu estat sempre és
     actiu, per tant li assignem verdader. I torn, ja que quan es crea un nou
     jardiner o jardinera aquest encara no té assignat cap torn, per tant li assignarem
     null.
     */
   
    public Jardiner(String nif, String nom){
        this.nif = nif;
        this.nom = nom;
        this.torn = null;
        this.actiu = actiu;
    }
    
    /*
     TODO Mètodes accessors    
     */
    public void setNif(String nif){
        this.nif=nif;
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
     
     public void setTorn(Torn torn){
        this.torn=torn;
     }
     
     public Torn getTorn(){
        return this.torn;
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
     - Demanar a l'usuari les dades per consola per crear un nou jardiner o nova
     jardinera. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou jardiner o nova jardinera creat/da.
     */
    public static Jardiner addJardiner() {
        String nif,nom;
        
        System.out.println("Introduce los datos de Jardinero/a");
        
        System.out.println("NIF de jardinero/a: ");        
        nif = DADES.nextLine();       
  
        System.out.println("El nombre de jardinero/a: ");
        nom = DADES.nextLine();

        return new Jardiner(nif,nom);               
    }
        
    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, menys de l'atribut torn.
     - En el cas de l'atribut actiu, li heu de demanar que si el jardiner o jardinera està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl jardiner o jardinera
     està en actiu", si el jardiner o jardinera està en actiu, i en cas contrari, el missatge 
     "\nEl jardiner o jardinera no està en actiu".
     Retorn: cap
     */
    public void updateJardiner() {
        String nif,nom;
        boolean actiu = true;
        int estado;
        
        //
        if (this.actiu == true){
            System.out.println("\\nEl jardiner/a està en actiu");           
        } else {
            System.out.println("\\nEl jardiner/a no està en actiu");   
        }
                
        System.out.println("Instroduce datos actuales del jardinero/a");
        
        System.out.println("Actualiza el NIF de jardinero/a");
        nif = DADES.nextLine();
        this.setNif(nif);
        
        System.out.println("Actualiza el nombre de jardinero/a ");
        nom = DADES.nextLine();
        this.setNom(nom);
                
        System.out.println("Actualiza el estado del jardinero/a. Activo corresponde a 1, No activo corresponde a 0");
        estado = DADES.nextInt();
        this.setActiu(actiu);   
        
        //Associamos el valor numerico a la definicion de dato "boolean" true or false.
        if (estado == 1){
            actiu = true;
        }else{
            actiu = false;
        }          
    }

    public void showJardiner() {
        System.out.println("\nLes dades del jardiner o jardinera amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        torn.showTorn();
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
}
