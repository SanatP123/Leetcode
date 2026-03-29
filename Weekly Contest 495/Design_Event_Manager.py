import heapq
class EventManager:

    def __init__(self, events: list[list[int]]):
        # Track events
        self.event_map = {}
        # Track candidates for highest priority
        self.heap = []

        for event_id, priority in events:
            self.event_map[event_id] = priority
            # Negative priority for max heap implementation
            heapq.heappush(self.heap, (-priority, event_id))
        

    def updatePriority(self, eventId: int, newPriority: int) -> None:
        # Update priorities in the map and the heap
        self.event_map[eventId] = newPriority
        heapq.heappush(self.heap, (-newPriority, eventId))

    def pollHighest(self) -> int:
        # Loop through the heap
        while self.heap:

            # Pop the highest priority value and check if it exists in the map
            neg_priority, event_id = heapq.heappop(self.heap)

            if event_id in self.event_map and self.event_map[event_id] == -neg_priority:
                # If it exists remove the value and return the id
                del self.event_map[event_id]
                return event_id
            else:
                continue
        # If there are no active events
        return -1
        


s = EventManager([[5, 7], [2, 7], [9, 4]])
print(s.pollHighest()) # 2
s.updatePriority(9, 7)
print(s.pollHighest()) # 5
print(s.pollHighest()) # 9  

# Your EventManager object will be instantiated and called as such:
# obj = EventManager(events)
# obj.updatePriority(eventId,newPriority)
# param_2 = obj.pollHighest()



# class EventManager:
#     def __init__(self, events: list[list[int]]):
#         self.event_map = {}
#         for event_id, priority in events:
#             self.event_map[event_id] = priority
        

#     def updatePriority(self, eventId: int, newPriority: int) -> None:
#         self.event_map[eventId] = newPriority


#     def pollHighest(self) -> int:
#         if not self.event_map:
#             return -1
#         highest = max(self.event_map, key = lambda x : (self.event_map[x], -x))
#         del self.event_map[highest]
#         return highest


# # Your EventManager object will be instantiated and called as such:
# # obj = EventManager(events)
# # obj.updatePriority(eventId,newPriority)
# # param_2 = obj.pollHighest()