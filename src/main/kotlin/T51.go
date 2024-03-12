package main

import (
	"fmt"
	"strings"
)
func solveNQueens(n int) [][]string {
	res:=make([][]string,0)
	board:=make([]string,0)
	for i := 0; i < n; i++ {
		board = append(board, strings.Repeat(".",n))
	}
	backtrack(&res,board,0)
	return res

}
func backtrack(res *[][]string,board []string,row int){
	if len(board)==row {
		boardCpy := make([]string, len(board))
		copy(boardCpy,board)
		*res = append(*res, boardCpy)
		return
	}
	size:= len(board)
	for i := 0; i < size; i++ {
		if !isValid(board,row,i){
			continue
		}
		board[row] = board[row][:i] +"Q"+board[row][i+1:]
		backtrack(res,board,row+1)
		board[row] = board[row][:i] +"."+board[row][i+1:]
	}
}
func isValid(board []string,row int,col int)bool{
	n:=len(board)
	for i := 0; i < n; i++ {
		if board[i][col]=='Q' {
			return false
		}
	}
	for j,k:=row-1,col+1;j>=0&&k<n;j,k=j-1,k+1{
		if board[j][k]=='Q' {
			return false
		}
	}
	for j,k:=row-1,col-1;j>=0&&k>=0;j,k=j-1,k-1{
		if board[j][k]=='Q' {
			return false
		}
	}
	return true
}
func main(){
	fmt.Println(solveNQueens(5))
}
