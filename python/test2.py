from collections import deque


def solution(s1, s2, k):
    result = []
    answer = []

    v = ord(max(max(s1), max(s2))) - ord('A') + 1
    indegree = [0] * (v + 1)
    graph = [[] for _ in range(v + 1)]
    k_num = ord(k) - ord('A') + 1

    use = [False for _ in range(v + 1)]

    for i in range(len(s1)):
        a = ord(s1[i]) - ord('A') + 1
        b = ord(s2[i]) - ord('A') + 1
        graph[a].append(b)

        indegree[b] += 1

    stack = []

    for i in range(1, v + 1):

        if i == k_num:
            use[i] = True
            continue

        if graph[i]:
            for j in graph[i]:
                stack.append(j)
            while stack:
                top = stack.pop()

                if top == k_num:
                    use[i] = True
                    break
                for k in graph[top]:
                    stack.append(k)

    q = deque()

    for i in range(1, v + 1):
        if indegree[i] == 0 and use[i]:
            q.append(i)

    while q:
        now = q.popleft()

        result.append(now)

        for i in graph[now]:
            indegree[i] -= 1

            if indegree[i] == 0:
                q.append(i)

    for i in result:
        answer.append(chr(i + ord('A') - 1))

    return answer


print(solution(["A", "E", "B", "D", "B", "H", "F", "H", "C"], ["G", "C", "G", "F", "J", "E", "B", "F", "B"], 'B'))

# answer
# ["D", "H", "E", "C", "F", "B"]
