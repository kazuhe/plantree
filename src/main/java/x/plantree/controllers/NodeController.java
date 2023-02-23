package x.plantree.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import x.plantree.models.Node;
import x.plantree.services.NodeService;

@RestController
@RequestMapping(path = NodeController.BASE_URL)
public class NodeController {

  public static final String BASE_URL = "/api/v1/nodes";

  @Autowired
  private NodeService nodeService;

  /**
   * Node を作成する
   * 
   * @param newNode 新しい Node
   * @return 作成された Node
   */
  @PostMapping(path = "")
  public ResponseEntity<Node> createNode(@RequestBody @Validated Node newNode) {
    Node savedNode = nodeService.saveNode(newNode);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedNode.getId()).toUri();
    return ResponseEntity.created(location).body(savedNode);
  }

  /**
   * Node 一覧を取得する
   * 
   * @return Node 一覧
   */
  @GetMapping(path = "")
  public ResponseEntity<List<Node>> getNodeList() {
    List<Node> nodeList = nodeService.getNodeList();
    return ResponseEntity.ok(nodeList);
  }

  /**
   * Node を取得する
   * 
   * @param id Node ID
   * @return Node
   */
  @GetMapping(path = "/{id}")
  public ResponseEntity<Node> getNode(@PathVariable int id) {
    Node node = nodeService.getNodeById(id);
    return ResponseEntity.ok(node);
  }

  /**
   * Node を更新する
   * 
   * @param newNode 新しい Node
   * @param id      新しい Node ID
   */
  @PutMapping(path = "/{id}")
  public ResponseEntity<Object> updateNode(@RequestBody Node newNode, @PathVariable int id) {
    nodeService.updateNode(id, newNode);
    return ResponseEntity.noContent().build();
  }

  /**
   * Node を削除する
   * 
   * @param id Node ID
   */
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Object> removeNodeItem(@PathVariable int id) {
    nodeService.deleteNode(id);
    return ResponseEntity.noContent().build();
  }

}
