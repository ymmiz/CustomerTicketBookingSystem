package Model;

import java.util.ArrayList;
import java.util.List;

public class Cinema {
   private int id;
   private String name;
   private List<Theatre> theatres = new ArrayList<Theatre>();

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getId() {
      return id;
   }

   public List<Theatre> getThreatres() {
      return theatres;
   }

   public void setThreatres(List<Theatre> theatres) {
      this.theatres = theatres;
   }

   public void setId(int id) {
      this.id = id;
   }
}
