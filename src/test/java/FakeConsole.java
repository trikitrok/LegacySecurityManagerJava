import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FakeConsole implements Console {
    private final List<String> userInputs;
    private int linesReadNumber;
    private List<String> printedLines;

    public FakeConsole(String ... userInputs) {
        printedLines = new ArrayList<>();
        this.userInputs = Arrays.asList(userInputs);
        linesReadNumber = 0;
    }

    public String readLine()  {
        String line = userInputs.get(linesReadNumber);
        linesReadNumber++;
        return line;
    }

    public void printLine(String line) {
        printedLines.add(line);
    }

    public String lastPrintedLine() {
        return printedLines.get(printedLines.size() - 1);
    }
}
