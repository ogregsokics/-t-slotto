/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

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
@Table(name = "lotto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lotto.findAll", query = "SELECT l FROM Lotto l")
    , @NamedQuery(name = "Lotto.findById", query = "SELECT l FROM Lotto l WHERE l.id = :id")
    , @NamedQuery(name = "Lotto.findBySorsolt", query = "SELECT l FROM Lotto l WHERE l.sorsolt = :sorsolt")
    , @NamedQuery(name = "Lotto.findByTippek", query = "SELECT l FROM Lotto l WHERE l.tippek = :tippek")
    , @NamedQuery(name = "Lotto.findByTalalatok", query = "SELECT l FROM Lotto l WHERE l.talalatok = :talalatok")
    , @NamedQuery(name = "Lotto.findByTalalatokszama", query = "SELECT l FROM Lotto l WHERE l.talalatokszama = :talalatokszama")
    , @NamedQuery(name = "Lotto.findByElsosor", query = "SELECT l FROM Lotto l WHERE l.elsosor = :elsosor")
    , @NamedQuery(name = "Lotto.findByMasodiksor", query = "SELECT l FROM Lotto l WHERE l.masodiksor = :masodiksor")})
public class Lotto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "sorsolt")
    private String sorsolt;
    @Basic(optional = false)
    @Column(name = "tippek")
    private String tippek;
    @Basic(optional = false)
    @Column(name = "talalatok")
    private String talalatok;
    @Column(name = "talalatokszama")
    private Integer talalatokszama;
    @Basic(optional = false)
    @Column(name = "elsosor")
    private String elsosor;
    @Basic(optional = false)
    @Column(name = "masodiksor")
    private String masodiksor;

    public Lotto() {
    }

    public Lotto(Integer id) {
        this.id = id;
    }

    public Lotto(Integer id, String sorsolt, String tippek, String talalatok, String elsosor, String masodiksor) {
        this.id = id;
        this.sorsolt = sorsolt;
        this.tippek = tippek;
        this.talalatok = talalatok;
        this.elsosor = elsosor;
        this.masodiksor = masodiksor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSorsolt() {
        return sorsolt;
    }

    public void setSorsolt(String sorsolt) {
        this.sorsolt = sorsolt;
    }

    public String getTippek() {
        return tippek;
    }

    public void setTippek(String tippek) {
        this.tippek = tippek;
    }

    public String getTalalatok() {
        return talalatok;
    }

    public void setTalalatok(String talalatok) {
        this.talalatok = talalatok;
    }

    public Integer getTalalatokszama() {
        return talalatokszama;
    }

    public void setTalalatokszama(Integer talalatokszama) {
        this.talalatokszama = talalatokszama;
    }

    public String getElsosor() {
        return elsosor;
    }

    public void setElsosor(String elsosor) {
        this.elsosor = elsosor;
    }

    public String getMasodiksor() {
        return masodiksor;
    }

    public void setMasodiksor(String masodiksor) {
        this.masodiksor = masodiksor;
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
        if (!(object instanceof Lotto)) {
            return false;
        }
        Lotto other = (Lotto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "backend.Lotto[ id=" + id + " ]";
    }

}
