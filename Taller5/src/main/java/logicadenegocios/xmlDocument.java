/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicadenegocios;
import java.io.File;
import java.util.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author usuario
 */
public class xmlDocument {
    ArrayList<Pais> paises = new ArrayList();
    public xmlDocument(){}
    public void AgregarPais(Pais pPais){
        paises.add(pPais);
    }
    public void Guardar(){
        try {
 
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// elemento raiz
		Document doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("Paises");
		doc.appendChild(rootElement);
                int tamanoPaises = paises.size();
                for(int i = 0; i<tamanoPaises; i++){
                    Pais temp = paises.get(i);
                    // empleado
                    Element empleado = doc.createElement("Pais");
                    rootElement.appendChild(empleado);

                    // atributo del elemento empleado
                    Attr attr = doc.createAttribute("id");
                    String valor = String.valueOf(i);
                    attr.setValue(valor);
                    empleado.setAttributeNode(attr);

                    // nombre
                    Element nombre = doc.createElement("nombre");
                    nombre.appendChild(doc.createTextNode(temp.getNombre()));
                    empleado.appendChild(nombre);

                    // apellidos
                    Element apellidos = doc.createElement("area");
                    apellidos.appendChild(doc.createTextNode(temp.getArea()));
                    empleado.appendChild(apellidos);

                    // seccion
                    Element seccion = doc.createElement("poblacion");
                    seccion.appendChild(doc.createTextNode(temp.getPoblacion()));
                    empleado.appendChild(seccion);

                    // salario
                    Element salario = doc.createElement("idoma");
                    salario.appendChild(doc.createTextNode(temp.getIdioma()));
                    empleado.appendChild(salario);
                    
                    Element provincias = doc.createElement("provincias");
                    empleado.appendChild(provincias);
                    
                    ArrayList<String> listPro = temp.getProvincias();
                    int cantPro = listPro.size();
                    for(int j = 0; j<cantPro; j++){
                        Element proTemp = doc.createElement("provincia");
                        proTemp.appendChild(doc.createTextNode(listPro.get(j)));
                        provincias.appendChild(proTemp);
                    }
                    
                    Element limites = doc.createElement("limites");
                    empleado.appendChild(limites);
                    
                    ArrayList<String> listLim = temp.getLimites();
                    int cantLim = listLim.size();
                    for(int y = 0; y<cantLim; y++){
                        Element proTemp = doc.createElement("limite");
                        proTemp.appendChild(doc.createTextNode(listLim.get(y)));
                        limites.appendChild(proTemp);
                    }
                }
		// escribimos el contenido en un archivo .xml
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(new File("Paises.xml"));
		//StreamResult result = new StreamResult(new File("archivo.xml"));
 
		// Si se quiere mostrar por la consola...
		// StreamResult result = new StreamResult(System.out);
 
		transformer.transform(source, result);
 
		System.out.println("File saved!");
 
		} catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		} catch (TransformerException tfe) {
			tfe.printStackTrace();
		}
    }
}
