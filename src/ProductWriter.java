import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

void main() {

    ArrayList<String> csvList = new ArrayList<String>();

    Scanner input = new Scanner(System.in);
    boolean done = false;

    String Name;
    String ID;
    String Desc;
    double Cost;

    do {
        StringBuilder sb = new StringBuilder();

        ID = SafeInput.getNonZeroLenString(input,"Enter Their Six Digit ID Number");
        Name = SafeInput.getNonZeroLenString(input,"Enter The items Name");
        Desc = SafeInput.getNonZeroLenString(input,"Enter The items description");
        Cost = SafeInput.getDouble(input,"Enter The items cost");


        sb.append(ID).append(",");
        sb.append(Name).append(",");
        sb.append(Desc).append(",");
        sb.append(Cost);

        csvList.add(sb.toString());

        if(SafeInput.getYNConfirm(input,"Are you sure you want to quit")){
            done = true;
        }

    } while(!done);


    String fileName = SafeInput.getNonZeroLenString(input, "Enter file name (without .csv)");

    try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".csv"))) {

        for(String record : csvList ){
            writer.write(record);
            writer.newLine();
        }

    } catch (IOException e){
        e.printStackTrace();
    }
}