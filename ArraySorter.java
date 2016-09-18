/**
 * Created by Grigoryan on 18.09.2016.
 */
public class ArraySorter {

    /**
     * This method is used to print a subset of an array of integers in one line
     * @param array the array of integers to print
     * @param lowerIndex  the lower inclusive index for the items to be printed
     * @param upperIndex the upper inclusive index for the items to be printed
     * @param highlightedItemIndex the item index which will be highlighted when printed
     * @return void
     */
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

    /**
     * This method is used to print the whole array of integers in one line
     * @param array the array of integers to print
     * @param highlightedItemIndex the item index which will be highlighted when printed
     * @return void
     */
    private void PrintArray(int[] array, int highlightedItemIndex)
    {
        PrintArray(array, 0, array.length-1, highlightedItemIndex);
    }

    /**
     * This method is used to print the whole array of integers in one line without highlighting any of them
     * @param array the array of integers to print
     * @return void
     */
    private void PrintArray(int[] array)
    {
        PrintArray(array, -1);
    }

    /**
     * This method is used to print the initial message for the sorting algorithms
     * @param array the array of integers to sort
     * @param sortingAlgorithmName the algorithm name which will be used for sorting
     * @param descendingSort whether will be sorted by descending order
     * @return void
     */
    private void PrintInitialMessage(int[] array, String sortingAlgorithmName, boolean descendingSort)
    {
        String sortOrder = descendingSort ? "descending" : "ascending";
        System.out.print("Is about to sort this array using " + sortingAlgorithmName + " sort by " + sortOrder + " order: ");
        PrintArray(array);
    }

    /**
     * This method is used to print the terminal message for the sorting algorithms
     * @param array the array of integers to sort
     * @return void
     */
    private void PrintTerminalMessage(int[] array)
    {
        System.out.print("The final array after sorting is: ");
        PrintArray(array);
    }


    /**
     * This method is used to sort the array in place using the insertion sort algorithm
     * @param array the array of integers to sort
     * @param descendingSort whether will be sorted by descending order
     * @param traceIntermediateResults whether intermediate results will be traced
     * @return void
     */
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

    /**
     * This method is used to sort the array in place using the selection sort algorithm
     * @param array the array of integers to sort
     * @param descendingSort whether will be sorted by descending order
     * @param traceIntermediateResults whether intermediate results will be traced
     * @return void
     */
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

    /**
     * This method is used to sort the array in place using the bubble sort algorithm
     * @param array the array of integers to sort
     * @param descendingSort whether will be sorted by descending order
     * @param traceIntermediateResults whether intermediate results will be traced
     * @return void
     */
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

    /**
     * This method is used to trace a message prepended with appropriate number of tabs
     * @param message the message to trace
     * @param level the number of tabs that will be prepended to the message
     * @return void
     */
    private void TraceWithLevel(String message, int level)
    {
        for (int i=1;i<=level;i++)
        {
            System.out.print("\t");
        }
        System.out.print(message);
    }

    /**
     * This method is used to trace a message with a new line prepended with appropriate number of tabs
     * @param message the message to trace
     * @param level the number of tabs that will be prepended to the message
     * @return void
     */
    private void TraceLineWithLevel(String message, int level)
    {
        TraceWithLevel(message, level);
        System.out.println();
    }

    /**
     * This method is used to recursively sort the array in place using the merge sort algorithm
     * @param array the array of integers to sort
     * @param lowerIndex the lower inclusive index for items which will be sorted
     * @param upperIndex the upper inclusive index for items which will be sorted
     * @param descendingSort whether will be sorted by descending order
     * @param tracingEnabled whether intermediate results will be traced
     * @param level the level of the call of the merge sort (used to properly indent the output from merge sort)
     * @return void
     */
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

    /**
     * The main merge sort method which will sort the array of integers in place
     * @param array the array of integers to sort
     * @param descendingSort whether will be sorted by descending order
     * @param traceIntermediateResults whether intermediate results will be trace
     * @return void
     */
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

    /**
     * This method is used to recursively sort the array in place using the quick sort algorithm
     * @param array the array of integers to sort
     * @param lowerIndex the lower inclusive index for items which will be sorted
     * @param upperIndex the upper inclusive index for items which will be sorted
     * @param descendingSort whether will be sorted by descending order
     * @param tracingEnabled whether intermediate results will be traced
     * @param level the level of the call of the merge sort (used to properly indent the output from merge sort)
     * @return void
     */
    private void QuickSort(int[] array, int lowerIndex, int upperIndex, boolean descendingSort, boolean tracingEnabled, int level)
    {
        if (lowerIndex < upperIndex)
        {
            if (tracingEnabled)
            {
                TraceWithLevel("Got the following array: ", level);
                PrintArray(array, lowerIndex, upperIndex, -1);
            }
            int finalPivotIndex = lowerIndex - 1;
            int pivot = array[upperIndex];
            for (int i=lowerIndex;i<=upperIndex;i++)
            {
                boolean shouldSwap;
                if (descendingSort)
                {
                    shouldSwap = array[i] >= pivot;
                }
                else
                {
                    shouldSwap = array[i] <= pivot;
                }
                if (shouldSwap)
                {
                    finalPivotIndex++;
                    int temp = array[i];
                    array[i] = array[finalPivotIndex];
                    array[finalPivotIndex] = temp;
                }
            }
            if (tracingEnabled)
            {
                TraceWithLevel("After partitioning the array: ", level);
                PrintArray(array, lowerIndex, upperIndex, finalPivotIndex);
            }

            QuickSort(array, lowerIndex, finalPivotIndex-1, descendingSort, tracingEnabled, level+1);
            QuickSort(array, finalPivotIndex+1, upperIndex, descendingSort, tracingEnabled, level+1);
            if (tracingEnabled)
            {
                TraceWithLevel("After sorting the subarrays: ", level);
                PrintArray(array, lowerIndex, upperIndex, finalPivotIndex);
                System.out.println();
            }
        }
    }

    /**
     * The main quick sort method which will sort the array of integers in place
     * @param array the array of integers to sort
     * @param descendingSort whether will be sorted by descending order
     * @param traceIntermediateResults whether intermediate results will be trace
     * @return void
     */
    public void SortByQuickSort(int[] array, boolean descendingSort, boolean traceIntermediateResults)
    {
        if (traceIntermediateResults) {
            PrintInitialMessage(array, "quick", descendingSort);
        }

        QuickSort(array, 0, array.length-1, descendingSort, traceIntermediateResults, 0);

        if (traceIntermediateResults)
        {
            PrintTerminalMessage(array);
        }
    }



}
