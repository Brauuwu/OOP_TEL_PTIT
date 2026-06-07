import java.util.*;

class EmptyStackException extends Exception {
    public EmptyStackException(String message) {
        super(message);
    }
}

class Stack<T> {
    private ArrayList<T> stack;

    public Stack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public T peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);
    }

    @Override
    public String toString() {
        return "Task [" + name + "] " + priority;
    }
}

class History implements Comparable<History> {
    private String action;

    public History(String action) {
        this.action = action;
    }

    @Override
    public int compareTo(History other) {
        return other.action.compareTo(this.action); // Z -> A
    }

    @Override
    public String toString() {
        return "History [" + action + "]";
    }
}

public class GENERIC005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Task> taskStack = new Stack<>();
        Stack<History> historyStack = new Stack<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.equals("exit")) {
                break;
            }

            if (line.startsWith("Task")) {
                int l = line.indexOf('[');
                int r = line.lastIndexOf(']');

                String name = line.substring(l + 1, r);
                if (name.endsWith(".")) {
                    name = name.substring(0, name.length() - 1);
                }

                int priority = Integer.parseInt(line.substring(r + 1).trim());

                taskStack.push(new Task(name, priority));
            } else if (line.startsWith("History")) {
                int l = line.indexOf('[');
                int r = line.lastIndexOf(']');

                String action = line.substring(l + 1, r);

                historyStack.push(new History(action));
            }
        }

        List<Task> tasks = new ArrayList<>();
        List<History> histories = new ArrayList<>();

        try {
            while (!taskStack.isEmpty()) {
                tasks.add(taskStack.pop());
            }

            while (!historyStack.isEmpty()) {
                histories.add(historyStack.pop());
            }
        } catch (EmptyStackException e) {
            // Không xảy ra do đã kiểm tra isEmpty()
        }

        Collections.sort(tasks);
        Collections.sort(histories);

        System.out.println("[Task Stack]");
        if (tasks.isEmpty()) {
            System.out.println("Không có công việc trong ngăn xếp.");
        } else {
            for (Task t : tasks) {
                System.out.println(t);
            }
        }

        System.out.println();
        System.out.println("[History Stack]");
        if (histories.isEmpty()) {
            System.out.println("Không có lịch sử trong ngăn xếp.");
        } else {
            for (History h : histories) {
                System.out.println(h);
            }
        }
    }
}
