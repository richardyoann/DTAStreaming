/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.service;

import dtastreaming.entity.Film_Casting;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author ETY
 */
public class FilmCastingService {
    
    public Collection<Film_Casting> lister(){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        return em.createQuery("SELECT fc FROM Film_Casting fc ORDER BY fc.role").getResultList();
    }
    
    public Film_Casting rechercher(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        return em.find(Film_Casting.class, id);
    }
    
    public void supprimer(long id){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        /*FilmCasting fc = new FilmCasting();    //EQUIVALENT A
        fc.setId(id);                            //     |  
        em.remove(fc);*/                         //     V
        em.createQuery("DELETE FROM Film_Casting fc WHERE fc.id=:idFilmCasting").setParameter("idFilmCasting", id).executeUpdate();
        em.getTransaction().commit();
    }
    
    public void modifier(Film_Casting fc){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.merge(fc);
        em.getTransaction().commit();
    }
    
    public void ajouter(Film_Casting fc){
        EntityManager em = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
        em.getTransaction().begin();
        em.persist(fc);
        em.getTransaction().commit();
    }
}
