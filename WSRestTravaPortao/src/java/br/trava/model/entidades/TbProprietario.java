/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.trava.model.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pauloricardo
 */
@Entity
@Table(name = "tb_proprietario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProprietario.findAll", query = "SELECT t FROM TbProprietario t")
    , @NamedQuery(name = "TbProprietario.findByIdProprietario", query = "SELECT t FROM TbProprietario t WHERE t.idProprietario = :idProprietario")
    , @NamedQuery(name = "TbProprietario.findByCodHex", query = "SELECT t FROM TbProprietario t WHERE t.codHex = :codHex")
    , @NamedQuery(name = "TbProprietario.findByProprietario", query = "SELECT t FROM TbProprietario t WHERE t.proprietario = :proprietario")
    , @NamedQuery(name = "TbProprietario.findByDataInicio", query = "SELECT t FROM TbProprietario t WHERE t.dataInicio = :dataInicio")
    , @NamedQuery(name = "TbProprietario.findByDataFim", query = "SELECT t FROM TbProprietario t WHERE t.dataFim = :dataFim")})
public class TbProprietario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proprietario")
    private Integer idProprietario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "cod_hex")
    private String codHex;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "proprietario")
    private String proprietario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data_fim")
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @OneToMany(mappedBy = "idProprietario")
    private Collection<TbLeituras> tbLeiturasCollection;

    public TbProprietario() {
    }

    public TbProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }

    public TbProprietario(Integer idProprietario, String codHex, String proprietario, Date dataInicio, Date dataFim) {
        this.idProprietario = idProprietario;
        this.codHex = codHex;
        this.proprietario = proprietario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Integer getIdProprietario() {
        return idProprietario;
    }

    public void setIdProprietario(Integer idProprietario) {
        this.idProprietario = idProprietario;
    }

    public String getCodHex() {
        return codHex;
    }

    public void setCodHex(String codHex) {
        this.codHex = codHex;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @XmlTransient
    public Collection<TbLeituras> getTbLeiturasCollection() {
        return tbLeiturasCollection;
    }

    public void setTbLeiturasCollection(Collection<TbLeituras> tbLeiturasCollection) {
        this.tbLeiturasCollection = tbLeiturasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProprietario != null ? idProprietario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProprietario)) {
            return false;
        }
        TbProprietario other = (TbProprietario) object;
        if ((this.idProprietario == null && other.idProprietario != null) || (this.idProprietario != null && !this.idProprietario.equals(other.idProprietario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.trava.model.entidades.TbProprietario[ idProprietario=" + idProprietario + " ]";
    }
    
}
