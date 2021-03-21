package algorithm.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class ProblemNo21 {

    @Test
    void test() {
        ListNode l1 = makeListNode(Stream.of(1, 2, 4).collect(Collectors.toList()));
        ListNode l2 = makeListNode(Stream.of(1, 3, 4).collect(Collectors.toList()));
        assertThat(makeList(mergeTwoLists(l1, l2)).get(3)).isEqualTo(3);
        l1 = makeListNode(new ArrayList<>());
        l2 = makeListNode(Stream.of(0).collect(Collectors.toList()));
        assertThat(makeList(mergeTwoLists(l1, l2)).size()).isEqualTo(1);
        l1 = makeListNode(new ArrayList<>());
        l2 = makeListNode(new ArrayList<>());
        assertThat(makeList(mergeTwoLists(l1, l2)).isEmpty()).isTrue();
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 != null ? l1 : l2;
        return head.next;
    }

    private ListNode makeListNode(List<Integer> list) {
        if (list.isEmpty()) {
            return null;
        }
        ListNode start = new ListNode();
        ListNode point = start;
        for (int i = 0; i < list.size(); i++) {
            point.val = list.get(i);
            if (i == list.size() - 1) {
                break;
            }
            point.next = new ListNode();
            point = point.next;
        }
        return start;
    }

    private List<Integer> makeList(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
}
