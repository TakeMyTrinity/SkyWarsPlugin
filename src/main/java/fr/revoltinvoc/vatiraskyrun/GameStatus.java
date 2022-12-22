package fr.revoltinvoc.vatiraskyrun;

public enum GameStatus {

    LOBBY(), GAME(), END();

    private static GameStatus status;

    public static void setStatus(GameStatus statusS) {
        status = statusS;
    }

    public static boolean isStatus(GameStatus statusS) {
        return status == statusS;
    }

    public static GameStatus getStatus() {
        return status;
    }
}