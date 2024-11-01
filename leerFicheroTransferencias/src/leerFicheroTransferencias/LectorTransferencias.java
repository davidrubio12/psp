package leerFicheroTransferencias;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LectorTransferencias {

    private BufferedReader reader;

    public LectorTransferencias(String filePath) throws IOException {
        reader = new BufferedReader(new FileReader(filePath));
    }

    public synchronized String leerTransferencia() throws IOException {
        return reader.readLine();
    }

    public void cerrar() throws IOException {
        reader.close();
    }
}
