package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ru.netology.domain.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BillboardRepositoryTest {
    BillboardRepository repository = new BillboardRepository();

    private BillboardItem film1 = new BillboardItem(1, "film1", "genre1");
    private BillboardItem film2 = new BillboardItem(2, "film2", "genre3");
    private BillboardItem film3 = new BillboardItem(3, "film3", "genre2");
    private BillboardItem film4 = new BillboardItem(4, "film4", "genre1");
    private BillboardItem film5 = new BillboardItem(5, "film5", "genre1");
    private BillboardItem film6 = new BillboardItem(6, "film6", "genre2");
    private BillboardItem film7 = new BillboardItem(7, "film7", "genre3");
    private BillboardItem film8 = new BillboardItem(8, "film8", "genre3");
    private BillboardItem film9 = new BillboardItem(9, "film9", "genre4");
    private BillboardItem film10 = new BillboardItem(10, "film10", "genre1");
    private BillboardItem film11 = new BillboardItem(11, "film11", "genre2");
    private BillboardItem film12 = new BillboardItem(12, "film12", "genre2");
    private BillboardItem film13 = new BillboardItem(13, "film13", "genre1");

    @BeforeEach
    public void setUp() {
        repository.save(film1);
        repository.save(film2);
        repository.save(film3);
        repository.save(film4);
        repository.save(film5);
        repository.save(film6);
        repository.save(film7);
        repository.save(film8);
        repository.save(film9);
        repository.save(film10);
        repository.save(film11);
        repository.save(film12);
    }

    @Test
    void save() {
        repository.save(film13);

        BillboardItem[] expected = new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12, film13};
        BillboardItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAll() {
        BillboardItem[] expected = new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12};
        BillboardItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        BillboardItem[] expected = new BillboardItem[]{};
        repository.removeAll();
        BillboardItem[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        BillboardItem[] expected = new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film10, film11, film12};
        BillboardItem[] actual;

        repository.removeById(9);

        actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        BillboardItem expected = film10;
        BillboardItem actual;

        actual = repository.findById(9);

        assertEquals(expected, actual);
    }
}