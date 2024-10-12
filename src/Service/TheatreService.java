package Service;

import Dao.AbstractDao;
import Dao.CinemaDao;
import Model.Cinema;
import Model.Theatre;

import java.io.IOException;
import java.sql.SQLException;

public class TheatreService extends BaseService<Theatre>{
    private CinemaDao cinemaDao;
    //private CinemaService cinemaService;
    private AbstractDao TheatreDao;
    public TheatreService(AbstractDao abstractDao) {
        super(abstractDao);
        this.TheatreDao = abstractDao;
        this.cinemaDao = new CinemaDao();
        //this.cinemaService = new CinemaService(this.cinemaDao);
    }
    @Override
    public Theatre getEntityObject(int id) {
        Theatre theatre = new Theatre();
        theatre.setId(id);
        return theatre;
    }

    @Override
    public String getEntity() {
        return "Theatre";
    }

    @Override
    public void register() throws SQLException, IOException {
        System.out.print("Enter theatre name : ");
        String name = br.readLine();
        //this.cinemaService.getAll();
        System.out.print("Enter cinema Id : ");
        int cinema_id = Integer.parseInt(br.readLine());
        Theatre theatre = new Theatre();
        Cinema cinema = new Cinema();
        cinema.setId(cinema_id);

        theatre.setName(name);
        theatre.setCinema(cinema);
        this.TheatreDao.create(theatre);
    }

}

