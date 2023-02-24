package x.plantree.infrastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import x.plantree.domain.entity.Node;
import x.plantree.domain.repository.NodeRepository;
import x.plantree.errors.NotFoundException;

@Repository
public class NodeRepositoryImplWithInMemory implements NodeRepository {

  private final AtomicInteger counter = new AtomicInteger();

  private List<Node> nodeList = new ArrayList<>();

  /**
   * ID を用いてインメモリオブジェクトから Node を取得する
   * 
   * @param id Node ID
   * @return Node
   */
  private Node findNodeById(int id) {
    Optional<Node> result = nodeList.stream().filter(item -> item.getId() == id).findAny();
    if (!result.isPresent()) {
      throw new NotFoundException("Node is not available.");
    }

    return result.get();
  }

  /**
   * インメモリオブジェクトに Node を登録する
   */
  @Override
  public Node save(Node node) {
    node.setId(counter.incrementAndGet());
    nodeList.add(node);

    return node;
  }

  /**
   * インメモリオブジェクトから全ての Node を取得する
   */
  @Override
  public List<Node> findAll() {
    return nodeList;
  }

  /**
   * インメモリオブジェクトから特定の Node を取得する
   */
  @Override
  public Node findById(int id) {
    return findNodeById(id);
  }

  /**
   * インメモリオブジェクトの特定の Node を更新する
   */
  @Override
  public Node updateById(int id, Node node) {
    Node result = findNodeById(id);
    nodeList.remove(result);
    nodeList.add(node);

    return node;
  }

  /**
   * インメモリオブジェクトから特定の Node を削除する
   */
  @Override
  public void deleteById(int id) {
    Node result = findNodeById(id);
    nodeList.remove(result);
  }

}
