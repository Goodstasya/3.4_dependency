package ru.netology.manager;

import lombok.Data;
import ru.netology.domain.BillboardItem;

@Data
public class BillboardManager {
  private int BillboardLength = 10;
  private BillboardItem[] items = new BillboardItem[0];

  public BillboardManager() {  }

  public BillboardManager(int n)
  {
    this.BillboardLength = n;
  }

  public BillboardItem[] findAll() {
    return items;
  }

  public void save(BillboardItem item) {
    int length = items.length + 1;
    BillboardItem[] tmp = new BillboardItem[length];
    System.arraycopy(items, 0, tmp, 0, items.length);
    int lastIndex = tmp.length - 1;
    tmp[lastIndex] = item;
    items = tmp;
  }

  public BillboardItem[] getFilms() {
    BillboardItem[] result = new BillboardItem[Math.min(BillboardLength, items.length)];
    for (int i = 0; i < Math.min(BillboardLength, items.length) ; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

  public void setItems(BillboardItem[] items) {
    this.items = items;
  }
}
