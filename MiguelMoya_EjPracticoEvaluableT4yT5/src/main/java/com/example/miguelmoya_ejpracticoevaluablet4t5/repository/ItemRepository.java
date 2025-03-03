package com.example.miguelmoya_ejpracticoevaluablet4t5.repository;

import com.example.miguelmoya_ejpracticoevaluablet4t5.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    /**
     * Busca y devuelve una lista de items según la categoria espeficiada.
     *
     * @param categoria Categoria de los Items a buscar.
     * @return Lista de items con la categoria indicada.
     */
    List<Item> findByCategorias(String categoria);

}
