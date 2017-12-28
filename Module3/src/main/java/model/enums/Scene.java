package model.enums;

/**
 * @author Alex Volochai
 */
public enum Scene {

    ASSEMBLY_HALL,
    STREET_PLATFORM,
    TV_STUDIO;

    public static Scene parseScene(String scene) throws IllegalArgumentException {
        switch (scene) {
            case "assemblyHall":
                return ASSEMBLY_HALL;
            case "streetPlatform":
                return STREET_PLATFORM;
            case "TVStudio":
                return TV_STUDIO;
            default:
                throw new IllegalArgumentException("for key " + scene);
        }
    }

}
