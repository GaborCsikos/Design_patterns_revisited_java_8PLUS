package week2.structural.flyweight;

import java.util.ArrayList;
import java.util.List;


public class BetterFormattedText {
    private int memoryUsed = 0;
    private String plainText;
    private List<TextRange> formatting = new ArrayList<>();

    public BetterFormattedText(String plainText) {
        this.plainText = plainText;
    }

    public TextRange getRange(int start, int end) {
        TextRange range = new TextRange(start, end);
        formatting.add(range);
        memoryUsed++;
        return range;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < plainText.length(); ++i) {
            char c = plainText.charAt(i);
            for (TextRange range : formatting)
                if (range.covers(i) && range.capitalize)
                    c = Character.toUpperCase(c);
            sb.append(c);
        }
        return sb.toString();
    }

    public int getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(int memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public class TextRange {
        public int start, end;
        public boolean capitalize, bold, italic;

        public TextRange(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean covers(int position) {
            return position >= start && position <= end;
        }

    }
}