import java.io.IOException;
import java.util.List;

public class StudentProcessor {
    private final StudentReader reader;

    public StudentProcessor(StudentReader reader) {
        this.reader = reader;
    }

    public <R> R executeOperation(String filePath, StudentOperation<R> operation) throws IOException {
        List<Student> students = reader.read(filePath);
        return operation.process(students);
    }
}

//Liga o leitor (StudentReader) à operação pretendida (StudentOperation), executando o fluxo de forma desacoplada.