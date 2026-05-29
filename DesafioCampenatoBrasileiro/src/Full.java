public class Full {

    private String ID;
    private String rodada;
    private String data;
    private String hora;
    private String mandatante;
    private String visitante;
    private String formacao_mandante;
    private String formacao_visitante;
    private String tecnico_mandante;
    private String tecnico_visitante;
    private String vencedor;
    private String arena;
    private String mandante_placar;
    private String visitante_placar;
    private String mandante_Estado;
    private String visitante_Estado;

    public Full(String ID, String rodada, String data, String hora, String mandatante, String visitante, String formacao_mandante, String formacao_visitante, String tecnico_mandante, String tecnico_visitante, String vencedor, String arena, String mandante_placar, String visitante_placar, String mandante_Estado, String visitante_Estado) {
        this.ID = ID;
        this.rodada = rodada;
        this.data = data;
        this.hora = hora;
        this.mandatante = mandatante;
        this.visitante = visitante;
        this.formacao_mandante = formacao_mandante;
        this.formacao_visitante = formacao_visitante;
        this.tecnico_mandante = tecnico_mandante;
        this.tecnico_visitante = tecnico_visitante;
        this.vencedor = vencedor;
        this.arena = arena;
        this.mandante_placar = mandante_placar;
        this.visitante_placar = visitante_placar;
        this.mandante_Estado = mandante_Estado;
        this.visitante_Estado = visitante_Estado;
    }

    public String getID() {
        return ID;
    }

    public String getRodada() {
        return rodada;
    }
    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getMandatante() {
        return mandatante;
    }

    public String getVisitante() {
        return visitante;
    }

    public String getFormacao_mandante() {
        return formacao_mandante;
    }

    public String getFormacao_visitante() {
        return formacao_visitante;
    }

    public String getTecnico_mandante() {
        return tecnico_mandante;
    }

    public String getTecnico_visitante() {
        return tecnico_visitante;
    }

    public String getVencedor() {
        return vencedor;
    }

    public String getArena() {
        return arena;
    }

    public String getMandante_placar() {
        return mandante_placar;
    }

    public String getVisitante_placar() {
        return visitante_placar;
    }

    public String getMandante_Estado() {
        return mandante_Estado;
    }

    public String getVisitante_Estado() {
        return visitante_Estado;
    }

    public String toString(){
        return "Full{" +
                "ID='" + ID + '\'' +
                ", rodada='" + rodada + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", mandatante='" + mandatante + '\'' +
                ", visitante='" + visitante + '\'' +
                ", formacao_mandante='" + formacao_mandante + '\'' +
                ", formacao_visitante='" + formacao_visitante + '\'' +
                ", tecnico_mandante='" + tecnico_mandante + '\'' +
                ", tecnico_visitante='" + tecnico_visitante + '\'' +
                ", vencedor='" + vencedor + '\'' +
                ", arena='" + arena + '\'' +
                ", mandante_placar='" + mandante_placar + '\'' +
                ", visitante_placar='" + visitante_placar + '\'' +
                ", mandante_Estado='" + mandante_Estado + '\'' +
                ", visitante_Estado='" + visitante_Estado + '\'' +
                '}';
    }
}