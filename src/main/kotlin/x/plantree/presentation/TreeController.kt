package x.plantree.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TreeController(private val treeDao: TreeDao) {
    @GetMapping("/")
    fun index(): String {
        return treeDao.selectAll().toString()
    }
}
