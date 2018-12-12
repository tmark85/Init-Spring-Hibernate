/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import javax.persistence.*;

/**
 *
 * @author trainer
 */
@Entity

public class Livre extends Document{
           
    @Column(name="AUTEUR")
    private String auteur;
    
    public Livre() {}
    
    public Livre ( String titre, String auteur){
        super(titre);
        this.auteur = auteur;
    }
}


@Entity
class Livre2 extends Document{
           
    @Column(name="AUTEUR")
    private String auteur;
    
    public Livre2() {}
    
    public Livre2 ( String titre, String auteur){
        super(titre);
        this.auteur = auteur;
    }
}
