package org.openjfx.api2semestre.database.query;

public enum TableProperty {

    // universal property - All tables have this!
    Id("id"),

    // Appointments table
    Requester("requester"),
    Type("tipo"),
    StartDate("hora_inicio"),
    EndDate("hora_fim"),
    Squad("cr_id"),
    Client("cliente"),
    Project("projeto"),
    Justification("justificativa"),
    Status("aprovacao"),
    Feedback("feedback"),
    
    // User table
    Name("nome"),
    Email("email"),
    Password("senha"),
    Profile("perfil"),
    Registration("matricula"),

    // TODO: Clients table
    Sigla("sigla"),
    Codigo("codigo"),
    
    // TODO: IntervalFees table
    
    ;

    public static final TableProperty[] APPOINTMENT_PROPERTIES = new TableProperty[] {
        Id, Requester, Type, StartDate, EndDate, Squad, Client, Project, Justification, Status, Feedback
    };


    // TableProperty variable and constructor
    private String stringValue;
    private TableProperty (String stringValue) { this.stringValue = stringValue; }

    // Getter: raw string value
    public String getStringValue() { return stringValue; }

    // Getter: string value formatted for "SELECT where _ = ?"
    public String getStringValueWhere() { return stringValue + " = ?"; }

}
