package edu.kiligoy.lab5.item;

/*
@author   Dtest
@project   lab5
@class  ItemService
@version  1.0.0
@since 08.04.2025 - 13.12
*/

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    private List<Item> items;

    @PostConstruct
    void init() {
        items.add(new Item("1", "Іван Петров", "Пацієнт із гіпертонією"));
        items.add(new Item("2", "Марія Коваленко", "Операція на серці у 2022"));
        items.add(new Item("3", "Сергій Мельник", "Діабет 2 типу"));
        items.add(new Item("4", "Анна Шевченко", "Алергія на антибіотики"));
        items.add(new Item("5", "Василь Бондар", "Хронічний бронхіт"));
        items.add(new Item("6", "Ольга Сидоренко", "Вагітність, 2-й триместр"));
        repository.saveAll(items);
    }

    public List<Item> getAll() {
        return repository.findAll();
    }


    public Item getById(String id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public Item create(Item item) {
        return repository.save(item);
    }

    public Item update(Item item) {
        return repository.save(item);
    }
}
