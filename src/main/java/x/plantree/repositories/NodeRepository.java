package x.plantree.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import x.plantree.models.Node;

@Repository
public class NodeRepository {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Node> findAll() {
    String sql = "SELECT * FROM nodes";
    SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
    List<Node> list = new ArrayList<>();
    while (rs.next()) {
      list.add(new Node(rs.getInt("id"), rs.getString("title")));
    }

    return list;
  }

  // ↓WIP

  private List<Node> nodeList = new ArrayList<>();

  /**
   * ID を用いてインメモリオブジェクトから Node を取得する
   * 
   * @param id Node ID
   * @return Node
   */
  private Node findNodeById(int id) {
    Optional<Node> result = nodeList.stream().filter(item -> item.getId() == id).findAny();

    return result.get();
  }

  public Node save(Node node) {
    nodeList.add(node);

    return node;
  }

  public Optional<Node> findById(int id) {
    return nodeList.stream().filter(item -> item.getId() == id).findAny();
  }

  public void deleteById(int id) {
    Node result = findNodeById(id);
    nodeList.remove(result);
  }
}
