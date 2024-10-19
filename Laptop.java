import java.util.Objects;

public class Laptop {
    public int ram;
    public int memoryHD;
    public String OS;
    public String color;

    public Laptop (int ram, int memoryHD, String OS, String color) {
    this.ram = ram; // GB
    this.memoryHD = memoryHD; // GB
    this.OS = OS;
    this.color = color;
    }

    public int getRam () {
        return ram;
    }

    public int getMemoryHD() {
        return memoryHD;
    }

    public String getOS() {
        return OS;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram && memoryHD == laptop.memoryHD && Objects.equals(OS, laptop.OS) && Objects.equals(color, laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ram, memoryHD, OS, color);
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Оперативная память=" + ram +
                ", память HDD=" + memoryHD +
                ", операционная система='" + OS + '\'' +
                ", цвет='" + color + '\'' +
                '}';
    }
}
