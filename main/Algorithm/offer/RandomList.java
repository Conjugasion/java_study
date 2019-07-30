package Algorithm.offer;

import java.util.ArrayList;

/**
 * @author Lucas
 * @date 2019/7/12 15:28
 */
public class RandomList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode Clone(RandomListNode pHead)
    {
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode tempNew = newHead;
        RandomListNode tempOld = pHead;
        ArrayList<RandomListNode> nodesNew = new ArrayList<>();
        ArrayList<RandomListNode> nodesOld = new ArrayList<>();
        nodesNew.add(tempNew);
        nodesOld.add(tempOld);
        while(true){
            RandomListNode curNode = tempOld.next;
            if (curNode==null) break;
            RandomListNode copyNode = new RandomListNode(curNode.label);
            tempNew.next = copyNode;
            nodesNew.add(copyNode);
            nodesOld.add(curNode);
            tempNew = tempNew.next;
            tempOld = tempOld.next;
        }
        for(int i=0; i< nodesNew.size();i++){
            RandomListNode randomNode = nodesOld.get(i).random;
            int index = nodesOld.indexOf(randomNode);
            nodesNew.get(i).random = nodesNew.get(index);
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomList randomList = new RandomList();
        RandomListNode node1 = randomList.new RandomListNode(1);
        RandomListNode node2 = randomList.new RandomListNode(2);
        RandomListNode node3 = randomList.new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node2.random = null;
        node3.random = node2;

        System.out.println(node1);

        RandomListNode newNode = randomList.Clone(node1);
        System.out.println(newNode);
    }
}
