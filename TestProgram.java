import java.io.BufferedReader;
 import java.io.FileReader;
 import java.io.IOException;
 import java.util.*;
 //Class my entry
 class MyEntry {
    private Integer key;
    private String value;
    public MyEntry(Integer key, String value) {
        this.key = key;
        this.value = value;
    }
    public Integer getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return key + " " + value;
    }
 }
 //Class SkipListPQ
 class SkipListPQ {
    private double alpha;
    private Random rand;
    //AGGIUNTE MIE
    private list<list<MyEntry>> sl;
    private static list<MyEntry> empty_list = {MyEntry(-100000,""),MyEntry(100000,"")};
    //FINE AGGIUNTE MIE
    public SkipListPQ(double alpha) {
        this.alpha = alpha;
        this.rand = new Random();
        sl.add(empty_list);
 // TO BE COMPLETED       
    }
    public int size() {
        return sl.get(0).size() - 2;
 // TO BE COMPLETED (finito?)       
    }
    public MyEntry min() {
        if(this.size()!=0)return sl.get(0).get(1);
        return null;
 // TO BE COMPLETED (finito?) 
    }
    public int insert(int key, String value) {
        int i = 0;
        MyEntry e = new MyEntry(key, value);
        int level = generateEll(alpha, key);
        while((sl.size()-1) <= level) sl.add(empty_list);
        while(i <= level) //3 votle uscito testa -> level = 3 -> inserita la entry in S0,S1,S2,S3
        {
            int j = 0;
            while(key >= sl.get(i).get(j).getValue()) j++;
            sl.(i).add(j, e);
            i++;
        }
 // TO BE COMPLETED (finito?)
    }
    private int generateEll(double alpha_ , int key) {
        int level = 0;
        if (alpha_ >= 0. && alpha_< 1) {
          while (rand.nextDouble() < alpha_) {
              level += 1;
          }
        }
        else{
          while (key != 0 && key % 2 == 0){
            key = key / 2;
            level += 1;
          }
        }
        return level;
    }
    public MyEntry removeMin() {
        MyEntry e = min();
        if(e==null) return e;
        int i = 0;
        boolean check = sl.get(i).remove(e);
        while(check)
        {
            i++;
            check = sl.get(i).remove(e);  
        } 
        return e;
 // TO BE COMPLETED (finito?)
    }
    public void print() {
        int i = 1;
        while(i < sl.get(0).size()-1)
        {   
            MyEntry e = sl.get(0).get(i);
            int j = 1;
            while(sl.get(j).contains(e)) j++;
            System.out.print("("+ e + "):S"+ j-1 + ", ");
        }
        System.out.println("");
 // TO BE COMPLETED (finito?)
    }
 }
 //TestProgram
 public class TestProgram {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java TestProgram <file_path>");
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            double alpha = Double.parseDouble(firstLine[1]);
            System.out.println(N + " " + alpha);
            SkipListPQ skipList = new SkipListPQ(alpha);
            for (int i = 0; i < N; i++) {
                String[] line = br.readLine().split(" ");
                int operation = Integer.parseInt(line[0]);
                switch (operation) {
                    case 0:
 // TO BE COMPLETED 
                        break;
                    case 1:
 // TO BE COMPLETED 
                        break;
                    case 2:
 // TO BE COMPLETED 
                        break;
                    case 3:
 // TO BE COMPLETED 
                        break;
                    default:
                        System.out.println("Invalid operation code");
                        return;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
 }