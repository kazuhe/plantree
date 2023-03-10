package x.plantree.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import x.plantree.domain.entity.Node;
import x.plantree.domain.repository.NodeRepository;

@Repository
@Primary
public class NodeRepositoryImpl implements NodeRepository {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  /**
   * データベースに Node を登録する
   */
  @Override
  public Node save(Node node) {
    String sql = "INSERT INTO nodes VALUES (?, ?)";
    jdbcTemplate.update(sql, node.getId(), node.getTitle());

    return node;
  }

  /**
   * データベースから全ての Node を取得する
   */
  @Override
  public List<Node> findAll() {
    String sql = "SELECT * FROM nodes";
    SqlRowSet rs = jdbcTemplate.queryForRowSet(sql);
    List<Node> list = new ArrayList<>();
    while (rs.next()) {
      list.add(new Node(rs.getInt("id"), rs.getString("title")));
    }

    return list;
  }

  /**
   * データベースから特定の Node を取得する
   */
  @Override
  public Node findById(int id) {
    String sql = "SELECT * FROM nodes WHERE id = ?";
    Map<String, Object> map = jdbcTemplate.queryForMap(sql, id);
    Node node = new Node();
    node.setId((int) map.get("id"));
    node.setTitle((String) map.get("title"));
    return node;
  }

  /**
   * データベースの特定の Node を更新する
   */
  @Override
  public Node updateById(int id, Node node) {
    String sql = "UPDATE nodes SET title = ? WHERE id = ?";
    jdbcTemplate.update(sql, node.getTitle(), id);
    return node;
  }

  /**
   * データベースから特定の Node を削除する
   */
  @Override
  public void deleteById(int id) {
    String sql = "DELETE FROM nodes WHERE id = ?";
    jdbcTemplate.update(sql, id);
  }

}
