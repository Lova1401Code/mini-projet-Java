/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import controlleur.MpianatraJpaController;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Ramih
 */
public class Connection {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence2PU");
    private static MpianatraJpaController etudiantjpacontrol = new MpianatraJpaController(emf);
    private static EntityManager emc = emf.createEntityManager();

    public static MpianatraJpaController getEtudiantjpacontrol() {
        return etudiantjpacontrol;
    }

    public static void setEtudiantjpacontrol(MpianatraJpaController etudiantjpacontrol) {
        Connection.etudiantjpacontrol = etudiantjpacontrol;
    }

    public static EntityManager getEmc() {
        return emc;
    }

    public static void setEmc(EntityManager emc) {
        Connection.emc = emc;
    }
    

    
}

