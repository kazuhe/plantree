package x.plantree.services;

import java.util.List;

import x.plantree.domain.entities.Node;

public interface NodeService_bk {
  public Node saveNode(Node node);

  public List<Node> getNodeList();

  public Node getNodeById(int id);

  public Node updateNode(int id, Node node);

  public void deleteNode(int id);
}
