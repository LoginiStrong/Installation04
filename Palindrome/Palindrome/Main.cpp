#include <iostream>
#include <string>
#include <algorithm>

// Function to check if a string is a palindrome
bool isPalindrome(const std::string& str) {
    int left = 0;
    int right = str.length() - 1;

    while (left < right) {
        if (str[left] != str[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}

// Function to check if a string is an inexact palindrome
bool isInexactPalindrome(const std::string& str) {
    int left = 0;
    int right = str.length() - 1;
    int allowedMismatches = 1; // Number of allowed character mismatches

    while (left < right) {
        if (str[left] != str[right]) {
            if (allowedMismatches == 0) {
                return false; // Exceeded allowed mismatches
            }
            allowedMismatches--;
        }
        left++;
        right--;
    }
    return true;
}

int main() {
    std::string input;
    std::cout << "Enter a string: ";
    std::cin >> input;

    if (isPalindrome(input)) {
        std::cout << "It's a palindrome." << std::endl;
    }
    else if (isInexactPalindrome(input)) {
        std::cout << "It's an inexact palindrome." << std::endl;
    }
    else {
        std::cout << "It's not a palindrome." << std::endl;
    }

    return 0;
}