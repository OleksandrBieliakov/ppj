package gui.factories;

class Factory extends Thread {

    private BaloonColors color;
    private final Storage storage;

    Factory(BaloonColors color, Storage storage) {
        this.color = color;
        this.storage = storage;
    }

    @Override
    public void run() {
        int waitTime;
        while(true) {
            waitTime = 600 + (int)(Math.random()*1000);
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (storage) {
                storage.addBaloon(new Baloon(color));
            }
        }
    }

}
