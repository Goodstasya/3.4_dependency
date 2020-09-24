package ru.netology.repository;

import ru.netology.domain.*;

public class BillboardRepository {
    private BillboardItem[] items = new BillboardItem[0];

    private int n;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void save(BillboardItem item) {
        int length = items.length + 1;
        BillboardItem[] tmp = new BillboardItem[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public BillboardItem[] findAll() {
        BillboardItem[] result = new BillboardItem[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
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
