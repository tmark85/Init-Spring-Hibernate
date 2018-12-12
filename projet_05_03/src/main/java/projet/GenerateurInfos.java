/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import javax.annotation.PostConstruct;

/**
 *
 * @author trainer
 */

public class GenerateurInfos {
    
    private InfosInterface generateur ;
    
    
    public void setInfosInterface(InfosInterface generateur){
        this.generateur= generateur;
    }
          
    public String fournirLesDonnees() {
        return generateur.genererInfos();
    }

    @PostConstruct
    public void initIt() {
          System.out.println("Le conteneur a initialisé..");  
    }
    
    public void cleanup() {
          System.out.println("Le conteneur va se débarasser de ...");  
    }
}
