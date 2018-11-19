package controllers;

import dao.CitasFacade;
import dao.PacientesFacade;
import entities.Citas;
import entities.Pacientes;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.event.ToggleEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author user
 */
//@Named(value = "dashboardView")
@Named(value = "hola")
@ViewScoped
public class DashboardView implements Serializable {

//****************************************************************************//
//                          Declaración de variables                          //
//****************************************************************************//
    @EJB
    private CitasFacade citasfacade;
    List<Citas> citas = new ArrayList<Citas>();
    @EJB
    private PacientesFacade pacientefacade;
    
    private DashboardModel model;
    private LineChartModel lineModel1 = new LineChartModel();
    private PieChartModel pieModel;

    public DashboardView() {
    }

    @PostConstruct
    public void init() {
        model = new DefaultDashboardModel();
        DashboardColumn column1 = new DefaultDashboardColumn();
        DashboardColumn column2 = new DefaultDashboardColumn();
        DashboardColumn column3 = new DefaultDashboardColumn();
        DashboardColumn column4 = new DefaultDashboardColumn();

        column1.addWidget("paciente");
        column2.addWidget("nuevos");
        column3.addWidget("total");
        column4.addWidget("consulta");

        model.addColumn(column1);
        model.addColumn(column2);
        model.addColumn(column3);
        model.addColumn(column4);
    }

//****************************************************************************//
//                  Métodos para obtener listas por entidades                 //
//****************************************************************************//
    public List<Citas> todasCitas() {
        return getCitasfacade().findAll();
    }

    public List<Pacientes> todosPaciete() {
        return getPacientefacade().findAll();
    }

//****************************************************************************//
//                 Métodos Get para obtener datos de entidades                //
//****************************************************************************//
    public CitasFacade getCitasfacade() {
        return citasfacade;
    }

    public PacientesFacade getPacientefacade() {
        return pacientefacade;
    }

//****************************************************************************//
//                             Métodos Get y SET                              //
//****************************************************************************//    
    public DashboardModel getModel() {
        return model;
    }

    public LineChartModel getLineModel1() {
        return lineModel1;
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

//****************************************************************************//
//                       Métodos Para Graficos                                //
//****************************************************************************//    
    public void createLineModels() {
        lineModel1 = sucursalEstadistica();
        lineModel1.setTitle("Total de paciente atendidos por Mes");
        lineModel1.setLegendPosition("e");
        lineModel1.setShowPointLabels(true);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Mes"));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Paciente");
        yAxis.setMin(0);
    }

    public LineChartModel createLineModels2() {
        lineModel1 = sucursalEstadistica();
        lineModel1.setTitle("Total de paciente atendidos por mes");
        lineModel1.setLegendPosition("e");
        lineModel1.setShowPointLabels(true);
        lineModel1.getAxes().put(AxisType.X, new CategoryAxis("Mes"));
        Axis yAxis = lineModel1.getAxis(AxisType.Y);
        yAxis.setLabel("Paciente");
        yAxis.setMin(0);
        return lineModel1;
    }

    private LineChartModel initLinearModel() {
        LineChartModel model1 = new LineChartModel();

        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Clinica 1");
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        model1.addSeries(series1);
        return model1;
    }

    private LineChartModel sucursalEstadistica() {
        LineChartModel model2 = new LineChartModel();

        int contador[] = consultasAtendidasPorSucursal();
        ChartSeries sucursal1 = new ChartSeries();
        sucursal1.setLabel("Sucursal 1");
        for (int i = 0; i < contador.length; i++) {
            switch (i) {
                case 0:
                    sucursal1.set("Enero", contador[i]);
                    break;
                case 1:
                    sucursal1.set("Febrero", contador[i]);
                    break;
                case 2:
                    sucursal1.set("Marzo", contador[i]);
                    break;
                case 3:
                    sucursal1.set("Abril", contador[i]);
                    break;
                case 4:
                    sucursal1.set("Mayo", contador[i]);
                    break;
                case 5:
                    sucursal1.set("Junio", contador[i]);
                    break;
                case 6:
                    sucursal1.set("Julio", contador[i]);
                    break;
                case 7:
                    sucursal1.set("Agosto", contador[i]);
                    break;
                case 8:
                    sucursal1.set("Septiember", contador[i]);
                    break;
                case 9:
                    sucursal1.set("Octubre", contador[i]);
                    break;
                case 10:
                    sucursal1.set("Noviembre", contador[i]);
                    break;
                case 11:
                    sucursal1.set("Diciembre", contador[i]);
                    break;
            }
        }

        model2.addSeries(sucursal1);

        return model2;
    }

    public PieChartModel createPieModel() {
        pieModel = new PieChartModel();
        pieModel.setData(datosPieModel());
        pieModel.setTitle("Total de pacientes registrados por sexo");
        pieModel.setLegendPosition("w");
        pieModel.setShadow(false);
        return pieModel;
    }

    private Map datosPieModel() {
        Map<String, Number> data = new HashMap<>();
        int mujer = 0;
        int hombre = 0;
        List<Pacientes> paciente = getPacientefacade().findAll();
        if (!paciente.isEmpty()) {
            for (Pacientes next : paciente) {
                if (next.getPacienteSexo()) {
                    hombre++;
                } else {
                    mujer++;
                }
            }
        }
        data.put("Hombres", hombre);
        data.put("Mujeres", mujer);
        return data;
    }

//****************************************************************************//
//                            Metodos Estadisticos                            //
//****************************************************************************//
    public double totalPacientesRegistrado() {
        double totalPaciente = 0;
        List<Pacientes> paciente = getPacientefacade().findAll();
        if (!paciente.isEmpty()) {
            for (Pacientes next : paciente) {
                totalPaciente++;
            }
        }
        return totalPaciente;
    }

    public Double totalConsultasRealizadas() {
        double totalConsultas = 0;
        List<Citas> cita = getCitasfacade().citasAtendidasEstado(1);
        if (!cita.isEmpty()) {
            for (Citas next : cita) {
                totalConsultas++;
            }
        }
        return totalConsultas;
    }

    public double totalConsultasRealizadasRango() throws ParseException {
        double consultasMes = 0;
        Date fin = new Date();
        Date inicio = sumarRestarMes(fin, -1);
        List<Citas> citasMes = getCitasfacade().citasRangoFecha(inicio, fin);
        for (Citas next : citasMes) {
            consultasMes++;
        }

        return consultasMes;
    }

    public double pacientesRegistradosMes() {
        double pacientesMes =0;
        Calendar fecha = Calendar.getInstance();
        int mes = fecha.get(Calendar.MONTH);
        int anyo = fecha.get(Calendar.YEAR) ;
        
        Calendar inicio = Calendar.getInstance();
        Calendar fin = Calendar.getInstance();
        inicio.set(anyo, mes, 1,0,0,0);
        fin.set(anyo, mes + 1, 1,23,59,60);
        System.out.println("controllers" + inicio.getTime());
        
        fin.add(Calendar.DAY_OF_MONTH, -1);
        System.out.println("controllers" + fin.getTime());
        List<Pacientes> pacientes = getPacientefacade().pacientesFechaCreacionRango(inicio.getTime(), fecha.getTime());
        
        for (Pacientes next : pacientes) {
            pacientesMes++;
        }
        
        return pacientesMes;
    }
//****************************************************************************//
//                                  Métodos                                   //
//****************************************************************************//

    public void handleReorder(DashboardReorderEvent event) {
        FacesMessage message = new FacesMessage();
        message.setSeverity(FacesMessage.SEVERITY_INFO);
        message.setSummary("Reordered: " + event.getWidgetId());
        message.setDetail("Item index: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());

        addMessage(message);
    }

    public void handleClose(CloseEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Panel Closed", "Closed panel id:'" + event.getComponent().getId() + "'");

        addMessage(message);
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, event.getComponent().getId() + " toggled", "Status:" + event.getVisibility().name());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /*Para una sucursal*/
    public int[] consultasAtendidasPorSucursal() {

        citas = getCitasfacade().citasAtendidasPorSucursal(1, 1);
        // citas = getCitasfacade().findAll();
        Integer month = 13;
        int contador[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Iterator<Citas> iterator = citas.iterator(); iterator.hasNext();) {
            Citas next = iterator.next();
            month = next.getCitaFecha().getMonth();
            String monthString = "";
            switch (month) {
                case 0:
                    contador[0] += 1;
                    monthString = "January";
                    break;
                case 1:
                    contador[1] += 1;
                    monthString = "February";
                    break;
                case 2:
                    contador[2] += 1;
                    monthString = "March";
                    break;
                case 3:
                    contador[3] += 1;
                    monthString = "April";
                    break;
                case 4:
                    contador[4] += 1;
                    monthString = "May";
                    break;
                case 5:
                    contador[5] += 1;
                    monthString = "June";
                    break;
                case 6:
                    contador[6] += 1;
                    monthString = "July";
                    break;
                case 7:
                    contador[7] += 1;
                    monthString = "August";
                    break;
                case 8:
                    contador[8] += 1;
                    monthString = "September";
                    break;
                case 9:
                    contador[9] += 1;
                    monthString = "October";
                    break;
                case 10:
                    contador[10] += 1;
                    monthString = "November";
                    break;
                case 11:
                    contador[11] += 1;
                    monthString = "December";
                    break;
                default:
                    monthString = "Invalid month";
                    break;
            }//Fin Switch 
        }// Fin de iterador Citas

        return contador;
    }

    private Date sumarRestarMes(Date fecha, int mes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.MONTH, mes);

        return calendar.getTime();
    }

}
