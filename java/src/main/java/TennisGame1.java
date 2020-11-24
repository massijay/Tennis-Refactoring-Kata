
public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;
    private final String player1Name;
    private final String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name))
            ++player1Score;
        else if (playerName.equals(player2Name))
            ++player2Score;
    }

    public String getScore() {
        String scoreString;
        if (player1Score == player2Score) {
            if (player1Score >= 3) scoreString = "Deuce";
            else scoreString = scoreNumberToString(player1Score) + "-All";
        } else if (player1Score >= 4 || player2Score >= 4) {
            int scoreDifference = player1Score - player2Score;
            if (scoreDifference == 1) scoreString = "Advantage " + player1Name;
            else if (scoreDifference == -1) scoreString = "Advantage " + player2Name;
            else if (scoreDifference >= 2) scoreString = "Win for " + player1Name;
            else scoreString = "Win for " + player2Name;
        } else {
            scoreString = scoreNumberToString(player1Score) + "-" + scoreNumberToString(player2Score);
        }
        return scoreString;
    }

    public static String scoreNumberToString(int score) {
        String scoreString;
        switch (score) {
            case 0:
                scoreString = "Love";
                break;
            case 1:
                scoreString = "Fifteen";
                break;
            case 2:
                scoreString = "Thirty";
                break;
            case 3:
                scoreString = "Forty";
                break;
            default:
                scoreString = "";
                break;
        }
        return scoreString;
    }
}
