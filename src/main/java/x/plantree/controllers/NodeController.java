package x.plantree.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import x.plantree.models.Node;

@RestController
public class NodeController {
  private List<Node> nodeItems = new ArrayList<>();

  /**
   * Node を取得する
   * 
   * @param id ID
   * @return Node
   */
  private Node getNodeById(int id) {
    return nodeItems.stream().filter(item -> item.getId() == id).findAny().orElse(null);
  }

  // get Nodes
  @RequestMapping(method = RequestMethod.GET, path = "/nodes")
  public List<Node> getNodeItems() {
    return nodeItems;
  }

  // get Node
  @RequestMapping(method = RequestMethod.GET, path = "/nodes/{id}")
  public Node getNodeItem(@PathVariable int id) {
    Node result = getNodeById(id);
    if (result == null) {
      // TODO: 404 を返す
    }

    return result;
  }

  // create Node
  @RequestMapping(method = RequestMethod.POST, path = "/nodes")
  public List<Node> createNodeItem(@RequestBody Node newNode) {
    // TODO: ID を生成する
    newNode.setId(1);
    nodeItems.add(newNode);

    return nodeItems;
  }

  // update Node
  @RequestMapping(method = RequestMethod.PUT, path = "/nodes/{id}")
  public Node updateNodeItem(@RequestBody Node newNode, @PathVariable int id) {
    Node result = getNodeById(id);
    if (result == null) {
      // TODO: 404 を返す
    }

    nodeItems.remove(result);
    nodeItems.add(newNode);

    return newNode;
  }

  // delete Node
  @RequestMapping(method = RequestMethod.DELETE, path = "/nodes/{id}")
  public void removeNodeItem(@PathVariable int id) {
    Node result = getNodeById(id);
    if (result == null) {
      // TODO: 404 を返す
    }
    nodeItems.remove(result);
  }
}
