package x.plantree.domain.entity;

import jakarta.validation.constraints.NotBlank;

public class Node {

  private int id;

  @NotBlank(message = "Title must not be blank.")
  private String title;

  public Node(int id, String title) {
    this.id = id;
    this.title = title;
  }

  public Node() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}
