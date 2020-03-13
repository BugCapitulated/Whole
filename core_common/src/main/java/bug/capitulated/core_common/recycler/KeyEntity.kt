package bug.capitulated.core_common.recycler

interface KeyEntity<Key> {
    
    val id: Key
    
    override fun equals(other: Any?): Boolean
    
}