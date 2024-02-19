public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FXskel fxskel = new FXskel();
            fxskel.initialize();
        });
    }
}
