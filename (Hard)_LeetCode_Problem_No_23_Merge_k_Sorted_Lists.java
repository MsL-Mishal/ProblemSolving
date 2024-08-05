/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution 
{
    public ListNode mergeKLists(ListNode[] lists) 
    {   
        // Our given `lists` contains the `head` of each sorted linked lists

        // Priority Queue Created with a Custom Comparator
        PriorityQueue<ListNode> pq = new PriorityQueue<>( (a, b) -> a.val - b.val ); // Comparator functions logic is written here in such a way that priority queue follows ascending order logic
                                                                                     // for descending order, we would've written (a, b) -> b.val - a.val
        // Insert the minimum node of each sorted list
        // i.e we are adding the head of each linked list to the priority queue
        for(int i = 0; i < lists.length; i++)
            if(lists[i] != null)    // checking if the head doesn't point to null (means not an empty linked list)
                pq.add(lists[i]);

        // Create our ans linked list
        ListNode head = null;
        ListNode cur = head;

        while(!pq.isEmpty())
        {
            // Remove and return the current minimum node from Priority Queue in O(logk)
                                                // Both `poll()` and `remove()` is used to remove and return the minimum element in the priority queue.
            ListNode curMinNode = pq.poll();    // `poll()` method is used or preferred instead of remove() method, 
                                                // since `remove()` method returns `exception` when the queue is empty, 
                                                // whereas `poll()` method won't return an exception, but, returns `null` instead
            if(head == null)
            {
                head = new ListNode(curMinNode.val);
                cur = head;
            }

            else
            {
                cur.next = new ListNode(curMinNode.val);
                cur = cur.next;
            }

            // add the next minimum node
            if(curMinNode.next != null)
            {
                pq.add(curMinNode.next);
            }
        }
        
        return head;

        //Time Complexity : O(nlog(k))
        // Space Complexity : O(k)
    }
}
