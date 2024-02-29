class SolutionT210{
    var hasCycle = false
    val res = mutableListOf<Int>()
    fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>):Array<MutableList<Int>>{
        val graph = Array(numCourses){mutableListOf<Int>()}
        for(edge in prerequisites){
            val from = edge[1]
            val to = edge[0]
            graph[from].add(to)
        }
        return graph
    }
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val onPath = Array(numCourses){false}
        val visited = Array(numCourses){false}
        val graph = buildGraph(numCourses,prerequisites)
        for(course in 0 until numCourses){
            traverse(graph,course,visited,onPath)
        }
        return if(!hasCycle) intArrayOf() else{res.reversed().toIntArray()}
    }
    fun traverse(graph:Array<MutableList<Int>>,course:Int,visited:Array<Boolean>,onPath:Array<Boolean>){
        if(onPath[course]){
            hasCycle=true
            return
        }
        if(visited[course])return
        onPath[course]=true
        visited[course]=true
        for(v in graph[course]){
            traverse(graph,v,visited,onPath)
        }
        res.add(course)
        onPath[course]=false
    }
}