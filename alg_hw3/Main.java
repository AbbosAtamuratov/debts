public class Main {

    public static void main(String[] args) {

        ListNode node = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(4)))); // 1 -> 2 -> 2 -> 4
        System.out.println((node.size())); // 4
        System.out.println(node.asString()); // [1 -> 2 -> 2 -> 4]

        System.out.println(node.getByIndex(0)); // 1
        System.out.println(node.getByIndex(3)); // 4
        System.out.println(node.getByIndex(4)); // new IndexOutOfBoundsException
    }

    /**
     * Посчитать размер списка.
     */
//    int size(ListNode head) {
//        throw new UnsupportedOperationException();
//    }

    /**
     * Написать строковое представление списка в формате
     * [first_value -> second_value -> ... -> last_value]
     */
//    String asString(ListNode head) {
//        throw new UnsupportedOperationException();
//    }

    /**
     * Найти значение по индексу
     */
//    int getByIndex(ListNode head, int index) {
//        throw new UnsupportedOperationException();
//    }

    /**
     * Дано 2 отсортированных связных списка.
     * Нужно их смержить и получить новый отсортированный связный список.
     *
     * (1, 2, 3), (1, 2, 2, 4) -> (1, 1, 2, 2, 2, 3, 4)
     * (1, 2), (3, 4, 5, 6) -> 1, 2, 3, 4, 5, 6
     */

    // (a && b) ~ !a || !b
    // a || b ~ !a && !b
    static ListNode merge(ListNode first, ListNode second) {
        ListNode head = null; // 1 -> 1 -> 2
        ListNode iterator = null; // 2
        while (first != null || second != null) {
            int nextValue = -1; // 2

            if (first == null) { // second != null
                nextValue = second.value;
                second = second.next;
            } else if (second == null) {
                nextValue = first.value;
                first = first.next;
            } else if (first.value > second.value) {
                nextValue = second.value;
                second = second.next;
            } else { // if (first.value <= second.value) {
                nextValue = first.value;
                first = first.next;
            }

            if (head == null) {
                head = new ListNode(nextValue);
                iterator = head;
            } else {
                iterator.next = new ListNode(nextValue);
                iterator = iterator.next;
            }
        }
        return head;
    }

    static void intro() {
        // head -> second -> third -> ... -> last -> null
        // 1 -> 2 -> 3
        ListNode third = new ListNode(3); // 3
        ListNode second = insertFirst(third, 2); // 2 -> 3
        ListNode first = insertFirst(second, 1); // 1 -> 2 -> 3
        iterate(first); // 1 -> 2 -> 3 -> null

        ListNode head = insertFirst(first, 0); // 0 -> 1 -> 2 -> 3
        iterate(head); // 0 -> 1 -> 2 -> 3 -> null

        insertLast(head, 4); // 0 -> 1 -> 2 -> 3 -> 4
        iterate(head); // 0 -> 1 -> 2 -> 3 -> 4 -> null

        remove(head, 2);
        iterate(head); // 0 -> 1 -> 3 -> 4 -> null

        head = reverse(head);
        iterate(head); // 4 -> 3 -> 1 -> 0 -> null
    }

    /**
     * Распечатать все элементы связного списка
     */
    static void iterate(ListNode node) {
        ListNode iter = node; // [null]
        while (iter != null) {
            System.out.print(iter.value + " -> ");
            iter = iter.next;
        }
        System.out.println("null");
    }

    /**
     * Создать список, получанный из head прибавлением value в начало
     */
    static ListNode insertFirst(ListNode head, int value) {
        return new ListNode(value, head);
    }

    /**
     * Добавить к существующему списку в конце значение value
     */
    static void insertLast(ListNode head, int value) {
        ListNode last = new ListNode(value);
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
        }
        iter.next = last;
    }

    /**
     * Удаляет из списка первое вхождение value.
     */
    static void remove(ListNode head, int value) {
        // iter -> 1
        // iter.next -> 2
        // iter.next.next -> 3

        // -> .. -> 1 -> 1 -> null

        ListNode iter = head; // [null]
        while (iter.next != null) {
            if (iter.next.value == value) {
                iter.next = iter.next.next;
                break;
            }
            iter = iter.next;
        }
    }

    static ListNode reverse(ListNode head) {
        // 0 -> 1 -> 3 -> 4 -> null
        ListNode node = null;
        ListNode iterator = head;
        while (iterator != null) {
            if (node == null) {
                node = new ListNode(iterator.value);
            } else {
                node = insertFirst(node, iterator.value);
            }
            iterator = iterator.next;
        }
        return node;
    }

}
