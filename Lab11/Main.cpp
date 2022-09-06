#include "sort.h"
#include "randVec.h"
#include "inversions.h"
#include "revVec.h"
#include "sortVec.h"

int main()
{
	//these variables are used in calculating the time it takes for an operation to occur
	long long startTime;
	long long endTime;
	long long tl;//tl means total time

	bool check = true;//boolean that is used to keep user entering sizes and seeds untill they want to be done
	while (check == true)
	{
		int size, seed;
		cout << "How large of a list would you like to create? (Enter a number that is below 1 to end the program) :";
		cin >> size;
		if (size < 1)
		{
			check = false;//is set to false so loop and conditions inside it aren't met
		}
		if (check != false)
		{
		cout << "What random seed would you like to use? :";
		cin >> seed;
		cout << endl;

			/*Here are our initial instantiations of each of our vectors.
			vec is our random vector and the other to are self named as well as the functions.*/
			vector<int> vec = randVec(size, seed);
			vector<int> reverseVec;
			reverseVec.resize(size);
			vector<int> sortedVec;
			sortedVec.resize(size);
			reverseVec = revVec(0, reverseVec);
			sortedVec = sortVec(sortedVec);


			/*Now, these long blocks of code are all pretty identical, the only real thing changing
			is the type of sort used and on what list it was used on. By breaking down this first bit 
			the rest is explained as well.*/

			//RANDOM VECTOR
			cout << "Total inversions in the original list " << inversions(vec) << endl;//we print out what list it is and its inversions, calling inversions on the corresponding vector
			startTime = getTime();//gets time before sort
			insertionSort(vec);//calls one of the sort functions
			 endTime = getTime();//gets time afterward
			tl = endTime - startTime;//finds total time between before and after call
			cout << "Insertion sort time " << tl << endl;//tells user which sort we used and time it took
			cout << "Total inversions after insertion sort " << inversions(vec) << endl;//shows amount of inversions afterward
			vec = randVec(size, seed);//resets the vector
			cout << endl;//goes on to the next sort (Sort types done right to left according to the report)

			cout << "Total inversions in the original list " << inversions(vec) << endl;
			startTime = getTime();
			mergeSort(vec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Merge sort time " << tl << endl;
			cout << "Total inversions after merge sort " << inversions(vec) << endl;
			vec = randVec(size, seed);
			cout << endl;

			cout << "Total inversions in the original list " << inversions(vec) << endl;
			startTime = getTime();
			shellsort(vec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Shell sort time " << tl << endl;
			cout << "Total inversions after shell sort " << inversions(vec) << endl;
			vec = randVec(size, seed);
			cout << endl;

			cout << "Total inversions in the original list " << inversions(vec) << endl;
			startTime = getTime();
			quicksort(vec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Quick sort time " << tl << endl;
			cout << "Total inversions after quick sort " << inversions(vec) << endl;
			vec = randVec(size, seed);
			cout << endl;

			cout << "Total inversions in the original list " << inversions(vec) << endl;
			startTime = getTime();
			heapsort(vec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Heap sort time " << tl << endl;
			cout << "Total inversions after quick heap sort " << inversions(vec) << endl;
			cout << endl;




			//REVERSE VECTOR

			cout << "Total inversions in the worst case list " << inversions(reverseVec) << endl;
			startTime = getTime();
			insertionSort(reverseVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Insertion sort time " << tl << endl;
			cout << "Total inversions after insertion sort " << inversions(reverseVec) << endl;
			reverseVec = revVec(0, reverseVec);
			cout << endl;

			cout << "Total inversions in the worst case list " << inversions(reverseVec) << endl;
			startTime = getTime();
			mergeSort(reverseVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Merge sort time " << tl << endl;
			cout << "Total inversions after merge sort " << inversions(reverseVec) << endl;
			reverseVec = revVec(0, reverseVec);
			cout << endl;

			cout << "Total inversions in the worst case list " << inversions(reverseVec) << endl;
			startTime = getTime();
			shellsort(reverseVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Shell sort time " << tl << endl;
			cout << "Total inversions after shell sort " << inversions(reverseVec) << endl;
			reverseVec = revVec(0, reverseVec);
			cout << endl;

			cout << "Total inversions in the worst case list " << inversions(reverseVec) << endl;
			startTime = getTime();
			quicksort(reverseVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Quick sort time " << tl << endl;
			cout << "Total inversions after quick sort " << inversions(reverseVec) << endl;
			reverseVec = revVec(0, reverseVec);
			cout << endl;

			cout << "Total inversions in the worst case list " << inversions(reverseVec) << endl;
			startTime = getTime();
			heapsort(reverseVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Heap sort time " << tl << endl;
			cout << "Total inversions after quick heap sort " << inversions(reverseVec) << endl;
			cout << endl;




			//SORTED VECTOR

			cout << "Total inversions in the best case list " << inversions(sortedVec) << endl;
			startTime = getTime();
			insertionSort(sortedVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Insertion sort time " << tl << endl;
			cout << "Total inversions after insertion sort " << inversions(sortedVec) << endl;
			sortedVec = sortVec(sortedVec);
			cout << endl;

			cout << "Total inversions in the best case list " << inversions(sortedVec) << endl;
			startTime = getTime();
			mergeSort(sortedVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Merge sort time " << tl << endl;
			cout << "Total inversions after merge sort " << inversions(sortedVec) << endl;
			sortedVec = sortVec(sortedVec);
			cout << endl;

			cout << "Total inversions in the best case list " << inversions(sortedVec) << endl;
			startTime = getTime();
			shellsort(sortedVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Shell sort time " << tl << endl;
			cout << "Total inversions after shell sort " << inversions(sortedVec) << endl;
			sortedVec = sortVec(sortedVec);
			cout << endl;

			cout << "Total inversions in the best case list " << inversions(sortedVec) << endl;
			startTime = getTime();
			quicksort(sortedVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Quick sort time " << tl << endl;
			cout << "Total inversions after quick sort " << inversions(sortedVec) << endl;
			sortedVec = sortVec(sortedVec);
			cout << endl;

			cout << "Total inversions in the best case list " << inversions(sortedVec) << endl;
			startTime = getTime();
			heapsort(sortedVec);
			endTime = getTime();
			tl = endTime - startTime;
			cout << "Heap sort time " << tl << endl;
			cout << "Total inversions after quick heap sort " << inversions(sortedVec) << endl;
			cout << endl;

		}
	} 
}