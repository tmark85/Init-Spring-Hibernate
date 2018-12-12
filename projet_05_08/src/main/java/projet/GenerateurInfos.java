/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author trainer
 */

public class GenerateurInfos {
    
    Map<String,InfosInterface> generateurs = new HashMap<String, InfosInterface>() ;
    int param ;
    
    public GenerateurInfos(int param0) {
          this.param=param0;
    }
    
    public void setInfos1(InfosInterface gen){
        this.generateurs.put("k1",gen);
    }
    public void setInfos2(InfosInterface gen){
        this.generateurs.put("k2",gen);
    }
    
    public String fournirLesDonnees() {
        String retval="";
        
        for( InfosInterface ii : generateurs.values()) {
         retval+= ii.genererInfos( message.valeur+" "+param)+"\n";
        }
        
        return retval;
    }

    
    public void init() {
          System.out.println("Le conteneur a initialisé ...");  
    }
    
    Message message;
    public void setMessage(Message msg) {
        this.message=msg;
    }
   
 }
