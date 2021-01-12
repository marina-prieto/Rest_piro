package presentacion.rutas;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class MiAreaDibujo extends JLabel{
	private ArrayList<ObjetoGrafico> objetosGraficos = new ArrayList<ObjetoGrafico>();
	
	public ArrayList<ObjetoGrafico> getObjetosGraficos() {
		return objetosGraficos;
	}

	public void setObjetosGraficos(ArrayList<ObjetoGrafico> objetosGraficos) {
		this.objetosGraficos = objetosGraficos;
	}

	public MiAreaDibujo(){
	}
	
	void addObjetoGrafico(ObjetoGrafico objg){
		objetosGraficos.add(objg);
	}
	
	public ObjetoGrafico getUltimoObjetoGrafico(){
		return objetosGraficos.get(objetosGraficos.size()-1);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		for (int i = 0; i < objetosGraficos.size(); i++) {
			ObjetoGrafico objg = objetosGraficos.get(i);
			if (objg instanceof ImagenGrafico){
				g.drawImage(((ImagenGrafico)objg).getImagen(), objg.getX(),
				objg.getY(), null);
			}
			else if(objg instanceof TextoGrafico){
				g.setColor(((TextoGrafico)objg).getColor());
				g.drawString(((TextoGrafico)objg).getTexto(),objg.getX(),objg.getY());
			}
		}
	}
	
}
