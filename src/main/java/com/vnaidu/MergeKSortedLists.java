package com.vnaidu;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

import static com.vnaidu.ReverseKNodes.ListNode;
public class MergeKSortedLists {

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
}
