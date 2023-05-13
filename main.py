import defs as d
import sys
sys.setrecursionlimit(1000000)
# import threading
# threading.stack_size(245760000) # Set stack size to 256 MB

print("choose sorting algorithm")
print("1.Insertion")
print("2.Selection")
print("3.Bubble")
print("4.Merge")
print("5.Quick")
print("6.Heap")
print("7.Counting")
print("8.Radix")
print("9.Pancake")
print("10.Shell")
print("11.Cocktail")


n = int(input("\nEnter number: "))
arr = []
max_value = 1000000

while(n < 13):

    # INSERTION SORT
    if n == 1:
        print("\nchoose the type of the array\n")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:

            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.insertionSort, arr))

                avg_time = float(sum_time/100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.insertionSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSE SORTED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.insertionSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # SELECTION SORT
    if n == 2:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.selectionSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.selectionSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.selectionSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # BUBBLE SORT
    if n == 3:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.bubbleSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            #SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.bubbleSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            #REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.bubbleSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # MERGE SORT
    if n == 4:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.mergeSort, arr,0, len(arr)-1))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.mergeSort, arr,0, len(arr)-1))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            #REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.mergeSort, arr,0, len(arr)-1))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 5:
                break

    # QUICK SORT
    if n == 5:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.quickSort, arr, 0, len(arr)-1))

                avg_time = float(sum_time / 3)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.quickSort, arr, 0, len(arr)-1))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.quickSort, arr, 0, len(arr)-1))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # HEAP SORT
    if n == 6:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.heapSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.heapSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    sum_time += float(d.measure_execution_time(d.heapSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # COUNTING SORT
    if n == 7:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.countSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.countSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.countSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # RADIX SORT
    if n == 8:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.radixSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.radixSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.radixSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # PANCAKE SORT
    if n == 9:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.pancakeSort, arr))

                avg_time = float(sum_time / 3)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.pancakeSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.pancakeSort, arr))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # SHELL SORT
    if n == 10:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.shellSort, arr, nr_elem))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.shellSort, arr, nr_elem))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.shellSort, arr, nr_elem))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break

    # COCKTAIL SORT
    if n == 11:
        print("choose the type of the array")
        print("1.Random")
        print("2.Sorted")
        print("3.Decreasing")
        m = int(input("\nEnter number: "))
        nr_elem = int(input("\nNumber of elements in the array: "))
        avg_time = 0
        sum_time = 0
        while m < 5:
            # RANDOM
            if m == 1:
                for i in range(0, 100):
                    arr = d.generate_random_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.cocktailSort, arr, nr_elem))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # SORTED
            if m == 2:
                for i in range(0, 100):
                    arr = d.generate_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.cocktailSort, arr, nr_elem))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            # REVERSED
            if m == 3:
                for i in range(0, 100):
                    arr = d.generate_decreasing_sorted_list(nr_elem, max_value)
                    #print(arr)
                    sum_time += float(d.measure_execution_time(d.cocktailSort, arr, nr_elem))

                avg_time = float(sum_time / 100)
                print(f"Elapsed time: {avg_time:.5f} milliseconds")
                #print(arr)
                break

            if m == 0:
                break


    if n == 0:
        break