package libraries;

import java.util.ArrayList;

public class SceneManager {

    private int currentScene;
    private ArrayList<Scene> sceneList;

    public SceneManager() {
        sceneList = new ArrayList<Scene>();
    }

    public void addScene(Scene scene) {
        sceneList.add(scene);
    }

    public Scene getScene(int index) {
        return sceneList.get(index);
    }

    public void nextScene() {
        currentScene++;
    }

    public void setCurrentScene(int scene) {
        this.currentScene = scene;
    }

    public Scene getCurrentScene() {
        return sceneList.get(currentScene);
    }

    public ArrayList<Scene> getScenes(){
        return sceneList;
    }
}
