/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Casting;
import dtastreaming.entity.Pays;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class CastingService {
    /**
     * Ajouter un Film et prend en param un objet Casting 
     * @param C
     */
    public void ajouter (Casting c){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();        
        em.persist(c);
        em.getTransaction().commit();
    }
    /**
     * Modifier un Film et prend en param un objet Casting
     * @param c 
     */
    public void modifier(Casting c){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();        
    }
    /**
     * Suppression d'un film avec en parametre l'id du Casting
     * @param id 
     */
    public void supprimer(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
       
        em.createQuery("DELETE FROM Casting c WHERE c.id=:idCasting").setParameter("idCasting", id).executeUpdate();        
        em.getTransaction().commit(); 
    }
    /**
     * Recherche un Casting en fonction de son ID
     * @param id
     * @return 
     */
    public Casting rechercher(long id){
       EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
       return em.find(Casting.class, id);
    }
    
    public Collection<Casting> lister(){
       EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
       return em.createQuery("SELECT c FROM Casting c ORDER BY c.nom").getResultList();
    }
}
