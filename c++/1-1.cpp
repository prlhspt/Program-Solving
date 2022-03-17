#include <iostream>
#include <vector>
#include <string>
#include <cstdio>

using namespace std;

int func2(int arr[], int N) {
    for (int i = 0; i < N; i++) {
        for (int j = j + 1; j < N; j++) {
            if ( arr[i] + arr[j] == 100) return 1;
        }
    }
    return 0;
}

int main() {
    int a[3] = {1, 52, 48};
    int result = func2(a, 3);
    cout << result << endl;
}