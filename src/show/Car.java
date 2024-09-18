package show;

public class Car {
    private static int current_id = 0;

    private int id;
    private String model;
    private double price;
    private int year;
    private Registr_number registr_number = new Registr_number();

    private static int generate_id() {
        return ++current_id;
    }

    public class Registr_number {
        private String region_code;
        private String number;
        private String series_code;

        public void set_number(String number) {
            this.number = number;
        }

        public String get_number() {
            return number;
        }

        public void set_series_code(String series_code) {
            this.series_code = series_code;
        }

        public String get_series_code() {
            return series_code;
        }

        public void set_region_code(String region_code) {
            this.region_code = region_code;
        }

        public String get_region_code() {
            return region_code;
        }
    }

    public Car(String model, int year, double price, Registr_number registr_Number) {
        this.id = generate_id();
        setModel(model);
        setYear(year);
        setPrice(price);
        setRegistr_Number(registr_Number);
    }

    public Car() {
        this.id = generate_id();
    }

    public int getId() {
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setRegistr_Number(Registr_number registr_Number) {
        this.registr_number = registr_Number;
    }

    public Registr_number getRegistr_Number() {
        return registr_number;
    }

    public void show() {
        System.out.println("ID: " + id + ", Model: " + model + ", Price: " + price + ", Year: " + year + ", Registration: " + registr_number.get_region_code() + " " + registr_number.get_number() + " " + registr_number.get_series_code());
    }
}
