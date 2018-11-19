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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Fam. Gomez Aldana
 */
@Entity
@Table(name = "configuraciones")
@NamedQueries({
    @NamedQuery(name = "Configuraciones.findAll", query = "SELECT c FROM Configuraciones c"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionId", query = "SELECT c FROM Configuraciones c WHERE c.configuracionId = :configuracionId"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionTiempoSesion", query = "SELECT c FROM Configuraciones c WHERE c.configuracionTiempoSesion = :configuracionTiempoSesion"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoHost", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoHost = :configuracionCorreoHost"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoPort", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoPort = :configuracionCorreoPort"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoRequerido", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoRequerido = :configuracionCorreoRequerido"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoEncryptacion", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoEncryptacion = :configuracionCorreoEncryptacion"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoCuenta", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoCuenta = :configuracionCorreoCuenta"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoContrasenya", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoContrasenya = :configuracionCorreoContrasenya"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoIlimitada", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoIlimitada = :configuracionCorreoIlimitada"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoMes", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoMes = :configuracionCorreoMes"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoDia", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoDia = :configuracionCorreoDia"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoEnviadoMes", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoEnviadoMes = :configuracionCorreoEnviadoMes"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoEnviadoDia", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoEnviadoDia = :configuracionCorreoEnviadoDia"),
    @NamedQuery(name = "Configuraciones.findByConfiguracionCorreoActivo", query = "SELECT c FROM Configuraciones c WHERE c.configuracionCorreoActivo = :configuracionCorreoActivo")})
public class Configuraciones implements Serializable {

    @Size(max = 50)
    @Column(name = "configuracion_titulo")
    private String configuracionTitulo;
    @Size(max = 1000)
    @Column(name = "configuracion_mensaje")
    private String configuracionMensaje;
    @Size(max = 300)
    @Column(name = "configuracion_imagen_superior")
    private String configuracionImagenSuperior;
    @Size(max = 300)
    @Column(name = "configuracion_imagen_inferior")
    private String configuracionImagenInferior;
    @Size(max = 300)
    @Column(name = "configuracion_imagen_login")
    private String configuracionImagenLogin;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "configuracion_id")
    private Integer configuracionId;
    @Column(name = "configuracion_tiempo_sesion")
    private Integer configuracionTiempoSesion;
    @Size(max = 75)
    @Column(name = "configuracion_correo_host")
    private String configuracionCorreoHost;
    @Column(name = "configuracion_correo_port")
    private Integer configuracionCorreoPort;
    @Column(name = "configuracion_correo_requerido")
    private Boolean configuracionCorreoRequerido;
    @Size(max = 30)
    @Column(name = "configuracion_correo_encryptacion")
    private String configuracionCorreoEncryptacion;
    @Size(max = 128)
    @Column(name = "configuracion_correo_cuenta")
    private String configuracionCorreoCuenta;
    @Size(max = 256)
    @Column(name = "configuracion_correo_contrasenya")
    private String configuracionCorreoContrasenya;
    @Column(name = "configuracion_correo_ilimitada")
    private Boolean configuracionCorreoIlimitada;
    @Column(name = "configuracion_correo_mes")
    private Integer configuracionCorreoMes;
    @Column(name = "configuracion_correo_dia")
    private Integer configuracionCorreoDia;
    @Column(name = "configuracion_correo_enviado_mes")
    private Integer configuracionCorreoEnviadoMes;
    @Column(name = "configuracion_correo_enviado_dia")
    private Integer configuracionCorreoEnviadoDia;
    @Column(name = "configuracion_correo_activo")
    private Boolean configuracionCorreoActivo;

    public Configuraciones() {
    }

    public Configuraciones(Integer configuracionId) {
        this.configuracionId = configuracionId;
    }

    public Integer getConfiguracionId() {
        return configuracionId;
    }

    public void setConfiguracionId(Integer configuracionId) {
        this.configuracionId = configuracionId;
    }

    public Integer getConfiguracionTiempoSesion() {
        return configuracionTiempoSesion;
    }

    public void setConfiguracionTiempoSesion(Integer configuracionTiempoSesion) {
        this.configuracionTiempoSesion = configuracionTiempoSesion;
    }

    public String getConfiguracionCorreoHost() {
        return configuracionCorreoHost;
    }

    public void setConfiguracionCorreoHost(String configuracionCorreoHost) {
        this.configuracionCorreoHost = configuracionCorreoHost;
    }

    public Integer getConfiguracionCorreoPort() {
        return configuracionCorreoPort;
    }

    public void setConfiguracionCorreoPort(Integer configuracionCorreoPort) {
        this.configuracionCorreoPort = configuracionCorreoPort;
    }

    public Boolean getConfiguracionCorreoRequerido() {
        return configuracionCorreoRequerido;
    }

    public void setConfiguracionCorreoRequerido(Boolean configuracionCorreoRequerido) {
        this.configuracionCorreoRequerido = configuracionCorreoRequerido;
    }

    public String getConfiguracionCorreoEncryptacion() {
        return configuracionCorreoEncryptacion;
    }

    public void setConfiguracionCorreoEncryptacion(String configuracionCorreoEncryptacion) {
        this.configuracionCorreoEncryptacion = configuracionCorreoEncryptacion;
    }

    public String getConfiguracionCorreoCuenta() {
        return configuracionCorreoCuenta;
    }

    public void setConfiguracionCorreoCuenta(String configuracionCorreoCuenta) {
        this.configuracionCorreoCuenta = configuracionCorreoCuenta;
    }

    public String getConfiguracionCorreoContrasenya() {
        return configuracionCorreoContrasenya;
    }

    public void setConfiguracionCorreoContrasenya(String configuracionCorreoContrasenya) {
        this.configuracionCorreoContrasenya = configuracionCorreoContrasenya;
    }

    public Boolean getConfiguracionCorreoIlimitada() {
        return configuracionCorreoIlimitada;
    }

    public void setConfiguracionCorreoIlimitada(Boolean configuracionCorreoIlimitada) {
        this.configuracionCorreoIlimitada = configuracionCorreoIlimitada;
    }

    public Integer getConfiguracionCorreoMes() {
        return configuracionCorreoMes;
    }

    public void setConfiguracionCorreoMes(Integer configuracionCorreoMes) {
        this.configuracionCorreoMes = configuracionCorreoMes;
    }

    public Integer getConfiguracionCorreoDia() {
        return configuracionCorreoDia;
    }

    public void setConfiguracionCorreoDia(Integer configuracionCorreoDia) {
        this.configuracionCorreoDia = configuracionCorreoDia;
    }

    public Integer getConfiguracionCorreoEnviadoMes() {
        return configuracionCorreoEnviadoMes;
    }

    public void setConfiguracionCorreoEnviadoMes(Integer configuracionCorreoEnviadoMes) {
        this.configuracionCorreoEnviadoMes = configuracionCorreoEnviadoMes;
    }

    public Integer getConfiguracionCorreoEnviadoDia() {
        return configuracionCorreoEnviadoDia;
    }

    public void setConfiguracionCorreoEnviadoDia(Integer configuracionCorreoEnviadoDia) {
        this.configuracionCorreoEnviadoDia = configuracionCorreoEnviadoDia;
    }

    public Boolean getConfiguracionCorreoActivo() {
        return configuracionCorreoActivo;
    }

    public void setConfiguracionCorreoActivo(Boolean configuracionCorreoActivo) {
        this.configuracionCorreoActivo = configuracionCorreoActivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (configuracionId != null ? configuracionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Configuraciones)) {
            return false;
        }
        Configuraciones other = (Configuraciones) object;
        if ((this.configuracionId == null && other.configuracionId != null) || (this.configuracionId != null && !this.configuracionId.equals(other.configuracionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Configuraciones[ configuracionId=" + configuracionId + " ]";
    }

    public String getConfiguracionTitulo() {
        return configuracionTitulo;
    }

    public void setConfiguracionTitulo(String configuracionTitulo) {
        this.configuracionTitulo = configuracionTitulo;
    }

    public String getConfiguracionMensaje() {
        return configuracionMensaje;
    }

    public void setConfiguracionMensaje(String configuracionMensaje) {
        this.configuracionMensaje = configuracionMensaje;
    }

    public String getConfiguracionImagenSuperior() {
        return configuracionImagenSuperior;
    }

    public void setConfiguracionImagenSuperior(String configuracionImagenSuperior) {
        this.configuracionImagenSuperior = configuracionImagenSuperior;
    }

    public String getConfiguracionImagenInferior() {
        return configuracionImagenInferior;
    }

    public void setConfiguracionImagenInferior(String configuracionImagenInferior) {
        this.configuracionImagenInferior = configuracionImagenInferior;
    }

    public String getConfiguracionImagenLogin() {
        return configuracionImagenLogin;
    }

    public void setConfiguracionImagenLogin(String configuracionImagenLogin) {
        this.configuracionImagenLogin = configuracionImagenLogin;
    }
    
}
