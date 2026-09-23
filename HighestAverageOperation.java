import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class HighestAverageOperation implements StudentOperation<Optional<Student>> {
    @Override
    public Optional<Student> process(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(Student::average));
    }
}

//Implementa a interface StudentOperation com a lógica específica para encontrar o aluno com a maior média.