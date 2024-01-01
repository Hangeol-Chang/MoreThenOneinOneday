#include <iostream>

int main() {
    long long a, b, c;
    std::cin >> a >> b >> c;
    std::cout << std::max(a * b / c, a * c / b);
}
