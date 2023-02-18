package x.plantree.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import x.plantree.models.Node;

@Repository
public interface NodeRepository extends JpaRepository<Node, Integer> {
}
