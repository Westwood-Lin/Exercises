/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset* obj = new Bitset(size);
 * obj->fix(idx);
 * obj->unfix(idx);
 * obj->flip();
 * bool param_4 = obj->all();
 * bool param_5 = obj->one();
 * int param_6 = obj->count();
 * string param_7 = obj->toString();
 */

#include <iostream>
#include <string>
#include <stdio.h>
#include <vector>
#include <numeric>
#include <sstream>
using namespace std;


class Bitset {
private:
    vector<int> content;
public:
    Bitset(int size) {
        vector<int> bit(size, 0);
        content.insert(content.end(),bit.begin(), bit.end());
    }

    void fix(int idx) {
        content[idx] = 1;
    }

    void unfix(int idx) {
        content[idx] = 0;
    }

    void flip() {
        for (size_t i = 0; i < content.size(); i++) {
            content[i] ^= 1;
        }
    }

    bool all() {
        return count() == content.size();
    }

    bool one() {
        return count() > 0;
    }

    int count() {
        return accumulate(content.cbegin(), content.cend(), 0);
    }

    string toString() {
        stringstream ss;
        copy(content.begin(), content.end(), ostream_iterator<int>(ss, ""));
        return ss.str();
    }
};

