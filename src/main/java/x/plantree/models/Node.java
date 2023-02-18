package x.plantree.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/**
 * Tree の Node
 */
@Entity
@Table(name = "nodes", schema = "public")
public class Node {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private int id;

  @NotBlank(message = "Title must not be blank.")
  @Column(name = "title", nullable = false)
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
