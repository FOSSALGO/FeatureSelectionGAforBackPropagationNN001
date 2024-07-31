package test;

import gann.Data;
import java.util.Arrays;

public class Test001 {

    public static void main(String[] args) {
        String filename = "src/gann/Invistico_Airline.csv";
        String separator = ",";
        int indeksKelas = 0;
        String[] typesOfData = {Data.CAT, Data.CAT, Data.CAT, Data.NUM, Data.CAT, Data.CAT, Data.NUM, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.NUM, Data.NUM};
        int[] ignored = {};
        Data data = new Data(filename, separator, indeksKelas, typesOfData, ignored);

        int numOfInputNeuron = 0;
        if (data.kategori != null) {
            for (int j = 0; j < data.kategori.length; j++) {
                if (data.kategori[j] != null) {
                    System.out.println("Num Categories" + (1 + j) + ": " + data.kategori[j].length);
                    numOfInputNeuron += data.kategori[j].length;
                } else {
                    System.out.println("NUMERIC TYPE");
                    numOfInputNeuron++;
                }
            }
        }
        System.out.println("NUMBER of INPUT NEURON = " + numOfInputNeuron);

//        if(data.stringValues!=null){
//            System.out.println("STRING VALUES-----------------------------------");
//            for (int i = 0; i < data.stringValues.length; i++) {
//                System.out.println(Arrays.toString(data.stringValues[i]));
//            }
//        }
//        if(data.stringValues!=null){
//            System.out.println("NORMAL VALUES-----------------------------------");
//            for (int i = 0; i < data.normalValues.length; i++) {
//                System.out.println(Arrays.toString(data.normalValues[i]));
//            }
//        }
    }
}
