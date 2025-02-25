package academy.devdojo.maratonajava.javacore.Qstring.test;

public class StringPerformanceTest01 {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatenaStrings(100_000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para String "+ (fim-inicio)+"ms");

        inicio = System.currentTimeMillis();
        concatBuffer(1_000_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para String Buffer "+ (fim-inicio)+"ms");

        inicio = System.currentTimeMillis();
        concatBuilder(1_000_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para String Builder "+ (fim-inicio)+"ms");
    }

    private static void concatenaStrings(int tamanho) {
        String texto ="";
        for (int i = 0; i < tamanho; i++) {
            texto += i;
        }
    }

    private static void concatBuffer(int tamanho) {
        StringBuffer stringBuffer = new StringBuffer(tamanho);
        for (int i = 0; i < tamanho; i++) {
            stringBuffer.append(i);
        }
    }

    private static void concatBuilder(int tamanho) {
        StringBuilder stringBuilder = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            stringBuilder.append(i);
        }
    }
}
