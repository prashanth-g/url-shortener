import hashlib

url_mapping = {}

def shorten_url(long_url):
    hash_object = hashlib.md5(long_url.encode())
    short_url = hash_object.hexdigest()[:6]
    url_mapping[short_url] = long_url
    return short_url

def retrieve_url(short_url):
    return url_mapping.get(short_url)

if __name__ == "__main__":
    while True:
        print("1. Shorten URL")
        print("2. Retrieve URL")
        print("3. Exit")
        choice = input("Enter your choice: ")

        if choice == "1":
            long_url = input("Enter the long URL: ")
            short_url = shorten_url(long_url)
            print(f"Shortened URL: {short_url}")
        elif choice == "2":
            short_url = input("Enter the shortened URL: ")
            long_url = retrieve_url(short_url)
            if long_url:
                print(f"Original URL: {long_url}")
            else:
                print("URL not found.")
        elif choice == "3":
            break
        else:
            print("Invalid choice. Please try again.")
