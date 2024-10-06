package br.unitins.topicos1.service.hash;

public interface HashService {
   
    String getHashSenha(String senha);
    boolean verificandoHash(String senha, String hash);
}
