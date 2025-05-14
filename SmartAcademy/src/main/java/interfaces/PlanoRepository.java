package interfaces;

import com.example.SmartAcademy.models.PlanoModels;
import java.util.List;

public interface PlanoRepository {
    PlanoModels buscarPorCodigo(int id);
    List<PlanoModels> buscar();
    void adicionar(PlanoModels plano);
    void remover(int id);
    void atualizar(PlanoModels plano);
}
