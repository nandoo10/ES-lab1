import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentProcessor {
    private static final Logger LOGGER = Logger.getLogger(StudentProcessor.class.getName());
    private final StudentReader reader;

    public StudentProcessor(StudentReader reader) {
        this.reader = reader;
    }

    public <R> R executeOperation(String filePath, StudentOperation<R> operation) throws IOException {
        LOGGER.info("A iniciar a leitura do ficheiro: " + filePath);
        
        try {
            List<Student> students = reader.read(filePath);
            LOGGER.info("Ficheiro lido com sucesso. Total de registos: " + students.size());
            
            LOGGER.info("A executar a operação nos dados...");
            R result = operation.process(students);
            LOGGER.info("Operação concluída com sucesso.");
            return result;
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Erro ao processar o ficheiro: " + filePath, e);
            throw e;
        }
    }
}

//Liga o leitor (StudentReader) à operação pretendida (StudentOperation), executando o fluxo de forma desacoplada.