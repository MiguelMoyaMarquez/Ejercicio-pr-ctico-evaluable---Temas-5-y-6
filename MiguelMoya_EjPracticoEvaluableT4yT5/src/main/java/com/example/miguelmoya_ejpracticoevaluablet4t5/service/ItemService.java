package com.example.miguelmoya_ejpracticoevaluablet4t5.service;

import com.example.miguelmoya_ejpracticoevaluablet4t5.model.Item;
import com.example.miguelmoya_ejpracticoevaluablet4t5.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio para gestionar las operaciones relacionadas con los items.
 */
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    /**
     * Constructor del servicio de item.
     *
     * @param itemRepository Repositorio de items.
     */
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /**
     * Obtiene todos los items disponibles en la base de datos.
     *
     * @return Lista de items.
     */
    public List<Item> obtenerTodosLosItems() {
        return itemRepository.findAll();
    }

    /**
     * Busca un item por su ID.
     *
     * @param id ID del item.
     * @return Un Optional con el item si se encuentra, o vacío si no existe.
     */
    public Optional<Item> obtenerItemPorId(Long id) {
        return itemRepository.findById(id);
    }


    /**
     * Guarda un item en la base de datos.
     *
     * @param item Objeto de tipo Item a guardar.
     * @return El item guardado.
     */
    public Item guardarItem(Item item) {
        return itemRepository.save(item);
    }

    /**
     * Elimina un item de la base de datos por su ID.
     *
     * @param id ID del item a eliminar.
     */
    public void eliminarItem(Long id) {
        itemRepository.deleteById(id);
    }

    public List<Item> obtenerItemsPorCategoria(String categoria) {
        return itemRepository.findByCategorias(categoria);
    }
}
