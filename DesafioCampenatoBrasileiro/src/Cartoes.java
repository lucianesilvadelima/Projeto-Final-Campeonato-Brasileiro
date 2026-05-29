public class Cartoes {

    private String partida_id;
    private String rodada;
    private String clube;
    private String cartao;
    private String atleta;
    private String num_camisa;
    private String posicao;
    private String minuto;

    public Cartoes(String partida_id, String rodada, String clube, String cartao, String atleta, String num_camisa, String posicao, String minuto) {
        this.partida_id = partida_id;
        this.rodada = rodada;
        this.clube = clube;
        this.cartao = cartao;
        this.atleta = atleta;
        this.num_camisa = num_camisa;
        this.posicao = posicao;
        this.minuto = minuto;
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

    public String getCartao() {
        return cartao;
    }

    public String getAtleta() {
        return atleta;
    }

    public String getNum_camisa() {
        return num_camisa;
    }

    public String getPosicao() {
        return posicao;
    }

    public String getMinuto() {
        return minuto;
    }

    @Override
    public String toString() {
        return "Cartoes{" +
                "partida_id='" + partida_id + '\'' +
                ", rodada='" + rodada + '\'' +
                ", clube='" + clube + '\'' +
                ", cartao='" + cartao + '\'' +
                ", atleta='" + atleta + '\'' +
                ", num_camisa='" + num_camisa + '\'' +
                ", posicao='" + posicao + '\'' +
                ", minuto='" + minuto + '\'' +
                '}';
    }
}