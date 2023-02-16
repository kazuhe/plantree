package x.plantree.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;

import x.plantree.errors.NotFoundException;
import x.plantree.models.Node;

@Service
public class NodeServiceImpl implements NodeService {

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

  @Override
  public Node saveNode(Node node) {
    node.setId(counter.incrementAndGet());
    nodeList.add(node);

    return node;
  }

  @Override
  public List<Node> getNodeList() {
    return nodeList;
  }

  @Override
  public Node getNodeById(int id) {
    return findNodeById(id);
  }

  @Override
  public Node updateNode(int id, Node node) {
    Node result = findNodeById(id);
    nodeList.remove(result);
    nodeList.add(node);

    return node;
  }

  @Override
  public void deleteNode(int id) {
    Node result = findNodeById(id);
    nodeList.remove(result);
  }

}
