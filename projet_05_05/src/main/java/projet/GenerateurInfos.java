/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

/**
 *
 * @author trainer
 */

public class GenerateurInfos {
    
    InfosInterface generateur ;
    
    public GenerateurInfos(InfosInterface generateur, int param0) {
        this.generateur = generateur;
    }
    
   /* public void setInfosInterface(InfosInterface generateur){
        this.generateur= generateur;
    }
   */
    
    public String fournirLesDonnees() {
        return generateur.genererInfos();
    }

    
    public void init() {
          System.out.println("Le conteneur a initialisé ...");  
    }
    
 }
