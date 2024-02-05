# ii) Write a function that takes in a non-empty array of distinct integers and an 
# integer representing a target sum. The function should find all triplets in the array 
# that sum up to the target sum and return a two-dimensional array of all these triplets. 
# The numbers in each triplet should be ordered in ascending order, and the triplets themselves 
# should be ordered in ascending order with respect to the numbers they hold. If no three numbers sum up to the target sum, the function should return an empty array.
# Ex:
# target_sum = 6
# nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]
# result = [[1, 2, 3]]

import copy
from array_utils import ArrayUtils

def find_triplets():

    obj = ArrayUtils()
    arr = obj.input()
    target_sum = int(input('Enter target Sun: '))

    result =[]
    sublist = []

    target_sum_helper(arr, target_sum, result, sublist, 0)

    print(result)

def target_sum_helper(arr, target_sum, result, sublist, start):
    if start >= len(arr):
        return
    if target_sum == 0 and len(sublist) == 3:
        result.append(copy.deepcopy(sublist))
        return
    if(len(sublist) > 3):
        return
    
    sublist.append(arr[start])
    target_sum_helper(arr, target_sum - arr[start], result, sublist, start+1)
    sublist.pop()
    target_sum_helper(arr, target_sum, result, sublist, start+1)

find_triplets()
