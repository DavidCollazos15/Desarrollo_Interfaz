package Primera_ventana;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class Tabla extends AbstractTableModel {

    private enum TablaEstudianteColumna {

        Nif("NIF"),
        Name("Nombre"),
        Surname("Apellidos"),
        Age("Edad");

        final String header;

        TablaEstudianteColumna(String header) {
            this.header = header;
        }
    }

    private List<Student> students;

    public Tabla(List<Student> students) {
        super();
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return TablaEstudianteColumna.values().length;
    }

    @Override
    public String getColumnName(int column) {
        return TablaEstudianteColumna.values()[column].header;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (TablaEstudianteColumna.values()[columnIndex]) {
            case Nif:
                return student.getNif();
            case Name:
                return student.getNombre();
            case Surname:
                return student.getApellidos();
            case Age:
                return student.getEdad();
            default:
                return null;
        }
    }
}

