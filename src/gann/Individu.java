package gann;

import java.util.Arrays;

public class Individu {
    private int[] gen;
    private int min_feature = 2;

    public Individu(int length) {
        initialization(length);
    }
    
    public void initialization(int length){
        gen = new int[length];
        int nSatu = 0;
        for (int i = 0; i < length; i++) {
            int alele = Utility.randomBiner();
            gen[i]=alele;
            if(alele==1){
                nSatu++;
            }
        }
        if (nSatu < min_feature) {
            boolean valid = false;
            while (!valid && nSatu < min_feature) {
                int r = Utility.randomBetween(0, length - 1);
                if (gen[r] == 0) {
                    gen[r] = 1;
                    nSatu++;
                    valid = true;
                }
            }
        }
    }
    
    public double calculateFitnessValue(){
        double fitnessValue = 0;
        
        return fitnessValue;
    }
    
    public String toString(){
        return "Individu: "+Arrays.toString(gen)+"";
    }
}
