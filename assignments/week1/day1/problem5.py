# v) Write a program to find the smallest number divisible by all the numbers between 1 to n.

def divisible_by_all(n:int):
    ans = 1
    for i in range(2, n+1):
        ans = lcm(ans, i)
    return ans

def lcm(a:int, b:int):
    min_val = min(a,b)
    max_val = max(a,b)

    count = max_val
    
    while True:
        if count % min_val == 0:
            return count
        count += max_val


print(divisible_by_all(5))