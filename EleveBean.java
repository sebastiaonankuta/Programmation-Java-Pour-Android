package com.example.premierprojet;

import java.util.Random;

public class EleveBean {
    public static final int AGE_ADULT =18;
    private String nom, prenom;

       //attributs
    private static final Random random = new Random();
    private int Age;

    //constructeur
    public EleveBean(){
        Age = random.nextInt(100);
    }

    //contructeur avec parametre
    public EleveBean(int Age){
        this.Age = Age;

    }

    public boolean isAdulte(){
        return Age>= AGE_ADULT;
    }


//'''''''''''''''''''''''''''''''''''''''''
    ///+GETTER   SETTER
//''''''''''''''''''''''''''''''''''''''
    public void setAge(int Age){
       this.Age = Age;
    }

    public static int getAgeAdult() {
        return AGE_ADULT;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge(){
        return Age;
    }
   /* public static boolean isAdultStatic(){
        return Age>= AGE_ADULT;
    }*/

}
