package es.ieci.tecdoc.isicres.admin.estructura.dao;

import es.ieci.tecdoc.isicres.admin.estructura.dao.impl.GroupsImpl;


/**
 * Maneja la lista de grupos invesDoc.
 */
public class Groups
{
	/**
    * Construye un objeto de la clase.
    *
    */

   public Groups()
   {
      _groupsImpl = new GroupsImpl();
   }

   /**
    * Devuelve el n�mero de grupos.
    *
    * @return El n�mero de grupo mencionado.
    */

   public int count()
   {
      return _groupsImpl.count();
   }

   /**
    * Carga la lista de grupos con su informaci�n b�sica.
    *
    * @throws Exception Si se produce alg�n error en la carga de los grupos.
    */

   public void loadLite(String entidad) throws Exception
   {
      _groupsImpl.load(entidad);
   }


   /**
    * Devuelve un grupo de la lista.
    *
    * @param index Indice del grupo que se desea recuperar.
    *
    * @return El grupo mencionado.
    */

   public Group getGroup(int index)
   {
      return _groupsImpl.get(index);
   }

   /**
    * Obtiene la informaci�n de la lista de grupos en formato XML.
    *
    * @return La lista de grupo mencionada.
    */

   public String toXML()
   {
      return _groupsImpl.toXML(true);
   }

   /**
    * Muestra una representaci�n de los valores de la clase en formato XML.
    *
    * @return La representaci�n mencionada.
    */

	public String toString()
   {
      return _groupsImpl.toString();
   }

	public GroupsImpl get_groupsImpl() {
		return _groupsImpl;
	}


   private GroupsImpl _groupsImpl;





}
