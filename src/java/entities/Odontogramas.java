/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "odontogramas")
@NamedQueries({
    @NamedQuery(name = "Odontogramas.findAll", query = "SELECT o FROM Odontogramas o"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaId", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaId = :odontogramaId"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaPieza", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaPieza = :odontogramaPieza"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaCuadrante", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaCuadrante = :odontogramaCuadrante"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaOclusal", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaOclusal = :odontogramaOclusal"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaVestibular", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaVestibular = :odontogramaVestibular"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaMesial", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaMesial = :odontogramaMesial"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaDistal", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaDistal = :odontogramaDistal"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaLingual", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaLingual = :odontogramaLingual"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaPalatina", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaPalatina = :odontogramaPalatina"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaExtraccion", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaExtraccion = :odontogramaExtraccion"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaAusente", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaAusente = :odontogramaAusente"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaFractura", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaFractura = :odontogramaFractura"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaProtesis", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaProtesis = :odontogramaProtesis"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaImplante", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaImplante = :odontogramaImplante"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaEndodoncia", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaEndodoncia = :odontogramaEndodoncia"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaRaiz", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaRaiz = :odontogramaRaiz"),
    @NamedQuery(name = "Odontogramas.findByOdontogramaGeneral", query = "SELECT o FROM Odontogramas o WHERE o.odontogramaGeneral = :odontogramaGeneral"),

    @NamedQuery(name = "Odontogramas.findByOdontogramaPorPiezaPaciente", query = "SELECT o FROM Odontogramas o WHERE o.pacienteId.pacienteId = :pacienteId and o.odontogramaPieza = :piezaCodigo")})
public class Odontogramas implements Serializable {

    @Column(name = "odontograma_endodoncia_reincide")
    private Boolean odontogramaEndodonciaReincide;
    @Column(name = "odontograma_protesis_reincide")
    private Boolean odontogramaProtesisReincide;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "odontograma_id")
    private Integer odontogramaId;
    @Size(max = 5)
    @Column(name = "odontograma_pieza")
    private String odontogramaPieza;
    @Column(name = "odontograma_cuadrante")
    private Integer odontogramaCuadrante;
    @Column(name = "odontograma_oclusal")
    private Integer odontogramaOclusal;
    @Column(name = "odontograma_vestibular")
    private Integer odontogramaVestibular;
    @Column(name = "odontograma_mesial")
    private Integer odontogramaMesial;
    @Column(name = "odontograma_distal")
    private Integer odontogramaDistal;
    @Column(name = "odontograma_lingual")
    private Integer odontogramaLingual;
    @Column(name = "odontograma_palatina")
    private Integer odontogramaPalatina;
    @Column(name = "odontograma_extraccion")
    private Boolean odontogramaExtraccion;
    @Column(name = "odontograma_ausente")
    private Boolean odontogramaAusente;
    @Column(name = "odontograma_fractura")
    private Boolean odontogramaFractura;
    @Column(name = "odontograma_protesis")
    private Boolean odontogramaProtesis;
    @Column(name = "odontograma_implante")
    private Boolean odontogramaImplante;
    @Column(name = "odontograma_endodoncia")
    private Boolean odontogramaEndodoncia;
    @Column(name = "odontograma_raiz")
    private Boolean odontogramaRaiz;
    @Column(name = "odontograma_general")
    private Integer odontogramaGeneral;
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    @ManyToOne(optional = false)
    private Pacientes pacienteId;

    public Odontogramas() {
    }

    public Odontogramas(Integer odontogramaId) {
        this.odontogramaId = odontogramaId;
    }

    public Integer getOdontogramaId() {
        return odontogramaId;
    }

    public void setOdontogramaId(Integer odontogramaId) {
        this.odontogramaId = odontogramaId;
    }

    public String getOdontogramaPieza() {
        return odontogramaPieza;
    }

    public void setOdontogramaPieza(String odontogramaPieza) {
        this.odontogramaPieza = odontogramaPieza;
    }

    public Integer getOdontogramaCuadrante() {
        return odontogramaCuadrante;
    }

    public void setOdontogramaCuadrante(Integer odontogramaCuadrante) {
        this.odontogramaCuadrante = odontogramaCuadrante;
    }

    public Integer getOdontogramaOclusal() {
        return odontogramaOclusal;
    }

    public void setOdontogramaOclusal(Integer odontogramaOclusal) {
        this.odontogramaOclusal = odontogramaOclusal;
    }

    public Integer getOdontogramaVestibular() {
        return odontogramaVestibular;
    }

    public void setOdontogramaVestibular(Integer odontogramaVestibular) {
        this.odontogramaVestibular = odontogramaVestibular;
    }

    public Integer getOdontogramaMesial() {
        return odontogramaMesial;
    }

    public void setOdontogramaMesial(Integer odontogramaMesial) {
        this.odontogramaMesial = odontogramaMesial;
    }

    public Integer getOdontogramaDistal() {
        return odontogramaDistal;
    }

    public void setOdontogramaDistal(Integer odontogramaDistal) {
        this.odontogramaDistal = odontogramaDistal;
    }

    public Integer getOdontogramaLingual() {
        return odontogramaLingual;
    }

    public void setOdontogramaLingual(Integer odontogramaLingual) {
        this.odontogramaLingual = odontogramaLingual;
    }

    public Integer getOdontogramaPalatina() {
        return odontogramaPalatina;
    }

    public void setOdontogramaPalatina(Integer odontogramaPalatina) {
        this.odontogramaPalatina = odontogramaPalatina;
    }

    public Boolean getOdontogramaExtraccion() {
        return odontogramaExtraccion;
    }

    public void setOdontogramaExtraccion(Boolean odontogramaExtraccion) {
        this.odontogramaExtraccion = odontogramaExtraccion;
    }

    public Boolean getOdontogramaAusente() {
        return odontogramaAusente;
    }

    public void setOdontogramaAusente(Boolean odontogramaAusente) {
        this.odontogramaAusente = odontogramaAusente;
    }

    public Boolean getOdontogramaFractura() {
        return odontogramaFractura;
    }

    public void setOdontogramaFractura(Boolean odontogramaFractura) {
        this.odontogramaFractura = odontogramaFractura;
    }

    public Boolean getOdontogramaProtesis() {
        return odontogramaProtesis;
    }

    public void setOdontogramaProtesis(Boolean odontogramaProtesis) {
        this.odontogramaProtesis = odontogramaProtesis;
    }

    public Boolean getOdontogramaImplante() {
        return odontogramaImplante;
    }

    public void setOdontogramaImplante(Boolean odontogramaImplante) {
        this.odontogramaImplante = odontogramaImplante;
    }

    public Boolean getOdontogramaEndodoncia() {
        return odontogramaEndodoncia;
    }

    public void setOdontogramaEndodoncia(Boolean odontogramaEndodoncia) {
        this.odontogramaEndodoncia = odontogramaEndodoncia;
    }

    public Boolean getOdontogramaRaiz() {
        return odontogramaRaiz;
    }

    public void setOdontogramaRaiz(Boolean odontogramaRaiz) {
        this.odontogramaRaiz = odontogramaRaiz;
    }

    public Integer getOdontogramaGeneral() {
        return odontogramaGeneral;
    }

    public void setOdontogramaGeneral(Integer odontogramaGeneral) {
        this.odontogramaGeneral = odontogramaGeneral;
    }

    public Pacientes getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Pacientes pacienteId) {
        this.pacienteId = pacienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (odontogramaId != null ? odontogramaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Odontogramas)) {
            return false;
        }
        Odontogramas other = (Odontogramas) object;
        if ((this.odontogramaId == null && other.odontogramaId != null) || (this.odontogramaId != null && !this.odontogramaId.equals(other.odontogramaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Odontogramas[ odontogramaId=" + odontogramaId + " ]";
    }

    public Boolean getOdontogramaEndodonciaReincide() {
        return odontogramaEndodonciaReincide;
    }

    public void setOdontogramaEndodonciaReincide(Boolean odontogramaEndodonciaReincide) {
        this.odontogramaEndodonciaReincide = odontogramaEndodonciaReincide;
    }

    public Boolean getOdontogramaProtesisReincide() {
        return odontogramaProtesisReincide;
    }

    public void setOdontogramaProtesisReincide(Boolean odontogramaProtesisReincide) {
        this.odontogramaProtesisReincide = odontogramaProtesisReincide;
    }
    
}
