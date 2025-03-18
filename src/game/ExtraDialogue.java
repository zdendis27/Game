package game;

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
}
