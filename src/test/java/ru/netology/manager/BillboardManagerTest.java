package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.BillboardItem;
import ru.netology.repository.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BillboardManagerTest {
    @Mock
    private BillboardRepository repository;

    private BillboardRepository repository2;

    @InjectMocks
    private BillboardManager manager;

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

    @Test
    public void shouldRemoveIfExists(){
        int idToRemove = 3;

        BillboardItem[] returned = new BillboardItem[]{film12, film11, film10, film9, film8, film7, film6, film5, film4, film2};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).removeById(idToRemove);

        manager.removeById(idToRemove);
        BillboardItem[] expected = new BillboardItem[]{film12, film11, film10, film9, film8, film7, film6, film5, film4, film2};
        BillboardItem[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
        verify(repository).removeById(idToRemove);
    }

    @Test
    public void shouldSave(){
        BillboardItem[] returned = new BillboardItem[]{film13, film12, film11, film10, film9, film8, film7, film6, film5, film4};
        doReturn(returned).when(repository).findAll();
        doNothing().when(repository).save(film13);

        manager.save(film13);
        BillboardItem[] expected = new BillboardItem[]{film13, film12, film11, film10, film9, film8, film7, film6, film5, film4};
        BillboardItem[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
        verify(repository).save(film13);
    }
}