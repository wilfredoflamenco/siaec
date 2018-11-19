package controllers;

import dao.ConfiguracionesFacade;
import dao.PacientesFacade;
import dao.PromocionesFacade;
import entities.Configuraciones;
import entities.Pacientes;
import entities.Promociones;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import util.CorreoBasico;

@Stateless
public class tareasProgramadasBean {

//****************************************************************************//
//                          Declaración de variables                          //
//****************************************************************************//
    @EJB
    private PacientesFacade pacientesFacade;
    private Pacientes paciente = new Pacientes();

    @EJB
    private PromocionesFacade promocionesFacade;
    private Promociones promociones;
    private Calendar mes = Calendar.getInstance();
    private Calendar mesActual = Calendar.getInstance();

    @EJB
    private ConfiguracionesFacade configuracionFacade;

//****************************************************************************//
//                  Métodos para obtener listas por entidades                 //
//****************************************************************************//
    public List<Pacientes> todosPacientes() {
        return getPacientesFacade().findAll();
    }

    public List<Pacientes> pacientesPorCorreo(Integer desde) {
        return getPacientesFacade().pacientesNotificarCorreDesde(desde);
    }

    public List<Promociones> promocionesCumpleanyosMes() {
        return getPromocionesFacade().promocionesFechaMes();
    }

    public List<Promociones> promocionesEspeciales() {
        return getPromocionesFacade().promocionesEspeciales();
    }

//****************************************************************************//
//                 Métodos Get para obtener datos de entidades                //
//****************************************************************************//
    public PacientesFacade getPacientesFacade() {
        return pacientesFacade;
    }

    public PromocionesFacade getPromocionesFacade() {
        return promocionesFacade;
    }

    public ConfiguracionesFacade getConfiguracionFacade() {
        return configuracionFacade;
    }

//****************************************************************************//
//                   Métodos para tareas programas                            //
//****************************************************************************//
    //@Schedule(dayOfMonth = "*", hour = "*", minute = "*/4", persistent = false)
    public void enviarPromocionesCumpleanyos() {
        try {
            System.out.println("Se ejecuto el metodo envio de promociones para cumpleañeros a las:" + new Date());
            Configuraciones correoConfiguracion = getConfiguracionFacade().find(1);
            if (correoConfiguracion != null) {
                if (correoConfiguracion.getConfiguracionCorreoActivo()) {
                    String cuerpo = "";
                    Integer enviadosMes = correoConfiguracion.getConfiguracionCorreoEnviadoMes();
                    Integer enviadosDia = correoConfiguracion.getConfiguracionCorreoEnviadoDia();
                    Integer limiteMes = correoConfiguracion.getConfiguracionCorreoMes();
                    Integer limiteDia = correoConfiguracion.getConfiguracionCorreoDia();
                    if (((enviadosMes < limiteMes && enviadosDia < limiteDia) || correoConfiguracion.getConfiguracionCorreoIlimitada())
                            && !correoConfiguracion.getConfiguracionCorreoCuenta().isEmpty()) {
                        Integer desde = 0;
                        List<Promociones> promocionesEnviar = promocionesCumpleanyosMes();
                        if (!promocionesEnviar.isEmpty()) {
                            //System.out.println("El primer valor es " + promocionesEnviar.get(0).getPromocionCorreoLimitadoEspera() + "Id " + promocionesEnviar.get(0).getPromocionId());
                            if (promocionesEnviar.size() > 1) {
                                desde = promocionesEnviar.get(0).getPromocionCorreoLimitadoEspera();
                                for (Promociones promociones1 : promocionesEnviar) {
                                    if (desde > promociones1.getPromocionCorreoLimitadoEspera()) {
                                        desde = promociones1.getPromocionCorreoLimitadoEspera();
                                    }
                                }
                            } else {
                                desde = promocionesEnviar.get(0).getPromocionCorreoLimitadoEspera();
                            }
                            System.out.println("Comenzare desde el paciente con id: " + desde);
                            List<Pacientes> pacientesEnviar = pacientesPorCorreo(desde);
                            if (!pacientesEnviar.isEmpty()) {
                                //CorreoBasico enviar = new CorreoBasico(correoConfiguracion);
                                for (Pacientes p : pacientesEnviar) {
                                    if (mes.get(Calendar.MONTH) == mesActual.get(Calendar.MONTH)) {
                                        if ((enviadosMes < limiteMes && enviadosDia < limiteDia) || correoConfiguracion.getConfiguracionCorreoIlimitada()) {
                                            System.out.println("El paciente: " + p.getPacientePrimerNombre() + " recibira.");
                                            enviadosDia++;
                                            enviadosMes++;
                                            System.out.println("En su mes de cumpleanyos " + mes.get(Calendar.MONTH));
                                            for (Promociones promo : promocionesEnviar) {
                                                cuerpo = cuerpo + promo.getPromocionMensaje() + "<br/>";
                                                promo.setPromocionCorreoLimitadoEspera(p.getPacienteId());
                                                getPromocionesFacade().edit(promo);
                                            }
                                            System.out.println("Promociones " + cuerpo);
                                            String body = "<div style=\"margin-top: 0px; margin-bottom: 35px;\">"
                                                    + "      <h1 style=\"text-align: center; background: #0B6EAC; color: white\">Clinica Dental Smiling</h1>    "
                                                    + "    </div>"
                                                    + "    <div style=\"margin-top: 10px; margin-bottom: 60px;\">"
                                                    + "      <p>"
                                                    + "          <br/>" + cuerpo + "<br/>"
                                                    + "      </p>"
                                                    + "    </div>"
                                                    + "    <div style=\"background-color:#0B6EAC; color: white;\">"
                                                    + "      <div style=\"text-align: right\">"
                                                    + "         <p>Horario de lunes a viernes de 8:00 a.m. a 6:00 p.m.<br/>"
                                                    + "            Sabádo de 8:00 a.m. a 2:30 p.m. <br/>"
                                                    + "            Diagonal Dr Arturo Romero edificio 444 local # 4 Edificio del Subway . Col medica.<br/>"
                                                    + "         </p>"
                                                    + "      </div>"
                                                    + "         <div style=\"padding:5px; text-align: center; border-top: 1px double white\">"
                                                    + "              © 2019 <b>SIAEC</b> Todos los Derechos Reservados."
                                                    + "         </div> "
                                                    + "      </div>";

                                            if (promocionesEnviar.size() == 1) {
                                                // enviar.sendMailHTML(p.getPacienteCorreo(), promocionesEnviar.get(0).getPromocionNombre(), body);
                                                System.out.println("se envio para uno");
                                            } else {
                                                // enviar.sendMailHTML(p.getPacienteCorreo(), "Ven y descubre las promociones que tenemos en el mes de tu cumpleaños!", body);
                                                System.out.println("se envio para muchos");
                                            }
                                        }//Fin de if enviadosDia <= limiteDia
                                    }//Fin de if cumpleanyeros
                                }//Fin de if de pacientes vacio
                            }//Fin de for paciente
                        }//Fin del if promociones vacias 
                    }//Fin de correo ilimato y cuenta no null
                    correoConfiguracion.setConfiguracionCorreoEnviadoDia(enviadosDia);
                    correoConfiguracion.setConfiguracionCorreoEnviadoMes(enviadosMes);
                    getConfiguracionFacade().edit(correoConfiguracion);
                }//Fin de correo activo
            }
        } catch (Exception e) {
            System.err.println("error en enviarPromocionesCumpleanyos");
        } finally {
            System.out.println("enviarPromocionesCumpleanyos() finally");
        }

    }

    //@Schedule(dayOfMonth = "*", hour = "*", minute = "*", persistent = false)
    public void promocionesEspecialesEnviar() {
        try {
            System.out.println("Se esta ejecutando promociones especiales" + new Date());
            Configuraciones correoConfiguracion = getConfiguracionFacade().find(1);
            if (correoConfiguracion != null) {
                if (correoConfiguracion.getConfiguracionCorreoActivo()) {
                    String cuerpo = "";
                    Integer enviadosMes = correoConfiguracion.getConfiguracionCorreoEnviadoMes();
                    Integer enviadosDia = correoConfiguracion.getConfiguracionCorreoEnviadoDia();
                    Integer limiteMes = correoConfiguracion.getConfiguracionCorreoMes();
                    Integer limiteDia = correoConfiguracion.getConfiguracionCorreoDia();
                    if ((enviadosMes < limiteMes && enviadosDia < limiteDia) || correoConfiguracion.getConfiguracionCorreoIlimitada()) {
                        if (!correoConfiguracion.getConfiguracionCorreoCuenta().isEmpty()) {
                            List<Promociones> promocionesEnviar = promocionesEspeciales();
                            if (!promocionesEnviar.isEmpty()) {
                                //CorreoBasico enviar = new CorreoBasico(correoConfiguracion);
                                Integer desde = 0;
                                System.out.println("El primer valor es " + promocionesEnviar.get(0).getPromocionCorreoLimitadoEspera() + "Id " + promocionesEnviar.get(0).getPromocionId());
                                if (promocionesEnviar.size() > 1) {
                                    desde = promocionesEnviar.get(0).getPromocionCorreoLimitadoEspera();
                                    for (Promociones promociones1 : promocionesEnviar) {
                                        if (desde > promociones1.getPromocionCorreoLimitadoEspera()) {
                                            desde = promociones1.getPromocionCorreoLimitadoEspera();
                                        }
                                    }
                                } else {
                                    desde = promocionesEnviar.get(0).getPromocionCorreoLimitadoEspera();
                                }
                                System.out.println("Valor minimo de salida" + desde);
                                List<Pacientes> pacientesEnviar = pacientesPorCorreo(desde);
                                for (Pacientes p : pacientesEnviar) {
                                    if ((enviadosMes < limiteMes && enviadosDia < limiteDia) || correoConfiguracion.getConfiguracionCorreoIlimitada()) {
                                        System.out.println("El paciente: " + p.getPacientePrimerNombre() + " recibira.");
                                        enviadosDia++;
                                        enviadosMes++;
                                        for (Promociones promo : promocionesEnviar) {
                                            // System.out.println("Promocion: " + promo.getPromocionMensaje());
                                            cuerpo = cuerpo + promo.getPromocionMensaje() + "<br/>";
                                            promo.setPromocionCorreoLimitadoEspera(p.getPacienteId());
                                            getPromocionesFacade().edit(promo);
                                        }
                                        System.out.println("Promociones " + cuerpo);
                                        String body = "<div style=\"margin-top: 0px; margin-bottom: 35px;\">"
                                                + "      <h1 style=\"text-align: center; background: #0B6EAC; color: white\">Clinica Dental Smiling</h1>    "
                                                + "    </div>"
                                                + "    <div style=\"margin-top: 10px; margin-bottom: 60px;\">"
                                                + "      <p>"
                                                + "          <br/>" + cuerpo + "<br/>"
                                                + "      </p>"
                                                + "    </div>"
                                                + "    <div style=\"background-color:#0B6EAC; color: white;\">"
                                                + "      <div style=\"text-align: right\">"
                                                + "         <p>Horario de lunes a viernes de 8:00 a.m. a 6:00 p.m.<br/>"
                                                + "            Sabádo de 8:00 a.m. a 2:30 p.m. <br/>"
                                                + "            Diagonal Dr Arturo Romero edificio 444 local # 4 Edificio del Subway . Col medica.<br/>"
                                                + "         </p>"
                                                + "      </div>"
                                                + "         <div style=\"padding:5px; text-align: center; border-top: 1px double white\">"
                                                + "              © 2019 <b>SIAEC</b> Todos los Derechos Reservados."
                                                + "         </div> "
                                                + "      </div>";
                                        if (promocionesEnviar.size() == 1) {
                                            // enviar.sendMailHTML(p.getPacienteCorreo(), promocionesEnviar.get(0).getPromocionNombre(), body);
                                            System.out.println("se envio para uno");
                                        } else {
                                            //      enviar.sendMailHTML(p.getPacienteCorreo(), "Aprovecha estas promociones especiales para ti!", body);
                                            System.out.println("se envio para muchos");
                                        }
                                    }//Fin de if enviadosDia <= limiteDia
                                }//Fin de for paciente
                            }//Fin if si preugnta si hay promociones
                        }//Fin de if si cuenta esta vacia.  
                    }//Fin de if limitado o mandar correos ilimitados
                    correoConfiguracion.setConfiguracionCorreoEnviadoDia(enviadosDia);
                    correoConfiguracion.setConfiguracionCorreoEnviadoMes(enviadosMes);
                    getConfiguracionFacade().edit(correoConfiguracion);
                }//Fin de correo activo.
            }
        } catch (Exception e) {
            System.err.println(new Date() + "Error con el metodo promocionesEspeciales(): " + e);
        }

    }

    //@Schedule(dayOfMonth = "*", hour = "*", minute = "*/3", persistent = false)
    public void reiniciarMensajesDia() {
        try {
            System.out.println("reiniciando hora" + new Date());
            Configuraciones correoConfiguracion = getConfiguracionFacade().find(1);
            if (correoConfiguracion.getConfiguracionCorreoActivo() && !correoConfiguracion.getConfiguracionCorreoIlimitada()) {
                correoConfiguracion.setConfiguracionCorreoEnviadoDia(0);
                getConfiguracionFacade().edit(correoConfiguracion);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //@Schedule(dayOfMonth = "*", hour = "*", minute = "*/5", persistent = false)
    public void reiniciarMensajesMes() {
        try {
            System.out.println("reiniciando mes " + new Date());
            Configuraciones correoConfiguracion = getConfiguracionFacade().find(1);
            if (correoConfiguracion.getConfiguracionCorreoActivo() && !correoConfiguracion.getConfiguracionCorreoIlimitada()) {
                correoConfiguracion.setConfiguracionCorreoEnviadoMes(0);
                getConfiguracionFacade().edit(correoConfiguracion);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    //Solo se utilizara para las promociones de cumpleanyos y especiales
    //@Schedule(dayOfMonth = "*", hour = "*", minute = "*/5", persistent = false)
    public void reiniciarCorreoPromocionesVigentesEspAndCump() {
        try {
            System.out.println("Reiniciando las promociones especiales y cumpleaños. " + new Date());
            List<Promociones> reiniciarPromo = getPromocionesFacade().promocionesReinicioCumpAndEsp();
            if (!reiniciarPromo.isEmpty()) {
                for (Promociones promociones1 : reiniciarPromo) {
                    promociones1.setPromocionCorreoLimitadoEspera(0);
                    getPromocionesFacade().edit(promociones);
                }
            }
        } catch (Exception e) {
            System.err.println(new Date() + " Error con el metodo reinicarCorreoPromocionesVigentes. " + e);
        }
    }

}
