package x.plantree.presentation

import org.seasar.doma.Entity
import org.seasar.doma.Id

/**
 * ツリー
 */
@Entity(immutable = true)
data class Tree(@Id val id: Int, val name: String)
