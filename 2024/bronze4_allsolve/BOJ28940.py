# chatGPT한테 번역해달라고 넣었더니, 이런 코드를 줌.

w, h = map(int, input().split())
n, a, b = map(int, input().split())

if a > w or b > h:
    print(-1)
else:
    lines_per_page = h // b
    letters_per_line = w // a
    letters_per_page = lines_per_page * letters_per_line
    total_pages = (n + letters_per_page - 1) // letters_per_page
    print(total_pages)