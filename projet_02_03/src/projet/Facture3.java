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
@Table(name="FACTURE3")
public class Facture3 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    
    @Column(name="TOTALTTC")
    private double totalTTC;
    
    @ManyToOne @JoinColumn(name="CLIENTID")
    private Client3 client;
    
    public Facture3() {}
    
    public Facture3 (Client3 c, double mt) {
        this.client=c;
        c.addFacture(this);
        this.totalTTC = mt;
    }
    
    @Override
    public String toString() {
        return "Id : "+id+ " total : "+totalTTC+ "  pour : "+((client!= null) ? client.getNom() : "");
    }
}