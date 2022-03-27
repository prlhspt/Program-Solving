from collections import deque


def solution(bridge_length, weight, truck_weights):
    answer = 0
    time = 1
    index = 0

    deq = deque()
    on_truck = deque()

    for i in truck_weights:
        deq.append([i, 0])

    remain_length = bridge_length - 1
    remain_weight = weight - deq[0][0]
    deq[0][1] = bridge_length
    on_truck.append(deq.popleft())

    while True:

        if not on_truck:
            break

        if on_truck[0][1] == time:
            remain_length = remain_length + 1
            remain_weight = remain_weight + on_truck[0][0]
            on_truck.popleft()

        if deq:
            if remain_length <= 0 or deq[0][0] > remain_weight:
                time = time + 1
            else:
                remain_length = remain_length - 1
                remain_weight = remain_weight - deq[0][0]
                deq[0][1] = time + bridge_length
                on_truck.append(deq.popleft())
                time = time + 1
        else:
            time = time + 1

    answer = time
    return answer


print(solution(2, 10, [7, 4, 5, 6]))
