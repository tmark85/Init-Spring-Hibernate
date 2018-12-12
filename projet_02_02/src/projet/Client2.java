/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author trainer
 */
@Entity
@Table(name="CLIENT2")
public class Client2 {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column( name="ID")
    private int id;
    
    @Column(name="NOM")
    private String nom;
    
    @ManyToOne @JoinColumn(name="adresseId",unique = true,nullable = false) 
    private Adresse2 adresse;
    
    public Adresse2 getAdresse() {
		return adresse;
	}

	public Client2(String nom,Adresse2 adresse) { 
        this.nom=nom;
        this.adresse=adresse;
    }
	
	public Client2() { 
	}
    
    @Override
    public String toString(){ return "Id : "+id+" nom : "+nom;}
    
}
