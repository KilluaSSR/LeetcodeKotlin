package old01

class SolutionT590 {
    var list = ArrayList<Int>()
    fun postorder(root: Node?): List<Int> {
        build(root)
        return list
    }
    fun build(root: Node?){
        if(root == null) return
        for(child in root.children){
            build(child)
        }
        list.add(root.`val`)

    }
}