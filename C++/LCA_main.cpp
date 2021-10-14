#include <iostream>
#include <vector>
#include "LCA.cpp"
#include <assert.h>

using namespace std;

int main()
{
    //test that findLCA functions properly
    cout << "TESTING FINDLCA FUNCTION\n";

    Node * root1 = newNode(1);
    root1->left = newNode(2);
    root1->right = newNode(3);
    root1->left->left = newNode(4);
    root1->left->right = newNode(5);
    root1->right->left = newNode(6);
    root1->right->right = newNode(7);

    //cout << "LCA(4, 5) = " << findLCA(root, 4, 5);
    assert(findLCA(root1, 4, 5)==2);
    //cout << "\nLCA(4, 6) = " << findLCA(root, 4, 6);
    assert(findLCA(root1, 4, 6)==1);
    //cout << "\nLCA(3, 4) = " << findLCA(root, 3, 4);
    assert(findLCA(root1, 3, 4)==1);
    //cout << "\nLCA(2, 4) = " << findLCA(root, 2, 4);
    assert(findLCA(root1, 2, 4)==2);

    cout << "LCA TESTS PASS\n\n";

    //test empty tree
    cout << "TESTING EMPTY TREE\n";

    Node * root2 = newNode(1);

    assert(findLCA(root2, 0, 0)==-1); 

    cout << "EMPTY TREE TEST PASSES\n\n";

    //test for a negative result
    cout << "TEST FOR NODE NOT IN TREE\n";

    Node * root3 = newNode(1);
    root3->left = newNode(2);
    root3->right = newNode(3);
    root3->left->left = newNode(4);
    root3->left->right = newNode(5);

    assert(findLCA(root3, 2, 6)==-1);

    cout << "NODE NOT IN TREE TEST PASSES\n\nALL TESTS PASS";
    return 0;
}