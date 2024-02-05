
# i)Write a program to remove duplicate values from an array and returns an array of unique values. int[] removeDuplicates(int[]values)
# Ex: 
# values = [2, 4, 6, 2, 8, 10, 4, 12, 14, 6]
# result = [2, 4, 6, 8, 10, 12, 14]

from array_utils import ArrayUtils

def remove_duplicates():
    obj = ArrayUtils()
    arr = obj.input()

    unique_arr = []

    obj.display(arr)

    for i in arr:
        if i not in unique_arr:
            unique_arr.append(i)

    obj.display(unique_arr)

remove_duplicates()