package day10.io.obj;

import day10.io.rw.FilePath;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class LoadSnack {

    public static void main(String[] args) {

        try (FileInputStream fis = new FileInputStream(FilePath.path + "/snack.sav")) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            List<Snack> snackList = (List<Snack>) ois.readObject();

            for (Snack snack:snackList) {
                System.out.println("snack = " + snack);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
