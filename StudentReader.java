import java.io.IOException;
import java.util.List;

public interface StudentReader {
    List<Student> read(String filePath) throws IOException;
}

//Define a regra genérica para a leitura de dados. Permite a extensibilidade pedida no enunciado: se no futuro for preciso ler dados de um ficheiro JSON ou XML, basta criar um novo leitor baseado nesta interface.