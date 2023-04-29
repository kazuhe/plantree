package x.plantree.presentation

import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.boot.ConfigAutowireable

@Dao
@ConfigAutowireable
interface TreeDao {
//    @Insert
//    fun insert(entity: Tree): Result<Tree>

    @Select
    fun selectAll(): List<Tree>
}
