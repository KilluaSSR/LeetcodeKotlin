class Interview0103 {
    fun replaceSpaces(S: String, length: Int): String {
        val sb =StringBuilder()
        for(i in 0 until length){
            if(S[i]==' '){
                sb.append("%20")
                continue
            }
            sb.append(S[i])
        }
        return sb.toString()
    }
}