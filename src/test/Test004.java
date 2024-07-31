package test;

import gann.ActivationFunction;
import gann.Data;
import gann.Model;
import gann.NeuralNetwork;
import gann.Result;
import java.util.Arrays;

public class Test004 {

    public static void main(String[] args) {
        String filename = "src/gann/Invistico_Airline.csv";
        String separator = ",";
        int indeksKelas = 0;
        String[] typesOfData = {Data.CAT, Data.CAT, Data.CAT, Data.NUM, Data.CAT, Data.CAT, Data.NUM, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.CAT, Data.NUM, Data.NUM};
        int[] ignored = {};

        //--------------------------------------
        double percentTraining = 80;
        double percentTesting = 20;
        ActivationFunction[] activationFunction = {ActivationFunction.SIGMOID_BINER, ActivationFunction.SIGMOID_BINER};//tipe fungsi aktivasi
        double alpha = 0.1;
        int[] numHiddenNeurons = {4};
        int MAX_EPOCH = 100;
        double targetError = 0.1;

        Data data = new Data(filename, separator, indeksKelas, typesOfData, ignored);

//        if (data.normalValues != null) {
//            System.out.println("NORMAL VALUES-----------------------------------");
//            for (int i = 0; i < data.normalValues.length; i++) {
//                System.out.println(Arrays.toString(data.normalValues[i]));
//            }
//        }

        data.splitData(percentTraining, percentTesting);
        
        NeuralNetwork nn = new NeuralNetwork();      
        int[] selectedFeatures = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //Model model = nn.training(data, alpha, numHiddenNeurons, activationFunction, MAX_EPOCH, targetError);
        Model model = nn.training(selectedFeatures, data, alpha, numHiddenNeurons,activationFunction, MAX_EPOCH, targetError);
        if(model!=null){
            System.out.println("MODEL");
            for(double[][]w:model.weights){
                System.out.println("W-----------------------------");
                for (int i = 0; i < w.length; i++) {
                    System.out.println(Arrays.toString(w[i]));
                }
            }
        }
        Result result = nn.testing(selectedFeatures, data, model, activationFunction);   
        System.out.println(result);
        
        
    }
}
