package Level3;

/**
WHAT?
In a city, year of birth/death of people who were born and died between year 1900 to 2000 are given. Write an algorithm to find the year in which max people were alive.
Assume that there two arrays: one contains year of birth and another array contains year of death. Other details like name, place, etc are ignored. The arrays contain only years. So input will be two integer arrays. Each array size will vary depending on the number people were born and died between 1900 and 2000.


HOW?
1. get the birth and death list
2. create new array of size 101( for counting people year wise 1900-2000) - PEOPLECNT[]
3. iterate birth list and increment corresponding year count - PEOPLECNT[year-1900]++
4. iterate death list and decrement corresponding year count - PEOPLECNT[year-1900]--
5. iterate PEOPLECNT and find max count and corresponding year.
6. print max year
7. done
*/

public class MaxAlive {

	public static int findMaxAlive(int[] birthList, int[] deathList) {
		int aliveCnt = 0;
		int maxCnt = 0;
		int maxYear = 1900;
		int[] peopleCnt = new int[2000-1900+1];

		for(int i=0; i<birthList.length; i++) {
			peopleCnt[ birthList[i] - 1900]++;
		}

		for(int i=0; i<deathList.length; i++) {
			peopleCnt[ birthList[i] - 1900]--;
		}


		for(int i=0; i<peopleCnt.length; i++) {
			aliveCnt = aliveCnt + peopleCnt[i];
			System.out.format("%d : %d\n", (1900+i), aliveCnt);
			if( aliveCnt > maxCnt ) {
				maxCnt = aliveCnt;
				maxYear = 1900 + i;
			}
		}
		return maxYear;
	}

	public static void main(String[] args) {
		int[] birthList = { 1934, 1960, 1934, 1944, 1934, 1910,1934, 1990, 1980,1934};
		int[] deathList = { 1960, 1950, 1940, 1940, 1930, 1935 };
		System.out.println(findMaxAlive(birthList, deathList));
	}
}
