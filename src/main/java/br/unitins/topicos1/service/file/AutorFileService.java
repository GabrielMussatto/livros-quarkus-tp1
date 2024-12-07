package br.unitins.topicos1.service.file;

import java.io.File;
import java.io.IOException;

public interface AutorFileService {

    void salvar(Long id, String nomeImagem, byte[] imagem) throws IOException;
    File download(String nomeArquivo);
    
}
