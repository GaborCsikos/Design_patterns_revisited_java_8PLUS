package week2.structural.proxy.protection;

public class ProxyImage implements Image {
    private RealImage real = new RealImage();

    @Override
    public void loadImage() {
         real.loadImage();
    }

    @Override
    public boolean isLoaded() {
        return real.isLoaded();
    }


}
