package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
/*@Data*/
public class BillboardItem {
  private int id;
  private String Name;
  private String GenreName;


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGenreName() {
    return GenreName;
  }

  public void setGenreName(String genreName) {
    GenreName = genreName;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }
}
