#include <iostream>

class Node {
    public:
        char data;
        Node* next;

        Node(char element, Node* nextNode=NULL) {
            data = element;
            next = nextNode;
        }

        Node(Node* nextNode=NULL) {
            next = nextNode;
        }
};

class LinkedList {
    private:
        Node* head;
        Node* tail;
        Node* curr;
        int size;

        void init() {
            curr = tail = head = new Node;
            size = 0;
        }

        void removeAll() {
            while(head != NULL) {
                curr = head;
                head = head->next;
                delete curr;
            }
        }


    public:
        LinkedList() {
            init();
        }

        ~LinkedList() {
            removeAll();
        }

        void clear() {
            removeAll();
            init();
            curr = tail = head;
        }

        void insert(char value) {
            curr->next = new Node(value, curr->next);
            if (tail == curr) {
                tail = curr->next;
            }
            curr = curr->next;
            size++;
        }

        void moveToStart() {
            curr = head;
        }

        void moveToEnd() {
            curr = tail;
        }

        void print() {
            curr = head->next;
            while(curr != NULL) {
                std::cout << curr->data;
                curr = curr->next;
            }
            std::cout<<std::endl;
        }
};

int main() {
    std::string entrada;
    LinkedList texto;

    while(std::cin >> entrada) {
        for (int i=0; i<entrada.length(); i++) {
            if (entrada[i] == '[') {
                texto.moveToStart();
            }
            else if (entrada[i] == ']'){
                texto.moveToEnd();
            }
            else {
                texto.insert(entrada[i]);
            }
        }

        texto.print();
        texto.clear();
        }

    return 0;
}