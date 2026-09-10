import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import javax.swing.JFileChooser;

void main(String[] args) {

    File file = null;

    if (args.length > 0) {
        file = new File(args[0]);
    }
    else {
        JFileChooser choose = new JFileChooser(
                "C:/Users/moham/IdeaProjects/Practicum01"
        );

        int result = choose.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            file = choose.getSelectedFile();
        }
    }

    if (file != null) {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            System.out.println(String.format(
                    "%-10s %-15s %-15s %-10s ",
                    "ID#", "Name", "Desc", "Cost"
            ));

            System.out.println(
                    "===================================================="
            );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println(String.format(
                        "%-10s %-15s %-15s %-10s ",
                        data[0],
                        data[1],
                        data[2],
                        data[3]

                ));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}