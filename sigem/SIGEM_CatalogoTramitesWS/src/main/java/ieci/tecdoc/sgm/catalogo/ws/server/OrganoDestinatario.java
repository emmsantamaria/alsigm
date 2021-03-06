package ieci.tecdoc.sgm.catalogo.ws.server;
/*
 * $Id: OrganoDestinatario.java,v 1.1.2.1 2008/01/25 12:25:07 jconca Exp $
 */
import ieci.tecdoc.sgm.core.services.dto.RetornoServicio;


/**
 * Clase que implementa la clase OrganoDestinatario
 * @author x53492no
 *
 */
public class OrganoDestinatario extends RetornoServicio
{
	/**
	 * Constructor de la clase OrganoDestinatario
	 *
	 */
  public OrganoDestinatario()
  {
     this.id = null;
     this.description = null;
  }
  
  /**
   * Constructor de la clase OrganoDestinatario a partir de datos
   * @param id Identificador del �rgano destinatario
   * @param description Descripci�n correspondiente al �rgano destinatario
   */
  public OrganoDestinatario(String id, String description)
  {
     this.id = id;
     this.description = description;
  }
  
  /**
   * Establece el identificador del �rgano destinatario.
   * @param String Identificador de �rgano destinatario.
   */   
  public void setId(String id)
  {
     this.id = id;
  }
  
  /**
   * Establece la descripci�n del �rgano destinatario.
   * @param description Descripci�n del �rgano destinatario.
   */   
  public void setDescription(String description)
  {
     this.description = description;
  }
  
  /**
   * Recupera el identificador del �rgano destinatario.
   * @return String identificador de �rgano destinatario.
   */   
  public String getId()
  {
     return id;
  }
  
  /**
   * Recupera la descripci�n del �rgano destinatario.
   * @return String descripci�n del �rgano destinatario.
   */   
  public String getDescription()
  {
     return description;
  }
  
  protected String id;
  protected String description;

}
