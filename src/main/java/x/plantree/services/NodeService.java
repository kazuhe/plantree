package x.plantree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x.plantree.domain.entities.Node;
import x.plantree.domain.repositories.NodeRepository;

@Service
public class NodeService {

  @Autowired
  private NodeRepository nodeRepository;

  public Node saveNode(Node node) {
    return nodeRepository.save(node);
  }

  public List<Node> getNodeList() {
    return nodeRepository.findAll();
  }

  public Node getNodeById(int id) {
    return nodeRepository.findById(id);
  }

  public Node updateNode(int id, Node node) {
    return nodeRepository.updateById(id, node);
  }

  public void deleteNode(int id) {
    nodeRepository.deleteById(id);
  }

}
