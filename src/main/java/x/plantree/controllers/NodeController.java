package x.plantree.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import x.plantree.models.Node;

@RestController
@RequestMapping(path = NodeController.BASE_URL)
public class NodeController {
  public static final String BASE_URL = "/api/v1/nodes";

  private final AtomicInteger counter = new AtomicInteger();

  private List<Node> nodeItems = new ArrayList<>();

  /**
   * ID を用いてインメモリオブジェクトから Node を取得する
   * 
   * @param id Node ID
   * @return Node
   */
  private Node findNodeById(int id) {
    Optional<Node> result = nodeItems.stream().filter(item -> item.getId() == id).findAny();
    if (!result.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
    }

    return result.get();
  }

  /**
   * Node 一覧を取得する
   * 
   * @return Node 一覧
   */
  @GetMapping(path = "")
  public List<Node> getNodeItems() {
    return nodeItems;
  }

  /**
   * Node を取得する
   * 
   * @param id Node ID
   * @return Node
   */
  @GetMapping(path = "/{id}")
  public Node getNodeItem(@PathVariable int id) {
    return findNodeById(id);
  }

  /**
   * Node を作成する
   * 
   * @param newNode 新しい Node
   * @return 作成された Node
   */
  @PostMapping(path = "")
  public ResponseEntity<Node> createNodeItem(@RequestBody Node newNode) {
    newNode.setId(counter.incrementAndGet());
    nodeItems.add(newNode);
    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(newNode.getId()).toUri();
    return ResponseEntity.created(location).body(newNode);
  }

  /**
   * Node を更新する
   * 
   * @param newNode 新しい Node
   * @param id      新しい Node ID
   */
  @PutMapping(path = "/{id}")
  public ResponseEntity<?> updateNodeItem(@RequestBody Node newNode, @PathVariable int id) {
    Node result = findNodeById(id);
    nodeItems.remove(result);
    nodeItems.add(newNode);

    return ResponseEntity.noContent().build();
  }

  /**
   * Node を削除する
   * 
   * @param id Node ID
   */
  @DeleteMapping(path = "/{id}")
  public ResponseEntity<?> removeNodeItem(@PathVariable int id) {
    Node result = findNodeById(id);
    nodeItems.remove(result);

    return ResponseEntity.noContent().build();
  }
}
