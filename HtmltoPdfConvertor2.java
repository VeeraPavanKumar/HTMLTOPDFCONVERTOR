package html;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HtmltoPdfConvertor2 {
    public static void main(String[] args) {
        String htmlFilePath = "file:///C:/Users/hp/Downloads/test.html";
        String pdfOutputPath = "D:\\OUTPUT\\output.pdf";

        try {
            String[] cmd = {"C://Program Files//wkhtmltopdf//bin//wkhtmltopdf.exe", htmlFilePath, pdfOutputPath};

            Process process = Runtime.getRuntime().exec(cmd);

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

            process.waitFor();

            if (process.exitValue() == 0) {
                System.out.println("PDF conversion successful.");
            } else {
                System.err.println("PDF conversion failed.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
