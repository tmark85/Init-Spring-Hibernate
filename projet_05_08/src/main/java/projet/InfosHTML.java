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
public class InfosHTML implements InfosInterface{

    public String genererInfos(String msg) {
        return "<HTML>"+msg+"</HTML>";
    }
    
}
