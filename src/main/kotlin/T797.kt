import java.util.*


class SolutionT797{
    private var res : LinkedList<List<Int>> = LinkedList()
    val path : LinkedList<Int> = LinkedList()
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        calc(graph,0,path)
        return res
        
    }
    fun calc(graph:Array<IntArray>,i:Int,path:LinkedList<Int>){
        var size = graph.size
        path.add(i)
        if(i == size-1){
            res.add(LinkedList(path))
        }
        for(v in graph[i]){
            calc(graph, v, path)
        }
        path.removeLast()

    }
}