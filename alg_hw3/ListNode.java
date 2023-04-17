public class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    /**
     * Посчитать размер списка.
     */
    public int size() {
        int size = 1;
        ListNode iter = next;
        while (iter!=null) {
            size++;
            iter=iter.next;
        }
        return size;
    }

    /**
     * Написать строковое представление списка в формате
     * [first_value -> second_value -> ... -> last_value]
     */
    public String asString() {
       ListNode iter = next;
       StringBuilder sb = new StringBuilder();
       sb.append("[").append(getValue()).append("->");
       while(iter!=null){
           sb.append(iter.getValue()).append("->");
           iter = iter.next;
       }
       sb.deleteCharAt(sb.length()-1).deleteCharAt(sb.length()-1);
       sb.append("]");
       return sb.toString();
    }

    /**
     * Найти значение по индексу
     */
    public int getByIndex(int index) {

        if (index == 0)
            return getValue();
        else if (index >= size())
            throw new IndexOutOfBoundsException();
        else{
            ListNode iter = next;
            for (int i = 0; i < index-1; i++)
                iter=iter.next;
            return iter.getValue();
        }

    }

    public int getValue() {
        return value;
    }


}
