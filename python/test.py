import heapq


def solution(jobs):
    answer = 0

    h = []

    heapq.heapify(jobs)

    one = heapq.heappop(jobs)

    index = 1
    while True:
        index += 1
        two = heapq.heappop(jobs)
        if one[1] > two[0]:
            heapq.heappush(h, two)
        else:
            heapq.heappush(jobs, two)
            break

        for i in range(len(h) - 1, 0, -1):





    return answer


jobs = [[0, 3], [1, 9], [2, 6], [3, 5], [4, 6]]
solution(jobs)
