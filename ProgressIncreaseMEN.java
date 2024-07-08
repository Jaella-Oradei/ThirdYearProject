public class ProgressIncreaseMEN implements Runnable {
    
    ProgressBarPanelMEN progress;
    
    public ProgressIncreaseMEN(ProgressBarPanelMEN progress) {
        this.progress = progress;
    }
    
    @Override
    public void run(){
        for (int i = 0; i <= 100; i += 3) {
            progress.updateProgress(i);
            try {
                Thread.sleep(5000); // Adjust sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
