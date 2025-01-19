# URL Shortener Python Script

This repository contains a Python script for URL shortening. The script uses the `hashlib` library to generate shortened URLs. It includes functions to shorten URLs and retrieve the original URLs, as well as a simple command-line interface for users to shorten URLs.

## How to Use

1. Clone the repository:
    ```bash
    git clone https://github.com/prashanth-g/url-shortener.git
    cd url-shortener
    ```

2. Run the Python script:
    ```bash
    python url_shortener.py
    ```

3. Follow the on-screen instructions to shorten URLs or retrieve the original URLs.

## Examples

### Shorten a URL

1. Run the script:
    ```bash
    python url_shortener.py
    ```

2. Select the option to shorten a URL by entering `1`.

3. Enter the long URL you want to shorten, for example:
    ```
    Enter the long URL: https://www.example.com
    ```

4. The script will generate a shortened URL and display it, for example:
    ```
    Shortened URL: 1a2b3c
    ```

### Retrieve the Original URL

1. Run the script:
    ```bash
    python url_shortener.py
    ```

2. Select the option to retrieve the original URL by entering `2`.

3. Enter the shortened URL, for example:
    ```
    Enter the shortened URL: 1a2b3c
    ```

4. The script will retrieve and display the original URL, for example:
    ```
    Original URL: https://www.example.com
    ```

## Dependencies

- Python 3.x

## License

This project is licensed under the MIT License.
