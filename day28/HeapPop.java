import java.util.List;

public class Solution {
    static int findMax(int left,int right)
    {
        // left -> 0
        // right -> 1
        return (left > right)?0:1;
    }
    static void heapify(List<Integer> heap)
    {
        
        int numberOfInnerNodes = (heap.size()/2) - 1;
        int index = 0;
        while(index <= numberOfInnerNodes)
        {
            int parentValue = heap.get(index);
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            if(rightChild < heap.size())
            {
                // both left and right child
                int maxChildIndex = (findMax(heap.get(leftChild),heap.get(rightChild)) == 0)?leftChild:rightChild;
                // compare the big child with current parent
                if(parentValue < heap.get(maxChildIndex))
                {
                    int tem = heap.get(index);
                    heap.set(index, heap.get(maxChildIndex));
                    heap.set(maxChildIndex, tem);
                    index = maxChildIndex;
                    continue;
                }
                break;
            }
            // ony left child
            else
            {
                int leftChildValue = heap.get(leftChild);
                if(parentValue < leftChildValue)
                {
                    heap.set(index, leftChildValue);
                    heap.set(leftChild,parentValue);
                }
                break;
            }
        }
    }
    public static int pop(List<Integer> heap) {
        // return the 0 index value 
        // System.out.println(heap);
        if(heap.size() == 0)
            return -1;
        int maxValue = heap.get(0);
        // remove the last index value and assign the value into the 0 index
        heap.set(0,heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(heap);
        return maxValue;
    }

    // Code Snippet of the push function:
    // public static void push(List<Integer> heap, int x) {
    //         heap.add(x);
    //
    //         // Position of the current inserted element.
    //         int pos = heap.size() - 1;
    //
    //         // Shifting the element up until it reaches the topmost node if it is larger than its parent.
    //         while (pos > 0) {
    //             int parent = (pos - 1) / 2;
    //             if (heap.get(pos) > heap.get(parent)) {
    //                 // Swapping the elements.
    //                 int temp = heap.get(parent);
    //                 heap.set(parent, heap.get(pos));
    //                 heap.set(pos, temp);
    //                 pos = parent;
    //             } else {
    //                 // As parent is larger, the element is now in its correct position.
    //                 break;
    //             }
    //         }
    //     }
}
