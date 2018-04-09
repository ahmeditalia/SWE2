package SWEProject.Main.Controller.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AllStatistics {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;
    String operation;
    String entity;
    boolean added;

    public AllStatistics(String operation, String entity) {
        this.operation = operation;
        this.entity = entity;
        added=false;
    }
    public String getOperation() {
        return operation;
    }
    public void setOperation(String operation) {
        this.operation = operation;
    }
    public String getEntity() {
        return entity;
    }
    public void setEntity(String entity) {
        this.entity = entity;
    }
    public boolean isAdded() {
        return added;
    }
    public void setAdded(boolean added) {
        this.added = added;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
