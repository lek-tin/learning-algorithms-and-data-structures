import heapq

class Solution:
    def kClosest(self, points, k):
        # max heap: top of the heap is the max element
        pq = []
        N = len(points)

        for i in range(N):
            point = points[i]
            dist = self.calcDistance(point)
            heapq.heappush(pq, (-dist, i))

            if len(pq) > k:
                heapq.heappop(pq)

        res = [points[heapq.heappop(pq)[1]] for _ in range(k)]
        return res

    def calcDistance(self, point):
        return point[0] ** 2 + point[1] ** 2
