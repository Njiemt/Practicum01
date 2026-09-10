import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;

void main() {

    ArrayList<String> csvList = new ArrayList<String>();

    Scanner input = new Scanner(System.in);
    boolean done = false;

    String fName;
    String lName;
    String ID;
    String Title;
    int BirthYear;

    do {
        StringBuilder sb = new StringBuilder();

        ID = SafeInput.getNonZeroLenString(input,"Enter Their Six Digit ID Number");
        fName = SafeInput.getNonZeroLenString(input,"Enter Their First Name");
        lName = SafeInput.getNonZeroLenString(input,"Enter Their last Name");
        Title = SafeInput.getNonZeroLenString(input,"Enter Their Email");
        BirthYear = SafeInput.getRangedInt(input,"Enter Their Birth Year",0000,9999);


        sb.append(ID).append(",");
        sb.append(fName).append(",");
        sb.append(lName).append(",");
        sb.append(Title).append(",");
        sb.append(BirthYear);

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