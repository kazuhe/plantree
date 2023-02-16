package x.plantree.models;

import jakarta.validation.constraints.NotBlank;

/**
 * Tree の Node
 */
public class Node {

  private int id;

  @NotBlank(message = "Title must not be blank.")
  private String title;

  public Node(int id, String title) {
    this.id = id;
    this.title = title;
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
