/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ramih
 */
@Entity
@Table(name = "mpianatra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mpianatra.findAll", query = "SELECT m FROM Mpianatra m")
    , @NamedQuery(name = "Mpianatra.findById", query = "SELECT m FROM Mpianatra m WHERE m.id = :id")
    , @NamedQuery(name = "Mpianatra.findByNomMp", query = "SELECT m FROM Mpianatra m WHERE m.nomMp = :nomMp")
    , @NamedQuery(name = "Mpianatra.findByPrenomMp", query = "SELECT m FROM Mpianatra m WHERE m.prenomMp = :prenomMp")
    , @NamedQuery(name = "Mpianatra.findByMatricule", query = "SELECT m FROM Mpianatra m WHERE m.matricule = :matricule")})
public class Mpianatra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom_mp")
    private String nomMp;
    @Basic(optional = false)
    @Column(name = "prenom_mp")
    private String prenomMp;
    @Basic(optional = false)
    @Column(name = "matricule")
    private String matricule;

    public Mpianatra() {
    }

    public Mpianatra(Integer id) {
        this.id = id;
    }

    public Mpianatra(Integer id, String nomMp, String prenomMp, String matricule) {
        this.id = id;
        this.nomMp = nomMp;
        this.prenomMp = prenomMp;
        this.matricule = matricule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomMp() {
        return nomMp;
    }

    public void setNomMp(String nomMp) {
        this.nomMp = nomMp;
    }

    public String getPrenomMp() {
        return prenomMp;
    }

    public void setPrenomMp(String prenomMp) {
        this.prenomMp = prenomMp;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
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
        if (!(object instanceof Mpianatra)) {
            return false;
        }
        Mpianatra other = (Mpianatra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modele.Mpianatra[ id=" + id + " ]";
    }
    
}
