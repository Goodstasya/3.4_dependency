package ru.netology.manager;

import lombok.Data;
import ru.netology.repository.*;
import ru.netology.domain.*;

public class BillboardManager {
  private int BillboardLength = 10;

  private BillboardRepository repository;

  public BillboardManager() {  }

  public BillboardManager(BillboardRepository repository)
  {
    this.repository = repository;
  }

  public BillboardManager(BillboardRepository repository, int n)
  {
    this.repository = repository;
    this.setBillboardLength(n);
  }

  public void save(BillboardItem item)
  {
    repository.save(item);
  }

  public void removeAll()
  {
    repository.removeAll();
  }

  public void removeById(int id) {
    repository.removeById(id);
  }

  public BillboardItem[] findAll() {
    return repository.findAll();
  }

  public BillboardItem[] getFilms() {
    BillboardItem[] items = repository.findAll();
    BillboardItem[] result = new BillboardItem[Math.min(BillboardLength, items.length)];
    for (int i = 0; i < Math.min(BillboardLength, items.length) ; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

  public BillboardItem findById(int id) {
    return repository.findById(id);
  }

  public int getBillboardLength() {
    return BillboardLength;
  }

  public void setBillboardLength(int billboardLength) {
    BillboardLength = billboardLength;
  }
}
