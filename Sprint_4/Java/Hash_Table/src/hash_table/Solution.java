//52299977

// Принцип работы алгоритма:
//      Хэш-таблица содержит в себе элементы, состоящие из ключа и значения. Все реализованные операции (сохранение,
//      получение и удаление из хэщ-таблицы) основаны на:
//              - получении значения от ключа по модулю, равному количество корзин;
//              - обращении к корзине с соответствующим номером (индекс в массиве);
//              - поиск элемента в корзине (поиск по связанному списку).
//      В процессе работы могут возникать коллизии (в одной корзине находятся элементы с одинаковым значением
//      ключа по модулю. Разрешение коллизий в данном алгоритме реализовано с помощью метода цепочек. То есть корзина
//      представляет собой связанный список с головой в ячейке массива.
//
//Обоснование корректности:
//      Алгоритм корректен, так как значение ключа по модулю, равному количеству корзин, не превосходит основания, то
//      есть не будет выхода за границы массива. Использование связанных списков в корзинах позволяет хранить элементы
//      несмотря на коллизии. Поиск в связанном списке идет по ключу.
//
//Временная сложность:
//      Временная сложность будет складываться из:
//          - перехода в нужную корзину (O[1] - получение головы связанного списка из массива):
//          - проход по связанному списку.
//      В худшем случае (когда количество корзин и ключи входных данных будут давать одно и то же значение номера корзины)
//      временная сложность будет складываться из прохода по всем входным данным (все входные данные лежат в одном
//      связанном списке). Таким образов в худшем случае временная сложность будет O(N). Сложность в среднем случае
//      будет O(1).
//
//Пространственная сложность:
//Задействуется память в размере массива размером, равным количеству корзин. И память на связанные списке в корзинах.
//Таким образом пространственная сложность будет O[N + M], где M - количество корзин.


package hash_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashTable table = new HashTable();
        StringBuffer stringBuffer = new StringBuffer("");
        int commandsQuantity = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < commandsQuantity; i++) {
            int key;
            int value;
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String command = stringTokenizer.nextToken();
            switch (command) {
                case ("put"):
                    key = Integer.parseInt(stringTokenizer.nextToken());
                    value = Integer.parseInt(stringTokenizer.nextToken());
                    table.put(key, value);
                    break;
                case ("get"):
                    key = Integer.parseInt(stringTokenizer.nextToken());
                    try {
                        stringBuffer.append(table.get(key)).append("\n");
                    } catch (NoSuchElementException e) {
                        stringBuffer.append("None").append("\n");
                    }
                    break;
                case ("delete"):
                    key = Integer.parseInt(stringTokenizer.nextToken());
                    try {
                        stringBuffer.append(table.delete(key)).append("\n");
                    } catch (NoSuchElementException e) {
                        stringBuffer.append("None").append("\n");
                    }
            }
        }
        System.out.println(stringBuffer.toString());
    }
}

class HashTable {
    public Node[] table;
    public static final int BUCKET_QUANTITY = 99991;

    public HashTable() {
        table = new Node[BUCKET_QUANTITY];
    }

    public void put(int key, int value) {
        if (table[hash(key)] == null) {
            Node newNode = new Node(null, key, value);
            table[hash(key)] = newNode;
        } else {
            Node previousNode = table[hash(key)];
            if (previousNode.getKey() == key) {
                previousNode.setValue(value);
                return;
            }
            Node nextNode = table[hash(key)].getNext();
            while (nextNode != null) {
                if (nextNode.getKey() == key) {
                    nextNode.setValue(value);
                    return;
                }
                previousNode = nextNode;
                nextNode = previousNode.getNext();
            }
            Node newNode = new Node(null, key, value);
            previousNode.setNext(newNode);
        }
    }

    public int get(int key) throws NoSuchElementException {
        chekExistKey(key);
        Node previousNode = table[hash(key)];
        if (previousNode.getKey() == key) {
            return previousNode.getValue();
        }
        Node nextNode = table[hash(key)].getNext();
        while (nextNode != null) {
            if (nextNode.getKey() == key) {
                break;
            }
            previousNode = nextNode;
            nextNode = previousNode.getNext();
        }
        if (nextNode == null) {
            throw new NoSuchElementException();
        }
        return nextNode.getValue();
    }

    public int delete(int key) throws NoSuchElementException {
        chekExistKey(key);
        Node previousNode = table[hash(key)];
        if (previousNode.getKey() == key) {
            table[hash(key)] = previousNode.getNext();
            return previousNode.getValue();
        }
        Node nextNode = table[hash(key)].getNext();
        while (nextNode != null) {
            if (nextNode.getKey() == key) {
                break;
            }
            previousNode = nextNode;
            nextNode = previousNode.getNext();
        }
        if (nextNode == null) {
            throw new NoSuchElementException();
        }
            int result = nextNode.getValue();
            previousNode.setNext(nextNode.getNext());
            return result;
    }

    private void chekExistKey(int key) {
        if (table[hash(key)] == null) {
            throw new NoSuchElementException();
        }
    }

    private int hash(int key) {
        return key % table.length;
    }
}

class Node {
    private Node next;
    private int key;
    private int value;

    public Node(Node next, int key, int value) {
        this.next = next;
        this.key = key;
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public int getKey() {
        return key;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
