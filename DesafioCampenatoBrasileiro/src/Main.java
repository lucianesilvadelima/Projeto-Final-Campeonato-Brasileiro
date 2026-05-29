import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        // Importando os dados
        System.out.println();
        System.out.println("================================");
        System.out.println("Importando os dados");
        System.out.println("================================");
        System.out.println();

        // Gols do brasileirao
        String urlGols = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/refs/heads/master/campeonato-brasileiro-gols.csv";
        List<Gols> gols = lerCSV(
                urlGols,
                dados -> new Gols(
                        dados[0],
                        dados[1],
                        dados[2],
                        dados[3],
                        dados[4],
                        dados[5]
                )
        );
        System.out.println("Planilha Gols: " + gols.size() + " registros.");
        gols.stream().limit(1).forEach(System.out::println);
        System.out.println();

        // Informacoes do brasileirao (full)
        String urlFull = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/refs/heads/master/campeonato-brasileiro-full.csv";
        List<Full> full = lerCSV(
                urlFull,
                dados -> new Full(
                        dados[0],
                        dados[1],
                        dados[2],
                        dados[3],
                        dados[4],
                        dados[5],
                        dados[6],
                        dados[7],
                        dados[8],
                        dados[9],
                        dados[10],
                        dados[11],
                        dados[12],
                        dados[13],
                        dados[14],
                        dados[15]
                )
        );
        System.out.println("Planilha Full: " + full.size() + " registros.");
        full.stream().limit(1).forEach(System.out::println);
        System.out.println();

        // Cartoes no brasileirao
        String urlCartoes = "https://raw.githubusercontent.com/vconceicao/ada_brasileirao_dataset/refs/heads/master/campeonato-brasileiro-cartoes.csv";
        List<Cartoes> cartoes = lerCSV(
                urlCartoes,
                dados -> new Cartoes(
                        dados[0],
                        dados[1],
                        dados[2],
                        dados[3],
                        dados[4],
                        dados[5],
                        dados[6],
                        dados[7]
                )
        );
        System.out.println("Planilha Cartoes: " + cartoes.size() + " registros.");
        cartoes.stream().limit(1).forEach(System.out::println);
        System.out.println();

        System.out.println();
        System.out.println("================================");
        System.out.println("Atividades Projeto Final");
        System.out.println("================================");
        System.out.println();


        // 1) O time que mais venceu jogos no ano 2008
        DateTimeFormatter dataFormatada =
                DateTimeFormatter.ofPattern("d/M/yyyy");

        List<String> times = full.stream()
                .filter(f -> {
                    LocalDate data =
                            LocalDate.parse(f.getData(), dataFormatada);

                    return data.getYear() == 2008;
                })
                .filter(f -> !f.getVencedor().equals("-"))
                .map(Full::getVencedor)
                .distinct()
                .sorted()
                .toList();

        String timeMaisVitorioso = "";
        long qtdVitoriasTimeMaisVitorioso = 0;

        for (String time : times) {

            long qtdVitorias = full.stream()
                    .filter(f -> {
                        LocalDate data =
                                LocalDate.parse(f.getData(), dataFormatada);

                        return data.getYear() == 2008;
                    })
                    .filter(f -> f.getVencedor().equals(time))
                    .count();

            if (qtdVitorias > qtdVitoriasTimeMaisVitorioso) {
                qtdVitoriasTimeMaisVitorioso = qtdVitorias;
                timeMaisVitorioso = time;
            }
        }

        System.out.println(
                "Time com mais vitórias em 2008: "
                        + timeMaisVitorioso
                        + " - "
                        + qtdVitoriasTimeMaisVitorioso
                        + " vitórias"
        );


        // 2) O jogador que mais fez gols
        List<String> jogadores = gols.stream()
                .map(Gols::getAtleta)
                .distinct()
                .sorted()
                .toList();

        String jogadorComMaisGols = "";
        long qtdGolsJogadorComMaisGols = 0;

        for (String jogador : jogadores) {

            long qtdGols = gols.stream()
                    .filter(g -> g.getAtleta().equals(jogador))
                    .count();

            if (qtdGols > qtdGolsJogadorComMaisGols) {
                qtdGolsJogadorComMaisGols = qtdGols;
                jogadorComMaisGols = jogador;
            }
        }

        System.out.println(
                "Jogador com mais gols: "
                        + jogadorComMaisGols
                        + " - "
                        + qtdGolsJogadorComMaisGols
                        + " gols"
        );


        // 3) O jogador que mais fez gols de pênaltis
        String jogadorComMaisGolsPenalty = "";
        long qtdGolsJogadorComMaisGolsPenalty = 0;

        for (String jogador : jogadores) {
            long qtdGols = gols.stream()
                    .filter(g -> g.getAtleta().equals(jogador))
                    .filter(g -> g.getTipo_de_gol().equals("Penalty"))
                    .count();

            if (qtdGols > qtdGolsJogadorComMaisGolsPenalty) {
                qtdGolsJogadorComMaisGolsPenalty = qtdGols;
                jogadorComMaisGolsPenalty = jogador;
            }
        }
        System.out.println(
                "Jogador com mais gols de pênalti: "
                        + jogadorComMaisGolsPenalty
                        + " - "
                        + qtdGolsJogadorComMaisGolsPenalty
                        + " gols de pênalti"
        );


        // 4) O jogador que mais fez gols contras
        String jogadorComMaisGolsContra = "";
        long qtdGolsJogadorComMaisGolsContra = 0;

        for (String jogador : jogadores) {
            long qtdGols = gols.stream()
                    .filter(g -> g.getAtleta().equals(jogador))
                    .filter(g -> g.getTipo_de_gol().equals("Gol Contra"))
                    .count();

            if (qtdGols > qtdGolsJogadorComMaisGolsContra) {
                qtdGolsJogadorComMaisGolsContra = qtdGols;
                jogadorComMaisGolsContra = jogador;
            }
        }
        System.out.println(
                "Jogador com mais gols contra: "
                        + jogadorComMaisGolsContra
                        + " - "
                        + qtdGolsJogadorComMaisGolsContra
                        + " gols contra"
        );


        // 5) O jogador que mais recebeu cartões amarelos
        List<String> jogadoresCartoes = cartoes.stream()
                .map(Cartoes::getAtleta)
                .distinct()
                .sorted()
                .toList();

        String jogadorComMaisCartoesAmarelos = "";
        long qtdCartoesJogadorComMaisCartoesAmarelos = 0;

        for (String jogador : jogadoresCartoes) {
            long qtdCartoesAmarelos = cartoes.stream()
                    .filter(c -> c.getAtleta().equals(jogador))
                    .filter(c -> c.getCartao().equals("Amarelo"))
                    .count();

            if (qtdCartoesAmarelos > qtdCartoesJogadorComMaisCartoesAmarelos) {
                qtdCartoesJogadorComMaisCartoesAmarelos = qtdCartoesAmarelos;
                jogadorComMaisCartoesAmarelos = jogador;
            }
        }
        System.out.println(
                "Jogador com mais cartões amarelos: "
                        + jogadorComMaisCartoesAmarelos
                        + " - "
                        + qtdCartoesJogadorComMaisCartoesAmarelos
                        + " cartões amarelos"
        );
    }


    // Leitura de CSV genérica
    public static <T> List<T> lerCSV(
            String linkCSV,
            Function<String[], T> conversor
    ) {

        List<T> lista = new ArrayList<>();

        try {

            URL url = new URL(linkCSV);

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(url.openStream(), StandardCharsets.UTF_8)
            );

            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {

                String[] dados = linha.split(",");

                for (int i = 0; i < dados.length; i++) {
                    dados[i] = dados[i].replace("\"", "");
                }

                T objeto = conversor.apply(dados);

                lista.add(objeto);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler CSV: " + e.getMessage());
        }

        return lista;
    }
}