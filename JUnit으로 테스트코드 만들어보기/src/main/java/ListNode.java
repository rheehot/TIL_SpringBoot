public class ListNode implements LinkedList {
    int data;
    ListNode next;

    public ListNode() {}
    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        ListNode node = head;
        for (int i = 0; i < position - 1; i++) {
            node = node.next;
        }
        nodeToAdd.next = node.next;
        node.next = nodeToAdd;
        return head;
    }

    @Override
    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode node = head;
        if(positionToRemove == 0) {
            ListNode deleteToNode = node;
            head = node.next;
            deleteToNode.next = null;
            return deleteToNode;
        }
        for (int i = 0; i < positionToRemove - 1; i++) {
            node = node.next;
        }
        ListNode deleteToNode = node.next;
        node.next = deleteToNode.next;
        deleteToNode.next = null;
        return deleteToNode;
    }

    @Override
    public boolean contains(ListNode head, ListNode nodeToCheck) {
        while (head.next != null) {
            if (head.next == nodeToCheck)
                return true;
            head = head.next;
        }
        return false;
    }
}
