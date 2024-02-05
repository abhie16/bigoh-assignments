# // iii) Find the largest number less than N whose each digit is prime number

def largest_prime(num:int):
    for n in range(num,0, -1):
        if is_each_digit_prime(n):
            return n
        
    return -1

def is_each_digit_prime(num:int):
    while num > 0:
        dig = num % 10
        num = num // 10

        if dig != 2 and dig != 3 and dig != 5 and dig != 7:
            return False
    
    return True


print(largest_prime(770))