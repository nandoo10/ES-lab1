import java.util.List;

@FunctionalInterface
public interface StudentOperation<R> {
    R process(List<Student> students);
}

//Define a regra genérica para realizar cálculos ou ações sobre a lista de estudantes. Permite adicionar facilmente novas funcionalidades no futuro (como calcular a média global ou filtrar notas).