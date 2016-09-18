/**
 * Created by Grigoryan on 18.09.2016.
 */
public class ArraySorter {

    private void PrintArray(int[] array)
    {
        PrintArray(array, -1);
    }

    private void PrintArray(int[] array, int highlightedItemIndex)
    {
        for (int i=0;i<array.length;i++)
        {
            if (i == highlightedItemIndex)
            {
                System.out.print("->");
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    public void SortByInsertionSort(int[] array, boolean descendingSort, boolean traceIntermediateResults)
    {
        if (traceIntermediateResults)
        {
            String sortOrder = descendingSort ? "descending" : "ascending";
            System.out.print("Is about to sort this array using insertion sort by " + sortOrder + " order: ");
            PrintArray(array);
        }
        for (int i=1;i<array.length;i++)
        {
            int currentNumber = array[i];
            int j;
            if (traceIntermediateResults)
            {
                System.out.println("Element #" + (i+1));
                System.out.print("Before shifting to the left: ");
                PrintArray(array, i);
            }
            for (j=i-1;j>=0;j--)
            {
                boolean shouldShift;
                if (descendingSort)
                {
                    shouldShift = array[j] < currentNumber;
                }
                else
                {
                    shouldShift = array[j] > currentNumber;
                }
                if (shouldShift)
                {
                    array[j+1] = array[j];
                }
                else
                {
                    break;
                }
            }
            array[j+1] = currentNumber;
            if (traceIntermediateResults)
            {
                System.out.print("After shifting to the left: ");
                PrintArray(array, j+1);
                System.out.println("-----------------------------");
            }
        }
        if (traceIntermediateResults)
        {
            System.out.print("The final array after sorting is: ");
            PrintArray(array);
        }
    }
}
