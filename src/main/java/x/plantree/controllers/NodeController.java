package x.plantree.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NodeController {
  // get Nodes
  @RequestMapping(method = RequestMethod.GET, path = "/nodes")
  public String getNodeItems() {
    return "get node items";
  }

  // get Node
  @RequestMapping(method = RequestMethod.GET, path = "/nodes/{id}")
  public String getNodeItem() {
    return "get node item";
  }

  // create Node
  @RequestMapping(method = RequestMethod.POST, path = "/nodes")
  public String createNodeItem() {
    return "create node item";
  }

  // update Node
  @RequestMapping(method = RequestMethod.PUT, path = "/nodes/{id}")
  public String updateNodeItem() {
    return "update node item";
  }

  // delete Node
  @RequestMapping(method = RequestMethod.DELETE, path = "/nodes/{id}")
  public String removeNodeItem() {
    return "remove node item";
  }
}
