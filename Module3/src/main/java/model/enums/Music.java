package model.enums;

/**
 * @author Alex Volochai
 */
public enum Music {

    TRACK,
    LIVE_MUSIC;

    public static Music parseMusic(String music) throws IllegalArgumentException {
        switch (music) {
            case "track":
                return TRACK;
            case "liveMusic":
                return LIVE_MUSIC;
            default:
                throw new IllegalArgumentException();
        }
    }

}
