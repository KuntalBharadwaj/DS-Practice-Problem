class Task implements Comparable<Task> {
    int userId, taskId, priority;

    Task(int userId, int taskId, int priority) {
        this.userId = userId;
        this.taskId = taskId;
        this.priority = priority;
    }

    @Override // priority queue me dalne ke liye check karna he
    public int compareTo(Task other) {
        if (this.priority != other.priority)
            return Integer.compare(other.priority, this.priority); // higher priority first
        return Integer.compare(other.taskId, this.taskId); // higher taskId first
    }
}

class TaskManager {
    Map<Integer, Task> taskMap = new HashMap<>();
    PriorityQueue<Task> pq = new PriorityQueue<>();

    public TaskManager(List<List<Integer>> tasks) {
        for (List<Integer> t : tasks) {
            add(t.get(0), t.get(1), t.get(2));
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority) {
        Task old = taskMap.get(taskId);
        pq.remove(old);

        Task updated = new Task(old.userId, taskId, newPriority);
        taskMap.put(taskId, updated);
        pq.offer(updated);
    }

    public void rmv(int taskId) {
        Task task = taskMap.remove(taskId);
        pq.remove(task);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Task top = pq.poll();
            if (taskMap.containsKey(top.taskId)) {
                taskMap.remove(top.taskId);
                return top.userId;
            }
        }
        return -1;
    }
}

/**
 * Your TaskManager object will be instantiated and called as such:
 * TaskManager obj = new TaskManager(tasks);
 * obj.add(userId,taskId,priority);
 * obj.edit(taskId,newPriority);
 * obj.rmv(taskId);
 * int param_4 = obj.execTop();
 */