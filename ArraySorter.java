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

    private void PrintInitialMessage(int[] array, String sortingAlgorithmName, boolean descendingSort)
    {
        String sortOrder = descendingSort ? "descending" : "ascending";
        System.out.print("Is about to sort this array using " + sortingAlgorithmName + " sort by " + sortOrder + " order: ");
        PrintArray(array);
    }

    private void PrintTerminalMessage(int[] array)
    {
        System.out.print("The final array after sorting is: ");
        PrintArray(array);
    }


    public void SortByInsertionSort(int[] array, boolean descendingSort, boolean traceIntermediateResults)
    {
        if (traceIntermediateResults)
        {
            PrintInitialMessage(array,"insertion", descendingSort);
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
                System.out.println();
            }
        }
        if (traceIntermediateResults)
        {
            PrintTerminalMessage(array);
        }
    }

    public void SortBySelectionSort(int[] array, boolean descendingSort, boolean traceIntermediateResults)
    {
        if (traceIntermediateResults)
        {
            PrintInitialMessage(array, "selection", descendingSort);
        }
        for (int i=0;i<array.length-1;i++)
        {
            if (traceIntermediateResults)
            {
                System.out.println("Element #" + (i+1));
                PrintArray(array, i);
            }
            int currentNumber = array[i];
            int swapElement = currentNumber;
            int swapIndex = i;
            for (int j = i+1;j<array.length;j++)
            {
                boolean shouldSwap;
                if (descendingSort)
                {
                    shouldSwap = array[j] > swapElement;
                }
                else
                {
                    shouldSwap = array[j] < swapElement;
                }
                if (shouldSwap)
                {
                    swapElement = array[j];
                    swapIndex = j;
                }
            }
            if (traceIntermediateResults)
            {
                System.out.println("Found swap element: ");
                PrintArray(array, swapIndex);
            }
            array[i] = swapElement;
            array[swapIndex] = currentNumber;
            if (traceIntermediateResults)
            {
                System.out.println("After swapping: ");
                PrintArray(array);
                System.out.println();
            }
        }
        if (traceIntermediateResults)
        {
            PrintTerminalMessage(array);
        }
    }

}
