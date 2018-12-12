/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author trainer
 */
public class Projet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext contexte = 
                new ClassPathXmlApplicationContext("maconfig.xml");
       
        //ClientDAO service = contexte.getBean(ClientDAOImpl.class);
        
        ClientService service = contexte.getBean(ClientServiceImpl.class);
        
        Client c= new Client("Rasori");
        service.store(c);
        
        Client retour = service.findById(1);
        
        System.out.println("Client retrouvé "+retour);
        
        
        Client c2= new Client("Rasori");
        service.store(c2);
        
        List<Client> lesClients = service.findAll();
        for(Client cc : lesClients) {
            System.out.println("Les clients : "+cc);
        }
        ((ConfigurableApplicationContext) contexte).close();   
    }
    
}
