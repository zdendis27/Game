package game;

/**
 * Tato trida reprezentuje specialni dialogy pouzite pri hadankach.
 */

public class ExtraDialogue {

    private int id;
    private String filePath;
    private String answer;

    public ExtraDialogue(int id, String filePath, String answer) {
        this.id = id;
        this.filePath = filePath;
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ExtraDialogue{" +
                "id=" + id +
                ", filePath='" + filePath + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
