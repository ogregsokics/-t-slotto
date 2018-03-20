/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package backend;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.stream.Collectors;



public class Sorsolo {
    private final int MAX = 90;
    private final int MIN = 1;
    
    private int genNum1;
    private int genNum2;
    private int genNum3;
    private int genNum4;
    private int genNum5;
    
    private int selNum1;
    private int selNum2;
    private int selNum3;
    private int selNum4;
    private int selNum5;
    
    private String sor1;
    private String sor2;
    private String sor3;

    private String elsosor;
    private String masodiksor;

    private int numberOfTalalatok;
    
    
    public Sorsolo(){}

    
    

    public String getSor1() {
        return sor1;
    }

    public String getSor2() {
        return sor2;
    }

    public String getSor3() {
        return sor3;
    }
    
    public String getElsosor() {
        return elsosor;
    }

    public String getMasodiksor() {
        return masodiksor;
    }
    
    public Integer getnumberOfTalalatok() {
        return numberOfTalalatok;
    }
  
    public void start() {
        
        genNum1 = 0;
        genNum2 = 0;
        genNum3 = 0;
        genNum4 = 0;
        genNum5 = 0;
        genNum1 = getRandomNumber1();
        genNum2 = getRandomNumber1();
        genNum3 = getRandomNumber1();
        genNum4 = getRandomNumber1();
        genNum5 = getRandomNumber1();
        
        selNum1 = 0;
        selNum2 = 0;
        selNum3 = 0;
        selNum4 = 0;
        selNum5 = 0;
        selNum1 = getRandomNumber2();
        selNum2 = getRandomNumber2();
        selNum3 = getRandomNumber2();
        selNum4 = getRandomNumber2();
        selNum5 = getRandomNumber2();
        
     
        calculate();
    }
    
      private int getRandomNumber1(){
          
            int random = (int) (Math.random() * MAX) + MIN; 

            if (random == genNum1 || random == genNum2 || random == genNum3 || random == genNum4 || random == genNum5){
                return getRandomNumber1();
            }

            return random;      
        }
      
      
      private int getRandomNumber2(){
          
            int random = (int) (Math.random() * MAX) + MIN; 

            if (random == selNum1 || random == selNum2 || random == selNum3 || random == selNum4 || random == selNum5){
                return getRandomNumber2();
            }

            return random;      
        }
    
      
    private void calculate(){
        
        
        
        ArrayList<Integer> selectedNumbers = new ArrayList<>();
        selectedNumbers.add(selNum1);
        selectedNumbers.add(selNum2);
        selectedNumbers.add(selNum3);
        selectedNumbers.add(selNum4);
        selectedNumbers.add(selNum5);
       
        ArrayList<Integer> generatedNunbers = new ArrayList<>();
        generatedNunbers.add(genNum1);
        generatedNunbers.add(genNum2);
        generatedNunbers.add(genNum3);
        generatedNunbers.add(genNum4);
        generatedNunbers.add(genNum5);
        
        
        Integer[] selected = new Integer[selectedNumbers.size()];
        selected = selectedNumbers.toArray(selected);
        
        Integer[] generated = new Integer[generatedNunbers.size()];
        generated = generatedNunbers.toArray(generated);

        int meret = generated.length;
        int meret2 = selected.length;

        
        ArrayList<Integer> talalatok = new ArrayList<>();

        ArrayList<Integer> elsosor1 = new ArrayList<>();
        ArrayList<Integer> masodiksor2 = new ArrayList<>();

        int j;
        
        for (int i = 0; i < meret; i++) {
                            j=0;

                            while(j<meret2 && (selected[j] != generated[i]))
                            {j++;}
                            if (j<meret2) {
                                    talalatok.add(generated[i]);
                                    elsosor1.add(j);
                                    masodiksor2.add(i);
                            }
        }

        numberOfTalalatok = talalatok.size();
            
        String talalatokString = talalatok.stream().map(Object::toString)
        .collect(Collectors.joining(", "));

        String elsosorString = elsosor1.stream().map(Object::toString)
        .collect(Collectors.joining(","));

        String masodiksorString = masodiksor2.stream().map(Object::toString)
        .collect(Collectors.joining(","));


        
        sor1 = Arrays.toString(selected);
        sor1 = sor1.replace("[","");
        sor1 = sor1.replace("]","");

        sor2 = Arrays.toString(generated);
        sor2 = sor2.replace("[","");
        sor2 = sor2.replace("]","");


        sor3 = talalatokString;

        elsosor = elsosorString;
        masodiksor = masodiksorString;

    } 
    
}