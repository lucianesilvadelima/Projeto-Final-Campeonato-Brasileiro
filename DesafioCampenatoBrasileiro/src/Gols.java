public class Gols {

    private String partida_id;
    private String rodada;
    private String clube;
    private String atleta;
    private String minuto;
    private String tipo_de_gol;

    public Gols(String partida_id, String rodada, String clube,  String atleta, String minuto, String tipo_de_gol) {
        this.partida_id = partida_id;
        this.rodada = rodada;
        this.clube = clube;
        this.atleta = atleta;
        this.minuto = minuto;
        this.tipo_de_gol = tipo_de_gol;
    }

    public String getPartida_id() {
        return partida_id;
    }

    public String getRodada() {
        return rodada;
    }

    public String getClube() {
        return clube;
    }

    public String getAtleta() {
        return atleta;
    }

    public String getMinuto() {
        return minuto;
    }

    public String getTipo_de_gol() {
        return tipo_de_gol;
    }

    @Override
    public String toString() {
        return "Gols{" +
                "partida_id='" + partida_id + '\'' +
                ", rodada='" + rodada + '\'' +
                ", clube='" + clube + '\'' +
                ", atleta='" + atleta + '\'' +
                ", minuto='" + minuto + '\'' +
                ", tipo_de_gol='" + tipo_de_gol + '\'' +
                '}';
    }
}