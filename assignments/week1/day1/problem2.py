# ii) Write a program (without using inbuilt functions and not using Strings or array) to swap first and last digits of any number

def swap_first_last_digit(num:int):
    num_len = length(num)
    print(num_len)

    if num_len < 2:
        print("At least 2 digits required")
        return
    if num == 0:
        print(num)
        return
    
    last_digit = num % 10
    num //= 10

    first_digit = num // (10**(num_len-2))
    num = num % (10**(num_len-2))

    num = last_digit * (10**(num_len-1)) + (num * 10 + first_digit)
    
    return num

def length(num:int):
    count = 0
    while num>0:
        num = num // 10
        count += 1
    return count

print(swap_first_last_digit(5670))