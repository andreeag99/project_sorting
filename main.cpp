#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <random>
#include <chrono>
#include <functional>
#include <algorithm>


//1.INSERTION SORT
std::vector<int>insertionSort(int n, std::vector<int> &array) {
    if (n <= 1) {
        return array ;
    }
    int j, temp;
    int key;
    for (int i = 1; i < n; i++) {
        key = array[i];
        j = i - 1;
        while (j >= 0 && key < array[j]) {
            temp = array[j];
            array[j] = array[j + 1];
            array[j + 1] = temp;
            j--;
        }
    }
    return array;
}

//2.SELECTION SORT
std::vector<int> selectionSort(int n, std::vector<int> &array) {
    for (int ind = 0; ind < n; ind++) {
        int main_index = ind;
        for (int j = ind + 1; j < n; j++) {
            if (array[j] < array[main_index]) {
                main_index = j;
            }
        }
        std::swap(array[ind], array[main_index]);
    }
    return array;
}

//3.BUBBLE SORT
std::vector<int>bubbleSort(int n, std::vector<int> &arr) {
    bool swapped = false;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                swapped = true;
                std::swap(arr[j], arr[j + 1]);
            }
        }
        if (!swapped) {
            return arr;
        }
    }
    return arr;
}

//4.MERGE SORT
void merge(std::vector<int>& array, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    std::vector<int> L(n1);
    std::vector<int> R(n2);
    for (int i = 0; i < n1; i++) {
        L[i] = array[l + i];
    }
    for (int j = 0; j < n2; j++) {
        R[j] = array[m + 1 + j];
    }
    int i = 0;
    int j = 0;
    int k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            array[k] = L[i];
            i++;
        } else {
            array[k] = R[j];
            j++;
        }
        k++;
    }
    while (i < n1) {
        array[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        array[k] = R[j];
        j++;
        k++;
    }
}

std::vector<int> mergeSort(std::vector<int> &array, int l, int r) {
    if (l < r) {
        int m = l + (r - l) / 2;
        array = mergeSort(array, l, m);
        array = mergeSort(array, m + 1, r);
        merge(array, l, m, r);
    }
    return array;
}

//5.QUICK SORT
int partition(std::vector<int>& array, int low, int high)
{
    int pivot = array[high];
    int i = low - 1;

    for (int j = low; j <= high - 1; j++)
    {
        if (array[j] <= pivot)
        {
            i++;
            std::swap(array[i], array[j]);
        }
    }
    std::swap(array[i + 1], array[high]);
    return (i + 1);
}

void quickSort(std::vector<int>& array, int low, int high)
{
    if (low < high)
    {
        int pi = partition(array, low, high);

        quickSort(array, low, pi - 1);
        quickSort(array, pi + 1, high);
    }
}

//6.HEAP SORT
void heapify(std::vector<int>& array, int n, int i)
{
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && array[i] < array[l])
        largest = l;

    if (r < n && array[largest] < array[r])
        largest = r;

    if (largest != i)
    {
        std::swap(array[i], array[largest]);
        heapify(array, n, largest);
    }
}

std::vector<int>heapSort(std::vector<int>& array, int n)
{
    for (int i = n / 2 - 1; i >= 0; i--)
        heapify(array, n, i);

    for (int i = n - 1; i >= 0; i--)
    {
        std::swap(array[0], array[i]);
        heapify(array, i, 0);
    }
    return array;
}

//7.COUNTING SORT
std::vector<int> countSort(std::vector<int>& array,int value)
{
    std::vector<int> output(array.size());
    int max_val = value; //
    std::vector<int> count(max_val + 1, 0);

    for (int i = 0; i < array.size(); i++)
        count[array[i]]++;

    for (int i = 1; i <= max_val; i++)
        count[i] += count[i - 1];

    for (int i = array.size() - 1; i >= 0; i--)
    {
        output[count[array[i]] - 1] = array[i];
        count[array[i]]--;
    }


    for (int i = 0; i < array.size(); i++) {
        array[i] = output[i];
    }
    return array;
}

//8.RADIX SORT
std::vector<int> radixSort(std::vector<int>& arr)
{
    int max_val = *std::max_element(arr.begin(), arr.end());

    for (int exp = 1; max_val / exp > 0; exp *= 10)
        countSort(arr, max_val);
    return arr;
}

//10.SHELL SORT
std::vector<int> shellSort(std::vector<int>& arr, int n) {
    int temp, j;
    for (int gap = n / 2; gap > 0; gap /= 2) {
        for (int i = gap; i < n; i += 1) {
            temp = arr[i];
            for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                arr[j] = arr[j - gap];
            }
            arr[j] = temp;
        }
    }
    return arr;
}


//11.COCKTAIL SORT
std::vector<int> cocktailSort(std::vector<int>& arr, int n) {
    bool swapped = true;
    int start = 0;
    int end = n - 1;

    while (swapped) {
        swapped = false;
        for (int i = start; i < end; ++i) {
            if (arr[i] > arr[i + 1]) {
                std::swap(arr[i], arr[i + 1]);
                swapped = true;
            }
        }

        if (!swapped) break;

        swapped = false;
        --end;

        for (int i = end - 1; i >= start; --i) {
            if (arr[i] > arr[i + 1]) {
                std::swap(arr[i], arr[i + 1]);
                swapped = true;
            }
        }

        ++start;
    }
    return arr;
}


//12.PANCAKE SORT
void flip(std::vector<int>& arr, int idx) {
    int i = 0, j = idx;
    while (i < j) {
        std::swap(arr[i], arr[j]);
        i++;
        j--;
    }
}

int findMaxIndex(std::vector<int>& arr, int end_idx) {
    int max_idx = 0;
    for (int i = 1; i <= end_idx; i++) {
        if (arr[i] > arr[max_idx]) {
            max_idx = i;
        }
    }
    return max_idx;
}

std::vector<int> pancakeSort(std::vector<int>& arr) {
    int n = arr.size();
    for (int i = n - 1; i >= 0; i--) {
        int max_idx = findMaxIndex(arr, i);
        if (max_idx != i) {
            flip(arr, max_idx);
            flip(arr, i);
        }
    }
    return arr;
}



//TIME
template<typename Func, typename... Args>
std::chrono::duration<float> measureExecutionTime(Func&& func, Args&&... args)
{
    auto start = std::chrono::high_resolution_clock::now();
    std::forward<Func>(func)(std::forward<Args>(args)...);
    auto end = std::chrono::high_resolution_clock::now();

    std::chrono::duration<float, std::milli> elapsed = end - start;
    //std::cout << "Elapsed time: " << elapsed.count() << " nanoseconds\n";

    return elapsed;
}

//RANDOM ARRAY GENERATOR
std::vector<int> generateRandomList(int n, int max_value) {
    std::vector<int> result;

    while (result.size() < n) {
        result.push_back(rand() % (max_value));
    }
    return result;
}



//SORTED ARRAY GENERATOR
std::vector<int> generate_sorted_list(int length, int max_number) {
    std::vector<int> result;
    std::srand(std::time(nullptr));

    while (result.size() < length) {
        result.push_back(std::rand() % (max_number + 1));
    }

    std::sort(result.begin(), result.end());
    return result;
}



//DECREASING SORTED ARRAY GENERATOR
std::vector<int> generate_decreasing_sorted_list(int length, int max_number) {
    std::vector<int> result;
    srand(time(nullptr));
    while (result.size() < length) {
        result.push_back(rand() % (max_number + 1));
    }
    std::sort(result.begin(), result.end(), std::greater<int>());

    return result;
}

void alg_menu(void){
    std::cout<<"Choose the sorting algorithm"<<std::endl;
    std::cout<<"1.Insertion sort"<<std::endl;
    std::cout<<"2.Selection sort"<<std::endl;
    std::cout<<"3.Bubble sort"<<std::endl;
    std::cout<<"4.Merge sort"<<std::endl;
    std::cout<<"5.Quick sort"<<std::endl;
    std::cout<<"6.Heap sort"<<std::endl;
    std::cout<<"7.Count sort"<<std::endl;
    std::cout<<"8.Radix sort"<<std::endl;
    std::cout<<"9.Pancake sort"<<std::endl;
    std::cout<<"10.Shell sort"<<std::endl;
    std::cout<<"11.Cocktail sort"<<std::endl;


}

int main() {

    std::vector<int> arr;
    int n = 0, m = 0, number_elem, max_value = 1000000;
    while(m < 13) {

        bool dir = true;
        std::chrono::duration<float> total_time = std::chrono::duration<float>::zero();
        std::chrono::duration<float, std::milli> avg_time;

        // calling menu
        alg_menu();
        std::cin>>m;
        switch (m) {
            // INSERTION SORT
            case 1:

                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(insertionSort, number_elem, arr);
                        }
                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(insertionSort, number_elem, arr);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(insertionSort, number_elem, arr);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // SELECTION SORT
            case 2:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(selectionSort, number_elem, arr);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(selectionSort, number_elem, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(selectionSort, number_elem, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // BUBBLE SORT
            case 3:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(bubbleSort, number_elem, arr);;
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(bubbleSort, number_elem, arr);;
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(bubbleSort, number_elem, arr);;
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // MERGE SORT
            case 4:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(mergeSort, arr, 0, arr.size() - 1);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(mergeSort, arr, 0, arr.size() - 1);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(mergeSort, arr, 0, arr.size() - 1);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // QUICK SORT
            case 5:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(quickSort, arr, 0, arr.size() - 1);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(quickSort, arr, 0, arr.size() - 1);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(quickSort, arr, 0, arr.size() - 1);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // HEAP SORT
            case 6:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(heapSort, arr, number_elem);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(heapSort, arr, number_elem);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(heapSort, arr, number_elem);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // COUNTING SORT
            case 7:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 3; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(countSort, arr, max_value);
                        }
                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(countSort, arr, max_value);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(countSort, arr, max_value);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // RADIX SORT
            case 8:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(radixSort, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(radixSort, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(radixSort, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // PANCAKE SORT
            case 9:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(pancakeSort, arr);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(pancakeSort, arr);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(pancakeSort, arr);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // SHELL SORT
            case 10:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(shellSort, arr, number_elem);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(shellSort, arr, number_elem);
                        }

                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(shellSort, arr, number_elem);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;

            // COCKTAIL SORT
            case 11:
                std::cout << "Choose the kind of array you want to sort" << std::endl;
                std::cout << "1.Unsorted " << std::endl;
                std::cout << "2.Decreasing sorted" << std::endl;
                std::cout << "3.Sorted" << std::endl;
                std::cout << "4.Go back" << std::endl;
                std::cin >> n;
                switch (n) {
                    case 1:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generateRandomList(number_elem, max_value);
                            total_time += measureExecutionTime(pancakeSort, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;
                        break;

                    case 2:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_decreasing_sorted_list(number_elem, max_value);;
                            total_time += measureExecutionTime(pancakeSort, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " milliseconds" << std::endl;

                        break;
                    case 3:
                        std::cout << "Enter number of elements in array" << std::endl;
                        std::cin >> number_elem;
                        srand(time(nullptr));

                        for (int i = 0; i < 100; ++i) {
                            arr = generate_sorted_list(number_elem, max_value);
                            total_time += measureExecutionTime(pancakeSort, arr);
                        }


                        avg_time = total_time / 100;
                        std::cout << "\nAverage time: " << avg_time.count() << " millisconds" << std::endl;
                        break;
                    case 4:
                        break;
                    default:
                        std::cout << "Invalid action" << std::endl;
                        break;
                }
                break;
        }
    }
    return 0;
}
