package ru.netology.repository;

import ru.netology.domain.*;

public class BillboardRepository {
    private BillboardItem[] items = new BillboardItem[0];

    public void save(BillboardItem item) {
        int length = items.length + 1;
        BillboardItem[] tmp = new BillboardItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public BillboardItem[] findAll() {
        return items;
    }

    public void removeAll() {
        int id;
        for (BillboardItem item : items) {
            this.removeById(item.getId());
        }
    }

    public void removeById(int id) {
        int length = items.length - 1;
        BillboardItem[] tmp = new BillboardItem[length];
        int index = 0;
        for (BillboardItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

    public BillboardItem findById(int id) {
        BillboardItem result;
        if (id < items.length) {
            result = items[id];
        } else {
            result = null;
        }

        return result;
    }
}
