# // iii) Write a program to print the below pattern:

# // \*****/         
# // *\***/*         
# // **\*/**         
# // ***\***        
# // **/*\**        
# // */***\*         
# // /*****\


def print_pattern(num:int):
    for i in range(num):
        for j in range(num):
            if j == i:
                print('\\', end='')
            elif j == num - 1 - i:
                print('/', end='')
            else:
                print('*', end='')
        print() # new line

print_pattern(6)