/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.test;
import javax.persistence.Persistence;
import org.junit.Test;



/**
 *
 * @author ETY
 */
public class listeFilm {
    @Test
    public void createDB()
    {
        Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();
    }
   // @Test
//    public void  listeFilm() {
//         System.out.println("Film francais");
//         EntityManager en = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();                 
//         Collection<Film> filmFrancais =  en.createQuery("SELECT f FROM Film f, Pays p WHERE f.pays.id = p.id AND p.id='France'").getResultList();
//         for (Film filmFrancai : filmFrancais) {
//             System.out.println(filmFrancai.getTitre());
//        }
//    }
//   // @Test
//    public void  listeFilmAction() {
//         System.out.println("Film d'actions");
//         EntityManager en = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();                 
//         Collection<Film> filmFrancais =  en.createQuery("SELECT f FROM Film f JOIN f.genres g where  g.intitule='Action'").getResultList();
//         for (Film filmFrancai : filmFrancais) {
//             System.out.println(filmFrancai.getTitre());
//        }
//    }
//   // @Test
//    public void  listeFilmActionFrancais() {
//         System.out.println("Film d'actions Francais ");
//         EntityManager en = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();                 
//         Collection<Film> filmFrancais =  en.createQuery("SELECT f FROM Film f JOIN f.genres g JOIN f.pays p WHERE g.intitule='Action' AND p.id ='France'").getResultList();
//         for (Film filmFrancai : filmFrancais) {
//             System.out.println(filmFrancai.getTitre());
//        }
//    }
//   // @Test
//    public void  listeFilmSansLien() {
//         System.out.println("Film sans liens ");
//         EntityManager en = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();                 
//         Collection<Film> filmFrancais =  en.createQuery("SELECT f FROM Film  f  where 0 =(select count(l) FROM f.liens l) ").getResultList();
//         for (Film filmFrancai : filmFrancais) {
//             System.out.println(filmFrancai.getTitre());
//        }
//    }
//    
//    //@Test
//    public void  listeFilmSansLien1() {
//         System.out.println("Film sans liens ");
//         EntityManager en = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();                 
//         Collection<Film> filmFrancais =  en.createQuery( ""
//                 + "SELECT  f "
//                 + "FROM    Film f "
//                 + "WHERE   f.id NOT IN (   SELECT  f2.id  "
//                 + "                        FROM    Lien l JOIN l.film f2 "
//                 + "                        WHERE   f2.id=f.id)").getResultList();
//         for (Film filmFrancai : filmFrancais) {
//             System.out.println(filmFrancai.getTitre());
//        }
//    }
//    
//    @Test
//    public void  listeFilmGenrenotTarantino() {
//         System.out.println("listeFilmGenrenotTarantino ");
//         EntityManager en = Persistence.createEntityManagerFactory("DTAStreamingPU").createEntityManager();                 
//         Collection<Genre> filmFrancais =  en.createQuery("SELECT f2 FROM Film f2 JOIN f2.genres g2 WHERE g2.id NOT IN( SELECT g.id FROM Genre g JOIN g.films f JOIN f.filmcasting fc JOIN fc.casting c WHERE c.nom ='luc bessons' AND fc.role=dtastreaming.entity.Role.REALISATEUR)").getResultList();
//         
//         System.out.println( filmFrancais );
//    }
}
