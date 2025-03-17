import java.util.*;

public class ResultsBoard {
    private TreeMap<Double, String> board = new TreeMap<>(Collections.reverseOrder());

    public void addStudent(String name, Double score) {
        // Предполагаем, что имена студентов уникальны
        board.put(score, name);
    }

    public List<String> top3() {
        List<String> topStudents = new ArrayList<>();
        int count = 0;
        for(Map.Entry<Double, String> entry : board.entrySet()) {
            if(count < 3) {
                topStudents.add(entry.getValue());
                count++;
            } else {
                break;
            }
        }
        return topStudents;
    }
    public static void main(String[] args) {
        ResultsBoard board = new ResultsBoard();
        board.addStudent("Иван", 4.5);
        board.addStudent("Мария", 4.8);
        board.addStudent("Алексей", 4.2);
        board.addStudent("Светлана", 4.9);
        board.addStudent("Николай", 4.7);

        List<String> topStudents = board.top3();
        for(String student : topStudents) {
            System.out.println(student);
        }
    }



}

