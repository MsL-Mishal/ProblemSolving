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
    public ListNode mergeNodes(ListNode head) 
    {   
        // Here, I'm using `head` pointer to keep track of result (modified linkedlist).
        ListNode initialHead = head;    // Preserving the original `head` to return at last.
        ListNode leftPtr = head;    //Pointer to keep track of leftmost 0 in a sequence.
        ListNode rightPtr = head.next;  //Moving Pointer or Traversal Pointer.
        int sum = 0;    // To save the sum of non-zero values lying between two 0's.

        while(rightPtr.next != null)
        {  
           if(rightPtr.val != 0)    // Adding value to sum if it's a non-zero value.
                sum += rightPtr.val;

           else
           {
                head.val = sum;     // if rightpointer points to a 0 value, we'll update the value pointed by `head` to `sum` calculated so far.
                head = head.next;   // moving the `head` pointer to the next position.
                sum = 0;            // resetting `sum` value for calculating the sum of next non-zero sequence.
                leftPtr = rightPtr; // updating `leftPtr` to `rightPtr` to keep track of leftmost end of next sequence.   
           }
           rightPtr = rightPtr.next;    // updating rightPtr to point to the next position in the linked list.
        }

         // since we'll not be getting into the last element (because it violates rightPtr.next != null)
         // so, we have to update the value currently pointed by `head` with `sum` value calculated so far. 
        head.val = sum;    
        head.next = null;   // since all the elements are exhausted, we'll set the `head.next` to `null` to mark the end of result (modified linkedlist). 
        head = initialHead; // resetting the `head` to original `head` as it was in the beginning.

        return head;
    }
}
