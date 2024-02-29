class SolutionT207{
    var hasCycle = false
    fun buildGraph(numCourses: Int, prerequisites: Array<IntArray>):Array<MutableList<Int>>{
        val graph = Array(numCourses){mutableListOf<Int>()}
        for(edge in prerequisites){
            val from = edge[1]
            val to = edge[0]
            graph[from].add(to)
        }
        return graph
    }
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val onPath = Array(numCourses){false}
        val visited = Array(numCourses){false}
        val graph = buildGraph(numCourses,prerequisites)
        for(course in 0 until numCourses){
            traverse(graph,course,visited,onPath)
        }
        return !hasCycle
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
        onPath[course]=false

    }
}
