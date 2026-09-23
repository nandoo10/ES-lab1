import java.io.IOException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String csvPath = "data/students.csv";

        // Instancia o leitor padrão (virgula como separador, com cabeçalho)
        StudentReader reader = new StandardCsvStudentReader(",", true);
        StudentProcessor processor = new StudentProcessor(reader);

        try {
            // Executa a operação para obter o aluno com maior média
            Optional<Student> topStudent = processor.executeOperation(csvPath, new HighestAverageOperation());

            topStudent.ifPresentOrElse(
                student -> System.out.printf("Aluno com maior média: %s (Nº Mec: %d) - Média: %.2f%n",
                        student.fullName(), student.numMec(), student.average()),
                () -> System.out.println("Nenhum registo encontrado no ficheiro.")
            );

        } catch (IOException e) {
            System.err.println("Erro ao abrir/ler o ficheiro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Erro no formato numérico dos dados do CSV: " + e.getMessage());
        }
    }
}


//Onde a aplicação arranca. Junta todas as peças, passa o caminho do ficheiro CSV e imprime o resultado na consola.