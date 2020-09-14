package Exe_2P;

public class Exame_Classe {

	private int idExame;
	private String tipoExame;
	private float nivelGlicose;
	
	public Exame_Classe() {
		
	}
	
	public Exame_Classe(int idExame, String tipoExame, float nivelGlicose) {
		super();
		this.idExame = idExame;
		this.tipoExame = tipoExame;
		this.nivelGlicose = nivelGlicose;
	}

	public int getIdExame() {
		return idExame;
	}

	public void setIdExame(int idExame) {
		this.idExame = idExame;
	}

	public String getNomeExame() {
		return tipoExame;
	}

	public void setNomeExame(String nomeExame) {
		this.tipoExame = nomeExame;
	}

	public float getNivelGlicose() {
		return nivelGlicose;
	}

	public void setNivelGlicose(float nivelGlicose) {
		this.nivelGlicose = nivelGlicose;
	}
	
	public String obterDiagnostico(float nivelGlicose) {
		String diagnostico =" ";
		if (nivelGlicose < 99) {
			diagnostico = "Normal";
		} else if (nivelGlicose >= 100 && nivelGlicose <= 125) {
			diagnostico = "Pré-diabetes";
		} else {
			diagnostico = "Diabetes";
		}		
		return diagnostico;
	}
	
	
	
}
