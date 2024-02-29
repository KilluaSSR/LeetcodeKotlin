package old01//class SolutionT116 {
//    fun connect(root: Node?): Node? {
//        dfs(root,null)
//        return root
//    }
//    fun dfs(node: Node?,nxt: Node?){
//        if(node == null) return
//        node?.next = nxt
//        dfs(node?.left,node?.right)
//        if(node?.next != null){
//            dfs(node?.right,node?.next?.left)
//        }else{
//            dfs(node?.right,null)
//        }
//
//    }
//
//
//    //tree
//    fun connectX(root: Node?): Node? {
//        if(root==null)return
//        solve(root?.left, root?.right)
//        return root
//    }
//    fun solve(Node1: Node?,Node2: Node?){
//        if(Node1 == null  || Node2 == null)return
//        Node1?.next = Node2
//        solve(Node1?.left, Node1?.right)
//        solve(Node2?.left, Node2?.right)
//        solve(Node1?.right,Nofe2?.left)
//    }
//
//    fun demo(a:Int){
//
//    }
//
//
//}