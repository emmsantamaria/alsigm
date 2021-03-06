package es.ieci.tecdoc.fwktd.csv.ws.delegate.impl;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import es.ieci.tecdoc.fwktd.csv.core.exception.CSVException;
import es.ieci.tecdoc.fwktd.csv.ws.delegate.AplicacionesDelegate;
import es.ieci.tecdoc.fwktd.csv.ws.service.AplicacionCSV;
import es.ieci.tecdoc.fwktd.csv.ws.service.AplicacionCSVForm;
import es.ieci.tecdoc.fwktd.test.db.AbstractDbUnitTransactionalJUnit4SpringContextTests;
import es.ieci.tecdoc.fwktd.test.db.annotation.DatasetLocation;

@DatasetLocation("data/dataset.xml")
@ContextConfiguration({ "/beans/fwktd-csv-core-applicationContext.xml",
		"/beans/fwktd-csv-api-applicationContext.xml",
		"/beans/fwktd-csv-ws-applicationContext.xml",
		"/beans/fwktd-csv-test-beans.xml" })
public class AplicacionesDelegateImplTest extends
		AbstractDbUnitTransactionalJUnit4SpringContextTests {

	private static final String ID_APLICACION_EXISTENTE = "20000001";
	private static final String ID_APLICACION_BORRAR = "20000002";
	private static final String ID_APLICACION_NO_EXISTENTE = "99999999";

	private static final String CODIGO_APLICACION_EXISTENTE = "APP1";
	private static final String CODIGO_APLICACION_NO_EXISTENTE = "XXXXX";

	@Autowired
	private AplicacionesDelegateImpl fwktd_csv_ws_aplicacionesDelegateImpl;

	public AplicacionesDelegate getAplicacionesDelegate() {
		return fwktd_csv_ws_aplicacionesDelegateImpl;
	}

	@Test
	public void testDelegate() {
		Assert.assertNotNull("El delegate es nulo", getAplicacionesDelegate());
	}

	@Test
	public void testGetAplicaciones() {

		List<AplicacionCSV> aplicaciones = getAplicacionesDelegate().getAplicaciones();
		Assert.assertNotNull("No se han obtenido las aplicaciones", aplicaciones);
		Assert.assertFalse(aplicaciones.isEmpty());
	}

	@Test
	public void testGetAplicacion() {

		AplicacionCSV aplicacion = getAplicacionesDelegate().getAplicacion(ID_APLICACION_EXISTENTE);
		Assert.assertNotNull("No se ha encontrado la aplicacion", aplicacion);
		Assert.assertEquals(ID_APLICACION_EXISTENTE, aplicacion.getId());
		Assert.assertEquals(CODIGO_APLICACION_EXISTENTE, aplicacion.getCodigo());
		Assert.assertEquals("Aplicaci�n 1", aplicacion.getNombre());
		Assert.assertEquals("<?xml version='1.0' encoding='UTF-8'?><connection-config><connector>MOCK</connector></connection-config>", aplicacion.getInfoConexion());
	}

	@Test
	public void testGetAplicacion_IdNulo() {

		try {
			getAplicacionesDelegate().getAplicacion(null);
			Assert.fail("Deber�a producirse una IllegalArgumentException");

		} catch (IllegalArgumentException e) {
			Assert.assertEquals("'id' must not be empty", e.getMessage());
		}
	}

	@Test
	public void testGetAplicacion_IdNoExistente() {

		AplicacionCSV aplicacion = getAplicacionesDelegate().getAplicacion(ID_APLICACION_NO_EXISTENTE);
		Assert.assertNull("No se deber�a haber encontrado la aplicaci�n", aplicacion);
	}

	@Test
	public void testGetAplicacionByCodigo() {

		AplicacionCSV aplicacion = getAplicacionesDelegate().getAplicacionByCodigo(CODIGO_APLICACION_EXISTENTE);
		Assert.assertNotNull("No se ha encontrado la aplicacion", aplicacion);
		Assert.assertEquals(ID_APLICACION_EXISTENTE, aplicacion.getId());
		Assert.assertEquals(CODIGO_APLICACION_EXISTENTE, aplicacion.getCodigo());
		Assert.assertEquals("Aplicaci�n 1", aplicacion.getNombre());
		Assert.assertEquals("<?xml version='1.0' encoding='UTF-8'?><connection-config><connector>MOCK</connector></connection-config>", aplicacion.getInfoConexion());
	}

	@Test
	public void testGetAplicacionByCodigo_CodigoNulo() {

		try {
			getAplicacionesDelegate().getAplicacionByCodigo(null);
			Assert.fail("Deber�a producirse una IllegalArgumentException");

		} catch (IllegalArgumentException e) {
			Assert.assertEquals("'codigo' must not be empty", e.getMessage());
		}
	}

	@Test
	public void testGetAplicacionByCodigo_CodigoNoExistente() {

		AplicacionCSV aplicacion = getAplicacionesDelegate().getAplicacionByCodigo(CODIGO_APLICACION_NO_EXISTENTE);
		Assert.assertNull("No se deber�a haber encontrado la aplicaci�n", aplicacion);
	}

	@Test
	public void testSaveAplicacion() {

		AplicacionCSVForm aplicacionForm = new AplicacionCSVForm();
		aplicacionForm.setCodigo(CODIGO_APLICACION_NO_EXISTENTE);
		aplicacionForm.setNombre("Aplicaci�n nueva");
		aplicacionForm.setInfoConexion("<?xml version='1.0' encoding='UTF-8'?><connection-config><connector>MOCK</connector></connection-config>");

		AplicacionCSV aplicacionCreada = getAplicacionesDelegate().saveAplicacion(aplicacionForm);
		Assert.assertNotNull("No se ha creado la aplicaci�n", aplicacionCreada);
		Assert.assertNotNull("No se ha creado el ID de la aplicaci�n", aplicacionCreada.getId());
		Assert.assertEquals(aplicacionForm.getCodigo(), aplicacionCreada.getCodigo());
		Assert.assertEquals(aplicacionForm.getNombre(), aplicacionCreada.getNombre());
		Assert.assertEquals(aplicacionForm.getInfoConexion(), aplicacionCreada.getInfoConexion());
	}

	@Test
	public void testSaveAplicacion_FormVacio() {

		try {
			getAplicacionesDelegate().saveAplicacion(null);
			Assert.fail("Deber�a producirse una IllegalArgumentException");

		} catch (IllegalArgumentException e) {
			Assert.assertEquals("'aplicacion' must not be null", e.getMessage());
		}
	}

	@Test
	public void testSaveAplicacion_CodigoVacio() {

		AplicacionCSVForm aplicacionForm = new AplicacionCSVForm();
		aplicacionForm.setCodigo(null);
		aplicacionForm.setNombre("Aplicaci�n nueva");
		aplicacionForm.setInfoConexion("<?xml version='1.0' encoding='UTF-8'?><connection-config><connector>MOCK</connector></connection-config>");

		try {
			getAplicacionesDelegate().saveAplicacion(aplicacionForm);
			Assert.fail("Deber�a producirse una IllegalArgumentException");

		} catch (IllegalArgumentException e) {
			Assert.assertEquals("'aplicacion.codigo' must not be empty", e.getMessage());
		}
	}

	@Test
	public void testSaveAplicacion_NombreVacio() {

		AplicacionCSVForm aplicacionForm = new AplicacionCSVForm();
		aplicacionForm.setCodigo(CODIGO_APLICACION_NO_EXISTENTE);
		aplicacionForm.setNombre(null);
		aplicacionForm.setInfoConexion("<?xml version='1.0' encoding='UTF-8'?><connection-config><connector>MOCK</connector></connection-config>");

		try {
			getAplicacionesDelegate().saveAplicacion(aplicacionForm);
			Assert.fail("Deber�a producirse una IllegalArgumentException");

		} catch (IllegalArgumentException e) {
			Assert.assertEquals("'aplicacion.nombre' must not be empty", e.getMessage());
		}
	}

	@Test
	public void testSaveAplicacion_InfoConexionVacio() {

		AplicacionCSVForm aplicacionForm = new AplicacionCSVForm();
		aplicacionForm.setCodigo(CODIGO_APLICACION_NO_EXISTENTE);
		aplicacionForm.setNombre("Aplicaci�n nueva");
		aplicacionForm.setInfoConexion(null);

		try {
			getAplicacionesDelegate().saveAplicacion(aplicacionForm);
			Assert.fail("Deber�a producirse una IllegalArgumentException");

		} catch (IllegalArgumentException e) {
			Assert.assertEquals("'aplicacion.infoConexion' must not be empty", e.getMessage());
		}
	}

	@Test
	public void testUpdateAplicacion() {

		AplicacionCSV aplicacion = getAplicacionesDelegate().getAplicacion(ID_APLICACION_EXISTENTE);
		Assert.assertNotNull("No se ha encontrado la aplicaci�n", aplicacion);

		// Modificar la informaci�n de la aplicaci�n
		aplicacion.setNombre("Nombre modificado");

		// Guardar la informaci�n de la aplicaci�n
		AplicacionCSV aplicacionModificada = getAplicacionesDelegate().updateAplicacion(aplicacion);
		Assert.assertNotNull("No se ha modificado la aplicaci�n", aplicacionModificada);

		Assert.assertEquals(aplicacion.getId(), aplicacionModificada.getId());
		Assert.assertEquals(aplicacion.getCodigo(), aplicacionModificada.getCodigo());
		Assert.assertEquals(aplicacion.getNombre(), aplicacionModificada.getNombre());
		Assert.assertEquals(aplicacion.getInfoConexion(), aplicacionModificada.getInfoConexion());

		aplicacion = getAplicacionesDelegate().getAplicacion(ID_APLICACION_EXISTENTE);
		Assert.assertEquals(aplicacion.getId(), aplicacionModificada.getId());
		Assert.assertEquals(aplicacion.getCodigo(), aplicacionModificada.getCodigo());
		Assert.assertEquals(aplicacion.getNombre(), aplicacionModificada.getNombre());
		Assert.assertEquals(aplicacion.getInfoConexion(), aplicacionModificada.getInfoConexion());
	}

	@Test
	public void testUpdateAplicacion_InfoVacia() {

		try {
			getAplicacionesDelegate().updateAplicacion(null);
			Assert.fail("Deber�a producirse una IllegalArgumentException");

		} catch (IllegalArgumentException e) {
			Assert.assertEquals("'aplicacion' must not be null", e.getMessage());
		}
	}

	@Test
	public void testUpdateAplicacion_IdNoExistente() {

		try {

			AplicacionCSV aplicacion = new AplicacionCSV();
			aplicacion.setId(ID_APLICACION_NO_EXISTENTE);
			aplicacion.setCodigo(CODIGO_APLICACION_NO_EXISTENTE);
			aplicacion.setNombre("Aplicaci�n nueva");
			aplicacion.setInfoConexion("<?xml version='1.0' encoding='UTF-8'?><connection-config><connector>MOCK</connector></connection-config>");

			getAplicacionesDelegate().updateAplicacion(aplicacion);
			Assert.fail("Deber�a producirse una ServicioGestionCSVException");

		} catch (CSVException e) {
			Assert.assertEquals("error.csv.application.idNotFound", e.getMessageId());
		}
	}

	@Test
	public void testDeleteAplicacion() {

		getAplicacionesDelegate().deleteAplicacion(ID_APLICACION_BORRAR);
		Assert.assertNull("No se ha borrado la aplicacion", getAplicacionesDelegate().getAplicacion(ID_APLICACION_BORRAR));

		getAplicacionesDelegate().deleteAplicacion(ID_APLICACION_NO_EXISTENTE);
	}
}
