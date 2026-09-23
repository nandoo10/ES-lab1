import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//Implementa a interface StudentReader. É quem abre o ficheiro .csv, processa o texto linha a linha e o converte em objetos Student.

public class StandardCsvStudentReader implements StudentReader {
    private final String delimiter;
    private final boolean hasHeader;

    public StandardCsvStudentReader(String delimiter, boolean hasHeader) {
        this.delimiter = delimiter;
        this.hasHeader = hasHeader;
    }

    public StandardCsvStudentReader() {
        this(",", true);
    }

    @Override
    public List<Student> read(String filePath) throws IOException {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (isFirstLine && hasHeader) {
                    isFirstLine = false;
                    continue;
                }

                String[] tokens = line.split(delimiter);
                if (tokens.length >= 3) {
                    int numMec = Integer.parseInt(tokens[0].trim());
                    String fullName = tokens[1].trim();
                    double average = Double.parseDouble(tokens[2].trim());

                    students.add(new Student(numMec, fullName, average));
                }
            }
        }
        return students;
    }
}