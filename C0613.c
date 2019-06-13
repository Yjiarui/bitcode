#include<stdio.h>
#include<math.h>
int main()
{
	int num, i, k;
	for (num = 101; num<=200; num++)
	{
		k == sqrt(num);
		for (i = 2; i<=k; i++)
		{
			if (num%i == 0)break;
			if (i>=k+1)
			{
				printf("%d", num);
			}
		}
	}
    return 0;
}