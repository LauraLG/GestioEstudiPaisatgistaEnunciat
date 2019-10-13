/*
 * Classe que defineix un torn. Un torn es defineix pel seu codi, nom, hora d'inici
 * i hora d'acabament del torn.
 */
package components;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Torn {
    private final static Scanner DADES = new Scanner(System.in);
    private String codi;
    private String nom;
    private String horaInici;
    private String horaAcabament;
    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */
    
    public Torn(String codi, String nom, String horaInici, String horaAcabament){
        this.codi = codi;
        this.nom = nom;
        this.horaInici = horaInici;
        this.horaAcabament = horaAcabament;
    }

    /*
     TODO Mètodes accessors    
     */
    public void setCodi(String codi){
        this.codi = codi;
    }
    
    public String getCodi(){
        return this.codi;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public void setHoraInici(String horaInici){
        this.horaInici = horaInici;
    }
    
    public String getHoraInici(){
        return this.horaInici;
    }
    
    public void setHoraAcabament(String horaAcabament){
        this.horaAcabament = horaAcabament;
    }
    
    public String getHoraAcabament(){
        return this.horaAcabament;
    }
    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou torn. Les dades 
     a demanar són les que passem per paràmetre en el constructor.
     - Per assignar les hores d'inici i acabamanet del torn, heu d'utilitzar el mètode
     escaient d'aquesta classe.
     Retorn: El nou torn creat.
     */
    public static Torn addTorn() {
        String codi, nom, horaInici, horaAcabament;
        
        System.out.println("Introduce los datos del nuevo turno");
        
        System.out.println("Codi del turno:");
        codi = DADES.nextLine();

        System.out.println("El nombre del turno: ");
        nom = DADES.nextLine();
        
        System.out.println("Introduce la hh:mm de Inicio ");
        horaInici = horesTorn();
        
        System.out.println("Introduce la hh:mm de Fin: ");
        horaAcabament = horesTorn();
        
        return new Torn(codi, nom, horaInici, horaAcabament);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte (Penseu com heu de
     modificar les hores d'inici i d'acabament del torn).
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     Retorn: cap
     */
    public void updateTorn() {
        String codi, nom, horaInici, horaAcabament;
        System.out.println("Instroduce los nuevos datos del turno");
        
        System.out.println("El código del turno: ");
        codi = DADES.nextLine();
        this.setCodi(codi);
        
        System.out.println("El nombre del turno: ");
        nom = DADES.nextLine();
        this.setNom(nom);
               
        System.out.println("Introduce la hora de Inicio del turno");
        horaInici = horesTorn();
        this.setHoraInici(horaInici);
        
        System.out.println("Intriduce la hora de Fin de turno");
        horaAcabament = horesTorn();
        this.setHoraAcabament(horaAcabament);
    }

    public void showTorn() {
        System.out.println("\nLes dades del torn amb codi " + codi + " són: ");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHora d'inici: " + horaInici);
        System.out.println("\nHora d'acabament: " + horaAcabament);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear les hores d'inici o acabament
     d'un torn.
     - Tant l'hora d'inici com la d'acabament, han de tenir el format "hh:mm", on
     hh és l'hora en format 24 hores i mm els minuts. Perquè es respecti el format,
     primer demanarem l'hora a l'usuari i després els minuts. El mateix mètode és
     el que haurà de crear el format correcte amb les dades introduïdes per l'usuari.
     - Heu de controlar que les hores i minuts introduïts siguin correctes. Si no 
     és així, se li tornaran a demanar a l'usuari fins que introdueixi unes dades correctes.
     Retorn: Les hores d'inici o acabament del torn.
     */
    public static String horesTorn() {
/**
 * la hora esta entre 0 22 y la lala tenemos que confirmar, pedir la hora pero tambien los minutos, tenemos
 * que juntarlo luego.
 * Leer una hora. Dime los datos de este turno y devuelve estas horas y minutos
 * lo llmas 2 veces
 */
    int hora, min;
    Calendar calendar = Calendar.getInstance();

    System.out.println("Introduce la hora en formato 'hh 00 – 23': ");
    hora = DADES.nextInt();    
        if (hora>=00 && hora<24){
            calendar.set(Calendar.HOUR, hora);
        }else{
            System.out.println("Los datos incorrectos, sigue el formato 'hh 00 – 23'");
        }
      
    System.out.println("Instroduce los minutos en formato 'mm 00-59': ");
    min = DADES.nextInt();      
        if (min>=00 && min<=59){
            calendar.set(Calendar.MINUTE, min);    
        }else{
            System.out.println("Los datos incorrectos, sigue el formato 'mm 00-59'");
        }
        return hora + ":" + min;
    }
}