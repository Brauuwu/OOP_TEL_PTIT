import java.util.*;
import java.util.regex.*;

class EmptyQueueException extends Exception {
    public EmptyQueueException() {
        super();
    }
}

class GenericPriorityQueue<T extends Comparable<T>> {
    private PriorityQueue<T> queue;

    public GenericPriorityQueue() {
        queue = new PriorityQueue<>();
    }

    public void add(T item) {
        queue.add(item);
    }

    public T poll() throws EmptyQueueException {
        if (queue.isEmpty()) {
            throw new EmptyQueueException();
        }
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

class Task implements Comparable<Task> {
    private static long counter = 0;

    private String name;
    private int priority;
    private long order;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.order = counter++;
    }

    @Override
    public int compareTo(Task other) {
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return Long.compare(this.order, other.order);
    }

    @Override
    public String toString() {
        return "Task [" + name + "] " + priority;
    }
}

class Student implements Comparable<Student> {
    private static long counter = 0;

    private String name;
    private double gpa;
    private long order;

    public Student(String name, double gpa) {
        this.name = name;
        this.gpa = gpa;
        this.order = counter++;
    }

    @Override
    public int compareTo(Student other) {
        int cmp = Double.compare(other.gpa, this.gpa); // giảm dần
        if (cmp != 0) {
            return cmp;
        }
        return Long.compare(this.order, other.order);
    }

    @Override
    public String toString() {
        return "Student [" + name + "] " + gpa;
    }
}

public class GENERIC004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GenericPriorityQueue<Task> taskQueue = new GenericPriorityQueue<>();
        GenericPriorityQueue<Student> studentQueue = new GenericPriorityQueue<>();

        Pattern taskPattern =
                Pattern.compile("^Task \\[(.*)]\\s+(\\d+)$");
        Pattern studentPattern =
                Pattern.compile("^Student \\[(.*)]\\s+([0-9]+(?:\\.[0-9]+)?)$");

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.equals("exit")) {
                break;
            }

            Matcher mt = taskPattern.matcher(line);
            Matcher ms = studentPattern.matcher(line);

            if (mt.matches()) {
                String name = mt.group(1);
                int priority = Integer.parseInt(mt.group(2));
                taskQueue.add(new Task(removeDot(name), priority));
            } else if (ms.matches()) {
                String name = ms.group(1);
                double gpa = Double.parseDouble(ms.group(2));
                studentQueue.add(new Student(removeDot(name), gpa));
            }
        }

        System.out.println("[Task Queue]");

        if (taskQueue.isEmpty()) {
            System.out.println("Không có nhiệm vụ trong hàng đợi.");
        } else {
            while (!taskQueue.isEmpty()) {
                try {
                    System.out.println(taskQueue.poll());
                } catch (EmptyQueueException e) {
                    break;
                }
            }
        }

        System.out.println();
        System.out.println("[Student Queue]");

        if (studentQueue.isEmpty()) {
            System.out.println("Không có sinh viên trong hàng đợi.");
        } else {
            while (!studentQueue.isEmpty()) {
                try {
                    System.out.println(studentQueue.poll());
                } catch (EmptyQueueException e) {
                    break;
                }
            }
        }
    }

    private static String removeDot(String s) {
        if (s.endsWith(".")) {
            return s.substring(0, s.length() - 1);
        }
        return s;
    }
}
