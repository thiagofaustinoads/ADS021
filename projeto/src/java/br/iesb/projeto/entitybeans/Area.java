package br.iesb.projeto.entitybeans;

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


@Entity
@Table(name = "areas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT m FROM Area m")
    , @NamedQuery(name = "Area.findById", query = "SELECT m FROM Area m WHERE m.id = :id")
    , @NamedQuery(name = "Area.findByCondominio", query = "SELECT m FROM Area m WHERE m.condominio = :condominio")
    , @NamedQuery(name = "Area.findByArea", query = "SELECT m FROM Area m WHERE m.area = :area")
    , @NamedQuery(name = "Area.findBySituacao", query = "SELECT m FROM Area m WHERE m.situacao = :situacao")
            })
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "condominio")
    private int condominio;
    @Basic(optional = false)
    @Column(name = "area")
    private String area;
    @Basic(optional = false)
    @Column(name = "situacao")
    private int situacao;


    public Area() {
    }

    public Area(Integer id) {
        this.id = id;
    }

    public Area(Integer id, int condominio, String area, int situacao) {
        this.id = id;
        this.condominio = condominio;
        this.area = area;
        this.situacao = situacao;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCondominio() {
        return condominio;
    }

    public void setCondominio(int condominio) {
        this.condominio = condominio;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getSituacao() {
        return situacao;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
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
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.iesb.projeto.entitybeans.Area[ id=" + id + " ]";
    }
    
}
