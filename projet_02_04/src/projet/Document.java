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
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Document {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;
    
    
    @Column(name="TITRE")
    private String titre;
    
    public Document() {}
    
    public Document(String titre) {
        this.titre=titre;
    }
}
