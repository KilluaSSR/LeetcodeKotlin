package main

func canCompleteCircuit(gas []int, cost []int) int {
	size := len(gas)
	minSum, where, sum := 0, 0, 0
	for i := 0; i < size; i++ {
		sum += gas[i] - cost[i]
		if sum < minSum {
			where = i + 1
			minSum = sum
		}
	}
	if sum < 0 {
		return -1
	}
	if where == 0 {
		return 0
	}
	return where

}
