#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PAUSE do { fflush(stdin); getchar(); } while(0)

#define MAXURLLEN 1000


void display_menu(char *curr_page)
{
	static const char *menu[] = {
		"0. 프로그램 종료",
		"1. URL 입력",
		"2. 방문 기록 보기",
		"3. 뒤로 가기",
		"4. 앞으로 가기",
		"5. 방문 기록 보기(오름차순)", };
	int i;

	printf("\n------------------------------\n");
	if (strlen(curr_page) == 0)
		printf(">> 현재 페이지: Home\n");
	else
		printf(">> 현재 페이지: %s\n", curr_page);
	for (i = 0; i < (sizeof(menu) / sizeof(menu[0])); i++) {
		printf("%s\n", menu[i]);
	}
	printf("------------------------------\n");
}

int main(void)
{
	char *stk[MAXURLLEN];
	int now = -1;
	int max = -1;

	int no;
	char curr_page[MAXURLLEN] = { '\0', };

	setbuf(stdout, NULL);

	while (1) {
		display_menu(curr_page);
		printf("메뉴 선택: ");
		fflush(stdin);
		scanf("%d", &no);

		switch (no) {
		case 0: // 프로그램 종료
			exit(0);
			break;
		case 1: // URL 접속
			printf("input url : ");

			getchar();
			fflush(stdin);

			char url[MAXURLLEN];
			
			fgets(url, MAXURLLEN, stdin);
			url[strlen(url)-1] = '\0';
			printf("%s : %d\n", url, now + 1);

			stk[++now] = (char *)malloc(sizeof(char) * MAXURLLEN);
			strcpy(stk[now], url);
			max++;

			printf("%s %s", stk[now], url);

			break;
		case 2: // 방문 기록 보기
			for(int i = 0; i <= max; i++) 
				printf("%d : %s\n", i, stk[i]);

			break;
		case 3: // 뒤로 가기
			if(now > 0) now--;
			break;
		case 4: // 앞으로 가기
			if(now < max) now++;
			break;
		case 5: // 방문 기록 보기(오름차순)
			{
				char *tmpstk[MAXURLLEN];
				char tmp[MAXURLLEN];
				for(int i = 0; i <= max; i++) {
					tmpstk[i] = (char *)malloc(sizeof(char) * MAXURLLEN);
					strcpy(tmpstk[i], stk[i]);
				}

				for(int i = 0; i < now; i++) {
					for(int j = i+1; j <= now; j++) {
						if(strcmp(tmpstk[i], tmpstk[j]) > 0) {
							strcpy(tmp, tmpstk[i]);
							strcpy(tmpstk[i], tmpstk[j]);
							strcpy(tmpstk[j], tmp);
						}
					}
				}

				for(int i = 0; i <= max; i++) printf("%d : %s\n", i, tmpstk[i]);
				break;
			}
		}
	}

	return 0;
}
