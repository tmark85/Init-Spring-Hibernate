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
import javax.persistence.Table;

/**
 *
 * @author trainer
 */
@Entity
@Table(name="CLIENT1")
public class Client1 {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    
    @Column(name="NOM", length=100, nullable=false)
    private String nom;
   
    
    public String toString() {
        return id+" : "+nom;
    }
        
    public Client1(String nom) { this.nom=nom;}
}
