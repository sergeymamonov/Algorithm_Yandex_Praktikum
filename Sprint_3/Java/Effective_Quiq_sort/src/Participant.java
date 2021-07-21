public class Participant {
    private String login;
    private int solvedProblems;
    private int penalty;

    public Participant(String login, int solvedProblems, int penalty) {
        this.login = login;
        this.solvedProblems = solvedProblems;
        this.penalty = penalty;
    }

    public String getLogin() {
        return login;
    }

    public int getSolvedProblems() {
        return solvedProblems;
    }

    public int getPenalty() {
        return penalty;
    }
}
