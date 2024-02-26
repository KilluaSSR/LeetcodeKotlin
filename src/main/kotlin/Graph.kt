class Graph(private val numVertices: Int) {
    private val adjacencyMatrix = Array(numVertices) { IntArray(numVertices) }

    fun addEdge(i: Int, j: Int) {
        adjacencyMatrix[i][j] = 1
        adjacencyMatrix[j][i] = 1
    }
}
