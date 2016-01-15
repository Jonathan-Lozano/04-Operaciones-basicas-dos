import java.awt.Container;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Jonathan Lozano
 *
 */

public class Vista extends JFrame implements ActionListener {

	private TextField txtN1 = new TextField();
	private TextField txtN2 = new TextField();

	private Label lblN1 = new Label("Numero 1");
	private Label lblN2 = new Label("Numero 2");
	private Label lblResult = new Label("Resultado");

	private Container cont = getContentPane();

	private JButton btnSuma = new JButton("+");
	private JButton btnResta = new JButton("-");
	private JButton btnMultiplicacion = new JButton("*");
	private JButton btnDivicion = new JButton("/");

	Operacion op = new Operacion();

	/**
	 * Se crea un constructor que crea una venta y a su vez carga los controles
	 * llamando al metodo cargarControles
	 */
	public Vista() {
		super.setTitle("Operaciones");
		super.setSize(320, 480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);

		cargarControles();

	}

	/**
	 * Se le dan especificaciones a cada uno de los controles y agregandoles a
	 * un contenedor asi como tambien se agrega el la accion que va a tener cada
	 * boton
	 */
	private void cargarControles() {
		cont.setLayout(null);

		lblN1.setBounds(10, 10, 290, 30);
		cont.add(lblN1);

		txtN1.setBounds(10, 40, 290, 30);
		cont.add(txtN1);

		lblN2.setBounds(10, 80, 290, 30);
		cont.add(lblN2);

		txtN2.setBounds(10, 110, 290, 30);
		cont.add(txtN2);

		btnSuma.setBounds(10, 170, 50, 30);
		cont.add(btnSuma);

		btnResta.setBounds(80, 170, 50, 30);
		cont.add(btnResta);

		btnMultiplicacion.setBounds(150, 170, 50, 30);
		cont.add(btnMultiplicacion);

		btnDivicion.setBounds(220, 170, 50, 30);
		cont.add(btnDivicion);

		lblResult.setBounds(10, 200, 290, 30);
		cont.add(lblResult);

		btnSuma.addActionListener(this);
		btnResta.addActionListener(this);
		btnMultiplicacion.addActionListener(this);
		btnDivicion.addActionListener(this);
	}

	/**
	 * se crean tres variables dos para obtener lo que contengan las cajas de
	 * texto y una mas para guardar el resultado de las operaciones
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		int num1 = Integer.parseInt(txtN1.getText());
		int num2 = Integer.parseInt(txtN2.getText());
		int result;
		if (e.getSource() == btnSuma) {
			result = op.sumar(num1, num2);
			lblResult
					.setText(String.format("%d + %d = %d", num1, num2, result));
		} else if (e.getSource() == btnResta) {
			result = op.restar(num1, num2);
			lblResult
					.setText(String.format("%d - %d = %d", num1, num2, result));
		} else if (e.getSource() == btnMultiplicacion) {
			result = op.multiplicar(num1, num2);
			lblResult
					.setText(String.format("%d * %d = %d", num1, num2, result));
		} else if (e.getSource() == btnDivicion) {
			result = op.dividir(num1, num2);
			lblResult
					.setText(String.format("%d / %d = %d", num1, num2, result));
		}
	}

}
