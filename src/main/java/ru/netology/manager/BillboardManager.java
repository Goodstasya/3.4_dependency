package ru.netology.manager;

import lombok.Data;
import ru.netology.repository.*;
import ru.netology.domain.*;

public class BillboardManager {

  private BillboardRepository repository;

  public BillboardManager()
  {
    this.repository = new BillboardRepository();
  }

  public BillboardManager(BillboardRepository repository)
  {
    this.repository = repository;
  }

  public BillboardManager(BillboardRepository repository, int n)
  {
    this.repository = repository;
    this.repository.setN(n);
  }

  public BillboardItem[] getAll() {
    BillboardItem[] items = repository.findAll();
    BillboardItem[] result = new BillboardItem[items.length];
    for (int i = 0; i < result.length; i++) {
      int index = items.length - i - 1;
      result[i] = items[index];
    }
    return result;
  }

  public void removeById(int id) {
    repository.removeById(id);
  }
}
