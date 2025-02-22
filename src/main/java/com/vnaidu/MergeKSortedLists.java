package com.vnaidu;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

import static com.vnaidu.ReverseKNodes.ListNode;
public class MergeKSortedLists extends Base {

    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null|| lists.isEmpty()) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<>(lists.size(),
                Comparator.comparingInt(o -> o.val));

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        lists.stream().filter(Objects::nonNull).forEach(queue::add);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1!=null && list2!=null){
            if(list1.val<list2.val){
                list1.next=mergeTwoLists(list1.next,list2);
                return list1;
            }
            else{
                list2.next=mergeTwoLists(list1,list2.next);
                return list2;
            }
        }
        if(list1==null)
            return list2;
        return list1;
    }
}
