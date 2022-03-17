def max_number(a: list, n: int, m: int, k: int) -> int:
    a.sort(reverse=True)
    # a = [6, 5, 4, 4, 2]
    check_num = m
    check_flag = True
    sum = 0

    if (a[0] == a[1]) or (m <= k):
        return (a[0] * m)

    while check_num - k > 0:
        if check_flag == True:
            sum = sum + (a[0] * k)
            check_flag = False
            check_num = check_num - k

        else:
            sum = sum + (a[1] * 1)
            check_flag = True
            check_num = check_num - 1

    if check_num == 0:
        return sum

    else:
        if check_flag == True:
            sum = sum + (a[0] * check_num)

        else:
            while check_num > 0:
                sum = sum + a[1]
                check_num = check_num - 1

        return sum


n = 5
m = 8
k = 3
a = [2, 4, 5, 4, 6]

num = max_number(a, n, m, k)
print(num)

