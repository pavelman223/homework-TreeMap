import java.util.*;

public class ResultsBoard {
    private TreeMap<Float, List<String>> board = new TreeMap<>(Collections.reverseOrder());

    public void addStudent(String name, Float score) {
        // Получаем список студентов с данным баллом
        board.putIfAbsent(score, new ArrayList<>());
        board.get(score).add(name);
    }

    public List<String> top3() {
        List<String> topStudents = new ArrayList<>();
        int count = 0;

        for(Map.Entry<Float, List<String>> entry : board.entrySet()) {
            for (String student : entry.getValue()) {
                if (count < 3) {
                    topStudents.add(student);
                    count++;
                } else {
                    break;
                }
            }
            if (count >= 3) {
                break;
            }
        }

        return topStudents;
    }

    public static void main(String[] args) {
        ResultsBoard board = new ResultsBoard();
        board.addStudent("Иван", 4.56f);
        board.addStudent("Мария", 4.86f);
        board.addStudent("Алексей", 4.86f); // Дубликат по баллу
        board.addStudent("Светлана", 4.933f);
        board.addStudent("Николай", 4.724f);

        List<String> topStudents = board.top3();
        for(String student : topStudents) {
            System.out.println(student);
        }
    }
}
