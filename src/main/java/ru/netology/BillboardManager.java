package ru.netology;

import lombok.Data;
import ru.netology.BillboardItem;

@Data
public class BillboardManager {
  private int n;
  private BillboardItem[] items = new BillboardItem[0];

  public BillboardManager()
  {
    this.n = 10;
  }

  public BillboardManager(int n)
  {
    this.n = n;
  }

  public BillboardItem[] findAll() {
    return items;
  }

  public void add(BillboardItem item) {
    this.save(item);
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
    BillboardItem[] items = this.findAll();
    BillboardItem[] result = new BillboardItem[Math.min(n, items.length)];
    for (int i = 0; i < Math.min(n, items.length) ; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }
}
