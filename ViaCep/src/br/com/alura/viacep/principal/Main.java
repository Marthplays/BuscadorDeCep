package br.com.alura.viacep.principal;

import java.util.Scanner;
import java.io.IOException;

import br.com.alura.viacep.modelo.BuscaCep;
import br.com.alura.viacep.modelo.CepViaCep;
import br.com.alura.viacep.modelo.GeradorDeArquivo;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner in = new Scanner(System.in);
        String busca = "";
        BuscaCep consultaCep = new BuscaCep();

        while (!busca.equalsIgnoreCase("sim")) {
            System.out.println("Qual CEP deseja procurar? Digite sim caso queira encerrar o programa.");
            busca = in.nextLine();

            if (busca.equalsIgnoreCase("sim")) {
                break;
            }

            try {
                CepViaCep novoEndereco = consultaCep.buscaEndereco(busca);
                System.out.println(novoEndereco);
                GeradorDeArquivo gerador = new GeradorDeArquivo();
                gerador.salvaJson(novoEndereco);
            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
