package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.netology.domain.BillboardItem;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

class BillboardManagerTest {
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

    /*@BeforeEach
    public void setUp() {
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        manager.save(film6);
        manager.save(film7);
        manager.save(film8);
        manager.save(film9);
        manager.save(film10);
        manager.save(film11);
        manager.save(film12);
    }

    private void addTestFilms(){
        manager.save(film1);
        manager.save(film2);
        manager.save(film3);
        manager.save(film4);
        manager.save(film5);
        manager.save(film6);
        manager.save(film7);
        manager.save(film8);
        manager.save(film9);
        manager.save(film10);
        manager.save(film11);
        manager.save(film12);
    }*/

    /*@Test
    public void shouldAddLessLen(){
        BillboardManager manager = new BillboardManager(5);
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        BillboardItem film13 = new BillboardItem(13, "film13", "genre2");
        manager.save(film13);
        BillboardItem[] expected = new BillboardItem[]{film13, film12, film11, film10, film9};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }*/

    @Test
    public void shouldOutLessLen(){
        BillboardManager manager = new BillboardManager(18);
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        BillboardItem[] expected = new BillboardItem[]{film12, film11, film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutExactLen(){
        BillboardManager manager = new BillboardManager(12);
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        BillboardItem[] expected = new BillboardItem[]{film12, film11, film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutBiggerLen(){
        BillboardManager manager = new BillboardManager(5);
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        BillboardItem[] expected = new BillboardItem[]{film12, film11, film10, film9, film8};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutLessLenDefault(){
        BillboardManager manager = new BillboardManager();
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8});
        BillboardItem[] expected = new BillboardItem[]{film8, film7, film6, film5, film4, film3, film2, film1};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutExactLenDefault(){
        BillboardManager manager = new BillboardManager();
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10});
        BillboardItem[] expected = new BillboardItem[]{film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutBiggerLenDefault(){
        BillboardManager manager = new BillboardManager();
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        BillboardItem[] expected = new BillboardItem[]{film12, film11, film10, film9, film8, film7, film6, film5, film4, film3};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveLessLen(){
        BillboardManager manager = new BillboardManager(18);
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        manager.save(film13);
        BillboardItem[] expected = new BillboardItem[]{film13, film12, film11, film10, film9, film8, film7, film6, film5, film4, film3, film2, film1};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveExactLen(){
        BillboardManager manager = new BillboardManager(12);
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        manager.save(film13);
        BillboardItem[] expected = new BillboardItem[]{film13, film12, film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveBiggerLen(){
        BillboardManager manager = new BillboardManager(5);
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        manager.save(film13);
        BillboardItem[] expected = new BillboardItem[]{film13, film12, film11, film10, film9};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveLessLenDefault(){
        BillboardManager manager = new BillboardManager();
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8});
        manager.save(film9);
        BillboardItem[] expected = new BillboardItem[]{film9, film8, film7, film6, film5, film4, film3, film2, film1};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveExactLenDefault(){
        BillboardManager manager = new BillboardManager();
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10});
        manager.save(film11);
        BillboardItem[] expected = new BillboardItem[]{film11, film10, film9, film8, film7, film6, film5, film4, film3, film2};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSaveBiggerLenDefault(){
        BillboardManager manager = new BillboardManager();
        manager.setItems(new BillboardItem[]{film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12});
        manager.save(film13);
        BillboardItem[] expected = new BillboardItem[]{film13, film12, film11, film10, film9, film8, film7, film6, film5, film4};
        BillboardItem[] actual = manager.getFilms();
        assertArrayEquals(expected, actual);
    }
}