/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "promociones")
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p"),
    @NamedQuery(name = "Promociones.findByPromocionId", query = "SELECT p FROM Promociones p WHERE p.promocionId = :promocionId"),
    @NamedQuery(name = "Promociones.findByPromocionNombre", query = "SELECT p FROM Promociones p WHERE p.promocionNombre = :promocionNombre"),
    @NamedQuery(name = "Promociones.findByPromocionDescripcion", query = "SELECT p FROM Promociones p WHERE p.promocionDescripcion = :promocionDescripcion"),
    @NamedQuery(name = "Promociones.findByPromocionInicio", query = "SELECT p FROM Promociones p WHERE p.promocionInicio = :promocionInicio"),
    @NamedQuery(name = "Promociones.findByPromocionFin", query = "SELECT p FROM Promociones p WHERE p.promocionFin = :promocionFin"),
    @NamedQuery(name = "Promociones.findByPromocionEstado", query = "SELECT p FROM Promociones p WHERE p.promocionEstado = :promocionEstado"),
    @NamedQuery(name = "Promociones.findByPromocionTipo", query = "SELECT p FROM Promociones p WHERE p.promocionTipo = :promocionTipo"),
    @NamedQuery(name = "Promociones.findByPromocionImagenNombre", query = "SELECT p FROM Promociones p WHERE p.promocionImagenNombre = :promocionImagenNombre"),
    @NamedQuery(name = "Promociones.findByPromocionImagenUrl", query = "SELECT p FROM Promociones p WHERE p.promocionImagenUrl = :promocionImagenUrl"),
    @NamedQuery(name = "Promociones.findByPromocionMensaje", query = "SELECT p FROM Promociones p WHERE p.promocionMensaje = :promocionMensaje"),
    @NamedQuery(name = "Promociones.findByPromocionActiva", query = "SELECT p FROM Promociones p WHERE p.promocionActiva = :promocionActiva"),
    @NamedQuery(name = "Promociones.findByPromocionFechaCreacion", query = "SELECT p FROM Promociones p WHERE p.promocionFechaCreacion = :promocionFechaCreacion"),
    @NamedQuery(name = "Promociones.findByPromocionUsuarioCreacion", query = "SELECT p FROM Promociones p WHERE p.promocionUsuarioCreacion = :promocionUsuarioCreacion"),
    @NamedQuery(name = "Promociones.findByPromocionFechaModificacion", query = "SELECT p FROM Promociones p WHERE p.promocionFechaModificacion = :promocionFechaModificacion"),
    @NamedQuery(name = "Promociones.findByPromocionUsuarioModificacion", query = "SELECT p FROM Promociones p WHERE p.promocionUsuarioModificacion = :promocionUsuarioModificacion"),

    @NamedQuery(name = "Promociones.cumpleanyosMes", query = "SELECT p FROM Promociones p WHERE :fecha_actual BETWEEN p.promocionInicio AND p.promocionFin AND p.promocionActiva=true AND p.promocionTipo= 2"),
    @NamedQuery(name = "Promociones.promocionesEspeciales", query = "SELECT p FROM Promociones p WHERE :fecha_actual BETWEEN p.promocionInicio AND p.promocionFin AND p.promocionActiva=true AND p.promocionTipo= 1"),
    @NamedQuery(name = "Promociones.promocionesReinicioEspAndCump", query = "SELECT p FROM Promociones p WHERE :fecha_actual BETWEEN p.promocionInicio AND p.promocionFin AND p.promocionActiva=true AND p.promocionTipo= 1 AND p.promocionTipo= 2"),

    //namedquery que busca las fechas existentes dentro del rango seleccionado, para validar reporte de promo demandadas
    @NamedQuery(name = "Promociones.findpromocionDemandaReport", query = "SELECT c FROM Consultas c WHERE c.consultaFechaCreacion between :fechainicio and :fechafin"), 
    @NamedQuery(name = "Promociones.findByPromocionUsuarioModificacion", query = "SELECT p FROM Promociones p WHERE p.promocionUsuarioModificacion = :promocionUsuarioModificacion")})
public class Promociones implements Serializable {

    @Lob
    @Column(name = "promocion_imagen")
    private byte[] promocionImagen;
    @Column(name = "promocion_correo_limitado_espera")
    private Integer promocionCorreoLimitadoEspera;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "promocion_id")
    private Integer promocionId;
    @Size(max = 50)
    @Column(name = "promocion_nombre")
    private String promocionNombre;
    @Size(max = 250)
    @Column(name = "promocion_descripcion")
    private String promocionDescripcion;
    @Column(name = "promocion_inicio")
    @Temporal(TemporalType.DATE)
    private Date promocionInicio;
    @Column(name = "promocion_fin")
    @Temporal(TemporalType.DATE)
    private Date promocionFin;
    @Column(name = "promocion_estado")
    private Boolean promocionEstado;
    @Column(name = "promocion_tipo")
    private Integer promocionTipo;
    @Size(max = 75)
    @Column(name = "promocion_imagen_nombre")
    private String promocionImagenNombre;
    @Size(max = 300)
    @Column(name = "promocion_imagen_url")
    private String promocionImagenUrl;
    @Size(max = 1000)
    @Column(name = "promocion_mensaje")
    private String promocionMensaje;
    @Column(name = "promocion_activa")
    private Boolean promocionActiva;
    @Column(name = "promocion_fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date promocionFechaCreacion;
    @Size(max = 50)
    @Column(name = "promocion_usuario_creacion")
    private String promocionUsuarioCreacion;
    @Column(name = "promocion_fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date promocionFechaModificacion;
    @Size(max = 50)
    @Column(name = "promocion_usuario_modificacion")
    private String promocionUsuarioModificacion;
    @OneToMany(mappedBy = "promocionId")
    private List<Consultas> consultasList;

    public Promociones() {
    }

    public Promociones(Integer promocionId) {
        this.promocionId = promocionId;
    }

    public Integer getPromocionId() {
        return promocionId;
    }

    public void setPromocionId(Integer promocionId) {
        this.promocionId = promocionId;
    }

    public String getPromocionNombre() {
        return promocionNombre;
    }

    public void setPromocionNombre(String promocionNombre) {
        this.promocionNombre = promocionNombre;
    }

    public String getPromocionDescripcion() {
        return promocionDescripcion;
    }

    public void setPromocionDescripcion(String promocionDescripcion) {
        this.promocionDescripcion = promocionDescripcion;
    }

    public Date getPromocionInicio() {
        return promocionInicio;
    }

    public void setPromocionInicio(Date promocionInicio) {
        this.promocionInicio = promocionInicio;
    }

    public Date getPromocionFin() {
        return promocionFin;
    }

    public void setPromocionFin(Date promocionFin) {
        this.promocionFin = promocionFin;
    }

    public Boolean getPromocionEstado() {
        return promocionEstado;
    }

    public void setPromocionEstado(Boolean promocionEstado) {
        this.promocionEstado = promocionEstado;
    }

    public Integer getPromocionTipo() {
        return promocionTipo;
    }

    public void setPromocionTipo(Integer promocionTipo) {
        this.promocionTipo = promocionTipo;
    }

    public byte[] getPromocionImagen() {
        return promocionImagen;
    }

    public void setPromocionImagen(byte[] promocionImagen) {
        this.promocionImagen = promocionImagen;
    }

    public String getPromocionImagenNombre() {
        return promocionImagenNombre;
    }

    public void setPromocionImagenNombre(String promocionImagenNombre) {
        this.promocionImagenNombre = promocionImagenNombre;
    }

    public String getPromocionImagenUrl() {
        return promocionImagenUrl;
    }

    public void setPromocionImagenUrl(String promocionImagenUrl) {
        this.promocionImagenUrl = promocionImagenUrl;
    }

    public String getPromocionMensaje() {
        return promocionMensaje;
    }

    public void setPromocionMensaje(String promocionMensaje) {
        this.promocionMensaje = promocionMensaje;
    }

    public Boolean getPromocionActiva() {
        return promocionActiva;
    }

    public void setPromocionActiva(Boolean promocionActiva) {
        this.promocionActiva = promocionActiva;
    }

    public Date getPromocionFechaCreacion() {
        return promocionFechaCreacion;
    }

    public void setPromocionFechaCreacion(Date promocionFechaCreacion) {
        this.promocionFechaCreacion = promocionFechaCreacion;
    }

    public String getPromocionUsuarioCreacion() {
        return promocionUsuarioCreacion;
    }

    public void setPromocionUsuarioCreacion(String promocionUsuarioCreacion) {
        this.promocionUsuarioCreacion = promocionUsuarioCreacion;
    }

    public Date getPromocionFechaModificacion() {
        return promocionFechaModificacion;
    }

    public void setPromocionFechaModificacion(Date promocionFechaModificacion) {
        this.promocionFechaModificacion = promocionFechaModificacion;
    }

    public String getPromocionUsuarioModificacion() {
        return promocionUsuarioModificacion;
    }

    public void setPromocionUsuarioModificacion(String promocionUsuarioModificacion) {
        this.promocionUsuarioModificacion = promocionUsuarioModificacion;
    }

    public List<Consultas> getConsultasList() {
        return consultasList;
    }

    public void setConsultasList(List<Consultas> consultasList) {
        this.consultasList = consultasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (promocionId != null ? promocionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.promocionId == null && other.promocionId != null) || (this.promocionId != null && !this.promocionId.equals(other.promocionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Promociones[ promocionId=" + promocionId + " ]";
    }

    public Integer getPromocionCorreoLimitadoEspera() {
        return promocionCorreoLimitadoEspera;
    }

    public void setPromocionCorreoLimitadoEspera(Integer promocionCorreoLimitadoEspera) {
        this.promocionCorreoLimitadoEspera = promocionCorreoLimitadoEspera;
    }

}
