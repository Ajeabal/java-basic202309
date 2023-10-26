package day10.io.obj;

import day10.io.rw.FilePath;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import static day10.io.obj.Snack.Taste.*;

public class SaveSnack {
    public static void main(String[] args) {
        List<Snack> snackList = List.of(
                new Snack("콘칲", 1970, 1500, GOOD),
                new Snack("사브레", 1890, 2500, BAD),
                new Snack("오징어집", 1985, 1800, SOSO)
        );
        try (FileOutputStream fos = new FileOutputStream(FilePath.path + "/snack.sav")) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(snackList);
        } catch (Exception e) {
           e.printStackTrace();
        }
    }
}
