/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;


import dtastreaming.entity.Pays;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class PaysService {
    /**
     * Ajouter un Film et prend en param un objet Film
     * @param p 
     */
    public void ajouter (Pays p){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();        
        em.persist(p);
        em.getTransaction().commit();
    }
    /**
     * Modifier un Film et prend en param un objet Film
     * @param p
     */
    public void modifier(Pays p){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();        
    }
    /**
     * Suppression d'un film avec en parametre l'id du film
     * @param id 
     */
    public void supprimer(String id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        //Suppression avec le remove
        //Film f =new Film();
        //f.setId(id);
        //em.remove(f);
        
        //Plus simple et plus rapide
        //On creer une requete de suppression en passant en parametre l'id du film et on execute la requete
        em.createQuery("DELETE FROM Pays p WHERE p.id=:idPays").setParameter("idPays", id).executeUpdate();        
        em.getTransaction().commit(); 
    }
    /**
     * Recherche un film en fonction de son ID
     * @param id
     * @return 
     */
    public Pays rechercher(String id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
       return em.find(Pays.class, id);
    }
    
    public Collection<Pays> lister(){
       EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
       return em.createQuery("SELECT p FROM Pays p ORDER BY p.id").getResultList();
    }
}
