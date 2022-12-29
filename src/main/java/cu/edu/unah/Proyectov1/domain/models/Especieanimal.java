/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cu.edu.unah.Proyectov1.domain.models;

import cu.edu.unah.Proyectov1.model.EspecieanimalPK;
import cu.edu.unah.Proyectov1.model.Grupoanimal;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ashi
 */
@Entity
@Table(name = "especieanimal", catalog = "Consultor_Pecuario_Practica", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Especieanimal.findAll", query = "SELECT e FROM Especieanimal e"),
    @NamedQuery(name = "Especieanimal.findByIdEspecieAnimal", query = "SELECT e FROM Especieanimal e WHERE e.especieanimalPK.idEspecieAnimal = :idEspecieAnimal"),
    @NamedQuery(name = "Especieanimal.findByNombreEspecieAnimal", query = "SELECT e FROM Especieanimal e WHERE e.nombreEspecieAnimal = :nombreEspecieAnimal"),
    @NamedQuery(name = "Especieanimal.findByGrupoanimalidGrupoAnimal", query = "SELECT e FROM Especieanimal e WHERE e.especieanimalPK.grupoanimalidGrupoAnimal = :grupoanimalidGrupoAnimal")})
public class Especieanimal implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EspecieanimalPK especieanimalPK;
    @Basic(optional = false)
    @Column(name = "nombre_especie_animal")
    private String nombreEspecieAnimal;
    @JoinColumn(name = "grupoanimalid_grupo_animal", referencedColumnName = "id_grupo_animal", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private cu.edu.unah.Proyectov1.model.Grupoanimal grupoanimal;
    
   

    public Especieanimal() {
    }

    public Especieanimal(EspecieanimalPK especieanimalPK) {
        this.especieanimalPK = especieanimalPK;
    }

    public Especieanimal(EspecieanimalPK especieanimalPK, String nombreEspecieAnimal) {
        this.especieanimalPK = especieanimalPK;
        this.nombreEspecieAnimal = nombreEspecieAnimal;
    }

    public Especieanimal(int idEspecieAnimal, int grupoanimalidGrupoAnimal) {
        this.especieanimalPK = new EspecieanimalPK(idEspecieAnimal, grupoanimalidGrupoAnimal);
    }

    public EspecieanimalPK getEspecieanimalPK() {
        return especieanimalPK;
    }

    public void setEspecieanimalPK(EspecieanimalPK especieanimalPK) {
        this.especieanimalPK = especieanimalPK;
    }

    public String getNombreEspecieAnimal() {
        return nombreEspecieAnimal;
    }

    public void setNombreEspecieAnimal(String nombreEspecieAnimal) {
        this.nombreEspecieAnimal = nombreEspecieAnimal;
    }

    public cu.edu.unah.Proyectov1.model.Grupoanimal getGrupoanimal() {
        return grupoanimal;
    }

    public void setGrupoanimal(Grupoanimal grupoanimal) {
        this.grupoanimal = grupoanimal;
    }

   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (especieanimalPK != null ? especieanimalPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Especieanimal)) {
            return false;
        }
        Especieanimal other = (Especieanimal) object;
        if ((this.especieanimalPK == null && other.especieanimalPK != null) || (this.especieanimalPK != null && !this.especieanimalPK.equals(other.especieanimalPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultor_Pecuario_Practica.Especieanimal[ especieanimalPK=" + especieanimalPK + " ]";
    }
    
}