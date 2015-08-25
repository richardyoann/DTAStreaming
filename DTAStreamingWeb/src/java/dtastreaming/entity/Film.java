/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtastreaming.entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.eclipse.persistence.annotations.CascadeOnDelete;
/**
 *
 * @author ETY
 */
@Entity
public class Film implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    private String titre;  
    private Integer annee; 
    private Integer duree;
    @JoinTable(name = "film_genre", joinColumns = {@JoinColumn(name="film_id")},inverseJoinColumns = {@JoinColumn(name = "genre_id")})
    @ManyToMany   
    private Collection<Genre> genres =new ArrayList<Genre>();   
    // Creation de la relation 
    // Cle etrangere 
    @OneToMany (mappedBy = "film", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})    
    @CascadeOnDelete
    private Collection<Lien> liens = new ArrayList<Lien>();   
    // Creation de la relation 
    // Cle etrangere 
    @OneToMany (mappedBy = "film", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}) 
    @CascadeOnDelete
    private Collection<Film_Casting> filmcasting = new ArrayList<Film_Casting>(); 
    @ManyToOne
    @JoinColumn(name = "pays_id")
    private Pays pays;
    
    
   

    //GETTEUR SETTEUR
    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }
    public Collection<Genre> getGenres() {
        return genres;
    }

    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }   

    public Integer getAnnee() {
        return annee;
    }

    public void setAnnee(Integer annee) {
        this.annee = annee;
    }


    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Collection<Lien> getLiens() {
        return liens;
    }

    public Collection<Film_Casting> getFilmcasting() {
        return filmcasting;
    }

    public void setFilmcasting(Collection<Film_Casting> filmcasting) {
        this.filmcasting = filmcasting;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }
    
    //contructeur
    /**
     * constructeur par défault
     */
    public Film() {
    }  
    public Film(Long id, String titre, Integer annee, Integer duree) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
    }     
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dtastreaming.entity.Film[ id=" + id + " ]";
    }
    
}
