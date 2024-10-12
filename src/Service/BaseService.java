package Service;

import Dao.AbstractDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseService<T> {
    protected static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public AbstractDao abstractDao;
    public abstract T getEntityObject(int id);
    public abstract String getEntity();
    public abstract void register() throws SQLException, IOException;

    public BaseService(AbstractDao abstractDao) {
        this.abstractDao = abstractDao;
    }

    public void call() throws NumberFormatException, IOException, SQLException {
        boolean exit = true;
        do {
            actionMenu();
            int choice = Integer.parseInt(br.readLine());

            switch (choice) {
                case 1:
                    findById();
                    break;
                case 2:
                    getAll();
                    break;
                case 3:
                    register();
                    break;
                case 4:
                    destory();
                    break;
                case 5:
                    exit = false;
                    System.out.println("Exiting the application...");
                    break;
            }
        } while (exit);
    }

    public void actionMenu() {
        System.out.println("Choose an action:");
        System.out.println("1: Find "+getEntity()+" by ID");
        System.out.println("2: Get All "+getEntity()+"s");
        System.out.println("3: Create a New "+getEntity());
        System.out.println("4: Delete a "+getEntity());
        System.out.println("5: Exit");
    }

    private void destory() throws NumberFormatException, IOException, SQLException {
        System.out.print("Enter "+getEntity()+" Id : ");
        int id = Integer.parseInt(br.readLine());
        T entity = getEntityObject(id);
        this.abstractDao.delete(entity);
    }

    public void getAll() throws SQLException {
        System.out.println("*** All "+getEntity()+"s ***");
        List<T> entities = this.abstractDao.getAll();
        for (T entity : entities) {
            System.out.println(entity);
        }
    }

    private void findById() throws NumberFormatException, IOException, SQLException {
        System.out.print("Enter "+getEntity()+" Id : ");
        int id = Integer.parseInt(br.readLine());
        T entity = (T) this.abstractDao.findById(id);
        System.out.println(entity);
    }
}
