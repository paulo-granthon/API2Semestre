package Classes;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/// Representação de um apontamento de Hora-Extra ou Sobreaviso dentro do sistema java.
/// Instanciado utilizando os dados de um apontamento na tabela .sql como atributos.
/// Utilizado para facilitar a conversação entre os sistemas dentro do código. 
public class Appointment {
    // private int id;                 // Identificação unica do apontamento.
    private int requester = 1;       // Nome do solicitante do apontamnto (colaborador / gestor que lançou). TODO: mudar para referencia do tipo 'User'.
    private AppointmentType type = AppointmentType.OnNotice;   // Tipo de apontamento: Hora-Extra / Sobreaviso.
    private String startDate = "10/04/2023";       // Data de início do apontamento.
    private String endDate = "14/04/2023";           // Data de término do apontamento.
    private String squad = "Khali";           // Nome da squad pela qual o solicitante está prestando serviço nesse apontamento. TODO: mudar para referencia do tipo 'Squad'.
    private String client = "Jhonatta";          // Nome do cliente para qual o solicitante está prestando serviço nesse apontamento. TODO: remover cliente do apontamento pois futuramente consegue ser acessado dentro de "project".
    private String project = "API";         // Nome do projeto para qual o solicitante está prestando serviço.
    private String justification = "Porque eu quero";   // Justificativa fornecida pelo solicitante para prestar esta Hora-Extra ou Sobreaviso.


    // /// Cria uma nova instancia de apontamento
    // public Appointment(
    //     // int id,
    //     AppointmentType type,
    //     int requester,
    //     String startDate,
    //     String endDate,
    //     String squad,
    //     String client,
    //     String project,
    //     String justification
    // ) {
    //     // this.id = id;
    //     this.requester = requester;
    //     this.type = type;
    //     this.startDate = startDate;
    //     this.endDate = endDate;
    //     this.squad = squad;
    //     this.client = client;
    //     this.project = project;
    //     this.justification = justification;
    // }

    /// Métodos de acesso "GET" das variaveis do apontamento.
    // public int getId() { return id; }
    public AppointmentType getType() { return type; }
    public int getRequester() { return requester; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getSquad() { return squad; }
    public String getClient() { return client; }
    public String getProject() { return project; }
    public String getJustification() { return justification; }

    /// Métodos de acesso "SET" das variaveis do apontamento para modificar os valores
    // public void setId (int newId) { id = newId; }
    // public void setType (AppointmentType newType) { type = newType; }
    // public void setRequester (String newRequester) { requester = newRequester; }
    // public void setStartDate (Date newStartDate) { startDate = newStartDate; }
    // public void setEndDate (Date newEndDate) { endDate = newEndDate; }
    // public void setSquad (String newSquad) { squad = newSquad; }
    // public void setClient (String newClient) { client = newClient; }
    // public void setProject (String newProject) { project = newProject; }
    // public void setJustification (String newJustification) { justification = newJustification; }

}