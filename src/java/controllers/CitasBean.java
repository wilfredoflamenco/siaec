package controllers;

import dao.CitasFacade;
import dao.ClinicasFacade;
import dao.MedicosFacade;
import entities.Citas;
import entities.Clinicas;
import entities.Medicos;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;

@Named(value = "citasBean1")
@SessionScoped
public class CitasBean implements Serializable {

//****************************************************************************//
//                          Declaración de variables                          //
//****************************************************************************//
    @EJB
    private CitasFacade citasFacade;
    private Citas citaNuevo = new Citas();
    private Citas citaConsultar = new Citas();
    private Citas citaEditar = new Citas();
    private Calendar citaEditarFecha = Calendar.getInstance();
    private Calendar citaEditarHora = Calendar.getInstance();
    private Clinicas citasEditarSucursal = new Clinicas();
    private Citas citaEliminar = new Citas();
    private int idEliminar;

    @EJB
    private ClinicasFacade clinicasFacade;

    @EJB
    private MedicosFacade odontologosFacade;

    private Date citaDia = new Date();
    private Integer horaE;
    private Date fechaActual = new Date();

//****************************************************************************//
//                  Métodos para obtener listas por entidades                 //
//****************************************************************************//
    public List<Clinicas> todasClinicas() {
        return getClinicasFacade().findAll();
    }

    public List<Medicos> todoOdontologos() {
        return getOdontologosFacade().findAll();
    }

//****************************************************************************//
//                 Métodos Get para obtener datos de entidades                //
//****************************************************************************//
    public CitasFacade getCitasFacade() {
        return citasFacade;
    }

    public ClinicasFacade getClinicasFacade() {
        return clinicasFacade;
    }

    public MedicosFacade getOdontologosFacade() {
        return odontologosFacade;
    }

//****************************************************************************//
//                             Métodos Get y SET                              //
//****************************************************************************//
    public Date getCitaDia() {
        return citaDia;
    }

    public void setCitaDia(Date citaDia) {
        this.citaDia = citaDia;
    }

    public Citas getCitaNuevo() {
        return citaNuevo;
    }

    public void setCitaNuevo(Citas citaNuevo) {
        this.citaNuevo = citaNuevo;
    }

    public Integer getHoraE() {
        return horaE;
    }

    public void setHoraE(Integer horaE) {
        this.horaE = horaE;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Citas getCitaConsultar() {
        return citaConsultar;
    }

    public void setCitaConsultar(Citas citaConsultar) {
        this.citaConsultar = citaConsultar;
    }

    public Citas getCitaEditar() {
        return citaEditar;
    }

    public void setCitaEditar(Citas citaEditar) {
        this.citaEditar = citaEditar;
    }

    public Citas getCitaEliminar() {
        return citaEliminar;
    }

    public void setCitaEliminar(Citas citaEliminar) {
        this.citaEliminar = citaEliminar;
    }

    public int getIdEliminar() {
        return idEliminar;
    }

    public void setIdEliminar(int idEliminar) {
        this.idEliminar = idEliminar;
    }

//****************************************************************************//
//                                  Métodos                                   //
//****************************************************************************//
    //Obteniendo horarios disponible de odontologo usado en cita_nueva.html
    public List<Horario> horariosDisponibleSucursal() {
        List<Horario> horarios = new ArrayList<>();
        horarios.clear();
        Calendar cita = Calendar.getInstance();
        cita.setTime(citaDia);
        String s;
        System.out.println("Entra");
        if (citaNuevo.getClinicaId() != null) {
            Calendar clinicaInicio = Calendar.getInstance();
            Calendar clinicaFin = Calendar.getInstance();
            clinicaInicio.setTime(citaNuevo.getClinicaId().getClinicaHorarioApertura());
            clinicaFin.setTime(citaNuevo.getClinicaId().getClinicaHorarioCierre());

            for (int i = clinicaInicio.get(Calendar.HOUR_OF_DAY); i < clinicaFin.get(Calendar.HOUR_OF_DAY); i++) {
                Calendar citaPreguntar = Calendar.getInstance();
                citaPreguntar.setTime(citaDia);
                citaPreguntar.set(Calendar.HOUR_OF_DAY, i);
                citaPreguntar.set(Calendar.MINUTE, 0);
                citaPreguntar.set(Calendar.SECOND, 0);

                List<Citas> reservadasSucursal = getCitasFacade().citasReservadoSucursal(cita.getTime(), citaNuevo.getClinicaId().getClinicaId(), citaPreguntar.getTime());
                int cantidadCitas = reservadasSucursal.size();

                if (i < 13) {
                    s = i + ":00 AM";
                } else {
                    s = (i - 12) + ":00 PM";
                }

                if (cantidadCitas < citaNuevo.getClinicaId().getClinicaModulo()) {
                    horarios.add(new Horario(i, s));
                }
            }
            return horarios;
        } else {
            System.out.println("Solo yo me ejecuto");
            return horarios;
        }
    }

    //Metodo para obtener citas para editar cita
    public List<Horario> horariosDisponibleSucursalEditar() {
        horaE = null;
        List<Horario> horarios = new ArrayList<>();
        horarios.clear();
        Calendar cita = Calendar.getInstance();
        cita.setTime(citaDia);
        String s;
        if (citaEditar.getClinicaId() != null) {
            Calendar clinicaInicio = Calendar.getInstance();
            Calendar clinicaFin = Calendar.getInstance();
            clinicaInicio.setTime(citaEditar.getClinicaId().getClinicaHorarioApertura());
            clinicaFin.setTime(citaEditar.getClinicaId().getClinicaHorarioCierre());

            for (int i = clinicaInicio.get(Calendar.HOUR_OF_DAY); i < clinicaFin.get(Calendar.HOUR_OF_DAY); i++) {
                Calendar citaPreguntar = Calendar.getInstance();
                citaPreguntar.setTime(citaDia);
                citaPreguntar.set(Calendar.HOUR_OF_DAY, i);
                citaPreguntar.set(Calendar.MINUTE, 0);
                citaPreguntar.set(Calendar.SECOND, 0);

                List<Citas> reservadasSucursal = getCitasFacade().citasReservadoSucursal(cita.getTime(), citaEditar.getClinicaId().getClinicaId(), citaPreguntar.getTime());
                int cantidadCitas = reservadasSucursal.size();

                if (i < 13) {
                    s = i + ":00 AM";
                } else {
                    s = (i - 12) + ":00 PM";
                }

                //Si la cita que se tiene guardado es igua a la cita que se pregunta
                if (citaEditarFecha.get(Calendar.YEAR) == citaPreguntar.get(Calendar.YEAR) && citaEditarFecha.get(Calendar.MONTH) == citaPreguntar.get(Calendar.MONTH) && citaEditarFecha.get(Calendar.DAY_OF_MONTH) == citaPreguntar.get(Calendar.DAY_OF_MONTH) && citasEditarSucursal.getClinicaId() == citaEditar.getClinicaId().getClinicaId()) {
                    // if (citaEditarFecha.get(Calendar.YEAR) == citaPreguntar.get(Calendar.YEAR) && citaEditarFecha.get(Calendar.MONTH) == citaPreguntar.get(Calendar.MONTH) && citaEditarFecha.get(Calendar.DAY_OF_MONTH) == citaPreguntar.get(Calendar.DAY_OF_MONTH) && Objects.equals(citasEditarSucursal.getClinicaId(), citaEditar.getClinicaId().getClinicaId())) {

                    if (citaEditarHora.get(Calendar.HOUR_OF_DAY) == i) {
                        horaE = citaEditarHora.get(Calendar.HOUR_OF_DAY);
                       // System.out.println("cuantas veces entras" + horaE);
                        horarios.add(new Horario(i, s));
                    } else if (cantidadCitas < citaEditar.getClinicaId().getClinicaModulo()) {
                        horarios.add(new Horario(i, s));
                    }

                } else if (cantidadCitas < citaEditar.getClinicaId().getClinicaModulo()) {
                    horarios.add(new Horario(i, s));
                }

            }//Fin de for
            return horarios;
        } else {
            return horarios;
        }
    }

    //Metodo para guardar cita utilizado en cita_nueva.html
    public void guardarCita() {
        System.out.println("Se guardo la cita");
        citaNuevo.setCitaFecha(citaDia);
        Calendar hora = Calendar.getInstance();
        hora.set(Calendar.HOUR_OF_DAY, horaE);
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);
        citaNuevo.setCitaHora(hora.getTime());
        citaNuevo.setCitaFechaCreacion(new Date());
        citaNuevo.setCitaHoraCreacion(new Date());
        getCitasFacade().create(citaNuevo);
        citaNuevo = new Citas();
        citaDia = new Date();
        mensajeGuardado("Su cita a sido guardada.");
    }

    //Método para refrescar los valores utilizado en cita_nueva.xhtml.
    public void refrescar() {
        citaDia = new Date();
        citaNuevo = new Citas();
        horaE = null;
    }

    //Método para recargar la pagina.
    public void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    //Método para mostrar mensaje de guardado/actualizado.
    public void mensajeGuardado(String mensaje) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje", mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }

    //Método usado para cargar las proximas citas desde fecha actual, usado en cita_lista_proximas.xhtml
    public List<Citas> citasProximas() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        //System.out.println("Fecha actual " + c.getTime());
        return getCitasFacade().citasProximas(c.getTime());
    }

    //Método para mostrar los estados de las citas. 
    public String estadoCita(Integer estado) {
        switch (estado) {
            case 1:
                return "Reservado";
            case 2:
                return "Confirmado";
            case 3:
                return "Atendido";
            case 4:
                return "Cancelado";
            default:
                return "";
        }
    }

    //Hora no se utiliza partnerr por razones de error con en compilaciond e sesionbean
    public String horacita(Date hora) {
        Calendar c = Calendar.getInstance();
        c.setTime(hora);
        //System.out.println("Metodo horacita(), class Citas Bean" + c.get(Calendar.HOUR_OF_DAY));
        if (c.get(Calendar.HOUR_OF_DAY) < 13) {
            return (c.get(Calendar.HOUR_OF_DAY)) + ":00 AM";
        } else {
            return (c.get(Calendar.HOUR_OF_DAY) - 12) + ":00 PM";
        }
    }

    //Retornando medico dentro de la tabla usado en cita_lista_proximas.xhtml
    public String nombreMedico(Integer id) {
        if (id != null) {
            Medicos m = getOdontologosFacade().find(id);
            if (m.getMedicoSexo() == true) {
                return "Dr." + m.getMedicoPrimerNombre() + m.getMedicoPrimerApellido();
            } else {
                return "Dra." + m.getMedicoPrimerNombre() + m.getMedicoPrimerApellido();
            }
        }
        return "";
    }

    //Retornar si es Dr. o Dra. 
    public String abreviatura(Boolean s) {
        if (s != null) {
            return (s) ? "Dr." : "Dra.";
        }
        return "";
    }

    //Colocar la hora y cita en editarcITA
    public void editarConsultaHoraCita() {
        citaDia = citaEditar.getCitaFecha();
        Calendar horaSeleccionada = Calendar.getInstance();
        horaSeleccionada.setTime(citaEditar.getCitaHora());
        citaEditarFecha.setTime(citaEditar.getCitaFecha());
        citaEditarHora.setTime(citaEditar.getCitaHora());
        citasEditarSucursal = citaEditar.getClinicaId();
    }

    public void resertEditarCita() {
        citaEditar.setClinicaId(citasEditarSucursal);
        citaDia = citaEditar.getCitaFecha();
    }

    public void actualizarCita() {
        citaEditar.setCitaFecha(citaDia);
        Calendar hora = Calendar.getInstance();
        hora.set(Calendar.HOUR_OF_DAY, horaE);
        hora.set(Calendar.MINUTE, 0);
        hora.set(Calendar.SECOND, 0);
        citaEditar.setCitaHora(hora.getTime());
        citaEditar.setCitaFechaModificacion(new Date());
        getCitasFacade().edit(citaEditar);
        citaDia = citaEditar.getCitaFecha();
        //citaEditarHora.set(0, 0);
        citaEditarHora.setTime(citaEditar.getCitaHora());
        citaEditarFecha.setTime(citaEditar.getCitaFecha());
        citasEditarSucursal = citaEditar.getClinicaId();
        horaE = hora.get(Calendar.HOUR_OF_DAY);
        //System.out.println("hora de set cual sera" + horaE);
        mensajeGuardado("Su cita a sido modificada.");
    }

    public void eliminarCita() {
        // citaEliminar = getCitasFacade().find(idEliminar);
        citaEliminar.setCitaEstado(4);
        getCitasFacade().edit(citaEliminar);
        mensajeGuardado("La cita ha sido eliminado.");
    }
}
