#include <iostream>

using namespace std;

typedef struct bstNode {
    int key;
    int element;
    bstNode *left;
    bstNode *right;
    int height;
}BstNode;

BstNode *createBstNode(int k, int e) {
    BstNode *n = new BstNode;
    n->height = 0;
    n->key = k;
    n->element = e;
    n->left = n->right = NULL;
    return n;
}


void preOrder(BstNode *rt) {
    if (rt != NULL) {
        cout << rt->key << endl;
        preOrder(rt->left);
        preOrder(rt->right);
    }
}

typedef struct bst {
    BstNode *root;
    int nodeCount;
}Bst;

Bst *createBst() {
    Bst *tree = new Bst;
    tree->root = NULL;
    tree->nodeCount = 0;
    return tree;
}


int h(BstNode *rt) {
    if (rt == NULL) {
        return -1;
    }
    return rt->height;
}

int getBalance(BstNode *rt) {
    if (rt == NULL) {
        return 0;
    }
    return h(rt->left) - h(rt->right);
}

BstNode *rightRotate(BstNode* y) {
    BstNode *x = y->left;
    BstNode* z = x->right;

    x->right = y;
    y->left = z;

    y->height = max(h(y->left), h(y->right)) + 1;
    x->height = max(h(x->left), h(x->right)) + 1;

    return x;
}

BstNode* leftRotate(BstNode* y) {
    BstNode *x = y->right;
    BstNode *z = x->left;

    x->left = y;
    y->right = z;

    y->height = max(h(y->left), h(y->right)) + 1;
    x->height = max(h(x->left), h(x->right)) + 1;

    return x;
}

BstNode *insertHelp(BstNode *rt, int k, int e) {
    if (rt == NULL) {
        return createBstNode(k,e);
    }
    if (rt->key > k) {
        rt->left = insertHelp(rt->left, k, e);
    } else {
        rt->right = insertHelp(rt->right, k, e);
    }

    rt->height = 1 + max(h(rt->left), h(rt->right));
    int balance = getBalance(rt);

    if (balance < -1 and k >= rt->right->key) {
        return leftRotate(rt);
    }
    if (balance > 1 and k < rt->left->key) {
        return rightRotate(rt);
    }
    if (balance > 1 and k >= rt->left->key) {
        rt->left = leftRotate(rt->left);
        return rightRotate(rt);
    }
    if (balance < -1 and k < rt->right->key) {
        rt->right = rightRotate(rt->right);
        return leftRotate(rt);
    }

    return rt;
}



void insert(Bst *tree, int k, int e) {
    tree->root = insertHelp(tree->root, k, e);
    tree->nodeCount++;
}



int main() {
    int operations;
    cin >> operations;

    int numKeys;
    int keys;

    Bst *tree = createBst();

    cin >> numKeys;
    for (int i = 0; i < operations; i++)
    {
        Bst *tree = new Bst;
        for (int i = 0; i < numKeys; i++)
        {

            cin >> keys;
            insert(tree, keys, keys);

        }
        preOrder(tree->root);
        cout << "END" << endl;

        cin >> numKeys;


    }

    return 0;
}