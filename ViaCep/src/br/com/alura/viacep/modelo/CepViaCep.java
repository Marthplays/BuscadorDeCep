package br.com.alura.viacep.modelo;

public record CepViaCep(String bairro, String logradouro, String cep, String complemento, String unidade, String localidade, String uf,
                        String estado, String regiao, String ddd) {
}
