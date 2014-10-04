package ua.artcode.week3.day2.saveToFile;

public class TestSaveToFile {

    public static void main(String[] args) {
        BigData bigData = new BigData("Bla bla", 5, 3.3);

//        BigData bigData1 = LoadData.refLoad();

        SaveData.refSave(bigData);



    }
}
