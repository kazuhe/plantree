package x.plantree.domain.repository;

import java.util.List;

import x.plantree.domain.entity.Node;

public interface NodeRepository {

  Node save(Node node);

  List<Node> findAll();

  Node findById(int id);

  Node updateById(int id, Node node);

  void deleteById(int id);

}
