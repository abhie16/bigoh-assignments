# 1) Write down a method boolean isNameValid(String  name).
    # A name is valid if following conditions are satisfied:
    # • It does not contain any vowel more than once.
    # • If the name contains two ‘S’, then there is not any ‘T’ in between them (both in capital cases).

def isNameValid(name):
    letters = [0] * 26

    for char in name:
        if char != 's' and char != 't' and char != 'S' and char != 'T':
            letters[ord(char) - ord('a')] += 1

        if char == 'S' or char == 'T':
            letters[ord(char) - ord('A')] += 1

        if char == 'a' or char == 'e' or char == 'i' or char == 'o' or char == 'u':
            if letters[ord(char) - ord('a')] > 1 :
                return False
            
        if char == 'S' and letters[ord(char) - ord('A')] == 2 and letters[ord('T') - ord('A')] > 0:
            return False
    
    return True


print(isNameValid("abhSiiSshek"))