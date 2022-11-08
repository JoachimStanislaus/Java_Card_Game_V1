public class GameLog {
    public void writeContentsToFile() throws IOException {
        // File name generated using deckNumber attribute to ensure unique file directory.
        String path = "log" + File.separator + "deck" + deckId + "_log.txt";
        StringBuilder output = new StringBuilder("deck" + deckId + " contents: ");
        for (Card card : hand) {
            if (card != null) output.append(" ").append(card.getValue());
        }
        File f = new File(path);
        // mkdirs() method to create new directory
        f.getParentFile().mkdirs();
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        if (!f.createNewFile()) {
            writer.write("");
        }
        // BufferedWriter to write to and edit file
        writer = new BufferedWriter(new FileWriter(path, true));
        writer.write(output.toString());
        writer.newLine();
        writer.close();
    }
    
    public void xx(){

    }
}