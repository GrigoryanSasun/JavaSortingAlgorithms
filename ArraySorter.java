/**
 * Created by Grigoryan on 18.09.2016.
 */
public class ArraySorter {

    private void PrintArray(int[] array, int lowerIndex, int upperIndex, int highlightedItemIndex)
    {
        for (int i=lowerIndex;i<=upperIndex;i++)
        {
            if (i == highlightedItemIndex)
            {
                System.out.print("->");
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


    private void PrintArray(int[] array, int highlightedItemIndex)
    {
        PrintArray(array, 0, array.length-1, highlightedItemIndex);
    }

    private void PrintArray(int[] array)
    {
        PrintArray(array, -1);
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

    public void SortByBubbleSort(int[] array, boolean descendingSort, boolean traceIntermediateResults)
    {
        if (traceIntermediateResults)
        {
            PrintInitialMessage(array, "bubble", descendingSort);
        }
        for (int i=1;i<=array.length-1;i++)
        {
            if (traceIntermediateResults)
            {
                System.out.println("Pass #" + i);
            }
            boolean anySwapOccurred = false;
            for (int j=0;j<array.length-i;j++)
            {
                if (traceIntermediateResults)
                {
                    System.out.print("The current item in array: ");
                    PrintArray(array, j);
                }
                boolean shouldSwap;
                int current = array[j];
                int next = array[j+1];

                if (descendingSort)
                {
                    shouldSwap = current < next;
                }
                else
                {
                    shouldSwap = current > next;
                }
                if (shouldSwap)
                {
                    if (traceIntermediateResults)
                    {
                        System.out.println("Will be swapped with the next item");
                    }
                    anySwapOccurred = true;
                    array[j] = next;
                    array[j+1] = current;
                    if (traceIntermediateResults)
                    {
                        System.out.print("After swapping: ");
                        PrintArray(array, j+1);
                    }
                }
                else
                {
                    if (traceIntermediateResults)
                    {
                        System.out.println("Will NOT be swapped with the next item");
                    }
                }
            }
            if (!anySwapOccurred)
            {
                if (traceIntermediateResults)
                {
                    System.out.println("No swap occurred. So the array is already sorted.");
                }
                break;
            }
            System.out.println();
        }
        if (traceIntermediateResults)
        {
            PrintTerminalMessage(array);
        }
    }

    private void TraceWithLevel(String message, int level)
    {
        for (int i=1;i<=level;i++)
        {
            System.out.print("\t");
        }
        System.out.print(message);
    }

    private void TraceLineWithLevel(String message, int level)
    {
        TraceWithLevel(message, level);
        System.out.println();
    }


    private void MergeSort(int[] array, int lowerIndex, int upperIndex, boolean descendingSort, boolean tracingEnabled, int level)
    {
        if (lowerIndex < upperIndex)
        {
            int middleIndex = (lowerIndex + upperIndex) / 2;
            if (tracingEnabled)
            {
                TraceWithLevel("Got the following array: ", level);
                PrintArray(array, lowerIndex, upperIndex, -1);
                TraceLineWithLevel("Will divide into following two arrays:", level);
                TraceWithLevel("Left array: ", level);
                PrintArray(array, lowerIndex, middleIndex,-1);
                TraceWithLevel("Right array: ", level);
                PrintArray(array, middleIndex + 1, upperIndex,-1);
            }
            MergeSort(array, lowerIndex, middleIndex, descendingSort, tracingEnabled, level+1);
            MergeSort(array, middleIndex + 1, upperIndex, descendingSort, tracingEnabled, level+1);

            int[] leftArray = new int[middleIndex - lowerIndex + 2];
            int[] rightArray = new int[upperIndex - middleIndex + 1];
            int i;
            for (i = lowerIndex; i <= middleIndex; i++)
            {
                leftArray[i - lowerIndex] = array[i];
            }
            leftArray[i - lowerIndex] = descendingSort ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            for (i = middleIndex + 1; i <= upperIndex; i++)
            {
                rightArray[i - middleIndex - 1] = array[i];
            }
            rightArray[i - middleIndex - 1] = descendingSort ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            if (tracingEnabled)
            {
                TraceLineWithLevel("After being sorted:", level);
                TraceWithLevel("Left array: ", level);
                PrintArray(leftArray,0, leftArray.length-2, -1);
                TraceWithLevel("Right array: ", level);
                PrintArray(rightArray,0, rightArray.length-2,-1);
            }

            int leftIndex = 0;
            int rightIndex = 0;
            for (i = lowerIndex; i <= upperIndex; i++)
            {
                int currentLeftElement = leftArray[leftIndex];
                int currentRightElement = rightArray[rightIndex];
                int elementToSet;

                if (currentLeftElement > currentRightElement)
                {
                    if (descendingSort)
                    {
                        elementToSet = currentLeftElement;
                        leftIndex++;
                    }
                    else
                    {
                        elementToSet = currentRightElement;
                        rightIndex++;
                    }
                }
                else
                {
                    if (descendingSort)
                    {
                        elementToSet = currentRightElement;
                        rightIndex++;
                    }
                    else
                    {
                        elementToSet = currentLeftElement;
                        leftIndex++;
                    }
                }
                array[i] = elementToSet;
            }
            if (tracingEnabled)
            {
                TraceWithLevel("After being merged: ", level);
                PrintArray(array, lowerIndex, upperIndex, -1);
                System.out.println();
            }
        }
    }


    public void SortByMergeSort(int[] array, boolean descendingSort, boolean traceIntermediateResults)
    {
        if (traceIntermediateResults)
        {
            PrintInitialMessage(array, "merge", descendingSort);
        }

        MergeSort(array, 0, array.length-1,descendingSort, traceIntermediateResults, 0);

        if (traceIntermediateResults)
        {
            PrintTerminalMessage(array);
        }
    }


}
