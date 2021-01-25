public class ListNodeStack implements Stack {
    static int top;
    ListNode node;
    public ListNodeStack() {
        this.node = null;
        this.top = -1;
    }

    @Override
    public void push(int data) {
        ListNode pushNode = new ListNode(data);
        if(node == null) {
            node = new ListNode(data);
            top++;
        } else {
            node = node.add(node, pushNode, ++top);
        }
    }

    @Override
    public int pop() {
        if (top == -1) {
            System.out.println("Empty");
            return top;
        }
        return node.remove(node, top--).data;
    }
}
