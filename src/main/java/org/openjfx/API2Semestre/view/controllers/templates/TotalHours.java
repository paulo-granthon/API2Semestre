package org.openjfx.api2semestre.view.controllers.templates;

import org.openjfx.api2semestre.App;
import org.openjfx.api2semestre.appointment.Appointment;
import org.openjfx.api2semestre.report.IntervalFee;
import org.openjfx.api2semestre.report.ReportInterval;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class TotalHours {

    @FXML
    private Label lblNumeroApontamentos;

    @FXML
    private Label lblTotalHoras;

    @FXML
    private Label lblTotalHorasVerba;

    public void setTotalHours(ReportInterval[] listReportInterval) {
        long totalMinutes = 0;
        for (ReportInterval reportInterval : listReportInterval) {
            totalMinutes += reportInterval.getTotal();
        }
        lblTotalHoras.setText(String.valueOf(
            new StringBuilder(String.valueOf((int)totalMinutes / 60)).append(":").append(String.valueOf((int)totalMinutes % 60)).toString()
        ));
    }

    public void setTotalHoursRemunereted(ReportInterval[] listReportInterval) {
        // System.out.println("TotalHours.setTotalHoursRemunereted");
        double totalMinutes = 0;
        IntervalFee[] verbas = IntervalFee.getVerbasFull();
        for (ReportInterval reportInterval : listReportInterval) {
            // System.out.println("ri | verba: " + reportInterval.getVerba() + " | " + verbas.length + " | " +listReportInterval.length);
            for (IntervalFee verba : verbas) {
                if (reportInterval.getVerba() == verba.getCode()) {
                    // System.out.println("IF | ri.getVerba " + reportInterval.getVerba() + " | verba.getCode " + verba.getCode());
                    totalMinutes += reportInterval.getTotal() * verba.getHourDuration();
                    // System.out.println("totalMunutes += " + reportInterval.getTotal() + " * " + verba.getHourDuration() + " | " + (reportInterval.getTotal() * verba.getHourDuration()));
                    break;
                }
            }
        }
        // System.out.println("TotalHours.setTotalHoursRemunereted -- totalMinutes" + totalMinutes);
        lblTotalHorasVerba.setText(String.valueOf(
            new StringBuilder(String.valueOf((int)totalMinutes / 60)).append(":").append(String.valueOf((int)totalMinutes % 60)).toString()
        ));
    }

    public void setNumTotalAppointments(Appointment[] listApontamentos) {
        lblNumeroApontamentos.setText(((Integer)(listApontamentos.length)).toString());
    }

    public static Parent totalHoursParent(Appointment[] listAppointments, ReportInterval[] listReportInterval) {
        // System.out.println("TotalHours.totalHoursParent");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.getFXML("templates/totalHours"));
            Parent totalHoursParent = fxmlLoader.load();
            TotalHours controller = fxmlLoader.getController();
            controller.setNumTotalAppointments(listAppointments);
            controller.setTotalHours(listReportInterval);
            controller.setTotalHoursRemunereted(listReportInterval);
            return totalHoursParent;
        } catch (Exception e) {
            // System.out.println("Erro - totalHoursParent() | erro ao gerar tela");
            e.printStackTrace();
        }
        return null;
    }
}
