/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.trava.model.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pauloricardo
 */
@Entity
@Table(name = "tb_leituras")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbLeituras.findAll", query = "SELECT t FROM TbLeituras t")
    , @NamedQuery(name = "TbLeituras.findByIdLeitura", query = "SELECT t FROM TbLeituras t WHERE t.idLeitura = :idLeitura")
    , @NamedQuery(name = "TbLeituras.findByHrLeitura", query = "SELECT t FROM TbLeituras t WHERE t.hrLeitura = :hrLeitura")
    , @NamedQuery(name = "TbLeituras.findByDtLeitura", query = "SELECT t FROM TbLeituras t WHERE t.dtLeitura = :dtLeitura")})
public class TbLeituras implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_leitura")
    private Integer idLeitura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hr_leitura")
    @Temporal(TemporalType.TIME)
    private Date hrLeitura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dt_leitura")
    @Temporal(TemporalType.DATE)
    private Date dtLeitura;
    @JoinColumn(name = "id_proprietario", referencedColumnName = "id_proprietario")
    @ManyToOne
    private TbProprietario idProprietario;

    public TbLeituras() {
    }

    public TbLeituras(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public TbLeituras(Integer idLeitura, Date hrLeitura, Date dtLeitura) {
        this.idLeitura = idLeitura;
        this.hrLeitura = hrLeitura;
        this.dtLeitura = dtLeitura;
    }

    public Integer getIdLeitura() {
        return idLeitura;
    }

    public void setIdLeitura(Integer idLeitura) {
        this.idLeitura = idLeitura;
    }

    public Date getHrLeitura() {
        return hrLeitura;
    }

    public void setHrLeitura(Date hrLeitura) {
        this.hrLeitura = hrLeitura;
    }

    public Date getDtLeitura() {
        return dtLeitura;
    }

    public void setDtLeitura(Date dtLeitura) {
        this.dtLeitura = dtLeitura;
    }

    public TbProprietario getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(TbProprietario idProprietario) {
        this.idProprietario = idProprietario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLeitura != null ? idLeitura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLeituras)) {
            return false;
        }
        TbLeituras other = (TbLeituras) object;
        if ((this.idLeitura == null && other.idLeitura != null) || (this.idLeitura != null && !this.idLeitura.equals(other.idLeitura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.trava.model.entidades.TbLeituras[ idLeitura=" + idLeitura + " ]";
    }
    
}
