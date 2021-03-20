package com.example.premierprojet;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv_console;
    Button bt_ajouter, bt_supp_dernier;
    Button bt_ajouter_plusieurs;
    Button supprimer_dernier;
    EditText et_nom;
    EditText et_prenom;
    SeekBar sb;


    //données
    ArrayList<EleveBean> eleves;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //interagir avec text view
        tv_console = (TextView) findViewById(R.id.tv_console);
        // tv_console.setText("coucou");
        bt_ajouter = (Button) findViewById(R.id.bt_ajouter);
        et_nom = (EditText) findViewById(R.id.et_nom);
        et_prenom = (EditText) findViewById(R.id.et_prenom);
        sb = (SeekBar) findViewById(R.id.sb);
        bt_ajouter_plusieurs = (Button) findViewById(R.id.bt_ajouter_plusiers);
        bt_supp_dernier = (Button) findViewById(R.id.bt_supprimer_dernier);


        bt_ajouter.setOnClickListener(this);
        bt_supp_dernier.setOnClickListener(this);
        bt_ajouter_plusieurs.setOnClickListener(this);/**/
        // une nouvelle liste;
        //creation
        eleves = new ArrayList<>();
        //prenoms = new ArrayList<>();

        tv_console.setText("");
    }

    @Override
    public void onClick(View v) {

        if (v == bt_ajouter) {
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            ajouter(nom, prenom, 100000);
            //tv_console.setText("supprimer_dernier");
            //eleves.clear(); //effacer la memore
            refraichirEcran();

        } else if (v == bt_ajouter_plusieurs) {
            int nb = sb.getProgress();
            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();
            ajouterOpti(nom, prenom, nb);
            refraichirEcran();

        } else if (v == bt_supp_dernier) {

            String nom = et_nom.getText().toString();
            String prenom = et_prenom.getText().toString();

            ajouterOpti(nom, prenom, 100000);
            eleves.clear(); //effacer la memore
            refraichirEcran();
            //SupprimerDernier();
            //refraichirEcran();
            // tv_console.setText("supprimer_dernier");
        }
        //tv_console.append("click");
    }

    /*
        public String concat(String nom, String prenom) {
            String result = "nom : " + nom + "\n prenom : " + prenom;
            if (nom.length() == 0) {
                return "le nom est vide";
            }
            return result;
        }
    */
    //ajouer plusiers nom et prenom
    public void ajouter(String nom, String prenom, int nb) {

        //afficher un message si le nom et prenom est vide
        if (nom.length() == 0) {
            Toast.makeText(this, " nom est vide", Toast.LENGTH_SHORT).show();
            return;
        }
        if (prenom.length() == 0) {
            Toast.makeText(this, " prenom est vide", Toast.LENGTH_SHORT).show();
            return;
        }
        // int i = 0;
//        while (i < nb) { //pour sb
//            tv_console.append(nom + " " + prenom + i + "\n");
//            i++;
//        }
//        //tv_console.append(nom + " " + prenom + "\n");
        //autre methode
        //EleveBean eleve;
        for (int i = 0; i <= nb; i++) {
            EleveBean eleve = new EleveBean();
            eleve.setNom(nom);
            eleve.setPrenom(prenom + eleves.size()); //pour qu'il aiet prenoms differents il faut ajouter la taille de la liste'
            //Random random = new Random();
            //eleve.setAge(random.nextInt(100));

            eleves.add(eleve);
            //tv_console.append(nom + " " + prenom + i + "\n");
        }
    }


    public void ajouterOpti(String nom, String prenom, int nb) {

        //afficher un message si le nom et prenom est vide
        if (nom.length() == 0) {
            Toast.makeText(this, " nom est vide", Toast.LENGTH_SHORT).show();
            return;
        }
        if (prenom.length() == 0) {
            Toast.makeText(this, " prenom est vide", Toast.LENGTH_SHORT).show();
            return;
        }
//        //tv_console.append(nom + " " + prenom + "\n");
        //autre methode
        Random random = new Random();
        for (int i = 0; i <= nb; i++) {
            EleveBean eleve = new EleveBean();
            eleve.setNom(nom);
            eleve.setPrenom(prenom +eleves.size()); //pour qu'il aiet prenoms differents il faut ajouter la taille de la liste'
            //Random random = random.nextInt(100);
            eleve.setAge(random.nextInt(100));
            eleves.add(eleve);
            //tv_console.append(nom + " " + prenom + i + "\n");
        }
    }


    public void refraichirEcran() {
        String resultat = "";

       /* for (int i = 0; i < eleves.size(); i++) {
            resultat += eleve.nom + " "+eleve.prenom + "\n";
        }*/

        for (EleveBean eleve : eleves) {
            if (eleve.isAdulte()) {
                resultat += "Adult";
            } else {
                resultat += "Enfant";
            }
            resultat += eleve.getNom() + " " + eleve.getPrenom() + "\n";
        }
        tv_console.setText(resultat);
    }

    public void SupprimerDernier() {

        if (eleves.isEmpty()) { //condition pour eviter le beug
            Toast.makeText(this, " La liste est vide", Toast.LENGTH_SHORT).show();
        } else {
            eleves.remove(eleves.size() - 1);
        }
    }

}
