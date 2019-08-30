package week2.structural.proxy.protection;

public class RealImage implements Image {
    private boolean loaded = false;

    public void loadImage() {
        loaded = true;
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }


}
