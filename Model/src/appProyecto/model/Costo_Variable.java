package appProyecto.model;

public class Costo_Variable {
    private String id;
    private double monto;
    private TipoCosto tipo;
    
    public Costo_Variable() {
    }

    public Costo_Variable(double monto, TipoCosto tipo) {
        super();
        this.monto = monto;
        this.tipo = tipo;
    }


    public void setMonto(double monto) {
        this.monto = monto;
    }

    public double getMonto() {
        return monto;
    }

    public void setTipo(TipoCosto tipo) {
        this.tipo = tipo;
    }

    public TipoCosto getTipo() {
        return tipo;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
