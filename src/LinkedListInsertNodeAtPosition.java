public class HillsAndValleys {
    // Complete the insertNodeAtPosition function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        if (head == null) {
            return new SinglyLinkedListNode(data);
        }

        SinglyLinkedListNode current = head;
        SinglyLinkedListNode temp = null;
        for (int i = 0; i <= position; i++) {
            if ((i+1) != position) {
                current = current.next;
                continue;
            }

            temp = current.next;
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
            newNode.next = temp;
            current.next = newNode;
        }

        return head;
    }
}