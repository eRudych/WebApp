package app.entities.employees;

public  abstract class CashEmployee {
    private String name;
    private boolean seniorPosition;
    CashEmployee(String name, boolean seniorPosition){
        this.name=name;
        this.seniorPosition=seniorPosition;
    }

    public String getName() {
        return name;
    }

    public boolean isSeniorPosition() {
        return seniorPosition;
    }
}
