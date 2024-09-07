package br.com.alura.viacep.modelo;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {
    public CepViaCep buscaEndereco(String busca) {
        URI endereco = URI.create("https://viacep.com.br/ws/" + busca + "/json/");

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), CepViaCep.class);
        } catch (Exception e) {
            throw new RuntimeException("Não foi possível obter o endereço a partir desse CEP.");
        }

    }

}
