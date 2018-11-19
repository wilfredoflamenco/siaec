/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "imagenes")
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i"),
    @NamedQuery(name = "Imagenes.findByImagenId", query = "SELECT i FROM Imagenes i WHERE i.imagenId = :imagenId"),
    @NamedQuery(name = "Imagenes.findByImagenNombre", query = "SELECT i FROM Imagenes i WHERE i.imagenNombre = :imagenNombre"),
    @NamedQuery(name = "Imagenes.findByImagenAnotacion", query = "SELECT i FROM Imagenes i WHERE i.imagenAnotacion = :imagenAnotacion"),
    @NamedQuery(name = "Imagenes.findByImagenUrl", query = "SELECT i FROM Imagenes i WHERE i.imagenUrl = :imagenUrl"),
    @NamedQuery(name = "Imagenes.findByImagenFechaCreacion", query = "SELECT i FROM Imagenes i WHERE i.imagenFechaCreacion = :imagenFechaCreacion"),
    @NamedQuery(name = "Imagenes.findByImagenUsuarioCreacion", query = "SELECT i FROM Imagenes i WHERE i.imagenUsuarioCreacion = :imagenUsuarioCreacion"),

    @NamedQuery(name = "Imagenes.findByImagenesPorPaciente", query = "SELECT i FROM Imagenes i WHERE i.pacienteId.pacienteId = :pacienteId")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "imagen_id")
    private Integer imagenId;
    @Size(max = 75)
    @Column(name = "imagen_nombre")
    private String imagenNombre;
    @Size(max = 250)
    @Column(name = "imagen_anotacion")
    private String imagenAnotacion;
    @Lob
    @Column(name = "imagen_imagen")
    private byte[] imagenImagen;
    @Size(max = 300)
    @Column(name = "imagen_url")
    private String imagenUrl;
    @Column(name = "imagen_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date imagenFechaCreacion;
    @Size(max = 50)
    @Column(name = "imagen_usuario_creacion")
    private String imagenUsuarioCreacion;
    @JoinColumn(name = "paciente_id", referencedColumnName = "paciente_id")
    @ManyToOne(optional = false)
    private Pacientes pacienteId;

    public Imagenes() {
    }

    public Imagenes(Integer imagenId) {
        this.imagenId = imagenId;
    }

    public Integer getImagenId() {
        return imagenId;
    }

    public void setImagenId(Integer imagenId) {
        this.imagenId = imagenId;
    }

    public String getImagenNombre() {
        return imagenNombre;
    }

    public void setImagenNombre(String imagenNombre) {
        this.imagenNombre = imagenNombre;
    }

    public String getImagenAnotacion() {
        return imagenAnotacion;
    }

    public void setImagenAnotacion(String imagenAnotacion) {
        this.imagenAnotacion = imagenAnotacion;
    }

    public byte[] getImagenImagen() {
        return imagenImagen;
    }

    public void setImagenImagen(byte[] imagenImagen) {
        this.imagenImagen = imagenImagen;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public Date getImagenFechaCreacion() {
        return imagenFechaCreacion;
    }

    public void setImagenFechaCreacion(Date imagenFechaCreacion) {
        this.imagenFechaCreacion = imagenFechaCreacion;
    }

    public String getImagenUsuarioCreacion() {
        return imagenUsuarioCreacion;
    }

    public void setImagenUsuarioCreacion(String imagenUsuarioCreacion) {
        this.imagenUsuarioCreacion = imagenUsuarioCreacion;
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
        hash += (imagenId != null ? imagenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.imagenId == null && other.imagenId != null) || (this.imagenId != null && !this.imagenId.equals(other.imagenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Imagenes[ imagenId=" + imagenId + " ]";
    }
    
}
