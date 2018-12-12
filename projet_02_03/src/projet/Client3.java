/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author trainer
 */
@Entity
@Table(name="CLIENT3")
public class Client3 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column( name="ID")
    private int id;
    
    @Column(name="NOM")
    private String nom;
        
    @OneToOne
    private Adresse3 adresse;
    
    @OneToMany(mappedBy="client")
    private Set<Facture3> factures = new HashSet<Facture3>();
       
    public Client3 (){};
    
    public Client3(String nom,Adresse3 adresse) { 
        this.nom=nom;
        this.adresse=adresse;
    }
    
    @Override
    public String toString(){ return "Id : "+id+" nom : "+nom;}

    Adresse3 getAdresse() {
            return adresse;
    }

    String getNom() {
        return nom;
    }
    
    int getId(){
    	return id;
    }

    void addFacture(Facture3 facture) {
        factures.add(facture);
    }

    Iterable<Facture3> getFactures() {
        return factures;
    }

   
    
    

    
}
