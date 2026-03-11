public class ReadFile {

    public List<Model> read(String filePath) {
        List<Model> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String day = data[2];
                int period = Integer.parseInt(data[3]);
                int length = Integer.parseInt(data[4]);
                int credit = Integer.parseInt(data[5]);
                boolean required = Boolean.parseBoolean(data[6]);

                Model m = new Model(id, name, day, period, length, credit, required);
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}

    
}
