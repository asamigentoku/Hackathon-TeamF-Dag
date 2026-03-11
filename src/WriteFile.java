public class WriteFile {

    public void write(String filePath, List<Model> list) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {

            for (Model m : list) {
                String line = m.id + "," +
                              m.name + "," +
                              m.day + "," +
                              m.period + "," +
                              m.length + "," +
                              m.credit + "," +
                              m.required;

                bw.write(line);
                bw.newLine();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

