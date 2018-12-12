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
    int param ;
    
    public GenerateurInfos(InfosInterface generateur, int param0) {
        this.generateur = generateur;
        this.param=param0;
    }
    
   /* public void setInfosInterface(InfosInterface generateur){
        this.generateur= generateur;
    }
   */
    
    public String fournirLesDonnees() {
        
        return generateur.genererInfos( message.valeur+" "+param);
    }

    
    public void init() {
          System.out.println("Le conteneur a initialisé GenerateurInfo");  
    }
    
    Message message;
    public void setMessage(Message msg) {
        this.message=msg;
    }
   
 }
