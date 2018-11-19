package controllers;

import dao.ConsultasFacade;
import dao.PatologiasFacade;
import dao.DepartamentosFacade;
import dao.DetallesConsultasFacade;
import dao.OdontogramasFacade;
import dao.DireccionesFacade;
import dao.MunicipiosFacade;
import dao.PacientesFacade;
import entities.Patologias;
import entities.Departamentos;
import entities.Direcciones;
import entities.Municipios;
import entities.Pacientes;
import dao.ImagenesFacade;
import dao.MedicosFacade;
import dao.PromocionesFacade;
import dao.TratamientosFacade;
import entities.Consultas;
import entities.DetallesConsultas;
import entities.Odontogramas;
import entities.Imagenes;
import entities.Medicos;
import entities.Promociones;
import entities.Tratamientos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import org.primefaces.model.UploadedFile;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
import static org.springframework.util.FileCopyUtils.BUFFER_SIZE;

/* @author Equipo 19-2018 FIA-UES */
@Named(value = "expedientesBean")
@SessionScoped
public class ExpedientesBean implements Serializable {

//****************************************************************************//
//                          Declaración de variables                          //
//****************************************************************************//
    @EJB
    private ImagenesFacade imagenesFacade;
    private Imagenes imagenNueva = new Imagenes();
    private Imagenes imagenConsultar = new Imagenes();
    private Imagenes imagenEditar = new Imagenes();
    @EJB
    private PatologiasFacade patologiasFacade;
    @EJB
    private PacientesFacade pacientesFacade;
    private Pacientes pacienteNuevo = new Pacientes();
    private Pacientes pacienteConsultar = new Pacientes();
    private Pacientes pacienteEditar = new Pacientes();
    @EJB
    private DireccionesFacade direccionesFacade;
    private Direcciones direccionNuevo = new Direcciones();
    private Direcciones direccionEditar = new Direcciones();
    private Direcciones direccionConsultar = new Direcciones();
    @EJB
    private DepartamentosFacade departamentosFacade;
    @EJB
    private MunicipiosFacade municipiosFacade;
    @EJB
    private ConsultasFacade consultasFacade;
    private Consultas consultaNueva = new Consultas();
    private Consultas consultaEditar = new Consultas();
    private Consultas consultaSeleccionada = new Consultas();
    @EJB
    private MedicosFacade medicosFacade;
    @EJB
    private PromocionesFacade promocionesFacade;
    @EJB
    private TratamientosFacade tratamientosFacade;
    @EJB
    private DetallesConsultasFacade detallesConsultasFacade;
    private DetallesConsultas detalleConsultaNuevo = new DetallesConsultas();
    @EJB
    private OdontogramasFacade odontogramasFacade;
    private Odontogramas piezaNuevo = new Odontogramas();
    private Odontogramas piezaConsultar = new Odontogramas();
    private Odontogramas piezaEditar = new Odontogramas();
    private Odontogramas pieza11 = new Odontogramas();
    private Odontogramas pieza12 = new Odontogramas();
    private Odontogramas pieza13 = new Odontogramas();
    private Odontogramas pieza14 = new Odontogramas();
    private Odontogramas pieza15 = new Odontogramas();
    private Odontogramas pieza16 = new Odontogramas();
    private Odontogramas pieza17 = new Odontogramas();
    private Odontogramas pieza18 = new Odontogramas();
    private Odontogramas pieza21 = new Odontogramas();
    private Odontogramas pieza22 = new Odontogramas();
    private Odontogramas pieza23 = new Odontogramas();
    private Odontogramas pieza24 = new Odontogramas();
    private Odontogramas pieza25 = new Odontogramas();
    private Odontogramas pieza26 = new Odontogramas();
    private Odontogramas pieza27 = new Odontogramas();
    private Odontogramas pieza28 = new Odontogramas();
    private Odontogramas pieza31 = new Odontogramas();
    private Odontogramas pieza32 = new Odontogramas();
    private Odontogramas pieza33 = new Odontogramas();
    private Odontogramas pieza34 = new Odontogramas();
    private Odontogramas pieza35 = new Odontogramas();
    private Odontogramas pieza36 = new Odontogramas();
    private Odontogramas pieza37 = new Odontogramas();
    private Odontogramas pieza38 = new Odontogramas();
    private Odontogramas pieza41 = new Odontogramas();
    private Odontogramas pieza42 = new Odontogramas();
    private Odontogramas pieza43 = new Odontogramas();
    private Odontogramas pieza44 = new Odontogramas();
    private Odontogramas pieza45 = new Odontogramas();
    private Odontogramas pieza46 = new Odontogramas();
    private Odontogramas pieza47 = new Odontogramas();
    private Odontogramas pieza48 = new Odontogramas();
    private Odontogramas pieza51 = new Odontogramas();
    private Odontogramas pieza52 = new Odontogramas();
    private Odontogramas pieza53 = new Odontogramas();
    private Odontogramas pieza54 = new Odontogramas();
    private Odontogramas pieza55 = new Odontogramas();
    private Odontogramas pieza61 = new Odontogramas();
    private Odontogramas pieza62 = new Odontogramas();
    private Odontogramas pieza63 = new Odontogramas();
    private Odontogramas pieza64 = new Odontogramas();
    private Odontogramas pieza65 = new Odontogramas();
    private Odontogramas pieza71 = new Odontogramas();
    private Odontogramas pieza72 = new Odontogramas();
    private Odontogramas pieza73 = new Odontogramas();
    private Odontogramas pieza74 = new Odontogramas();
    private Odontogramas pieza75 = new Odontogramas();
    private Odontogramas pieza81 = new Odontogramas();
    private Odontogramas pieza82 = new Odontogramas();
    private Odontogramas pieza83 = new Odontogramas();
    private Odontogramas pieza84 = new Odontogramas();
    private Odontogramas pieza85 = new Odontogramas();

    private Integer tabindex = 0;
    private Integer tabIndex = 0;
    private Integer tabIndexFicha = 0;
    private Integer departamentoId = 0;
    private Integer departametoIdConsultar = 0;
    private Integer departametoIdGestionar = 0;
    private String expediente; //Variable para buscar paciente por expediente.
    private String nombre; //Variable para buscar paciente por nombre.
    private UploadedFile file;
    private Date fechaSistema = new Date();
    
    public ExpedientesBean() {
    }

//****************************************************************************//
//                  Métodos para obtener listas por entidades                 //
//****************************************************************************//
    public List<Patologias> todosPatologiasDisponibles() {
        return getPatologiasFacade().patologiasDisponibles(Boolean.TRUE);
    }

    public List<Departamentos> todosDepartamentos() {
        return getDepartamentosFacade().findAll();
    }

    public List<Imagenes> todosImagenesPorPacienteGestionar() {
        return getImagenesFacade().todasImagenesPorPaciente(pacienteEditar.getPacienteId());
    }

    public List<Imagenes> todosImagenesPorPacienteConsultar() {
        return getImagenesFacade().todasImagenesPorPaciente(pacienteConsultar.getPacienteId());
    }

    public List<Municipios> municipioPorDepartamento() {
        return getMunicipiosFacade().municipioPorDepartamentos(departamentoId);
    }

    public List<Municipios> todosMunicipiosPorDepartamento() {
        return getMunicipiosFacade().municipioPorDepartamentos(departamentoId);
    }

    public List<Municipios> todosMunicipiosPorDepartamentoEditar() {
        return getMunicipiosFacade().municipioPorDepartamentos(direccionEditar.getMunicipioId().getDepartamentoId().getDepartamentoId());
    }

    public List<Pacientes> todosPacientes() {
        return getPacientesFacade().findAll();
    }

    public List<Pacientes> todosPacientesPorExpediente() {
        if (expediente != null) {
            if (!(expediente.equalsIgnoreCase(""))) {
                return getPacientesFacade().todosPacientesPorExpediente(expediente);
            }
        }
        List<Pacientes> listaVaciaExpediente = getPacientesFacade().findAll();
        listaVaciaExpediente.clear();
        return listaVaciaExpediente;
    }

    public List<Pacientes> todosPacientesPorNombre() {
        if (nombre != null) {
            if (!(nombre.equalsIgnoreCase(""))) {
                return getPacientesFacade().todosPacientesPorNombre(nombre);
            }
        }
        List<Pacientes> listaVaciaNombre = getPacientesFacade().findAll();
        listaVaciaNombre.clear();
        return listaVaciaNombre;
    }

    public List<Municipios> MunicipioDePacienteConsultar(Integer muncipioConsultar) {
        return getMunicipiosFacade().municipioPorDepartamentos(muncipioConsultar);
    }

    public List<Consultas> todasConsultasPorPacienteConsultar() {
        return getConsultasFacade().todosPacientesPorPaciente(pacienteConsultar.getPacienteId());
    }

    public List<Consultas> todasConsultasPorPacienteGestionar() {
        return getConsultasFacade().todosPacientesPorPaciente(pacienteEditar.getPacienteId());
    }

    public List<Medicos> todosMedicosDisponibles() {
        return getMedicosFacade().medicosDisponibles(Boolean.TRUE);
    }

    public List<Promociones> todasPromocionesDisponibles() {
        return getPromocionesFacade().promocionesDisponibles(Boolean.TRUE);
    }
    
    public List<Tratamientos> todosTratamientosDisponibles() {
        return getTratamientosFacade().tratamientosDisponibles(Boolean.TRUE);
    }
    
    public List<DetallesConsultas> todosDetallesConsultasPorPacienteGestionar() {
        return getDetallesConsultasFacade().detalleConsultaPorPaciente(pacienteEditar.getPacienteId());
    }
    
    public List<DetallesConsultas> todosDetallesConsultasPorPacienteConsultar() {
        return getDetallesConsultasFacade().detalleConsultaPorPaciente(pacienteConsultar.getPacienteId());
    }

//****************************************************************************//
//                 Métodos Get para obtener datos de entidades                //
//****************************************************************************//

    public PatologiasFacade getPatologiasFacade() {
        return patologiasFacade;
    }

    public PacientesFacade getPacientesFacade() {
        return pacientesFacade;
    }

    public DireccionesFacade getDireccionesFacade() {
        return direccionesFacade;
    }

    public DepartamentosFacade getDepartamentosFacade() {
        return departamentosFacade;
    }

    public MunicipiosFacade getMunicipiosFacade() {
        return municipiosFacade;
    }

    public ImagenesFacade getImagenesFacade() {
        return imagenesFacade;
    }

    public ConsultasFacade getConsultasFacade() {
        return consultasFacade;
    }

    public MedicosFacade getMedicosFacade() {
        return medicosFacade;
    }

    public PromocionesFacade getPromocionesFacade() {
        return promocionesFacade;
    }
    
    public TratamientosFacade getTratamientosFacade() {
        return tratamientosFacade;
    }

    public OdontogramasFacade getOdontogramasFacade() {
        return odontogramasFacade;
    }

    public DetallesConsultasFacade getDetallesConsultasFacade() {
        return detallesConsultasFacade;
    }

//****************************************************************************//
//                             Métodos Get y SET                              //
//****************************************************************************//
    
    public Pacientes getPacienteNuevo() {
        return pacienteNuevo;
    }
    public void setPacienteNuevo(Pacientes pacienteNuevo) {
        this.pacienteNuevo = pacienteNuevo;
    }

    public Direcciones getDireccionNuevo() {
        return direccionNuevo;
    }
    public void setDireccionNuevo(Direcciones direccionNuevo) {
        this.direccionNuevo = direccionNuevo;
    }

    public Direcciones getDireccionEditar() {
        return direccionEditar;
    }
    public void setDireccionEditar(Direcciones direccionEditar) {
        this.direccionEditar = direccionEditar;
    }

    public Direcciones getDireccionConsultar() {
        return direccionConsultar;
    }
    public void setDireccionConsultar(Direcciones direccionConsultar) {
        this.direccionConsultar = direccionConsultar;
    }

    public Integer getTabindex() {
        return tabindex;
    }
    public void setTabindex(Integer tabindex) {
        this.tabindex = tabindex;
    }

    public Integer getDepartamentoId() {
        return departamentoId;
    }
    public void setDepartamentoId(Integer departamentoId) {
        this.departamentoId = departamentoId;
    }

    public Integer getDepartametoIdConsultar() {
        return departametoIdConsultar;
    }
    public void setDepartametoIdConsultar(Integer departametoIdConsultar) {
        this.departametoIdConsultar = departametoIdConsultar;
    }

    public String getExpediente() {
        return expediente;
    }
    public void setExpediente(String expediente) {
        this.expediente = expediente;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pacientes getPacienteConsultar() {
        return pacienteConsultar;
    }
    public void setPacienteConsultar(Pacientes pacienteConsultar) {
        this.direccionConsultar = getDireccionesFacade().direccionPorPaciente(pacienteConsultar.getPacienteId());
        this.pieza11 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "11");
        this.pieza12 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "12");
        this.pieza13 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "13");
        this.pieza14 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "14");
        this.pieza15 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "15");
        this.pieza16 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "16");
        this.pieza17 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "17");
        this.pieza18 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "18");
        this.pieza21 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "21");
        this.pieza22 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "22");
        this.pieza23 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "23");
        this.pieza24 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "24");
        this.pieza25 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "25");
        this.pieza26 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "26");
        this.pieza27 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "27");
        this.pieza28 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "28");
        this.pieza31 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "31");
        this.pieza32 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "32");
        this.pieza33 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "33");
        this.pieza34 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "34");
        this.pieza35 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "35");
        this.pieza36 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "36");
        this.pieza37 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "37");
        this.pieza38 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "38");
        this.pieza41 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "41");
        this.pieza42 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "42");
        this.pieza43 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "43");
        this.pieza44 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "44");
        this.pieza45 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "45");
        this.pieza46 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "46");
        this.pieza47 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "47");
        this.pieza48 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "48");
        this.pieza51 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "51");
        this.pieza52 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "52");
        this.pieza53 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "53");
        this.pieza54 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "54");
        this.pieza55 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "55");
        this.pieza61 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "61");
        this.pieza62 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "62");
        this.pieza63 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "63");
        this.pieza64 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "64");
        this.pieza65 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "65");
        this.pieza71 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "71");
        this.pieza72 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "72");
        this.pieza73 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "73");
        this.pieza74 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "74");
        this.pieza75 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "75");
        this.pieza81 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "81");
        this.pieza82 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "82");
        this.pieza83 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "83");
        this.pieza84 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "84");
        this.pieza85 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteConsultar.getPacienteId(), "85");
        this.pacienteConsultar = pacienteConsultar;
    }

    public Pacientes getPacienteEditar() {
        return pacienteEditar;
    }
    public void setPacienteEditar(Pacientes pacienteEditar) {
        this.direccionEditar = getDireccionesFacade().direccionPorPaciente(pacienteEditar.getPacienteId());
        this.pieza11 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "11");
        this.pieza12 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "12");
        this.pieza13 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "13");
        this.pieza14 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "14");
        this.pieza15 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "15");
        this.pieza16 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "16");
        this.pieza17 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "17");
        this.pieza18 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "18");
        this.pieza21 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "21");
        this.pieza22 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "22");
        this.pieza23 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "23");
        this.pieza24 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "24");
        this.pieza25 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "25");
        this.pieza26 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "26");
        this.pieza27 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "27");
        this.pieza28 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "28");
        this.pieza31 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "31");
        this.pieza32 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "32");
        this.pieza33 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "33");
        this.pieza34 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "34");
        this.pieza35 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "35");
        this.pieza36 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "36");
        this.pieza37 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "37");
        this.pieza38 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "38");
        this.pieza41 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "41");
        this.pieza42 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "42");
        this.pieza43 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "43");
        this.pieza44 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "44");
        this.pieza45 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "45");
        this.pieza46 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "46");
        this.pieza47 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "47");
        this.pieza48 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "48");
        this.pieza51 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "51");
        this.pieza52 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "52");
        this.pieza53 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "53");
        this.pieza54 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "54");
        this.pieza55 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "55");
        this.pieza61 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "61");
        this.pieza62 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "62");
        this.pieza63 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "63");
        this.pieza64 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "64");
        this.pieza65 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "65");
        this.pieza71 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "71");
        this.pieza72 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "72");
        this.pieza73 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "73");
        this.pieza74 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "74");
        this.pieza75 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "75");
        this.pieza81 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "81");
        this.pieza82 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "82");
        this.pieza83 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "83");
        this.pieza84 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "84");
        this.pieza85 = getOdontogramasFacade().odontogramaPorPiezaPaciente(pacienteEditar.getPacienteId(), "85");
        this.pacienteEditar = pacienteEditar;
    }

    public Imagenes getImagenNueva() {
        return imagenNueva;
    }
    public void setImagenNueva(Imagenes imagenNueva) {
        this.imagenNueva = imagenNueva;
    }

    public UploadedFile getFile() {
        return file;
    }
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Consultas getConsultaSeleccionada() {
        return consultaSeleccionada;
    }
    public void setConsultaSeleccionada(Consultas consultaSeleccionada) {
        this.consultaSeleccionada = consultaSeleccionada;
    }

    public Consultas getConsultaNueva() {
        return consultaNueva;
    }
    public void setConsultaNueva(Consultas consultaNueva) {
        this.consultaNueva = consultaNueva;
    }

    public Date getFechaSistema() {
        return fechaSistema;
    }
    public void setFechaSistema(Date fechaSistema) {
        this.fechaSistema = fechaSistema;
    }

    public Integer getDepartametoIdGestionar() {
        return departametoIdGestionar;
    }
    public void setDepartametoIdGestionar(Integer departametoIdGestionar) {
        this.departametoIdGestionar = departametoIdGestionar;
    }

    public Imagenes getImagenConsultar() {
        return imagenConsultar;
    }
    public void setImagenConsultar(Imagenes imagenConsultar) {
        this.imagenConsultar = imagenConsultar;
    }

    public Imagenes getImagenEditar() {
        return imagenEditar;
    }
    public void setImagenEditar(Imagenes imagenEditar) {
        this.imagenEditar = imagenEditar;
    }
      
    public Consultas getConsultaEditar() {
        return consultaEditar;
    }
    public void setConsultaEditar(Consultas consultaEditar) {
        this.consultaEditar = consultaEditar;
    }

    public Odontogramas getPiezaNuevo() {
        return piezaNuevo;
    }
    public void setPiezaNuevo(Odontogramas piezaNuevo) {
        this.piezaNuevo = piezaNuevo;
    }

    public Odontogramas getPiezaConsultar() {
        return piezaConsultar;
    }
    public void setPiezaConsultar(Odontogramas piezaConsultar) {
        this.piezaConsultar = piezaConsultar;
    }

    public Odontogramas getPiezaEditar() {
        return piezaEditar;
    }
    public void setPiezaEditar(Odontogramas piezaEditar) {
        this.piezaEditar = piezaEditar;
    }
    
    public Odontogramas getPieza11() {
        return pieza11;
    }
    public void setPieza11(Odontogramas pieza11) {
        this.pieza11 = pieza11;
    }

    public Odontogramas getPieza12() {
        return pieza12;
    }
    public void setPieza12(Odontogramas pieza12) {
        this.pieza12 = pieza12;
    }

    public Odontogramas getPieza13() {
        return pieza13;
    }
    public void setPieza13(Odontogramas pieza13) {
        this.pieza13 = pieza13;
    }

    public Odontogramas getPieza14() {
        return pieza14;
    }
    public void setPieza14(Odontogramas pieza14) {
        this.pieza14 = pieza14;
    }

    public Odontogramas getPieza15() {
        return pieza15;
    }
    public void setPieza15(Odontogramas pieza15) {
        this.pieza15 = pieza15;
    }

    public Odontogramas getPieza16() {
        return pieza16;
    }
    public void setPieza16(Odontogramas pieza16) {
        this.pieza16 = pieza16;
    }

    public Odontogramas getPieza17() {
        return pieza17;
    }
    public void setPieza17(Odontogramas pieza17) {
        this.pieza17 = pieza17;
    }

    public Odontogramas getPieza18() {
        return pieza18;
    }
    public void setPieza18(Odontogramas pieza18) {
        this.pieza18 = pieza18;
    }

    public Odontogramas getPieza21() {
        return pieza21;
    }
    public void setPieza21(Odontogramas pieza21) {
        this.pieza21 = pieza21;
    }

    public Odontogramas getPieza22() {
        return pieza22;
    }
    public void setPieza22(Odontogramas pieza22) {
        this.pieza22 = pieza22;
    }

    public Odontogramas getPieza23() {
        return pieza23;
    }
    public void setPieza23(Odontogramas pieza23) {
        this.pieza23 = pieza23;
    }

    public Odontogramas getPieza24() {
        return pieza24;
    }
    public void setPieza24(Odontogramas pieza24) {
        this.pieza24 = pieza24;
    }

    public Odontogramas getPieza25() {
        return pieza25;
    }
    public void setPieza25(Odontogramas pieza25) {
        this.pieza25 = pieza25;
    }

    public Odontogramas getPieza26() {
        return pieza26;
    }
    public void setPieza26(Odontogramas pieza26) {
        this.pieza26 = pieza26;
    }

    public Odontogramas getPieza27() {
        return pieza27;
    }
    public void setPieza27(Odontogramas pieza27) {
        this.pieza27 = pieza27;
    }

    public Odontogramas getPieza28() {
        return pieza28;
    }
    public void setPieza28(Odontogramas pieza28) {
        this.pieza28 = pieza28;
    }

    public Odontogramas getPieza31() {
        return pieza31;
    }
    public void setPieza31(Odontogramas pieza31) {
        this.pieza31 = pieza31;
    }

    public Odontogramas getPieza32() {
        return pieza32;
    }
    public void setPieza32(Odontogramas pieza32) {
        this.pieza32 = pieza32;
    }

    public Odontogramas getPieza33() {
        return pieza33;
    }
    public void setPieza33(Odontogramas pieza33) {
        this.pieza33 = pieza33;
    }

    public Odontogramas getPieza34() {
        return pieza34;
    }
    public void setPieza34(Odontogramas pieza34) {
        this.pieza34 = pieza34;
    }

    public Odontogramas getPieza35() {
        return pieza35;
    }
    public void setPieza35(Odontogramas pieza35) {
        this.pieza35 = pieza35;
    }

    public Odontogramas getPieza36() {
        return pieza36;
    }
    public void setPieza36(Odontogramas pieza36) {
        this.pieza36 = pieza36;
    }

    public Odontogramas getPieza37() {
        return pieza37;
    }
    public void setPieza37(Odontogramas pieza37) {
        this.pieza37 = pieza37;
    }

    public Odontogramas getPieza38() {
        return pieza38;
    }
    public void setPieza38(Odontogramas pieza38) {
        this.pieza38 = pieza38;
    }

    public Odontogramas getPieza41() {
        return pieza41;
    }
    public void setPieza41(Odontogramas pieza41) {
        this.pieza41 = pieza41;
    }

    public Odontogramas getPieza42() {
        return pieza42;
    }
    public void setPieza42(Odontogramas pieza42) {
        this.pieza42 = pieza42;
    }

    public Odontogramas getPieza43() {
        return pieza43;
    }
    public void setPieza43(Odontogramas pieza43) {
        this.pieza43 = pieza43;
    }

    public Odontogramas getPieza44() {
        return pieza44;
    }
    public void setPieza44(Odontogramas pieza44) {
        this.pieza44 = pieza44;
    }

    public Odontogramas getPieza45() {
        return pieza45;
    }
    public void setPieza45(Odontogramas pieza45) {
        this.pieza45 = pieza45;
    }

    public Odontogramas getPieza46() {
        return pieza46;
    }
    public void setPieza46(Odontogramas pieza46) {
        this.pieza46 = pieza46;
    }

    public Odontogramas getPieza47() {
        return pieza47;
    }
    public void setPieza47(Odontogramas pieza47) {
        this.pieza47 = pieza47;
    }

    public Odontogramas getPieza48() {
        return pieza48;
    }
    public void setPieza48(Odontogramas pieza48) {
        this.pieza48 = pieza48;
    }

    public Odontogramas getPieza51() {
        return pieza51;
    }
    public void setPieza51(Odontogramas pieza51) {
        this.pieza51 = pieza51;
    }

    public Odontogramas getPieza52() {
        return pieza52;
    }
    public void setPieza52(Odontogramas pieza52) {
        this.pieza52 = pieza52;
    }

    public Odontogramas getPieza53() {
        return pieza53;
    }
    public void setPieza53(Odontogramas pieza53) {
        this.pieza53 = pieza53;
    }

    public Odontogramas getPieza54() {
        return pieza54;
    }
    public void setPieza54(Odontogramas pieza54) {
        this.pieza54 = pieza54;
    }

    public Odontogramas getPieza55() {
        return pieza55;
    }
    public void setPieza55(Odontogramas pieza55) {
        this.pieza55 = pieza55;
    }

    public Odontogramas getPieza61() {
        return pieza61;
    }
    public void setPieza61(Odontogramas pieza61) {
        this.pieza61 = pieza61;
    }

    public Odontogramas getPieza62() {
        return pieza62;
    }
    public void setPieza62(Odontogramas pieza62) {
        this.pieza62 = pieza62;
    }

    public Odontogramas getPieza63() {
        return pieza63;
    }
    public void setPieza63(Odontogramas pieza63) {
        this.pieza63 = pieza63;
    }

    public Odontogramas getPieza64() {
        return pieza64;
    }
    public void setPieza64(Odontogramas pieza64) {
        this.pieza64 = pieza64;
    }

    public Odontogramas getPieza65() {
        return pieza65;
    }
    public void setPieza65(Odontogramas pieza65) {
        this.pieza65 = pieza65;
    }

    public Odontogramas getPieza71() {
        return pieza71;
    }
    public void setPieza71(Odontogramas pieza71) {
        this.pieza71 = pieza71;
    }

    public Odontogramas getPieza72() {
        return pieza72;
    }
    public void setPieza72(Odontogramas pieza72) {
        this.pieza72 = pieza72;
    }

    public Odontogramas getPieza73() {
        return pieza73;
    }
    public void setPieza73(Odontogramas pieza73) {
        this.pieza73 = pieza73;
    }

    public Odontogramas getPieza74() {
        return pieza74;
    }
    public void setPieza74(Odontogramas pieza74) {
        this.pieza74 = pieza74;
    }

    public Odontogramas getPieza75() {
        return pieza75;
    }
    public void setPieza75(Odontogramas pieza75) {
        this.pieza75 = pieza75;
    }

    public Odontogramas getPieza81() {
        return pieza81;
    }
    public void setPieza81(Odontogramas pieza81) {
        this.pieza81 = pieza81;
    }

    public Odontogramas getPieza82() {
        return pieza82;
    }
    public void setPieza82(Odontogramas pieza82) {
        this.pieza82 = pieza82;
    }

    public Odontogramas getPieza83() {
        return pieza83;
    }
    public void setPieza83(Odontogramas pieza83) {
        this.pieza83 = pieza83;
    }

    public Odontogramas getPieza84() {
        return pieza84;
    }
    public void setPieza84(Odontogramas pieza84) {
        this.pieza84 = pieza84;
    }

    public Odontogramas getPieza85() {
        return pieza85;
    }
    public void setPieza85(Odontogramas pieza85) {
        this.pieza85 = pieza85;
    }

    public DetallesConsultas getDetalleConsultaNuevo() {
        return detalleConsultaNuevo;
    }
    public void setDetalleConsultaNuevo(DetallesConsultas detalleConsultaNuevo) {
        this.detalleConsultaNuevo = detalleConsultaNuevo;
    }

    public Integer getTabIndex() {
        return tabIndex;
    }
    public void setTabIndex(Integer tabIndex) {
        this.tabIndex = tabIndex;
    }

    public Integer getTabIndexFicha() {
        return tabIndexFicha;
    }
    public void setTabIndexFicha(Integer tabIndexFicha) {
        this.tabIndexFicha = tabIndexFicha;
    }
    
//****************************************************************************//
//                                  Métodos                                   //
//****************************************************************************//
    
    //Método para guardar Paciente y su Dirección (paciente_registrar.xhtml)
    public void guardarPaciente() {
        try{
            pacienteNuevo.setPacienteFechaCreacion(new Date());
            pacienteNuevo.setPacienteEstado(Boolean.TRUE);
            pacienteNuevo.setPacienteRecordatorio(Boolean.TRUE);
            getPacientesFacade().create(pacienteNuevo);
            crearOdontograma(pacienteNuevo);
            direccionNuevo.setPacienteId(new Pacientes(pacienteNuevo.getPacienteId()));
            getDireccionesFacade().create(direccionNuevo);
            pacienteNuevo = new Pacientes();
            direccionNuevo = new Direcciones();
            this.setDepartamentoId(0);
            mensajeGuardado("El paciente se ha guardado.");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: guardarPaciente.");
        }
    }

    //Método que crea un odontograma a un nuevo paciente (paciente_registrar.xhtml)
    public void crearOdontograma(Pacientes paciente) {
        try{
            piezaNuevo.setPacienteId(new Pacientes(paciente.getPacienteId()));
            piezaNuevo.setOdontogramaPieza("11");
            piezaNuevo.setOdontogramaDistal(0);
            piezaNuevo.setOdontogramaOclusal(0);
            piezaNuevo.setOdontogramaMesial(0);
            piezaNuevo.setOdontogramaVestibular(0);
            piezaNuevo.setOdontogramaPalatina(0);
            piezaNuevo.setOdontogramaLingual(0);
            piezaNuevo.setOdontogramaGeneral(0);
            piezaNuevo.setOdontogramaRaiz(Boolean.FALSE);
            piezaNuevo.setOdontogramaExtraccion(Boolean.FALSE);
            piezaNuevo.setOdontogramaAusente(Boolean.FALSE);
            piezaNuevo.setOdontogramaFractura(Boolean.FALSE);
            piezaNuevo.setOdontogramaImplante(Boolean.FALSE);
            piezaNuevo.setOdontogramaProtesis(Boolean.FALSE);
            piezaNuevo.setOdontogramaProtesisReincide(Boolean.FALSE);
            piezaNuevo.setOdontogramaEndodoncia(Boolean.FALSE);
            piezaNuevo.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            piezaNuevo.setOdontogramaCuadrante(1);
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("12");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("13");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("14");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("15");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("16");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("17");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("18");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaCuadrante(2);
            piezaNuevo.setOdontogramaPieza("21");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("22");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("23");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("24");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("25");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("26");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("27");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("28");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaCuadrante(3);
            piezaNuevo.setOdontogramaPieza("31");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("32");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("33");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("34");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("35");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("36");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("37");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("38");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaCuadrante(4);
            piezaNuevo.setOdontogramaPieza("41");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("42");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("43");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("44");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("45");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("46");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("47");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("48");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaCuadrante(5);
            piezaNuevo.setOdontogramaPieza("51");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("52");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("53");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("54");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("55");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaCuadrante(6);
            piezaNuevo.setOdontogramaPieza("61");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("62");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("63");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("64");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("65");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaCuadrante(7);
            piezaNuevo.setOdontogramaPieza("71");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("72");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("73");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("74");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("75");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaCuadrante(8);
            piezaNuevo.setOdontogramaPieza("81");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("82");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("83");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("84");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo.setOdontogramaPieza("85");
            getOdontogramasFacade().create(piezaNuevo);
            piezaNuevo = new Odontogramas();
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: crearOdontograma.");
        }
    }
    
    // Método para calcular edad de los pacientes (pacientes_listado.xhtml)
    public int edadPaciente(Date fechaNacimiento) {
        Date fechaActual = new Date();
        int anio = fechaActual.getYear() - fechaNacimiento.getYear();
        int mes = fechaActual.getMonth() - fechaNacimiento.getMonth();
        int dia = fechaActual.getDate() - fechaNacimiento.getDate();
        //Si está en ese año pero todavía no los ha cumplido.
        if (mes < 0 || (mes == 0 && dia < 0)) {
            anio = anio - 1;
        }
        return anio;
    }
    
    // Método para obtener mes de nacimiento de los pacientes (pacientes_listado.xhtml)
    public String mesPaciente(Date fechaNacimiento){
        String mes = "";
        int mesEntero = fechaNacimiento.getMonth() + 1;
        switch(mesEntero){
            case 1: mes = "Enero"; break;
            case 2: mes = "Febrero"; break;
            case 3: mes = "Marzo"; break;
            case 4: mes = "Abril"; break;
            case 5: mes = "Mayo"; break;
            case 6: mes = "Junio"; break;
            case 7: mes = "Julio"; break;
            case 8: mes = "Agosto"; break;
            case 9: mes = "Septiembre"; break;
            case 10: mes = "Octubre"; break;
            case 11: mes = "Noviembre"; break;
            case 12: mes = "Diciembre"; break;
        }
        return mes;
    }
    
    // Método para extraer el teléfono de los pacientes (pacientes_listado.xhtml)
    public String telefonoPaciente(Pacientes paciente) {
        if(paciente.getPacienteTelefonoMovil() != null){
            return paciente.getPacienteTelefonoMovil();
        }
        if(paciente.getPacienteTelefonoCasa() != null){
            return paciente.getPacienteTelefonoCasa();
        }
        if(paciente.getPacienteTelefonoOficina() != null){
            return paciente.getPacienteTelefonoOficina();
        }
        return "Sin teléfono";
    }
    
    //Método para editar un Paciente (fichadatos_gestionar.xhtml)
    public void editarPaciente() {
        try{
            pacienteEditar.setPacienteUsuarioModificacion("Nombre de usuario");
            pacienteEditar.setPacienteFechaModificacion(new Date());
            getPacientesFacade().edit(pacienteEditar);
            this.setTabIndex(0);
            this.setTabIndexFicha(0);
            mensajeGuardado("Los datos del paciente se han actualizado.");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: editarPaciente.");
        }
    }

    //Método para editar la Dirección de un Paciente (fichadatos_gestionar.xhtml)
    public void editarDireccion() {
        try{
            getDireccionesFacade().edit(direccionEditar);
            this.setTabIndex(0);
            this.setTabIndexFicha(1);
            mensajeGuardado("La dirección de residencia se ha actualizado.");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: editarDireccion.");
        }
    }
 
    //Método para guardar Patologias de un paciente (antecedentes_gestionar.xhtml)
    public void guardarPatologias() {
        try{
            getPacientesFacade().edit(pacienteEditar);
            this.setTabIndex(1);
            mensajeGuardado("Los antecedentes se han actualizado.");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: guardarPatologias.");
        }
    }

    //Método para guardar Consulta de un paciente (consultas_gestionar.xhtml)
    public void guardarConsulta() throws InterruptedException {
        try{
            consultaNueva.setConsultaFechaCreacion(fechaSistema);
            consultaNueva.setPacienteId(new Pacientes(pacienteEditar.getPacienteId()));
            getConsultasFacade().create(consultaNueva);
            consultaEditar = getConsultasFacade().find(consultaNueva.getConsultaId());
            consultaNueva = new Consultas();
            this.setTabIndex(2);
            refrescaPagina("/views/3_expedientes/consultas_plantilla_gestionar.xhtml");
            Thread.sleep(5000);
            mensajeGuardado("La consulta se ha guardado.");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: guardarConsulta.");
        }
    }

    //Método para direccionar a una página (consultas_nuevo.xhtml)
    public void refrescaPagina(String url){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        String contextPath = origRequest.getContextPath();
        try{
            FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath+url);
        }
        catch(IOException e){
            e.printStackTrace();
            mensajeError("Se detuvo el proceso en el método: refrescaPagina.");
        }
    }
    
    //Método para editar una Consulta (consultas_gestionar.xhtml)
    public void editarConsulta() {
        try{
            getConsultasFacade().edit(consultaEditar);
            this.setTabIndex(2);
            mensajeGuardado("La consulta se ha actualizado.");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: editarConsulta.");
        }
    }
    
    //Método para seleccionar extracción en una pieza (odontograma_gestionar.xhtml)
    public void extraccionSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaExtraccion() == true){
                piezaEditar.setOdontogramaAusente(Boolean.FALSE);
                piezaEditar.setOdontogramaFractura(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesis(Boolean.FALSE);
                piezaEditar.setOdontogramaImplante(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodoncia(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesisReincide(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: extraccionSeleccionada.");
        }
    }
   
    //Método para seleccionar ausente en una pieza (odontograma_gestionar.xhtml)
    public void ausenteSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaAusente() == true){
                piezaEditar.setOdontogramaExtraccion(Boolean.FALSE);
                piezaEditar.setOdontogramaFractura(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesis(Boolean.FALSE);
                piezaEditar.setOdontogramaImplante(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodoncia(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesisReincide(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: ausenteSeleccionada.");
        }
    }
   
    //Método para seleccionar fractura en una pieza (odontograma_gestionar.xhtml)
    public void fracturaSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaFractura() == true){
                piezaEditar.setOdontogramaExtraccion(Boolean.FALSE);
                piezaEditar.setOdontogramaAusente(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesis(Boolean.FALSE);
                piezaEditar.setOdontogramaImplante(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodoncia(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesisReincide(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: fracturaSeleccionada.");
        }
    }
   
    //Método para seleccionar protesis en una pieza (odontograma_gestionar.xhtml)
    public void protesisSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaProtesis() == true){
                piezaEditar.setOdontogramaExtraccion(Boolean.FALSE);
                piezaEditar.setOdontogramaAusente(Boolean.FALSE);
                piezaEditar.setOdontogramaFractura(Boolean.FALSE);
                piezaEditar.setOdontogramaImplante(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodoncia(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesisReincide(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: protesisSeleccionada.");
        }
    }
   
    //Método para seleccionar implante en una pieza (odontograma_gestionar.xhtml)
    public void implanteSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaImplante() == true){
                piezaEditar.setOdontogramaExtraccion(Boolean.FALSE);
                piezaEditar.setOdontogramaAusente(Boolean.FALSE);
                piezaEditar.setOdontogramaFractura(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesis(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodoncia(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesisReincide(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: implanteSeleccionada.");
        }
    }
    
    //Método para seleccionar endodoncia en una pieza (odontograma_gestionar.xhtml)
    public void endodonciaSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaEndodoncia() == true){
                piezaEditar.setOdontogramaExtraccion(Boolean.FALSE);
                piezaEditar.setOdontogramaAusente(Boolean.FALSE);
                piezaEditar.setOdontogramaFractura(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesis(Boolean.FALSE);
                piezaEditar.setOdontogramaImplante(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesisReincide(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: endodonciaSeleccionada.");
        }
    }
   
    //Método para seleccionar protesis reincidente en una pieza (odontograma_gestionar.xhtml)
    public void protesisReincidenteSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaProtesisReincide() == true){
                piezaEditar.setOdontogramaExtraccion(Boolean.FALSE);
                piezaEditar.setOdontogramaAusente(Boolean.FALSE);
                piezaEditar.setOdontogramaFractura(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesis(Boolean.FALSE);
                piezaEditar.setOdontogramaImplante(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodoncia(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodonciaReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: protesisReincidenteSeleccionada.");
        }
    }
   
    //Método para seleccionar endodoncia reincidente en una pieza (odontograma_gestionar.xhtml)
    public void endodonciaReincidenteSeleccionada(){
        try{
            if(piezaEditar.getOdontogramaEndodonciaReincide() == true){
                piezaEditar.setOdontogramaExtraccion(Boolean.FALSE);
                piezaEditar.setOdontogramaAusente(Boolean.FALSE);
                piezaEditar.setOdontogramaFractura(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesis(Boolean.FALSE);
                piezaEditar.setOdontogramaImplante(Boolean.FALSE);
                piezaEditar.setOdontogramaEndodoncia(Boolean.FALSE);
                piezaEditar.setOdontogramaProtesisReincide(Boolean.FALSE);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: endodonciaReincidenteSeleccionada.");
        }
    }
   
    //Método para editar una Pieza (odontograma_gestionar.xhtml)
    public void editarPieza(){
        try{
            getOdontogramasFacade().edit(piezaEditar);
            piezaEditar = new Odontogramas();
            this.setTabIndex(3);
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: editarPieza.");
        }
    }
    
    //Método para guardar Detalle de Consulta (odontograma_gestionar.xhtml)
    public void guardarDetalleConsulta() {
        try{
            detalleConsultaNuevo.setPacienteId(new Pacientes(pacienteEditar.getPacienteId()));
            detalleConsultaNuevo.setDetalleconsultaFechaCreacion(fechaSistema);
            detalleConsultaNuevo.setDetalleconsultaUsuarioCreacio("Nombre Usuario");
            getDetallesConsultasFacade().create(detalleConsultaNuevo);
            detalleConsultaNuevo = new DetallesConsultas();
            this.setTabIndex(3);
            mensajeGuardado("El tratamiento se ha guardado.");
            //refrescaPagina("/views/3_expedientes/paciente_expediente_gestionar.xhtml");
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: guardarDetalleConsulta.");
        }
    }

    // Método para extraer la ubicación de imágenes (imagenes_consultar.xhtml)
    public String imagenPaciente(Imagenes imagen) {
        String direccion = "../../images/pacientes/"+pacienteConsultar.getPacienteId()+"/"+imagen.getImagenNombre();
        return direccion;
    }
    
    //Método para verificar si ya existe la imagen a subir (imagenes_gestionar.xhtml)
    public void existeArchivo() {
        try{
            FacesContext cty = FacesContext.getCurrentInstance();
            String directorio = cty.getExternalContext().getInitParameter("directory_path_patients");
            File archivo1 = new File(directorio + pacienteEditar.getPacienteId() + "/" + getFile().getFileName()+"/");
            if (archivo1.exists()) {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Mensaje", "El archivo seleccionado ya existe para este paciente.");
                RequestContext.getCurrentInstance().showMessageInDialog(message);
            }
            else{
                subeArchivo(file);
            }
        } catch (Exception e) {
            mensajeError("Se detuvo el proceso en el método: existeArchivo.");
        }
    }
        
    //Método que guarda el archivo seleccionado (ver_aprobacion) y (ver_perfil).
    public void subeArchivo(UploadedFile file) throws InterruptedException {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String directorioArchivo = ctx.getExternalContext().getInitParameter("directory_path_patients");
        File storage_folder = new File(directorioArchivo + pacienteEditar.getPacienteId());
        if (!storage_folder.exists()) {
            storage_folder.mkdir();
        }
        String fname = getFile().getFileName();
        int middle = fname.lastIndexOf(".");
        String ext = fname.substring(middle + 1, fname.length());
        File archivoImagen = new File(directorioArchivo + pacienteEditar.getPacienteId() + "/" + getFile().getFileName());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(archivoImagen);
            byte[] buffer = new byte[BUFFER_SIZE];
            int bulk;
            InputStream inputStream = getFile().getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }
                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }
            fileOutputStream.close();
            inputStream.close();
            imagenNueva.setImagenUrl(directorioArchivo + pacienteEditar.getPacienteId() + "/" + getFile().getFileName());
            imagenNueva.setImagenNombre(getFile().getFileName());
            imagenNueva.setPacienteId(new Pacientes(pacienteEditar.getPacienteId()));
            imagenNueva.setImagenFechaCreacion(new Date());
            imagenNueva.setImagenUsuarioCreacion("Nombre Usuario");
            getImagenesFacade().create(imagenNueva);
            Thread.sleep(3000);
            imagenNueva = new Imagenes();
            this.setTabIndex(4);
            mensajeGuardado("La imagen se ha guardado.");
        } catch (IOException e) {
            mensajeError("Se detuvo el proceso en el método: subeArchivo.");
        }
    }
    
    //Método para mostrar mensaje de guardado/actualizado.
    public void mensajeGuardado(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
    
    //Método para mostrar mensaje de error en el sistema.
    public void mensajeError(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "¡Error!", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
        
    // Método para extraer el nombre de los médicos (consultas_nuevo.xhtml) y (consultas_gestionar.xhtml)
    public String nombreMedico(Medicos medico) {
        String nombre = "Dra. ";
        if(medico.getMedicoSexo()){
            nombre = "Dr. ";
        }
        if(medico.getMedicoPrimerNombre() != null){
            nombre = nombre + medico.getMedicoPrimerNombre();
        }
        if(medico.getMedicoSegundoNombre() != null){
            nombre = nombre + " " + medico.getMedicoSegundoNombre();
        }
        if(medico.getMedicoPrimerApellido() != null){
            nombre = medico + " " + medico.getMedicoPrimerApellido();
        }
        if(medico.getMedicoSegundoApellido() != null){
            nombre = medico + " " + medico.getMedicoSegundoApellido();
        }
        return nombre;
    }
    
    
    
    
    
    
    
    
    
    public void asignaTab(){
        this.setTabIndex(4);
    }
    
    //Este método no se donde carajo se ocupa jajaja
    public void direccionPaciente() {
        direccionConsultar = new Direcciones();
        direccionConsultar = getDireccionesFacade().DireccionDePaciente(pacienteConsultar.getPacienteId());
        Municipios mup = getMunicipiosFacade().MunicipioDePaciente(direccionConsultar.getMunicipioId().getMunicipioId());
        departametoIdConsultar = mup.getDepartamentoId().getDepartamentoId();
    }
        
}
