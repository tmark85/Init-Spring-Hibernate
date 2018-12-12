/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import javax.persistence.*;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
class Papier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private int id;
     
    private String titre;
    
    public Papier() {}
    
    public Papier(String titre) {this.titre=titre;}
    
}

@Entity
@PrimaryKeyJoinColumn(name="MAGAZINEID")
class Magazine extends Papier {
	
    private String frequence;
    
    Magazine() {}
    
    Magazine(String titre, String frequence) {
        super(titre);
        this.frequence=frequence;
    }
    
}

@Entity
@PrimaryKeyJoinColumn(name="MAGAZINE2ID")
class Magazine2 extends Papier {
	
    private String frequence;
    
    Magazine2() {}
    
    Magazine2(String titre, String frequence) {
        super(titre);
        this.frequence=frequence;
    }
    
}
