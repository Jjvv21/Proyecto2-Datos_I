package Interfaz;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class Columnas {
	//TXT COLUMNS
	private TableColumn<Caracteristicas_De_Archivos, String> Name1 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Size1 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Location1 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Date1 = new TableColumn<>();
	
	//DOCX COLUMNS 
	private TableColumn<Caracteristicas_De_Archivos, String> Name2 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Size2 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Location2 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Date2 = new TableColumn<>();
	
	//PDF COLUMNS
	private TableColumn<Caracteristicas_De_Archivos, String> Name3 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Size3 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Location3 = new TableColumn<>();
	private TableColumn<Caracteristicas_De_Archivos, String> Date3 = new TableColumn<>();
	
	
	
	
	
	/// METODOS PARA LAS COLUMNAS DE LOS ARCHIVOS TXT
	public void Nametxt(TableColumn<Caracteristicas_De_Archivos, String> Nombretxt) {
		TableColumn<Caracteristicas_De_Archivos, String> Name1 = new TableColumn<>("Name");
		Name1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Nombre"));
		Name1.setResizable(true);
		this.Name1= Name1; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getNombretxt(){
		return Name1;
	}
	public void Tamañotxt(TableColumn<Caracteristicas_De_Archivos, String> Tamañotxt) {
		TableColumn<Caracteristicas_De_Archivos, String> Size1 = new TableColumn<>("Size(Bytes)");
		Size1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Peso"));
		Size1.setResizable(true);
		this.Size1= Size1 ; 
	}
	public  TableColumn<Caracteristicas_De_Archivos, String> getTamañotxt(){
		return Size1;
	}
	public void Direcciontxt(TableColumn<Caracteristicas_De_Archivos, String> Direcciontxt) {
		TableColumn<Caracteristicas_De_Archivos, String> Location1 = new TableColumn<>("Location");
		Location1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Direccion"));
		Location1.setResizable(true);
		this.Location1= Location1 ; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getDirecciontxt(){
		return Location1;
	}
	public void Fechatxt(TableColumn<Caracteristicas_De_Archivos, String> Fechatxt) {
		TableColumn<Caracteristicas_De_Archivos, String> Date1 = new TableColumn<>("Date");
		Date1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Fecha"));
		Date1.setResizable(true);
		this.Date1= Date1 ; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getFechaTxt(){
		return Date1;
	}
	
	
	
	
	///// METODOS PARA LAS COLUMNAS DE LOS ARCHIVOS DOCX 
	
	
	
	
	public void Namedocx(TableColumn<Caracteristicas_De_Archivos, String> NombreDocx) {
		TableColumn<Caracteristicas_De_Archivos, String> Name2 = new TableColumn<>("Name");
		Name2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Nombre"));
		Name2.setResizable(true);
		this.Name2= Name2; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getNombreDocx(){
		return Name2;
	}
	public void TamañoDocx(TableColumn<Caracteristicas_De_Archivos, String> TamañoDocx) {
		TableColumn<Caracteristicas_De_Archivos, String> Size2 = new TableColumn<>("Size(Bytes)");
		Size2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Peso"));
		Size2.setResizable(true);
		this.Size2= Size2 ; 
	}
	public  TableColumn<Caracteristicas_De_Archivos, String> getTamañoDocx(){
		return Size2;
	}
	public void DireccionDocx(TableColumn<Caracteristicas_De_Archivos, String> DireccionDocx) {
		TableColumn<Caracteristicas_De_Archivos, String> Location2 = new TableColumn<>("Location");
		Location2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Direccion"));
		Location2.setResizable(true);
		this.Location2= Location2 ; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getDireccionDocx(){
		return Location2;
	}
	public void FechaDocx(TableColumn<Caracteristicas_De_Archivos, String> FechaDocx) {
		TableColumn<Caracteristicas_De_Archivos, String> Date2 = new TableColumn<>("Date");
		Date2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Fecha"));
		Date2.setResizable(true);
		this.Date2= Date2 ; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getFechaDocx(){
		return Date2;
	}

	
	
	
	///// METODOS PARA LAS COLUMNAS DE LOS ARCHIVOS DOCX 
	
	
	
	public void NamePdf(TableColumn<Caracteristicas_De_Archivos, String> NombrePdf) {
		TableColumn<Caracteristicas_De_Archivos, String> Name3 = new TableColumn<>("Name");
		Name3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Nombre"));
		Name3.setResizable(true);
		this.Name3= Name3; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getNombrePdf(){
		return Name3;
	}
	public void TamañoPdf(TableColumn<Caracteristicas_De_Archivos, String> TamañoPdf) {
		TableColumn<Caracteristicas_De_Archivos, String> Size3 = new TableColumn<>("Size(Bytes)");
		Size3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Peso"));
		Size3.setResizable(true);
		this.Size3= Size3 ; 
	}
	public  TableColumn<Caracteristicas_De_Archivos, String> getTamañoPdf(){
		return Size3;
	}
	public void DireccionPdf(TableColumn<Caracteristicas_De_Archivos, String> DireccionPdf) {
		TableColumn<Caracteristicas_De_Archivos, String> Location3 = new TableColumn<>("Location");
		Location3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Direccion"));
		Location3.setResizable(true);
		this.Location3= Location3 ; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getDireccionPdf(){
		return Location3;
	}
	public void FechaPdf(TableColumn<Caracteristicas_De_Archivos, String> FechaPdf) {
		TableColumn<Caracteristicas_De_Archivos, String> Date3 = new TableColumn<>("Date");
		Date3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Fecha"));
		Date3.setResizable(true);
		this.Date3= Date3 ; 
	}
	public TableColumn<Caracteristicas_De_Archivos, String> getFechaPdf(){
		return Date3;
	}

	
	
	
	
}	
