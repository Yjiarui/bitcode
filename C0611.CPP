#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>
#include<stdlib.h>

void printlog(int data[], int size)
{
	int i=0;
	for (i = 0; i < size; i++)
	{
		printf("%d", data[i]);
	}
	printf("\n");
}

void init(int *data, int put[], int size)
{
	int i;
	for (i = 0; i < size; i++)
	{
		data[i] = put[i];
	}
}


void reserve(int data[], int size)
{
	int i, j, temp;
	for (i = 0, j = size - 1; i < j; i++, j--)
	{      
		temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}


void empty(int data[], int size)
{
	int i;
	for (i = 0; i < size; i++)
	{
		data[i] = 0;
	}
}

int main()
{ 
	int data[10] = { 0 };
	int input[100] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

	init(data, input, 10);
	printlog(data, 10);
	reserve(data, 10);
	printlog(data, 10);
	empty(data, 10);
	printlog(data, 10);
	system("pause");
	return 0;
}
