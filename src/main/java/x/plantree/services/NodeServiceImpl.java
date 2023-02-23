package x.plantree.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import x.plantree.errors.NotFoundException;
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
    Optional<Node> result = nodeRepository.findById(id);
    if (!result.isPresent()) {
      throw new NotFoundException("Node is not available.");
    }

    return result.get();
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
