import random
import time


# INSERTION SORT
def insertionSort(array):
    n = len(array)
    if(n <= 1):
        return
    for i in range(1, n):
        key = array[i]
        j = i - 1
        while j >= 0 and key < array[j]:
            temp = array[j]
            array[j] = array[j+1]
            array[j+1] = temp
            j -= 1
    return array



# SELECTION SORT
def selectionSort(array):
    for ind in range(len(array)):
        main_index = ind
        for j in range(ind + 1, len(array)):
            if array[j] < array[main_index]:
                main_index = j
        (array[ind], array[main_index]) = (array[main_index], array[ind])
    return array



# BUBBLE SORT
def bubbleSort(list):
    n = len(list)
    swapped = False
    for i in range(0, n-1):
        for j in range(0, n-i-1):
            if list[j]> list[j+1]:
                swapped = True
                list[j], list[j + 1] = list[j + 1], list[j]
    if not swapped:
        return
    return list;



# MERGE SORT
def merge(array, l, m, r):
    n1 = m - l + 1
    n2 = r - m
    L = [0] * (n1)
    R = [0] * (n2)
    for i in range(0, n1):
        L[i] = array[l + i]
    for j in range(0, n2):
        R[j] = array[m + 1 + j]
    i = 0
    j = 0
    k = l
    while i < n1 and j < n2:
        if L[i] <= R[j]:
            array[k] = L[i]
            i += 1
        else:
            array[k] = R[j]
            j += 1
        k += 1
    while i < n1:
        array[k] = L[i]
        i += 1
        k += 1
    while j < n2:
        array[k] = R[j]
        j += 1
        k += 1
def mergeSort(array, l, r):
    if l < r:
        m = l+(r-l)//2
        mergeSort(array, l, m)
        mergeSort(array, m+1, r)
        merge(array, l, m, r)
    return array



# QUICK SORT
def partition(array, low, high):
    pivot = array[high]
    i = low - 1
    for j in range(low, high):
        if array[j] <= pivot:
            i += 1
            (array[i], array[j]) = (array[j], array[i])

    (array[i+1], array[high]) = (array[high], array[i+1])
    return i + 1
def quickSort(array, low, high):
    if low < high:
        pi = partition(array, low, high)
        quickSort(array,low, pi - 1)
        quickSort(array, pi + 1, high)

    return array


# HEAP SORT
def heapify(array, n, i):
    largest = i
    l = 2 * i + 1
    r = 2 * i + 2
    if l < n and array[i] < array[l]:
        largest = l
    if r < n and array[largest] < array[r]:
        largest = r
    if largest != i:
        (array[i], array[largest]) = (array[largest], array[i])
        heapify(array, n, largest)
def heapSort(array):
    n = len(array)
    for i in range( n // 2 -1, -1, -1):
        heapify(array, n, i)
    for i in range(n - 1, 0, -1):
        (array[i], array[0]) = (array[0], array[i])
        heapify(array, i, 0)

    return array



# COUNTING SORT
def countSort(array):
    size = len(array)
    output = [0] * size

    count = [0] * (max(array) + 1)

    for i in range(0, size):
        count[array[i]] += 1

    for i in range(1, len(count)):
        count[i] += count[i - 1]

    i = size - 1
    while i >= 0:
        output[count[array[i]] - 1] = array[i]
        count[array[i]] -= 1
        i -= 1


    for j in range(0, size):
        array[j] = output[j]

    return array



# Radix Sort
def radixSort(arr):
    max1 = max(arr)
    exp = 1

    while max1 // exp > 0:
        countSort(arr)
        exp *= 10
    return arr







# PANCAKE SORT
def flip(arr, idx):
    i, j = 0, idx
    while i < j:
        arr[i], arr[j] = arr[j], arr[i]
        i += 1
        j -= 1



# SHELL SORT
def shellSort(arr, n):
    for gap in range(n//2, 0, -1):
        for i in range(gap, n):
            temp = arr[i]
            j = i
            while j >= gap and arr[j-gap] > temp:
                arr[j] = arr[j-gap]
                j -= gap
            arr[j] = temp
    return arr


# COCKTAIL SORT
def cocktailSort(arr, n):
    swapped = True
    start = 0
    end = n - 1

    while swapped:
        swapped = False
        for i in range(start, end):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = True

        if not swapped:
            break

        swapped = False
        end -= 1

        for i in range(end - 1, start - 1, -1):
            if arr[i] > arr[i + 1]:
                arr[i], arr[i + 1] = arr[i + 1], arr[i]
                swapped = True

        start += 1

    return arr



# PANCAKE SORT
def findMaxIndex(arr, end_idx):
    max_idx = 0
    for i in range(1, end_idx+1):
        if arr[i] > arr[max_idx]:
            max_idx = i
    return max_idx
def pancakeSort(arr):
    n = len(arr)
    for i in range(n-1, -1, -1):
        max_idx = findMaxIndex(arr, i)
        if max_idx != i:
            flip(arr, max_idx)
            flip(arr, i)
    return arr



# RANDOM ARRAY
def generate_random_list(length, max_value):
    # create an empty list
    result = []

    # add random numbers to the list until it reaches the desired length
    while len(result) < length:
        result.append(random.randint(0, max_value))  # generate a random number between 0 and 100

    return result



# SORTED ARRAY
def generate_sorted_list(lenght, max_value):
    result = []
    while len(result) < lenght:
        result.append(random.randint(0, max_value))
    result.sort()
    return result





# DEACREASING SORTED ARRAY
def generate_decreasing_sorted_list(lenght, max_value):
    result = []
    while len(result) < lenght:
        result.append(random.randint(0, max_value))
    result.sort(reverse = True)
    return result



#TIME FUNCTION
def measure_execution_time(func, *args, **kwargs):
    start_time = time.perf_counter()
    func(*args, **kwargs)
    end_time = time.perf_counter()
    elapsed_time = (end_time - start_time)*1000

    return elapsed_time