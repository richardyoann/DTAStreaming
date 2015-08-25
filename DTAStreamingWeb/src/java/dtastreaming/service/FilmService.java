/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Film;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class FilmService {
    /**
     * Ajouter un Film et prend en param un objet Film
     * @param f 
     */
    public void ajouter (Film f){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();        
        em.persist(f);
        em.getTransaction().commit();
    }
    /**
     * Modifier un Film et prend en param un objet Film
     * @param f 
     */
    public void modifier(Film f){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();        
    }
    /**
     * Suppression d'un film avec en parametre l'id du film
     * @param id 
     */
    public void supprimer(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        //Suppression avec le remove
        //Film f =new Film();
        //f.setId(id);
        //em.remove(f);
        
        //Plus simple et plus rapide
        //On creer une requete de suppression en passant en parametre l'id du film et on execute la requete
        em.createQuery("DELETE FROM Film f WHERE f.id=:idFilm").setParameter("idFilm", id).executeUpdate();        
        em.getTransaction().commit(); 
    }
    /**
     * Recherche un film en fonction de son ID
     * @param id
     * @return 
     */
    public Film rechercher(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
       return em.find(Film.class, id);
    }
    
    public Collection<Film> lister(){
       EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
       return em.createQuery("SELECT f FROM Film f ORDER BY f.titre").getResultList();
    }
}
