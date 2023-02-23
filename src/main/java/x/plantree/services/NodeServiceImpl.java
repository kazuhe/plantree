package x.plantree.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import x.plantree.models.Node;
import x.plantree.repositories.NodeRepository;

@Service
@Primary
public class NodeServiceImpl implements NodeService {

  @Autowired
  private NodeRepository nodeRepository;

  @Override
  public Node saveNode(Node node) {
    return nodeRepository.save(node);
  }

  @Override
  public List<Node> getNodeList() {
    return nodeRepository.findAll();
  }

  @Override
  public Node getNodeById(int id) {
    return nodeRepository.findById(id);
  }

  @Override
  public Node updateNode(int id, Node node) {
    return nodeRepository.updateById(id, node);
  }

  @Override
  public void deleteNode(int id) {
    nodeRepository.deleteById(id);
  }

}
