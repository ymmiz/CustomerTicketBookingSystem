package Model;

import java.util.ArrayList;
import java.util.List;

public class Theatre {
    private int id;
    private String name;
    private Cinema cinema;
    private List<Seat> seats = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }
}
