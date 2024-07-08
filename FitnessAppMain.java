public class FitnessAppMain {
    public static void main(String[] args) {
        FitnessAppBase fab = new FitnessAppBase();
        ProgressBarPanel pbp = new ProgressBarPanel();
        ProgressBarPanelMEN pbdMEN = new ProgressBarPanelMEN();

        ProgressIncrease pI = new ProgressIncrease(pbp);
       ProgressIncreaseMEN pIMEN = new ProgressIncreaseMEN(pbdMEN);

        Thread thread = new Thread(pI);
        thread.start();
        Thread threadMEN = new Thread(pIMEN);
        threadMEN.start();
    }
    
}
