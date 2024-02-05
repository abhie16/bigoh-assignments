# iv) Write a function Boolean isValidURL(String url).
# Input : str = “https://www.bigohtech.com/” 
# Output : Yes 
# Explanation : 
# The above URL is a valid URL.
# Input : str = “https:// www.bigohtech.com/” 
# Output : No 
# Explanation : 
# Note that there is a space after https://, hence the URL is invalid. 


def is_valid_url(url:str):
    if " " in url:
        return "No"
    else:
        if url.startswith("https://") or url.startswith("http://"):
            if url.__contains__(" "):
                return "No"
            else:
                if url.endswith(".com") or url.endswith(".in") or url.endswith(".org"):
                    return "Yes"
                if url.endswith(".com/") or url.endswith(".in/") or url.endswith(".org/"):
                    return "Yes"

    return "No"

print(is_valid_url("https://www.bigohtech.com/"))